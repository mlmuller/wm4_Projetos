package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Estacao;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class EstacaoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Estacao estacao;
	@Getter @Setter
	private Estacao estacaoClone;
	@Getter @Setter
	private List<Estacao> listaEstacao;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController logadoController;
	@Inject
	private CrudDao<Estacao,Long> estacaoDao;
	
	private Integer tipoOperacao;
	@PostConstruct
	public void init() {
		listaEstacao = new ArrayList<>();
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		this.estacao = new Estacao() ;
		estacao.setSituacao(Situacao.A);
		  listaEstacao = estacaoDao.findAll();
	}

	public void edit(Estacao estacao) throws CloneNotSupportedException {
		this.estacao = estacao;
		tipoOperacao = 1;
		estacaoClone = new Estacao();
		estacaoClone = (Estacao) estacao.clone();
		
	}
	
	public void save() {
		Calendar caldate1 = Calendar.getInstance();
		Calendar caldate2 = Calendar.getInstance();
		if (tipoOperacao == 0) {
			List<Estacao> aux = facadeAcesso.existeEstacao(estacao.getNome());
			if (aux.size() > 0) {
				Messages.addGlobalError("Estacao já está cadastrada,Verifique!");
	    		return;
			}
			
		}else {
			if(!estacao.getNome().equals(estacaoClone.getNome())) {
				List<Estacao> aux = facadeAcesso.existeEstacao(estacao.getNome());
				if (aux.size() > 0) {
					Messages.addGlobalError("Estacao alterada, já está cadastrada,Verifique!");
					estacao.setNome(estacaoClone.getNome());
		    		return;
				}
			}
		}
		try {
			caldate1.setTime(estacao.getInicioestacao());
			caldate2.setTime(estacao.getFimestacao());
			if(caldate2.before(caldate1)) {
				Messages.addGlobalError("Data Final Menor que Inicial,Verifique!");
				return;
			}
			if(caldate1.equals(caldate2)) {
				Messages.addGlobalError("Data Inicial e final não podem ser iguais !");
				return;
			}
			estacao.setDatastamp(facadeAcesso.gettimeStamp());
			estacao.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			estacaoDao.update(estacao);
			refresh();
			Messages.addGlobalInfo("Operação executada com Sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel ,Cadastrar Estação !");
			ex.printStackTrace();

		}
	}
	public void delete(Estacao estacao) {
		try {
			estacaoDao.delete(estacao.getEstacaoid());
			refresh();
			Messages.addGlobalInfo("Estação Cancelada com Sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel cancelar Estação,verifique !");
		}
	}

	private void refresh() {
		  listaEstacao=estacaoDao.findAll();
	}


}
