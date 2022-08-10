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
import br.com.gvdexport.model.Situacao;
import br.com.gvdexport.model.Transportador;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class TransportadoraController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private List<Cidade> listaCidades;
	@Getter @Setter
	private List<Transportador> listaTransportadora;
	@Getter @Setter
	private Transportador cloneTransportadora;
	@Getter @Setter
	private Transportador transportador;
	private Integer operacao;
	@Getter @Setter
	private List<Situacao> ativoinativo = Arrays.asList(Situacao.values());
	@Inject
	private CrudDao<Cidade, Long> cidadeDao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<Transportador, Long> transportadoraDao;
	@PostConstruct
	public void init() {
		listaCidades= new ArrayList<>();
		listaTransportadora = new ArrayList<>();
		refresh();
	}
	
	public void add() {
		transportador = new Transportador();
		transportador.setSituacao(Situacao.A);
		operacao = 0;
	}
	
	public void edit(Transportador transportador) {
		cloneTransportadora = new Transportador();
	    this.transportador = transportador ;
	    cloneTransportadora = transportador;
		operacao = 1;
	}
	public void save() {
			try {
				if(operacao == 1) {
					if(transportador.getNome() != cloneTransportadora.getNome()) {
						List<Transportador> aux = facadeAcesso.existeTransportadora(transportador.getNome());
						if (aux.size() != 0 ) {
							Messages.addGlobalError("Transportadora já está Cadastrado !");
							return;
						}
					}
					transportador.setUf(transportador.getCidade().getEstado().getSigla());
					transportador.setNomecidade(transportador.getCidade().getNome());
					transportador.setDatastamp(transportadoraDao.gettimeStamp());
					transportador.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					transportadoraDao.update(transportador);
				}else {
					List<Transportador> aux = facadeAcesso.existeTransportadora(transportador.getNome());
					if (aux.size() != 0 ) {
						Messages.addGlobalError("Nome Transportador é existente!");
						return;
					}
					transportador.setUf(transportador.getCidade().getEstado().getSigla());
					transportador.setNomecidade(transportador.getCidade().getNome());
					transportador.setDatastamp(cidadeDao.gettimeStamp());
					transportador.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					transportadoraDao.update(transportador);
				}
				Messages.addGlobalInfo("Operação executada com Sucesso!");
				refresh();
			} catch (RuntimeException ex) {
		        Messages.addGlobalError("Não foi possivel incluir Transportadora!");
			}
	}
	
	public void delete(Transportador transportador){
		try {
			transportadoraDao.delete(transportador.getTransportadoraid());
			refresh();
			Messages.addGlobalError("Transportadora Removida com Sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel remover Transportadora!");
		}
	}

	public void refresh() {
		if (listaCidades.size() == 0) {
			listaCidades = cidadeDao.findAll();
		}
		listaTransportadora = transportadoraDao.findAll();
	}

}
