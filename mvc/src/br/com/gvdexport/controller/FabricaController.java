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
import br.com.gvdexport.model.Fabrica;
import br.com.gvdexport.model.GrupoFabrica;
import br.com.gvdexport.model.SimNao;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class FabricaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private Fabrica fabrica;
	@Getter @Setter
	private List<Fabrica> listaFabricas;
	@Getter @Setter
	private List<GrupoFabrica> listagrpFabricas;
	@Getter @Setter
	private List<Cidade> listaCidades;
	@Getter @Setter
	private Fabrica cloneFabrica;
	@Getter @Setter
	private List<SimNao> simplesnacional = Arrays.asList(SimNao.values());
	@Getter @Setter
	private List<Situacao> situacao = Arrays.asList(Situacao.values());
	private Integer operacao;

	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<Cidade, Long> cidadeDao;
	@Inject
	private CrudDao<Fabrica, Long> fabricaDao;
	@Inject
	private CrudDao<GrupoFabrica, Long> grpFabricaDao;
	@PostConstruct
	public void init() {
		listaCidades= new ArrayList<>();
		listaFabricas = new ArrayList<>();
		listagrpFabricas = new ArrayList<>();
		refresh();
	}
	
	public void add() {
		listaCidades = new ArrayList<>();
		listaFabricas = new ArrayList<>();
		listagrpFabricas = new ArrayList<>();
		refresh();
		fabrica = new Fabrica();
		fabrica.setSituacao(Situacao.A);
		operacao = 0;
	}

	public void edit(Fabrica mfabrica) throws CloneNotSupportedException {
		cloneFabrica = new Fabrica();
	    cloneFabrica  = (Fabrica) mfabrica.clone();
	    fabrica = mfabrica;
		operacao = 1;
	}
	public void save() {
			try {
				if(operacao == 1) {
					String priNome = fabrica.getNome().trim();
					String secNome = cloneFabrica.getNome().trim();
					if(!priNome.equals(secNome)) {
						List<Fabrica> aux = facadeAcesso.existeFabNome(fabrica.getNome(),null,null);
						if (aux.size() != 0 ) {
							Messages.addGlobalError("Este Fábrica já possui Cadastro !");
					
							return;
						}
					}
					priNome = fabrica.getSucinto().trim();
					secNome = cloneFabrica.getSucinto().trim();
					if(!priNome.equals(secNome)) {
						List<Fabrica> aux = facadeAcesso.existeFabNome(null,fabrica.getSucinto(),null);
						if (aux.size() != 0 ) {
							Messages.addGlobalError("Este Sucinto Fábrica já possui Cadastro !");
							return;
						}
					}
					priNome = fabrica.getAbreviacao().trim();
					secNome = cloneFabrica.getAbreviacao().trim();
					if(!priNome.equals(secNome)) {
						List<Fabrica> aux = facadeAcesso.existeFabNome(null,null,fabrica.getAbreviacao());
						if (aux.size() != 0 ) {
							Messages.addGlobalError("Esta Abreviação Fábrica já possui Cadastro !");
							return;
						}
					}
					
					fabrica.setDatastamp(fabricaDao.gettimeStamp());
					fabrica.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					if(fabrica.getCidade().getCidadeid() != null) {
						fabrica.setNomecidade(fabrica.getCidade().getNome());
						fabrica.setPais(fabrica.getCidade().getEstado().getPais());
						fabrica.setUf(fabrica.getCidade().getEstado().getSigla());
					}
					fabricaDao.update(fabrica);
				}else {
					List<Fabrica> auxa = facadeAcesso.existeFabNome(fabrica.getNome(),null,null);
					if (auxa.size() != 0 ) {
						Messages.addGlobalError("Este Fábrica já possui Cadastro !");
						return;
					}
					List<Fabrica> auxb = facadeAcesso.existeFabNome(null,fabrica.getSucinto(),null);
					if (auxb.size() != 0 ) {
						Messages.addGlobalError("Este Sucinto Fábrica já possui Cadastro !");
						return;
					}
					List<Fabrica> auxc = facadeAcesso.existeFabNome(null,null,fabrica.getAbreviacao());
					if (auxc.size() != 0 ) {
						Messages.addGlobalError("Esta Abreviação Fábrica já possui Cadastro !");
						return;
					}
					if(fabrica.getCidade().getCidadeid() != null) {
						fabrica.setNomecidade(fabrica.getCidade().getNome());
						fabrica.setPais(fabrica.getCidade().getEstado().getPais());
						fabrica.setUf(fabrica.getCidade().getEstado().getSigla());
					}
					fabrica.setDatastamp(fabricaDao.gettimeStamp());
					fabrica.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
					fabricaDao.update(fabrica);
				}
				refresh();
				Messages.addGlobalInfo("Operação executada com Sucesso!");
			} catch (RuntimeException ex) {
		        Messages.addGlobalError("Não foi possivel incluir Fábrica!");
				ex.printStackTrace();
		       
			}
	}
	
	public void delete(Fabrica fabrica) {
		try {
			fabricaDao.delete(fabrica.getFabricaid());
			refresh();
			Messages.addGlobalInfo("Fábrica Removida com Sucesso!");
		} catch (RuntimeException ex) {
   		    Messages.addGlobalError("Não foi possivel remover Fábrica!");
		}
	}

	public void refresh() {
		listaFabricas = fabricaDao.findAll();
		listaCidades = cidadeDao.findAll();
		listagrpFabricas = grpFabricaDao.findAll();
	}

}
