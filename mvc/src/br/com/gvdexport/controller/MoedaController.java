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

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Moeda;
import br.com.gvdexport.model.SimNao;
import lombok.Getter;
import lombok.Setter;

@SessionScoped
@Named
public class MoedaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Moeda moeda;	
	@Getter @Setter
	private List<Moeda> listaMoedas;
	@Getter @Setter
	private List<SimNao> simnao = Arrays.asList(SimNao.values());

	@Inject
	private DGAFacadeCompKey dgaFacade;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController logadoController;
	@Inject
	private CrudDao<Moeda,Long> moedaDao;
	
	private Integer tipoOperacao;
	

	@PostConstruct
	public void init() {
		listaMoedas = new ArrayList<>();
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		this.moeda = new Moeda() ;
		  listaMoedas = moedaDao.findAll();
	}

	public void edit(Moeda moeda) {
		this.moeda = moeda;
		tipoOperacao = 1;
	}
	
	public void save() {
		List<Moeda> aux = facadeAcesso.existeMoeda(moeda.getSigla());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Moeda/Sigla Existente,Verique!"));
	    		return;
			}
		}
		try {
			moeda.setDatastamp(dgaFacade.gettimeStamp());
			moeda.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			moedaDao.update(moeda);
			refresh();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Moeda salvo com Sucesso!"));
		} catch (RuntimeException ex) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel,executar Processo!"));
			ex.printStackTrace();
		}
	}
	public void delete(Moeda moeda) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			moedaDao.delete(moeda.getMoedaid());
			refresh();
			context.addMessage(null, new FacesMessage("Moeda Cancelado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel Cancelar Moeda!"));
			ex.printStackTrace();
		}
	}

	private void refresh() {
		  listaMoedas = moedaDao.findAll();
	}

}
