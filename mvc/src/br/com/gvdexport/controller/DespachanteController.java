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

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Cidade;
import br.com.gvdexport.model.Despachante;
import br.com.gvdexport.model.Estado;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class DespachanteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Despachante despachante;
	@Getter @Setter
	private Despachante cloneDespachante;
	@Getter @Setter
	private List<Despachante> listaDespachantes;
	@Getter @Setter
	private List<Cidade> listaCidades;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	private Integer operacao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private CrudDao<Cidade, Long> cidadeDao;
	@Inject
	private CrudDao<Despachante, Long> despachanteDao;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	
	@PostConstruct
	public void init() {
		
		listaCidades = new ArrayList<>();
		listaDespachantes= new ArrayList<>();
		refresh();
	}
	
	public void add() {
		despachante = new Despachante();
		operacao = 0;
	}
	
	public void edit(Despachante despachante) throws CloneNotSupportedException {
		cloneDespachante = new Despachante();
	    this.cloneDespachante = (Despachante) despachante.clone() ;
		this.despachante = despachante;
		operacao = 1;
	}
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(operacao == 1) {
					if(despachante.getNome() != cloneDespachante.getNome()) {
						List<Despachante> aux = facadeAcesso.existeDespachante(despachante.getNome());
						if (aux.size() != 0 ) {
					        FacesContext fc = FacesContext.getCurrentInstance();
					        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Despachante ja possui Cadastro!","");
					        fc.addMessage("", fm1);
							return;
						}
					}
					despachante.setCidade(despachante.getCidades().getNome());
					despachante.setUf(despachante.getCidades().getEstado().getNome());
					despachante.setDatastamp(despachanteDao.gettimeStamp());
					despachante.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					despachanteDao.update(despachante);
				}else {
					List<Despachante> aux = facadeAcesso.existeDespachante(despachante.getNome());
					if (aux.size() != 0 ) {
				        FacesContext fc = FacesContext.getCurrentInstance();
				        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Despachante ja possui Cadastro!","");
				        fc.addMessage("", fm1);
						return;
					}
					despachante.setCidade(despachante.getCidades().getNome());
					despachante.setUf(despachante.getCidades().getEstado().getNome());
					despachante.setDatastamp(despachanteDao.gettimeStamp());
					despachante.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					despachanteDao.update(despachante);
				}
				refresh();
				context.addMessage(null, new FacesMessage("Operação executada com Sucesso!"));
			} catch (RuntimeException ex) {
		        FacesContext fc = FacesContext.getCurrentInstance();
		        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possivel incluir Despachante!","");
		        fc.addMessage("", fm1);
			}
	}
	
	public void delete(Estado estado) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			despachanteDao.delete(despachante.getDespachanteid());
			refresh();
			context.addMessage(null, new FacesMessage("Despachante Removido com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel remover Despachante!"));
			ex.printStackTrace();
		}
	}

	public void refresh() {
		listaDespachantes = despachanteDao.findAll();
		if (listaCidades.size() == 0) {
			listaCidades = cidadeDao.findAll();
		}
	}
	

}
