package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.ClienteProjecao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class GrupoClienteProjecaoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private ClienteProjecao grupoclienteprojecao;
	@Getter @Setter
	private List<ClienteProjecao> listaGrupoclienteProjecao;
	private Integer tipoOperacao;
	@Inject
	private CrudDao<ClienteProjecao, Long> grpClienteProjecaoDao;
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
		this.grupoclienteprojecao = new ClienteProjecao() ;
		  listaGrupoclienteProjecao = grpClienteProjecaoDao.findAll();
		  grupoclienteprojecao.setPrioridade(999);
	}

	public void edit(ClienteProjecao grupoclienteprojecao) {
		this.grupoclienteprojecao = grupoclienteprojecao;
		tipoOperacao = 1;
	}
	
	public void save() {
		List<ClienteProjecao> aux = facadeAcesso.existeGrupoClienteProjecao(grupoclienteprojecao.getNome());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
				Messages.addGlobalError("Grupo Cliente Existente,Verique!");
	    		return;
			}
		}
		try {
			grupoclienteprojecao.setDatastamp(facadeAcesso.gettimeStamp());
			grupoclienteprojecao.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			grpClienteProjecaoDao.update(grupoclienteprojecao);
			refresh();
	        Messages.addGlobalInfo("Grupo Cliente Projecao Cadastrado com sucesso!");
		} catch (RuntimeException ex) {
	        Messages.addGlobalError("Não foi possiven Cadastrar Grupo Cliente Projecao !");
		}
	}
	public void delete(ClienteProjecao grupoclienteprojecao) {
		try {
			 grpClienteProjecaoDao.delete(grupoclienteprojecao.getClienteprojecaoid());
			 Messages.addGlobalInfo("Grupo Cliente Projecao cancelado com Sucesso!");
			 refresh();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Cancelar Grupo Clientes Projeção !");
		}
	}

	private void refresh() {
		  listaGrupoclienteProjecao = grpClienteProjecaoDao.findAll();
	}


}
