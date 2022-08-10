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
import org.primefaces.event.SelectEvent;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.facade.FacadeView;
import br.com.gvdexport.model.Cliente;
import br.com.gvdexport.model.Estacao;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.Modelo;
import br.com.gvdexport.model.Situacao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ModeloController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private Modelo modelo;
	@Getter @Setter
	private Estacao estacao;
	@Getter @Setter 
	private LivroReferencia livroReferencia;
	@Getter @Setter 
	private Cliente cliente;
	@Getter @Setter
	private Modelo modeloClone;
	@Getter @Setter
	private Integer operacao;
	@Getter @Setter
	private Boolean Mstatus;
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject 
	private FacadeView facadeView;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<Modelo, Long> modeloDao;
	@Getter @Setter
	private List<Situacao> ativoInativo = Arrays.asList(Situacao.values());
	
//	LazyModeloDataModel dataModel = new LazyModeloDataModel();
//
//	public LazyDataModel<Modelo> getModel(){
//		return dataModel;
//	}
	@PostConstruct
	public void init() {
    	Mstatus = true;
    	operacao = 0;
    	modelo = new Modelo();
	}
	
	
	public void add() {
		operacao = 0;
		Mstatus = false;
		modelo = new Modelo();
		modelo.setSituacao(Situacao.A);
	}
	public void cancelaOperacao() {
		facadeView.edit("", "", "");
	}
	public void edit(Modelo modeloEdit) throws CloneNotSupportedException {
		modelo = modeloDao.find(modeloEdit.getModeloid());
		modeloClone = new Modelo();
		modeloClone = (Modelo) modelo.clone();
		String referencia = modelo.getLivroreferencia().getReferencia().toString().trim();
		facadeView.edit(referencia, modelo.getSucinto(), modelo.getNomeestacao());
		operacao = 1;
		Mstatus = false;
	}

	public void save() {
		try {
			 if(modelo.getLivroreferencia() == null ) {
				 Messages.addGlobalError("Informe Referência é Obrigatorio,Verifique !");
				 return;
			 }
			
			 if(modelo.getCliente() == null ) {
				 Messages.addGlobalError("Informe Cliente é Obrigatorio,Verifique !");
				 return;
			 }
			 if(modelo.getEstacao()== null) {
				 Messages.addGlobalError("Informe Estação, é Obrigatorio,Verifique !");
				 return;
			 }

			  List<Modelo> aux = new ArrayList<>();
			  //Testa se abrev/ref/ver/cliente/esta ja possui um nome de modelo	
			  if (operacao == 1)  {	
				  if(!modelo.getLivroreferencia().equals(modeloClone.getLivroreferencia()) || (!modelo.getEstacao().equals(modeloClone.getEstacao())) || 
						  (!modelo.getCliente().equals(modeloClone.getCliente()) || (!modelo.getNome().equals(modeloClone.getNome())))) {
					 operacao = 0; 
				  }
			  }
			 if (operacao == 0) { 
		     aux = facadeAcesso.existeModeloCliente(modelo);
				 if (aux.size() != 0) {
					 Messages.addGlobalError("Este Modelo/Cliente/Estação/Nome já possui Cadastro,Verifique !");
					 return;
				 }
			 }
			modelo.setDatastamp(modeloDao.gettimeStamp());
			modelo.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			modeloDao.update(modelo);
			Messages.addGlobalInfo("Operação realizada com Sucesso !");
			facadeView.edit("", "", "");
			modelo = new Modelo();

		} catch (Exception ex) {
			Messages.addGlobalError("Não foi possivel Executar Operação com o Modelo ! ");
			ex.printStackTrace();
		}
	}

	public void delete(Modelo modelo) {
		try {
			modeloDao.delete(modelo.getModeloid());
			Messages.addGlobalInfo("Modelo/Cliente/Estação Removido com Sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel remover Modelo!");
		}
	}

	public void referenciaSelecionada(SelectEvent event) {
		livroReferencia = new LivroReferencia();
		livroReferencia = (LivroReferencia) event.getObject();
		modelo.setLivroreferencia(livroReferencia);
		modelo.setReferencia(modelo.getLivroreferencia().getReferencia());
		modelo.setVersaorefer(modelo.getLivroreferencia().getVersaorefer());
		modelo.setConstrucaonome(modelo.getLivroreferencia().getConstrucaonome());
		modelo.setVersao(modelo.getLivroreferencia().getVersao());
		modelo.setReferenciaforma(modelo.getLivroreferencia().getReferenciaforma());
	}
 
	public void clienteSelecionado(SelectEvent event) {
		cliente = new Cliente();
		cliente = (Cliente) event.getObject();
		modelo.setCliente(cliente);
		modelo.setSucinto(modelo.getCliente().getSucinto());
		
	}
	
	public void estacaoSelecionado(SelectEvent event) {
		estacao = new Estacao();
		estacao = (Estacao) event.getObject();
		modelo.setEstacao(estacao);
		modelo.setNomeestacao(getEstacao().getNome());
		
	}

}
