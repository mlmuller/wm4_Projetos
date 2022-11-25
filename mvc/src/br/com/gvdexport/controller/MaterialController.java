package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.lazy.LazyDataService;
import br.com.gvdexport.lazy.LazyMaterialDataModel;
import br.com.gvdexport.model.Cor;
import br.com.gvdexport.model.Material;
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.Tipo;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class MaterialController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Material material;
	@Getter @Setter
	private Material materialClone;
	@Getter @Setter
	private List<Cor> listaMateriais;
	private Integer tipoOperacao;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	//Lazy
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
	//---------------------------------------------
	@Inject
	private CrudDao<Material, Long> materialDao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private DGAFacadeCompKey dgaFacade;
	@Inject
	private UsuarioLogadoController logadoController;
	
//	LazyMaterialDataModel dataModel = new LazyMaterialDataModel();
//	public LazyDataModel<Material> getModel(){
//		return dataModel;
//	}
	@PostConstruct
	public void init() {
		tipoOperacao = 0;
	}
	public void add() {
		this.material = new Material() ;
		material.setSituacao(Situacao.A);
	}
	//Lazy
	public void renovaLazy() {
		lazyModel = new LazyMaterialDataModel(service.getMaterial());

	}
	public void setService(LazyDataService service) {
		this.service = service;
	}
	
	public void onRowSelect(SelectEvent<Material> event) {
	        FacesMessage msg = new FacesMessage("Material Selecionado", String.valueOf(event.getObject().getMaterialid()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	//---------------------------------------------------------------------------------
	public void edit(Material material) throws CloneNotSupportedException {
		this.material = material;
		materialClone = new Material();
		materialClone = (Material) material.clone();
		tipoOperacao = 1;
	}
	
	public void save() {
		List<Material> aux = new ArrayList<>();
		if (tipoOperacao == 1 && ((!material.getNome().equals(materialClone.getNome())))) {
			tipoOperacao = 0;
		}
		if (tipoOperacao == 0) {
			aux = facadeAcesso.existeMaterial(material.getNome());
			if (aux.size() != 0) {
		        Messages.addGlobalWarn("Material Existente,Verique!");
	    		return;
			}
		}
		try {
			material.setDatastamp(dgaFacade.gettimeStamp());
			material.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			materialDao.update(material);
	        Messages.addGlobalInfo("Material salvo com Sucesso!");
		} catch (RuntimeException ex) {
	        Messages.addGlobalError("Não foi possivel,executar Processo!");
			ex.printStackTrace();
		}
	}
	public void delete(Material material ) {
		try {
			materialDao.delete(material.getMaterialid());
			Messages.addGlobalInfo("Material Cancelado com Sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Cancelar Material!");
			ex.printStackTrace();
		}
	}
}
