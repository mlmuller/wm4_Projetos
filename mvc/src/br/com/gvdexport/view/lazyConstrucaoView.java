package br.com.gvdexport.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import br.com.gvdexport.lazy.LazyConstrucaoDataModel;
import br.com.gvdexport.lazy.LazyDataService;
import br.com.gvdexport.model.Construcao;
import lombok.Getter;
import lombok.Setter;


@Named("dtlazyConstrucaoView")
@ViewScoped
public class lazyConstrucaoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private LazyDataModel<Construcao> lazyModel;
	@Getter @Setter
	private Construcao construcaoSelecionada;
	
	@Inject
	private LazyDataService service;
	
	@PostConstruct
	public void init() {
		lazyModel = new LazyConstrucaoDataModel(service.getConstrucao());
	}


	public void setService(LazyDataService service) {
		this.service = service;
	}
	
	public void onRowSelect(SelectEvent<Construcao> event) {
	        FacesMessage msg = new FacesMessage("Construção Selecionada", String.valueOf(event.getObject().getConstrucaoid()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}
