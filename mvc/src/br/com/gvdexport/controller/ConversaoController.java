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

import br.com.gvdexport.dao.ConversaoDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Conversao;
import br.com.gvdexport.model.Genero;
import br.com.gvdexport.model.PadraoEspecial;
import br.com.gvdexport.model.TipoSize;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ConversaoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Conversao conversao;
	@Getter	@Setter
	private List<Conversao> listaConversoes;
	@Getter @Setter
	private List<Genero> genero = Arrays.asList(Genero.values());
	private Integer tipoOperacao;
	@Getter @Setter
	private List<TipoSize> tiposize = Arrays.asList(TipoSize.values());
	@Getter @Setter
	private List<PadraoEspecial> padraoespecial = Arrays.asList(PadraoEspecial.values());

	@PostConstruct
	public void init() {
		listaConversoes = new ArrayList<>();
		tipoOperacao = 0;
		listaConversoes = conversaoDao.findAll();
	}
	@Inject
	private UsuarioLogadoController logadoController;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private ConversaoDao conversaoDao;
	
	public void add() {
		conversao = new Conversao() ;
		conversao.setPadraoespecial(PadraoEspecial.P);
	}
	public void edit(Conversao conversao) {
		this.conversao = conversao;
		tipoOperacao = 1;
	}
	
	public void save() {
		if(conversao.getPadraoespecial().equals(PadraoEspecial.P)) {
			conversao.setNome(conversao.getTiposize().getLabel());
		}else {
			conversao.setNome(conversao.getNomeespecial());
		}
		List<Conversao> aux = facadeAcesso.existeConversaoNome(conversao.getNome());
		if (tipoOperacao == 0) {
			if (aux.size() != 0) {
				Messages.addGlobalError("Nome conversão Existente,Verique!");
	    		return;
			}
		}
		try {
			conversao.setDatastamp(facadeAcesso.gettimeStamp());
			conversao.setUsuariostamp(logadoController.getUsuariologado().getUsuario());
			conversaoDao.update(conversao);
			refresh();
	        Messages.addGlobalInfo("conversão salva com sucesso !");
		} catch (RuntimeException ex) {
	        Messages.addFlashGlobalError("Não foi possivel executar Processo !");
			ex.printStackTrace();
		}
	}
	public void delete(Conversao conversao) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			conversaoDao.delete(conversao.getConversaoid());
			refresh();
			context.addMessage(null, new FacesMessage("Conversão Cancelada com Sucesso!"));
			Messages.addGlobalInfo("Conversão Cancelada com sucesso !");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel executar Cancelamento !");
			ex.printStackTrace();
		}
	}

	public void refresh() {
		  listaConversoes = conversaoDao.findAll();
	}
	
	
}
