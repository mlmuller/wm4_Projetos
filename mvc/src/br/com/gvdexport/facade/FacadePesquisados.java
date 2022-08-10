package br.com.gvdexport.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;

import br.com.gvdexport.controller.AmostraNovaController;
import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.model.Cliente;
import br.com.gvdexport.model.Componente;
import br.com.gvdexport.model.Construcao;
import br.com.gvdexport.model.Cor;
import br.com.gvdexport.model.CorAmostra;
import br.com.gvdexport.model.CorAmostraMulti;
import br.com.gvdexport.model.Estacao;
import br.com.gvdexport.model.Fabrica;
import br.com.gvdexport.model.Forma;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.MarcaCliente;
import br.com.gvdexport.model.Material;
import br.com.gvdexport.model.Modelo;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class FacadePesquisados implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter	@Setter
	private List<LivroReferencia> listaReferencias;
	@Getter	@Setter
	private List<Cliente> listaClientes;
	@Getter	@Setter
	private List<Estacao> listaEstacoes;
	@Getter	@Setter
	private List<Fabrica> listaFabricas;
	@Getter	@Setter
	private List<Construcao> listaConstrucoes;
	@Getter	@Setter
	private List<Modelo> listaModelos;
	@Getter	@Setter
	private List<Componente> listaProdutos;
	@Getter	@Setter
	private List<Forma> listaFormas;
	@Getter	@Setter
	private List<MarcaCliente> listaMarcaCliente;
	@Getter	@Setter
	private List<Material> listaMaterial;
	@Getter	@Setter
	private String posicaoMaterial;
	@Getter	@Setter
	private String posicaoMaterialRes;
	@Getter	@Setter
	private String materialFinal;
	@Getter	@Setter
	private String materialFinalRes;
	@Getter	@Setter
	private String corPosicaoFinal;
	@Getter	@Setter
	private String corFinal;
	@Getter	@Setter
	private String corFinalRes;
//	@Getter	@Setter
//	private String posicaoCor;
//	@Getter	@Setter
//	private String posicaoCorRes;
	@Getter	@Setter
	private String cor;
	@Getter	@Setter
	private List<Cor> listaCor;
	@Getter	@Setter
	private String informaReferencia;
	@Getter	@Setter
	private Modelo modelo;
	@Getter	@Setter
	private String informaCliente;
	@Getter	@Setter
	private String informaEstacao;
	@Getter	@Setter
	private String informaFabrica;
	@Getter	@Setter
	private String informaConstrucao;
	@Getter	@Setter
	private String informaForma;
	@Getter	@Setter
	private String informaModelo;
	@Getter	@Setter
	private String informaProduto;
	@Getter	@Setter
	private String informaMarcaCliente;
	@Getter	@Setter
	private String informaMaterial;
	@Getter	@Setter
	private String informaCor;
	@Getter	@Setter
	private String tipoComponente;
	@Getter	@Setter
	private List<CorAmostraMulti> listaMultiCor;
	@Getter	@Setter
	private List<CorAmostraMulti> listaMultiTemp;
	@Getter	@Setter
	private CorAmostraMulti corAmostraMulti;
	@Getter @Setter 
	private CorAmostraMulti corAmostraMultiBase;
	@Getter	@Setter
	private Integer PrimeiraCor;
	@Getter	@Setter
	private Integer PrimeiroMaterial;
	@Getter @Setter
	private String complementar;
	@Getter	@Setter
	private Boolean btnVisao;
	@Getter	@Setter
	private Integer ultimoMaterial;
	@Getter	@Setter
	private String principalCor;
	
	@Inject
	private FacadeAcesso facadeAcesso;

	@Inject
	private AmostraNovaController amostraController;

	@Inject
	private CrudDao<CorAmostraMulti, Long> corAmostraNovaMultiDao;
	@PostConstruct
	public void init() {
		informaReferencia = "";
		informaCliente = "";
		informaEstacao = "";
		informaFabrica = "";
		informaConstrucao = "";
		informaForma = "";
		informaModelo = "";
		informaProduto = "";
		amostraController.setBtnVisao(true);
		listaMultiCor = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			corAmostraMulti = new CorAmostraMulti();
			corAmostraMulti.setCorPrincipal(false);
			corAmostraMulti.setSequenciaPosicao(i + 1);
			corAmostraMulti.setSeqMaterial(0);
			corAmostraMulti.setSeqCor(0);
			corAmostraMulti.setCompletaCor("");
			listaMultiCor.add(corAmostraMulti);
		}
			btnVisao = false;
	}
	public void edit(String referencia, String cliente, String estacao) {
		informaReferencia = referencia;
		informaCliente = cliente;
		informaEstacao = estacao;
	}

	// Atualiza para complementar cor
	public void editCor(String referencia, String cliente, String estacao, String fabrica, String produto) {
		informaReferencia = referencia;
		informaCliente = cliente;
		informaEstacao = estacao;
		informaProduto = produto;
		informaFabrica = fabrica;
	}

	// Popular Lista conforme solicitacao (On Demand)
	public void buscaReferencia(Integer referencia) {

		listaReferencias = new ArrayList<LivroReferencia>();
		listaReferencias = facadeAcesso.existeLivroReferencia(referencia);
		if (listaReferencias.size() == 0) {
			Messages.addGlobalWarn("Informação solicitada não encontrada !");
			return;
		}
	}

	public void buscaCliente(String nomeCliente) {
		listaClientes = new ArrayList<Cliente>();
		listaClientes = facadeAcesso.buscaCliente(nomeCliente);
	}

	public void buscaEstacao(String estacao) {
		listaEstacoes = new ArrayList<Estacao>();
		listaEstacoes = facadeAcesso.existeEstacao(estacao);
	}

	public void buscaFabrica(String nomeFabrica) {

		listaFabricas = new ArrayList<Fabrica>();
		listaFabricas = facadeAcesso.buscaFabrica(nomeFabrica);
	}

	public void buscaConstrucao(String construcao) {
		listaConstrucoes = new ArrayList<Construcao>();
		listaConstrucoes = facadeAcesso.existeConstrucoes(construcao);
	}

	public void buscaForma(String forma) {
		listaFormas = new ArrayList<Forma>();
		listaFormas = facadeAcesso.existeFormaReferencia(forma);
	}

	public void buscaModelo(String modelo) {
		listaModelos = new ArrayList<Modelo>();
		listaModelos = facadeAcesso.existeNomeModelo(modelo);
	}

	public void buscaProdutoDescricao(String descricao) {
		listaProdutos = new ArrayList<Componente>();
		tipoComponente = "B";
		listaProdutos = facadeAcesso.existeComponente(tipoComponente, descricao);
	}

	public void buscaMarcaCliente(String marcaCliente) {
		listaMarcaCliente = new ArrayList<MarcaCliente>();
		listaMarcaCliente = facadeAcesso.existeMarcaCliente(marcaCliente);
	}

	public void buscaMaterial(String nomeMaterial) {
		listaMaterial = new ArrayList<Material>();
		listaMaterial = facadeAcesso.existeMaterial(nomeMaterial);

	}

	public void buscaCor(String nomeCor) {
		listaCor = new ArrayList<>();
		listaCor = facadeAcesso.existeCor(nomeCor);
	}

	// ------Visão Livro Referencias
	public void visaoLivroReferencia() {
		if(informaReferencia.isEmpty()) {
			Messages.addGlobalInfo("Informe Referencia para pesquisa !");
			return;
		}
		Integer referenciaSelecionada = Integer.parseInt(informaReferencia);
		buscaReferencia(referenciaSelecionada);
		if (listaReferencias.size() == 0) {
			Messages.addGlobalWarn("Não foi encontrada Referencia !");
			return;
		}
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 540);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "referenciaheader");
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkReferencia", options, null);
	}

	public void Selecionar(LivroReferencia referencia) {
		PrimeFaces.current().dialog().closeDynamic(referencia);
		informaReferencia = referencia.getReferencia().toString().trim();
	}

	// ----Visão Clientes
	public void visaoCliente() {
		if (informaCliente.isEmpty()) {
			Messages.addGlobalInfo("Informe um cliente ou Letra para pesquisa !");
			return;
		}
		buscaCliente(informaCliente.toUpperCase());
		if (listaClientes.size() == 0) {
			Messages.addGlobalWarn("Informação Cliente solicitado não encontrado !");
			return;
		}

		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 640);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "clienteheader");
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkCliente", options, null);
	}

	public void selecionarCliente(Cliente cliente) {
		PrimeFaces.current().dialog().closeDynamic(cliente);
		informaCliente = cliente.getSucinto();
	}

//-----------------------------------------------------    
	// ----Visão Estações
	public void visaoEstacao() {
		if (informaEstacao.trim().isEmpty()) {
			Messages.addGlobalWarn("Não foi informado Estação,verifique !");
			return;
		}

		buscaEstacao(informaEstacao);
		if (listaEstacoes.size() == 0) {
			Messages.addGlobalWarn("Informação Estação solicitada não encontrada !");
			return;
		}
		
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 540);
		options.put("height", 240);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "estacaoheader");
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkEstacao", options, null);
	}

	public void selecionarEstacao(Estacao estacao) {
		PrimeFaces.current().dialog().closeDynamic(estacao);
		informaEstacao = estacao.getNome();
	}

	// ----Visão Fabricas
	public void visaoFabrica() {
		if (informaFabrica.isEmpty()) {
			Messages.addGlobalInfo("Informe Fabrica ou Caracter para busca !");
			return;
		}
		buscaFabrica(informaFabrica.toUpperCase());
		if (listaFabricas.size() == 0) {
			Messages.addGlobalError("Fábrica ionformada não Localizada !");
			return;
		}
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 540);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "fabricaheader");
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkFabrica", options, null);
	}

	public void selecionarFabrica(Fabrica fabrica) {
		PrimeFaces.current().dialog().closeDynamic(fabrica);
		informaFabrica = fabrica.getSucinto();
	}

	// ------Visão construção
	public void visaoConstrucao() {
		informaConstrucao.equals(null);
		buscaConstrucao(informaConstrucao.toUpperCase());
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 540);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "construcaoheader");
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkConstrucao", options, null);
	}

	public void SelecionarConstrucao(Construcao construcao) {
		PrimeFaces.current().dialog().closeDynamic(construcao);
	}

	// ----Visão Forma
	public void visaoForma() {
		informaForma.equals(null);
		buscaForma(informaForma);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 540);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "formaheader");
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkForma", options, null);
	}

	public void selecionarForma(Forma forma) {
		PrimeFaces.current().dialog().closeDynamic(forma);
		informaForma = forma.getReferenciaforma();
	}

	// ----Visão Componente
	public void visaoComponente() {
		informaProduto.equals(null);
		buscaProdutoDescricao(informaProduto);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 540);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "componenteheader");
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkComponente", options, null);
	}

	public void selecionarComponente(Componente componente) {
		PrimeFaces.current().dialog().closeDynamic(componente);
		informaProduto = componente.getDef1().trim();
	}

	// ----Visão Modelo
	public void visaoModelo() {
		informaModelo.equals(null);
		buscaForma(informaModelo);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 640);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "modeloheader");
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkModelo", options, null);
	}

	public void selecionarModelo(Modelo modelo) {
		PrimeFaces.current().dialog().closeDynamic(modelo);
		informaModelo = modelo.getNome();
	}

	// ----Visão Marca Cliente
	public void visaoMarcaCliente() {
		informaMarcaCliente.equals(null);
		buscaForma(informaMarcaCliente);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 640);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "marcaclienteheader");
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkMarcaCliente", options, null);
	}

	public void selecionarMarcaCliente(MarcaCliente marcacliente) {
		PrimeFaces.current().dialog().closeDynamic(marcacliente);
		informaModelo = modelo.getNome();
	}

	// ------Visão Materiais
	public void visaoMultiMaterial(Integer posicao) {
		informaMaterial = listaMultiCor.get(posicao).getMatNome().trim();
		amostraController.setSequencialCor(posicao);
		buscaMaterial(informaMaterial);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 540);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "materialheader");
		options.put("closable", false);
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkMaterial", options, null);
	}
	
	public void selecionarMaterial(Material material) {
		PrimeFaces.current().dialog().closeDynamic(material);
		informaMaterial = material.getNome();

	}

	// ------Visão Materiais
	public void visaoMultiCor(Integer posicao) {
		informaCor = listaMultiCor.get(posicao).getCorNome().trim();
		amostraController.setSequencialCor(posicao);
		buscaCor(informaCor);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 540);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "corheader");
		options.put("resizable", false);
		options.put("position", "center right");
		options.put("showEffect", "flip");
		PrimeFaces.current().dialog().openDynamic("frkCor", options, null);
	}

	public void selecionarCor(Cor cor) {
		PrimeFaces.current().dialog().closeDynamic(cor);
		informaCor = cor.getNome();
	}

	public void ComporMulti() {
		// Composicao Material
		// --------------------------------------------------------------------------
		listaMultiTemp = new ArrayList<>();
		Integer verificaQuantosElementos = 0;
		Integer corPrincipal = 0;
		for (int i = 0; i < listaMultiCor.size(); i++) {
			if (listaMultiCor.get(i).getMaterial() != null) {
				verificaQuantosElementos++;
			}
			if (listaMultiCor.get(i).getCorPrincipal()) {
				corPrincipal++;
			}
		}
		materialFinal = "";
		materialFinalRes="";
		posicaoMaterial = "";
		posicaoMaterialRes="";
		Boolean primeiraVez = true;
		if (verificaQuantosElementos < 2) {
			listaMultiCor.get(0).setSeqMaterial(1);
			posicaoMaterial = listaMultiCor.get(0).getMatNome();
			posicaoMaterialRes = listaMultiCor.get(0).getMaterial().getResumido();
			materialFinal = listaMultiCor.get(0).getMatNome();
			amostraController.getCorAmostra().setMaterial(listaMultiCor.get(0).getMatNome());
		} else {
			AjustaCorMaterial(listaMultiCor, verificaQuantosElementos);
			sortedByIndexMatMulti(listaMultiCor);
			Integer posicao = 0;
			//
			posicao = PrimeiraPosicaoMaterial(listaMultiCor);
			//

			for (int i = 0; i < listaMultiCor.size(); i++) {
				if (listaMultiCor.get(i).getMaterial() != null) {
					if ((listaMultiCor.get(i).getSeqMaterial() == posicao)) {

						if (primeiraVez) {
							materialFinal = materialFinal + "-" + listaMultiCor.get(i).getMatNome().trim();
							materialFinalRes = materialFinalRes + "-" + listaMultiCor.get(i).getMaterial().getResumido().trim();
							primeiraVez = false;
							posicaoMaterial = posicaoMaterial + "("
									+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
							posicaoMaterialRes = posicaoMaterialRes + "("
									+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim();

						} else {
							posicaoMaterial = posicaoMaterial + "."
									+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
							posicaoMaterialRes = posicaoMaterialRes + "."
									+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
						}

					} else {

						posicaoMaterial = posicaoMaterial + ")";
						posicaoMaterialRes = posicaoMaterialRes + ")";
						posicaoMaterial = posicaoMaterial + materialFinal + ",";
						posicaoMaterialRes = posicaoMaterialRes + materialFinalRes + ",";
						posicao = listaMultiCor.get(i).getSeqMaterial();
						materialFinal = "";
						materialFinalRes = "";
						materialFinal = materialFinal + "-" + listaMultiCor.get(i).getMatNome().trim();
						materialFinalRes = materialFinalRes + "-" + listaMultiCor.get(i).getMaterial().getResumido().trim();
						posicaoMaterial = posicaoMaterial + "("
								+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
						posicaoMaterialRes = posicaoMaterialRes + "("
								+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim();

					}
				}

			}
			posicaoMaterial = posicaoMaterial + ")";
			posicaoMaterialRes = posicaoMaterialRes + ")";

			posicaoMaterial = posicaoMaterial + materialFinal;
			posicaoMaterialRes = posicaoMaterialRes + materialFinalRes;
			
			if (posicaoMaterial.trim().length() > 60) {
				materialFinal = posicaoMaterialRes.trim();
			}else {
				materialFinal = posicaoMaterial.trim();
			}
		}
		//Armazena dados obtidos na composicao de Material
		// --------------------------------------------------------------------------------------------
		// Composicao Cor
		String posicaoCor = "";
		String posicaoCorRes = "";
		String complemento = "";
		String complementoRes = "";
		complementar = "";
		String complementarRes = "";
		corFinal="";
		corFinalRes="";
		primeiraVez = true;
		if (verificaQuantosElementos < 2) {
			listaMultiCor.get(0).setSeqCor(1);
			amostraController.getCorAmostra().setCorPrincipal(listaMultiCor.get(0).getCor().getNome());
			amostraController.getCorAmostra().setCor(listaMultiCor.get(0).getCorNome());
			materialFinalRes = listaMultiCor.get(0).getCor().getResumido();
			corPosicaoFinal =listaMultiCor.get(0).getCorNome() + " " + listaMultiCor.get(0).getCompletaCor().trim();
			principalCor = listaMultiCor.get(0).getCorNome();
			corFinal = corPosicaoFinal;
			corFinalRes = materialFinalRes;
			return;
		} else {
			// Ordena antes da Montagem...
			AjustaCor(listaMultiCor, verificaQuantosElementos);
			//
			Collections.sort(listaMultiCor, Comparator.comparing(CorAmostraMulti::getSeqCor)
					.thenComparing(CorAmostraMulti::getCompletaCor));
			//
			// aqui faria a chamado do metodo para ordenar...
			//Collections.sort(listaMultiCor);
			Integer posicao = 0;
			//
			posicao = PrimeiraPosicaoCor(listaMultiCor);
			principalCor = "";
			//
			Integer i = 0;
			Boolean executaLaco = true;
			Boolean executadoFinal = false;
			// verificaQuantosElementos--;
			// ----
			do {
				// se cor igual
				if (listaMultiCor.get(i).getCor() != null) {
					if (listaMultiCor.get(i).getCorPrincipal()) {
						principalCor = listaMultiCor.get(i).getCor().getNome();
					}
					if ((listaMultiCor.get(i).getSeqCor() == posicao) && (i < (listaMultiCor.size())) && (listaMultiCor.get(i).getCompletaCor().trim().equals(complementar))) {
							if (primeiraVez) {
								complemento = "-" + listaMultiCor.get(i).getCorNome().trim() + " "+ listaMultiCor.get(i).getCompletaCor().trim() + ",";
								complementoRes = "-" + listaMultiCor.get(i).getCor().getResumido().trim() + " " + listaMultiCor.get(i).getCompletaCor().trim() + ",";
								posicaoCor = "(" + posicaoCor + listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
								posicaoCorRes = "(" + posicaoCorRes	+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
								primeiraVez = false;
							} else {
								if (i <= (listaMultiCor.size()-1) ) {
									posicaoCor = posicaoCor + "." + listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
									posicaoCorRes = posicaoCorRes + "."	+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim();

									
								} else {
									if ((materialFinal.trim().isEmpty())) {
										posicaoCor = posicaoCor + "." + listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
										posicaoCor = posicaoCor + ")";
										
										posicaoCorRes = posicaoCorRes + "."
												+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
										posicaoCorRes = posicaoCorRes + ")";

										corFinal = posicaoCor + "" + complemento;
										corFinalRes = posicaoCorRes + " " + complementoRes;

									} else {
										corFinal = corFinal + posicaoCor + listaMultiCor.get(i).getCorNome().trim()
												+ " " + listaMultiCor.get(i).getCompletaCor().trim();

										corFinalRes = corFinalRes + posicaoCorRes + listaMultiCor.get(i).getCor().getResumido().trim()
												+ " " + listaMultiCor.get(i).getCompletaCor().trim();

									}
									executadoFinal = true;

								}
							}

					} else {

						if (i <= (listaMultiCor.size()-1)) {
							if (!posicaoCor.isEmpty()) {	
							    posicaoCor = posicaoCor + ")";
								posicaoCorRes = posicaoCorRes + ")";
							}
							// adicionado na expressao materialFinal antes posicao
							corFinal = corFinal + posicaoCor + complemento;
							corFinalRes = corFinalRes + posicaoCorRes + complementoRes;

							posicaoCor = "(" + listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
							posicaoCorRes = "(" + listaMultiCor.get(i).getSequenciaPosicao().toString().trim();
							complemento = "-" + listaMultiCor.get(i).getCorNome().trim() + " "
									+ listaMultiCor.get(i).getCompletaCor().trim().trim() + ",";
							complementoRes = "-" + listaMultiCor.get(i).getCor().getResumido().trim() + " "
									+ listaMultiCor.get(i).getCompletaCor().trim() + ",";
							
						} else {
							posicaoCor = "(" + listaMultiCor.get(i).getSequenciaPosicao().toString().trim() + ")";
							posicaoCorRes = "(" + listaMultiCor.get(i).getSequenciaPosicao().toString().trim() + ")";

							complemento = "-" + listaMultiCor.get(i).getCorNome ().trim();
							complementoRes = "-" + listaMultiCor.get(i).getCor().getResumido().trim();

							executadoFinal = true;
							if ((corFinal.trim().isEmpty())) {
								corFinal = posicaoCor + "" + complemento + "("
										+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim() + ")" + "-"
										+ listaMultiCor.get(i).getCorNome().trim() + " "
										+ listaMultiCor.get(i).getCompletaCor().trim();

								corFinalRes = posicaoCorRes + "" + complementoRes + "("
										+ listaMultiCor.get(i).getSequenciaPosicao().toString().trim() + ")" + "-"
										+ listaMultiCor.get(i).getCor().getResumido().trim() + " "
										+ listaMultiCor.get(i).getCompletaCor().trim();
								
							} else {
								// adicionado complementos em funcao de 3 combinacoes...
								corFinal = corFinal + posicaoCor + complemento + " "
										+ listaMultiCor.get(i).getCompletaCor().trim();

								corFinalRes = corFinalRes + posicaoCorRes + complementoRes + " "
										+ listaMultiCor.get(i).getCompletaCor().trim()+"";

								executadoFinal = true;
							}
						}
						// adicionado em 04112020
						posicao = listaMultiCor.get(i).getSeqCor();
						//
						if (!listaMultiCor.get(i).getCompletaCor().trim().equals(complementar)) {
							complementar = listaMultiCor.get(i).getCompletaCor().trim();
							complementarRes = listaMultiCor.get(i).getCompletaCor().trim();
						}
					}
				}

				i++;
				if (i > (listaMultiCor.size() - 1)) {
					executaLaco = false;
					if (!executadoFinal) {
						posicaoCor = posicaoCor + ")";
						posicaoCorRes = posicaoCorRes + ")";
						corFinal = corFinal + posicaoCor + complemento;
						corFinalRes = corFinalRes + posicaoCorRes + complementoRes;
						
					}

				}
			} while (executaLaco);
			//Armazena dados na composicao das Cor(es)
			amostraController.getCorAmostra().setCorPrincipal(principalCor);
			Integer compCompleto = corFinal.trim().length();
			Integer compResumida = corFinalRes.trim().length();
			if (compCompleto < 70) {
				corPosicaoFinal = corFinal.trim();
			}else {
				if (compResumida > 70) {
					corPosicaoFinal = corFinalRes.substring(0,69);
				}else {
					corPosicaoFinal = corFinalRes.trim();
				}
			}
			
		}
		
	}

	public void RefazComporMulti() {
		sortedByIndexPosicao(listaMultiCor);
		Integer posicaoMulti = 0;
		amostraController.setRefazComposicao(1);
//		posicaoMulti = listaMultiCor.size();
		// Reinicializara para zero os sequencias de cor e material,pois foi adicionado
		// novo item
		RefazSequencias(listaMultiCor);
		posicaoMulti = PrimeiraPosicaoMaterial(listaMultiCor);
		AjustaHabilitacoes(posicaoMulti, listaMultiCor);
		amostraController.setBtnVisao(false);
	}

	// Consistencia Montagem Material
	public void AjustaCorMaterial(List<CorAmostraMulti> listaMulti, Integer quantosElementos) {
		Long posicao = listaMulti.get(0).getMaterial().getMaterialid();
		Integer matContador = 1;
		for (int i = 0; i < listaMulti.size(); i++) {
			if(listaMulti.get(i).getMaterial() != null) {
				posicao = listaMultiCor.get(i).getMaterial().getMaterialid();
				listaMulti.get(i).setSeqMaterial(matContador);
				break;
			}
		}
		//
		// Nao pode ocorrer material sem cor ou vice-versa
		//

		for (int i = 0; i < listaMulti.size(); i++) {
			listaMulti.get(i).setSeqMaterial(0);
			if (listaMulti.get(i).getMatNome() != null) {
				if ((listaMulti.get(i).getMatNome().trim().isEmpty()) && (listaMulti.get(i).getMaterial() != null)) {
					listaMulti.get(i).setMaterial(null);
					listaMulti.get(i).setCor(null);
					listaMulti.get(i).setCorNome("");
				}
				if ((listaMulti.get(i).getCorNome().trim().isEmpty()) && (listaMulti.get(i).getCor() != null)) {
					listaMulti.get(i).setMaterial(null);
					listaMulti.get(i).setCor(null);
					listaMulti.get(i).setMatNome("");
				}
			}
		}
		// ----------------------------------------------------------------
		for (int i = 0; i < listaMulti.size(); i++) {

			if (listaMulti.get(i).getMaterial() != null) {

				if (listaMulti.get(i).getMaterial().getMaterialid() != posicao) {
					posicao = listaMulti.get(i).getMaterial().getMaterialid();
					matContador++;
				}

				for (int j = 0; j < listaMulti.size(); j++) {

					if ((listaMulti.get(j).getMaterial() != null)) {
						if (listaMulti.get(j).getSeqMaterial() == 0) {
							if (listaMulti.get(j).getMaterial().getMaterialid() == posicao) {
								listaMulti.get(j).setSeqMaterial(matContador);
							}
						}
					}

				}

			}
		}

	}
	public void apagaDadosMulti(Integer linhaMulti) {
		//Metodo para limpar dados da linha,caso usuario retire os dados limpando os campos
		//busca nova posicao de material
		
		PrimeiraPosicaoMaterial(listaMultiCor);
		if (ultimoMaterial == 1) {
			Messages.addGlobalWarn("Não é permitido Cancelar todas as linhas!");
			return;
		}
		if (listaMultiCor != null){
			amostraController.setBtnVisao(false);
			corAmostraMultiBase = new CorAmostraMulti();
			try {
				if (amostraController.getOperacao() == 1) {
					corAmostraNovaMultiDao.delete(listaMultiCor.get(linhaMulti).getCormultiid());
					Messages.addGlobalInfo("Linha Multi Cor, removida com sucesso !");
				}
				amostraController.getParametros().setBtnfecha(false);
			} catch (Exception ex) {
				Messages.addGlobalError("Não foi possivel remover linha Multi Cor !");
				ex.printStackTrace();
			}
			listaMultiCor.remove(listaMultiCor.get(linhaMulti));
			for (CorAmostraMulti listaMulti:listaMultiCor ) {
				if (listaMulti.getAmostra() != null) {
					corAmostraMultiBase.setAmostra(listaMulti.getAmostra());
					corAmostraMultiBase.setCorAmostra(listaMulti.getCorAmostra());
					corAmostraMultiBase.setSeqCor(listaMulti.getSeqCor());
					corAmostraMultiBase.setSeqCorAmostra(listaMulti.getSeqCorAmostra());
					corAmostraMultiBase.setCorAmostra(listaMulti.getCorAmostra());
					corAmostraMultiBase.setCorPrincipal(false);
					corAmostraMultiBase.setCompletaCor("");
					break;
				}
			}
			//
			//Ajusta Vetor Primario ,excluindo a linha removida...
			if (listaMultiCor.size() > 1) {
				ajustaVetorPrimario(listaMultiCor);
			}
			//Refaz composicao
			RefazComporMulti();
			//busca nova posicao de material
			PrimeiraPosicaoMaterial(listaMultiCor);
			//ajusta botoes conforme nova situacao
//			AjustaHabilitacoes(ultimoMaterial, listaMultiCor);
		}
	}
	public void AjustaCor(List<CorAmostraMulti> listaMulti, Integer quantosElementos) {
		// Consistencia Montagem Cor
		Integer matContador = 1;
		sortedByIndexPosicao(listaMulti);
		Long posicao = listaMulti.get(0).getCor().getCorid();

		for (int i = 0; i < listaMulti.size(); i++) {
			if (listaMulti.get(i).getCor() != null) {
				listaMulti.get(i).setSeqCor(0);
				posicao = listaMulti.get(i).getCor().getCorid();
			}
		}
		for (int i = 0; i < listaMulti.size(); i++) {
			// alterado 05/11 para ler total lista
			// for (int i = 0; i < quantosElementos; i++) {

			if (listaMulti.get(i).getCor() != null) {

				if (listaMulti.get(i).getCor().getCorid() != posicao) {
					posicao = listaMulti.get(i).getCor().getCorid();
					matContador++;
				}

				// alterado como acima
				for (int j = 0; j < listaMulti.size(); j++) {

					if ((listaMulti.get(j).getCor() != null)) {
						if (listaMulti.get(j).getSeqCor() == 0) {
							if (listaMulti.get(j).getCor().getCorid() == posicao) {
								listaMulti.get(j).setSeqCor(matContador);
							}
						}
					}

				}

			}
		}
	}

	// Ordena por Sequencia pre-definida
	public static void sortedByIndexPosicao(List<CorAmostraMulti> listaMultiPosicao) {
		Collections.sort(listaMultiPosicao, compareByPosicao);
	}

	public static Comparator<CorAmostraMulti> compareByPosicao = new Comparator<CorAmostraMulti>() {

		@Override
		public int compare(CorAmostraMulti po1, CorAmostraMulti po2) {
			return po1.getSequenciaPosicao().compareTo(po2.getSequenciaPosicao());
		}
	};

	// Ordena por Sequencia Material
	public static void sortedByIndexMatMulti(List<CorAmostraMulti> listaCoresMulti) {
		Collections.sort(listaCoresMulti, CompareByIndexMat);
	}

	public static Comparator<CorAmostraMulti> CompareByIndexMat = new Comparator<CorAmostraMulti>() {
		@Override
		public int compare(CorAmostraMulti iB1, CorAmostraMulti iB2) {
			return iB1.getSeqMaterial().compareTo(iB2.getSeqMaterial());
		}
	};

	// Ordena por Sequencia Cor
	public static void sortedByIndexCorMulti(List<CorAmostraMulti> listaCoresMulti) {
		Collections.sort(listaCoresMulti, CompareByIndexCor);
	}

	public static Comparator<CorAmostraMulti> CompareByIndexCor = new Comparator<CorAmostraMulti>() {
		@Override
		public int compare(CorAmostraMulti iB1, CorAmostraMulti iB2) {
			return iB1.getSeqCor().compareTo(iB2.getSeqCor());
		}
	};

	public void RefazSequencias(List<CorAmostraMulti> listaRefazMulti) {
		for (int i = 0; i < listaRefazMulti.size(); i++) {
			listaRefazMulti.get(i).setSeqCor(0);
			listaRefazMulti.get(i).setSeqMaterial(0);
		}
	}

	public Integer PrimeiraPosicaoMaterial(List<CorAmostraMulti> listaMaterial) {
		PrimeiroMaterial = 0;
		for (int k = 0; k < listaMaterial.size(); k++) {
			if (listaMaterial.get(k).getMaterial() != null) {
				if ((listaMaterial.get(k).getSeqMaterial() != 0) && (PrimeiroMaterial == 0)) {
					PrimeiroMaterial = listaMaterial.get(k).getSeqMaterial();
				}
				ultimoMaterial = listaMaterial.get(k).getSequenciaPosicao();
			}
		}
		return PrimeiroMaterial;
	}

	public Integer PrimeiraPosicaoCor(List<CorAmostraMulti> listaCor) {
		PrimeiraCor = 0;
		for (int k = 0; k < listaCor.size(); k++) {
			if (listaCor.get(k).getCor() != null) {
				if (listaCor.get(k).getSeqCor() != 0) {
					PrimeiraCor = listaCor.get(k).getSeqCor();
					complementar = listaCor.get(k).getCompletaCor().trim();
					break;
				}
			}
		}
		return PrimeiraCor;
	}

	public void inicializaVetorMulti() {
		for (int i = 0; i < 6; i++) {
			corAmostraMulti = new CorAmostraMulti();
			corAmostraMulti.setCorPrincipal(false);
			corAmostraMulti.setSequenciaPosicao(i + 1);
			corAmostraMulti.setSeqMaterial(0);
			corAmostraMulti.setSeqCor(0);
			corAmostraMulti.setCompletaCor("");
			listaMultiTemp.add(corAmostraMulti);
		}

	}

	public void AjustaHabilitacoes(Integer ultimaPosicao, List<CorAmostraMulti> listaMulti) {
		amostraController.inicializaParametros();
		amostraController.getParametros().setBotao1(false);
		amostraController.getParametros().setBotao2(false);
		amostraController.getParametros().setBotao3(false);
		amostraController.getParametros().setBotao4(false);
		amostraController.getParametros().setBotao5(false);
		amostraController.getParametros().setBotao6(false);
		amostraController.getParametros().setBtnlimpa1(false);
		amostraController.getParametros().setBtnlimpa2(false);
		amostraController.getParametros().setBtnlimpa3(false);
		amostraController.getParametros().setBtnlimpa4(false);
		amostraController.getParametros().setBtnlimpa5(false);
		amostraController.getParametros().setBtnlimpa6(false);
		amostraController.getParametros().setBtncheck(true);
		amostraController.setBtnVisao(false);
		if (listaMulti.size() != 0) {
			for (int i = 0; i < listaMulti.size(); i++) {
				if ((listaMulti.get(i).getMaterial() != null) && (i == 0)) {
					amostraController.getParametros().setBotao1(false);
					amostraController.getParametros().setHabilita1(true);
					amostraController.getParametros().setBtnlimpa1(true);
					if (i == (ultimoMaterial - 1)) {
						amostraController.getParametros().setBotao1(true);
					}
				}
				if ((listaMulti.get(i).getMaterial() != null) && (i == 1)) {
					amostraController.getParametros().setBotao2(false);
					amostraController.getParametros().setHabilita2(true);
					amostraController.getParametros().setBtnlimpa2(true);
					if (i == (ultimoMaterial - 1)) {
						amostraController.getParametros().setBotao2(true);

					}
				}
				if ((listaMulti.get(i).getMaterial() != null) && (i == 2)) {
					amostraController.getParametros().setBotao3(false);
					amostraController.getParametros().setHabilita3(true);
					amostraController.getParametros().setBtnlimpa3(true);
					if (i == (ultimoMaterial - 1)) {
						amostraController.getParametros().setBotao3(true);

					}
				}
				if ((listaMulti.get(i).getMaterial() != null) && (i == 3)) {
					amostraController.getParametros().setBotao4(false);
					amostraController.getParametros().setHabilita4(true);
					amostraController.getParametros().setBtnlimpa4(true);
					if (i == (ultimoMaterial - 1)) {
						amostraController.getParametros().setBotao4(true);

					}
				}
				if ((listaMulti.get(i).getMaterial() != null) && (i == 4)) {
					amostraController.getParametros().setBotao5(false);
					amostraController.getParametros().setHabilita5(true);
					amostraController.getParametros().setBtnlimpa5(true);
					if (i == (ultimoMaterial - 1)) {
						amostraController.getParametros().setBotao5(true);
					}
				}

				if ((listaMulti.get(i).getMaterial() != null) && (i == 5)) {
					amostraController.getParametros().setBotao5(false);
					amostraController.getParametros().setHabilita6(true);
					amostraController.getParametros().setBtnlimpa6(true);
				} else {
					if ((i == 5) && (listaMulti.get(i).getMaterial() != null)) {
						amostraController.getParametros().setHabilita6(true);
					}
				}

			}
		}
		// fim
	}

	public void getInicializaVetorEntrada(List<CorAmostraMulti> listaCorMulti, Integer operacao, CorAmostra editaCorAmostra) {
		if (operacao == 0) {
			listaMultiCor = new ArrayList<>();
			for (CorAmostraMulti listaCoresMulti : listaCorMulti) {
				listaMultiCor.add(listaCoresMulti);
			}

			Integer lin1 = amostraController.getLinha2();
			Integer lin2 = amostraController.getLinha3();
		} else {
			// Adicionado em 30/12 ,ref em 11/02
			Integer listaMulti = 0;
			listaMulti =  listaCorMulti.size();
//			if (listaMulti < 6) {	
			listaMultiCor = new ArrayList<>();
			for (CorAmostraMulti listaCoresMulti : listaCorMulti) {
				listaMultiCor.add(listaCoresMulti);
			}

			
			if (listaMulti < 6) {
				listaMulti = listaMultiCor.size()+1;
				for (int i = listaMultiCor.size(); i < 6; i++) {
					corAmostraMulti = new CorAmostraMulti();
					corAmostraMulti.setCorPrincipal(false);
					corAmostraMulti.setSequenciaPosicao(i + 1);
					corAmostraMulti.setSeqMaterial(0);
					corAmostraMulti.setSeqCor(0);
					corAmostraMulti.setCompletaCor("");
					corAmostraMulti.setAmostra(editaCorAmostra.getAmostra());
					corAmostraMulti.setCorAmostra(editaCorAmostra);
					corAmostraMulti.setSeqCorAmostra(editaCorAmostra.getSequenciaCorAmostra());
					listaMultiCor.add(corAmostraMulti);
				}
			}
		}
	}
	//Metodo para ajustar,quando dados de uma linha sao removidos,este refaz a ordem...
	public void ajustaVetorPrimario(List<CorAmostraMulti> listaMulti) {
		Integer mSize = listaMulti.size();
		for (int j = 0; j < 6; j++) {
			if (j < mSize) {
				listaMulti.get(j).setSequenciaPosicao(j+1);
			}else {
				listaMulti.add(corAmostraMultiBase);
				listaMulti.get(j).setSequenciaPosicao(j+1);
			}
		}
		//---------------------------------------
		//Segunda parte adiciona vazios no final
	}
	public void inicializaCor(Integer operacao) {
		if ((operacao == 0) || (operacao == 1)) {
			informaReferencia = "";
			informaCliente = "";
			informaEstacao = "";
			informaFabrica = "";
			informaConstrucao = "";
			informaForma = "";
			informaModelo = "";
			informaProduto = "";
			listaMultiCor = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				corAmostraMulti = new CorAmostraMulti();
				corAmostraMulti.setCorPrincipal(false);
				corAmostraMulti.setSequenciaPosicao(i + 1);
				corAmostraMulti.setSeqMaterial(0);
				corAmostraMulti.setSeqCor(0);
				corAmostraMulti.setCompletaCor("");
				corAmostraMulti.setStatus("V");
				listaMultiCor.add(corAmostraMulti);
			}
		}
		
  }
// Save Amostras Novas Multi Cor
	public void saveMultiCorAmostraNova(CorAmostra corAmostra, Integer mOperacao) {
		try {
			for (CorAmostraMulti listaMulti:listaMultiCor ) {
				if (listaMulti.getMaterial() != null) {
					listaMulti.setMatNome(listaMulti.getMaterial().getNome());
					listaMulti.setCorNome(listaMulti.getCor().getNome());
					listaMulti.setSeqCorAmostra(corAmostra.getSequenciaCorAmostra());
					//
					if (mOperacao == 0) {
						listaMulti.setCorAmostra(corAmostra);
						listaMulti.setAmostra(corAmostra.getAmostra());
					}
				}
				
			}
			
			Stream<CorAmostraMulti> stream = listaMultiCor.stream().filter(lm -> lm.getMaterial() != null || lm.getCormultiid() != null);
			List<CorAmostraMulti> multiFinal = stream.collect(Collectors.toList());
			sortedByIndexPosicao(multiFinal);
			corAmostraNovaMultiDao.updateCorMulti(multiFinal);
		} catch (RuntimeException ex) {
			Messages.addGlobalFatal("Não foi possivel Incluir Cores Multi !");
			return;
		}
	}

}
