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

import br.com.gvdexport.lazy.LazyDataService;
import br.com.gvdexport.lazy.LazyMaterialDataModel;
import br.com.gvdexport.model.Material;
import br.com.gvdexport.model.Tipo;
import lombok.Getter;
import lombok.Setter;


@Named("dtlazyMaterialView")
@ViewScoped
public class lazyMaterialView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private LazyDataModel<Material> lazyModel;
	@Getter @Setter
	private Material materialSelecionado;
	@Getter @Setter
	private List<FilterMeta> filterBy;	
	@Getter @Setter
	private List<Tipo> tipos = Arrays.asList(Tipo.values());
	@Inject
	private LazyDataService service;
	
	@PostConstruct
	public void init() {
		lazyModel = new LazyMaterialDataModel(service.getMaterial());
	}
	
	public void setService(LazyDataService service) {
		this.service = service;
	}
	
	public void onRowSelect(SelectEvent<Material> event) {
	        FacesMessage msg = new FacesMessage("Material Selecionado", String.valueOf(event.getObject().getMaterialid()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}



	
}
