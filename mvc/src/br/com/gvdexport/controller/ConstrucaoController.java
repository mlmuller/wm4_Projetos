package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.Construcao;
import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.model.Forma;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.TipoPessoa;
import br.com.gvdexport.util.BeanUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ConstrucaoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private Construcao construcao;
	@Getter @Setter
	private List<Construcao> listaConstrucaoVersoes;
	@Getter @Setter
	private List<Forma> listaFormas;
	@Getter @Setter
	private List<LivroReferencia> listaLivroReferencia;
	@Getter @Setter
	private List<FichaProducao> listaFichaNLProducao;
	@Getter @Setter
	private List<Construcao> listaConstrucao;
	@Getter @Setter
	private Construcao cloneConstrucao;
	@Getter @Setter
	private List<SimNao> simnao = Arrays.asList(SimNao.values());
	@Getter @Setter
	private List<TipoPessoa> tipopessoa = Arrays.asList(TipoPessoa.values());
	@Getter @Setter
	private List<Situacao> situacao = Arrays.asList(Situacao.values());
	private Integer operacao;
	@Getter @Setter
	private String negocnnegoc;
	@Getter @Setter
	private boolean duplica;
	@Getter @Setter
	private Construcao construcaoSelecionada;
	@Getter @Setter
	private String referenciaForma;
	@Getter @Setter
	private Boolean temFicha;
	//Esta variavel,deve ser tambem relacionada com o tipo de usuario
	@Getter @Setter
	private Boolean mStatus;
	@Getter @Setter
	private Boolean somenteLeitura;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<Construcao, Long> construcaoDao;
	
//	LazyConstrucaoDataModel dataModel = new LazyConstrucaoDataModel();
//	public LazyDataModel<Construcao> getModel() {
//		return dataModel;
//	}
	@PostConstruct
	public void init() {
	   	listaConstrucao = new ArrayList<Construcao>();
    	listaFormas = new ArrayList<Forma>();
    	referenciaForma = "";
    	mStatus = true;
    	operacao = 0;
    	setTemFicha(false);
    	construcao = new Construcao();
    	setMStatus(true);
    	listaConstrucao = construcaoDao.findAll();
    }
	
	//
	// Operacao 0 = inclusao
	//          1 = Alteração
	//          2 = Duplicação
	public void add() {
		construcao = new Construcao();
		listaFormas = new ArrayList<Forma>();
		construcao.setSituacao(Situacao.A);
		construcao.setComercial(false);
		construcao.setBloqueio(SimNao.N);
		construcao.setVersao(1);
		negocnnegoc="Não Negociada";
		referenciaForma = "";
		operacao = 0;
		duplica = false;
		mStatus = true;
    	setSomenteLeitura(false);
    	
	}
	public void edit(Construcao rowConstrucao) throws CloneNotSupportedException {
		cloneConstrucao = new Construcao();
		construcao = new Construcao();
		construcao = rowConstrucao;
		referenciaForma = construcao.getForma().getReferenciaforma();
		listaFormas = new ArrayList<Forma>();
		listaFormas.add(construcao.getForma());
	    cloneConstrucao = (Construcao) rowConstrucao.clone();
		setMStatus(true);
	    setSomenteLeitura(false);
	    if (rowConstrucao.getComercial()) {
	    	negocnnegoc="Negociada";
	    	mStatus = false;
		    Messages.addGlobalFatal("Ficha Negociada, já possui Pedido em Fábrica,contate Gerencia!");
	    }else {
	    	negocnnegoc="Não Negociada";
	    	mStatus=true;
	    }
	    if(construcao.getBloqueio().name().equals("S") ) {
	    	mStatus = false;
		    Messages.addGlobalFatal("Ficha Bloqueada para qualquer alteração, contate Gerencia!");
	    }
	    operacao = 1;
		duplica = true;
		temFicha = false; //Este sera usado,no teste se a alteracao na construcao tem ficha
		Boolean temFichaProducao = false;
		/*mAuxAmostraProdnLiberada e amostraProducao,criadas para implementar , caso queira ver quais são as amostras em producao
		 *quando implementar verificar se a a data de entrega esta preenchida...
		 *for , abaixo apenas verificar se existe em producao..
		*/
		List<Amostra> auxListaAmostra = facadeAcesso.getExisteListaFichaAmostra(construcao.getConstrucaoid());
		FichaProducao auxFichaProducao = new FichaProducao();
		listaFichaNLProducao = new ArrayList<FichaProducao>();
		List<FichaProducao> auxLstFichaNLProducao = new ArrayList<FichaProducao>(); 
		//aqui se nao for null, tem ficha de amostra com esta construcao
		if ((auxListaAmostra != null)  && (!auxListaAmostra.isEmpty())) {
			for (Amostra auxAmostra : auxListaAmostra) {
				//Aqui, as amostras encontradas,serao verificadas, se possuem ficha de producao
				if (!auxAmostra.getGerada() && (auxAmostra.getDataEntrega() == null)) {
					temFichaProducao = true;
					//aqui , significa que tem ficha de producao, abaixo serao verificadas se estao liberadas para alteracao
					//caso , tenha varias, se gerada uma lista para apresentacao ao usuario...
					auxLstFichaNLProducao = facadeAcesso.getExisteFichaNLProducao(auxAmostra.getAmostraId());
					if (auxLstFichaNLProducao != null) {
						for (FichaProducao auxFichaNLProducao : auxLstFichaNLProducao ) {
							if (auxFichaNLProducao.getLiberadoalteraramostra().equals(SimNao.N)) {
								listaFichaNLProducao.add(auxFichaProducao);
							}
						}
					}
					// Apartir daqui, feito a alteracao, podemos usar a lista para repor a clausula "N",bloqueando novamente alterações..
				}
			}
		}
		if (temFichaProducao) {
			  // Verificara se na producao estao liberadas ou nao...
			  temFicha = true;
			  Messages.addGlobalFatal("Tem Ficha(s) em Produção com está Construção, não é permitida alteração sem Liberação!");
			  setMStatus(false);
			  return;
		}
	}
	public void duplicaConstrucao(Construcao construcaodup) throws CloneNotSupportedException {
		setMStatus(true);
		setTemFicha(false);
		cloneConstrucao = new Construcao();
		this.construcao = construcaodup;
		if (construcao.getBloqueio().name().equals("S")) {
			Messages.addGlobalError("Não é possivel Duplicar esta Construcao!!!Foi Bloqueada por :"+construcaodup.getUsuariostamp()+" em :"+construcaodup.getDatastamp());
			mStatus = false;
			return;
		}
		//Ver possiblidade de criar rotina, para as construções com muitas versões, e se alguma
		// não foi usada, pois a duplicacao poderia ser com uma versao disponivel entre.....
		cloneConstrucao = (Construcao) construcaodup.clone();
		verVersoesConstrucao();
		Integer ultimaVersao = 0;
		for (int i = 0; i < listaConstrucaoVersoes.size(); i++) {
			if (listaConstrucaoVersoes.get(i).getVersao() > ultimaVersao) {
				ultimaVersao = listaConstrucaoVersoes.get(i).getVersao();
			}
		}
		cloneConstrucao.setConstrucaoid(null);
		cloneConstrucao.setBloqueio(SimNao.N);
		cloneConstrucao.setComercial(false);
		cloneConstrucao.setVersao(ultimaVersao+1);
		if(cloneConstrucao.getVersao() > 9) {
			Messages.addGlobalError("Não é possivel Duplicar esta Construcao,VERSÃO maior que 9!");
			mStatus = false;
		}
		cloneConstrucao.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
		cloneConstrucao.setDatastamp(construcaoDao.gettimeStamp());
		if (!mStatus) {
			FacesContext.getCurrentInstance().validationFailed();
			return;
		}
		try {
			 construcao = new Construcao();
			 construcao = construcaoDao.update(cloneConstrucao);
			 referenciaForma = construcao.getForma().getReferenciaforma();
			 refresh();
			 operacao = 2;
			 Messages.addGlobalInfo("Construcão Duplicada com Sucesso,liberada para alteração !");
		} catch (Exception ex) {
			Messages.addGlobalError("Não foi possivel Duplicar Referencia !");
			ex.printStackTrace();
			return;
		}
		
	}
	public void verificaBloqueio() {
		
	}
	public void preSave() throws Exception {
			try {
				if(operacao == 1 ) {
					Boolean b = BeanUtil.haveSamePropertyValues(Construcao.class, cloneConstrucao, construcao);
					listaLivroReferencia = new ArrayList<LivroReferencia>();
				    listaLivroReferencia = facadeAcesso.existeConstrucaoReferencia(cloneConstrucao.getConstrucaoid());
				    //Criar regra para verificacao de Ficha cadastrada???
				    //Observar que pode ocorrer Ficha na confirmacao, e não ter Amostra Nova
				    //Entao caso , não haja Ficha de amostras, Verificar imediatamente na Confirmacao
				    //Criar dialogo de confirmacao para esta operacao ou Java ou no Xhtml
					if((!construcao.getConstrucao().trim().equals(cloneConstrucao.getConstrucao().trim())) || (!construcao.getVersao().equals(cloneConstrucao.getVersao()))) {
						List<Construcao> aux = facadeAcesso.existeConstrucaoVersao(construcao.getConstrucao(),construcao.getVersao());
						if (aux.size() != 0 ) {
							Messages.addGlobalError("Esta Construção já possui Cadastro !");
							return;
						}
					}
					if((!construcao.getConstrucao().trim().equals(cloneConstrucao.getConstrucao().trim()))) {
						List<Construcao> aux = facadeAcesso.existeConstrucoes(construcao.getConstrucao());
						if (aux.size() != 0 ) {
							Messages.addGlobalError("Este Nome ja possui Cadastro, se quiser usa-la replique a Construção,e atribua nova Versão!");
						    construcao.setConstrucao(cloneConstrucao.getConstrucao());	
							return;
						}
					}
					if(construcao.getVersao() > 9) {
					       Messages.addGlobalError("Não é possivel cadastrar mais que 9 versões!");
					       return;
					}
					//verifica a existencia de fichas de Amostras com esta construcao
					Integer mAux = facadeAcesso.getExisteFichaAmostra(construcao);
					if ((!b)&&(mAux > 1)) {
						  temFicha = true;
						  Messages.addGlobalFatal("Será alterado em todas as Fichas que possuem esta Construcao, confirme botão Vermelho!!");
						  setMStatus(false);
						}
				    
				    if (!mStatus) {
				    	FacesContext.getCurrentInstance().validationFailed();
				    	return;
				    }
				}
				if (!temFicha) {
					if ((operacao == 0) || (operacao == 1) || (operacao == 2)){
						save();
					}
					
				}
				
				
			} catch (RuntimeException ex) {
		        Messages.addGlobalError("Não foi possivel Localizar fichas com esta Construcao!");
				ex.printStackTrace();
		       
			}
	}
	public void save() {
		try {
			if(operacao == 1 ) {
				construcao.setDatastamp(construcaoDao.gettimeStamp());
				construcao.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
				construcao.setReferenciaforma(construcao.getForma().getReferenciaforma());
			}	
			if ((operacao == 1) || (operacao == 2)) {
				construcaoDao.update(construcao);
			}	
			if(operacao == 0) {
				List<Construcao> aux = facadeAcesso.existeConstrucaoVersao(construcao.getConstrucao(), construcao.getVersao());
				if (aux.size() != 0 ) {
			        Messages.addGlobalError("Este Construção já possui Cadastro!");
					return;
				}
				if(construcao.getVersao() > 9) {
			       Messages.addGlobalError("Não é possivel cadastrar mais que 9 versões!");
			       return;
			    						
				}
				construcao.setDatastamp(construcaoDao.gettimeStamp());
				construcao.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
				construcao.setReferenciaforma(construcao.getForma().getReferenciaforma());
				construcaoDao.update(construcao);
				add();
			}
			Messages.addGlobalInfo("Operação executada com Sucesso!");
		} catch (RuntimeException ex) {
	        Messages.addGlobalError("Não foi possivel incluir Construcão!");
			ex.printStackTrace();
	       
		}		
	}
	public void delete(Construcao construcao) {
		try {
			// Para remover nao pode haver fichas nem amostra e confirmacao
			construcaoDao.delete(construcao.getConstrucaoid());
			refresh();
			Messages.addGlobalInfo("Construção Removida com Sucesso!");
		} catch (RuntimeException ex) {
   		    Messages.addGlobalError("Não foi possivel remover Construção!");
		}
	}

	public void refresh() {
//		listaConstrucao = facadeAcesso.todasConstrucoesPorOrdem();
//		if(listaFormas.size() == 0) {
//			listaFormas = formaDao.findAll();
//			
//		}
	}
	public void verVersoesConstrucao(){
	    if ((construcao.getConstrucao() == null) || construcao.getConstrucao().isEmpty()) {
	    	Messages.addGlobalError("Informe Nome Construção para verificação de Versão(ões) !");
	    	return;
	    }
	    listaConstrucaoVersoes = new ArrayList<>();
	    listaConstrucaoVersoes = facadeAcesso.existeConstrucoes(construcao.getConstrucao().trim());
	    if (listaConstrucaoVersoes.size() == 0){
	    	Messages.addGlobalInfo("Não há Cadastro para esta Construção!");
	    	construcao.setVersao(1);
	    	return;
	    }
	}

	public void buscaFormaPre(){
		if (!referenciaForma.isEmpty()) {
			listaFormas = facadeAcesso.existeFormaPre(referenciaForma.trim());
		}
		if (listaFormas.size() == 0) {
   		    Messages.addGlobalError("Forma não existente,verifique!");
   		    mStatus = false;
   		    return;
		}
		if (listaFormas.size() == 1) {
			construcao.setForma(listaFormas.get(0));
			mStatus = true;
		}
	}

//	public LazyDataModel<Construcao> getDataModel() {
//		return dataModel;
//	}

}
