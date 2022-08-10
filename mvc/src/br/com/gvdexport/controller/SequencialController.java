package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.gvdexport.dao.SequencialDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Grupo;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.Sequencial;
import lombok.Getter;
import lombok.Setter;

@SessionScoped
@Named
public class SequencialController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private Sequencial novasequencia;
	@Getter @Setter
	private LivroReferencia livroReferencia;
	@Getter @Setter
	private List<Sequencial> listaSequencial;
	@Inject
	private SequencialDao sequencialDao;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
    //
	private Integer operacao;
	@PostConstruct
	public void init() {
		listaSequencial = new ArrayList<>();
		refresh();
		operacao = 0;
	}
	
	public void add() {
		novasequencia = new Sequencial();
		operacao = 1;
	}
	
	public void edit(Sequencial sequencial){
	    this.novasequencia = sequencial;
	    operacao = 2;
	    if (!usuarioLogado.getUsuariologado().getGrupo().equals(Grupo.M)) {
			Messages.addGlobalFatal("Olá, você não tem permissão para alterar Sequencial!");
			Messages.addGlobalWarn("Contate Administrador do Sistema,Obrigado");
			return;
	    }
	}
	public void save() {
			try {
			 if(operacao == 2) {	
				livroReferencia = new LivroReferencia();
				livroReferencia = facadeAcesso.getBuscaUltimo(1);
				if(novasequencia.getReferencia() <= livroReferencia.getReferencia()) {
					Messages.addGlobalFatal("Alteração de Referencia para numero anterior a existente..Última Reserva:" + livroReferencia.getReferencia());
					return;
				}
			  }
				sequencialDao.update(novasequencia);
				refresh();
				Messages.addGlobalInfo("Operação executada com Sucesso!");
			} catch (RuntimeException ex) {
				Messages.addGlobalError("Não foi possivel executar o processo!");
			}
	}
	
	public void refresh() {
		listaSequencial = sequencialDao.findAll();
	}
}
