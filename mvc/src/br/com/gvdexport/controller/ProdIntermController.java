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
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.ToggleEvent;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
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
import br.com.gvdexport.model.Mercado;
import br.com.gvdexport.model.ParametrosTransientes;
import br.com.gvdexport.model.PrioridadeProducao;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.SituacaoProducao;
import br.com.gvdexport.model.Tipo;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ProdIntermController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Amostra amostra;
	@Getter
	@Setter
	private Amostra amostraFichaProduzirFinal;
	@Getter
	@Setter
	private List<Amostra> listaAmostraProduzir;
	@Getter
	@Setter
	private List<CorAmostra> listaTmpCoresSelecionasAmostras;
	@Getter
	@Setter
	private List<FichaProducao> listaFinalSelecaoProducao;
	@Getter
	@Setter
	private CorAmostra corAmostraClone;
	@Getter
	@Setter
	private ParametrosTransientes parametros;
	@Getter
	@Setter
	private CorAmostra corAmostra;
	@Getter
	@Setter
	private List<CorAmostra> listaCoresCadastradas;
	@Getter
	@Setter
	private LivroReferencia livroReferencia;
	@Getter
	@Setter
	private Cliente cliente;
	@Getter
	@Setter
	private Construcao construcao;
	@Getter
	@Setter
	private Fabrica fabrica;
	@Getter
	@Setter
	private Forma forma;
	@Getter
	@Setter
	private Estacao estacaoCliente;
	@Getter
	@Setter
	private Amostra amostraClone;
	@Getter
	@Setter
	private List<LivroReferencia> listaLivroReferencia;
	@Getter
	@Setter
	private List<Amostra> listaFiltroAmostras;
	@Getter
	@Setter
	private Integer operacao;
	@Getter
	@Setter
	private Integer operacaoPosterior;
	@Getter
	@Setter
	private LivroReferencia referenciaSelecionada;
	@Getter
	@Setter
	private List<Estacao> listaEstacoes;
	@Getter
	@Setter
	private Integer qtdCores;
	@Getter
	@Setter
	private Boolean parcialTotal;

	private String activeIndexes = null;
	private List<Tab> accordionTabs = null;

	// Esta variavel,deve ser tambem relacionada com o tipo de usuario

	@Getter
	@Setter
	private List<Tipo> tipoamostra = Arrays.asList(Tipo.values());
	@Getter
	@Setter
	private List<Mercado> mercado = Arrays.asList(Mercado.values());
	@Getter
	@Setter
	private List<PrioridadeProducao> prioridade = Arrays.asList(PrioridadeProducao.values());
	@Getter
	@Setter
	private List<SimNao> simNao = Arrays.asList(SimNao.values());
	@Getter
	@Setter
	private List<EmTransicao> emTransicao = Arrays.asList(EmTransicao.values());
	@Getter
	@Setter
	private List<DireitoEsquerdo> direitoEsquerdo = Arrays.asList(DireitoEsquerdo.values());
	@Getter
	@Setter
	private CorAmostra coresAmostra;
	//
	// Datas usadas na pesquisa
	//
	@Getter
	@Setter
	private Date iniSolicitacao;
	@Getter
	@Setter
	private Date finSolicitacao;
	@Getter
	@Setter
	private Date iniliberap;
	@Getter
	@Setter
	private Date finliberap;
	@Getter
	@Setter
	private String informaCor;
	@Getter
	@Setter
	private String informaCorp;
	@Getter
	@Setter
	private Integer sequenciaCor;
	@Getter
	@Setter
	private Integer ultimaSequencia;
	@Getter
	@Setter
	private Integer qtdFichas;

	@Inject
	private CrudDao<Amostra, Long> amostraDao;

	@Inject
	private CrudDao<FichaProducao, Long> fichaProducaoDao;

	@Inject
	private FacadeAcesso facadeAcesso;

	@Inject
	private UsuarioLogadoController usuarioLogado;

	@Inject
	private CrudDao<CorAmostra, Long> corAmostraNovaDao;

	@PostConstruct
	public void init() {
		amostra = new Amostra();
		qtdFichas = 0;
		listaLivroReferencia = new ArrayList<LivroReferencia>();
		listaAmostraProduzir = new ArrayList<Amostra>();
		listaAmostraProduzir = facadeAcesso.getExisteFichaNLAmostra();
		if ((listaAmostraProduzir == null) || (listaAmostraProduzir.isEmpty())) {
			qtdFichas = 0;
		}else {
			qtdFichas = listaAmostraProduzir.size();
		}
		listaFiltroAmostras = new ArrayList<Amostra>();
		listaCoresCadastradas = new ArrayList<>();
		listaEstacoes = new ArrayList<Estacao>();
		operacaoPosterior = 0;
		operacao = 0;
	}

	// ajusta selecao das cores caso, seja marcado na amostra
	public void checkCoresDaAmostra(Amostra auxAmostra) {
		Integer xCores = 0;
		if (auxAmostra.getCoresAmostra().size() > 1) {
			xCores = (auxAmostra.getCoresAmostra().size() - 1);
		   
	   }else {
			xCores = (auxAmostra.getCoresAmostra().size());
	   }
		setQtdCores(0);
		if (auxAmostra.getAmostraselecao()) {
			for (int i = 0; i < xCores; i++) {
				if (auxAmostra.getCoresAmostra().get(i).getDesenvolveramostra().equals(SimNao.S)) {
					if (!auxAmostra.getCoresAmostra().get(i).getProducao()) {
						auxAmostra.getCoresAmostra().get(i).setCorselecao(true);
						qtdCores++;
					}
				}
			}
		}else {
			for (int i = 0; i < xCores; i++) {
				if (auxAmostra.getCoresAmostra().get(i).getDesenvolveramostra().equals(SimNao.S)) {
					if (!auxAmostra.getCoresAmostra().get(i).getProducao()) {
						auxAmostra.getCoresAmostra().get(i).setCorselecao(false);
						qtdCores++;
					}
				}
			}
		}
	}

	//
	// Primeira etapa para geracao das fichas
	//
	// Metodos para identificar selecao total ou parcial

	public void gerarFichadeProducao() {
		Boolean temFichaCorSelecionada = false;
		parcialTotal = false;
		Integer xCores = 0;
		setQtdCores(0);
		for (Amostra amostraFichaProduzir : listaAmostraProduzir) {
			if (amostraFichaProduzir.getCoresAmostra().size() > 1) {
			  xCores = (amostraFichaProduzir.getCoresAmostra().size() - 1);
			}else
			{
			  xCores = (amostraFichaProduzir.getCoresAmostra().size());
			}
			for (int i = 0; i < xCores; i++) {
				if ((amostraFichaProduzir.getCoresAmostra().get(i).getCorselecao() != null) && (amostraFichaProduzir.getCoresAmostra().get(i).getCorselecao())) {
					temFichaCorSelecionada = true;
				}
			if (amostraFichaProduzir.getCoresAmostra().get(i).getDesenvolveramostra().equals(SimNao.S)) {
				qtdCores++;
			}
		}
		}
		if (!temFichaCorSelecionada) {
			if (qtdCores > 1) {
			Messages.addGlobalError("Selecione pelo menos uma cor !");
			return;
			}
		}
		amostraFichaProduzirFinal = new Amostra();
		for (Amostra amostraFichaProduzir : listaAmostraProduzir) {
			gerarFichaProdCor(amostraFichaProduzir);
			amostraFichaProduzirFinal = amostraFichaProduzir;
		}
		// Tudo certo, gera linhas de gravacao no banco
		//
		if ((listaTmpCoresSelecionasAmostras != null) && (!listaTmpCoresSelecionasAmostras.isEmpty())) {
			Boolean geradaOk = geraBancoFichaProducao();
			if ((geradaOk) && (parcialTotal)) {
				amostraFichaProduzirFinal.setGerada(true);
				amostraDao.update(amostraFichaProduzirFinal);
			} else {
				amostraFichaProduzirFinal.setGerada(false);
				amostraDao.update(amostraFichaProduzirFinal);
			}
			amostraFichaProduzirFinal = new Amostra();
			// Refaz consulta se ha pendencias e renova visao do datatable
			listaAmostraProduzir = facadeAcesso.getExisteFichaNLAmostra();
			if (listaAmostraProduzir.size() == 0) {
				qtdFichas = 0;
			}
		} else {
			Messages.addGlobalWarn("Não ha Amostras para geração de Producao!");
			return;
		}
	}

	// Metodo auxiliar para gravacao das cores selecionadas
	public void gerarFichaProdCor(Amostra amostraFichaProduzir) {
		Integer xCores = 0;
		if (amostraFichaProduzir.getCoresAmostra().size() > 1) {
			xCores = (amostraFichaProduzir.getCoresAmostra().size() - 1);
		}else {
			xCores = amostraFichaProduzir.getCoresAmostra().size();
		}
		Integer xCoresGeradas = 0; // Aqui mostrar se ha fichas ja criadas
		listaTmpCoresSelecionasAmostras = new ArrayList<>();
		// duas situacoes, se for marcado na amostra pega todas, se nao verificar cores
		// afirmadas
		if (amostraFichaProduzir.getAmostraselecao()) {
			for (int i = 0; i < xCores; i++) {
				if ((amostraFichaProduzir.getCoresAmostra().get(i).getDesenvolveramostra().equals(SimNao.S))) {
					listaTmpCoresSelecionasAmostras.add(amostraFichaProduzir.getCoresAmostra().get(i));
					if ((amostraFichaProduzir.getGerada() != null) && (amostraFichaProduzir.getGerada())) {
						xCoresGeradas++;
					}
				}
			}
		} else {
			for (int i = 0; i < xCores; i++) {
				if ((amostraFichaProduzir.getCoresAmostra().get(i).getCorselecao() != null)
						&& (amostraFichaProduzir.getCoresAmostra().get(i).getCorselecao())
						&& (amostraFichaProduzir.getCoresAmostra().get(i).getDesenvolveramostra().equals(SimNao.S))
						&& (!amostraFichaProduzir.getCoresAmostra().get(i).getProducao())) {
					listaTmpCoresSelecionasAmostras.add(amostraFichaProduzir.getCoresAmostra().get(i));
				}
				if ((amostraFichaProduzir.getCoresAmostra().get(i).getProducao() != null) && (amostraFichaProduzir.getCoresAmostra().get(i).getProducao())) {
					xCoresGeradas++;
				}
			}
			// Codigo determina se a amostra foi criada parcial ou total, se parcial
			// gerada=false,pois podera ser gerada
			// em momento posterior, outra(as) cores
		}
		if ((xCoresGeradas+1) == qtdCores) {
			setParcialTotal(true);

		} else {
			setParcialTotal(false);

		}

	}

	//
	// Segunda etapa, geracao e gravacao no banco das fichas selecionadas com base
	// na cor
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
				String marcaCerta = "\u2713";
				fichaProducaoDao.update(fichaProducao);
				Messages.addGlobalInfo("Ficha Produção Gerada com sucesso !");
				corFinal.setProducao(true);
				corFinal.setMarca(marcaCerta);
				corAmostraNovaDao.update(corFinal);
				geradaOk = true;
			} catch (RuntimeException ex) {
				Messages.addGlobalError(
						"Não foi possivel gerar ficha de Produção !" + "-" + fichaProducao.getAmostra());
				ex.printStackTrace();
			}
		}
		return geradaOk;
	}

	public void inicializaParametros() {
		parametros = new ParametrosTransientes();
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

	public void estacaoSelecionada(SelectEvent event) {
		estacaoCliente = new Estacao();
		estacaoCliente = (Estacao) event.getObject();
		amostra.setEstacao(estacaoCliente);
	}

	public void corSelecionada(SelectEvent event) {
		Cor corEscolha = new Cor();
		corEscolha = (Cor) event.getObject();
	}
    public void filtrosManIntProducao(ToggleEvent event) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Filtros", "Visiveis:" + event.getVisibility());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
