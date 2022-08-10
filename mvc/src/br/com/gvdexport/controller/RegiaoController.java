package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Regiao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class RegiaoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Regiao regiao;
	@Getter @Setter
	private Regiao cloneRegiao;
	
	private Integer operacao;
	
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	protected UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<Regiao, Long> regiaoDao;
	
	@Getter @Setter
	private List<Regiao> listaRegioes;
	@PostConstruct
	public void init() {
		refresh();
	}
	
	public void add() {
		refresh();
		regiao = new Regiao();
		operacao = 0;
	}

	public void edit(Regiao regiao) throws CloneNotSupportedException {
		cloneRegiao = new Regiao();
	    this.cloneRegiao = (Regiao) regiao.clone();
		this.regiao = regiao;
		
		operacao = 1;
	}
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
			try {
				if(operacao == 1) {
					if(regiao.getNome() != cloneRegiao.getNome()) {
						List<Regiao> aux = facadeAcesso. existeRegiao(regiao.getNome());
						if (aux.size() != 0 ) {
					        FacesContext fc = FacesContext.getCurrentInstance();
					        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Nome Região ja possui Cadastro!","");
					        fc.addMessage("", fm1);
							return;
						}
					}
					regiao.setDatastamp(regiaoDao.gettimeStamp());
					regiao.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					regiaoDao.update(regiao);
				}else {
					List<Regiao> aux = facadeAcesso.existeRegiao(regiao.getNome());
					if (aux.size() != 0 ) {
				        FacesContext fc = FacesContext.getCurrentInstance();
				        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Nome Regiao ja possui Cadastro!","");
				        fc.addMessage("", fm1);
						return;
					}
					regiao.setDatastamp(regiaoDao.gettimeStamp());
					regiao.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					regiaoDao.update(regiao);
				}
				refresh();
				context.addMessage(null, new FacesMessage("Processo executado com Sucesso!"));
			} catch (RuntimeException ex) {
		        FacesContext fc = FacesContext.getCurrentInstance();
		        FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possivel incluir esta Região","");
		        fc.addMessage("", fm1);
			}
	}
	
	public void delete(Regiao regiao) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			regiaoDao.delete(regiao.getRegiaoid());
			refresh();
			context.addMessage(null, new FacesMessage("Região Cancelado com Sucesso!"));
		} catch (RuntimeException ex) {
			context.addMessage(null, new FacesMessage("Não foi possivel Cancelar Região!"));
			ex.printStackTrace();
		}
	}

	public void refresh() {
		listaRegioes = regiaoDao.findAll();
	}
	

}
