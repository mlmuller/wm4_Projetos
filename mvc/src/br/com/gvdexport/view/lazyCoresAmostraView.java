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

import br.com.gvdexport.lazy.LazyCoresAmostraModel;
import br.com.gvdexport.lazy.LazyDataService;
import br.com.gvdexport.model.Cor;
import lombok.Getter;
import lombok.Setter;


@Named("dtlazyCorAmostraView")
@ViewScoped
public class lazyCoresAmostraView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private LazyDataModel<Cor> lazyModel;
	@Getter @Setter
	private Cor corSelecionada;
	
	@Inject
	private LazyDataService service;
	
	@PostConstruct
	public void init() {
		lazyModel = new LazyCoresAmostraModel(service.getCor());
	}


	public void setService(LazyDataService service) {
		this.service = service;
	}
	
	public void onRowSelect(SelectEvent<Cor> event) {
	        FacesMessage msg = new FacesMessage("Cor Selecionada", String.valueOf(event.getObject().getCorid()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}
