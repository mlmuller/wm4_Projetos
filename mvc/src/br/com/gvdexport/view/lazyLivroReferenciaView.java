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
import br.com.gvdexport.lazy.LazyLivroReferenciaDataModel;
import br.com.gvdexport.model.LivroReferencia;
import lombok.Getter;
import lombok.Setter;


@Named("dtlazyLivroReferenciaView")
@ViewScoped
public class lazyLivroReferenciaView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private LazyDataModel<LivroReferencia> lazyModel;
	@Getter @Setter
	private LivroReferencia livroReferenciaSelecionado;
	
	@Inject
	private LazyDataService service;
	
	@PostConstruct
	public void init() {
		lazyModel = new LazyLivroReferenciaDataModel(service.getlivroReferencia());
	}


	public void setService(LazyDataService service) {
		this.service = service;
	}
	
	public void onRowSelect(SelectEvent<LivroReferencia> event) {
	        FacesMessage msg = new FacesMessage("Referencia Selecionada", String.valueOf(event.getObject().getLivroreferenciaid()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}
