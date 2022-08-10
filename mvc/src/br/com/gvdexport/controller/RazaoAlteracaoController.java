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

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.RazaoAlteracao;
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.TipoRazao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class RazaoAlteracaoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private RazaoAlteracao razaoAlteracao;
	
	@Getter @Setter
	private List<RazaoAlteracao> listaRazaoAlteracoes;
	@Getter @Setter
	private List<TipoRazao> tipoRazao = Arrays.asList(TipoRazao.values());
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Inject
	private DGAFacadeCompKey dgaFacade;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController logadoController;
	@Inject
	private CrudDao<RazaoAlteracao,Long> razaoAlteracaoDao;
	
	private Integer tipoOperacao;
	@PostConstruct
	public void init() {
		listaRazaoAlteracoes = new ArrayList<>();
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		this.razaoAlteracao = new RazaoAlteracao() ;
		  listaRazaoAlteracoes = razaoAlteracaoDao.findAll();
	}

	public void edit(RazaoAlteracao razaoalteracao) {
		this.razaoAlteracao = razaoalteracao;
		tipoOperacao = 1;
	}
	
	public void save() {
		List<RazaoAlteracao> aux = facadeAcesso.existeRazaoAlteracao(razaoAlteracao.getDescricao());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
		        Messages.addGlobalInfo("Razão Alteração  Existente,Verique!");
	    		return;
			}
		}
		try {
			razaoAlteracao.setDatastamp(dgaFacade.gettimeStamp());
			razaoAlteracao.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			razaoAlteracaoDao.update(razaoAlteracao);
			refresh();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Razão Alteração salva com Sucesso!"));
		} catch (RuntimeException ex) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel,executar Processo!"));
			ex.printStackTrace();
		}
	}
	public void delete(RazaoAlteracao razaoalteracao) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			razaoAlteracaoDao.delete(razaoalteracao.getRazaoalteracaoid());
			refresh();
			context.addMessage(null, new FacesMessage("Razão Alteracao Cancelada com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel Cancelar Banco!"));
			ex.printStackTrace();
		}
	}

	private void refresh() {
		  listaRazaoAlteracoes =razaoAlteracaoDao.findAll();
	}


}
