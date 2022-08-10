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
import br.com.gvdexport.model.Banco;
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.TipoBanco;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class BancoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Banco banco;
	
	@Getter @Setter
	private List<Banco> listaBancos;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Getter @Setter
	private List<TipoBanco> tipoBanco = Arrays.asList(TipoBanco.values());

	@Inject
	private DGAFacadeCompKey dgaFacade;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController logadoController;
	@Inject
	private CrudDao<Banco,Long> bancoDao;
	
	private Integer tipoOperacao;
	@PostConstruct
	public void init() {
		listaBancos = new ArrayList<>();
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		this.banco = new Banco() ;
		  listaBancos = bancoDao.findAll();
	}

	public void edit(Banco banco) {
		this.banco = banco;
		tipoOperacao = 1;
	}
	
	public void save() {
		List<Banco> aux = facadeAcesso.existeBanco(banco.getNome());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Banco Existente,Verique!"));
	    		return;
			}
		}
		try {
			banco.setDatastamp(dgaFacade.gettimeStamp());
			banco.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			bancoDao.update(banco);
			refresh();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Banco salvo com Sucesso!"));
		} catch (RuntimeException ex) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel,executar Processo!"));
			ex.printStackTrace();
		}
	}
	public void delete(Banco banco) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			bancoDao.delete(banco.getBancoid());
			refresh();
			context.addMessage(null, new FacesMessage("Banco Cancelado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel Cancelar Banco!"));
			ex.printStackTrace();
		}
	}

	private void refresh() {
		  listaBancos =bancoDao.findAll();
	}


}
