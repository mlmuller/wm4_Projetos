package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.model.DGAMenu;
import br.com.gvdexport.model.DGAModulo;
import br.com.gvdexport.model.DGAPrivilegio;
import br.com.gvdexport.model.DGASistema;
import br.com.gvdexport.model.DGAUsuarioNivel;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class BasicoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private DGAPrivilegio dgaPrivilegio;
	@Getter @Setter
	private List<DGAPrivilegio> listaPrivilegio;
	@Getter @Setter
	private DGAModulo chaveModulo;
	@Getter @Setter
	private DGAUsuarioNivel dgaUsuarioNivel;
	@Getter @Setter
	private List<DGAUsuarioNivel> listaUsuarioNivel;
	@Getter @Setter
	private DGAMenu dgaMenu;
	@Getter @Setter
	private DGASistema dgaSistema;
	@Getter @Setter
	private DGAModulo dgaModuloa;
	@Getter @Setter
	private DGAModulo dgaModulob;
	@Getter @Setter
	private DGAModulo dgaModuloc;
	@Getter @Setter
	private DGAModulo dgaModulod;
	@Getter @Setter
	private DGAModulo dgaModuloe;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<DGASistema, Long> sistemaDao;
	@Inject
	private CrudDao<DGAMenu,Long> menuDao;
	@Inject
	private CrudDao<DGAModulo,Long> moduloDao;
	@Inject
	private DGAFacadeCompKey dgaFacade;
	@Inject
	private CrudDao<DGAPrivilegio, Long> privilegioDao;
	@Inject
	private CrudDao<DGAUsuarioNivel, Long> usuarioNivelDao;
	public void inicializarBasico() {
		FacesContext context = FacesContext.getCurrentInstance();
		dgaSistema=new DGASistema();
		dgaSistema.setDatastamp(dgaFacade.gettimeStamp());
		dgaSistema.setIconesistema("fa fa-fw fa-folder-open");
		dgaSistema.setNome("Cadastro");
		dgaSistema.setOrdem(1);
		dgaSistema.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
		Boolean permissaoTotal =true;
		try {
			DGASistema chaveSistema=sistemaDao.update(dgaSistema);
			dgaMenu = new DGAMenu();
			dgaMenu.setDatastamp(dgaFacade.gettimeStamp());
			dgaMenu.setDgasistema(chaveSistema);
			dgaMenu.setNome("Acesso");
			dgaMenu.setOrdem(1);
			dgaMenu.setStylemenu("font-size:12px");
			dgaMenu.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			dgaMenu.setBarramenu((dgaMenu.getNome()).trim()+"/"+(chaveSistema.getNome()).trim());
			DGAMenu chaveMenu = menuDao.update(dgaMenu);
			//
			listaUsuarioNivel= new ArrayList<>();
			listaPrivilegio = new ArrayList<>();
			chaveModulo=new DGAModulo();
			dgaModuloa =new DGAModulo();
			dgaModuloa.setClasse("usuario.class");
			dgaModuloa.setDatastamp(dgaFacade.gettimeStamp());
			dgaModuloa.setDgamenu(chaveMenu);
			dgaModuloa.setMonousuario(SimNao.valueOf("S"));
			dgaModuloa.setNome("Usu�rio");
			dgaModuloa.setOrdem(5);
			dgaModuloa.setSituacao(Situacao.A);
			dgaModuloa.setUrl("usuarios.jsf");
			dgaModuloa.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			chaveModulo=moduloDao.update(dgaModuloa);
			//
			dgaPrivilegio = new DGAPrivilegio();
			dgaPrivilegio.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaPrivilegio.setCaminho(chaveModulo.getUrl());
			dgaPrivilegio.setDatastamp(dgaFacade.gettimeStamp());
			dgaPrivilegio.setDgamenu(chaveMenu);
			dgaPrivilegio.setDgamodulo(chaveModulo);
			dgaPrivilegio.setDgasistema(chaveSistema);
			dgaPrivilegio.setNomemenu(chaveMenu.getNome());
			dgaPrivilegio.setNomeModulo(chaveModulo.getNome());
			dgaPrivilegio.setOrdem(1);
			dgaPrivilegio.setDgausuarioid(usuarioLogado.getUsuariologado().getUsuarioid());
			dgaPrivilegio.setNomesistema(chaveSistema.getNome());
			dgaPrivilegio.setPrivdelete(permissaoTotal);
			dgaPrivilegio.setPrivinsert(permissaoTotal);
			dgaPrivilegio.setPrivselect(permissaoTotal);
			dgaPrivilegio.setPrivupdate(permissaoTotal);
			dgaPrivilegio.setUsuario(usuarioLogado.getUsuariologado());
			dgaPrivilegio.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			dgaPrivilegio.setPermissao(1);
			//
			dgaUsuarioNivel = new DGAUsuarioNivel();
			dgaUsuarioNivel.setDgamenu(chaveMenu);
			dgaUsuarioNivel.setDgamodulo(chaveModulo);
			dgaUsuarioNivel.setDgasistema(chaveSistema);
			dgaUsuarioNivel.setNivelbarra(chaveSistema.getNome());
			dgaUsuarioNivel.setIconesistema(chaveSistema.getIconesistema());
			dgaUsuarioNivel.setNivelgrupo(1);
			dgaUsuarioNivel.setNivelsubitem(chaveModulo.getNome());
			dgaUsuarioNivel.setNivelsubmenu(chaveMenu.getNome());
			dgaUsuarioNivel.setOrdembarra(1);
			dgaUsuarioNivel.setOrdemitem(1);
			dgaUsuarioNivel.setOrdemmenu(1);
			dgaUsuarioNivel.setPrivdelete(permissaoTotal);
			dgaUsuarioNivel.setPrivinsert(permissaoTotal);
			dgaUsuarioNivel.setPrivupdate(permissaoTotal);
			dgaUsuarioNivel.setPrivselect(permissaoTotal);
			dgaUsuarioNivel.setStylemenu("font-size:12px");
			dgaUsuarioNivel.setUrl(chaveModulo.getUrl());
			dgaUsuarioNivel.setUsuario(usuarioLogado.getUsuariologado());
			dgaUsuarioNivel.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaUsuarioNivel.setDgamodulo(chaveModulo);
			dgaUsuarioNivel.setDgausuarioid(usuarioLogado.getUsuariologado().getUsuarioid());
			//
			listaPrivilegio.add(dgaPrivilegio);
			listaUsuarioNivel.add(dgaUsuarioNivel);
			//
			chaveModulo=new DGAModulo();
			dgaModulob =new DGAModulo();
			dgaModulob.setClasse("dgaSistema.class");
			dgaModulob.setDatastamp(dgaFacade.gettimeStamp());
			dgaModulob.setDgamenu(chaveMenu);
			dgaModulob.setMonousuario(SimNao.valueOf("S"));
			dgaModulob.setNome("Sistema");
			dgaModulob.setOrdem(4);
			dgaModulob.setSituacao(Situacao.A);
			dgaModulob.setUrl("dgaSistema.jsf");
			dgaModulob.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			chaveModulo=moduloDao.update(dgaModulob);
			dgaPrivilegio = new DGAPrivilegio();
			dgaPrivilegio.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaPrivilegio.setCaminho(chaveModulo.getUrl());
			dgaPrivilegio.setDatastamp(dgaFacade.gettimeStamp());
			dgaPrivilegio.setDgamenu(chaveMenu);
			dgaPrivilegio.setDgamodulo(chaveModulo);
			dgaPrivilegio.setDgasistema(chaveSistema);
			dgaUsuarioNivel.setIconesistema(chaveSistema.getIconesistema());
			dgaPrivilegio.setNomemenu(chaveMenu.getNome());
			dgaPrivilegio.setNomeModulo(chaveModulo.getNome());
			dgaPrivilegio.setOrdem(1);
			dgaPrivilegio.setDgausuarioid(usuarioLogado.getUsuariologado().getUsuarioid());
			dgaPrivilegio.setNomesistema(chaveSistema.getNome());
			dgaPrivilegio.setPrivdelete(permissaoTotal);
			dgaPrivilegio.setPrivinsert(permissaoTotal);
			dgaPrivilegio.setPrivselect(permissaoTotal);
			dgaPrivilegio.setPrivupdate(permissaoTotal);
			dgaPrivilegio.setUsuario(usuarioLogado.getUsuariologado());
			dgaPrivilegio.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			dgaPrivilegio.setPermissao(1);
			//
			dgaUsuarioNivel = new DGAUsuarioNivel();
			dgaUsuarioNivel.setDgamenu(chaveMenu);
			dgaUsuarioNivel.setDgamodulo(chaveModulo);
			dgaUsuarioNivel.setDgasistema(chaveSistema);
			dgaUsuarioNivel.setNivelbarra(chaveSistema.getNome());
			dgaUsuarioNivel.setIconesistema(chaveSistema.getIconesistema());
			dgaUsuarioNivel.setNivelgrupo(1);
			dgaUsuarioNivel.setNivelsubitem(chaveModulo.getNome());
			dgaUsuarioNivel.setNivelsubmenu(chaveMenu.getNome());
			dgaUsuarioNivel.setOrdembarra(1);
			dgaUsuarioNivel.setOrdemitem(1);
			dgaUsuarioNivel.setOrdemmenu(1);
			dgaUsuarioNivel.setPrivdelete(permissaoTotal);
			dgaUsuarioNivel.setPrivinsert(permissaoTotal);
			dgaUsuarioNivel.setPrivupdate(permissaoTotal);
			dgaUsuarioNivel.setPrivselect(permissaoTotal);
			dgaUsuarioNivel.setStylemenu("font-size:12px");
			dgaUsuarioNivel.setUrl(chaveModulo.getUrl());
			dgaUsuarioNivel.setUsuario(usuarioLogado.getUsuariologado());
			dgaUsuarioNivel.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaUsuarioNivel.setDgamodulo(chaveModulo);
			dgaUsuarioNivel.setDgausuarioid(usuarioLogado.getUsuariologado().getUsuarioid());
			//
			listaPrivilegio.add(dgaPrivilegio);
			listaUsuarioNivel.add(dgaUsuarioNivel);
			//
			chaveModulo=new DGAModulo();
			dgaModuloc =new DGAModulo();
			dgaModuloc.setClasse("menu.class");
			dgaModuloc.setDatastamp(dgaFacade.gettimeStamp());
			dgaModuloc.setDgamenu(chaveMenu);
			dgaModuloc.setMonousuario(SimNao.valueOf("S"));
			dgaModuloc.setNome("Menu");
			dgaModuloc.setOrdem(1);
			dgaModuloc.setSituacao(Situacao.A);
			dgaModuloc.setUrl("dgaMenu.jsf");
			dgaModuloc.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			chaveModulo=moduloDao.update(dgaModuloc);
			dgaPrivilegio = new DGAPrivilegio();
			dgaPrivilegio.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaPrivilegio.setCaminho(chaveModulo.getUrl());
			dgaPrivilegio.setDatastamp(dgaFacade.gettimeStamp());
			dgaPrivilegio.setDgamenu(chaveMenu);
			dgaPrivilegio.setDgamodulo(chaveModulo);
			dgaPrivilegio.setDgasistema(chaveSistema);
			dgaPrivilegio.setNomemenu(chaveMenu.getNome());
			dgaPrivilegio.setNomeModulo(chaveModulo.getNome());
			dgaPrivilegio.setOrdem(1);
			dgaPrivilegio.setDgausuarioid(usuarioLogado.getUsuariologado().getUsuarioid());
			dgaPrivilegio.setNomesistema(chaveSistema.getNome());
			dgaPrivilegio.setPrivdelete(permissaoTotal);
			dgaPrivilegio.setPrivinsert(permissaoTotal);
			dgaPrivilegio.setPrivselect(permissaoTotal);
			dgaPrivilegio.setPrivupdate(permissaoTotal);
			dgaPrivilegio.setUsuario(usuarioLogado.getUsuariologado());
			dgaPrivilegio.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			dgaPrivilegio.setPermissao(1);
			//
			dgaUsuarioNivel = new DGAUsuarioNivel();
			dgaUsuarioNivel.setDgamenu(chaveMenu);
			dgaUsuarioNivel.setDgamodulo(chaveModulo);
			dgaUsuarioNivel.setDgasistema(chaveSistema);
			dgaUsuarioNivel.setNivelbarra(chaveSistema.getNome());
			dgaUsuarioNivel.setIconesistema(chaveSistema.getIconesistema());
			dgaUsuarioNivel.setNivelgrupo(1);
			dgaUsuarioNivel.setNivelsubitem(chaveModulo.getNome());
			dgaUsuarioNivel.setNivelsubmenu(chaveMenu.getNome());
			dgaUsuarioNivel.setOrdembarra(1);
			dgaUsuarioNivel.setOrdemitem(1);
			dgaUsuarioNivel.setOrdemmenu(1);
			dgaUsuarioNivel.setPrivdelete(permissaoTotal);
			dgaUsuarioNivel.setPrivinsert(permissaoTotal);
			dgaUsuarioNivel.setPrivupdate(permissaoTotal);
			dgaUsuarioNivel.setPrivselect(permissaoTotal);
			dgaUsuarioNivel.setStylemenu("font-size:12px");
			dgaUsuarioNivel.setUrl(chaveModulo.getUrl());
			dgaUsuarioNivel.setUsuario(usuarioLogado.getUsuariologado());
			dgaUsuarioNivel.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaUsuarioNivel.setDgamodulo(chaveModulo);
			dgaUsuarioNivel.setDgausuarioid(usuarioLogado.getUsuariologado().getUsuarioid());
			//
			listaPrivilegio.add(dgaPrivilegio);
			listaUsuarioNivel.add(dgaUsuarioNivel);
			//
			chaveModulo=new DGAModulo();
			dgaModulod =new DGAModulo();
			dgaModulod.setClasse("modulo.class");
			dgaModulod.setDatastamp(dgaFacade.gettimeStamp());
			dgaModulod.setDgamenu(chaveMenu);
			dgaModulod.setMonousuario(SimNao.valueOf("S"));
			dgaModulod.setNome("Módulo");
			dgaModulod.setOrdem(2);
			dgaModulod.setSituacao(Situacao.A);
			dgaModulod.setUrl("dgaModulo.jsf");
			dgaModulod.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			chaveModulo=moduloDao.update(dgaModulod);
			dgaPrivilegio = new DGAPrivilegio();
			dgaPrivilegio.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaPrivilegio.setCaminho(chaveModulo.getUrl());
			dgaPrivilegio.setDatastamp(dgaFacade.gettimeStamp());
			dgaPrivilegio.setDgamenu(chaveMenu);
			dgaPrivilegio.setDgamodulo(chaveModulo);
			dgaPrivilegio.setDgasistema(chaveSistema);
			dgaPrivilegio.setNomemenu(chaveMenu.getNome());
			dgaPrivilegio.setNomeModulo(chaveModulo.getNome());
			dgaPrivilegio.setOrdem(1);
			dgaPrivilegio.setDgausuarioid(usuarioLogado.getUsuariologado().getUsuarioid());
			dgaPrivilegio.setNomesistema(chaveSistema.getNome());
			dgaPrivilegio.setPrivdelete(permissaoTotal);
			dgaPrivilegio.setPrivinsert(permissaoTotal);
			dgaPrivilegio.setPrivselect(permissaoTotal);
			dgaPrivilegio.setPrivupdate(permissaoTotal);
			dgaPrivilegio.setUsuario(usuarioLogado.getUsuariologado());
			dgaPrivilegio.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			dgaPrivilegio.setPermissao(1);
			//
			dgaUsuarioNivel = new DGAUsuarioNivel();
			dgaUsuarioNivel.setDgamenu(chaveMenu);
			dgaUsuarioNivel.setDgamodulo(chaveModulo);
			dgaUsuarioNivel.setDgasistema(chaveSistema);
			dgaUsuarioNivel.setIconesistema(chaveSistema.getIconesistema());
			dgaUsuarioNivel.setNivelbarra(chaveSistema.getNome());
			dgaUsuarioNivel.setNivelgrupo(1);
			dgaUsuarioNivel.setNivelsubitem(chaveModulo.getNome());
			dgaUsuarioNivel.setNivelsubmenu(chaveMenu.getNome());
			dgaUsuarioNivel.setOrdembarra(1);
			dgaUsuarioNivel.setOrdemitem(1);
			dgaUsuarioNivel.setOrdemmenu(1);
			dgaUsuarioNivel.setPrivdelete(permissaoTotal);
			dgaUsuarioNivel.setPrivinsert(permissaoTotal);
			dgaUsuarioNivel.setPrivupdate(permissaoTotal);
			dgaUsuarioNivel.setPrivselect(permissaoTotal);
			dgaUsuarioNivel.setStylemenu("font-size:12px");
			dgaUsuarioNivel.setUrl(chaveModulo.getUrl());
			dgaUsuarioNivel.setUsuario(usuarioLogado.getUsuariologado());
			dgaUsuarioNivel.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaUsuarioNivel.setDgamodulo(chaveModulo);
			dgaUsuarioNivel.setDgausuarioid(usuarioLogado.getUsuariologado().getUsuarioid());
			//
			listaPrivilegio.add(dgaPrivilegio);
			listaUsuarioNivel.add(dgaUsuarioNivel);
			//
			chaveModulo=new DGAModulo();
			dgaModuloe =new DGAModulo();
			dgaModuloe.setClasse("privilegio.class");
			dgaModuloe.setDatastamp(dgaFacade.gettimeStamp());
			dgaModuloe.setDgamenu(chaveMenu);
			dgaModuloe.setMonousuario(SimNao.valueOf("S"));
			dgaModuloe.setNome("Privil�gio");
			dgaModuloe.setOrdem(3);
			dgaModuloe.setSituacao(Situacao.A);
			dgaModuloe.setUrl("dgaPrivilegio.jsf");
			dgaModuloe.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			chaveModulo=moduloDao.update(dgaModuloe);
			dgaPrivilegio = new DGAPrivilegio();
			dgaPrivilegio.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaPrivilegio.setCaminho(chaveModulo.getUrl());
			dgaPrivilegio.setDatastamp(dgaFacade.gettimeStamp());
			dgaPrivilegio.setDgamenu(chaveMenu);
			dgaPrivilegio.setDgamodulo(chaveModulo);
			dgaPrivilegio.setDgasistema(chaveSistema);
			dgaPrivilegio.setNomemenu(chaveMenu.getNome());
			dgaPrivilegio.setNomeModulo(chaveModulo.getNome());
			dgaPrivilegio.setOrdem(1);
			dgaPrivilegio.setDgausuarioid(usuarioLogado.getUsuariologado().getUsuarioid());
			dgaPrivilegio.setNomesistema(chaveSistema.getNome());
			dgaPrivilegio.setPrivdelete(permissaoTotal);
			dgaPrivilegio.setPrivinsert(permissaoTotal);
			dgaPrivilegio.setPrivselect(permissaoTotal);
			dgaPrivilegio.setPrivupdate(permissaoTotal);
			dgaPrivilegio.setUsuario(usuarioLogado.getUsuariologado());
			dgaPrivilegio.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			dgaPrivilegio.setPermissao(1);
			//
			dgaUsuarioNivel = new DGAUsuarioNivel();
			dgaUsuarioNivel.setDgamenu(chaveMenu);
			dgaUsuarioNivel.setDgamodulo(chaveModulo);
			dgaUsuarioNivel.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaUsuarioNivel.setDgasistema(chaveSistema);
			dgaUsuarioNivel.setNivelbarra(chaveSistema.getNome());
			dgaUsuarioNivel.setIconesistema(chaveSistema.getIconesistema());
			dgaUsuarioNivel.setNivelgrupo(1);
			dgaUsuarioNivel.setNivelsubitem(chaveModulo.getNome());
			dgaUsuarioNivel.setNivelsubmenu(chaveMenu.getNome());
			dgaUsuarioNivel.setOrdembarra(1);
			dgaUsuarioNivel.setOrdemitem(1);
			dgaUsuarioNivel.setOrdemmenu(1);
			dgaUsuarioNivel.setPrivdelete(permissaoTotal);
			dgaUsuarioNivel.setPrivinsert(permissaoTotal);
			dgaUsuarioNivel.setPrivupdate(permissaoTotal);
			dgaUsuarioNivel.setPrivselect(permissaoTotal);
			dgaUsuarioNivel.setStylemenu("font-size:12px");
			dgaUsuarioNivel.setUrl(chaveModulo.getUrl());
			dgaUsuarioNivel.setUsuario(usuarioLogado.getUsuariologado());
			dgaUsuarioNivel.setDgamoduloid(chaveModulo.getDgamoduloid());
			dgaUsuarioNivel.setDgamodulo(chaveModulo);
			dgaUsuarioNivel.setDgausuarioid(usuarioLogado.getUsuariologado().getUsuarioid());
			//
			listaPrivilegio.add(dgaPrivilegio);
			listaUsuarioNivel.add(dgaUsuarioNivel);
			//
			try {
				dgaUsuarioNivel = new DGAUsuarioNivel();
				for (int i = 0; i < listaUsuarioNivel.size(); i++) {
					dgaUsuarioNivel=listaUsuarioNivel.get(i);
					usuarioNivelDao.update(dgaUsuarioNivel);
					dgaUsuarioNivel = new DGAUsuarioNivel();
				}
			} catch (RuntimeException ex) {
				context.addMessage(null, new FacesMessage("Não foi possivel adicionar Niveis Usuario !"));
				ex.printStackTrace();
			}
			try {
				for (DGAPrivilegio dgaPrivilegio : listaPrivilegio) {
					privilegioDao.update(dgaPrivilegio);
				}
			} catch (RuntimeException ex) {
				context.addMessage(null, new FacesMessage("Não foi possivel adicionar Privilegios !"));
				ex.printStackTrace();
			}
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel adicionar Combinações Básicas !"));
			ex.printStackTrace();
		}
	}

}
