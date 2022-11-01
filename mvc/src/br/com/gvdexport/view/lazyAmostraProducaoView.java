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

import br.com.gvdexport.lazy.LazyDataService;
import br.com.gvdexport.lazy.LazyFichaProducaoDataModel;
import br.com.gvdexport.model.FichaProducao;
import lombok.Getter;
import lombok.Setter;


@Named("dtlazyAmostraProducaoView")
@ViewScoped
public class lazyAmostraProducaoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private LazyDataModel<FichaProducao> lazyModel;
	@Getter @Setter
	private FichaProducao amostraProducaoSelecionada;
	
	@Inject
	private LazyDataService service;
	
	@PostConstruct
	public void init() {
		lazyModel = new LazyFichaProducaoDataModel(service.getAmostraProducao());
	}


	public void setService(LazyDataService service) {
		this.service = service;
	}
	
	public void onRowSelect(SelectEvent<FichaProducao> event) {
	        FacesMessage msg = new FacesMessage("Amostra Producao Selecionada", String.valueOf(event.getObject().getFichaproducaoid()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}
