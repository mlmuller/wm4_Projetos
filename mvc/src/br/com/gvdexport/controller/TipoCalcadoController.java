package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.IdentificaCalcado;
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.TipoCalcado;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class TipoCalcadoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private TipoCalcado tipoCalcado;
	@Getter @Setter
	private List<TipoCalcado> listaTiposProdutos;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	@Getter @Setter
	private List<IdentificaCalcado> tipoProduto=Arrays.asList(IdentificaCalcado.values());
	private Integer operacao;

	@Inject
	private CrudDao<TipoCalcado, Long> tipoCalcadoDao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@PostConstruct
	public void init() {
		listaTiposProdutos= new ArrayList<>();
		refresh();
	}
	
	public void add() {
		tipoCalcado = new TipoCalcado();
		operacao = 0;
	}
	
	public void edit(TipoCalcado tipocalcados) {
		this.tipoCalcado = tipocalcados;
		operacao = 1;
	}
	public void save() {
			try {
				if(operacao == 1) {
						List<TipoCalcado> aux = facadeAcesso.existeTipoCalcado(tipoCalcado.getNomeport());
						if (aux.size() != 0 ) {
							Messages.addGlobalWarn("Nome Produto Português ja possui Cadastro!");
							return;
					}
					tipoCalcado.setDatastamp(facadeAcesso.gettimeStamp());
					tipoCalcado.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					tipoCalcadoDao.update(tipoCalcado);
				}else {
					List<TipoCalcado> aux = facadeAcesso.existeTipoCalcado(tipoCalcado.getNomeport());
					if (aux.size() != 0 ) {
				        Messages.addGlobalWarn("Tipo Produto já está Cadastrado !");
						return;
					}
					tipoCalcado.setDatastamp(facadeAcesso.gettimeStamp());
					tipoCalcado.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					tipoCalcadoDao.update(tipoCalcado);
				}
				refresh();
				Messages.addGlobalInfo("Operação executada com sucesso !");
			} catch (RuntimeException ex) {
				Messages.addGlobalError("Não foi possivel incluit Tipo de Produto !");
			}
	}
	
	public void delete(TipoCalcado tipoCalcado) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			tipoCalcadoDao.delete(tipoCalcado.getTipocalcadoid());
			refresh();
			context.addMessage(null, new FacesMessage(""));
			Messages.addGlobalInfo("Tipo Produto Removido com Sucesso!");
			return;
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel remover PRoduto !");
			ex.printStackTrace();
		}
	}

	public void refresh() {
		listaTiposProdutos = tipoCalcadoDao.findAll();
	}

}
