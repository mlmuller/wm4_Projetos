package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.gvdexport.dao.PrazoPgtoDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.PrazoPagamento;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class PrazoPgtoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private PrazoPagamento prazoPagamento;
	
	@Getter @Setter
	private List<PrazoPagamento> listaPrazoPgto;
	
	private Integer tipoOperacao;
	
	@Getter @Setter
	private List<Situacao> ativoinativo = Arrays.asList(Situacao.values());

	@Inject
	private UsuarioLogadoController logadoController;
	
	@Inject
	private FacadeAcesso facadeAcesso;
	
	@Inject
	private DGAFacadeCompKey dgaFacade;
	
	@Inject
	private PrazoPgtoDao prazoPgtoDao;
	
	
	@PostConstruct
	public void init() {
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		this.prazoPagamento = new PrazoPagamento() ;
		prazoPagamento.setSituacao(Situacao.A);
		  listaPrazoPgto = prazoPgtoDao.findAll();
	}

	public void edit(PrazoPagamento prazopgto) {
		this.prazoPagamento = prazopgto;
		tipoOperacao = 1;
	}
	
	public void save() {
		List<PrazoPagamento> aux = facadeAcesso.existePrazoPgto(prazoPagamento.getDescricao());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
				Messages.addGlobalError("Este Prazo já tem Cadastro !");
	    		return;
			}
		}
		try {
			prazoPagamento.setDatastamp(dgaFacade.gettimeStamp());
			prazoPagamento.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			prazoPgtoDao.update(prazoPagamento);
			refresh();
			Messages.addGlobalInfo("Prazo adicionado com Sucesso !");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel executar tarefa !");
			ex.printStackTrace();
		}
	}
	public void delete(PrazoPagamento prazoPgto) {
		try {
			prazoPgtoDao.delete(prazoPgto.getPrazopagamentoid());
			refresh();
			Messages.addGlobalInfo("Prazo Pagamento Cancelado com sucesso !");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel cancelar Prazo de Pagamento !");
		}
	}

	private void refresh() {
		  listaPrazoPgto = prazoPgtoDao.findAll();
	}


}
