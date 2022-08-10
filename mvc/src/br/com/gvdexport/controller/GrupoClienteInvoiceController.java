package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.GrupoClienteInvoice;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class GrupoClienteInvoiceController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private GrupoClienteInvoice grupoclienteinvoice;
	@Getter @Setter
	private List<GrupoClienteInvoice> listaGrupoClienteInvoice;
	private Integer tipoOperacao;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Getter @Setter
	private List<SimNao> simnao = Arrays.asList(SimNao.values());
	@Inject
	private CrudDao<GrupoClienteInvoice, Long> grpClienteInvoiceDao;
	@Inject
	private FacadeAcesso facadeAcesso;

	@Inject
	private UsuarioLogadoController logadoController;
	@PostConstruct
	public void init() {
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		this.grupoclienteinvoice = new GrupoClienteInvoice() ;
		  listaGrupoClienteInvoice = grpClienteInvoiceDao.findAll();
		  grupoclienteinvoice.setPrecofabrica(SimNao.N);
		  grupoclienteinvoice.setSituacao(Situacao.A);
		  grupoclienteinvoice.setSequenciaid(0);
	}

	public void edit(GrupoClienteInvoice grupoclienteinvoice) {
		this.grupoclienteinvoice = grupoclienteinvoice;
		tipoOperacao = 1;
	}
	
	public void save() {
		List<GrupoClienteInvoice> aux = facadeAcesso.existeGrupoClienteInvoice(grupoclienteinvoice.getNome());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
				Messages.addGlobalError("Grupo Cliente Invoice Existente,Verique!");
	    		return;
			}
		}
		try {
			grupoclienteinvoice.setDatastamp(facadeAcesso.gettimeStamp());
			grupoclienteinvoice.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			grpClienteInvoiceDao.update(grupoclienteinvoice);
			refresh();
	        Messages.addGlobalInfo("Grupo Cliente Invoice Cadastrado com sucesso!");
		} catch (RuntimeException ex) {
	        Messages.addGlobalError("Não foi possivel Cadastrar Grupo Cliente Invoice !");
		}
	}
	public void delete(GrupoClienteInvoice grupoclienteinvoice) {
		try {
			 grpClienteInvoiceDao.delete(grupoclienteinvoice.getGrupoclienteinvoiceid());
			 Messages.addGlobalInfo("Grupo Cliente Invoice cancelado com Sucesso!");
			 refresh();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Cancelar Grupo de Clientes Invoices !");
		}
	}

	private void refresh() {
		  listaGrupoClienteInvoice = grpClienteInvoiceDao.findAll();
	}


}
