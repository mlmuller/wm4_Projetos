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
import br.com.gvdexport.model.GrupoCliente;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class GrupoClienteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private GrupoCliente grupocliente;
	@Getter @Setter
	private List<GrupoCliente> listaGrupocliente;
	private Integer tipoOperacao;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Getter @Setter
	private List<SimNao> simnao = Arrays.asList(SimNao.values());
	@Inject
	private CrudDao<GrupoCliente, Long> grpClienteDao;
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
		this.grupocliente = new GrupoCliente() ;
		  listaGrupocliente = grpClienteDao.findAll();
		  grupocliente.setMostraprecofabrica(SimNao.S);
		  grupocliente.setImprversaozero(SimNao.N);
		  grupocliente.setSituacao(Situacao.A);
	}

	public void edit(GrupoCliente grupocliente) {
		this.grupocliente = grupocliente;
		tipoOperacao = 1;
	}
	
	public void save() {
		List<GrupoCliente> aux = facadeAcesso.existeGrupoCliente(grupocliente.getNome());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
				Messages.addGlobalError("Grupo Cliente Existente,Verique!");
	    		return;
			}
		}
		try {
			grupocliente.setDatastamp(facadeAcesso.gettimeStamp());
			grupocliente.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			grpClienteDao.update(grupocliente);
			refresh();
	        Messages.addGlobalInfo("Grupo Cadastrado com sucesso!");
		} catch (RuntimeException ex) {
    	  Messages.addGlobalError("Não foi possivel Cadastrar Grupo Cliente !");
		}
	}
	public void delete(GrupoCliente grupocliente) {
		try {
			 grpClienteDao.delete(grupocliente.getClientegrpid());
			 Messages.addGlobalInfo("Grupo Cliente cancelado com Sucesso!");
			 refresh();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Cancelar Grupo de Clientes !");
		}
	}

	private void refresh() {
		  listaGrupocliente = grpClienteDao.findAll();
	}


}
