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
import br.com.gvdexport.lazy.LazyLivroImagemDataModel;
import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.ImagemReferencia;
import lombok.Getter;
import lombok.Setter;


@Named("dtlazyLivroImagemView")
@ViewScoped
public class lazyLivroImagemView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private LazyDataModel<ImagemReferencia> lazyModel;
	@Getter @Setter
	private Amostra amostraSelecionada;
	
	@Inject
	private LazyDataService service;
	
	@PostConstruct
	public void init() {
		lazyModel = new LazyLivroImagemDataModel(service.getImagemreferencia());
	}


	public void setService(LazyDataService service) {
		this.service = service;
	}
	
	public void onRowSelect(SelectEvent<Amostra> event) {
	        FacesMessage msg = new FacesMessage("Imagem Selecionada", String.valueOf(event.getObject().getAmostraId()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}
