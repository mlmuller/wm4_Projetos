package br.com.gvdexport.controller;

import java.io.Serializable;
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
import br.com.gvdexport.model.DGAMenu;
import br.com.gvdexport.model.DGAModulo;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ModuloController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Inject
	private DGAFacadeCompKey dgaFacade;
	@Inject
	private UsuarioController usuarioController;
	@Getter @Setter
	private DGAModulo dgaModulo;
	@Getter @Setter
	private List<DGAModulo> dgaModulos;
	@Getter @Setter
	private List<DGAMenu> dgaMenus;
	@Getter @Setter
	private List<SimNao> simNao = Arrays.asList(SimNao.values());
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Getter @Setter
	private Integer tipoOperacao;
	@Inject
	private CrudDao<DGAModulo, Long> moduloDao;
	@Inject 
	private CrudDao<DGAMenu, Long> menuDao;
	@PostConstruct
	public void init() {
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		this.dgaModulo = new DGAModulo() ;
		  dgaMenus = menuDao.findAll();
	}

	public void edit(DGAModulo dgamodulo) {
		this.dgaModulo = dgamodulo;
		tipoOperacao = 1;
	}
	
	
	public void save() {
		DGAModulo aux = dgaFacade.existeDGAModulo(dgaModulo.getOrdem(),dgaModulo.getNome(),dgaModulo.getDgamenu().getDgamenuid());
		if (tipoOperacao == 0) {
			if (aux != null) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modulo Existente,Verique!"));
	    		return;
			}
		}
		try {
			dgaModulo.setDatastamp(dgaFacade.gettimeStamp());
			dgaModulo.setUsuariostamp(usuarioController.getNome());
			moduloDao.update(dgaModulo);
			refresh();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modulo "+dgaModulo.getNome()+" salvo com Sucesso!"));
		} catch (RuntimeException ex) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel,executar Processo!"));
			ex.printStackTrace();
		}
	}
	public void delete(DGAModulo dgaModulo) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			moduloDao.delete(dgaModulo.getDgamoduloid());
			refresh();
			context.addMessage(null, new FacesMessage("Modulo Cancelado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel Cancelar modulo!"));
			ex.printStackTrace();
		}
	}

	private void refresh() {
		  dgaMenus = menuDao.findAll();
		dgaModulos = moduloDao.findAll();
	}

}

