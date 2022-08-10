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
import br.com.gvdexport.model.DestinoAmCf;
import br.com.gvdexport.model.GrupoClienteInvoice;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class DestinoAmCfController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private DestinoAmCf destinoamcf;
	@Getter @Setter
	private DestinoAmCf destinoClone;
	@Getter @Setter
	private List<GrupoClienteInvoice> listaGrupoClienteInvoice;
	@Getter @Setter
	private List<DestinoAmCf> listaDestinoAmCf;
	private Integer tipoOperacao;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Inject
	private CrudDao<DestinoAmCf, Long> destinoAmCfDao;
	@Inject
	private CrudDao<GrupoClienteInvoice, Long> grpClienteInvoiceDao;
	@Inject
	private FacadeAcesso facadeAcesso;

	@Inject
	private UsuarioLogadoController logadoController;
	@PostConstruct
	public void init() {
	    listaGrupoClienteInvoice = new ArrayList<GrupoClienteInvoice>();
	    listaDestinoAmCf = new ArrayList<DestinoAmCf>();
	    destinoamcf = new DestinoAmCf();
	    destinoClone = new DestinoAmCf();
		tipoOperacao = 0;
		refresh();
	}
	public void add() {
		this.destinoamcf = new DestinoAmCf();
		  destinoamcf.setSituacao(Situacao.A);
		  refresh();
	}

	public void edit(DestinoAmCf destinoamcf) throws CloneNotSupportedException {
		this.destinoamcf = destinoamcf;
		destinoClone = (DestinoAmCf) destinoamcf.clone();
		tipoOperacao = 1;
	}
	
	public void save() {
		if (!destinoamcf.getDestino().equals(destinoClone.getDestino())) {
			tipoOperacao = 0;
		}
		try {
			if (tipoOperacao == 0) {
				List<DestinoAmCf> aux = facadeAcesso.existeDestinoAmCf(destinoamcf.getGruposclientesinvoices().getGrupoclienteinvoiceid(),destinoamcf.getDestino());
				if (aux.size() != 0) {
					Messages.addGlobalError("Destino Existente,Verique!");
					return;
				}
				destinoamcf.setDatastamp(facadeAcesso.gettimeStamp());
				destinoamcf.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
				destinoAmCfDao.update(destinoamcf);
				refresh();
				Messages.addGlobalInfo("Destino/Grupo Cadastrado com sucesso!");
			}
		} catch (RuntimeException ex) {
	        Messages.addGlobalError("Não foi possivel Cadastrar Destino para o Grupo !");
		}
	}
	public void delete(DestinoAmCf destinoamcf) {
		try {
			 destinoAmCfDao.delete(destinoamcf.getDestinoamcfid());
			 Messages.addGlobalInfo("Destino cancelado com Sucesso!");
			 refresh();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Cancelar Destino do Grupo!-"+destinoamcf.getGruposclientesinvoices().getSucinto() );
		}
	}

	private void refresh() {
		if (listaGrupoClienteInvoice.size() == 0) {
		  listaGrupoClienteInvoice = grpClienteInvoiceDao.findAll();
		}
		listaDestinoAmCf = destinoAmCfDao.findAll();
	}


}
