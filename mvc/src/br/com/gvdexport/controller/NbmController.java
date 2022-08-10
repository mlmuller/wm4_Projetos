package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gvdexport.dao.NbmDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Nbm;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class NbmController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Nbm nbm;
	
	@Getter @Setter
	private List<Nbm> listaNbms;
	
	private Integer tipoOperacao;
	
	@Inject
	private UsuarioLogadoController logadoController;
	
	@Inject
	private FacadeAcesso facadeAcesso;
	
	@Inject
	private DGAFacadeCompKey dgaFacade;
	
	@Inject
	private NbmDao nbmDao;
	
	
	@PostConstruct
	public void init() {
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		this.nbm = new Nbm() ;
		  listaNbms = nbmDao.findAll();
	}

	public void edit(Nbm nbm) {
		this.nbm = nbm;
		tipoOperacao = 1;
	}
	
	public void save() {
		List<Nbm> aux = facadeAcesso.existeNBM(nbm.getNbm());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NBM Existente,Verique!"));
	    		return;
			}
		}
		try {
			nbm.setDatastamp(dgaFacade.gettimeStamp());
			nbm.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			nbmDao.update(nbm);
			refresh();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NBM salvo com Sucesso!"));
		} catch (RuntimeException ex) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel,executar Processo!"));
			ex.printStackTrace();
		}
	}
	public void delete(Nbm nbm) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			nbmDao.delete(nbm.getNbmid());
			refresh();
			context.addMessage(null, new FacesMessage("NBM Cancelado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel Cancelar NBM!"));
			ex.printStackTrace();
		}
	}

	private void refresh() {
		  listaNbms = nbmDao.findAll();
	}


}
