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
import br.com.gvdexport.model.DGAGlobal;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class GlobalController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private DGAGlobal dgaGlobal;;
	private Integer operacao;
	@Getter @Setter
	private DGAGlobal dgaGlobalClone;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	protected UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<DGAGlobal, Long> globalDao;
	
	@Getter @Setter
	private List<DGAGlobal> listaGlobais;
	@PostConstruct
	public void init() {
		refresh();
	}
	
	public void add() {
		refresh();
		dgaGlobal = new DGAGlobal();
		operacao = 0;
	}

	public void edit(DGAGlobal dgaGlobal) {
		dgaGlobalClone = new DGAGlobal();
		this.dgaGlobal = dgaGlobal;
		this.dgaGlobalClone = dgaGlobal;
		operacao = 1;
	}
	public void save() {
			try {
				if(operacao == 1) {
					if(dgaGlobal.getParametro() !=  dgaGlobalClone.getParametro()) {
						List<DGAGlobal> aux = facadeAcesso.existeGlobalParametro(dgaGlobal.getParametro());
						if (aux.size() != 0 ) {
							Messages.addGlobalWarn("Parêmetro existente,verifique !");
							return;
						}
					}
					dgaGlobal.setDatastamp(globalDao.gettimeStamp());
					dgaGlobal.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					globalDao.update(dgaGlobal);
				}else {
					List<DGAGlobal> aux = facadeAcesso.existeGlobalParametro(dgaGlobal.getParametro());
					if (aux.size() != 0 ) {
						Messages.addGlobalWarn("Parêmetro existente,verifique !");
						return;
					}
					dgaGlobal.setDatastamp(globalDao.gettimeStamp());
					dgaGlobal.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					globalDao.update(dgaGlobal);
				}
				refresh();
				Messages.addGlobalInfo("Processo executado com sucesso !");
			} catch (RuntimeException ex) {
				Messages.addGlobalWarn("Não foi possivel,Incuir Parametro !");
				return;
			}
	}
	
	public void delete(DGAGlobal dgaglobal) {
		try {
			globalDao.delete(dgaglobal.getDgaglobalid());
			refresh();
			Messages.addGlobalInfo("Parâmetro excluido com sucesso !");
		} catch (RuntimeException ex) {
			Messages.addGlobalWarn("Não foi possivel excluir Parâmetro !");
			ex.printStackTrace();
		}
	}

	public void refresh() {
		listaGlobais = globalDao.findAll();
	}
	

}
