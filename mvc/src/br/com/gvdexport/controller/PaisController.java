package br.com.gvdexport.controller;

import java.io.Serializable;
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
import br.com.gvdexport.model.Continentes;
import br.com.gvdexport.model.Pais;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class PaisController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Pais pais;
	@Getter @Setter
	private Pais clonePais;
	@Getter @Setter
	private List<Pais> listaPaises;
	@Getter @Setter
	private List<Continentes> continentes = Arrays.asList(Continentes.values());
	@Inject
	private CrudDao<Pais, Long> paisesDao;
	@Inject
	protected UsuarioLogadoController usuarioLogado;
	@Inject
	private FacadeAcesso facadeAcesso;
	private Integer operacao;
	@PostConstruct
	public void init() {
		refresh();
	}
	
	public void add() {
		refresh();
		pais = new Pais();
		operacao = 0;
	}

	public void edit(Pais pais) throws CloneNotSupportedException {
		clonePais = new Pais();
	    this.clonePais = (Pais) pais.clone();
		this.pais = pais;
		
		operacao = 1;
	}
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(operacao == 1) {
					if((pais.getNome() != clonePais.getNome()) || (pais.getSigla() != clonePais.getSigla())) {
						List<Pais> aux = facadeAcesso.existePais(pais.getNome(), pais.getSigla());
						if (aux.size() != 0 ) {
					        FacesContext fc = FacesContext.getCurrentInstance();
					        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Nome Pais ou Abreviacao ja possui Cadastro!","");
					        fc.addMessage("", fm1);
							return;
						}
					}
					if (pais.getContinente() != clonePais.getContinente() ) {
						ajustaContinente(pais);
					}
					pais.setDatastamp(paisesDao.gettimeStamp());
					pais.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					paisesDao.update(pais);
				}else {
					List<Pais> aux = facadeAcesso.existePais(pais.getNome(), pais.getSigla());
					if (aux.size() != 0 ) {
				        FacesContext fc = FacesContext.getCurrentInstance();
				        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Nome Pais ou Abreviacao ja possui Cadastro!","");
				        fc.addMessage("", fm1);
						return;
					}
					ajustaContinente(pais);
					pais.setDatastamp(paisesDao.gettimeStamp());
					pais.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					paisesDao.update(pais);
				}
				refresh();
				context.addMessage(null, new FacesMessage("Processo executado com Sucesso!"));
			} catch (RuntimeException ex) {
		        FacesContext fc = FacesContext.getCurrentInstance();
		        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possivel incluir este Pais!","");
		        fc.addMessage("", fm1);
			}
	}
	
	public void delete(Pais pais) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			paisesDao.delete(pais.getPaisid());
			refresh();
			context.addMessage(null, new FacesMessage("Pais Cancelado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel Cancelar Pais!"));
			ex.printStackTrace();
		}
	}

	public void refresh() {
		listaPaises = paisesDao.findAll();
	}
	
	public void ajustaContinente(Pais pais) {
		switch (pais.getContinente()) {
		case A:
			pais.setNomecontinente(continentes.get(0).getLabel1());
			pais.setGrupopais(continentes.get(0).getLabel2());
			break;
		case B:
			pais.setNomecontinente(continentes.get(1).getLabel1());
			pais.setGrupopais(continentes.get(1).getLabel2());
			break;
		case C:
			pais.setNomecontinente(continentes.get(2).getLabel1());
			pais.setGrupopais(continentes.get(2).getLabel2());
			break;
		case D:
			pais.setNomecontinente(continentes.get(3).getLabel1());
			pais.setGrupopais(continentes.get(3).getLabel2());
			break;
		case E:
			pais.setNomecontinente(continentes.get(4).getLabel1());
			pais.setGrupopais(continentes.get(4).getLabel2());
			break;
		case F:
			pais.setNomecontinente(continentes.get(5).getLabel1());
			pais.setGrupopais(continentes.get(5).getLabel2());
			break;
		case G:
			pais.setNomecontinente(continentes.get(6).getLabel1());
			pais.setGrupopais(continentes.get(6).getLabel2());
			break;
		}
	}
}
