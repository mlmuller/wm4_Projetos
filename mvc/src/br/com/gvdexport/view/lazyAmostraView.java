package br.com.gvdexport.view;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;

import br.com.gvdexport.lazy.LazyAmostraDataModel;
import br.com.gvdexport.lazy.LazyDataService;
import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.Tipo;
import lombok.Getter;
import lombok.Setter;


@Named("dtlazyAmostraView")
@ViewScoped
public class lazyAmostraView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private LazyDataModel<Amostra> lazyModel;
	@Getter @Setter
	private Amostra amostraSelecionada;
	@Getter @Setter
	private List<FilterMeta> filterBy;	
	@Getter @Setter
	private List<Tipo> tipos = Arrays.asList(Tipo.values());
	@Inject
	private LazyDataService service;
	
	@PostConstruct
	public void init() {
		lazyModel = new LazyAmostraDataModel(service.getAmostra());
	}
	
	public void setService(LazyDataService service) {
		this.service = service;
	}
	
	public void onRowSelect(SelectEvent<Amostra> event) {
	        FacesMessage msg = new FacesMessage("Amostra Selecionada", String.valueOf(event.getObject().getAmostraId()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}



	
}
