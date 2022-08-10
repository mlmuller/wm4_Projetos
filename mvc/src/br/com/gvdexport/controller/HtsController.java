package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gvdexport.dao.HtsDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Hts;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class HtsController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Hts hts;
	
	@Getter @Setter
	private List<Hts> listaHts;
	
	private Integer tipoOperacao;
	
	@Inject
	private UsuarioLogadoController logadoController;
	
	@Inject
	private FacadeAcesso facadeAcesso;
	
	@Inject
	private DGAFacadeCompKey dgaFacade;
	
	@Inject
	private HtsDao htsDao;
	
	
	@PostConstruct
	public void init() {
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		this.hts = new Hts() ;
		  listaHts = htsDao.findAll();
	}

	public void edit(Hts hts) {
		this.hts = hts;
		tipoOperacao = 1;
	}
	
	public void save() {
		List<Hts> aux = facadeAcesso.existeHTS(hts.getHts());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("HTS Existente,Verique!"));
	    		return;
			}
		}
		try {
			hts.setDatastamp(dgaFacade.gettimeStamp());
			hts.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			htsDao.update(hts);
			refresh();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("HTS salvo com Sucesso!"));
		} catch (RuntimeException ex) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel,executar Processo!"));
			ex.printStackTrace();
		}
	}
	public void delete(Hts hts) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			htsDao.delete(hts.getHtsid());
			refresh();
			context.addMessage(null, new FacesMessage("HTS Cancelado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel Cancelar NBM!"));
			ex.printStackTrace();
		}
	}

	private void refresh() {
		  listaHts = htsDao.findAll();
	}


}
