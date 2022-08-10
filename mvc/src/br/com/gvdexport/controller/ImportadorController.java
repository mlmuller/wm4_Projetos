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
import br.com.gvdexport.model.Cidade;
import br.com.gvdexport.model.Importador;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.TipoImportador;
import br.com.gvdexport.model.TipoPessoa;
import br.com.gvdexport.model.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ImportadorController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private List<Cidade> listaCidades;
	@Getter @Setter
	private List<Importador> listaImportador;
	@Getter @Setter
	private Importador cloneImportador;
	@Getter @Setter
	private Importador importador;
	private Integer operacao;
	@Getter @Setter
	private List<TipoPessoa> tipopessoa = Arrays.asList(TipoPessoa.values());
	@Getter @Setter
	private List<SimNao> simnao = Arrays.asList(SimNao.values());
	@Getter @Setter
	private List<Situacao> ativoinativo = Arrays.asList(Situacao.values());
	@Getter @Setter
	private List<TipoImportador> tipoimportador = Arrays.asList(TipoImportador.values());
	@Getter @Setter
	private List<TipoTelefone> tipotelefone = Arrays.asList(TipoTelefone.values());
	@Inject
	private CrudDao<Cidade, Long> cidadeDao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<Importador, Long> importadorDao;
	@PostConstruct
	public void init() {
		listaCidades= new ArrayList<>();
		refresh();
	}
	
	public void add() {
		importador = new Importador();
		importador.setSituacao(Situacao.A);
		operacao = 0;
	}
	
	public void edit(Importador importador) throws CloneNotSupportedException {
		cloneImportador = new Importador();
	    this.importador = importador;
		this.cloneImportador = (Importador) importador.clone();
		operacao = 1;
	}
	public void save() {
			try {
				if(operacao == 1) {
					if(importador.getNome() != cloneImportador.getNome()) {
						List<Importador> aux = facadeAcesso.existeImportador(importador.getNome());
						if (aux.size() != 0 ) {
							Messages.addGlobalError("Importador ja esta Cadastrado !");
							return;
						}
					}
					importador.setPais(importador.getCidade().getEstado().getPais());
					importador.setUf(importador.getCidade().getEstado().getSigla());
					importador.setDescricaocidade(importador.getCidade().getNome());
					importador.setLiberadoedi(SimNao.N);
					importador.setDatastamp(cidadeDao.gettimeStamp());
					importador.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					importadorDao.update(importador);
				}else {
					List<Importador> aux = facadeAcesso.existeImportador(importador.getNome());
					if (aux.size() != 0 ) {
						Messages.addGlobalError("Nome deste Importador é existente!");
						return;
					}
					importador.setPais(importador.getCidade().getEstado().getPais());
					importador.setUf(importador.getCidade().getEstado().getSigla());
					importador.setDescricaocidade(importador.getCidade().getNome());
					importador.setLiberadoedi(SimNao.N);
					importador.setDatastamp(cidadeDao.gettimeStamp());
					importador.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					importadorDao.update(importador);
				}
				Messages.addGlobalInfo("Operação executada com Sucesso!");
				refresh();
			} catch (RuntimeException ex) {
		        Messages.addGlobalError("Não foi possivel incluir Importador!");
			}
	}
	
	public void delete(Importador importador) {
		try {
			importadorDao.delete(importador.getImportadorid());
			refresh();
			Messages.addGlobalError("Importador Removido com Sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel remover Cidade!");
		}
	}

	public void refresh() {
		listaCidades = cidadeDao.findAll();
		listaImportador = importadorDao.findAll();
	}

}
