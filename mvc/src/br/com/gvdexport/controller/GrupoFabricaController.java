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
import br.com.gvdexport.model.GrupoFabrica;
import br.com.gvdexport.model.Prioridade;
import br.com.gvdexport.model.QuadroFabrica;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class GrupoFabricaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private GrupoFabrica grupoFabrica;
	@Getter @Setter
	private List<GrupoFabrica> listaGrupoFabrica;
	private Integer tipoOperacao;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Getter @Setter
	private List<SimNao> simnao = Arrays.asList(SimNao.values());
	@Getter @Setter
	private List<QuadroFabrica> quadrofabrica = Arrays.asList(QuadroFabrica.values());
	@Getter @Setter
	private List<Prioridade> prioridade = Arrays.asList(Prioridade.values());
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private CrudDao<GrupoFabrica, Long> grpFabricaDao;
	@Inject
	private UsuarioLogadoController logadoController;
	@PostConstruct
	public void init() {
		tipoOperacao = 0;
		listaGrupoFabrica = new ArrayList<>();
		refresh();
	}
	public void add() {
		this.grupoFabrica = new GrupoFabrica();
		tipoOperacao = 0;
	}
	public void edit(GrupoFabrica grupoFabrica) {
		this.grupoFabrica = grupoFabrica;
		tipoOperacao = 1;
	}
	public void save() {
		List<GrupoFabrica> aux = facadeAcesso.existeGrupoFabrica(grupoFabrica.getNome());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
				Messages.addGlobalError("Grupo Fabrica Existente,Verique!");
	    		return;
			}
		}
		try {
			grupoFabrica.setSucinto(grupoFabrica.getQuadrofabrica().getLabel());
			grupoFabrica.setDatastamp(facadeAcesso.gettimeStamp());
			grupoFabrica.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			grpFabricaDao.update(grupoFabrica);
			refresh();
	        Messages.addGlobalInfo("Grupo Fabrica Cadastrado com sucesso!");
		} catch (RuntimeException ex) {
	        Messages.addGlobalError("Não foi possivel Cadastrar Grupo Fabrica !");
		}
	}
	public void delete(GrupoFabrica grupofabrica) {
		try {
			 grpFabricaDao.delete(grupofabrica.getFabricagrpid());
			 Messages.addGlobalInfo("Grupo Fabrica cancelada com Sucesso!");
			 refresh();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel, Cancelar Grupo Fabricas !");
		}
	}
	private void refresh() {
	   listaGrupoFabrica = grpFabricaDao.findAll();
	}
}
