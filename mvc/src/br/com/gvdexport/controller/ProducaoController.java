package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.LazyDataModel;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.lazy.LazyDataService;
import br.com.gvdexport.lazy.LazyFichaProducaoDataModel;
import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.Cliente;
import br.com.gvdexport.model.Construcao;
import br.com.gvdexport.model.Cor;
import br.com.gvdexport.model.CorAmostra;
import br.com.gvdexport.model.DireitoEsquerdo;
import br.com.gvdexport.model.EmTransicao;
import br.com.gvdexport.model.Estacao;
import br.com.gvdexport.model.Fabrica;
import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.model.Forma;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.LogAmostraFichaProducao;
import br.com.gvdexport.model.Mercado;
import br.com.gvdexport.model.ParametrosTransientes;
import br.com.gvdexport.model.PrioridadeProducao;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.SituacaoProducao;
import br.com.gvdexport.model.Tipo;
import br.com.gvdexport.util.EnviadorEmail;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ProducaoController implements Serializable {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter	@Setter
	private Amostra amostra;
	@Getter @Setter
	private FichaProducao fichaProducao;
	@Getter @Setter
	private Amostra amostraFichaProduzirFinal;
	@Getter @Setter
	private List<Amostra> listaAmostraProduzir;
	@Getter @Setter
	private List<FichaProducao> listaAmostraALiberar;
	@Getter @Setter
	private List<CorAmostra> listaTmpCoresSelecionasAmostras;
	@Getter @Setter
	private List<FichaProducao> listaFinalSelecaoProducao;
	@Getter @Setter
	private List<LogAmostraFichaProducao> logFichaProducao;
	@Getter	@Setter
	private CorAmostra corAmostraClone;
	@Getter	@Setter
	private ParametrosTransientes parametros;
	@Getter	@Setter
	private CorAmostra corAmostra;
	@Getter	@Setter
	private List<CorAmostra> listaCoresCadastradas;
	@Getter	@Setter
	private LivroReferencia livroReferencia;
	@Getter	@Setter
	private Cliente cliente;
	@Getter	@Setter
	private Construcao construcao;
	@Getter	@Setter
	private Fabrica fabrica;
	@Getter	@Setter
	private Forma forma;
	@Getter	@Setter
	private Estacao estacaoCliente;
	@Getter	@Setter
	private FichaProducao fichaProducaoClone;
	@Getter	@Setter
	private List<LivroReferencia> listaLivroReferencia;
	@Getter	@Setter
	private List<Amostra> listaFiltroAmostras;
	@Getter @Setter
	private Integer operacao;
	@Getter	@Setter
	private Integer operacaoPosterior;
	@Getter	@Setter
	private LivroReferencia referenciaSelecionada;
	@Getter @Setter
	private List<Estacao> listaEstacoes;
	//Itens Laz
	private LazyDataModel<FichaProducao> lazyModel;
	
	@Getter @Setter
	private FichaProducao amostraProducaoSelecionada;
    private String activeIndexes = null;
    private List<Tab> accordionTabs = null;

    //Variaveis para impressoao fichas de producao cfe selecao
	@Getter @Setter
    private Boolean pf;
	@Getter @Setter
	private Boolean ca;
	@Getter @Setter
	private Boolean md;
	@Getter @Setter
	private Boolean dt;
	// Esta variavel,deve ser tambem relacionada com o tipo de usuario
	
	@Getter	@Setter
	private List<Tipo> tipoamostra = Arrays.asList(Tipo.values());
	@Getter	@Setter
	private List<Mercado> mercado = Arrays.asList(Mercado.values());
	@Getter	@Setter
	private List<PrioridadeProducao> prioridade = Arrays.asList(PrioridadeProducao.values());
	@Getter	@Setter
	private List<SimNao> simNao = Arrays.asList(SimNao.values());
	//Fichas solicitadas Dpto de Amostras para alteracao....
	@Getter	@Setter
	private List<EmTransicao> emTransicao = Arrays.asList(EmTransicao.values());
	@Getter	@Setter
	private List<DireitoEsquerdo> direitoEsquerdo = Arrays.asList(DireitoEsquerdo.values());
	@Getter	@Setter
	private CorAmostra coresAmostra;
	@Getter	@Setter
	private List<SituacaoProducao> situacaoProducao = Arrays.asList(SituacaoProducao.values());

	//
	// Datas usadas na pesquisa
	//
	@Getter	@Setter
	private Date iniSolicitacao;
	@Getter	@Setter
	private Date finSolicitacao;
	@Getter	@Setter
	private Date iniliberap;
	@Getter	@Setter
	private Date finliberap;
	@Getter	@Setter
	private String informaCor;
	@Getter	@Setter
	private String informaCorp;
	@Getter	@Setter
	private Integer sequenciaCor;
	@Getter	@Setter
	private Integer ultimaSequencia;
	@Getter @Setter
	private Integer qtdTransicao;

	@Inject
	private FacadeAcesso facadeAcesso;

	@Inject
	private CrudDao<CorAmostra, Long> corAmostraNovaDao;

	@Inject
	private CrudDao<FichaProducao, Long> fichaProducaoDao;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	@Inject
	private EnviadorEmail enviadorEmail;

	@Inject
	private LazyDataService service;
	@PostConstruct
	
	public void init() {
		amostra = new Amostra();
		qtdTransicao =0;
		fichaProducao = new FichaProducao();
		listaLivroReferencia = new ArrayList<LivroReferencia>();
		listaAmostraProduzir = new ArrayList<Amostra>();
		listaAmostraALiberar = new ArrayList<FichaProducao>();
		listaCoresCadastradas = new ArrayList<>();
		listaEstacoes = new ArrayList<Estacao>();
		logFichaProducao = new ArrayList<LogAmostraFichaProducao>();
		operacaoPosterior = 0;
		listaAmostraALiberar = facadeAcesso.getExisteFichaALProducao();
		if (listaAmostraALiberar.size() == 0) {
			Messages.addGlobalWarn("N?o h? Fichas para Liberar !!!");
			return;
		}else {
			qtdTransicao = listaAmostraALiberar.size();
		}
		operacao = 0;
		pf = true;
		ca = true;
		md = false;
		dt = false;
		renovaLazy();
	}
	//Lazy
	public void renovaLazy() {
		lazyModel = new LazyFichaProducaoDataModel(service.getAmostraProducao());
	}

	
	public void setService(LazyDataService service) {
		this.service = service;
	}
	
	public void onRowSelect(SelectEvent<FichaProducao> event) {
	        FacesMessage msg = new FacesMessage("Amostra Producao Selecionada", String.valueOf(event.getObject().getFichaproducaoid()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	//---------------------------------------------------------------------------------
	public void badgeTransicao() {
		qtdTransicao = 0;
		if (listaAmostraALiberar.isEmpty() || listaAmostraALiberar == null) {
			listaAmostraALiberar = new ArrayList<FichaProducao>();
			listaAmostraALiberar = facadeAcesso.getExisteFichaALProducao();
			qtdTransicao = listaAmostraALiberar.size();
		}
		
	}
	public void ExecuteLiberar() {
	   	String msgAgrupa = "";
    	String msgRec = "";
    	String msg = "Ol?,Fichas em Produ??o Liberadas cfe Solicita??o:";
		for (FichaProducao fichaProducaoALiberar:listaAmostraALiberar ) {
		  if (fichaProducaoALiberar.getAliberar() && !fichaProducaoALiberar.getLiberadoalteraramostra().equals(EmTransicao.L)) {
		   if (fichaProducaoALiberar.getLiberadoalteraramostra().equals(EmTransicao.W)) {	  
			fichaProducaoALiberar.setLiberadoalteraramostra(EmTransicao.T);
			fichaProducaoALiberar.setSemaforo("#f22c11"); //red
			fichaProducaoALiberar.setDatacorrecao(fichaProducaoDao.getDateLocalTime());
			msgRec=Long.toString(fichaProducaoALiberar.getAmostra().getAmostraId()).trim()+"/"+fichaProducaoALiberar.getCoramostra().getSequenciaCorAmostra();
			msgAgrupa +=msgRec+",";
			msgRec = "";

		   try {
			fichaProducaoDao.update(fichaProducaoALiberar);
		   	   } catch (RuntimeException ex) {
		   		ex.printStackTrace();
		    }
	    }

		  }else {
			  Messages.addGlobalWarn("Voc? nao pode alterar/imprimir, est? em Altera??o,Verifique com Dpto de Amostra!");
			  return;
		  }
		}
 
		if (!msgAgrupa.isEmpty()) {
			msg+=System.lineSeparator()+msgAgrupa;
    		String remetente = "almoxarifado2@gvdintl.com.br";
    		String senha = "Vav91126";
    		//Alterar aqui destinatario
    		//email destino, deve ser obtido do cadastro de usuarios
    		String destinatario = "ti@gvdintl.com.br";
    		String assunto = "Confirma??o, liberada(s) Ficha(s) em Produ??o";
    		enviadorEmail.sendMail(remetente, senha, destinatario, msg, assunto);
    		//
    		//* Reatualiza Lista 
    		listaAmostraALiberar = facadeAcesso.getExisteFichaALProducao();
    		if (listaAmostraALiberar.size() == 0) {
    			Messages.addGlobalWarn("N?o h? Fichas Pendentes !!!");
    			qtdTransicao = 0;
    			return;
    		}else {
    			qtdTransicao = listaAmostraALiberar.size();
    		}

		}
	}
	
	//Metodo auxiliar para gravacao das cores selecionadas
	public void gerarFichaProdCor(Amostra amostraFichaProduzir) {
		Integer xCores = (amostraFichaProduzir.getCoresAmostra().size()-1);
		listaTmpCoresSelecionasAmostras = new ArrayList<>();
		//duas situacoes, se for marcado na amostra pega todas, se nao verificar cores afirmadas
		if (amostraFichaProduzir.getAmostraselecao()) {
			for (int i = 0; i < xCores; i++) {
				if ((amostraFichaProduzir.getCoresAmostra().get(i).getDesenvolveramostra().equals(SimNao.S))) {
					listaTmpCoresSelecionasAmostras.add(amostraFichaProduzir.getCoresAmostra().get(i));
				}
			}
		}else {
			for (int i = 0; i < xCores; i++) {
				if ((amostraFichaProduzir.getCoresAmostra().get(i).getCorselecao()) && (amostraFichaProduzir.getCoresAmostra().get(i).getDesenvolveramostra().equals(SimNao.S))) {
					listaTmpCoresSelecionasAmostras.add(amostraFichaProduzir.getCoresAmostra().get(i));
				}
			}
		}
		
	}
	//
	//Segunda etapa, geracao e gravacao no banco das fichas selecionadas com base na cor
	//
	public Boolean geraBancoFichaProducao() {
		listaFinalSelecaoProducao = new ArrayList<FichaProducao>();
		FichaProducao fichaProducao = new FichaProducao();
		Boolean geradaOk = false;
		for (CorAmostra corFinal : listaTmpCoresSelecionasAmostras) {
			fichaProducao.setAmostra(corFinal.getAmostra());
			fichaProducao.setCoramostra(corFinal);
			fichaProducao.setDataentrada(fichaProducaoDao.getDateLocalTime());
			fichaProducao.setDatastamp(fichaProducaoDao.getDateLocalTime());
			fichaProducao.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			fichaProducao.setLiberadoalteraramostra(EmTransicao.N);
			fichaProducao.setPares(corFinal.getTotalPar());
			fichaProducao.setParesatual(corFinal.getTotalPar());
			fichaProducao.setSituacao(SituacaoProducao.L);
			listaFinalSelecaoProducao.add(fichaProducao);
			try {
				fichaProducaoDao.update(fichaProducao);
				corFinal.setProducao(true);
				corAmostraNovaDao.update(corFinal);
				Messages.addGlobalInfo("Ficha Produ??o Gerada com sucesso !");
				geradaOk = true;
				renovaLazy();
			} catch (RuntimeException ex) {
				Messages.addGlobalError("N?o foi possivel gerar ficha de Produ??o !"+"-"+fichaProducao.getAmostra());
				ex.printStackTrace();
			}
		}
		return geradaOk;
	}
	public void inicializaParametros() {
		parametros = new ParametrosTransientes();
	}

	
	@SuppressWarnings("unused")
	private Map<Object,Object> componentStates = new HashMap<Object,Object>();

	 public String getActiveIndexes()
	  {
	    return activeIndexes;
	  }

	  public void setActiveIndexes(String activeIndexes)
	  {
	    this.activeIndexes = activeIndexes;
	  }
	  
	  public void activeAllIndexes()
	  {
	    if (! accordionTabs.isEmpty())
	    {
	      int tabs = accordionTabs.size();
	      String indexes = null;
	      for (int i = 0; i < tabs; i++)
	      {
	        indexes += i + ",";
	      }
	      // delete the last ',' character
	      indexes = indexes.substring(0, indexes.length() - 1);
	      
	      setActiveIndexes(indexes);
	    }
	  }
	  public void inactiveAllIndexes()
	  {
	    setActiveIndexes("");
	  }
	   public void onTabChange(TabChangeEvent<?> event) {
//	        FacesMessage msg = new FacesMessage("", "Ativo: " + event.getTab().getTitle());
//	        FacesContext.getCurrentInstance().addMessage(null, msg);

	    }

	    public void filtrosManuntencaoProducao(ToggleEvent event) {
//	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Filtros", "Visiveis:" + event.getVisibility());
//	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	@SuppressWarnings("rawtypes")
	public void referenciaSelecionada(SelectEvent event) {
		livroReferencia = new LivroReferencia();
		livroReferencia = (LivroReferencia) event.getObject();
		amostra.setLivroReferencia(livroReferencia);
		amostra.setAbreviacao(livroReferencia.getAbreviacao());
		amostra.setReferencia(livroReferencia.getReferencia());
		amostra.setVersaoRefer(livroReferencia.getVersaorefer());
		amostra.setConstrucaoNome(livroReferencia.getConstrucaonome());
		amostra.setVersao(livroReferencia.getVersao());
		amostra.setReferenciaForma(livroReferencia.getReferenciaforma());
		amostra.setConstrucao(livroReferencia.getConstrucao());
	}

	public void clienteSelecionado(SelectEvent<?> event) {
		cliente = new Cliente();
		cliente = (Cliente) event.getObject();
		amostra.setCliente(cliente);
		amostra.setSucCliente(cliente.getSucinto());
	}

	public void fabricaSelecionada(SelectEvent<?> event) {
		fabrica = new Fabrica();
		fabrica = (Fabrica) event.getObject();
		amostra.setFabrica(fabrica);
		amostra.setSucFabrica(fabrica.getSucinto());
	}

	public void construcaoSelecionada(SelectEvent<?> event) {
		construcao = new Construcao();
		construcao = (Construcao) event.getObject();

	}

	public void formaSelecionada(SelectEvent<?> event) {
		forma = new Forma();
		forma = (Forma) event.getObject();

	}


	public void estacaoSelecionada(SelectEvent<?> event) {
		estacaoCliente = new Estacao();
		estacaoCliente = (Estacao) event.getObject();
		amostra.setEstacao(estacaoCliente);
	}	

	public void corSelecionada(SelectEvent<?> event) {
		Cor corEscolha = new Cor();
		corEscolha = (Cor) event.getObject();
	}

	public void edit(FichaProducao ficha) {
		fichaProducaoClone = new FichaProducao();
		fichaProducao = new FichaProducao();
		try {
			fichaProducao = ficha;
			fichaProducaoClone = (FichaProducao) fichaProducao.clone();
			operacao = 1;
			StatusImpressao(ficha);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	public void delete(FichaProducao evento) {
		
	}
	public void imprimiAmostraProd(FichaProducao evento) {
		
	}

	public void salvaManProducao() {

		if ((fichaProducao.getDataalmoxarifado() != null) && (fichaProducao.getDatacorte() != null)) {
			if (fichaProducao.getDatacorte().isBefore(fichaProducao.getDataalmoxarifado())) {
				addMessage(FacesMessage.SEVERITY_WARN, "Data Corte Menor que data Almoxarifado !","");
				return;
			}
		}
		
		if ((fichaProducao.getDatacorte() != null) && (fichaProducao.getDatacostura() != null)) {
			if (fichaProducao.getDatacostura().isBefore(fichaProducao.getDatacorte())) {
				addMessage(FacesMessage.SEVERITY_WARN, "Data Costura Menor que data Corte !","");
				return;
			}
		}

		if ((fichaProducao.getDatacostura() != null) && (fichaProducao.getDatamontagem() != null)) {
			if (fichaProducao.getDatamontagem().isBefore(fichaProducao.getDatacostura())) {
				addMessage(FacesMessage.SEVERITY_WARN, "Data Montagem Menor que data Costura !","");
				return;
			}
		}
	
		if ((fichaProducao.getDataprefabricado() != null) && (fichaProducao.getDataacabamento() != null)) {
			if (fichaProducao.getDataacabamento().isBefore(fichaProducao.getDataprefabricado())) {
				addMessage(FacesMessage.SEVERITY_WARN, "Data Acabamento Menor que data Pr?-Fabricado!","");
				return;
			}
		}
		
		try {
			fichaProducaoDao.update(fichaProducao);
			addMessage(FacesMessage.SEVERITY_INFO,"Ficha Atualizada com sucesso !","");
			renovaLazy();
		} catch (Exception e) {
			addMessage(FacesMessage.SEVERITY_ERROR, "N?o foi possivel Atualizar Ficha !","");
			e.printStackTrace();
			return;
		}
	}

	public void adicionaNovoProblema() {
		
	}
    public void addMessage(FacesMessage.Severity severity,String summary,String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity,summary,detail));
    }

    public void StatusImpressao(FichaProducao fichaProducao) {
		if (fichaProducao.getDataalmoxarifado() != null) {
			pf = true;
		}else {
			pf = false;
		}

		if (fichaProducao.getDatacorte() != null) {
			ca = true;
		}else {
			ca = false;
		}
		
		if (fichaProducao.getDatamodelagem() != null) {
			md = true;
		}else {
			md = false;
		}

		if (fichaProducao.getDatadistribuicao() != null) {
			dt = true;
		}else {
			dt = false;
		}
    	
    }
    public void imprimiProducao() {
    	
    }
    public void executeTravar() {
    	
    }
    
    public void limpaInformacao() {
    	
    }

    public void verHistorico(FichaProducao fichaProducao) {
//		logFichaProducao = new ArrayList<LogAmostraFichaProducao>();
//		logFichaProducao = facadeAcesso.getBuscaLogsFihaProducao(fichaProducao.getAmostra().getAmostraId());
//		inicializaParametros();
//		if ((!logFichaProducao.equals(null)) && (logFichaProducao.size() != 0)) {
//			parametros.setLogModulo("Ficha Produ??o");
//		}else {
//			Messages.addGlobalInfo("N?o h? altera??es p?s-libera??o para esta Ficha Produ??o!");
//			return;
//		}
//    	
    }
	// ------Vis?o Logs
	public void visaoFichaProducaoLogs(FichaProducao fichaProducao) {
		logFichaProducao = new ArrayList<LogAmostraFichaProducao>();
		logFichaProducao = facadeAcesso.getBuscaLogsFihaProducao(fichaProducao.getAmostra().getAmostraId());
		inicializaParametros();
		parametros.setLogModulo("Ficha Produ??o");
		if (logFichaProducao.size() != 0) {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 640);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "referenciaheader");
		options.put("resizable", false);
		options.put("closable", true);
		options.put("position", "left,top");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkLogsProducao", options, null);
	  }else {
		Messages.addGlobalWarn("N?o h? altera??es p?s-Libera??es para esta Amostra");
		return;

	  }
	}
	public LazyDataModel<FichaProducao> getLazyModel() {
		return lazyModel;
	}

}
