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

import br.com.gvdexport.dao.ConversaoDao;
import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.dao.HtsDao;
import br.com.gvdexport.dao.NbmDao;
import br.com.gvdexport.dao.TipoCalcadoDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Componente;
import br.com.gvdexport.model.Conversao;
import br.com.gvdexport.model.Hts;
import br.com.gvdexport.model.IdentificaCalcado;
import br.com.gvdexport.model.Nbm;
import br.com.gvdexport.model.OrigemProduto;
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.TipoCalcado;
import br.com.gvdexport.model.TipoMaterial;
import br.com.gvdexport.model.TipoSolado;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ComponenteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private Componente componente;
	@Getter @Setter
	private Componente componenteClone;
	@Getter @Setter
	private Conversao conversao;
	@Getter @Setter
	private Conversao selecionadaConversao;
	@Getter @Setter
	private Boolean opcao;
	@Getter @Setter
	private List<Componente> listaComponentes;
	@Getter @Setter
	private List<Conversao> listaConversoes;
	@Getter @Setter
	private List<TipoCalcado> listaTipoCalcados;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Getter @Setter
	private List<IdentificaCalcado> tipoProduto=Arrays.asList(IdentificaCalcado.values());
	private Integer operacao;
	@Getter @Setter
	private List<TipoMaterial> tipoCabedal=Arrays.asList(TipoMaterial.values());
	@Getter @Setter
	private List<TipoSolado> tipoSolado=Arrays.asList(TipoSolado.values());
	@Getter @Setter
	private List<OrigemProduto> origemProduto=Arrays.asList(OrigemProduto.values());
	@Getter @Setter
	private List<Nbm> listaNBM;
	@Getter @Setter
	private List<Hts> listaHTS;
	@Getter @Setter
	private String grupo;
	@Inject
	private CrudDao<Componente, Long> componenteDao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private NbmDao nbmDao;
	@Inject
	private HtsDao htsDao;
	@Inject
	private TipoCalcadoDao tipoCalcadoDao;
	@Inject
	private ConversaoDao conversaoDao;
	@PostConstruct
	public void init() {
		listaHTS = new ArrayList<>();
		listaNBM = new ArrayList<>();
		listaTipoCalcados = new ArrayList<>();
		listaConversoes = new ArrayList<>();
		selecionadaConversao = new Conversao();
		componente = new Componente();
		opcao = false;
	}
	public void inicializaGrupo(String grupo) {
		listaComponentes= new ArrayList<>();
		this.grupo = grupo;
		refresh(grupo);
	}
	public void add() {
		componente = new Componente();
		componente.setSituacao(Situacao.A);
		componente.setOrigemproduto(OrigemProduto.A);
		listaConversoes = conversaoDao.findAll();
		operacao = 0;
	}
	public void carregaConversao() {
		componente.setNomeconversao(selecionadaConversao.getNome()+"-"+"Marcar");
		if (selecionadaConversao != null && operacao == 1) {
			if(selecionadaConversao.getConversaoid() != componenteClone.getConversao().getConversaoid()) {
				componente.setNomesucinto(conversao.getNomesucinto()+"-"+"Marcar");
			}
		}
	}
	public void edit(Componente componente) throws CloneNotSupportedException {
		this.componente = componente;
		this.componenteClone = (Componente) componente.clone();
		selecionadaConversao = componente.getConversao();
		operacao = 1;
	}
	public void saveProduto() {
			try {
				componente.setGrupocomponente(grupo);
				List<Componente> aux = new ArrayList<>();
				if(grupo.equals("L")) {
					componente.setNomeabreviado(selecionadaConversao.getNomeabreviado());
					componente.setConversao(selecionadaConversao);
					aux = facadeAcesso.existeNumeracaoProduz(componente.getNomesucinto(),componente.getNomeconversao());
				}else {
					aux = facadeAcesso.existeComponente(componente.getGrupocomponente(),componente.getDef1().trim());
				}
				if(operacao == 1) {
					if(!grupo.equals("L")) {
						if(!componente.getDef1().trim().equals(componenteClone.getDef1().trim())) {
							if (aux.size() != 0 ) {
								Messages.addGlobalError("J� existe Produto com esta defini��o !");
								return;
							}else {
								componente.setDatastamp(facadeAcesso.gettimeStamp());
								componente.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
								componenteDao.update(componente);
							}
						}else {
							if ((componenteClone.getNomesucinto() != null) && (componenteClone.getNomeabreviado() != null)) {
								if ((!componente.getNomesucinto().trim().equals(componenteClone.getNomesucinto())) || 
										(!componente.getNomeabreviado().trim().equals(componenteClone.getNomeabreviado()))) {
									aux = facadeAcesso.existeComponente(componente.getNomesucinto(), componente.getNomeabreviado());
									if (aux.size() != 0){
										Messages.addGlobalError("J� existe esta Definicao para um Produto,Verifique!");
										return;
									}
									componente.setDatastamp(facadeAcesso.gettimeStamp());
									componente.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
									componenteDao.update(componente);
								}
							}
						}
					}else {
						componente.setDatastamp(facadeAcesso.gettimeStamp());
						componente.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
						componenteDao.update(componente);
						
					}
				}else {
					if (aux.size() != 0 ) {
				        Messages.addGlobalWarn("Componente j� est� Cadastrado !");
						return;
					}
					componente.setDatastamp(facadeAcesso.gettimeStamp());
					componente.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					componenteDao.update(componente);
				}
				refresh(grupo);
				Messages.addGlobalInfo("Opera��o executada com sucesso !");
			} catch (RuntimeException ex) {
				Messages.addGlobalError("N�o foi possivel incluir Componente !");
				ex.printStackTrace();
			}
	}
	
	public void delete(Componente componente) {
		try {
			componenteDao.delete(componente.getComponenteid());
			refresh(grupo);
			Messages.addGlobalInfo("Tipo Produto Removido com Sucesso!");
			return;
		} catch (RuntimeException ex) {
			Messages.addGlobalError("N�o foi possivel remover Componente !");
			ex.printStackTrace();
		}
	}

	public void refresh(String grupo) {
		listaComponentes = facadeAcesso.buscaComponente(grupo);
		if(listaNBM.size() == 0)  {
			listaNBM = nbmDao.findAll();
		}
		if(listaHTS.size() == 0) {
			listaHTS = htsDao.findAll();
		}
		listaTipoCalcados = tipoCalcadoDao.findAll();
		if(listaConversoes.size() == 0) {
			listaConversoes = conversaoDao.findAll();
			
		}
	}

}
