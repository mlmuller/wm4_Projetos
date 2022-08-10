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

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.model.DGASistema;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class SistemaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DGAFacadeCompKey dgaFacade;
	@Inject
	private CrudDao<DGASistema, Long> sistemaDao;
	@Getter @Setter
	private List<DGASistema> dgaSistemas;
	@Getter @Setter
	private DGASistema dgaSistema;
	
	@Inject
	private UsuarioController usuarioController;
	
	@PostConstruct
	public void init() {
		dgaSistemas = new ArrayList<DGASistema>();
		refresh();
	}
	
	public void add() {
		dgaSistema=new DGASistema();
	}
	
	public void edit(DGASistema dgasistema) {
		this.dgaSistema = dgasistema;
	}

	public void save() {
		DGASistema aux = dgaFacade.existedgaSistema(dgaSistema.getNome());
		FacesContext context = FacesContext.getCurrentInstance();
		if (aux != null) {
      		context.addMessage(null, new FacesMessage("Sistema Existente,Verique!"));
    		return;
		}
		try {
			dgaSistema.setDatastamp(dgaFacade.gettimeStamp());
			dgaSistema.setUsuariostamp(usuarioController.getNome());
			sistemaDao.update(dgaSistema);
			refresh();
			add();
			context.addMessage(null, new FacesMessage("Processo Adicionado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel adicionar Processo!"));
			ex.printStackTrace();
		}
	}
	
	public void delete(DGASistema dgaSistema) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			sistemaDao.delete(dgaSistema.getDgasistemaid());
			refresh();
			context.addMessage(null, new FacesMessage("Menu Cancelado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel Cancelar Processo!"));
			ex.printStackTrace();
		}
	}

	private void refresh() {
		dgaSistemas = sistemaDao.findAll();
	}

}
