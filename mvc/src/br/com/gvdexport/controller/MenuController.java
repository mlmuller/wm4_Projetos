package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.model.DGAMenu;
import br.com.gvdexport.model.DGASistema;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class MenuController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject	protected UsuarioController usuariocontroller;
	@Inject	private DGAFacadeCompKey dgaFacade;
	@Getter @Setter
	private List<DGAMenu> dgaMenus;
	@Getter @Setter
	private DGAMenu dgaMenu;
	@Getter @Setter
	private List<DGASistema> dgaSistemas;

	@Inject
	private CrudDao<DGAMenu, Long> menuDao;
	@Inject CrudDao<DGASistema, Long> sistemaDao;
	
	@PostConstruct
	public void init() {
		refresh();
	}
	
	public void add() {
		this.dgaMenu = new DGAMenu() ;
		dgaSistemas = sistemaDao.findAll();
	}

	public void edit(DGAMenu dgamenu) {
		this.dgaMenu = dgamenu;
	}

	public void save() {
		DGAMenu aux = dgaFacade.existedgaMenu(dgaMenu.getOrdem(),dgaMenu.getNome(),dgaMenu.getDgasistema().getDgasistemaid());
		FacesContext context = FacesContext.getCurrentInstance();
		if (aux != null) {
      		context.addMessage(null, new FacesMessage("Processo Existente,Verique!"));
    		return;
		}
		try {
			dgaMenu.setBarramenu((dgaMenu.getDgasistema().getNome()).trim()+"/"+(dgaMenu.getNome()).trim());
			dgaMenu.setDatastamp(dgaFacade.gettimeStamp());
			dgaMenu.setUsuariostamp(usuariocontroller.getNome());
			menuDao.update(dgaMenu);
			refresh();
			context.addMessage(null, new FacesMessage("Processo executado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel executar Processo!"));
			ex.printStackTrace();
		}
	}
	
	public void delete(DGAMenu dgaMenu) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			menuDao.delete(dgaMenu.getDgamenuid());
			refresh();
			context.addMessage(null, new FacesMessage("Menu Cancelado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel Cancelar Processo!"));
			ex.printStackTrace();
		}
	}

	private void refresh() {
		dgaMenus = menuDao.findAll();
		dgaSistemas = sistemaDao.findAll();
	}

}
