package br.com.gvdexport.controller;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.facade.FacadeView;
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
import br.com.gvdexport.model.Estacao;
import br.com.gvdexport.model.Fabrica;
import br.com.gvdexport.model.Forma;
import br.com.gvdexport.model.ImagemReferencia;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.MarcaCliente;
import br.com.gvdexport.model.Material;
import br.com.gvdexport.model.Mercado;
import br.com.gvdexport.model.Modelo;
import br.com.gvdexport.model.ParametrosTransientes;
import br.com.gvdexport.model.PrioridadeProducao;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Tipo;
import br.com.gvdexport.model.TipoMaterial;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class CriaFichaProducaoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter	@Setter
	private Amostra amostra;
	@Getter @Setter
	private List<Amostra> listaAmostras;
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
	@Getter	@Setter
	private boolean duplica;
	@Getter	@Setter
	private LivroReferencia referenciaSelecionada;
	
	 private String activeIndexes = null;
	 private List<Tab> accordionTabs = null;
	
	// Esta variavel,deve ser tambem relacionada com o tipo de usuario
	
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
	//
	// Composicao necessaria para formatar Acabamento
	//
	@Getter @Setter
	private AcabamentoAmostra acabamentoAmostra;
	@Getter @Setter
	private List<CorAcabamentoAm> listaCorAcabamentoAmostra;
	@Getter @Setter
	private CorAcabamentoAm corAcabamentoAmostra;

	@SuppressWarnings("unused")
	private StreamedContent imagem;
	// ---------------------------------------------------------------

//	LazyAmostraNovaDataModel dataModel = new LazyAmostraNovaDataModel();
//
//	public LazyDataModel<Amostra> getModel() {
//		return dataModel;
//	}

	@Inject
	private FacadeAcesso facadeAcesso;

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
	private CrudDao<CorCorteAm, Long> corCorteAmostraDao;
	
	@Inject
	private CrudDao<CosturaAmostra, Long> costuraAmostraDao;
	
	@Inject
	private CrudDao<CorCosturaAm, Long> corCosturaAmostraDao;
	
	@Inject
	private CrudDao<AcabamentoAmostra, Long> acabamentoAmostraDao;
	
	@Inject
	private CrudDao<CorAcabamentoAm, Long> corAcabamentoAmostraDao;
	
	@Inject
	private CrudDao<CorConstrucaoAm, Long> corSoladoAmostraDao;
	
	@Inject
	private CrudDao<CorAmostraMulti, Long> corAmostraMultidao;

	@PostConstruct
	public void init() {
		amostra = new Amostra();
		listaLivroReferencia = new ArrayList<LivroReferencia>();
		listaFiltroAmostras = new ArrayList<Amostra>();
		listaCoresCadastradas = new ArrayList<>();
		listaAmostras = new ArrayList<Amostra>();
		// (Operacao Posterior)
		// = 0, continua noutro perido
		// = 1, contniua adicao da ficha no mesmo momento
		operacaoPosterior = 0;
		mStatus = true;
		operacao = 0;
		btnVisao = false;
		// inicializa varaveis de pesquisa
		// inicializa datas
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
		inicializaParametros();
		inicializaConsulta();
		iniciaTransCores();
	}

	//
	// Operacao 0 = inclusao
	// 1 = Alteração
	// 2 = Duplicação
	public void add() {
		amostra = new Amostra();
		operacao = 0;
		duplica = false;
		mStatus = true;
		amostra.setPrioridaDeProducao(PrioridadeProducao.X);
		amostra.setDataSolicitacao(amostraDao.getLocalDate());
		amostra.setPares(BigDecimal.ZERO);
		amostra.setPargvd(BigDecimal.ZERO);
		//alterado para 1 , antes 0 , em 14/04;
		operacaoPosterior = 1;
		sequencialCor = 0;
		umaCorPrincipal = 0;
		parametros.setPrioridade(true);
		parametros.setBtncheck(true);
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
	}
	//Inicaliza parametros de mostragem das abas, em modo true
	public void inicializaParametros() {
		parametros = new ParametrosTransientes();
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
		corAmostra.setTotalPar(BigDecimal.ZERO);
		corAmostra.setParGvd(BigDecimal.ZERO);
		corAmostra.setParCancelado(BigDecimal.ZERO);
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
		//inicializa transientes cores de acabamento
		iniciaTransCores();
		//Carrega todas as listas , porque se não carregar, e chamar por exemplo Corte, em uma nova
		//Cor, este carregar corretamente a nova cor, mas paa a proxima aba, ex: Costura, verificar que as variaveis de Renderizacao
		//são as mesmas e carregar os includes  do anterior. A Nova consulta tem 4 cor, e a anterior tem duas,os includes sao todos carregados..
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
			//alterado em 04/05/2021
				//quando operacaoPosterior = 0, inclusa noutro periodo, entao a operacao e de alteracao
				//comentado em 27/05/2021
				//if (operacaoPosterior == 0) {
					//operacao = 1;
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
			parametros.setBtncheck(true);//Alterado de false p/true em 08/04
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

	public void edit(Amostra amostraedit) throws CloneNotSupportedException {
		amostraClone = new Amostra();
		posicaoAtual = 0;
		amostra = amostraedit;
		amostraClone = (Amostra) amostra.clone();
		operacao = 1;
		//adiconado em 14/04
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
		setBtnVisao(false);
		// Libera campo para alteracao
		// Aqui devera aparecer verificacao se possui fichas em producao
		// Aqui devera avisar, que precisa liberacao da producao para
		// alteracao.
		// aqui devera ser verificado se alterar prioridade, devera ter cadastro
		// completo,caso contrario avisa, que
		// o que falta (Cor,acabamentos,etc...)
		if (amostra.getPrioridaDeProducao().equals(PrioridadeProducao.X)) {
			parametros.setPrioridade(true);
		}
		// Atualiza variaveis de infomacao
		facadeView.editCor(amostra.getReferencia().toString().trim(), amostra.getSucCliente(),
				amostra.getEstacao().getNome(), amostra.getSucFabrica(), amostra.getComponente().getDef1().trim());
		// Para liberar este campo nao pode ter ficha de producao e se tiver precisa
		// libera-la pela Produção

		// Lista com cores da amostra Selecionada
		listaCoresCadastradas = new ArrayList<>();
		listaCoresCadastradas = facadeAcesso.getBuscaCoresAmostra(amostra.getAmostraId());
		if (amostraedit.getCliente().getGrpclienteinvoice() != null) {
			buscaListaDestinoAm(amostra);
		}

	}

	public void editCorMulti(CorAmostra corEditAmostra) throws CloneNotSupportedException {
		operacao = 1;
		btnVisao = false;
		refazComposicao = 0;
		corAmostraClone = new CorAmostra();
		listaCoresComposicao = new ArrayList<>();
		corAmostra = new CorAmostra();
		corCabedal = new CorCabedalAm();
		corAmostra = corEditAmostra;
		corAmostraClone = (CorAmostra) corAmostra.clone();
		corCabedal = facadeAcesso.getBuscaCorAmostraCabedal(amostra.getAmostraId(), corAmostra.getId());
		corCabedalClone = (CorCabedalAm) corCabedal.clone();
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

	//Alterar dados corte/cor
	public void editCorteCorAmostra(CorAmostra corAmostra) throws CloneNotSupportedException {
		CorCorteAm corCorteAmClone = new CorCorteAm();
		CorAmostra corAmostraClone = new CorAmostra();
		CorteAmostra corteAmostraClone = new CorteAmostra();
		corAmostraClone = (CorAmostra) corAmostra.clone(); 
		CorteAmostra corteAmostraAux = facadeAcesso.getBuscaCorteAmostra(corAmostra.getAmostra().getAmostraId());
		Optional<CorteAmostra> corteAmostraPresente = Optional.empty();
		corteAmostraPresente = Optional.ofNullable(corteAmostraAux);
		corteAmostra = new CorteAmostra();
		iniciaTransCorteCor();

		//Corte
		if (!corteAmostraPresente.isPresent()) {
			Messages.addGlobalError("Por Favor, antes, você deveria, Inserir Dados Corte");
			return;
		}else {
			corteAmostra = corteAmostraAux;
			corteAmostraClone = (CorteAmostra) corteAmostraAux.clone();
		}

		//Cor especifica Corte
		 CorCorteAm auxCorCorteAmostra = new CorCorteAm();
		
		auxCorCorteAmostra = facadeAcesso.getBuscaPosicaoCorCorteAmostra(corAmostra.getId());
		if (auxCorCorteAmostra != null) {
			corCorteAmClone = (CorCorteAm) auxCorCorteAmostra.clone();
		}else {
			Messages.addGlobalError("Por favor, contate Administrador-Amostracontroller-line:638, informando os dados!");
			return;
		}
		//As fases sempre serão de uma cor
		parametros.setPricor(true);

	}
	
	public void deleteCor(CorAmostra corDeleteAmostra) {
		if (corDeleteAmostra == null) {
			Messages.addGlobalError("Não há Cor(es) Cadastrada(s) !");
			return;
		}

		/* Para Deletar Cor
		   a)Remover corAcabamento,CorCorte,CorCostura,CorSolado
		   b)Remover tabela Multi
		   c)Remover tabela CorAmostra 
		   
		   1) Verificar se a cor tem ficha de producao,caso tenha, solicitar primeiro cancelamento na producao
		   2) Cancelamento na producao, devera ter uma justificativa, para efetu-la, que ficara vinculada a amostra de Origem
		   3) Verificar se tem ficha de confirmação, caso contrario nao pode ser efetuado.
		   4) Se tiver data de entrega de producao, nao pode ser cancelada
		   5) Sem producao,efetua cancelamento normal de todas
		*/

		amostra = new Amostra();
		amostra = amostraDao.find(corDeleteAmostra.getAmostraId());
		//Observar que aqui, se a cor for liberada,podera ser cancelada,este teste deve ser feito
		//quando houver modulo atelier
		if (amostra.getDataLiberacaoProducao() != null) {
			Messages.addGlobalError("Amostra em Produção!!!, não pode ser cancelada qualquer cor!");
			return;
		}
		//adiciona pares cancelados,subtrai do total da ficha
		if (amostra.getParCancelado() != null) {
			amostra.setParCancelado(amostra.getParCancelado().add(corDeleteAmostra.getTotalPar()));
		}else {
			amostra.setParCancelado(corDeleteAmostra.getTotalPar());
		}

		amostra.setPares(amostra.getPares().subtract(corDeleteAmostra.getTotalPar()));
		
		//
		//Cancelar tabela multi , Cor e Cabedal
		//
		List<CorAmostraMulti> listaCorMultiAux = facadeAcesso.getBuscaCorAmostraMulti(amostra.getAmostraId(), corDeleteAmostra.getSequenciaCorAmostra());
		if (listaCorMultiAux.size() != 0) {
			try {
				corAmostraMultidao.deleteCorMulti(listaCorMultiAux);
				} catch (RuntimeException ex) {
					Messages.addGlobalError("Não foi possivel Excluir Combinação Multi para cor Selecionada!");
					ex.printStackTrace();
					return;
				}
		}
		//Cabedais da Multi
		List<CorCabedalAm> listaCabedalMultiAux = facadeAcesso.getBuscaAmostraCabedais(corDeleteAmostra.getAmostra().getAmostraId(),corDeleteAmostra.getId());
		if (listaCabedalMultiAux.size() != 0) {
			try {
				corAmostraMultidao.deleteCabedalMulti(listaCabedalMultiAux);
				} catch (RuntimeException ex) {
					Messages.addGlobalError("Não foi possivel Excluir Combinação Multi para cor Selecionada!");
					ex.printStackTrace();
					return;
				}
		}
		//
		//Primeira Etapa Cancelamento Combinações
		// Busca Cor Corte para Cancelamento
		try {
			 CorCorteAm corCorteAux = facadeAcesso.getBuscaPosicaoCorCorteAmostra(corDeleteAmostra.getId());
			 if (corCorteAux != null) {
				 corCorteAmostraDao.delete(corCorteAux.getId());
			 }
			} catch (RuntimeException ex) {
				Messages.addGlobalError("Não foi possivel Excluir Cor/Combinação Corte!");
				ex.printStackTrace();
				return;
			}
		
		//Busca Cor Costura para Cancelamento
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
		
		//Busca Cor Solado para Cancelamento

		try {
			 CorConstrucaoAm corSoladoAux = facadeAcesso.getBuscaPosicaoCorConstrucaoAmostra(corDeleteAmostra.getId());
			 if (corSoladoAux != null) {
				 corSoladoAmostraDao.delete(corSoladoAux.getId());
			 }
			} catch (RuntimeException ex) {
				Messages.addGlobalError("Não foi possivel Excluir Cor/Combinação Solado!");
				ex.printStackTrace();
				return;
			}

		//Busca Cor Acabamento para Cancelamento
		try {
			 CorAcabamentoAm corAcabamentoAux = facadeAcesso.getBuscaPosicaoCorAcabamentoAmostra(corDeleteAmostra.getId());
			 if (corAcabamentoAux != null) {
				 corAcabamentoAmostraDao.delete(corAcabamentoAux.getId());
			 }
			} catch (RuntimeException ex) {
				Messages.addGlobalError("Não foi possivel Excluir Cor/Combinação Acabamento!");
				ex.printStackTrace();
				return;
			}
		//Atualiza Dados Amostra,Cancelamento da cor Tabela Cor Amostra
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
		//atualiza nova situacao de pares da Amostra

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
		this.amostra = amostradup;
		// Observar caraqcteristicas da amostra
		operacao = 3;
		amostraClone = (Amostra) amostradup.clone();
		amostraClone.setAmostraId(null);
		amostraClone.setUsuarioStamp(usuarioLogado.getUsuariologado().getUsuario());
		amostraClone.setDataStamp(amostraDao.getDateLocalTime());
		amostraClone.setDataSolicitacao(amostraDao.getLocalDate());
		amostraClone.setDtxfct(null);
		facadeView.setInformaReferencia(amostraClone.getReferencia().toString().trim());
//		try {
//			amostra = new Amostra();
//			amostra = amostraDao.update(amostraClone);
//			Messages.addGlobalInfo("Construcão Duplicada com Sucesso !");
//		} catch (Exception ex) {
//			Messages.addGlobalError("Não fo possivel Duplicar Referencia !");
//			ex.printStackTrace();
			return;
//		}

	}

	public void inicializaConsulta() {
	//	amostra = new Amostra();
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
	   public void onTabChange(TabChangeEvent event) {
//	        FacesMessage msg = new FacesMessage("", "Ativo: " + event.getTab().getTitle());
//	        FacesContext.getCurrentInstance().addMessage(null, msg);

	    }

	
	public void verificaBloqueio() {

	}

	public void verificaAntesSave() {
		Boolean erro = true;
		Boolean verificacao = true;
		try {

			if (operacao == 0) {
				// consistencia Dados Capa Amostra
				if (amostra.getTipo() == null) {
					Messages.addGlobalError("Por favor, informe Tipo de amostra !");
					erro = false;
				}
				if (amostra.getCliente() == null) {
					Messages.addGlobalError("Por Favor, Selecione Cliente!");
					erro = false;
				}
				if (amostra.getFabrica() == null) {
					Messages.addGlobalFatal("Por Favor, Selecione Fábrica!");
					erro = false;
				}
				if (amostra.getReferencia() == null) {
					Messages.addGlobalError("Por Favor, Selecione Referência!");
					erro = false;
				}
				if (amostra.getDtxfct() == null) {
					Messages.addGlobalError("Amostra Para:, Deve ser informado uma Data!");
					erro = false;
				}
				if (amostra.getDataEntrega() == null) {
					Messages.addGlobalError("Data Entrega:, Deve ser informado uma Data!");
					erro = false;
				}
				if (amostra.getComponente() == null) {
					Messages.addGlobalError("Por favor, Selecione Produto !");
					erro = false;
				}
				if (amostra.getEstacao() == null) {
					Messages.addGlobalError("Por favor, Selecione Estação !");
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
				if (((amostra.getPrioridaDeProducao().name().equals("N") || ((amostra.getPrioridaDeProducao().name().equals("U"))))
						&& (amostraClone.getPrioridaDeProducao().name().equals("X")))) {
					amostra.setDataLiberacaoProducao(amostraDao.getDateLocalTime());
				}
				if (!amostra.getPrioridaDeProducao().equals(PrioridadeProducao.X)) {
					//	
					//Verficar a opcao U = Urgente
					//Aqui verificar na tabela de producao se ja foi liberada ou ainda 
					//Falta gerar....por enqanto mensagem bloqueada
//					Messages.addGlobalError("Ficha não pode ser alterada,Possui Solicitação de Produção !");
//					return;
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
			if (operacao == 0) {
				if (!amostra.getPrioridaDeProducao().equals(PrioridadeProducao.X)){
					amostra.setDataLiberacaoProducao(amostraDao.getDateLocalTime());
				}
			}
			// guarda Id Criado na variavel = amostra
			amostra.setUsuarioStamp(usuarioLogado.getUsuariologado().getUsuario());
			amostra.setDataStamp(amostraDao.getDateLocalTime());
			amostra.setMercado(amostra.getMercado());
			amostra = amostraDao.update(amostra);
			Messages.addGlobalInfo("Ficha adicionada com Sucesso !");
			parametros.setAbacor(false);
			operacaoPosterior = 1;
			btnVisao = false;
			parametros.setBtncheck(false);
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
					corCabedal.setAmostra(amostra);
					corCabedal.setCoramostra(corAmostra);
					corCabedal.setSequenciacoramostra(corAmostra.getSequenciaCorAmostra());
					corCabedal.setDatastamp(corAmostra.getDataStamp());
					corCabedal.setUsuariostamp(corAmostra.getUsuarioStamp());
					corCabedal = corCabedalAmostraDao.update(corCabedal);
					// Atualiza pares na Amostra
					if (amostra.getPares().compareTo(BigDecimal.ZERO) != 0) {
						amostra.setPares(amostra.getPares().add(corAmostra.getTotalPar()));
					}else {
						amostra.setPares(corAmostra.getTotalPar());
					}
					if ((amostra.getPargvd().compareTo(BigDecimal.ZERO) != 0) && (corAmostra.getParGvd().compareTo(BigDecimal.ZERO) != 0)) {
						amostra.setPares(amostra.getPares().add(corAmostra.getTotalPar()));
					}else {
						if ((corAmostra.getParGvd().compareTo(BigDecimal.ZERO) != 0) && (corAmostra.getParGvd().compareTo(BigDecimal.ZERO) != 0)) {
							amostra.setPares(corAmostra.getTotalPar());
						}
					}
					
					// Adicionar Multi - tabela muitos --> muitos
					facadeView.saveMultiCorAmostraNova(corAmostra,operacao);
					amostraDao.update(amostra);
					Messages.addGlobalInfo("Material/Cor Cadastrados com Sucesso!");
					inicializaCor();
					parametros.setBtnfecha(true);
					return;
				 }else {
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
						 //ajustar pares na Amostra
						 varDiferenca = (corAmostra.getTotalPar().subtract(corAmostraClone.getTotalPar()));
						 if (varDiferenca.signum() >= 0) {
							 if (varDiferenca.signum() > 0) {
							  if (amostra.getPares().compareTo(BigDecimal.ZERO) != 0) {	 
								novoPares=amostra.getPares().add(varDiferenca);
							  }else {
								novoPares = varDiferenca;  
							  }
							 }else {
								 novoPares = amostra.getPares();
							 }
						 }else {
							 varDiferenca=varDiferenca.multiply(new BigDecimal(-1));
							 if (amostra.getPares().compareTo(BigDecimal.ZERO) != 0) {
								novoPares=amostra.getPares().subtract(varDiferenca);
							}else {
								novoPares = varDiferenca; 
							}
						 }
						 amostra.setPares(novoPares);
					 }else {
						 if (amostra.getPares().compareTo(BigDecimal.ZERO) != 0) {
							 amostra.setPares(amostra.getPares().add(corAmostra.getTotalPar()));
						}else {
							 amostra.setPares(corAmostra.getTotalPar());
						}
					 }
					 //Ajustar parGvd na GVD
					 varDiferenca = BigDecimal.ZERO;
					 if(corAmostraClone != null) {
						 varDiferenca = (corAmostra.getParGvd().subtract(corAmostraClone.getParGvd()));
						 if (varDiferenca.signum() > 0){
							  if (amostra.getPargvd().compareTo(BigDecimal.ZERO) != 0) {	
								amostra.setPargvd(amostra.getPargvd().add(varDiferenca));
							  }else {
								  amostra.setPargvd(corAmostra.getParGvd());
							  }
							}else {
							if (varDiferenca.signum() < 0) { 	
								varDiferenca=varDiferenca.multiply(new BigDecimal(-1));
								if (amostra.getPargvd().compareTo(BigDecimal.ZERO) != 0) {
									amostra.setPargvd(amostra.getPargvd().subtract(varDiferenca));
								}else {
									amostra.setPargvd(corAmostra.getParGvd());
								}
							}
					 }
					 corAmostraNovaDao.update(corAmostra);
					 amostraDao.update(amostra);
					 if (!corCabedal.getTexto().equals(corCabedalClone.getTexto())) {
						 corCabedalAmostraDao.update(corCabedal);
					 }
						facadeView.saveMultiCorAmostraNova(corAmostra,operacao);
						Messages.addGlobalInfo("Material/Cor Alterado com Sucesso!");
					inicializaCor();
				 }
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

	public void referenciaSelecionada(LivroReferencia referenciaselecionada) {

	}

	public void imprimiAmostra(Amostra amostra) {

	}

	public void LocalizaFiltroAmostra() {

	}

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

	public void clienteSelecionado(SelectEvent event) {
		cliente = new Cliente();
		cliente = (Cliente) event.getObject();
		amostra.setCliente(cliente);
		amostra.setSucCliente(cliente.getSucinto());
		if (amostra.getCliente() != null) {
			listaDestinoAmCf = new ArrayList<>();
			if (amostra.getCliente().getGrpclienteinvoice() != null) {
			//	listaDestinoAmCf = facadeAcesso.buscaDestinoAmCf(amostra.getCliente().getGrpclienteinvoice().getGrupoclienteinvoiceid());
				buscaListaDestinoAm(amostra);
			}
		}
	}

	public void fabricaSelecionada(SelectEvent event) {
		fabrica = new Fabrica();
		fabrica = (Fabrica) event.getObject();
		amostra.setFabrica(fabrica);
		amostra.setSucFabrica(fabrica.getSucinto());
	}

	public void construcaoSelecionada(SelectEvent event) {
		construcao = new Construcao();
		construcao = (Construcao) event.getObject();

	}

	public void formaSelecionada(SelectEvent event) {
		forma = new Forma();
		forma = (Forma) event.getObject();

	}

	public void produtoSelecionado(SelectEvent event) {
		componente = new Componente();
		componente = (Componente) event.getObject();
		amostra.setComponente(componente);
	}

	public void modeloSelecionada(SelectEvent event) {
		modelo = new Modelo();
		modelo = (Modelo) event.getObject();

	}

	public void marcaSelecionada(SelectEvent event) {
		marcaCliente = new MarcaCliente();
		marcaCliente = (MarcaCliente) event.getObject();
		amostra.setMarcaCliente(marcaCliente);
	}

	public void estacaoSelecionada(SelectEvent event) {
		estacaoCliente = new Estacao();
		estacaoCliente = (Estacao) event.getObject();
		amostra.setMarcaCliente(marcaCliente);
		amostra.setEstacao(estacaoCliente);
	}	
	public void materialSelecionado(SelectEvent event) {
		material = new Material();
		material = (Material) event.getObject();
		listaCoresComposicao = facadeView.getListaMultiCor();
		listaCoresComposicao.get(sequencialCor).setAmostra(amostra);
		listaCoresComposicao.get(sequencialCor).setMaterial(material);
		facadeView.getListaMultiCor().get(sequencialCor).setMaterial(material);
		facadeView.getListaMultiCor().get(sequencialCor).setMatNome(material.getNome());

	}

	public void corSelecionada(SelectEvent event) {
		Cor corEscolha = new Cor();
		corEscolha = (Cor) event.getObject();
		listaCoresComposicao.get(sequencialCor).setCor(corEscolha);
		facadeView.getListaMultiCor().get(sequencialCor).setCor(corEscolha);
		facadeView.getListaMultiCor().get(sequencialCor).setCorNome(corEscolha.getNome());
	}

	// retirado throw exepction da linaha 688 e adicionado try
	public StreamedContent getImagem() throws IOException {
		if (amostra.getLivroReferencia() == null) {
			//alterado teste para == 1, antes != 2
			if (operacaoPosterior == 1) {
				Messages.addGlobalError("Informe Referência, para apresentação da Imagem !");
				// adicionado em 26/05
			} else {
				operacaoPosterior = 0;
			}
			return new DefaultStreamedContent();
		}
		if (amostra.getAmostraId() != null) {
			List<ImagemReferencia> aux = facadeAcesso.existeImagem(amostra.getLivroReferencia().getLivroreferenciaid());
			if (aux.size() > 0) {
				altura = aux.get(0).getImheight().trim();
				largura = aux.get(0).getImwidth().trim();
				return aux.get(0).getImagem();
	
			} else {
				Messages.addGlobalError("Imagem não encontrada !");
				return new DefaultStreamedContent();
			}
		}else {
			return new DefaultStreamedContent();
		}
	}

//	public void setImagem(StreamedContent imagem) {
//		this.imagem = imagem;
//	}

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
		if ((corAmostra.getParCancelado().compareTo(BigDecimal.ZERO) != 0) && (corAmostra.getParCancelado().compareTo(BigDecimal.ZERO) != 0)) {
			if (amostra.getDataXfcFinal()== null) {
				Messages.addGlobalError("Para Cancelar,é necessário Amostra ser Produzida !");
				return;
			
			}else {
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
				if ((corAmostra.getParGvd().compareTo(BigDecimal.ZERO) != 0) && (diferenca.compareTo(new BigDecimal(0.5)) != 0)) {
					Messages.addGlobalError("Parte fracionaria Pares GVD nao pode ser diferente de .5, Corrija");
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
				if ((corAmostra.getParCancelado().compareTo(BigDecimal.ZERO) != 0) && (diferenca.compareTo(new BigDecimal(0.5)) != 0)) {
					Messages.addGlobalError("Parte fracionaria Pares cancelados nao pode ser diferente de .5, Corrija");
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
					mI++ ;
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
				}else {
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

	//Etapas Corte , Costura, Solado e Acabamento
	//Corte , podera ser selecionado uma Cor ou se pressionar na Aba, todas as cores

	public void inicializaCorteAmostra(){
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
		}else {
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
		}else {
			qtdCoresCorte = listaCoresCadastradas.size();
			if(qtdCoresCorte > listaCorCorteAmostra.size()) {
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
			}else if (qtdCoresCorte == 2) {
				parametros.setPricor(true);
				parametros.setSegcor(true);
			}else if (qtdCoresCorte == 3){
				parametros.setPricor(true);
				parametros.setSegcor(true);
				parametros.setTercor(true);
			}else if (qtdCoresCorte == 4 ) {
				parametros.setPricor(true);
				parametros.setSegcor(true);
				parametros.setTercor(true);
				parametros.setQuacor(true);
			}
		}
	}
		
	//Amostra Costura preenchimento dos dados e acabamentos
	public void inicializaCosturaAmostra() throws IOException{
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
		}else {
			costuraAmostra = costuraAmostraAux;
			
		}
		listaCorCosturaAmostra = new ArrayList<CorCosturaAm>();
		List<CorCosturaAm> listaAux = facadeAcesso.getBuscaCorCosturaAmostra(amostra.getAmostraId());
		if (listaAux != null ) {
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
		}else {
			qtdCoresCostura = listaCoresCadastradas.size();
			if(qtdCoresCostura > listaCorCosturaAmostra.size()) {
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
			}else if (qtdCoresCostura == 2) {
				parametros.setPricorb(true);
				parametros.setSegcorb(true);
			}else if (qtdCoresCostura == 3){
				parametros.setPricorb(true);
				parametros.setSegcorb(true);
				parametros.setTercorb(true);
			}else if (qtdCoresCostura == 4 ) {
				parametros.setPricorb(true);
				parametros.setSegcorb(true);
				parametros.setTercorb(true);
				parametros.setQuacorb(true);
			}
		}
	}

	// Amostras solado com base na construcao,mostra dados preenchidos para cores
	public void inicializaSoladoAmostra() throws IOException{
		Integer qtdCoresSolado = 0;
		if (listaCoresCadastradas.size() == 0) {
			Messages.addGlobalError("Por Favor, Incluir Primeiro Material/Cor(es)!");
			return; 
		}
		listaCorSoladoAmostra = new ArrayList<CorConstrucaoAm>();
		List<CorConstrucaoAm> listaAux = facadeAcesso.getBuscaCorSoladoAmostra(amostra.getAmostraId());
		if (listaAux != null ) {
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
		}else {
			qtdCoresSolado = listaCoresCadastradas.size();
			if(qtdCoresSolado > listaCorSoladoAmostra.size()) {
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
			}else if (qtdCoresSolado == 2) {
				parametros.setPricorc(true);
				parametros.setSegcorc(true);
			}else if (qtdCoresSolado == 3){
				parametros.setPricorc(true);
				parametros.setSegcorc(true);
				parametros.setTercorc(true);
			}else if (qtdCoresSolado == 4 ) {
				parametros.setPricorc(true);
				parametros.setSegcorc(true);
				parametros.setTercorc(true);
				parametros.setQuacorc(true);
			}
		}
		soladoAmostra = new Construcao();
		soladoAmostra = amostra.getLivroReferencia().getConstrucao();
		/*Busca pelo LivroReferencia, este objeto faz parte da amostra
		  Os dados devem ser apenas apresentados(readonly), nao podem ser editados.
		  para cada linha apresentada da construcao,preenche acabamento cores
		*/
	}

	// Amostras Acabamento, amostra dados preenchidos para cores
	public void inicializaAcabamentoAmostra() throws IOException{
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
		}else {
			acabamentoAmostra = acabamentoAmostraAux;
			
		}
		listaCorAcabamentoAmostra = new ArrayList<CorAcabamentoAm>();
		List<CorAcabamentoAm> listaAux = facadeAcesso.getBuscaCorAcabamentoAmostra(amostra.getAmostraId());
		if (listaAux != null ) {
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
		}else {
			qtdCoresAcabamento = listaCoresCadastradas.size();
			if(qtdCoresAcabamento > listaCorAcabamentoAmostra.size()) {
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
			}else if (qtdCoresAcabamento == 2) {
				parametros.setPricord(true);
				parametros.setSegcord(true);
			}else if (qtdCoresAcabamento == 3){
				parametros.setPricord(true);
				parametros.setSegcord(true);
				parametros.setTercord(true);
			}else if (qtdCoresAcabamento == 4 ) {
				parametros.setPricord(true);
				parametros.setSegcord(true);
				parametros.setTercord(true);
				parametros.setQuacord(true);
			}
		}
	}

	// Base para Salvar detalhes e combinacoes
	public void saveCorte() {

		//Save em duas parte, enviando - Corte e acabamentos

		try {
			corteAmostraDao.update(corteAmostra);
			corteAmostraDao.saveAmostraCorCorte(listaCorCorteAmostra);
			Messages.addGlobalInfo("Dados Detalhes Corte e Cores, Incluidos com  sucesso !");
			iniciaTransCorteCor();
			
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel incluir Detalhes Corte/Cores!");
			ex.printStackTrace();
			return;
		}
	}

	public void saveCostura() {

		//Save em duas parte, enviando - Costura e acabamentos

		try {
			costuraAmostraDao.update(costuraAmostra);
			costuraAmostraDao.saveAmostraCorCostura(listaCorCosturaAmostra);
			Messages.addGlobalInfo("Dados Detalhes Costura e Cores, Incluidos com  sucesso !");
			
			iniciaTransCosturaCor();
			
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel incluir Detalhes Costura/Cores !");
			ex.printStackTrace();
			return;
		}
	}
	
	public void saveSolado() {

		//Save em duas parte, enviando - Solado e acabamentos

		try {
		 corSoladoAmostraDao.saveAmostraCorSolado(listaCorSoladoAmostra);
		 parametros.setPricor(false);
		 Messages.addGlobalInfo("Dados Detalhes Cores Solado, Incluidos com  sucesso !");

		 iniciaTransSoladoCor();
		 
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel incluir Cores Solado !");
			ex.printStackTrace();
			return;
		}
	}
	
	public void saveAcabamento() {

		//Save em duas parte, enviando - Acabamento e cmbinacoes

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

	//Busca Attn para o cliente ficha
	public void buscaListaDestinoAm(Amostra attn) {
		listaDestinoAmCf = new ArrayList<>();
		listaDestinoAmCf = facadeAcesso.buscaDestinoAmCf(attn.getCliente().getGrpclienteinvoice().getGrupoclienteinvoiceid());
		
	}
}

