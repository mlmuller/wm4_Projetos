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
import br.com.gvdexport.model.Estado;
import br.com.gvdexport.model.Pais;
import br.com.gvdexport.model.Regiao;
import lombok.Getter;
import lombok.Setter;

@SessionScoped
@Named
public class EstadoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Estado estado;
	@Getter @Setter
	private Estado cloneEstado;
	private Integer operacao;
	@Getter @Setter
	private List<Pais> listaPaises;
	@Getter @Setter
	private List<Regiao> listaRegioes;
	@Getter @Setter
	private List<Estado> listaEstados;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private CrudDao<Pais, Long> paisesDao;
	@Inject
	private CrudDao<Regiao, Long> regioesDao;
	@Inject
	private CrudDao<Estado, Long> estadosDao;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@PostConstruct
	public void init() {
		
		listaPaises = new ArrayList<>();
		listaRegioes= new ArrayList<>();
		listaEstados= new ArrayList<>();
		refresh();
	}
	
	public void add() {
		estado = new Estado();
		operacao = 0;
	}
	
	public void edit(Estado estado) throws CloneNotSupportedException {
		cloneEstado = new Estado();
	    this.cloneEstado = (Estado) estado.clone();
		this.estado = estado;
		operacao = 1;
	}
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(operacao == 1) {
					if((estado.getNome() != cloneEstado.getNome()) || (estado.getSigla() != cloneEstado.getSigla())) {
						List<Estado> aux = facadeAcesso.existeEstado(estado.getNome(), estado.getSigla());
						if (aux.size() != 0 ) {
					        FacesContext fc = FacesContext.getCurrentInstance();
					        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Nome Estado ou Abreviacao ja possui Cadastro!","");
					        fc.addMessage("", fm1);
							return;
						}
					}
					estado.setDatastamp(estadosDao.gettimeStamp());
					estado.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					estadosDao.update(estado);
				}else {
					List<Estado> aux = facadeAcesso.existeEstado(estado.getNome(), estado.getSigla());
					if (aux.size() != 0 ) {
				        FacesContext fc = FacesContext.getCurrentInstance();
				        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Nome Estado ou Abreviacao ja possui Cadastro!","");
				        fc.addMessage("", fm1);
						return;
					}
					estado.setDatastamp(estadosDao.gettimeStamp());
					estado.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					estadosDao.update(estado);
				}
				refresh();
				context.addMessage(null, new FacesMessage("Operação executada com Sucesso!"));
			} catch (RuntimeException ex) {
		        FacesContext fc = FacesContext.getCurrentInstance();
		        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possivel incluir este Pais!","");
		        fc.addMessage("", fm1);
			}
	}
	
	public void delete(Estado estado) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			estadosDao.delete(estado.getEstadoid());
			refresh();
			context.addMessage(null, new FacesMessage("Estado Removido com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel remover Estado!"));
			ex.printStackTrace();
		}
	}

	public void refresh() {
		listaEstados = estadosDao.findAll();
		if (listaPaises.size() == 0) {
			listaPaises = paisesDao.findAll();
		}
		if(listaRegioes.size() == 0) {
			listaRegioes = regioesDao.findAll();
		}
	}
	
}
