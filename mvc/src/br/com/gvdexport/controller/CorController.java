package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Cor;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class CorController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Cor cor;
	@Getter @Setter
	private Cor corClone;
	@Getter @Setter
	private List<Cor> listaCores;
	private Integer tipoOperacao;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Inject
	private CrudDao<Cor, Long> corDao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private DGAFacadeCompKey dgaFacade;
	@Inject
	private UsuarioLogadoController logadoController;
	
//	LazyCorDataModel dataModel = new LazyCorDataModel();
//	public LazyDataModel<Cor> getModel(){
//		return dataModel;
//	}
	@PostConstruct
	public void init() {
		tipoOperacao = 0;
	}
	public void add() {
		this.cor = new Cor() ;
		cor.setSituacao(Situacao.A);
	}

	public void edit(Cor cor) throws CloneNotSupportedException {
		this.cor = cor;
		corClone = new Cor();
		corClone = (Cor) cor.clone();
		tipoOperacao = 1;
	}
	
	public void save() {
		List<Cor> aux = new ArrayList<>();
		if (tipoOperacao == 1 && ((!cor.getNome().equals(corClone.getNome())))) {
			tipoOperacao = 0;
		}
		if (tipoOperacao == 0) {
			aux = facadeAcesso.existeCor(cor.getNome());
			if (aux.size() != 0) {
		        Messages.addGlobalWarn("Cor Existente,Verique!");
	    		return;
			}
		}
		try {
			cor.setDatastamp(dgaFacade.gettimeStamp());
			cor.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			corDao.update(cor);
	        Messages.addGlobalInfo("Cor salva com Sucesso!");
		} catch (RuntimeException ex) {
	        Messages.addGlobalError("Não foi possivel,executar Processo!");
			ex.printStackTrace();
		}
	}
	public void delete(Cor cor) {
		try {
			corDao.delete(cor.getCorid());
			Messages.addGlobalInfo("Cor Cancelada com Sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Cancelar Cor!");
			ex.printStackTrace();
		}
	}
}
