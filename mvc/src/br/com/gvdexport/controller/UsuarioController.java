package br.com.gvdexport.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.model.menu.DefaultMenuColumn;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.model.DGAMenu;
import br.com.gvdexport.model.DGAPrivilegio;
import br.com.gvdexport.model.DGASistema;
import br.com.gvdexport.model.DGAUsuarioNivel;
import br.com.gvdexport.model.Grupo;
import br.com.gvdexport.model.Idioma;
import br.com.gvdexport.model.Mercado;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private DGAFacadeCompKey dgaFacade;
	@Getter @Setter
	private String Nome;
	@Getter @Setter
	private String Senha;
	@Getter @Setter
	private List<Idioma> listaIdiomas = Arrays.asList(Idioma.values());
	@Getter @Setter
	private String language="pt";
	@Getter @Setter
	private List<Grupo> listaGrupos = Arrays.asList(Grupo.values());
	@Getter @Setter
	private List<Mercado> listaMercados = Arrays.asList(Mercado.values());
	@Getter @Setter
	private List<Situacao> listaSituacao = Arrays.asList(Situacao.values());
	@Getter @Setter
	private List<SimNao> listaSimNao = Arrays.asList(SimNao.values());
	@Getter @Setter
	private List<Usuario> usuarios;
	@Getter @Setter
	private Usuario usuario;
	@Inject
	CrudDao<Usuario, Long> genericoDao;
	@Getter @Setter
	private Boolean editSaveOperacao=false;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private PrivilegioController privilegioController;
	/////
	@Getter @Setter
	private List<DGAPrivilegio> dgaPrivilegios;
	@Getter @Setter
	private List<DGAPrivilegio> dgaPrivSubMenus;
	@Getter @Setter
	private List<DGAPrivilegio> dgaPrivModulos;
	@Getter @Setter
	private List<DGAPrivilegio> tmpdgaPrivilegio;
	@Getter @Setter
	private List<DGAUsuarioNivel> tmpdgaPermissoes;
	@Getter @Setter
	private DGAUsuarioNivel permissaoNivel;
	@Getter @Setter
	private DGAUsuarioNivel tmpPermissao;
	@Getter @Setter
	private List<DGAUsuarioNivel> permissoesBarra;
	@Getter @Setter
	private List<DGAUsuarioNivel> permissoesMenuNivel;
	@Getter @Setter
	private List<DGAUsuarioNivel> permissoesNivel;
	@Getter @Setter
	private List<DGAUsuarioNivel> permissoesSubNivel;
	@Getter @Setter
	private DGAPrivilegio tmpPrivilegio;
	@Getter @Setter
	private ArrayList<String> barraMenus;
	@Getter @Setter
	private List<DGASistema> dgaSistemas;
	@Getter @Setter
	private List<DGAMenu> dgaMenus;
	private DefaultSubMenu rootMenu;
	private DefaultMenuModel modeloMenu;
	@Inject
	private BasicoController basicoController;
	//
	//Inicializa Lista de usuarios
	@PostConstruct
	public void init() {
		editSaveOperacao = false;
		refresh();
	}
	//Novo Registro
	public void add() {
		this.usuario = new Usuario();
	}
	
	public void edit(Usuario usuario) {
		this.usuario =  usuario;
		editSaveOperacao = true;
	}

	public void delete(Usuario usuario) {
		genericoDao.delete(usuario.getUsuarioid());
		refresh();
	}
    public void save() {
  //  	Usuario aux = genericoDao.find(usuario.getUsuarioid());
    	Usuario aux = dgaFacade.existeUsuario(usuario.getNome(), usuario.getSenha());
    	FacesContext context = FacesContext.getCurrentInstance();
    	if (aux != null) {
    		if(editSaveOperacao) {
    			context.addMessage(null, new FacesMessage("Altera??o para User Name/Password Existente,Verique!"));
    		return;}else {
       			context.addMessage(null, new FacesMessage("User Name/Password Existente,Verique!"));
       			return;
    		}
    	}
   		//Verificacao da Senha e encriptar
		try {
			usuario.setSenhaconversao(usuario.getSenha());
			usuario.setDatastamp(dgaFacade.gettimeStamp());
			SimpleHash passHash = new SimpleHash("md5",usuario.getSenha());
			usuario.setSenha(passHash.toHex());
			usuario.setUsuariostamp(Nome);
    		genericoDao.update(usuario);
    		refresh();
			context.addMessage(null, new FacesMessage("Usu?rio Cadastrado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("N?o foi poss?vel Cadastrar novo Usu?rio!"));
			ex.printStackTrace();
			return;
		} 
    }
	public void refresh() {
		usuarios = genericoDao.findAll();
		dgaPrivilegios = dgaFacade.getPrivilegios();
	}

	public void inicializaSessao() {
		add();
		FacesContext context = FacesContext.getCurrentInstance();
		Faces.redirect("template.jsf");
		context.addMessage(null, new FacesMessage("Bem Vindo usu?rio, "+usuarioLogado.getUsuariologado().getNome()));
	}

	public void finalizaSessao() {
		add();
		FacesContext context = FacesContext.getCurrentInstance();
		Faces.redirect("template.jsf");
		context.addMessage(null, new FacesMessage("At? mais..., "+usuarioLogado.getUsuariologado().getNome()));
	}

	public void validaUsuario() throws IOException {
    	FacesContext context = FacesContext.getCurrentInstance();
		if (!usuarios.isEmpty()) {
			SimpleHash passHash = new SimpleHash("md5",Senha);
			Senha = passHash.toHex();
			Usuario aux=dgaFacade.existeUsuario(Nome, Senha);
			Boolean ok;
			if(aux == null) {
				Messages.addGlobalError("Dados fornecidos n?o conferem,Verifique!");
			//	context.addMessage(null, new FacesMessage("Dados fornecidos n?o conferem,Verifique!"));
				return;
			}else {
				try {
					if(dgaPrivilegios.size() == 0) {
					   ok=true;
					   privilegioController.preparePrivilegio(aux, ok);	
					   dgaPrivilegios = new ArrayList<>();
					}
//					this.usuarioLogado.setUsuariologado(aux);
					usuarioLogado.setUsuariologado(aux);
					//initMenuFinal();
					Faces.redirect("template.jsf");
					context.addMessage(null, new FacesMessage("Bem Vindo usu?rio, "+usuarioLogado.getUsuariologado().getNome()));
				} catch (RuntimeException ex) {
					context.addMessage(null, new FacesMessage("N?o foi possivel ativar Menu de Entrada!"));
					ex.printStackTrace();
				}
			}
		}else {
			if(!Nome.equals("mauro") || (!Senha.equals("355193"))) {
				context.addMessage(null, new FacesMessage("Voc? n?o tem autoriza??o para inicializar o SISTEMA!"));
				Nome="";
				Senha="";
				return;
			}
			add();
			usuario.setNome("Mauro Muller");
			usuario.setEmail("ti@gvdintl.com.br");
			usuario.setGrupo(Grupo.M);
			usuario.setIdioma(Idioma.valueOf("pt"));
			usuario.setLiberafinanceiro(SimNao.valueOf("S"));
			usuario.setMercado(Mercado.Multimercado);
			SimpleHash passHash = new SimpleHash("md5",Senha);
			usuario.setSenha(passHash.toHex());
			usuario.setSituacao(Situacao.A);
			usuario.setUsuario("mauro");
			usuario.setUsuariostamp(usuario.getUsuario());
			usuario.setSenhaconversao(Senha);
			usuario.setDatastamp(dgaFacade.gettimeStamp());
			try {
				Usuario aux=genericoDao.update(usuario);
				usuarioLogado.setUsuariologado(aux);
				//
				basicoController.inicializarBasico();
				refresh();
				//
				initMenu();
				context.addMessage(null, new FacesMessage("Usu?rio Autorizado, Adicionado com Sucesso!"));
				Faces.redirect("template.jsf");
		    	
			} catch (RuntimeException ex) {
				context.addMessage(null, new FacesMessage("N?o foi possivel adicionar Usuario!"));
				ex.printStackTrace();
			}	
		}
	}
	//
	//Cria linha de opcoes principais (Barra de Menus)
    //
	public void initMenu() {
		dgaPrivilegios  = dgaFacade.getUsuarioPermissoes(usuarioLogado.getUsuariologado().getUsuarioid());
		dgaPrivSubMenus = dgaPrivilegios;
		dgaPrivModulos  = dgaPrivilegios;
		dgaSistemas     = dgaFacade.getSistemas();
		dgaMenus        = dgaFacade.getMenus();
		Integer cont = 0;
		Integer existeUm = 0;
		Long primeiraVez;
		primeiraVez = (long) 0;
		tmpdgaPrivilegio = new ArrayList<>();
		tmpPrivilegio = new DGAPrivilegio();
		modeloMenu = new DefaultMenuModel();
		for (int i = 0; i < dgaSistemas.size(); i++) {
			String vNome=dgaSistemas.get(i).getNome();
			DefaultSubMenu rootMenu = new DefaultSubMenu();
			rootMenu.setLabel(vNome);
			rootMenu.setIcon(dgaSistemas.get(i).getIconesistema().trim());
			rootMenu.setStyle("font-size:11px;");
			modeloMenu.getElements().add(rootMenu);
			List<DGAPrivilegio> resSistema=dgaPrivilegios.stream().filter(item-> item.getNomesistema().equals(vNome)).
					collect(Collectors.toList());
			if (resSistema.size() > 0){
				for (int j = 0; j < dgaMenus.size(); j++) {
					String vNomeMenu=dgaMenus.get(j).getNome();
					List<DGAPrivilegio> resMenu=dgaPrivilegios.stream().filter(itemb->itemb.getNomemenu().equals(vNomeMenu)).
							collect(Collectors.toList());
					if (resMenu.size() > 0) {
						primeiraVez = dgaMenus.get(j).getDgamenuid();
						if(dgaSistemas.get(i).getDgasistemaid().equals(dgaMenus.get(j).getDgasistema().getDgasistemaid())) {
							DGAMenu labelMenu = dgaMenus.get(j);
							// modulos
							for (int k = 0; k < resSistema.size(); k++) {
								if(resSistema.get(k).getDgamenu().getDgamenuid().equals(primeiraVez)) {
									tmpPrivilegio.setNomeModulo(resSistema.get(k).getNomeModulo());
									tmpPrivilegio.setCaminho(resSistema.get(k).getDgamodulo().getUrl());
									tmpPrivilegio.setDgasistema(resSistema.get(k).getDgasistema());
									tmpPrivilegio.setDgamenu(resSistema.get(k).getDgamenu());
									tmpPrivilegio.setGrpcomponente(resSistema.get(k).getGrpcomponente());
									tmpdgaPrivilegio.add(tmpPrivilegio);
									tmpPrivilegio=new DGAPrivilegio();
									existeUm = 1;
								}
							}
							if (existeUm != 0) {
								adicionaMenu(labelMenu,tmpdgaPrivilegio );
								tmpdgaPrivilegio = new ArrayList<>();
								existeUm = 0;
								cont++;
							}
							primeiraVez = (long) 0;
						}
					}	
				}
		   }
		}
		primeiraVez = (long) 0;
	}
	// Construcao novo formato do menu de usuario - resumindo com apenas as opcoes liberadas
	public void initMenuFinal() {
		permissoesNivel  = dgaFacade.getUsuarioPermissoesNivel(usuarioLogado.getUsuariologado().getUsuarioid());
		permissoesMenuNivel = new ArrayList<>();
		permissoesSubNivel  = new ArrayList<>();
		tmpdgaPermissoes = new ArrayList<>();
		tmpPermissao = new DGAUsuarioNivel();
		permissoesBarra = new ArrayList<>();

		dgaSistemas     = dgaFacade.getSistemas();
		String vNomeBarra="";
		permissaoNivel = new DGAUsuarioNivel();
		for (int i = 0; i < permissoesNivel.size(); i++) {
			if(!permissoesNivel.get(i).getNivelbarra().equals(vNomeBarra)) {
			   permissaoNivel=permissoesNivel.get(i);
			   vNomeBarra = permissoesNivel.get(i).getNivelbarra();
			   permissoesBarra.add(permissaoNivel);
			   permissaoNivel = new DGAUsuarioNivel();
			}
		}
		//
		Integer cont = 0;
		Integer existeUm = 0;
		tmpdgaPermissoes = new ArrayList<>();
		modeloMenu = new DefaultMenuModel();
		//Permissoes Barra todas as opces com icones
		for (int i = 0; i < permissoesBarra.size(); i++) {
			String vNomeBarraMenu=permissoesBarra.get(i).getNivelbarra();
			rootMenu = new DefaultSubMenu();
			rootMenu.setLabel(vNomeBarraMenu);
			rootMenu.setIcon(permissoesBarra.get(i).getIconesistema().trim());
			modeloMenu.getElements().add(rootMenu);
			List<DGAUsuarioNivel> resSistema=permissoesNivel.stream().filter(item-> item.getNivelbarra().equals(vNomeBarraMenu)).
					collect(Collectors.toList());
			//Mantem todos os SubMenus,barra mais escura 
			String nomeMenu="";
			tmpPermissao=new DGAUsuarioNivel();
			for (int j = 0; j < resSistema.size(); j++) {
				if(!resSistema.get(j).getNivelsubmenu().equals(nomeMenu.trim())) {
				  	tmpPermissao=resSistema.get(j);
				  	permissoesMenuNivel.add(tmpPermissao);
					nomeMenu=resSistema.get(j).getNivelsubmenu();
					tmpPermissao=new DGAUsuarioNivel();
				}
			}
				DGAUsuarioNivel labelMenu=new DGAUsuarioNivel();
			if (permissoesMenuNivel.size() > 0){
				for (int l = 0; l < permissoesMenuNivel.size(); l++) {
							labelMenu = permissoesMenuNivel.get(l);
							tmpPermissao = new DGAUsuarioNivel();
							for (int l2 = 0; l2 < permissoesNivel.size(); l2++) {
								if((permissoesNivel.get(l2).getDgasistema().getDgasistemaid().equals(permissoesBarra.get(i).getDgasistema().getDgasistemaid())) && 
								   (permissoesNivel.get(l2).getDgamenu().getDgamenuid().equals(permissoesMenuNivel.get(l).getDgamenu().getDgamenuid()))) {
									tmpPermissao=permissoesNivel.get(l2);
									tmpPermissao.setStylemenu("font-size:11px;");
									tmpdgaPermissoes.add(tmpPermissao);
									existeUm = 1;
								}
							}
							if (existeUm != 0) {
								adicionaMenuFinal(labelMenu,tmpdgaPermissoes );
								tmpdgaPermissoes = new ArrayList<>();
								existeUm = 0;
								cont++;
							}
				}
		   }

		//----fim do primeiro la?o
	}
	}
	
	public void adicionaMenu(DGAMenu label, List<DGAPrivilegio> itens) {
		DefaultMenuColumn coluna = new DefaultMenuColumn();
		//SubMenu
		DefaultSubMenu colunaMenu = new DefaultSubMenu();
		colunaMenu.setLabel(label.getNome());
		colunaMenu.setStyle(label.getStylemenu().trim());
		coluna.getElements().add(colunaMenu);
		for (DGAPrivilegio item:itens) {
			DefaultMenuItem mi = new DefaultMenuItem();
			mi.setValue(item.getNomeModulo());
			mi.setUrl(item.getCaminho().trim());
			if(!item.getGrpcomponente().equals(null)) {
				  String grupocomp = item.getGrpcomponente().trim();	
				  mi.setParam("meuP",grupocomp);
				}

			colunaMenu.getElements().add(mi);
		}
		rootMenu.getElements().add(coluna);
	}
	
	public void adicionaMenuFinal(DGAUsuarioNivel label, List<DGAUsuarioNivel> itens) {
	DefaultMenuColumn coluna = new DefaultMenuColumn();
	//SubMenu
	DefaultSubMenu colunaMenu = new DefaultSubMenu();
	colunaMenu.setLabel(label.getNivelsubmenu());
	colunaMenu.setStyle(label.getStylemenu());
	coluna.getElements().add(colunaMenu);
	for (DGAUsuarioNivel item:itens) {
		DefaultMenuItem mi = new DefaultMenuItem();
		mi.setValue(item.getNivelsubitem());
		mi.setUrl(item.getUrl().trim());
  	    //String grupocomp = item.getGrpcomponente();	
		colunaMenu.getElements().add(mi);
	}
	rootMenu.getElements().add(colunaMenu);
}
	public DefaultSubMenu getRootMenu() {
		return rootMenu;
	}
	public DefaultMenuModel getModeloMenu() {
		return modeloMenu;
	}
	public void setRootMenu(DefaultSubMenu rootMenu) {
		this.rootMenu = rootMenu;
	}
	public void setModeloMenu(DefaultMenuModel modeloMenu) {
		this.modeloMenu = modeloMenu;
	}
}
