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
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Banco;
import br.com.gvdexport.model.Cidade;
import br.com.gvdexport.model.Cliente;
import br.com.gvdexport.model.ClienteProjecao;
import br.com.gvdexport.model.Despachante;
import br.com.gvdexport.model.GrupoCliente;
import br.com.gvdexport.model.GrupoClienteInvoice;
import br.com.gvdexport.model.Importador;
import br.com.gvdexport.model.ImprimiContratoFabrica;
import br.com.gvdexport.model.LayoutInvoiceTrading;
import br.com.gvdexport.model.Mercado;
import br.com.gvdexport.model.PrazoPagamento;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.TipoNegociacao;
import br.com.gvdexport.model.TipoPessoa;
import br.com.gvdexport.model.Transportador;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ClienteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private Cliente cliente;
	@Getter @Setter
	private List<Cliente> listaClientes;
	@Getter @Setter
	private List<GrupoCliente> listagrpClientes;
	@Getter @Setter
	private List<Importador> listaImportadores;
	@Getter @Setter
	private List<Cidade> listaCidades;
	@Getter @Setter
	private List<Transportador> listaTransportador;
	@Getter @Setter
	private List<Despachante> listaDespachante;
	@Getter @Setter
	private List<GrupoClienteInvoice> listaGrpCliInvoice;
	@Getter @Setter
	private List<ClienteProjecao> listaGrpCliProjecao;
	@Getter @Setter
	private List<PrazoPagamento> listaPrzPagamento;
	@Getter @Setter
	private List<Banco> listaBancos;
	@Getter @Setter
	private Cidade cidade;
	@Getter @Setter
	private Cliente cloneCliente;
	@Getter @Setter
	private List<Mercado> mercados = Arrays.asList(Mercado.values());
	@Getter @Setter
	private List<TipoNegociacao> tiponegociacao = Arrays.asList(TipoNegociacao.values());
	@Getter @Setter
	private List<ImprimiContratoFabrica> imprimicontratofabrica = Arrays.asList(ImprimiContratoFabrica.values());
	@Getter @Setter
	private List<SimNao> simnao = Arrays.asList(SimNao.values());
	@Getter @Setter
	private List<TipoPessoa> tipopessoa = Arrays.asList(TipoPessoa.values());
	@Getter @Setter
	private List<LayoutInvoiceTrading> layoutinvtrading = Arrays.asList(LayoutInvoiceTrading.values());
	@Getter @Setter
	private List<Situacao> situacao = Arrays.asList(Situacao.values());
	private Integer operacao;

	@Inject
	private CrudDao<Cliente, Long> clienteDao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<GrupoCliente, Long> grpClienteDao;
	@Inject
	private CrudDao<Cidade, Long> cidadeDao;
	@Inject
	private CrudDao<Importador, Long> importadorDao;
	@Inject
	private CrudDao<Transportador, Long> transportadorDao;
	@Inject
	private CrudDao<Despachante, Long> despachanteDao;
	@Inject
	private CrudDao<GrupoClienteInvoice, Long> grpCliInvoiceDao;
	@Inject
	private CrudDao<ClienteProjecao, Long> grpCliProjecaoDao;
	@Inject
	private CrudDao<Banco, Long> bancoDao;
	@Inject
	private CrudDao<PrazoPagamento, Long> przPgtoDao;
	@PostConstruct
	public void init() {
		inicializaVetores();
		refresh();
	}
	
	public void add() {
		cliente = new Cliente();
		cliente.setSituacao(Situacao.A);
		cliente.setImprimicontratofabrica(ImprimiContratoFabrica.C);
		cliente.setImprimepalmilhaEtiqueta(SimNao.N);
		cliente.setLiberadoreprogramacaoorder(SimNao.S);
		cliente.setPrioridade("999");
		operacao = 0;
		inicializaVetores();
		refresh();
	}
	
	public void edit(Cliente cliente) throws CloneNotSupportedException {
		cloneCliente = new Cliente();
	    cloneCliente = (Cliente) cliente.clone();
	    this.cliente = cliente;
		operacao = 1;
	}
	public void save() {
			try {
				if(operacao == 1) {
					if(!cliente.getNome().equals(cloneCliente.getNome())) {
						List<Cliente> aux = facadeAcesso.existeCliNome(cliente.getNome());
						if (aux.size() != 0 ) {
							Messages.addGlobalError("Este Cliente já possui Cadastro !");
							return;
						}
					}
					if(!cliente.getSucinto().equals(cloneCliente.getSucinto())) {
						List<Cliente> aux = facadeAcesso.existeCliSucinto(cliente.getSucinto());
						if (aux.size() != 0 ) {
							Messages.addGlobalError("Este Sucinto para este Cliente já¡ possui Cadastro !");
							return;
						}
						
					}
					cliente.setDatastamp(clienteDao.gettimeStamp());
					cliente.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					if(cliente.getCidades().getCidadeid() != null) {
						cliente.setCidade(cliente.getCidades().getNome());
						cliente.setUf(cliente.getCidades().getEstado().getSigla());
						cliente.setPaises(cliente.getCidades().getEstado().getPais());
						cliente.setPais(cliente.getCidades().getEstado().getPais().getNome());
					}
					clienteDao.update(cliente);
				}else {
					List<Cliente> auxc = facadeAcesso.existeCliNome(cliente.getNome());
					if (auxc.size() != 0 ) {
				        Messages.addGlobalError("Este Cliente  já possui Cadastro!");
						return;
					}
					List<Cliente> auxs = facadeAcesso.existeCliSucinto(cliente.getSucinto());
					if (auxs.size() != 0 ) {
				        Messages.addGlobalError("Este Sucinto já possui Cadastro!");
						return;
					}
					if(cliente.getCidades() != null) {
						cliente.setCidade(cliente.getCidades().getNome());
						cliente.setUf(cliente.getCidades().getEstado().getSigla());
						cliente.setPaises(cliente.getCidades().getEstado().getPais());
						cliente.setPais(cliente.getCidades().getEstado().getPais().getNome());
					}
					cliente.setDatastamp(clienteDao.gettimeStamp());
					cliente.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					clienteDao.update(cliente);
				}
				refresh();
				Messages.addGlobalInfo("Operação executada com Sucesso!");
			} catch (RuntimeException ex) {
		        Messages.addGlobalError("Não foi possivel incluir Cliente!");
				ex.printStackTrace();
		       
			}
	}
	
	public void delete(Cliente cliente) {
		try {
			clienteDao.delete(cliente.getClienteid());
			refresh();
			Messages.addGlobalInfo("Cliente Removido com Sucesso!");
		} catch (RuntimeException ex) {
   		    Messages.addGlobalError("Não foi possivel remover Cliente!");
		}
	}

	public void refresh() {
		listaClientes = clienteDao.findAll();
		if (listaCidades.size() == 0) {
			listaCidades = cidadeDao.findAll();
		}
		if (listagrpClientes.size() == 0) {
			listagrpClientes = grpClienteDao.findAll();
		}
		if(listaImportadores.size() == 0) {
			listaImportadores = importadorDao.findAll(); 
			
		}
		if (listaTransportador.size() == 0) {
			listaTransportador = transportadorDao.findAll();
			
		}
		if(listaDespachante.size() == 0) {
			listaDespachante = despachanteDao.findAll();
			
		}
		if(listaGrpCliInvoice.size() == 0) {
			listaGrpCliInvoice = grpCliInvoiceDao.findAll();
			
		}
		if(listaGrpCliProjecao.size() == 0) {
			listaGrpCliProjecao = grpCliProjecaoDao.findAll();
			
		}
		if(listaBancos.size() == 0) {
			listaBancos = bancoDao.findAll();
			
		}
		if(listaPrzPagamento.size() == 0) {
			listaPrzPagamento = przPgtoDao.findAll();
			
		}
	}
	public void inicializaVetores() {
		listaClientes= new ArrayList<>();
		listaCidades= new ArrayList<>();
		listagrpClientes = new ArrayList<>();
		listaImportadores = new ArrayList<>();
		listaTransportador = new ArrayList<>();
		listaDespachante = new ArrayList<>();
		listaGrpCliInvoice = new ArrayList<>();
		listaGrpCliProjecao = new ArrayList<>();
		listaBancos = new ArrayList<>();
		listaPrzPagamento = new ArrayList<>();
	}

}
