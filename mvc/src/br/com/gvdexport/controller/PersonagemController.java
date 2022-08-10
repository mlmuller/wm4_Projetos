package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Personagem;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class PersonagemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Personagem personagem;
	@Getter @Setter
	private Personagem clonePersonagem;
	@Getter @Setter
	private List<Personagem> listaPersonagem;
	@Inject
	private CrudDao<Personagem, Long> personagemDao;
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
		personagem = new Personagem();
		operacao = 0;
	}

	public void edit(Personagem personagem) throws CloneNotSupportedException {
		clonePersonagem = new Personagem();
	    this.clonePersonagem = (Personagem) personagem.clone();
		this.personagem = personagem;
		
		operacao = 1;
	}
	public void save() {
			try {
				if(operacao == 1) {
					if((personagem.getNome() != clonePersonagem.getNome())) {
						List<Personagem> aux = facadeAcesso.existePersonagem(personagem.getNome());
						if (aux.size() != 0 ) {
							Messages.addGlobalError("Este personagem já possui Cadastro ,verifique !");
							return;
						}
					}
					personagem.setDatastamp(personagemDao.gettimeStamp());
					personagem.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					personagemDao.update(personagem);
				}else {
					List<Personagem> aux = facadeAcesso.existePersonagem(personagem.getNome());
					if (aux.size() != 0 ) {
						Messages.addGlobalError("Este personagem já esta Cadastrado,verifique !");
						return;
					}
					
					personagem.setDatastamp(personagemDao.gettimeStamp());
					personagem.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					personagemDao.update(personagem);
				}
				refresh();
				Messages.addGlobalInfo("Personagem Cadastrado com Sucesso !");
			} catch (RuntimeException ex) {
				Messages.addGlobalError("Não foi possivel executar a operação !");
			}
	}
	
	public void delete(Personagem personagem) {
		try {
			personagemDao.delete(personagem.getPersonagemid());
			refresh();
			Messages.addGlobalInfo("Personagem Cancelado com sucesso !");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Cancelar Personagem,Pode estar Referenciado!");
			ex.printStackTrace();
		}
	}

	public void refresh() {
		listaPersonagem = personagemDao.findAll();
	}
	
}
