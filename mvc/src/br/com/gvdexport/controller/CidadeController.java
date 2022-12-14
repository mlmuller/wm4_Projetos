package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Cidade;
import br.com.gvdexport.model.Estado;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class CidadeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private List<Estado> listaEstados;
	@Getter @Setter
	private List<Cidade> listaCidades;
	@Getter @Setter
	private Cidade cidade;
	@Getter @Setter
	private Cidade cloneCidade;
	
	private Integer operacao;

	@Inject
	private CrudDao<Cidade, Long> cidadeDao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<Estado, Long> estadoDao;
	@PostConstruct
	public void init() {
		listaEstados= new ArrayList<>();
		listaCidades= new ArrayList<>();
		refresh();
	}
	
	public void add() {
		cidade = new Cidade();
		operacao = 0;
	}
	
	public void edit(Cidade cidade) throws CloneNotSupportedException {
		cloneCidade = new Cidade();
	    this.cloneCidade = (Cidade) cidade.clone();
		this.cidade = cidade;
		operacao = 1;
	}
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(operacao == 1) {
					if(cidade.getNome() != cloneCidade.getNome()) {
						List<Cidade> aux = facadeAcesso.existeCidade(cidade.getNome());
						if (aux.size() != 0 ) {
					        FacesContext fc = FacesContext.getCurrentInstance();
					        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Nome Cidade ja possui Cadastro!","");
					        fc.addMessage("", fm1);
							return;
						}
					}
					cidade.setDatastamp(cidadeDao.gettimeStamp());
					cidade.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					cidadeDao.update(cidade);
				}else {
					List<Cidade> aux = facadeAcesso.existeCidade(cidade.getNome());
					if (aux.size() != 0 ) {
				        FacesContext fc = FacesContext.getCurrentInstance();
				        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Nome Cidade ja possui Cadastro!","");
				        fc.addMessage("", fm1);
						return;
					}
					cidade.setDatastamp(cidadeDao.gettimeStamp());
					cidade.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					cidadeDao.update(cidade);
				}
				refresh();
				context.addMessage(null, new FacesMessage("Opera??o executada com Sucesso!"));
			} catch (RuntimeException ex) {
		        FacesContext fc = FacesContext.getCurrentInstance();
		        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"N?o foi possivel incluir Cidade!","");
		        fc.addMessage("", fm1);
			}
	}
	
	public void delete(Cidade cidade) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			cidadeDao.delete(cidade.getCidadeid());
			refresh();
			context.addMessage(null, new FacesMessage("Cidade Removida com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("N?o foi possivel remover Cidade!"));
			ex.printStackTrace();
		}
	}

	public void refresh() {
		listaEstados = estadoDao.findAll();
		listaCidades = cidadeDao.findAll();
		if (listaEstados.size() == 0) {
			listaEstados = estadoDao.findAll();
		}
	}

}
