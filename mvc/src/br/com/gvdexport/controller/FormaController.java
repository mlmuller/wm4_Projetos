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
import br.com.gvdexport.model.Fabrica;
import br.com.gvdexport.model.Forma;
import br.com.gvdexport.model.LarguraForma;
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.TipoBico;
import br.com.gvdexport.model.TipoCalcadoResumido;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class FormaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	private Forma forma;
	@Getter
	@Setter
	private List<Forma> listaFormas;
	@Getter
	@Setter
	private List<Fabrica> listaFabricas;
	@Getter
	@Setter
	private Forma cloneForma;
	@Getter
	@Setter
	private List<TipoCalcadoResumido> tpResumido = Arrays.asList(TipoCalcadoResumido.values());
	@Getter
	@Setter
	private List<Situacao> situacao = Arrays.asList(Situacao.values());
	@Getter
	@Setter
	private List<LarguraForma> larguraforma = Arrays.asList(LarguraForma.values());
	@Getter
	@Setter
	private List<TipoBico> tipobico = Arrays.asList(TipoBico.values());
	private Integer operacao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<Forma, Long> formaDao;
	@Inject
	private CrudDao<Fabrica, Long> fabricaDao;

	@PostConstruct
	public void init() {
		listaFabricas = new ArrayList<>();
		listaFormas = new ArrayList<>();
		refresh();
	}

	public void add() {
		forma = new Forma();
		forma.setSituacao(Situacao.A);
		operacao = 0;
	}

	public void edit(Forma formaedt) throws CloneNotSupportedException {
		forma = new Forma();
		cloneForma = new Forma();
		forma = formaedt;
		cloneForma = (Forma) formaedt.clone();
		operacao = 1;
	}

	public void save() {
		try {
			if (operacao == 1) {
				if (!forma.getReferenciaforma().equals(cloneForma.getReferenciaforma())) {
					List<Forma> aux = facadeAcesso.existeFormaReferencia(forma.getReferenciaforma());
					if (aux.size() != 0) {
						Messages.addGlobalError("Referencia para esta Forma já possui Cadastro !");
						return;
					}
				}
				forma.setDatastamp(fabricaDao.gettimeStamp());
				forma.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
				formaDao.update(forma);
			} else {
				List<Forma> aux = facadeAcesso.existeFormaReferencia(forma.getReferenciaforma());
				if (aux.size() != 0) {
					Messages.addGlobalError("Referencia forma já possui Cadastro !");
					return;
				}
				forma.setDatastamp(fabricaDao.gettimeStamp());
				forma.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
				formaDao.update(forma);
			}
			Messages.addGlobalInfo("Operação realizada com Sucesso !");
			refresh();

		} catch (Exception ex) {
				Messages.addGlobalError("Não foi possivel Executar operacao com a Forma");
		}
	}

	public void delete(Forma forma) {
		try {
			formaDao.delete(forma.getFormaid());
			Messages.addGlobalInfo("Forma Removida com Sucesso!");
			refresh();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel remover Forma!");
		}
	}

	public void refresh() {
		listaFormas = formaDao.findAll();
		if (listaFabricas.size() == 0) {
			listaFabricas = fabricaDao.findAll();
		}
	}

}
