package br.com.gvdexport.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.MessagingException;

import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.StreamedContent;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.dao.LogAmostrasNovasDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.facade.FacadeLogs;
import br.com.gvdexport.facade.FacadeView;
import br.com.gvdexport.lazy.LazyAmostraDataModel;
import br.com.gvdexport.lazy.LazyDataService;
import br.com.gvdexport.logs.logsControllerAmostras;
import br.com.gvdexport.model.AcabamentoAmostra;
import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.Cliente;
import br.com.gvdexport.model.Componente;
import br.com.gvdexport.model.Construcao;
import br.com.gvdexport.model.Cor;
import br.com.gvdexport.model.CorAcabamentoAm;
import br.com.gvdexport.model.CorAmostra;
import br.com.gvdexport.model.CorAmostraMulti;
import br.com.gvdexport.model.CorCabedalAm;
import br.com.gvdexport.model.CorConstrucaoAm;
import br.com.gvdexport.model.CorCorteAm;
import br.com.gvdexport.model.CorCosturaAm;
import br.com.gvdexport.model.CorteAmostra;
import br.com.gvdexport.model.CosturaAmostra;
import br.com.gvdexport.model.DestinoAmCf;
import br.com.gvdexport.model.DireitoEsquerdo;
import br.com.gvdexport.model.EmTransicao;
import br.com.gvdexport.model.Estacao;
import br.com.gvdexport.model.Fabrica;
import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.model.Forma;
import br.com.gvdexport.model.ImagemReferencia;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.LogAmostrasNovas;
import br.com.gvdexport.model.MarcaCliente;
import br.com.gvdexport.model.Material;
import br.com.gvdexport.model.Mercado;
import br.com.gvdexport.model.Modelo;
import br.com.gvdexport.model.ParametrosTransientes;
import br.com.gvdexport.model.PrioridadeProducao;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Tipo;
import br.com.gvdexport.model.TipoMaterial;
import br.com.gvdexport.util.EnviadorEmail;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class AmostraNovaController implements Serializable {

	/*
	 * 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Getter	@Setter
	private Amostra amostra;
	@Getter @Setter
	private Amostra auxAmostra;
	@Getter @Setter
	private List<Amostra> listaAmostras;
	@Getter @Setter
	private List<LogAmostrasNovas> listaLogs;
	@Getter @Setter
	private List<String> eventos;
	@Getter @Setter
	private List<String> nomeEventos;
	@Getter @Setter
	private List<FichaProducao> listaFichasProducao;
	@Getter	@Setter
	private CorAmostraMulti composicaoCor;
	@Getter	@Setter
	private List<CorAmostraMulti> listaCorMultiClone;
	@Getter	@Setter
	private CorAmostra corAmostraClone;
	@Getter	@Setter
	private ParametrosTransientes parametros;
	@Getter	@Setter
	private CorAmostra corAmostra;
	@Getter	@Setter
	private CorCabedalAm corCabedal;
	@Getter @Setter
	private CorCabedalAm corCabedalClone;
	@Getter	@Setter
	private Material material;
	@Getter	@Setter
	private List<CorAmostraMulti> listaCoresComposicao;
	@Getter	@Setter
	private List<CorAmostra> listaCoresCadastradas;
	@Getter @Setter
	private List<CorAmostra> listCoresDup;
	@Getter	@Setter
	private List<CorAmostraMulti> ajustaMulti;
	@Getter	@Setter
	private Integer sequencialCor;
	@Getter	@Setter
	private LivroReferencia livroReferencia;
	@Getter	@Setter
	private Cliente cliente;
	@Getter	@Setter
	private Modelo modelo;
	@Getter	@Setter
	private MarcaCliente marcaCliente;
	@Getter	@Setter
	private Componente componente;
	@Getter	@Setter
	private Construcao construcao;
	@Getter	@Setter
	private Fabrica fabrica;
	@Getter	@Setter
	private Forma forma;
	@Getter	@Setter
	private Estacao estacaoCliente;
	@Getter	@Setter
	private Amostra amostraClone;
	@Getter	@Setter
	private List<LivroReferencia> listaLivroReferencia;
	@Getter	@Setter
	private List<DestinoAmCf> listaDestinoAmCf;
	@Getter	@Setter
	private List<Amostra> listaFiltroAmostras;
	@Getter @Setter
	private Integer operacao;
	@Getter	@Setter
	private Integer operacaoPosterior;
	@Getter @Setter
	private Boolean salvaUm;
	// Esta variavel comb e boolean , verificar se é necessario produzir a amostra
	// ou nao.
	@Getter @Setter
	private Integer verProduzAmostra;
	@Getter	@Setter
	private boolean duplica;
	@Getter	@Setter
	private LivroReferencia referenciaSelecionada;
	@Getter @Setter
	private String Status;

	@Getter	@Setter
	private Integer qtdFichas;

	private String activeIndexes = null;
	private List<Tab> accordionTabs = null;
	//Variaveis determinam fase de producao(Number1,number2)
	@Getter @Setter
	private Integer Number1;
	@Getter @Setter
	private Integer Number2;
	//Itens para Lazy e reLazy
	@Getter @Setter
	private LazyDataModel<Amostra> lazyModel;
	@Getter @Setter
	private Amostra amostraSelecionada;
	@Getter @Setter
	private List<FilterMeta> filterBy;	


	//Estas variaveis definirao se haverão alterações nas etapas em relacao aos clones
	
	@Getter @Setter
	private Boolean fase1;
	
	@Getter @Setter
	private Boolean fase2;
	
	@Getter @Setter
	private Boolean fase3;
	
	@Getter @Setter
	private Boolean fase4;
	
	@Getter @Setter
	private Boolean fase5;
	
	// Esta variavel,deve ser tambem relacionada com o tipo de usuario
	@Getter @Setter
	private List<Tipo> tipos = Arrays.asList(Tipo.values());
	@Getter	@Setter
	private Boolean mStatus;
	@Getter	@Setter
	private List<Tipo> tipoamostra = Arrays.asList(Tipo.values());
	@Getter	@Setter
	private List<Mercado> mercado = Arrays.asList(Mercado.values());
	@Getter	@Setter
	private List<PrioridadeProducao> prioridade = Arrays.asList(PrioridadeProducao.values());
	@Getter	@Setter
	private List<SimNao> simNao = Arrays.asList(SimNao.values());
	@Getter	@Setter
	private List<TipoMaterial> tipoMaterial = Arrays.asList(TipoMaterial.values());
	@Getter	@Setter
	private List<DireitoEsquerdo> direitoEsquerdo = Arrays.asList(DireitoEsquerdo.values());
	@Getter	@Setter
	private CorAmostra coresAmostra;
	@Getter	@Setter
	private String altura;
	@Getter	@Setter
	private String largura;
	@Getter	@Setter
	private Integer linha1;
	@Getter	@Setter
	private Integer linha2;
	@Getter	@Setter
	private Integer linha3;
	@Getter	@Setter
	private Integer linha4;
	@Getter	@Setter
	private Integer linha5;
	@Getter	@Setter
	private Integer linha6;
	@Getter	@Setter
	private Integer refazComposicao;
	@Getter	@Setter
	private Integer posicaoAtual;
	//
	// Datas usadas na pesquisa
	//
	@Getter	@Setter
	private Date iniSolicitacao;
	@Getter	@Setter
	private Date finSolicitacao;
	@Getter	@Setter
	private Date iniamostrap;
	@Getter	@Setter
	private Date finamostrap;
	@Getter	@Setter
	private Date inisaidaf;
	@Getter	@Setter
	private Date finsaidaf;
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

	// Variaveis de Pesquisa
	@Getter	@Setter
	private String pesqCliente;
	@Getter	@Setter
	private String pesqFabrica;
	@Getter	@Setter
	private List<Fabrica> listaFabricas;
	@Getter	@Setter
	private List<Cliente> listaClientes;
	@Getter	@Setter
	private Integer primeiraCor;
	@Getter	@Setter
	private Integer primeiroMat;
	@Getter	@Setter
	private Integer umaCorPrincipal;
	@Getter	@Setter
	private Boolean btnVisao;
	// Composicoes necessarias para formatar corte
	@Getter @Setter
	private CorteAmostra corteAmostra;
	@Getter @Setter
	private CorCorteAm corCorteAmostra;
	@Getter @Setter
	private List<CorCorteAm> listaCorCorteAmostra;
	@Getter @Setter
	private Boolean liberaDialogCorte;
	@Getter @Setter
	private Boolean statusGeracao;
	//
	// Composicoes para formatar Costura
	//
	@Getter @Setter
	private CosturaAmostra costuraAmostra;
	@Getter @Setter
	private CorCosturaAm corCosturaAmostra;
	@Getter @Setter
	private List<CorCosturaAm> listaCorCosturaAmostra;
	//
	// Composicao necessaria para formatar Solado
	//
	@Getter @Setter
	private Construcao soladoAmostra;
	@Getter @Setter
	private List<CorConstrucaoAm> listaCorSoladoAmostra;
	@Getter @Setter
	private CorConstrucaoAm corSoladoAmostra;
	@Getter @Setter
	private FichaProducao fichaProducao;
	//
	// Variavel abrira renderiza, se houver fichas em producao
	//
	@Getter @Setter
	private Boolean mostraListaProducao;
	//
	// Composicao necessaria para formatar Acabamento
	//
	@Getter @Setter
	private AcabamentoAmostra acabamentoAmostra;
	@Getter @Setter
	private List<CorAcabamentoAm> listaCorAcabamentoAmostra;
	@Getter @Setter
	private CorAcabamentoAm corAcabamentoAmostra;

	@Getter @Setter
	private StreamedContent imageResize;

	@Getter @Setter
	private Boolean liberaTransito;
	
	@Getter @Setter
	private Boolean solicitaLiberacao;
	
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private FacadeLogs facadelogs;

	@Inject
	private CrudDao<CorCorteAm, Long> corCorteAmostraDao;

	@Inject
	private FacadeView facadeView;
	
	@Inject
	private UsuarioLogadoController usuarioLogado;

	@Inject
	private CrudDao<Amostra, Long> amostraDao;

	@Inject
	private CrudDao<CorAmostra, Long> corAmostraNovaDao;

	@Inject
	private CrudDao<CorCabedalAm, Long> corCabedalAmostraDao;

	@Inject
	private CrudDao<CorteAmostra, Long> corteAmostraDao;

	@Inject
	private CrudDao<CosturaAmostra, Long> costuraAmostraDao;

	@Inject
	private CrudDao<CorCosturaAm, Long> corCosturaAmostraDao;

	@Inject
	private CrudDao<AcabamentoAmostra, Long> acabamentoAmostraDao;

	@Inject
	private CrudDao<CorAcabamentoAm, Long> corAcabamentoAmostraDao;

	@Inject
	private CrudDao<Construcao, Long> soladoAmostraDao;
	
	@Inject
	private CrudDao<CorConstrucaoAm, Long> corSoladoAmostraDao;

	@Inject
	private CrudDao<CorAmostraMulti, Long> corAmostraMultidao;

	@Inject
	private CrudDao<FichaProducao, Long> fichaProducaoDao;
	
	@Inject
	private EnviadorEmail enviadorEmail;
	
	@Inject
	private logsControllerAmostras logsControllerAmostrasNovas;

	@Inject
	private LogAmostrasNovasDao logAmostraNovaDao;
	//Lazy
	@Inject
	private LazyDataService service;
	
	@PostConstruct
	public void init(){
		amostra = new Amostra();
		parametros = new ParametrosTransientes();
		listaLivroReferencia = new ArrayList<LivroReferencia>();
		listaFiltroAmostras = new ArrayList<Amostra>();
		listaCoresCadastradas = new ArrayList<>();
		listaAmostras = new ArrayList<Amostra>();
		listaLogs = new ArrayList<LogAmostrasNovas>();
		// (Operacao Posterior)
		// = 0, continua noutro perido
		// = 1, contniua adicao da ficha no mesmo momento
		operacaoPosterior = 0;
		mStatus = true;
		operacao = 0;
		btnVisao = false;
		statusGeracao = false;
		parametros.setTemLog(false);
		parametros.setLogModulo("Não Há");
		parametros.setAllTransicao(false);
		liberaTransito = false;
		// inicializa varaveis de pesquisa
		// inicializa datas
		inicializaVariaveis();
		inicializaParametros();
		inicializaConsulta();
		iniciaTransCores();
		populaNomeEventos();
		Status = "____/____/_____";
		//Variavel para uso na atualizacao se for selecionado apenas uma cor
		Number1 = 0;
		Number2 = 100;
		renovaLazy();
	}
	//Chamadas para Lazy e reLazy
	   public void renovaLazy() {
			lazyModel = new LazyAmostraDataModel(service.getAmostra());
	    }
		public void setService(LazyDataService service) {
			this.service = service;
		}
		
		public void onRowSelect(SelectEvent<LivroReferencia> event) {
		        FacesMessage msg = new FacesMessage("Referencia Selecionada", String.valueOf(event.getObject().getLivroreferenciaid()));
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	//
	// Operacao 0 = inclusao
	// 1 = Alteração
	// 2 = Duplicação
	public void add() {
		amostra = new Amostra();
		operacao = 0;
		verProduzAmostra = 0;
		duplica = false;
		mStatus = true;
		mostraListaProducao = false;
		amostra.setGerada(false);
		amostra.setPrioridadeProducao(PrioridadeProducao.X);
		amostra.setDataSolicitacao(amostraDao.getLocalDate());
		amostra.setPares(BigDecimal.ZERO);
		amostra.setPargvd(BigDecimal.ZERO);
		amostra.setTemcor(false);
		amostra.setLog(false);
		// alterado para 1 , antes 0 , em 14/04;
		operacaoPosterior = 1;
		sequencialCor = 0;
		umaCorPrincipal = 0;
		parametros.setPrioridade(true);
		parametros.setBtncheck(true);
		parametros.setSaveTransicao(true);
		parametros.setFechaTransicao(false);
		parametros.setInpdataliberacao(false);
		//		parametros.setBtnvisao(true); comentado em 26/01
		setBtnVisao(false);
		listaCoresComposicao = new ArrayList<>();
		linha1 = 0;
		linha2 = 1;
		linha3 = 2;
		linha4 = 3;
		linha5 = 4;
		linha6 = 5;
		refazComposicao = 0;
		inicializaVetoresOperacoes();
		imageResize = null;
		inicializaVariaveis();
	}

	// Inicaliza parametros de mostragem das abas, em modo true
	public void inicializaParametros() {
		parametros.setAbacor(true);
		parametros.setAbacorte(true);
		parametros.setAbacostura(true);
		parametros.setAbasolado(true);
		parametros.setAbaacabamento(true);

	}

	public void inicializaCor() {
		corAmostra = new CorAmostra();
		corCabedal = new CorCabedalAm();
		corAmostraClone = new CorAmostra();
		corAmostra.setAmostraId(amostra.getAmostraId());
		corAmostra.setAmostra(amostra);
		corAmostra.setDesenvolveramostra(SimNao.S);
		corAmostra.setMarca("⏱");
		corAmostra.setTotalPar(BigDecimal.ZERO);
		corAmostra.setParGvd(BigDecimal.ZERO);
		corAmostra.setParCancelado(BigDecimal.ZERO);
		corAmostra.setProducao(false);
		listaCoresComposicao = new ArrayList<>();
		ajustaMulti = new ArrayList<>();
		refazComposicao = 0;
		// Primeira Linha nasce habilitada
		parametros.setBotao1(true);
		parametros.setHabilita1(true);
		parametros.setBtnlimpa1(true);
		parametros.setBtncheck(true);
		// deabilitar demais
		parametros.setHabilita2(false);
		parametros.setHabilita3(false);
		parametros.setHabilita4(false);
		parametros.setHabilita5(false);
		parametros.setHabilita6(false);
		// desabilita demais
		parametros.setBotao2(false);
		parametros.setBotao3(false);
		parametros.setBotao4(false);
		parametros.setBotao5(false);
		parametros.setBotao6(false);
		// desabilita icone de apagar
		parametros.setBtnlimpa2(false);
		parametros.setBtnlimpa3(false);
		parametros.setBtnlimpa4(false);
		parametros.setBtnlimpa5(false);
		parametros.setBtnlimpa6(false);
		// inicializa transientes cores de acabamento
		iniciaTransCores();
		// Carrega todas as listas , porque se não carregar, e chamar por exemplo Corte,
		// em uma nova
		// Cor, este carregar corretamente a nova cor, mas paa a proxima aba, ex:
		// Costura, verificar que as variaveis de Renderizacao
		// são as mesmas e carregar os includes do anterior. A Nova consulta tem 4 cor,
		// e a anterior tem duas,os includes sao todos carregados..
		setBtnVisao(false);
		//
		// Abrir botoes de insercao multi

		linha1 = 0;
		linha2 = 1;
		linha3 = 2;
		linha4 = 3;
		linha5 = 4;
		linha6 = 5;
		primeiraCor = 0;
		primeiroMat = 0;
		sequencialCor = 0;
		ultimaSequencia = 0;
		operacao = 0;
		// /verfica se ja existe cadastro
		if ((operacaoPosterior == 0) || operacaoPosterior == 1) {
			listaCoresCadastradas = facadeAcesso.getBuscaCoresAmostra(amostra.getAmostraId());
			if (listaCoresCadastradas.size() > 3) {
				Messages.addGlobalError("Não é possivel incluir Novas Cores, Limite de 4 Cores!");
				FacesContext.getCurrentInstance().validationFailed();
				return;
			}
			if (listaCoresCadastradas.size() == 0) {
				parametros.setHabilita1(true);
				sequencialCor = 0;
				ultimaSequencia = 1;
			} else {
				ultimaSequencia = 0;
				for (CorAmostra listaCores : listaCoresCadastradas) {
					ultimaSequencia = listaCores.getSequenciaCorAmostra();
				}
				ultimaSequencia++;
				corAmostra.setSequenciaCorAmostra(ultimaSequencia);
				// alterado em 04/05/2021
				// quando operacaoPosterior = 0, inclusa noutro periodo, entao a operacao e de
				// alteracao
				// comentado em 27/05/2021
				// if (operacaoPosterior == 0) {
				// operacao = 1;
//				}
			}
		}
		facadeView.inicializaCor(operacao);
	}

	public void addCor() {
		ultimaSequencia = 0;
		if (listaCoresCadastradas.size() != 0) {
			for (CorAmostra listaCores : listaCoresCadastradas) {
				ultimaSequencia = listaCores.getSequenciaCorAmostra();
			}
			parametros.setAbaacabamento(true);
			parametros.setAbacorte(true);
			parametros.setAbacostura(true);
			parametros.setAbasolado(true);
			parametros.setBtncheck(true);// Alterado de false p/true em 08/04
			parametros.setBtnfecha(true);
			ultimaSequencia++;
			btnVisao = false;
		} else {
			parametros.setAbacor(false);
			parametros.setAbaacabamento(false);
			parametros.setAbacorte(false);
			parametros.setAbacostura(false);
			parametros.setAbasolado(false);
			ultimaSequencia = 1;
		}
		//
		ajustaMulti = facadeView.getListaMultiCor();
		if (ajustaMulti.get(linha2).getMaterial() != null) {
			ajustaMulti.get(linha1).setSeqMaterial(ajustaMulti.get(linha1).getSequenciaPosicao());
		}
		// -----------------
		ajustaPermissoes(refazComposicao);
		// -----------------
		// Variavel refazComposicao ,se caso for pressionado Refaz, precisa deixar o
		// botao ultimo inclusao para
		// pra caso opte por nova inclusao de linha para nova cor/material
		// BtnLimpa1,2,3,4,5 , habilitam botao limpar, no ultimo item, foi usado o
		// btn6,pois nao entraria
		// mais nesta rotina para habilitar botao de inservao de nova cor
		if (refazComposicao == 0) {
			sequencialCor++;
		} else {
			ajustaParametros(ajustaMulti, sequencialCor);
		}
		posicaoAtual = sequencialCor;
		switch (sequencialCor) {
		case 1:
			parametros.setHabilita2(true);
			parametros.setBotao1(false);
			parametros.setBotao2(true);
			parametros.setBtnlimpa2(true);
			break;
		case 2:
			parametros.setHabilita3(true);
			parametros.setBotao2(false);
			parametros.setBotao3(true);
			parametros.setBtnlimpa3(true);
			break;
		case 3:
			parametros.setHabilita4(true);
			parametros.setBotao3(false);
			parametros.setBotao4(true);
			parametros.setBtnlimpa4(true);
			break;
		case 4:
			parametros.setHabilita5(true);
			parametros.setBotao4(false);
			parametros.setBotao5(true);
			parametros.setBtnlimpa5(true);
			break;
		case 5:
			parametros.setHabilita6(true);
			parametros.setBotao5(false);
			parametros.setBotao6(true);
			parametros.setBtnlimpa6(true);
			break;
		}
	}

	public void edit(Amostra amostraedit) throws CloneNotSupportedException, IOException {
		amostraClone = new Amostra();
		posicaoAtual = 0;
		amostra = amostraedit;
		parametros.setTemLog(false);
		parametros.setAllTransicao(false);
		//Verificar se ha fichas na producao e se houver, ver Status
		PrimeFaces current = PrimeFaces.current();
		mostraListaProducao = false;
		listaLogs = new ArrayList<LogAmostrasNovas>();
		listaLogs = facadeAcesso.getBuscaLogsAmostraNova(amostraedit.getAmostraId());
		if (listaLogs.size() != 0) {
			parametros.setTemLog(true);
			parametros.setLogModulo("Amostras Novas");
		}
		if (amostra.getGerada()) {
			listaFichasProducao = new ArrayList<FichaProducao>();
			listaFichasProducao = facadeAcesso.getExisteFichaNLProducao(amostraedit.getAmostraId());
			if (listaFichasProducao.size() != 0) {
				qtdFichas = listaFichasProducao.size();
				for (FichaProducao fichaProducao : listaFichasProducao) {

					if (fichaProducao.getLiberadoalteraramostra().name().equals("N")) {
						mostraListaProducao = true;
					}
					if (fichaProducao.getLiberadoalteraramostra().name().equals("T")) {
						liberaTransito = true;
						parametros.setAllTransicao(true);
					}
				}
				if (mostraListaProducao) {
					addMessage(FacesMessage.SEVERITY_WARN, "Existe(m) Ficha(s) em Produção !","");
					current.executeScript("PF('listaAmostraemProdDlg').show()");
					return;
				}else {
//					//adic em 19/10/2022, todas esta em transito,entao precisa atribuir,reg vindo
//					//do datatable,caso nao , mostrará tela vazia...
//					current.executeScript("PF('addEditFormAmostraNovaDlg').show()");
//					current.ajax().update("crudFormAmostraSecundario");
				}
				
			}
		}

		posicaoAtual = 0;
		amostraClone = (Amostra) amostra.clone();
		//Campo é informado na construcao(Solado, e é gravado na tabela de amostras
		operacao = 1;
		// adiconado em 14/04
		operacaoPosterior = 0;
		if (parametros == null) {
			parametros = new ParametrosTransientes();
		}
		parametros.setBtnlimpa1(true);
		parametros.setBtnlimpa2(false);
		parametros.setBtnlimpa3(false);
		parametros.setBtnlimpa4(false);
		parametros.setBtnlimpa5(false);
		parametros.setBtnlimpa6(false);
		parametros.setBtncheck(true);
		parametros.setAbacor(false);
		parametros.setSaveTransicao(true);
		parametros.setFechaTransicao(true);
		parametros.setInpdataliberacao(false);
		setBtnVisao(false);
		// Libera campo para alteracao
		// Aqui devera aparecer verificacao se possui fichas em producao
		// Aqui devera avisar, que precisa liberacao da producao para
		// alteracao.
		// aqui devera ser verificado se alterar prioridade, devera ter cadastro
		// completo,caso contrario avisa, que
		// o que falta (Cor,acabamentos,etc...)
		// Atualiza variaveis de infomacao
		facadeView.editCor(amostra.getReferencia().toString().trim(), amostra.getSucCliente(),
				amostra.getEstacao().getNome(), amostra.getSucFabrica(), amostra.getComponente().getDef1().trim());
		// Para liberar este campo nao pode ter ficha de producao e se tiver precisa
		// libera-la pela Produção

		// Lista com cores da amostra Selecionada
		listaCoresCadastradas = new ArrayList<>();
		listaCoresCadastradas = facadeAcesso.getBuscaCoresAmostra(amostraedit.getAmostraId());
		if (amostra.getCliente().getGrpclienteinvoice() != null) {
			buscaListaDestinoAm(amostra);
		}
		if ((amostra.getPrioridadeProducao() != amostraClone.getPrioridadeProducao()) && ((listaCoresCadastradas == null || listaCoresCadastradas.size() == 0))) {
			addMessage(FacesMessage.SEVERITY_WARN, "Não é possivel Liberar Produção, Não tem Cor(es) Cadastradas !","");
			amostra.setPrioridadeProducao(amostraClone.getPrioridadeProducao());
			return;
		}
		if (amostra.getPrioridadeProducao().equals(PrioridadeProducao.X)) {
			parametros.setPrioridade(true);
		}
		imageResize = ResizeImagem(amostra);
		if (!mostraListaProducao) {
			current.executeScript("PF('addEditFormAmostraNovaDlg').show()");
		}
		//Habilita campo para liberacao de producao
		if ((listaCoresCadastradas != null) && (listaCoresCadastradas.size() != 0)) {
			parametros.setInpdataliberacao(true);
		}
	}

	public void editCorMulti(CorAmostra corEditAmostra) throws CloneNotSupportedException {
		operacao = 1;
		btnVisao = false;
		refazComposicao = 0;
		corAmostraClone = new CorAmostra();
		corCabedalClone = new CorCabedalAm();
		listaCoresComposicao = new ArrayList<>();
		corAmostra = new CorAmostra();
		corCabedal = new CorCabedalAm();
		corAmostra = corEditAmostra;
		corAmostraClone = (CorAmostra) corAmostra.clone();
		corCabedal = facadeAcesso.getBuscaCorAmostraCabedal(amostra.getAmostraId(), corAmostra.getId());
		Optional<CorCabedalAm> corCabedalAm = Optional.empty();
		corCabedalAm = Optional.ofNullable(corCabedal);
		if (!corCabedalAm.isPresent()) {
			corCabedal = new CorCabedalAm();
			corCabedal.setAmostra(amostra);
			corCabedal.setCoramostra(corAmostra);
			corCabedal.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			corCabedal.setDatastamp(corCabedalAmostraDao.getDateLocalTime());
		} else {
			corCabedalClone = (CorCabedalAm) corCabedal.clone();
		}
		listaCoresComposicao = facadeAcesso.getBuscaCorAmostraMulti(corAmostra.getAmostraId(),
				corAmostra.getSequenciaCorAmostra());
		Collections.sort(listaCoresComposicao, Comparator.comparing(CorAmostraMulti::getSequenciaPosicao));
		listaCorMultiClone = new ArrayList<>();
		listaCorMultiClone = facadeAcesso.getBuscaCorAmostraMulti(corEditAmostra.getAmostraId(),
				corEditAmostra.getSequenciaCorAmostra());
		Collections.sort(listaCorMultiClone, Comparator.comparing(CorAmostraMulti::getSequenciaPosicao));
		ajustaParametrosPosInclusao(listaCoresComposicao);
		linha1 = 0;
		linha2 = 1;
		linha3 = 2;
		linha4 = 3;
		linha5 = 4;
		linha6 = 5;
		facadeView.getInicializaVetorEntrada(listaCoresComposicao, operacao, corAmostra);

	}
	
	// Corte
	// Corte/Cor
	@SuppressWarnings("unused")
	public void editCorteCorAmostra(CorAmostra corAmostra) throws CloneNotSupportedException {
		salvaUm = true;
		corAmostraClone = (CorAmostra) corAmostra.clone();
		CorteAmostra corteAmostraAux = facadeAcesso.getBuscaCorteAmostra(corAmostra.getAmostra().getAmostraId());
		Optional<CorteAmostra> corteAmostraPresente = Optional.empty();
		corteAmostraPresente = Optional.ofNullable(corteAmostraAux);
		corteAmostra = new CorteAmostra();
		iniciaTransCorteCor();

		// Corte
		if (!corteAmostraPresente.isPresent()) {
			Messages.addGlobalError("Por Favor, antes, você deveria, Inserir Dados Corte");
			return;
		} else {
			CorteAmostra corteAmostraClone = new CorteAmostra();
			corteAmostra = corteAmostraAux;
			corteAmostraClone = (CorteAmostra) corteAmostraAux.clone();
		}

		//Cor especifica Corte
		listaCorCorteAmostra = new ArrayList<CorCorteAm>();
		List<CorCorteAm> listaAux = facadeAcesso.getBuscaUmaCorCorteAmostra(corAmostra.getId());
		CorCorteAm corCorteAmClone = new CorCorteAm();
		if (listaAux != null) {
			listaCorCorteAmostra = listaAux;
			try {
				corCorteAmClone = (CorCorteAm) listaAux.get(0).clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}else {
			addMessage(FacesMessage.SEVERITY_ERROR , "Por favor, contate Administrador-Amostracontroller-line:638, informando os dados!", "");
			return;
		}

		parametros.setPricor(true);

	}

	// Costura
	// Costura/cor
	@SuppressWarnings("unused")
	public void editCosturaCorAmostra(CorAmostra corAmostra) throws CloneNotSupportedException {
		corAmostraClone = (CorAmostra) corAmostra.clone();
		CosturaAmostra costuraAmostraAux = facadeAcesso.getBuscaCosturaAmostra(corAmostra.getAmostra().getAmostraId());
		Optional<CosturaAmostra> costuraAmostraPresente = Optional.empty();
		costuraAmostraPresente = Optional.ofNullable(costuraAmostraAux);
		costuraAmostra = new CosturaAmostra();
		iniciaTransCosturaCor();

		// Costura
		if (!costuraAmostraPresente.isPresent()) {
			addMessage(FacesMessage.SEVERITY_WARN,"Por Favor, antes, você deveria, Inserir Dados Costura!" , "");
			return;
		} else {
			CosturaAmostra costuraAmostraClone = new CosturaAmostra();
			costuraAmostra = costuraAmostraAux;
			costuraAmostraClone = (CosturaAmostra) costuraAmostraAux.clone();
		}

		//Cor especifica Costura
		listaCorCosturaAmostra = new ArrayList<CorCosturaAm>();
		List<CorCosturaAm> listaAux = facadeAcesso.getBuscaUmaCorCosturaAmostra(corAmostra.getId());
		CorCosturaAm corCosturaAmClone = new CorCosturaAm();
		if (listaAux != null) {
			listaCorCosturaAmostra = listaAux;
			try {
				corCosturaAmClone = (CorCosturaAm) listaAux.get(0).clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}else {
			Messages.addGlobalError("Por favor, contate Administrador-Amostracontroller-line:638, informando os dados!");
			return;
		}

		parametros.setPricorb(true);


	}

	public void editSoladoCorAmostra(CorAmostra corAmostra) {
		try {
			corAmostraClone = (CorAmostra) corAmostra.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		Construcao construcaoAmostraAux = facadeAcesso.getBuscaConstrucaoAmostra(corAmostra.getAmostra().getConstrucao().getConstrucaoid());
		Optional<Construcao> construcaoAmostraPresente = Optional.empty();
		construcaoAmostraPresente = Optional.ofNullable(construcaoAmostraAux);
		soladoAmostra = new Construcao();
		iniciaTransSoladoCor();

		// Costura
		if (!construcaoAmostraPresente.isPresent()) {
			Messages.addGlobalError("Por Favor, antes, você deveria, Inserir Dados na Construcao");
			return;
		} else {
			Construcao construcaoAmostraClone = new Construcao();
			soladoAmostra = construcaoAmostraAux;
			try {
				construcaoAmostraClone = (Construcao) construcaoAmostraAux.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}

		//Cor especifica Costura
		listaCorSoladoAmostra = new ArrayList<CorConstrucaoAm>();
		List<CorConstrucaoAm> listaAux = facadeAcesso.getBuscaUmaCorSoladoAmostra(corAmostra.getId());
		CorConstrucaoAm corConstrucaoAmClone = new CorConstrucaoAm();
		if (listaAux != null) {
			listaCorSoladoAmostra = listaAux;
			try {
				corConstrucaoAmClone = (CorConstrucaoAm) listaAux.get(0).clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}else {
			Messages.addGlobalError("Por favor, contate Administrador-Amostracontroller-line:638, informando os dados!");
			return;
		}

		parametros.setPricorc(true);

		
	}
//	
	public void editAcabamentoCorAmostra(CorAmostra corAmostra) throws CloneNotSupportedException {
		corAmostraClone = (CorAmostra) corAmostra.clone();
		AcabamentoAmostra acabamentoAmostraAux = facadeAcesso.getBuscaAcabamentoAmostra(corAmostra.getAmostra().getAmostraId());
		Optional<AcabamentoAmostra> acabamentoAmostraPresente = Optional.empty();
		acabamentoAmostraPresente = Optional.ofNullable(acabamentoAmostraAux);
		acabamentoAmostra = new AcabamentoAmostra();
		iniciaTransAcabCor();

		// Acabamento
		if (!acabamentoAmostraPresente.isPresent()) {
			Messages.addGlobalError("Por Favor, antes, você deveria, Inserir Dados Acabamento");
			return;
		} else {
			AcabamentoAmostra acabamentoAmostraClone = new AcabamentoAmostra();
			acabamentoAmostra = acabamentoAmostraAux;
			try {
				acabamentoAmostraClone = (AcabamentoAmostra) acabamentoAmostraAux.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}

		//Cor especifica Acabamento
		listaCorAcabamentoAmostra = new ArrayList<CorAcabamentoAm>();
		List<CorAcabamentoAm> listaAux = facadeAcesso.getBuscaUmaCorAcabamentoAmostra(corAmostra.getId());
		CorAcabamentoAm corAcabamentoAmClone = new CorAcabamentoAm();
		if (listaAux != null) {
			listaCorAcabamentoAmostra = listaAux;
			try {
				corAcabamentoAmClone = (CorAcabamentoAm) listaAux.get(0).clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}else {
			Messages.addGlobalError("Por favor, contate Administrador-Amostracontroller-line:638, informando os dados!");
			return;
		}

		parametros.setPricord(true);

		
	}
	public void deleteCor(CorAmostra corDeleteAmostra) {
		if (corDeleteAmostra == null) {
			Messages.addGlobalError("Não há Cor(es) Cadastrada(s) !");
			return;
		}

		/*
		 * Para Deletar Cor a)Remover corAcabamento,CorCorte,CorCostura,CorSolado
		 * b)Remover tabela Multi c)Remover tabela CorAmostra
		 * 
		 * 1) Verificar se a cor tem ficha de producao,caso tenha, solicitar primeiro
		 * cancelamento na producao 2) Cancelamento na producao, devera ter uma
		 * justificativa, para efetu-la, que ficara vinculada a amostra de Origem 3)
		 * Verificar se tem ficha de confirmação, caso contrario nao pode ser efetuado.
		 * 4) Se tiver data de entrega de producao, nao pode ser cancelada 5) Sem
		 * producao,efetua cancelamento normal de todas
		 */

		amostra = new Amostra();
		amostra = amostraDao.find(corDeleteAmostra.getAmostraId());
		// Observar que aqui, se a cor for liberada,podera ser cancelada,este teste deve
		// ser feito
		// quando houver modulo atelier
		//--Testa se tem ficha producao, primeiros testes
		if (amostra.getDataLiberacaoProducao() != null) {
			Messages.addGlobalError("Amostra em Produção!!!, não pode ser cancelada qualquer cor!");
			return;
		}
		fichaProducao = new FichaProducao();
		fichaProducao = facadeAcesso.buscaCoramostraProducao(corDeleteAmostra.getId());
		if (fichaProducao != null && fichaProducao.getLiberadoalteraramostra().name().equals("L")){
			Messages.addGlobalError("Não é possivel Excluir Cor, Ficha Produção em circulação,Avise Almoxarifado!");
			return;
		}
		if (fichaProducao != null && !fichaProducao.getLiberadoalteraramostra().name().equals("L") && fichaProducao.getSituacao().name().equals("N")){
			Messages.addGlobalError("Não é possivel Excluir Cor,Ficha Produção,Não está liberada !");
			return;
		}
		//-------------------------------------------------
		//
		// adiciona pares cancelados,subtrai do total da ficha
		if (amostra.getParCancelado() != null) {
			amostra.setParCancelado(amostra.getParCancelado().add(corDeleteAmostra.getTotalPar()));
		} else {
			amostra.setParCancelado(corDeleteAmostra.getTotalPar());
		}

		amostra.setPares(amostra.getPares().subtract(corDeleteAmostra.getTotalPar()));

		//
		// Cancelar tabela multi , Cor e Cabedal
		//
		List<CorAmostraMulti> listaCorMultiAux = facadeAcesso.getBuscaCorAmostraMulti(amostra.getAmostraId(),
				corDeleteAmostra.getSequenciaCorAmostra());
		if (listaCorMultiAux.size() != 0) {
			try {
				corAmostraMultidao.deleteCorMulti(listaCorMultiAux);
				renovaLazy();
			} catch (RuntimeException ex) {
				Messages.addGlobalError("Não foi possivel Excluir Combinação Multi para cor Selecionada!");
				ex.printStackTrace();
				return;
			}
		}
		// Cabedais da Multi
		List<CorCabedalAm> listaCabedalMultiAux = facadeAcesso
				.getBuscaAmostraCabedais(corDeleteAmostra.getAmostra().getAmostraId(), corDeleteAmostra.getId());
		if (listaCabedalMultiAux.size() != 0) {
			try {
				corAmostraMultidao.deleteCabedalMulti(listaCabedalMultiAux);
				renovaLazy();
			} catch (RuntimeException ex) {
				Messages.addGlobalError("Não foi possivel Excluir Combinação Multi para cor Selecionada!");
				ex.printStackTrace();
				return;
			}
		}
		//
		// Primeira Etapa Cancelamento Combinações
		// Busca Cor Corte para Cancelamento
		//
		try {
			CorCorteAm corCorteAux = facadeAcesso
					.getBuscaPosicaoCorCorteAmostra(corDeleteAmostra.getId());
			if (corCorteAux != null) {
				corCorteAmostraDao.delete(corCorteAux.getId());
			}
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Excluir Cor/Combinação Corte!");
			ex.printStackTrace();
			return;
		}

		// Busca Cor Costura para Cancelamento
		try {
			CorCosturaAm corCosturaAux = facadeAcesso.getBuscaCorPosicaoCosturaAmostra(corDeleteAmostra.getId());
			if (corCosturaAux != null) {
				corCosturaAmostraDao.delete(corCosturaAux.getId());
			}
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Excluir Cor/Combinação Costura!");
			ex.printStackTrace();
			return;
		}

		// Busca Cor Solado para Cancelamento

		try {
			CorConstrucaoAm corSoladoAux = facadeAcesso.getBuscaPosicaoCorConstrucaoAmostra(
					corDeleteAmostra.getId());
			if (corSoladoAux != null) {
				corSoladoAmostraDao.delete(corSoladoAux.getId());
			}
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Excluir Cor/Combinação Solado!");
			ex.printStackTrace();
			return;
		}

		// Busca Cor Acabamento para Cancelamento
		try {
			CorAcabamentoAm corAcabamentoAux = facadeAcesso.getBuscaPosicaoCorAcabamentoAmostra(
					corDeleteAmostra.getId());
			if (corAcabamentoAux != null) {
				corAcabamentoAmostraDao.delete(corAcabamentoAux.getId());
			}
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Excluir Cor/Combinação Acabamento!");
			ex.printStackTrace();
			return;
		}
		// Atualiza Dados Amostra,Cancelamento da cor Tabela Cor Amostra
		try {
			amostraDao.update(amostra);
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro atualizacao Amostras/Avise Administrador!");
			ex.printStackTrace();
		}
		try {
			corAmostraNovaDao.delete(corDeleteAmostra.getId());
			listaCoresCadastradas = new ArrayList<>();
			listaCoresCadastradas = facadeAcesso.getBuscaCoresAmostra(amostra.getAmostraId());
			Messages.addGlobalInfo("Cor Cancelada com Sucesso !");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Excluir Cor/Combinação Acabamento!");
			ex.printStackTrace();
			return;
		}
		// atualiza nova situacao de pares da Amostra


	}

	public void liberaMultiCor() {
		// adicionado em 30/12
		operacao = 0;
		//
		facadeView.inicializaCor(operacao);
		parametros.setAbacor(false);
		parametros.setBotao1(true);
		parametros.setBotao2(false);
		parametros.setBotao3(false);
		parametros.setBotao4(false);
		parametros.setBotao5(false);
		parametros.setBotao6(false);
		parametros.setBtnfecha(true);
		parametros.setHabilita1(false);
		parametros.setHabilita2(false);
		parametros.setHabilita3(false);
		parametros.setHabilita4(false);
		parametros.setHabilita5(false);
		parametros.setHabilita6(false);
		linha1 = 0;
		linha2 = 1;
		linha3 = 2;
		linha4 = 3;
		linha5 = 4;
		linha6 = 5;
	}

	public void duplicaAmostra(Amostra amostradup) throws CloneNotSupportedException {

		amostraClone = new Amostra();
		duplica = false;
		this.amostra = amostradup;
		// Observar caraqcteristicas da amostra
		operacao = 3;
		amostraClone = (Amostra) amostradup.clone();
		// adicionado em 02/09
		amostraClone.setPrioridadeProducao(null);
		amostraClone.setDtxfct(null);
		amostraClone.setGerada(false);
		amostraClone.setUsuarioStamp(usuarioLogado.getUsuariologado().getUsuario());
		amostraClone.setDataStamp(amostraDao.getDateLocalTime());
		amostraClone.setDataSolicitacao(amostraDao.getLocalDate());
		facadeView.setInformaReferencia(amostraClone.getReferencia().toString().trim());

	}

	//
	// Metodo para replicacao de amostra Nova
	//
	public void saveDuplicacao() {
		// Amostra
		if (amostraClone.getDtxfct() == null) {
			Messages.addGlobalError("Amostra Para:, Deve ser informado uma Data!");
			return;
		}
		Boolean verificacao = amostraClone.getDataSolicitacao().isAfter(amostraClone.getDtxfct());
		if (verificacao) {
			Messages.addGlobalError("Data Prometida deve ser Maior ou Igual, data solicitacao!");
			return;
		}
		auxAmostra = new Amostra();
		//
		// Cores Amostras
//		listCoresDup = new ArrayList<>();

		try {
			// Duplica ficha
			amostraClone.setAmostraId(null);
			auxAmostra = amostraClone;
			auxAmostra.setPrioridadeProducao(PrioridadeProducao.X);
			auxAmostra.setDataLiberacaoProducao(null);
			auxAmostra = amostraDao.update(auxAmostra);
			// Duplica Cores Ficha
			List<CorAmostra> auxCores = facadeAcesso.getBuscaCoresAmostra(amostra.getAmostraId());
			List<CorAmostra> auxCoresFinal = new ArrayList<>();
			if (auxCores.size() != 0) {
				for (CorAmostra auxListaCores : auxCores) {
					CorAmostra cloneaux = (CorAmostra) auxListaCores.clone();
					cloneaux.setId(null);
					cloneaux.setAmostra(auxAmostra);
					cloneaux.setAmostraId(auxAmostra.getAmostraId());
					cloneaux.setUsuarioStamp(auxAmostra.getUsuarioStamp());
					cloneaux.setDataStamp(auxAmostra.getDataStamp());
					cloneaux.setDesenvolveramostra(SimNao.S);
					cloneaux.setProducao(false);
					auxCoresFinal.add(cloneaux);
				}
			}
			corAmostraNovaDao.saveCorAmostraDup(auxCoresFinal);
			// Duplica Cores Multi
			List<CorAmostra> auxCoresNovas = facadeAcesso.getBuscaCoresAmostra(auxAmostra.getAmostraId());
			if (auxCoresNovas.size() != 0) {
				List<CorAmostraMulti> auxMultiCores = facadeAcesso.getBuscaTodosCorAmostraMulti(amostra.getAmostraId());
				CorAmostraMulti varAux = new CorAmostraMulti();
				varAux = (CorAmostraMulti) auxMultiCores.get(0).clone();
				Integer varJ = 0;
				List<CorAmostraMulti> auxMultiFinal = new ArrayList<>();
				for (int i = 0; i < auxCoresNovas.size(); i++) {

					for (int j = varJ; j < auxMultiCores.size(); j++) {
						CorAmostraMulti auxMulti = new CorAmostraMulti();
						auxMulti = (CorAmostraMulti) auxMultiCores.get(j).clone();
						if ((auxMulti.getAmostra().getAmostraId() == varAux.getAmostra().getAmostraId())
								&& (auxMulti.getCorAmostra().getId() == varAux.getCorAmostra().getId())) {
							auxMulti.setAmostra(auxAmostra);
							auxMulti.setCorAmostra(auxCoresNovas.get(i));
							auxMulti.setCormultiid(null);
							auxMultiFinal.add(auxMulti);
						} else {
							varAux = new CorAmostraMulti();
							varAux = (CorAmostraMulti) auxMultiCores.get(j).clone();
							varJ = j;
							break;
						}

					}
				}
				// Gravar replicacao Tabela Multi Cor(es)
				corAmostraMultidao.updateCorMulti(auxMultiFinal);
				// Corte
				CorteAmostra corteAmostra = new CorteAmostra();
				CorteAmostra corteAmostraAux = facadeAcesso.getBuscaCorteAmostra(amostra.getAmostraId());
				Optional<CorteAmostra> corteAmostraPresente = Optional.empty();
				corteAmostraPresente = Optional.ofNullable(corteAmostraAux);
				// Clona para executar duplicacao com novo id amostra
				if (corteAmostraPresente.isPresent()) {
					corteAmostraAux.setAmostra(auxAmostra);
					corteAmostraAux.setAmostraid(auxAmostra.getAmostraId());
					corteAmostraAux.setDataStamp(auxAmostra.getDataStamp());
					corteAmostraAux.setUsuariostamp(auxAmostra.getUsuarioStamp());
					corteAmostra = (CorteAmostra) corteAmostraAux.clone();
					corteAmostraDao.update(corteAmostra);
				}
				// Monta lista de clones para aplicacao na Cor corte
				listaCorCorteAmostra = new ArrayList<CorCorteAm>();
				List<CorCorteAm> listaAuxCorte = facadeAcesso.getBuscaCorCorteAmostra(amostra.getAmostraId());
				if (listaAuxCorte.size() != 0) {
					corCorteAmostra = new CorCorteAm();
					CorCorteAm varAuxCorte = new CorCorteAm();
					varAuxCorte = (CorCorteAm) listaAuxCorte.get(0).clone();
					varJ = 0;
					for (int i = 0; i < auxCoresNovas.size(); i++) {

						for (int j = varJ; j < listaAuxCorte.size(); j++) {
							CorCorteAm auxCorCorte = new CorCorteAm();
							auxCorCorte = (CorCorteAm) listaAuxCorte.get(j).clone();
							if ((auxCorCorte.getAmostra().getAmostraId() == varAuxCorte.getAmostra().getAmostraId())
									&& (auxCorCorte.getCoramostra().getId() == varAuxCorte.getCoramostra().getId())) {
								auxCorCorte.setAmostra(auxAmostra);
								auxCorCorte.setCoramostra(auxCoresNovas.get(i));
								auxCorCorte.setId(null);
								listaCorCorteAmostra.add(auxCorCorte);
							} else {
								varAuxCorte = new CorCorteAm();
								varAuxCorte = (CorCorteAm) listaAuxCorte.get(j).clone();
								varJ = j;
								break;
							}

						}
					}
				}
				// Salvar replicacao Cor(es) Corte/Amostra
				corCorteAmostraDao.updateCorCorteAmostra(listaCorCorteAmostra);
				//
				// Costura
				CosturaAmostra costuraAmostra = new CosturaAmostra();
				CosturaAmostra costuraAmostraAux = facadeAcesso.getBuscaCosturaAmostra(amostra.getAmostraId());
				Optional<CosturaAmostra> costuraAmostraPresente = Optional.empty();
				costuraAmostraPresente = Optional.ofNullable(costuraAmostraAux);
				// Clona para executar duplicacao com novo id amostra
				if (costuraAmostraPresente.isPresent()) {
					costuraAmostraAux.setAmostra(auxAmostra);
					costuraAmostraAux.setDataStamp(auxAmostra.getDataStamp());
					costuraAmostraAux.setUsuariostamp(auxAmostra.getUsuarioStamp());
					costuraAmostra = (CosturaAmostra) costuraAmostraAux.clone();
					costuraAmostraDao.update(costuraAmostra);
				}
				// Monta lista de clones para aplicacao na Cor Costura
				listaCorCosturaAmostra = new ArrayList<CorCosturaAm>();
				List<CorCosturaAm> listaAuxCostura = facadeAcesso.getBuscaCorCosturaAmostra(amostra.getAmostraId());
				if (listaAuxCostura.size() != 0) {
					corCosturaAmostra = new CorCosturaAm();
					CorCosturaAm varAuxCostura = new CorCosturaAm();
					varAuxCostura = (CorCosturaAm) listaAuxCostura.get(0).clone();
					varJ = 0;
					for (int i = 0; i < auxCoresNovas.size(); i++) {

						for (int j = varJ; j < listaAuxCostura.size(); j++) {
							CorCosturaAm auxCorCostura = new CorCosturaAm();
							auxCorCostura = (CorCosturaAm) listaAuxCostura.get(j).clone();
							if ((auxCorCostura.getAmostra().getAmostraId() == varAuxCostura.getAmostra().getAmostraId())
									&& (auxCorCostura.getCoramostra().getId() == varAuxCostura.getCoramostra()
											.getId())) {
								auxCorCostura.setAmostra(auxAmostra);
								auxCorCostura.setCoramostra(auxCoresNovas.get(i));
								auxCorCostura.setId(null);
								listaCorCosturaAmostra.add(auxCorCostura);
							} else {
								varAuxCostura = new CorCosturaAm();
								varAuxCostura = (CorCosturaAm) listaAuxCostura.get(j).clone();
								varJ = j;
								break;
							}

						}
					}
				}
				// Salvar Cor(es) replicacao Costura
				corCosturaAmostraDao.updateCorCosturaAmostra(listaCorCosturaAmostra);
				//
				// Solado
				// Monta lista de clones para aplicacao na Cor corte
				listaCorSoladoAmostra = new ArrayList<CorConstrucaoAm>();
				List<CorConstrucaoAm> listaAuxSolado = facadeAcesso.getBuscaCorSoladoAmostra(amostra.getAmostraId());
				if (listaAuxSolado.size() != 0) {
					corSoladoAmostra = new CorConstrucaoAm();
					CorConstrucaoAm varAuxConstrucao = new CorConstrucaoAm();
					varAuxConstrucao = (CorConstrucaoAm) listaAuxSolado.get(0).clone();
					varJ = 0;
					for (int i = 0; i < auxCoresNovas.size(); i++) {

						for (int j = varJ; j < listaAuxCostura.size(); j++) {
							CorConstrucaoAm auxCorConstrucao = new CorConstrucaoAm();
							auxCorConstrucao = (CorConstrucaoAm) listaAuxSolado.get(j).clone();
							if ((auxCorConstrucao.getAmostra().getAmostraId() == varAuxConstrucao.getAmostra()
									.getAmostraId())
									&& (auxCorConstrucao.getCoramostra().getId() == varAuxConstrucao.getCoramostra()
											.getId())) {
								auxCorConstrucao.setAmostra(auxAmostra);
								auxCorConstrucao.setCoramostra(auxCoresNovas.get(i));
								auxCorConstrucao.setId(null);
								listaCorSoladoAmostra.add(auxCorConstrucao);
							} else {
								varAuxConstrucao = new CorConstrucaoAm();
								varAuxConstrucao = (CorConstrucaoAm) listaAuxSolado.get(j).clone();
								varJ = j;
								break;
							}

						}
					}
				}
				// Salvar cor(es) replicacao para o Solado
				corSoladoAmostraDao.updateCorSoladoAmostra(listaCorSoladoAmostra);
				//
				// Acabamento
				AcabamentoAmostra acabamentoAmostra = new AcabamentoAmostra();
				AcabamentoAmostra acabamentoAmostraAux = facadeAcesso.getBuscaAcabamentoAmostra(amostra.getAmostraId());
				Optional<AcabamentoAmostra> acabamentoAmostraPresente = Optional.empty();
				acabamentoAmostraPresente = Optional.ofNullable(acabamentoAmostraAux);
				// Clona para executar duplicacao com novo id amostra
				if (acabamentoAmostraPresente.isPresent()) {
					acabamentoAmostraAux.setAmostra(auxAmostra);
					acabamentoAmostraAux.setDataStamp(auxAmostra.getDataStamp());
					acabamentoAmostraAux.setUsuariostamp(auxAmostra.getUsuarioStamp());
					acabamentoAmostra = (AcabamentoAmostra) acabamentoAmostraAux.clone();
					acabamentoAmostraDao.update(acabamentoAmostra);
				}
				// Monta lista de clones para aplicacao na Cor Costura
				listaCorAcabamentoAmostra = new ArrayList<CorAcabamentoAm>();
				List<CorAcabamentoAm> listaAuxAcabamento = facadeAcesso
						.getBuscaCorAcabamentoAmostra(amostra.getAmostraId());
				if (listaAuxAcabamento.size() != 0) {
					corAcabamentoAmostra = new CorAcabamentoAm();
					CorAcabamentoAm varAuxAcabamento = new CorAcabamentoAm();
					varAuxAcabamento = (CorAcabamentoAm) listaAuxAcabamento.get(0).clone();
					varJ = 0;
					for (int i = 0; i < auxCoresNovas.size(); i++) {

						for (int j = varJ; j < listaAuxAcabamento.size(); j++) {
							CorAcabamentoAm auxCorAcabamento = new CorAcabamentoAm();
							auxCorAcabamento = (CorAcabamentoAm) listaAuxAcabamento.get(j).clone();
							if ((auxCorAcabamento.getAmostra().getAmostraId() == varAuxAcabamento.getAmostra()
									.getAmostraId())
									&& (auxCorAcabamento.getCoramostra().getId() == varAuxAcabamento.getCoramostra()
											.getId())) {
								auxCorAcabamento.setAmostra(auxAmostra);
								auxCorAcabamento.setCoramostra(auxCoresNovas.get(i));
								auxCorAcabamento.setId(null);
								listaCorAcabamentoAmostra.add(auxCorAcabamento);
							} else {
								varAuxAcabamento = new CorAcabamentoAm();
								varAuxAcabamento = (CorAcabamentoAm) listaAuxAcabamento.get(j).clone();
								varJ = j;
								break;
							}

						}
					}
				}
				// Gravar replicacao de cor(es) Acabamento
				corAcabamentoAmostraDao.updateCorAcabamentoAmostra(listaCorAcabamentoAmostra);
				// Cabedal - tabela complementar ao Cabedal - replicar
				// Duplica Cores Ficha
				List<CorCabedalAm> auxCoresCabedal = facadeAcesso.getBuscaTodosCabedaisAmostra(amostra.getAmostraId());
				List<CorCabedalAm> listaCorCabedalFinal = new ArrayList<>();
				if (auxCoresCabedal.size() != 0) {
					for (CorCabedalAm auxListaCabedal : auxCoresCabedal) {
						CorCabedalAm cloneCabAux = (CorCabedalAm) auxListaCabedal.clone();
						cloneCabAux.setId(null);
						cloneCabAux.setAmostra(auxAmostra);
						cloneCabAux.setDatastamp(auxAmostra.getDataStamp());
						cloneCabAux.setUsuariostamp(auxAmostra.getUsuarioStamp());
						listaCorCabedalFinal.add(cloneCabAux);
					}
				}
				corCabedalAmostraDao.updateCorCabedalAmostra(listaCorCabedalFinal);

			}
			setDuplica(true);
			renovaLazy();
			Messages.addGlobalInfo("Replicação Nova amostra com sucesso !");
			return;
		} catch (Exception ex) {
			Messages.addGlobalError("Não foi possivel Duplicar Ficha :" + amostra.getAmostraId());
			ex.printStackTrace();
			return;
		}
	}

	public void inicializaConsulta() {
		// amostra = new Amostra();
		iniSolicitacao = null;
		finSolicitacao = null;
		iniamostrap = null;
		finamostrap = null;
		inisaidaf = null;
		finsaidaf = null;
		iniliberap = null;
		finliberap = null;
		informaCor = "";
		informaCorp = "";
//		operacaoPosterior = 2; comentado em 14/04,teste da necessidade codigo 2

	}

	@SuppressWarnings("unused")
	private Map<Object, Object> componentStates = new HashMap<Object, Object>();

	public String getActiveIndexes() {
		return activeIndexes;
	}

	public void setActiveIndexes(String activeIndexes) {
		this.activeIndexes = activeIndexes;
	}

	public void activeAllIndexes() {
		if (!accordionTabs.isEmpty()) {
			int tabs = accordionTabs.size();
			String indexes = null;
			for (int i = 0; i < tabs; i++) {
				indexes += i + ",";
			}
			// delete the last ',' character
			indexes = indexes.substring(0, indexes.length() - 1);

			setActiveIndexes(indexes);
		}
	}

	public void inactiveAllIndexes() {
		setActiveIndexes("");
	}

	public void onTabChange(TabChangeEvent event) {
//	        FacesMessage msg = new FacesMessage("", "Ativo: " + event.getTab().getTitle());
//	        FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void verificaBloqueio() {

	}

	public void verificaAntesSave() {
		Boolean erro = true;
		Boolean verificacao = true;
		mostraListaProducao = false;
		try {

			if (operacao == 0) {
				// consistencia Dados Capa Amostra
				if (amostra.getTipo() == null) {
					Messages.addGlobalError("Informe Tipo de amostra !");
					erro = false;
				}
				if (amostra.getCliente() == null) {
					Messages.addGlobalError("Selecione Cliente!");
					erro = false;
				}
				if (amostra.getFabrica() == null) {
					Messages.addGlobalFatal("Selecione Fábrica!");
					erro = false;
				}
				if (amostra.getReferencia() == null) {
					Messages.addGlobalError("Selecione Referência!");
					erro = false;
				}
				if (amostra.getDtxfct() == null) {
					Messages.addGlobalError("Amostra Para:, Deve ser informado uma Data!");
					erro = false;
				}
				if (amostra.getComponente() == null) {
					Messages.addGlobalError("Selecione Produto !");
					erro = false;
				}
				if (amostra.getEstacao() == null) {
					Messages.addGlobalError("Selecione Estação !");
					erro = false;
				}
				if (!erro) {
					parametros.setAbacor(false);
					return;
				} else {
					parametros.setAbacor(true);
				}
			}

			// Se opcao for para edicao da Ficha
			if ((operacao == 2) || (operacao == 1)) {
				// Verificacao da Prioridade , se for primeira alteracao da Prioridae guarda
				// data Stamp - Liberacao Producao
				
				if (((amostra.getPrioridadeProducao().name().equals("N")
						|| ((amostra.getPrioridadeProducao().name().equals("U"))))
						&& (amostraClone.getPrioridadeProducao().name().equals("X")))) {
					if (amostra.getCoresAmostra().size() == 0) {
			    		addMessage(FacesMessage.SEVERITY_INFO, "Não é possivel Alterar, pois não há Cor(es) Cadastrada(s)!", "");
						//						Messages.addGlobalWarn("");
						amostra.setPrioridadeProducao(amostraClone.getPrioridadeProducao());
						
						return;	
					}
					if (amostra.getDataLiberacaoProducao() == null) {
						amostra.setDataLiberacaoProducao(amostraDao.getDateLocalTime());
					}
				}
				 
				if ((amostra.getPrioridadeProducao().equals(PrioridadeProducao.X) || amostra.getPrioridadeProducao().equals(PrioridadeProducao.U)) && (amostraClone.getPrioridadeProducao().equals(PrioridadeProducao.N))) {
					amostra.setPrioridadeProducao(amostraClone.getPrioridadeProducao());
					addMessage(FacesMessage.SEVERITY_ERROR, "Esta ficha já foi liberada, não é possível, alterar Prioridade!", "");
					return;
				}
			}

			// Consistencia de Datas
			// Data Prevista para amostra deve ser maior ou = a Solicitada
			// Data Saida de Fabrica deve ser maior ou = a solicitada

			verificacao = amostra.getDataSolicitacao().isAfter(amostra.getDtxfct());

			if (verificacao) {
				Messages.addGlobalError("Data Prometida deve ser Maior ou Igual, data solicitacao!");
				return;
			}

			if (amostra.getDataEntrega() != null) {
				verificacao = amostra.getDtxfct().isAfter(amostra.getDataEntrega());
				if (verificacao) {
					Messages.addGlobalError("Data da entrega,deve ser Maior ou Igual a Data Prommetida !");
					return;
				}
			}

			if (amostra.getMercado() == null) {
				Messages.addGlobalError("Por favor, Selecione Mercado para esta Ficha !");
			}

			if (amostra.getComponente() == null) {
				Messages.addGlobalError("Por favor, informe um Produto para esta Amostra !");
			}
			// Se for inclusao, e ja for liberado a ficha para producao,atribui data e hora
			if ((operacao == 0) || (operacao == 1)) {
				if ((!amostra.getPrioridadeProducao().equals(PrioridadeProducao.X))&& (!amostra.getPrioridadeProducao().equals(PrioridadeProducao.T))) {
					amostra.setDataLiberacaoProducao(amostraDao.getDateLocalTime());
					amostra.setGerada(false);
				}
			}
			// guarda Id Criado na variavel = amostra
			amostra.setUsuarioStamp(usuarioLogado.getUsuariologado().getUsuario());
			amostra.setDataStamp(amostraDao.getDateLocalTime());
			amostra.setMercado(amostra.getMercado());
			Boolean mAux = false;
			if ((amostra != amostraClone) && (operacao == 1))  {

				mAux = logsControllerAmostrasNovas.logAmostrasNovasEdicao(amostra, amostraClone);
			}
			amostra.setLog(mAux);
			amostra = amostraDao.update(amostra);
			Messages.addGlobalInfo("Operação realizada com Sucesso !");
			if (mAux) {
				listaLogs = facadeAcesso.getBuscaLogsAmostraNova(amostra.getAmostraId());
			}
			parametros.setAbacor(false);
			operacaoPosterior = 1;
			btnVisao = false;
			parametros.setBtncheck(false);
			renovaLazy();
			// Guarda ID gerado, para uso posterior nas tabelas de ligação a ficha
		} catch (Exception ex) {
			Messages.addGlobalError("Não foi possivel executar a operação Ficha de Amostra!");
			ex.printStackTrace();
			return;
		}
	}

	public void saveCor() {
		try {
//			if (operacaoPosterior == 0) {
			if (operacao == 0) {
				// Adicionar CorAmostra
				corAmostra.setDataStamp(corAmostraNovaDao.getDateLocalTime());
				corAmostra.setUsuarioStamp(amostra.getUsuarioStamp());
				corAmostra.setSequenciaCorAmostra(ultimaSequencia);
				corAmostra.setAmostraId(amostra.getAmostraId());
				corAmostra.setAmostra(amostra);
				corAmostra.setMaterial(facadeView.getMaterialFinal());
				corAmostra.setCor(facadeView.getCorPosicaoFinal());
				corAmostra = corAmostraNovaDao.update(corAmostra);
				amostra.setTemcor(true);
				// rever teste abaixo,fundamento nao esta correto
				// if
				// (corAmostra.getDesenvolveramostra().name().equals(corAmostra.getDesenvolveramostra().S)
				// && (verProduzAmostra == 0)) {
//						amostra.setGerada(false);
//						verProduzAmostra = 1;
//					}else {
//						amostra.setGerada(true);
//					}
				corCabedal.setAmostra(amostra);
				corCabedal.setCoramostra(corAmostra);
				corCabedal.setSequenciacoramostra(corAmostra.getSequenciaCorAmostra());
				corCabedal.setDatastamp(corAmostra.getDataStamp());
				corCabedal.setUsuariostamp(corAmostra.getUsuarioStamp());
				corCabedal = corCabedalAmostraDao.update(corCabedal);
				// Atualiza pares na Amostra
				if (amostra.getPares().compareTo(BigDecimal.ZERO) != 0) {
					amostra.setPares(amostra.getPares().add(corAmostra.getTotalPar()));
				} else {
					amostra.setPares(corAmostra.getTotalPar());
				}
				if ((amostra.getPargvd().compareTo(BigDecimal.ZERO) != 0)
						&& (corAmostra.getParGvd().compareTo(BigDecimal.ZERO) != 0)) {
					amostra.setPares(amostra.getPares().add(corAmostra.getTotalPar()));
				} else {
					if ((corAmostra.getParGvd().compareTo(BigDecimal.ZERO) != 0)
							&& (corAmostra.getParGvd().compareTo(BigDecimal.ZERO) != 0)) {
						amostra.setPares(corAmostra.getTotalPar());
					}
				}

				// Adicionar Multi - tabela muitos --> muitos
				facadeView.saveMultiCorAmostraNova(corAmostra, operacao);
				amostraDao.update(amostra);
				renovaLazy();
				Messages.addGlobalInfo("Material/Cor Cadastrados com Sucesso!");
				inicializaCor();
				parametros.setBtnfecha(true);
				return;
			} else {
				corAmostra.setAmostraId(amostra.getAmostraId());
				corAmostra.setAmostra(amostra);
				corAmostra.setMaterial(facadeView.getMaterialFinal());
				corAmostra.setCor(facadeView.getCorPosicaoFinal());
				corAmostra.setDataStamp(corAmostraNovaDao.getDateLocalTime());
				corAmostra.setUsuarioStamp(usuarioLogado.getUsuariologado().getUsuario());
				if (corAmostra.getTotalPar().signum() < 0) {
					Messages.addGlobalError("Informe Quantidade Pares Válido!");
					return;
				}
				if (corAmostra.getTotalPar().signum() == 0) {
					Messages.addGlobalWarn("Pares igual a Zero, alterado situacao para não Produzir!");
					corAmostra.setDesenvolveramostra(SimNao.N);
				}
				BigDecimal varDiferenca;
				BigDecimal novoPares;
				novoPares = BigDecimal.ZERO;
				varDiferenca = BigDecimal.ZERO;
				if (corAmostraClone != null) {
					if (getCorAmostraClone().getTotalPar().compareTo(BigDecimal.ZERO) == 0) {
						corAmostraClone.setTotalPar(BigDecimal.ZERO);
					}
					// ajustar pares na Amostra
					varDiferenca = (corAmostra.getTotalPar().subtract(corAmostraClone.getTotalPar()));
					if (varDiferenca.signum() >= 0) {
						if (varDiferenca.signum() > 0) {
							if (amostra.getPares().compareTo(BigDecimal.ZERO) != 0) {
								novoPares = amostra.getPares().add(varDiferenca);
							} else {
								novoPares = varDiferenca;
							}
						} else {
							novoPares = amostra.getPares();
						}
					} else {
						varDiferenca = varDiferenca.multiply(new BigDecimal(-1));
						if (amostra.getPares().compareTo(BigDecimal.ZERO) != 0) {
							novoPares = amostra.getPares().subtract(varDiferenca);
						} else {
							novoPares = varDiferenca;
						}
					}
					amostra.setPares(novoPares);
				} else {
					if (amostra.getPares().compareTo(BigDecimal.ZERO) != 0) {
						amostra.setPares(amostra.getPares().add(corAmostra.getTotalPar()));
					} else {
						amostra.setPares(corAmostra.getTotalPar());
					}
				}
				// Ajustar parGvd na GVD
				varDiferenca = BigDecimal.ZERO;
				if (corAmostraClone != null) {
					varDiferenca = (corAmostra.getParGvd().subtract(corAmostraClone.getParGvd()));
					if (varDiferenca.signum() > 0) {
						if (amostra.getPargvd().compareTo(BigDecimal.ZERO) != 0) {
							amostra.setPargvd(amostra.getPargvd().add(varDiferenca));
						} else {
							amostra.setPargvd(corAmostra.getParGvd());
						}
					} else {
						if (varDiferenca.signum() < 0) {
							varDiferenca = varDiferenca.multiply(new BigDecimal(-1));
							if (amostra.getPargvd().compareTo(BigDecimal.ZERO) != 0) {
								amostra.setPargvd(amostra.getPargvd().subtract(varDiferenca));
							} else {
								amostra.setPargvd(corAmostra.getParGvd());
							}
						}
					}
					//
					// Atualiza/inclui Cores amostra
					//
					corAmostraNovaDao.update(corAmostra);
					amostra.setTemcor(true);
					amostraDao.update(amostra);
					//
					// Inclui ou alterar Complemento Cabedal, através campo na Cor CABEDAL
					//
					if ((corCabedal != null) && (!corCabedal.getTexto().trim().isEmpty())) {
						if (!corCabedal.getTexto().trim().equals(corCabedalClone.getTexto().trim())) {
							corCabedal.setAmostra(amostra);
							corCabedal.setCoramostra(corAmostra);
							corCabedal.setDatastamp(corCabedalAmostraDao.getDateLocalTime());
							corCabedal.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
							corCabedalAmostraDao.update(corCabedal);
						}
					} else {
						if (corCabedalClone.getId() != null) {
							if ((corCabedal != null) && (corCabedal.getTexto().trim().isEmpty())) {
								corCabedalAmostraDao.delete(corCabedal.getId());
							}
						}
					}
					facadeView.saveMultiCorAmostraNova(corAmostra, operacao);
					Messages.addGlobalInfo("Material/Cor Alterado com Sucesso!");
					inicializaCor();
				}
				renovaLazy();
			}
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel incluir Cor !");
			ex.printStackTrace();
			return;
		}
	}

	// Cancelar Ficha
	public void delete(Amostra amostra) {
		// Impementar
	}

//	public void referenciaSelecionada(LivroReferencia referenciaselecionada) {
//
//	}

	public void imprimiAmostra(Amostra amostra) {

	}

	public void LocalizaFiltroAmostra() {

	}

	public void referenciaSelecionada(SelectEvent event) {
		livroReferencia = new LivroReferencia();
		livroReferencia = (LivroReferencia) event.getObject();
		// Inclusao/alteracao
		if (operacao != 3) {
			amostra.setLivroReferencia(livroReferencia);
			amostra.setAbreviacao(livroReferencia.getAbreviacao());
			amostra.setReferencia(livroReferencia.getReferencia());
			amostra.setVersaoRefer(livroReferencia.getVersaorefer());
			amostra.setConstrucaoNome(livroReferencia.getConstrucaonome());
			amostra.setVersao(livroReferencia.getVersao());
			amostra.setReferenciaForma(livroReferencia.getReferenciaforma());
			amostra.setConstrucao(livroReferencia.getConstrucao());
		}
		// Duplicacao
		if (operacao == 3) {
			amostraClone.setLivroReferencia(livroReferencia);
			amostraClone.setAbreviacao(livroReferencia.getAbreviacao());
			amostraClone.setReferencia(livroReferencia.getReferencia());
			amostraClone.setVersaoRefer(livroReferencia.getVersaorefer());
			amostraClone.setConstrucaoNome(livroReferencia.getConstrucaonome());
			amostraClone.setVersao(livroReferencia.getVersao());
			amostraClone.setReferenciaForma(livroReferencia.getReferenciaforma());
			amostraClone.setConstrucao(livroReferencia.getConstrucao());
		}
	}

	public void clienteSelecionado(SelectEvent<?> event) {
		cliente = new Cliente();
		cliente = (Cliente) event.getObject();
		amostra.setCliente(cliente);
		amostra.setSucCliente(cliente.getSucinto());
		if (amostra.getCliente() != null) {
			listaDestinoAmCf = new ArrayList<>();
			if (amostra.getCliente().getGrpclienteinvoice() != null) {
				// listaDestinoAmCf =
				// facadeAcesso.buscaDestinoAmCf(amostra.getCliente().getGrpclienteinvoice().getGrupoclienteinvoiceid());
				buscaListaDestinoAm(amostra);
			}
		}
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

	public void produtoSelecionado(SelectEvent<?> event) {
		componente = new Componente();
		componente = (Componente) event.getObject();
		amostra.setComponente(componente);
	}

	public void modeloSelecionada(SelectEvent<?> event) {
		modelo = new Modelo();
		modelo = (Modelo) event.getObject();

	}

	public void marcaSelecionada(SelectEvent<?> event) {
		marcaCliente = new MarcaCliente();
		marcaCliente = (MarcaCliente) event.getObject();
		amostra.setMarcaCliente(marcaCliente);
	}

	public void estacaoSelecionada(SelectEvent<?> event) {
		estacaoCliente = new Estacao();
		estacaoCliente = (Estacao) event.getObject();
		amostra.setMarcaCliente(marcaCliente);
		amostra.setEstacao(estacaoCliente);
	}

	public void materialSelecionado(SelectEvent<?> event) {
		material = new Material();
		material = (Material) event.getObject();
		listaCoresComposicao = facadeView.getListaMultiCor();
		listaCoresComposicao.get(sequencialCor).setAmostra(amostra);
		listaCoresComposicao.get(sequencialCor).setMaterial(material);
		facadeView.getListaMultiCor().get(sequencialCor).setMaterial(material);
		facadeView.getListaMultiCor().get(sequencialCor).setMatNome(material.getNome());

	}

	public void corSelecionada(SelectEvent<?> event) {
		Cor corEscolha = new Cor();
		corEscolha = (Cor) event.getObject();
		listaCoresComposicao.get(sequencialCor).setCor(corEscolha);
		facadeView.getListaMultiCor().get(sequencialCor).setCor(corEscolha);
		facadeView.getListaMultiCor().get(sequencialCor).setCorNome(corEscolha.getNome());
	}

	// retirado throw exepction da linaha 688 e adicionado try
	public StreamedContent ResizeImagem(Amostra amostra) throws IOException {
		DefaultStreamedContent streamedcontent = null;
		if (amostra.getLivroReferencia() == null) {
			// alterado teste para == 1, antes != 2
			if (operacaoPosterior == 1) {
				Messages.addGlobalError("Informe Referência, para apresentação da Imagem !");
				// adicionado em 26/05
			} else {
				operacaoPosterior = 0;
			}
			return streamedcontent;
		}
		if (amostra.getAmostraId() != null) {
			List<ImagemReferencia> aux = facadeAcesso.existeImagem(amostra.getLivroReferencia().getLivroreferenciaid());
			if (aux.size() > 0) {
				if (aux.get(0).getFoto() != null) {
					String mime = aux.get(0).getExtensao().trim();
					String nome = aux.get(0).getNomearquivo().trim();
					altura = aux.get(0).getImheight().trim();
					largura = aux.get(0).getImwidth().trim();
					byte[] foto = aux.get(0).getFoto();
					streamedcontent = DefaultStreamedContent.builder().name(nome).contentType(mime)
							.stream(() -> new ByteArrayInputStream(foto)).build();
					return streamedcontent;
				}

				return new DefaultStreamedContent();


			} else {
				Messages.addGlobalError("Imagem não encontrada !");
				return new DefaultStreamedContent();
			}
		} else {
			return new DefaultStreamedContent();
		}
	}

	public void checagemPreVisualizacao() {
		//
		// consistencia pagina de entrada da cor,campos obrigatorios
		// Tipo Material,pé se for pares quebrado,pares,size
		// Testa uso do Pe

		Optional<CorAmostra> corAmostraOpt = Optional.empty();
		corAmostraOpt = Optional.ofNullable(corAmostra);
		if (!corAmostraOpt.isPresent()) {
			Messages.addGlobalError("Informe dados necessarios !");
			return;

		}
		// Teste Size
		if ((corAmostra.getSizeCor() == null) || (corAmostra.getSizeCor().isEmpty())) {
			Messages.addGlobalError("Informe Size,informacao Obrigatória !");
			return;
		}
		// Teste Pares
		if (corAmostra.getTotalPar() == null) {
			Messages.addGlobalError("É necessario informar total de Pares!");
			return;

		} else {
			if (corAmostra.getTotalPar().compareTo(BigDecimal.ZERO) == 0) {
				Messages.addGlobalError("É necessario informar total de Pares!");
				return;
			}
		}
		Integer vlrPares = Integer.valueOf(corAmostra.getTotalPar().intValue());
		BigDecimal diferenca = corAmostra.getTotalPar().subtract(new BigDecimal(Integer.valueOf(vlrPares)));
		// Verificar parte Fracionaria ou nao inteiro para pares da Cor
		if (diferenca.compareTo(BigDecimal.ZERO) != 0) {
			if (((diferenca.compareTo(BigDecimal.ZERO)) != 0) && (diferenca.compareTo(new BigDecimal(0.5)) != 0)) {
				Messages.addGlobalError("Quantidade não inteiras,a parte fracionaria não pode ser diferente de .5!");
				return;
			}
		}
		if (((diferenca.compareTo(BigDecimal.ZERO)) != 0) && (corAmostra.getPe() == null)) {
			Messages.addGlobalError("Para esta Quantidade de Pares,é necessário escolher qual o PÉ !");
			return;
		}
		if (((diferenca.compareTo(BigDecimal.ZERO)) == 0) && (corAmostra.getPe() != null)) {
			Messages.addGlobalError("Para esta Quantidade de Pares,NÃO é necessário escolher qual o PÉ !");
			return;
		}

		// testa gvd informado se maior que ttl+canc
		if (corAmostra.getParGvd() != null) {
			if (corAmostra.getParGvd().compareTo(BigDecimal.ZERO) != 0) {
				if (corAmostra.getParCancelado().compareTo(BigDecimal.ZERO) != 0) {
					if (corAmostra.getParGvd()
							.compareTo(corAmostra.getTotalPar().subtract(corAmostra.getParCancelado())) == 1) {
						Messages.addGlobalError(
								"Verifique Quantidades informadas,Pares GVD+Cancelados superior a Pares Total!");
						return;
					}
				} else {
					if (corAmostra.getParGvd().compareTo(corAmostra.getTotalPar()) == 1) {
						Messages.addGlobalError("Verifique Quantidades,Pares GVD superior a Pares Total!");
						return;
					}

				}
			}

		}

		// Teste Cancelados
		if ((corAmostra.getParCancelado().compareTo(BigDecimal.ZERO) != 0)
				&& (corAmostra.getParCancelado().compareTo(BigDecimal.ZERO) != 0)) {
			if (amostra.getDataXfcFinal() == null) {
				Messages.addGlobalError("Para Cancelar,é necessário Amostra ser Produzida !");
				return;

			} else {
				amostra.setParCancelado(amostra.getParCancelado().add(corAmostra.getParCancelado()));
			}
			if (corAmostra.getParCancelado().compareTo(BigDecimal.ZERO) != 0) {
				if (corAmostra.getParGvd().compareTo(BigDecimal.ZERO) != 0) {
					if (corAmostra.getParCancelado()
							.compareTo(corAmostra.getTotalPar().subtract(corAmostra.getParGvd())) == 1) {
						Messages.addGlobalError(
								"Verifque Quantidades informadas,Pares GVD+Cancelados superior a Pares Total!");
						return;
					}
				} else {
					if (corAmostra.getParCancelado().compareTo(corAmostra.getTotalPar()) == 1) {
						Messages.addGlobalError("Verifique Quantidades,Pares Cancelados superior a Pares Total!");
						return;
					}

				}
			}
		}

		// Verificar parte fracionaria ou nao inteiro para pares na GVD
		vlrPares = 0;
		diferenca = BigDecimal.ZERO;
		vlrPares = Integer.valueOf(corAmostra.getParGvd().intValue());
		diferenca = corAmostra.getParGvd().subtract(new BigDecimal(Integer.valueOf(vlrPares)));
		if (diferenca.compareTo(BigDecimal.ZERO) != 0) {
			if ((corAmostra.getParGvd().compareTo(BigDecimal.ZERO) != 0)
					&& (diferenca.compareTo(new BigDecimal(0.5)) != 0)) {
				Messages.addGlobalError("Parte fracionaria, Pares GVD, nao pode ser diferente de .5, Corrija");
				if (corAmostraClone != null) {
					corAmostra.setParGvd(corAmostraClone.getParGvd());
				}
				return;
			}
		}
		// Verificar parte fracionaria pares Cancelados
		vlrPares = 0;
		diferenca = BigDecimal.ZERO;
		vlrPares = Integer.valueOf(corAmostra.getParCancelado().intValue());
		diferenca = corAmostra.getParCancelado().subtract(new BigDecimal(Integer.valueOf(vlrPares)));
		if ((diferenca.compareTo(BigDecimal.ZERO) != 0)) {
			if ((corAmostra.getParCancelado().compareTo(BigDecimal.ZERO) != 0)
					&& (diferenca.compareTo(new BigDecimal(0.5)) != 0)) {
				Messages.addGlobalError("Parte fracionaria, Pares cancelados, nao pode ser diferente de .5, Corrija");
				if (corAmostraClone != null) {
					corAmostra.setParCancelado(corAmostraClone.getParCancelado());
				}
				return;
			}

		}

		ajustaMulti = facadeView.getListaMultiCor();
		Integer recebePreenchidos = VerificaPreenchidos(ajustaMulti);
		Integer mRefaz = 0;
		if (recebePreenchidos > 1) {
			ajustaPermissoes(mRefaz);
			//

			if (umaCorPrincipal == 0) {
				Messages.addGlobalError("Selecione uma Sequencia para cor Principal!");
				facadeView.setBtnVisao(false);
				return;
			}
			if (umaCorPrincipal > 1) {
				Messages.addGlobalError("Seleciona APENAS UMA sequencia para cor Principal !");
				facadeView.setBtnVisao(false);
				return;
			}
			btnVisao = true;
		} else {
			if ((ajustaMulti.get(0).getMaterial() == null) || (ajustaMulti.get(0).getCor() == null)) {
				Messages.addGlobalError("Informe Material/Cor,faltando informações!");
				btnVisao = false;
				return;
			}else {
				if (!ajustaMulti.get(0).getCorPrincipal()) {
					ajustaMulti.get(0).setCorPrincipal(true);
				}
			}

		}
		btnVisao = true;
	}

	public void ajustaPermissoes(Integer mRefaz) {
		if ((ajustaMulti.get(linha1).getMaterial() != null) || (ajustaMulti.get(linha1).getCor() != null)) {
			sequencialCor = linha1;
			ajustaMulti.get(linha1).setAmostra(amostra);
			ajustaMulti.get(linha1).setSeqCorAmostra(ultimaSequencia);
		}
		//
		if ((ajustaMulti.get(linha2).getMaterial() != null) || (ajustaMulti.get(linha2).getCor() != null)) {
			sequencialCor = linha2;
			ajustaMulti.get(linha2).setAmostra(amostra);
			ajustaMulti.get(linha2).setSeqCorAmostra(ultimaSequencia);

		}

		if ((ajustaMulti.get(linha3).getMaterial() != null) || (ajustaMulti.get(linha3).getMaterial() != null)) {
			sequencialCor = linha3;
			ajustaMulti.get(linha3).setAmostra(amostra);
			ajustaMulti.get(linha3).setSeqCorAmostra(ultimaSequencia);

		}

		if ((ajustaMulti.get(linha4).getMaterial() != null) || (ajustaMulti.get(linha4).getCor() != null)) {
			sequencialCor = linha4;
			ajustaMulti.get(linha4).setAmostra(amostra);
			ajustaMulti.get(linha4).setSeqCorAmostra(ultimaSequencia);

		}

		if ((ajustaMulti.get(linha5).getMaterial() != null) || (ajustaMulti.get(linha5).getCor() != null)) {
			sequencialCor = linha5;
			ajustaMulti.get(linha5).setAmostra(amostra);
			ajustaMulti.get(linha5).setSeqCorAmostra(ultimaSequencia);

		}

		if ((ajustaMulti.get(linha6).getMaterial() != null) || (ajustaMulti.get(linha6).getCor() != null)) {
			sequencialCor = linha6;
			ajustaMulti.get(linha6).setAmostra(amostra);
			ajustaMulti.get(linha6).setSeqCorAmostra(ultimaSequencia);

		}
		if (operacao != 1) {
			if (sequencialCor > 0) {
//				sequencialCor++;
				Integer mSequenciador = 0;
				Integer mI = 0;
				for (int i = 0; i < (sequencialCor + 1); i++) {
					if (ajustaMulti.get(i).getMaterial() == null) {
						primeiroMat = 1;
						primeiraCor = 1;
					}
					if (ajustaMulti.get(i).getCor() == null) {
						primeiraCor = 1;
						primeiroMat = 1;
					}
					mI++;
					if (primeiroMat != 0) {
						break;
					}
					if ((ajustaMulti.get(i).getMaterial() != null) && (ajustaMulti.get(i).getCor() != null)) {
						mSequenciador++;
					}
				}

				if (((primeiroMat != 0) || (primeiraCor != 0)) && (mSequenciador != mI)) {
					Messages.addGlobalError("Informe Material/Cor,faltando informações!");
					primeiroMat = 0;
					primeiraCor = 0;
					return;
				} else {
					primeiroMat = 0;
					primeiraCor = 0;
				}
			}
		}
		if (mRefaz != 0) {
			sequencialCor++;
		}

	}

	// ajusta os Parametros de botoes e habilitacoes
	public void ajustaParametros(List<CorAmostraMulti> listaMulti, Integer sequencial) {
		for (int i = 0; i < listaMulti.size(); i++) {
			if ((i == 0) && i <= sequencial) {
				parametros.setBotao1(false);
				parametros.setHabilita1(true);
			}
			if ((i == 1) && i <= sequencial) {
				parametros.setBotao2(false);
				parametros.setHabilita2(true);
			}
			if ((i == 2) && i <= sequencial) {
				parametros.setBotao3(false);
				parametros.setHabilita3(true);
			}
			if ((i == 3) && i <= sequencial) {
				parametros.setBotao4(false);
				parametros.setHabilita4(true);
			}
			if ((i == 4) && i <= sequencial) {
				parametros.setBotao5(false);
				parametros.setHabilita5(true);
			}
			if ((i == 5) && i <= sequencial) {
				parametros.setHabilita6(true);
			}
		}
	}

	public void ajustaParametrosPosInclusao(List<CorAmostraMulti> listaMultiCores) {
		Integer quantosLinhasUsados = listaMultiCores.size();
		for (int i = 0; i < listaMultiCores.size(); i++) {
			if ((i == 0) && (listaMultiCores.get(i).getMaterial() != null)) {
				parametros.setBotao1(false);
				parametros.setHabilita1(true);
				parametros.setBtnlimpa1(true);
				if (i <= quantosLinhasUsados)
					parametros.setBotao1(true);
			}
			if ((i == 1) && (listaMultiCores.get(i).getMaterial() != null)) {
				parametros.setBotao2(false);
				parametros.setHabilita2(true);
				parametros.setBtnlimpa2(true);
				if (i <= quantosLinhasUsados)
					parametros.setBotao2(true);

			}
			if ((i == 2) && (listaMultiCores.get(i).getMaterial() != null)) {
				parametros.setBotao3(false);
				parametros.setHabilita3(true);
				parametros.setBtnlimpa3(true);
				if (i <= quantosLinhasUsados)
					parametros.setBotao3(true);

			}
			if ((i == 3) && (listaMultiCores.get(i).getMaterial() != null)) {
				parametros.setBotao4(false);
				parametros.setHabilita4(true);
				parametros.setBtnlimpa4(true);
				if (i <= quantosLinhasUsados)
					parametros.setBotao4(true);
			}
			if ((i == 4) && (listaMultiCores.get(i).getMaterial() != null)) {
				parametros.setBotao5(false);
				parametros.setHabilita5(true);
				parametros.setBtnlimpa5(true);
				if (i <= quantosLinhasUsados)
					parametros.setBotao5(true);

			}
			if ((i == 5) && (listaMultiCores.get(i).getMaterial() != null)) {
				parametros.setBotao6(false);
				parametros.setHabilita6(true);
				parametros.setBtnlimpa6(true);
			}

		}
	}

	public Integer VerificaPreenchidos(List<CorAmostraMulti> listaMultiCor) {
		Integer verificaQuantosElementos = 0;
		umaCorPrincipal = 0;
		for (int i = 0; i < listaMultiCor.size(); i++) {
			if (listaMultiCor.get(i).getMaterial() != null) {
				verificaQuantosElementos++;
			}
			if (listaMultiCor.get(i).getCorPrincipal()) {
				umaCorPrincipal++;
			}
		}
		return verificaQuantosElementos;
	}

	// Etapas Corte , Costura, Solado e Acabamento
	// Corte , podera ser selecionado uma Cor ou se pressionar na Aba, todas as
	// cores

	public void inicializaCorteAmostra() {
		Integer qtdCoresCorte = 0;
		if (listaCoresCadastradas.size() == 0) {
			Messages.addGlobalError("Por Favor, Incluir Primeiro Material/Cor(es)!");
			return;
		}
		CorteAmostra corteAmostraAux = facadeAcesso.getBuscaCorteAmostra(amostra.getAmostraId());
		Optional<CorteAmostra> corteAmostraPresente = Optional.empty();
		corteAmostraPresente = Optional.ofNullable(corteAmostraAux);
		corteAmostra = new CorteAmostra();
		if (!corteAmostraPresente.isPresent()) {
			corteAmostra.setAmostra(amostra);
			corteAmostra.setAmostraid(amostra.getAmostraId());
			corteAmostra.setUsuariostamp(amostra.getUsuarioStamp());
			corteAmostra.setDataStamp(corteAmostraDao.getDateLocalTime());
		} else {
			corteAmostra = corteAmostraAux;

		}
		listaCorCorteAmostra = new ArrayList<CorCorteAm>();
		List<CorCorteAm> listaAux = facadeAcesso.getBuscaCorCorteAmostra(amostra.getAmostraId());
		if ((listaAux != null) && (!listaAux.isEmpty())) {
			listaCorCorteAmostra = listaAux;
		}
		if (listaCorCorteAmostra.size() == 0) {
			corCorteAmostra = new CorCorteAm();
			for (CorAmostra corAmostraCorte : listaCoresCadastradas) {
				corCorteAmostra.setAmostra(corAmostraCorte.getAmostra());
				corCorteAmostra.setCoramostra(corAmostraCorte);
				corCorteAmostra.setSequenciacoramostra(corAmostraCorte.getSequenciaCorAmostra());
				corCorteAmostra.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
				corCorteAmostra.setDatastamp(corCorteAmostraDao.getDateLocalTime());
				listaCorCorteAmostra.add(corCorteAmostra);
				corCorteAmostra = new CorCorteAm();
				qtdCoresCorte++;
			}
		} else {
			qtdCoresCorte = listaCoresCadastradas.size();
			if (qtdCoresCorte > listaCorCorteAmostra.size()) {
				corCorteAmostra = new CorCorteAm();
				Integer addNovaCor = 0;
				qtdCoresCorte = listaCorCorteAmostra.size();
				for (CorAmostra corAmostraCorte : listaCoresCadastradas) {
					addNovaCor++;
					if (addNovaCor > qtdCoresCorte) {
						corCorteAmostra.setAmostra(corAmostraCorte.getAmostra());
						corCorteAmostra.setCoramostra(corAmostraCorte);
						corCorteAmostra.setSequenciacoramostra(corAmostraCorte.getSequenciaCorAmostra());
						corCorteAmostra.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
						corCorteAmostra.setDatastamp(corCorteAmostraDao.getDateLocalTime());
						listaCorCorteAmostra.add(corCorteAmostra);
						corCorteAmostra = new CorCorteAm();
					}
				}
				qtdCoresCorte = listaCorCorteAmostra.size();
			}
		}

		iniciaTransCorteCor();

		if (qtdCoresCorte != 0) {
			if (qtdCoresCorte == 1) {
				parametros.setPricor(true);
			} else if (qtdCoresCorte == 2) {
				parametros.setPricor(true);
				parametros.setSegcor(true);
			} else if (qtdCoresCorte == 3) {
				parametros.setPricor(true);
				parametros.setSegcor(true);
				parametros.setTercor(true);
			} else if (qtdCoresCorte == 4) {
				parametros.setPricor(true);
				parametros.setSegcor(true);
				parametros.setTercor(true);
				parametros.setQuacor(true);
			}
		}
	}

	// Amostra Costura preenchimento dos dados e acabamentos
	public void inicializaCosturaAmostra() throws IOException {
		Integer qtdCoresCostura = 0;
		if (listaCoresCadastradas.size() == 0) {
			Messages.addGlobalError("Por Favor, Incluir Primeiro Material/Cor(es)!");
			return;
		}
		CosturaAmostra costuraAmostraAux = facadeAcesso.getBuscaCosturaAmostra(amostra.getAmostraId());
		Optional<CosturaAmostra> costuraAmostraPresente = Optional.empty();
		costuraAmostraPresente = Optional.ofNullable(costuraAmostraAux);
		costuraAmostra = new CosturaAmostra();
		if (!costuraAmostraPresente.isPresent()) {
			costuraAmostra.setAmostra(amostra);
			costuraAmostra.setAmostraid(amostra.getAmostraId());
			costuraAmostra.setUsuariostamp(amostra.getUsuarioStamp());
			costuraAmostra.setDataStamp(costuraAmostraDao.getDateLocalTime());
		} else {
			costuraAmostra = costuraAmostraAux;

		}
		listaCorCosturaAmostra = new ArrayList<CorCosturaAm>();
		List<CorCosturaAm> listaAux = facadeAcesso.getBuscaCorCosturaAmostra(amostra.getAmostraId());
		if (listaAux != null) {
			listaCorCosturaAmostra = listaAux;
		}
		if (listaCorCosturaAmostra.size() == 0) {
			corCosturaAmostra = new CorCosturaAm();
			for (CorAmostra corAmostraCostura : listaCoresCadastradas) {
				corCosturaAmostra.setAmostra(corAmostraCostura.getAmostra());
				corCosturaAmostra.setCoramostra(corAmostraCostura);
				corCosturaAmostra.setSequenciacoramostra(corAmostraCostura.getSequenciaCorAmostra());
				corCosturaAmostra.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
				corCosturaAmostra.setDatastamp(corCosturaAmostraDao.getDateLocalTime());
				listaCorCosturaAmostra.add(corCosturaAmostra);
				corCosturaAmostra = new CorCosturaAm();
				qtdCoresCostura++;
			}
		} else {
			qtdCoresCostura = listaCoresCadastradas.size();
			if (qtdCoresCostura > listaCorCosturaAmostra.size()) {
				corCosturaAmostra = new CorCosturaAm();
				Integer addNovaCor = 0;
				qtdCoresCostura = listaCorCosturaAmostra.size();
				for (CorAmostra corAmostraCostura : listaCoresCadastradas) {
					addNovaCor++;
					if (addNovaCor > qtdCoresCostura) {
						corCosturaAmostra.setAmostra(corAmostraCostura.getAmostra());
						corCosturaAmostra.setCoramostra(corAmostraCostura);
						corCosturaAmostra.setSequenciacoramostra(corAmostraCostura.getSequenciaCorAmostra());
						corCosturaAmostra.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
						corCosturaAmostra.setDatastamp(corCosturaAmostraDao.getDateLocalTime());
						listaCorCosturaAmostra.add(corCosturaAmostra);
						corCosturaAmostra = new CorCosturaAm();
					}
				}
				qtdCoresCostura = listaCorCosturaAmostra.size();
			}
		}

		iniciaTransCosturaCor();

		if (qtdCoresCostura != 0) {
			if (qtdCoresCostura == 1) {
				parametros.setPricorb(true);
			} else if (qtdCoresCostura == 2) {
				parametros.setPricorb(true);
				parametros.setSegcorb(true);
			} else if (qtdCoresCostura == 3) {
				parametros.setPricorb(true);
				parametros.setSegcorb(true);
				parametros.setTercorb(true);
			} else if (qtdCoresCostura == 4) {
				parametros.setPricorb(true);
				parametros.setSegcorb(true);
				parametros.setTercorb(true);
				parametros.setQuacorb(true);
			}
		}
	}

	// Amostras solado com base na construcao,mostra dados preenchidos para cores
	public void inicializaSoladoAmostra() throws IOException {
		Integer qtdCoresSolado = 0;
		if (listaCoresCadastradas.size() == 0) {
			Messages.addGlobalError("Por Favor, Incluir Primeiro Material/Cor(es)!");
			return;
		}
		listaCorSoladoAmostra = new ArrayList<CorConstrucaoAm>();
		List<CorConstrucaoAm> listaAux = facadeAcesso.getBuscaCorSoladoAmostra(amostra.getAmostraId());
		if (listaAux != null) {
			listaCorSoladoAmostra = listaAux;
		}
		corSoladoAmostra = new CorConstrucaoAm();
		if (listaCorSoladoAmostra.size() == 0) {
			corSoladoAmostra = new CorConstrucaoAm();
			for (CorAmostra corAmostraSolado : listaCoresCadastradas) {
				corSoladoAmostra.setAmostra(corAmostraSolado.getAmostra());
				corSoladoAmostra.setCoramostra(corAmostraSolado);
				corSoladoAmostra.setSequenciacoramostra(corAmostraSolado.getSequenciaCorAmostra());
				corSoladoAmostra.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
				corSoladoAmostra.setDataStamp(corSoladoAmostraDao.getDateLocalTime());
				listaCorSoladoAmostra.add(corSoladoAmostra);
				corSoladoAmostra = new CorConstrucaoAm();
				qtdCoresSolado++;
			}
		} else {
			qtdCoresSolado = listaCoresCadastradas.size();
			if (qtdCoresSolado > listaCorSoladoAmostra.size()) {
				corSoladoAmostra = new CorConstrucaoAm();
				Integer addNovaCor = 0;
				qtdCoresSolado = listaCorSoladoAmostra.size();
				for (CorAmostra corAmostraSolado : listaCoresCadastradas) {
					addNovaCor++;
					if (addNovaCor > qtdCoresSolado) {
						corSoladoAmostra.setAmostra(corAmostraSolado.getAmostra());
						corSoladoAmostra.setCoramostra(corAmostraSolado);
						corSoladoAmostra.setSequenciacoramostra(corAmostraSolado.getSequenciaCorAmostra());
						corSoladoAmostra.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
						corSoladoAmostra.setDataStamp(corSoladoAmostraDao.getDateLocalTime());
						listaCorSoladoAmostra.add(corSoladoAmostra);
						corSoladoAmostra = new CorConstrucaoAm();
					}
				}
				qtdCoresSolado = listaCorSoladoAmostra.size();
			}
		}

		iniciaTransSoladoCor();

		if (qtdCoresSolado != 0) {
			if (qtdCoresSolado == 1) {
				parametros.setPricorc(true);
			} else if (qtdCoresSolado == 2) {
				parametros.setPricorc(true);
				parametros.setSegcorc(true);
			} else if (qtdCoresSolado == 3) {
				parametros.setPricorc(true);
				parametros.setSegcorc(true);
				parametros.setTercorc(true);
			} else if (qtdCoresSolado == 4) {
				parametros.setPricorc(true);
				parametros.setSegcorc(true);
				parametros.setTercorc(true);
				parametros.setQuacorc(true);
			}
		}
		soladoAmostra = new Construcao();
		soladoAmostra = amostra.getLivroReferencia().getConstrucao();
		/*
		 * Busca pelo LivroReferencia, este objeto faz parte da amostra Os dados devem
		 * ser apenas apresentados(readonly), nao podem ser editados. para cada linha
		 * apresentada da construcao,preenche acabamento cores
		 */
	}

	// Amostras Acabamento, amostra dados preenchidos para cores
	public void inicializaAcabamentoAmostra() throws IOException {
		Integer qtdCoresAcabamento = 0;
		if (listaCoresCadastradas.size() == 0) {
			Messages.addGlobalError("Por Favor, Incluir Primeiro Material/Cor(es)!");
			return;
		}
		AcabamentoAmostra acabamentoAmostraAux = facadeAcesso.getBuscaAcabamentoAmostra(amostra.getAmostraId());
		Optional<AcabamentoAmostra> acabamentoAmostraPresente = Optional.empty();
		acabamentoAmostraPresente = Optional.ofNullable(acabamentoAmostraAux);
		acabamentoAmostra = new AcabamentoAmostra();
		if (!acabamentoAmostraPresente.isPresent()) {
			acabamentoAmostra.setAmostra(amostra);
			acabamentoAmostra.setAmostraid(amostra.getAmostraId());
			acabamentoAmostra.setUsuariostamp(amostra.getUsuarioStamp());
			acabamentoAmostra.setDataStamp(acabamentoAmostraDao.getDateLocalTime());
		} else {
			acabamentoAmostra = acabamentoAmostraAux;

		}
		listaCorAcabamentoAmostra = new ArrayList<CorAcabamentoAm>();
		List<CorAcabamentoAm> listaAux = facadeAcesso.getBuscaCorAcabamentoAmostra(amostra.getAmostraId());
		if (listaAux != null) {
			listaCorAcabamentoAmostra = listaAux;
		}
		if (listaCorAcabamentoAmostra.size() == 0) {
			corAcabamentoAmostra = new CorAcabamentoAm();
			for (CorAmostra corAmostraAcabamento : listaCoresCadastradas) {
				corAcabamentoAmostra.setAmostra(corAmostraAcabamento.getAmostra());
				corAcabamentoAmostra.setCoramostra(corAmostraAcabamento);
				corAcabamentoAmostra.setSequenciacoramostra(corAmostraAcabamento.getSequenciaCorAmostra());
				corAcabamentoAmostra.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
				corAcabamentoAmostra.setDataStamp(corAcabamentoAmostraDao.getDateLocalTime());
				listaCorAcabamentoAmostra.add(corAcabamentoAmostra);
				corAcabamentoAmostra = new CorAcabamentoAm();
				qtdCoresAcabamento++;
			}
		} else {
			qtdCoresAcabamento = listaCoresCadastradas.size();
			if (qtdCoresAcabamento > listaCorAcabamentoAmostra.size()) {
				corAcabamentoAmostra = new CorAcabamentoAm();
				Integer addNovaCor = 0;
				qtdCoresAcabamento = listaCorAcabamentoAmostra.size();
				for (CorAmostra corAmostraAcabamento : listaCoresCadastradas) {
					addNovaCor++;
					if (addNovaCor > qtdCoresAcabamento) {
						corAcabamentoAmostra.setAmostra(corAmostraAcabamento.getAmostra());
						corAcabamentoAmostra.setCoramostra(corAmostraAcabamento);
						corAcabamentoAmostra.setSequenciacoramostra(corAmostraAcabamento.getSequenciaCorAmostra());
						corAcabamentoAmostra.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
						corAcabamentoAmostra.setDataStamp(corAcabamentoAmostraDao.getDateLocalTime());
						listaCorAcabamentoAmostra.add(corAcabamentoAmostra);
						corAcabamentoAmostra = new CorAcabamentoAm();
					}
				}
				qtdCoresAcabamento = listaCorAcabamentoAmostra.size();
			}
		}

		iniciaTransAcabCor();

		if (qtdCoresAcabamento != 0) {
			if (qtdCoresAcabamento == 1) {
				parametros.setPricord(true);
			} else if (qtdCoresAcabamento == 2) {
				parametros.setPricord(true);
				parametros.setSegcord(true);
			} else if (qtdCoresAcabamento == 3) {
				parametros.setPricord(true);
				parametros.setSegcord(true);
				parametros.setTercord(true);
			} else if (qtdCoresAcabamento == 4) {
				parametros.setPricord(true);
				parametros.setSegcord(true);
				parametros.setTercord(true);
				parametros.setQuacord(true);
			}
		}
	}

	// Base para Salvar detalhes e combinacoes
	public void saveCorte() {

		// Save em duas parte, enviando - Corte e acabamentos

		try {
			corteAmostraDao.update(corteAmostra);
			corCorteAmostraDao.saveAmostraCorCorte(listaCorCorteAmostra);
			Messages.addGlobalInfo("Dados Detalhes Corte e Cores, Incluidos com  sucesso !");
			iniciaTransCorteCor();

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel incluir Detalhes Corte/Cores!");
			ex.printStackTrace();
			return;
		}
	}

	public void saveCostura() {

		// Save em duas parte, enviando - Costura e acabamentos
		// Codificacao para Salvar por lista e item individual
		try {
			costuraAmostraDao.update(costuraAmostra);
			corCosturaAmostraDao.saveAmostraCorCostura(listaCorCosturaAmostra);
			Messages.addGlobalInfo("Dados Detalhe Costura/Cor, alterado com  sucesso !");
			iniciaTransCosturaCor();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Alterar Detalhe(s) Costura/Cor(es) !");
			ex.printStackTrace();
			return;
		}
	}

	public void saveSolado() {

		// Save em duas parte, enviando - Solado e acabamentos

		try {
			if (!amostra.getObsSolado().isEmpty()) {
			   amostraDao.update(amostra);
			}
			corSoladoAmostraDao.saveAmostraCorSolado(listaCorSoladoAmostra);
			Messages.addGlobalInfo("Dados Detalhes Cores Solado, Incluidos com  sucesso !");

			iniciaTransSoladoCor();

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel incluir Cores Solado !");
			ex.printStackTrace();
			return;
		}
	}

	public void saveAcabamento() {

		// Save em duas parte, enviando - Acabamento e cmbinacoes

		try {
			acabamentoAmostraDao.update(acabamentoAmostra);
			acabamentoAmostraDao.saveAmostraCorAcabamento(listaCorAcabamentoAmostra);
			Messages.addGlobalInfo("Dados Detalhes Acabamento e combinações, Incluidos com  sucesso !");

			iniciaTransAcabCor();

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel incluir Detalhes Acabamentos/Cores !");
			ex.printStackTrace();
			return;
		}
	}

	public void inicializaVetoresOperacoes() {
		corteAmostra = new CorteAmostra();
		costuraAmostra = new CosturaAmostra();
		acabamentoAmostra = new AcabamentoAmostra();
		listaCorCosturaAmostra = new ArrayList<>();
		listaCorAcabamentoAmostra = new ArrayList<>();
		listaCorSoladoAmostra = new ArrayList<>();
		listaCorCorteAmostra = new ArrayList<>();

	}

	public void inicializaVetorCores() {
		listaCoresCadastradas = new ArrayList<>();
		
	}

	public void iniciaTransCores() {
		parametros.setPricor(false);
		parametros.setPricorb(false);
		parametros.setPricorc(false);
		parametros.setPricord(false);

		parametros.setSegcor(false);
		parametros.setSegcorb(false);
		parametros.setSegcorc(false);
		parametros.setSegcord(false);

		parametros.setTercor(false);
		parametros.setTercorb(false);
		parametros.setTercorc(false);
		parametros.setTercord(false);

		parametros.setQuacor(false);
		parametros.setQuacorb(false);
		parametros.setQuacorc(false);
		parametros.setQuacord(false);

	}

	public void iniciaTransCorteCor() {
		parametros.setPricor(false);
		parametros.setSegcor(false);
		parametros.setTercor(false);
		parametros.setQuacor(false);
	}

	public void iniciaTransCosturaCor() {
		parametros.setPricorb(false);
		parametros.setSegcorb(false);
		parametros.setTercorb(false);
		parametros.setQuacorb(false);
	}

	public void iniciaTransSoladoCor() {
		parametros.setPricorc(false);
		parametros.setSegcorc(false);
		parametros.setTercorc(false);
		parametros.setQuacorc(false);
	}

	public void iniciaTransAcabCor() {
		parametros.setPricord(false);
		parametros.setSegcord(false);
		parametros.setTercord(false);
		parametros.setQuacord(false);
	}

	// Busca Attn para o cliente ficha
	public void buscaListaDestinoAm(Amostra attn) {
		listaDestinoAmCf = new ArrayList<>();
		listaDestinoAmCf = facadeAcesso
				.buscaDestinoAmCf(attn.getCliente().getGrpclienteinvoice().getGrupoclienteinvoiceid());

	}

	public void filtrosAmostraNova(ToggleEvent event) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Filtros", "Visiveis:" + event.getVisibility());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
    public void addMessage(FacesMessage.Severity severity,String summary,String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity,summary,detail));
    }
    public void executaSolicitacaoBloqueio() {
    	Boolean executadoSolicitacao = false;
    	if (listaFichasProducao.size() != 0){
			for (FichaProducao fichaProducao : listaFichasProducao) {
				//Solicitado rebloqueio,e altera transcao para Distribuicao bloqeuar
				if (fichaProducao.getLiberadoalteraramostra().equals(EmTransicao.T)) {
					fichaProducao.setLiberadoalteraramostra(EmTransicao.L);
					fichaProducao.setSemaforo("green");
					try {
						fichaProducaoDao.update(fichaProducao);
						amostra.setPrioridadeProducao(PrioridadeProducao.N);
						amostraDao.update(amostra);
						if (!solicitaLiberacao) {
							Messages.addGlobalInfo("Solicitação de Bloqueio realizado com sucesso !");
							solicitaLiberacao = true;
						}
					} catch (RuntimeException re) {
						Messages.addGlobalInfo("Não foi possivel atualizar Ficha(s) Produção(es)!");
						return;
					}
					if (solicitaLiberacao) {
						
					}
				}
			}
			liberaTransito = false;
    	}
    }
    public void executaDesbloqueio() throws MessagingException {
    	String msgAgrupa = "";
    	String msgRec = "";
    	String msg = "Olá, Por favor liberar as seguintes Fichas em Produção:";
    	Boolean temMarca = false;
    	for (FichaProducao fichaProducao : listaFichasProducao) {
			if (fichaProducao.getAliberar()) {
				try {
					fichaProducao.setAliberar(false);
					fichaProducao.setLiberadoalteraramostra(EmTransicao.W);
					fichaProducao.setSemaforo("#e77318");
					fichaProducao.setAliberar(true);
					fichaProducaoDao.update(fichaProducao);
				} catch (Exception e) {
					e.printStackTrace();
				}
				temMarca = true;
				msgRec=Long.toString(fichaProducao.getFichaproducaoid()).trim();
				msgAgrupa +=msgRec+",";
				msgRec = "";
			}
		}
    	if (temMarca) {
    		addMessage(FacesMessage.SEVERITY_INFO, "Fichas enviadas para Liberação !", "");
    	}else {
    		addMessage(FacesMessage.SEVERITY_WARN, "Não foi selecionada,Ficha para Desbloqueio !", "");
    	}
    	msgAgrupa="Ficha(s) : "+msgAgrupa;
    	msg+=System.lineSeparator()+msgAgrupa;
    	//Alterar aqui para o email do dpto solicitante-Amostras
    	String remetente = "ti@gvdintl.com.br";
    	String senha = "Fus99907";
    	String destinatario = "ti@gvdintl.com.br";
    	String assunto = "Solicitação liberacao Fichas em Produção";
    	enviadorEmail.sendMail(remetente, senha, destinatario, msg, assunto);
    	try {
    		/*T=Significa, solicitado desbloqueio na producao,somente podera alterar
    		quando Almoxarifado liberar, sera mudado status para "X"*/
    		//Na amostra de producao,status alterar para W,e na amostra fica como Transicao
			amostra.setPrioridadeProducao(PrioridadeProducao.T);
			amostraDao.update(amostra);
			//
			//* Atualiza Lista
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
    }

    public List<String> ajustaCronometro(FichaProducao fichaProducao) {
    	eventos = new ArrayList<>();
    	if (fichaProducao.getDataalmoxarifado() != null) {
            LocalDate localDate = fichaProducao.getDataalmoxarifado();
            Date date = Date.valueOf(localDate);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String data = format.format(date);

    		eventos.add(data);
    	}else {
    		eventos.add("???");
    	}
    	if (fichaProducao.getDatacorte() != null) {
            LocalDate localDate = fichaProducao.getDatacorte();
            Date date = Date.valueOf(localDate);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String data = format.format(date);
    
    		eventos.add(data);
    	}else {
    		eventos.add("???");
    	}
    	if (fichaProducao.getDatacostura() != null) {
            LocalDate localDate = fichaProducao.getDatacostura();
            Date date = Date.valueOf(localDate);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String data = format.format(date);
            eventos.add(data);
    	}else{
    		eventos.add("???");
    	}
    	if (fichaProducao.getDatadistribuicao() != null) {
            LocalDate localDate = fichaProducao.getDatadistribuicao();
            Date date = Date.valueOf(localDate);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String data = format.format(date);
    		eventos.add(data);
    	}else {
    		eventos.add("???");
    	}
    	return eventos;
    }
 
    public void populaNomeEventos() {
    	nomeEventos = new ArrayList<String>();
    	nomeEventos.add("Almoxarifado");
    	nomeEventos.add("Corte");
    	nomeEventos.add("Costura");
    	nomeEventos.add("Acabamento");
    }
    
    public void CheckSeHouveAlteração() {
    	
    }
	// ------Visão Logs
	public void visaoLogs() {
	  if (listaLogs.size() != 0) {
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
		PrimeFaces.current().dialog().openDynamic("frkLogs", options, null);
	  }else {
		Messages.addGlobalWarn("Não há alterações para esta Amostra");
		return;

	  }
	}

	public void inicializaVariaveis() {
		iniSolicitacao = null;
		finSolicitacao = null;
		iniamostrap = null;
		finamostrap = null;
		inisaidaf = null;
		finsaidaf = null;
		iniliberap = null;
		finliberap = null;
		informaCor = "";
		informaCorp = "";
		largura = "";
		altura = "";
		mostraListaProducao = false;
		solicitaLiberacao = false;
		imageResize = null;
	}
}
