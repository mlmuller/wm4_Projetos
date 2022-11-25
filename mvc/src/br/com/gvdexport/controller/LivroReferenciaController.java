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

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.lazy.LazyDataService;
import br.com.gvdexport.lazy.LazyLivroReferenciaDataModel;
import br.com.gvdexport.model.Construcao;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.Sequencial;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class LivroReferenciaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private LivroReferencia livroReferencia;
	@Getter @Setter
	private Sequencial novoSequencial;
	@Getter @Setter
	private Sequencial cloneSequencial;
	@Getter @Setter
	private List<LivroReferencia> listaLivroReferencia;
	@Getter @Setter
	private List<Construcao> listaConstrucao;
	@Getter @Setter
	private List<LivroReferencia> listaVersoesLivroReferencia; 
	@Getter @Setter
	private LivroReferencia cloneLivroReferencia;
	private Integer operacao;
	@Getter @Setter
	private boolean duplica;
	@Getter @Setter
	private String construcaoSelecionada;
	@Getter @Setter
	private Boolean temFicha;
	//Esta variavel,deve ser tambem relacionada com o tipo de usuario
	@Getter @Setter
	private Boolean mStatus;
	@Getter @Setter
	private Boolean libVersaoReferencia;
	@Getter @Setter
	private Boolean habilitaComplemento;
	//variaveis para Lazy
	@Getter @Setter
	private LazyDataModel<LivroReferencia> lazyModel;
	@Getter @Setter
	private LivroReferencia livroReferenciaSelecionado;

	
	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private CrudDao<Construcao, Long> construcaoDao;
	@Inject
	private CrudDao<LivroReferencia, Long> livroReferenciaDao;
	@Inject
	private LazyDataService service;
	

    @PostConstruct
	public void init() {
    	listaConstrucao = new ArrayList<Construcao>();
    	mStatus = true;
    	operacao = 0;
    	livroReferencia = new LivroReferencia();
    	construcaoSelecionada = "";
    	habilitaComplemento = true;
    	renovaLazy();
    }
    //Dados para Lazy
    public void renovaLazy() {
		lazyModel = new LazyLivroReferenciaDataModel(service.getlivroReferencia());
    }
	public void setService(LazyDataService service) {
		this.service = service;
	}
	
	public void onRowSelect(SelectEvent<LivroReferencia> event) {
	        FacesMessage msg = new FacesMessage("Referencia Selecionada", String.valueOf(event.getObject().getLivroreferenciaid()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	//------------------------------(Fim Lazy)-------------------------------------------
	//
	// Operacao 0 = inclusao
	//          1 = Altera��o
	//          2 = Duplica��o
	public void add() {
		livroReferencia = new LivroReferencia();
		listaConstrucao = new ArrayList<Construcao>();
		livroReferencia.setVersaorefer(1);
		livroReferencia.setAbreviacao("");
		operacao = 0;
		construcaoSelecionada = "";
		duplica = false;
		mStatus = true;
		habilitaComplemento = false;
		libVersaoReferencia = true;
		
	}
	public void edit(LivroReferencia rowLivroReferencia) throws CloneNotSupportedException {
		cloneLivroReferencia = new LivroReferencia();
		livroReferencia = new LivroReferencia();
		livroReferencia = rowLivroReferencia;
		listaConstrucao = new ArrayList<Construcao>();
	    cloneLivroReferencia = (LivroReferencia) rowLivroReferencia.clone();
	    construcaoSelecionada = livroReferencia.getConstrucaonome();
	    mStatus = true;
		operacao = 1;
		duplica = true;
		habilitaComplemento = true;
		libVersaoReferencia = false;
		temFicha = false; //Este sera usado,no teste se a alteracao na construcao tem ficha
	}
	public void duplicaLivroReferencia(LivroReferencia livroreferenciadup) throws CloneNotSupportedException {
		cloneLivroReferencia = new LivroReferencia();
		mStatus=false;
		this.livroReferencia = livroreferenciadup;
		cloneLivroReferencia = (LivroReferencia) livroreferenciadup.clone();
		verVersoesLivroReferencia();
		Integer ultimaVersao = 0;
		for (int i = 0; i < listaVersoesLivroReferencia.size(); i++) {
			if (listaVersoesLivroReferencia.get(i).getVersaorefer()>ultimaVersao) {
				
				ultimaVersao = listaVersoesLivroReferencia.get(i).getVersaorefer();
			}
		}
		//No Oracle versao � string neste esta sendo usado Small Int
		//Integer ultimaVersao=listaVersoesLivroReferencia.size();
		if((ultimaVersao+1) > 9) {
			Messages.addGlobalError("N�o � possivel Duplicar esta Refer�ncia,VERS�O maior que 9!");
			construcaoSelecionada = livroReferencia.getConstrucaonome();
			mStatus = false;
			return;
		}
		cloneLivroReferencia.setVersaorefer(ultimaVersao+1);
		cloneLivroReferencia.setLivroreferenciaid(null);
		cloneLivroReferencia.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
		cloneLivroReferencia.setDatastamp(livroReferenciaDao.gettimeStamp());
		construcaoSelecionada=cloneLivroReferencia.getConstrucaonome();
		try {
			 livroReferencia = new LivroReferencia();
			 livroReferencia = livroReferenciaDao.update(cloneLivroReferencia);
			 renovaLazy();
			 operacao = 2;
			 //Clonando novamente,pois neste estagio pode alterar a construcao/versao/forma
			 //Precisa verificar se a proxima alteracao, possui cadastro....
			 cloneLivroReferencia = new LivroReferencia();
			 cloneLivroReferencia = (LivroReferencia) livroReferencia.clone();
			 Messages.addGlobalInfo("Referencia duplicada com Sucesso !");
		} catch (Exception ex) {
			Messages.addGlobalError("N�o foi possivel Duplicar Referencia !");
			ex.printStackTrace();
			return;
		}
		
	}
	public void complementaLivroReferencia() {
		if (operacao == 0) {
			livroReferencia.setVersao(livroReferencia.getConstrucao().getVersao());
			livroReferencia.setReferenciaforma(livroReferencia.getConstrucao().getReferenciaforma());
			livroReferencia.setDatastamp(livroReferenciaDao.gettimeStamp());
			livroReferencia.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			livroReferencia.setConstrucaonome(livroReferencia.getConstrucao().getConstrucao());
			construcaoSelecionada=livroReferencia.getConstrucaonome();
			Integer serial = facadeAcesso.getNextSequence();
			livroReferencia.setReferencia(serial);
			habilitaComplemento = false;
		}
	}
	public void verificaBloqueio() {
		
	}
	public void save() {
			habilitaComplemento = true;
			try {
				livroReferencia.setDatastamp(construcaoDao.gettimeStamp());
				livroReferencia.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
				if(operacao == 1 ) {
					if (livroReferencia.getConstrucao() == null) {
						livroReferencia.setConstrucao(cloneLivroReferencia.getConstrucao());
					}
					//Testa se houve aluma alteracao na construcao ou abreviacao
					if ((!livroReferencia.getConstrucao().getConstrucaoid().equals(cloneLivroReferencia.getConstrucao().getConstrucaoid())) || (livroReferencia.getAbreviacao() != (cloneLivroReferencia.getAbreviacao()))) {
						//envia abrev,referencia,versao,construcao,versao,forma
						LivroReferencia aux = facadeAcesso.existeLivroReferenciaVersao(livroReferencia.getAbreviacao(),livroReferencia.getReferencia(),livroReferencia.getVersaorefer(),livroReferencia.getConstrucao().getConstrucaoid());
						if(aux != null) {
							Messages.addGlobalError("Esta Combina��o j� possui Cadastro !");
							return;
						}
					}
					if(livroReferencia.getVersaorefer() > 9) {
					       Messages.addGlobalError("N�o � possivel cadastrar mais que 9 vers�es!");
					       return;
					}

					livroReferencia.setConstrucaonome(livroReferencia.getConstrucao().getConstrucao());
					livroReferencia.setVersao(livroReferencia.getConstrucao().getVersao());
					livroReferencia.setReferenciaforma(livroReferencia.getConstrucao().getReferenciaforma());
				}	
				if ((operacao == 1) || (operacao == 2)) {
				   // Verificar se existe ficha com Cadastro
				   // Chave , construcao + versao
				   if(operacao == 1) {
//					  listaLivroReferencia = new ArrayList<LivroReferencia>();
//					  listaLivroReferencia = facadeAcesso.existeConstrucaoReferencia(cloneLivroReferencia.getConstrucao().getConstrucaoid());
//					  if(listaLivroReferencia.size() > 0 )  {
//						  Messages.addGlobalFatal("Existe(m) FICHA(S) de AMOSTRA(S),ALTERA��O valer� para TODAS ?");
//						  temFicha = true;
//						  return;
//					  }
				   }
				   if (operacao == 2) {
					   //Ocorreu uma duplica��o,se houve altera��o na constru��o,pois pode ocorrer problemas de vers�o..travar....
					   if(!livroReferencia.getConstrucao().getConstrucaoid().equals(cloneLivroReferencia.getConstrucao().getConstrucaoid())) {
							//envia abrev,referencia,versao,construcao,versao,forma
							LivroReferencia aux = facadeAcesso.existeLivroReferenciaVersao(livroReferencia.getAbreviacao().trim(),livroReferencia.getReferencia(),livroReferencia.getVersaorefer(),livroReferencia.getConstrucao().getConstrucaoid());
							livroReferencia.setConstrucaonome(livroReferencia.getConstrucao().getConstrucao());
							livroReferencia.setReferenciaforma(livroReferencia.getConstrucao().getForma().getReferenciaforma());
							livroReferencia.setVersao(livroReferencia.getConstrucao().getVersao());
							if(aux != null) {
								Messages.addGlobalError("Esta Combina��o j� possui Cadastro !");
								livroReferencia.setConstrucao(cloneLivroReferencia.getConstrucao());
								return;
							}
						}
						   
				   }
				   
				    	
				   livroReferenciaDao.update(livroReferencia);
				   renovaLazy();
				}	
				if(operacao == 0) {
					if(livroReferencia.getVersaorefer() > 9) {
				       Messages.addGlobalError("N�o � possivel cadastrar mais que 9 vers�es!");
				       return;
				    						
					}
					habilitaComplemento = true;
					livroReferenciaDao.update(livroReferencia);
					mStatus = false;
			    	construcaoSelecionada = "";
			    	renovaLazy();
				}
				Messages.addGlobalInfo("Opera��o executada com Sucesso!");
			} catch (RuntimeException ex) {
		        Messages.addGlobalError("N�o foi Executar opera��o com a Refer�ncia!");
				ex.printStackTrace();
		       
			}
	}
	
	public void delete(LivroReferencia livroReferencia) {
		try {
			livroReferenciaDao.delete(livroReferencia.getLivroreferenciaid());
			renovaLazy();
			Messages.addGlobalInfo("Refer�ncia Removida com Sucesso!");
		} catch (RuntimeException ex) {
   		    Messages.addGlobalError("N�o foi possivel remover Refer�ncia!");
		}
	}

	public void buscaConstrucoes(){
		if (!construcaoSelecionada.isEmpty()) {
			listaConstrucao = facadeAcesso.existeConstrucoes(construcaoSelecionada);
		}
		if (listaConstrucao.size() == 0) {
   		    Messages.addGlobalError("Constru��o informada n�o existente,verifique!");
   		    mStatus = false;
   		    return;
		}
		if (listaConstrucao.size() == 1) {
			livroReferencia.setConstrucao(listaConstrucao.get(0));
			complementaLivroReferencia();
			mStatus = true;
		}
	}
	public void verVersoesLivroReferencia(){
	    if ((livroReferencia.getReferencia() == null) || livroReferencia.getReferencia() == 0) {
	    	Messages.addGlobalError("Informe Referencia para verifica��o de Vers�o(�es) !");
	    	return;
	    }
	    listaVersoesLivroReferencia = new ArrayList<>();
	    listaVersoesLivroReferencia = facadeAcesso.existeLivroReferenciaVersoes(livroReferencia.getReferencia(),livroReferencia.getAbreviacao().trim());
	    if (listaVersoesLivroReferencia.size() == 0){
	    	Messages.addGlobalInfo("N�o h� Cadastro para esta Refer�ncia!");
	    	livroReferencia.setVersaorefer(1);
	    	return;
	    }
	}

}
