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
import br.com.gvdexport.model.EnderecoCliente;
import br.com.gvdexport.model.GrupoClienteInvoice;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class EnderecoClienteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private EnderecoCliente enderecocliente;
	@Getter @Setter
	private EnderecoCliente enderecoclienteclone;
	@Getter @Setter
	private GrupoClienteInvoice grpClienteInvoice;
	@Getter @Setter
	private List<GrupoClienteInvoice> listaGrpClienteInvoice;
	@Getter @Setter
	private Integer tipoOperacao;
	@Getter @Setter
	private List<EnderecoCliente> listaEnderecoCliente;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Inject
	private CrudDao<EnderecoCliente, Long> enderecoClienteDao;
	@Inject
	private DGAFacadeCompKey facadeAcesso;
	@Inject
	private CrudDao<GrupoClienteInvoice, Long> grpClienteInvoiceDao;
	@Inject
	private UsuarioLogadoController logadoController;
	@PostConstruct
	public void init() {
		listaGrpClienteInvoice = new ArrayList<>();
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		enderecocliente = new EnderecoCliente();
		grpClienteInvoice = new GrupoClienteInvoice();
		listaEnderecoCliente = enderecoClienteDao.findAll();
	}

	public void edit(EnderecoCliente enderecocliente) throws CloneNotSupportedException {
		enderecoclienteclone = new EnderecoCliente();
		this.enderecocliente = enderecocliente;
		enderecoclienteclone = (EnderecoCliente) enderecocliente.clone();
		tipoOperacao = 1;
	}
	
	public void save() {
		try
		{
			enderecocliente.setDatastamp(facadeAcesso.gettimeStamp());
			enderecocliente.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			if (tipoOperacao != 0) {
				if(!enderecocliente.getGrupoclienteinvoice().equals(enderecoclienteclone.getGrupoclienteinvoice())) {
					grpClienteInvoice = grpClienteInvoiceDao.find(enderecocliente.getGrupoclienteinvoice().getGrupoclienteinvoiceid());
					grpClienteInvoice.setSequenciaid(grpClienteInvoice.getSequenciaid()+1);
					grpClienteInvoiceDao.update(grpClienteInvoice);
					enderecocliente.setSequenciaendereco(grpClienteInvoice.getSequenciaid());
				}
				
				enderecoClienteDao.update(enderecocliente);
			}else {
				grpClienteInvoice = grpClienteInvoiceDao.find(enderecocliente.getGrupoclienteinvoice().getGrupoclienteinvoiceid());
				grpClienteInvoice.setSequenciaid(grpClienteInvoice.getSequenciaid()+1);
				grpClienteInvoiceDao.update(grpClienteInvoice);
				enderecocliente.setSequenciaendereco(grpClienteInvoice.getSequenciaid());
				enderecoClienteDao.insert(enderecocliente);
			}
			refresh();
	        Messages.addGlobalInfo("Endereço Cliente Cadastrado com sucesso!");
		} catch (RuntimeException ex) {
	        Messages.addGlobalError("Não foi possivel Cadastrar Endereço Cliente !");
	        ex.printStackTrace();
		}
	}
	public void delete(EnderecoCliente enderecocliente) {
		
		try {
			
		  enderecoClienteDao.delete(enderecocliente.getEnderecoclienteid());
			 Messages.addGlobalInfo("Endereço Cliente cancelado com Sucesso!");
			 refresh();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Cancelar Endereço Cliente !");
		}
	}

	private void refresh() {
	   listaEnderecoCliente = enderecoClienteDao.findAll();
	   if(listaGrpClienteInvoice.size() == 0 ) {
		  listaGrpClienteInvoice = grpClienteInvoiceDao.findAll();
	   }
	}


}
