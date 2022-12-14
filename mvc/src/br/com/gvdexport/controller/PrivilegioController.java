package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Produces;

import org.primefaces.PrimeFaces;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.model.DGAMenu;
import br.com.gvdexport.model.DGAModulo;
import br.com.gvdexport.model.DGAPrivilegio;
import br.com.gvdexport.model.DGASistema;
import br.com.gvdexport.model.DGAUsuarioNivel;
import br.com.gvdexport.model.Usuario;
import lombok.Getter;
import lombok.Setter;
@Produces
@Named
@SessionScoped
public class PrivilegioController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject 
	protected UsuarioController usuarioController;
	@Inject
	private DGAFacadeCompKey dgaFacade;
	@Getter @Setter
	private DGAPrivilegio dgaPrivilegio;
	@Getter @Setter
	private List<DGAPrivilegio> dgaPrivilegios;
	@Getter @Setter
	private List<DGAPrivilegio> TodosPrivilegios;
	@Getter @Setter
	private List<DGAPrivilegio> todosPrivilegiosUsuario;
	@Getter @Setter
	private List<DGAUsuarioNivel> usuariosPrivilegiosNivel;
	@Getter @Setter
	private List<DGAModulo> dgaModulos;
	@Getter @Setter
	private List<Usuario> usuarios;
	@Getter @Setter
	private Usuario usuario;
	@Getter @Setter
	private List<DGASistema> dgaSistemas;
	@Getter @Setter
	private List<DGAMenu> dgaMenus;
	@Getter @Setter
	private Boolean ok;
	@Getter @Setter
	private Integer tipoOperacao;
	
	//Tipo Operacao =  {0=inclusao},{alteracao=1},{delete=2}
	
	@Inject 
	private CrudDao<DGAPrivilegio, Long> privilegioDao;
	@Inject
	private CrudDao<DGAUsuarioNivel, Long> permissaoNivelDao; 
	
	@PostConstruct
	public void init() {
		dgaPrivilegios = new ArrayList<DGAPrivilegio>();
		refresh();
		add();
		tipoOperacao = 0;
	}
	
	public void add() {
		this.dgaPrivilegio = new DGAPrivilegio();
	}
	
	public void preparePrivilegio(Usuario usuario, Boolean permissao) {
		this.usuario = usuario;
		ok=false;
		TodosPrivilegios = new ArrayList<>();
		dgaPrivilegios = dgaFacade.getPrivilegios();
		todosPrivilegiosUsuario = new ArrayList<>();
		todosPrivilegiosUsuario = dgaFacade.getUsuarioPermissoes(usuario.getUsuarioid());
        permissao = false;
		if(todosPrivilegiosUsuario.size() != 0) {
	        FacesContext fc = FacesContext.getCurrentInstance();
	        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Permissoes j? estao Cadastradas...","");
	        FacesMessage fm2 = new FacesMessage(FacesMessage.SEVERITY_WARN,"Somente Editar Este Usu?rio...","");
	        fc.addMessage("", fm1);
	        fc.addMessage("", fm2);	
	        if(!eValidoCriarPermissao(permissao)) {
	        	return;
	        }
		}
		if(dgaPrivilegios.size() != 0) {
			permissao=true;
			if (!eValidoCriarPermissao(permissao)) {
				ok=false;
			}
		}else {
			permissao = true;
			ok=true;
	}
		Integer ordem = 1;
		//Primeiro dgasistema
		for (int i = 0; i < dgaSistemas.size(); i++) {
			//Segundo DGAMenus
			for (int j = 0; j < dgaMenus.size(); j++) {
				if(dgaSistemas.get(i).getDgasistemaid().equals(dgaMenus.get(j).getDgasistema().getDgasistemaid())) {
					//Terceiro DGAModulos
					for (int k = 0; k < dgaModulos.size(); k++) {
						if(dgaMenus.get(j).getDgamenuid().equals(dgaModulos.get(k).getDgamenu().getDgamenuid())) {
							dgaPrivilegio.setDatastamp(dgaFacade.gettimeStamp());
							dgaPrivilegio.setDgamoduloid(dgaModulos.get(k).getDgamoduloid());
							dgaPrivilegio.setDgamodulo(dgaModulos.get(k));
							dgaPrivilegio.setDgausuarioid(usuario.getUsuarioid());
							dgaPrivilegio.setPrivdelete(ok);
							dgaPrivilegio.setPrivinsert(ok);
							dgaPrivilegio.setPrivupdate(ok);
							dgaPrivilegio.setPrivselect(ok);
							dgaPrivilegio.setPrivwhere("");
							dgaPrivilegio.setDgamenu(dgaModulos.get(k).getDgamenu());
							dgaPrivilegio.setDgasistema(dgaModulos.get(k).getDgamenu().getDgasistema());
							dgaPrivilegio.setUsuariostamp(usuario.getUsuario());
							dgaPrivilegio.setDatastamp(dgaFacade.gettimeStamp());
							dgaPrivilegio.setUsuario(usuario);
							dgaPrivilegio.setOrdem(ordem);
							dgaPrivilegio.setNomemenu(dgaModulos.get(k).getDgamenu().getNome());
							dgaPrivilegio.setNomeModulo(dgaModulos.get(k).getNome());
							dgaPrivilegio.setNomesistema(dgaModulos.get(k).getDgamenu().getDgasistema().getNome());
							dgaPrivilegio.setPermissao(0);
							TodosPrivilegios.add(dgaPrivilegio);
							dgaPrivilegio=new DGAPrivilegio();
						}
					}
					ordem++;
				}
			}
		}
		//Sera executado somente, na primeira vez que o sistema for instalado com base no usuario,
		//Master definido,em linha fixa...
		if ((permissao) && dgaPrivilegios.size() == 0) {
			save();
			dgaPrivilegios =  new ArrayList<DGAPrivilegio>();
			dgaPrivilegios = dgaFacade.getPrivilegios();
		}
		//ultima etapa ordernar...vetor preenchido..
		dgaPrivilegio = new DGAPrivilegio();
	}
	public void prepareComplementacao(Usuario usuario,Boolean posicao) {
		tipoOperacao = 1;
		posicao = false;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			todosPrivilegiosUsuario = new ArrayList<>();
			todosPrivilegiosUsuario = dgaFacade.getUsuarioPermissoes(usuario.getUsuarioid());
		    dgaModulos = dgaFacade.getModulos();
			Integer primeiraVez;
			for (int i = 0; i < dgaModulos.size(); i++) {
				primeiraVez = 0;
				for (int j = 0; j < todosPrivilegiosUsuario.size(); j++) {
					if((dgaModulos.get(i).getDgamenu().getDgasistema().getDgasistemaid().equals(todosPrivilegiosUsuario.get(j).getDgasistema().getDgasistemaid()) &&
							(dgaModulos.get(i).getDgamoduloid().equals(todosPrivilegiosUsuario.get(j).getDgamoduloid()) && 
									(dgaModulos.get(i).getDgamenu().getDgamenuid().equals(todosPrivilegiosUsuario.get(j).getDgamenu().getDgamenuid()))))) {
						primeiraVez = 1;
						if (primeiraVez == 1){
							break;
						}
					}
					
				}
				//
				if (primeiraVez == 0) {
					dgaPrivilegio = new DGAPrivilegio();
					//nova opcao
					dgaPrivilegio.setDatastamp(dgaFacade.gettimeStamp());
					dgaPrivilegio.setDgamoduloid(dgaModulos.get(i).getDgamoduloid());
					dgaPrivilegio.setDgamodulo(dgaModulos.get(i));
					dgaPrivilegio.setDgausuarioid(usuario.getUsuarioid());
					dgaPrivilegio.setPrivdelete(posicao);
					dgaPrivilegio.setPrivinsert(posicao);
					dgaPrivilegio.setPrivupdate(posicao);
					dgaPrivilegio.setPrivselect(posicao);
					dgaPrivilegio.setPrivwhere(null);
					dgaPrivilegio.setDgamenu(dgaModulos.get(i).getDgamenu());
					dgaPrivilegio.setDgasistema(dgaModulos.get(i).getDgamenu().getDgasistema());
					dgaPrivilegio.setUsuariostamp(usuario.getUsuario());
					dgaPrivilegio.setDatastamp(dgaFacade.gettimeStamp());
					dgaPrivilegio.setUsuario(usuario);
					dgaPrivilegio.setOrdem(1);
					dgaPrivilegio.setNomemenu(dgaModulos.get(i).getDgamenu().getNome());
					dgaPrivilegio.setNomeModulo(dgaModulos.get(i).getNome());
					dgaPrivilegio.setNomesistema(dgaModulos.get(i).getDgamenu().getDgasistema().getNome());
					dgaPrivilegio.setCaminho(dgaModulos.get(i).getUrl());
					dgaPrivilegio.setPermissao(2); //alterado novamente de 1 para 2
					todosPrivilegiosUsuario.add(dgaPrivilegio);
				}
			}
		} catch (RuntimeException ex) {
			context.addMessage(null,new FacesMessage("N?o foi possivel informar Privilegios , do usuario :"+usuario.getUsuario()));
		}
	}
	public void visualizePermissoes(Usuario usuario) {
		
	}
	public void blocoPermissoes(Usuario usuario) {
		
	}
	public void edit(DGAPrivilegio dgaprivilegio) {
		this.dgaPrivilegio = dgaprivilegio;
	}
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//1 = Ja possui permissao
			//2 = Nova opcao c/permissao
			if (tipoOperacao == 0) {
			    DGAUsuarioNivel permissaoNivel = new DGAUsuarioNivel();
				for (DGAPrivilegio dgaPrivilegio:todosPrivilegiosUsuario){
					privilegioDao.update(dgaPrivilegio);
					if(dgaPrivilegio.getPrivdelete().equals(true) || dgaPrivilegio.getPrivinsert().equals(true) || 
							dgaPrivilegio.getPrivupdate().equals(true) || dgaPrivilegio.getPrivselect().equals(true)) {
							permissaoNivel.setDgamenu(dgaPrivilegio.getDgamenu());
							permissaoNivel.setOrdemmenu(dgaPrivilegio.getDgamenu().getOrdem());
							permissaoNivel.setDgamodulo(dgaPrivilegio.getDgamodulo());
							permissaoNivel.setOrdemitem(dgaPrivilegio.getDgamodulo().getOrdem());
							permissaoNivel.setDgasistema(dgaPrivilegio.getDgasistema());
							permissaoNivel.setOrdembarra(dgaPrivilegio.getDgasistema().getOrdem());
							permissaoNivel.setUrl(dgaPrivilegio.getDgamodulo().getUrl());
							permissaoNivel.setPrivdelete(dgaPrivilegio.getPrivdelete());
							permissaoNivel.setPrivinsert(dgaPrivilegio.getPrivinsert());
							permissaoNivel.setPrivupdate(dgaPrivilegio.getPrivupdate());
							permissaoNivel.setPrivselect(dgaPrivilegio.getPrivselect());
							permissaoNivel.setUsuario(dgaPrivilegio.getUsuario());
							permissaoNivel.setDgamodulo(dgaPrivilegio.getDgamodulo());
							permissaoNivel.setDgamoduloid(dgaPrivilegio.getDgamoduloid());
							permissaoNivel.setDgausuarioid(dgaPrivilegio.getUsuario().getUsuarioid());
							permissaoNivel.setNivelbarra(dgaPrivilegio.getNomesistema());
							permissaoNivel.setNivelsubmenu(dgaPrivilegio.getNomemenu());
							permissaoNivel.setNivelsubitem(dgaPrivilegio.getNomeModulo());
							permissaoNivel.setIconesistema(dgaPrivilegio.getDgasistema().getIconesistema());
							dgaPrivilegio.setPermissao(1);
							//=1,tem alguma permissao
							//Esta informacao sera customizada pelo usuario
							permissaoNivel.setStylemenu("font-size:12px;");
							//
							permissaoNivel.setUsuario(getUsuario());
							permissaoNivelDao.update(permissaoNivel);
							permissaoNivel=new DGAUsuarioNivel();
					}
			  }
			}else {
				if (tipoOperacao == 1) {
					//edicao , busca todos do usuario/checando novas/anteriores permissoes
					//chama rotina de ajuste das permissoes
					ajustaPermissoes(todosPrivilegiosUsuario);
					usuariosPrivilegiosNivel = new ArrayList<>();
					DGAUsuarioNivel permissaoNivel = new DGAUsuarioNivel();
					for (DGAPrivilegio dgaPrivilegio : todosPrivilegiosUsuario) {
						permissaoNivel.setDgamenu(dgaPrivilegio.getDgamenu());
						permissaoNivel.setOrdemmenu(dgaPrivilegio.getDgamenu().getOrdem());
						permissaoNivel.setDgamodulo(dgaPrivilegio.getDgamodulo());
						permissaoNivel.setOrdemitem(dgaPrivilegio.getDgamodulo().getOrdem());
						permissaoNivel.setDgasistema(dgaPrivilegio.getDgasistema());
						permissaoNivel.setOrdembarra(dgaPrivilegio.getDgasistema().getOrdem());
						permissaoNivel.setUrl(dgaPrivilegio.getDgamodulo().getUrl());
						permissaoNivel.setPrivdelete(dgaPrivilegio.getPrivdelete());
						permissaoNivel.setPrivinsert(dgaPrivilegio.getPrivinsert());
						permissaoNivel.setPrivupdate(dgaPrivilegio.getPrivupdate());
						permissaoNivel.setPrivselect(dgaPrivilegio.getPrivselect());
						permissaoNivel.setNivelbarra(dgaPrivilegio.getNomesistema());
						permissaoNivel.setNivelsubmenu(dgaPrivilegio.getNomemenu());
						permissaoNivel.setNivelsubitem(dgaPrivilegio.getNomeModulo());
						permissaoNivel.setNivelgrupo(1);
						permissaoNivel.setIconesistema(dgaPrivilegio.getDgasistema().getIconesistema());
						permissaoNivel.setUsuario(dgaPrivilegio.getUsuario());
						permissaoNivel.setDgamodulo(dgaPrivilegio.getDgamodulo());
						permissaoNivel.setDgamoduloid(dgaPrivilegio.getDgamoduloid());
						permissaoNivel.setDgausuarioid(dgaPrivilegio.getUsuario().getUsuarioid());
						//=1,tem alguma permissao
						//Esta informacao sera customizada pelo usuario
						permissaoNivel.setStylemenu("font-size:12px;");
						if(dgaPrivilegio.getPrivdelete().equals(false) && 
								dgaPrivilegio.getPrivinsert().equals(false) && 
								dgaPrivilegio.getPrivupdate().equals(false) && 
								dgaPrivilegio.getPrivselect().equals(false)) {
						  if (dgaPrivilegio.getPermissao() == 4) {
						   	  DGAUsuarioNivel aux=dgaFacade.buscarChaveCompPrivilegioUnica(dgaPrivilegio.getDgausuarioid(),dgaPrivilegio.getDgamoduloid());
							  if (aux != null) {
								  	permissaoNivelDao.delete(aux.getUsuarionivelid());
							  }
						  }
						  privilegioDao.update(dgaPrivilegio);
						}else {
							if (!dgaPrivilegio.getPermissao().equals(2)) {
							 dgaPrivilegio.setPermissao(1);	
							 privilegioDao.update(dgaPrivilegio);
						     //implementado em 09/08/2019
							 DGAUsuarioNivel aux =new DGAUsuarioNivel();
							 aux=dgaFacade.buscarChaveCompPrivilegioUnica(dgaPrivilegio.getDgausuarioid(),dgaPrivilegio.getDgamoduloid());
							  if (aux != null) {
									aux.setPrivdelete(dgaPrivilegio.getPrivdelete());
									aux.setPrivinsert(dgaPrivilegio.getPrivinsert());
									aux.setPrivupdate(dgaPrivilegio.getPrivupdate());
									aux.setPrivselect(dgaPrivilegio.getPrivselect());
								   permissaoNivelDao.update(aux);
							  }
							}else {
								dgaPrivilegio.setPermissao(1);
								privilegioDao.update(dgaPrivilegio);
								permissaoNivel.setPrivinsert(dgaPrivilegio.getPrivinsert());
								permissaoNivel.setPrivupdate(dgaPrivilegio.getPrivupdate());
								permissaoNivel.setPrivselect(dgaPrivilegio.getPrivselect());
								permissaoNivel.setPrivdelete(dgaPrivilegio.getPrivdelete());
								permissaoNivelDao.update(permissaoNivel);
							}
						   }
						permissaoNivel = new DGAUsuarioNivel();
						}
					}
				}
			refresh();
			add();
			context.addMessage(null, new FacesMessage("Operacao realizada com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("N?o foi possivel adicionar Privil?gios!"));
			ex.printStackTrace();
		}
	}
	//1-Incluido com permissao
	//2-Novo c/permissao
	//3-Novo s/permissao,atualizado no principal , e apos altera status para 4
	//4-existente no principal removido permissoes,nao existe no menu resumindo
	public void ajustaPermissoes(List<DGAPrivilegio> listaTodosPrivilegios) {
		for (int i = 0; i < listaTodosPrivilegios.size(); i++) {
			if ((listaTodosPrivilegios.get(i).getPrivdelete().equals(false)) && (listaTodosPrivilegios.get(i).getPrivinsert().equals(false)) 
					&& (listaTodosPrivilegios.get(i).getPrivselect().equals(false)) && (listaTodosPrivilegios.get(i).getPrivupdate().equals(false))) {

				if(listaTodosPrivilegios.get(i).getPermissao().equals(2)) {
					listaTodosPrivilegios.get(i).setPermissao(3);
				}
				if(listaTodosPrivilegios.get(i).getPermissao().equals(1)){
					listaTodosPrivilegios.get(i).setPermissao(4);
				}
				
			}else {
				if(listaTodosPrivilegios.get(i).getPermissao().equals(3)) {
					listaTodosPrivilegios.get(i).setPermissao(2);
				}
				if (listaTodosPrivilegios.get(i).getPermissao().equals(4)) {
					listaTodosPrivilegios.get(i).setPermissao(2);
				}
			}
		}
		
	}
	public void delete(DGAPrivilegio dgaPrivilegio) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
//			DGAPrivilegio aux = dgaFacade.buscarChaveCompPrivilegioUnica(dgaPrivilegio.getDgamoduloid(), dgaPrivilegio.getDgausuarioid());
			context.addMessage(null, new FacesMessage("M?dulo Cancelado com Sucesso!"));
			refresh();
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("N?o foi possivel Cancelar M?dulo!"));
			ex.printStackTrace();
		}
	}

	private void refresh() {
	dgaPrivilegios = dgaFacade.getPrivilegios();
		  usuarios = dgaFacade.getUsuarios();
	    dgaModulos = dgaFacade.getModulos();
	    dgaSistemas= dgaFacade.getSistemas();
	      dgaMenus = dgaFacade.getMenus();
	}

	public boolean eValidoCriarPermissao(Boolean validaCriacaoPermissao) {
	    if((!validaCriacaoPermissao)) {
	    	PrimeFaces.current().ajax().addCallbackParam("eValido", true);
	        return true;
	    }
    	PrimeFaces.current().ajax().addCallbackParam("eValido", false);
    	return false;
	}
}
