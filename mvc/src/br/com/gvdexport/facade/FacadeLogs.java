package br.com.gvdexport.facade;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.com.gvdexport.model.AcabamentoAmostra;
import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.Banco;
import br.com.gvdexport.model.Cidade;
import br.com.gvdexport.model.Cliente;
import br.com.gvdexport.model.ClienteProjecao;
import br.com.gvdexport.model.Componente;
import br.com.gvdexport.model.Construcao;
import br.com.gvdexport.model.Conversao;
import br.com.gvdexport.model.Cor;
import br.com.gvdexport.model.CorAcabamentoAm;
import br.com.gvdexport.model.CorAmostra;
import br.com.gvdexport.model.CorAmostraMulti;
import br.com.gvdexport.model.CorCabedalAm;
import br.com.gvdexport.model.CorConstrucaoAm;
import br.com.gvdexport.model.CorCorteAm;
import br.com.gvdexport.model.CorCosturaAm;
import br.com.gvdexport.model.CorteAmostra;
import br.com.gvdexport.model.CosturaAmostra;
import br.com.gvdexport.model.Cotacao;
import br.com.gvdexport.model.DGAGlobal;
import br.com.gvdexport.model.Despachante;
import br.com.gvdexport.model.DestinoAmCf;
import br.com.gvdexport.model.EmTransicao;
import br.com.gvdexport.model.Estacao;
import br.com.gvdexport.model.Estado;
import br.com.gvdexport.model.Etiquetas;
import br.com.gvdexport.model.Fabrica;
import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.model.Forma;
import br.com.gvdexport.model.GrupoCliente;
import br.com.gvdexport.model.GrupoClienteInvoice;
import br.com.gvdexport.model.GrupoFabrica;
import br.com.gvdexport.model.Hts;
import br.com.gvdexport.model.ImagemReferencia;
import br.com.gvdexport.model.Importador;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.LogAmostrasNovas;
import br.com.gvdexport.model.MarcaCliente;
import br.com.gvdexport.model.Material;
import br.com.gvdexport.model.Modelo;
import br.com.gvdexport.model.Moeda;
import br.com.gvdexport.model.Navio;
import br.com.gvdexport.model.Nbm;
import br.com.gvdexport.model.Pais;
import br.com.gvdexport.model.Personagem;
import br.com.gvdexport.model.PrazoPagamento;
import br.com.gvdexport.model.RazaoAlteracao;
import br.com.gvdexport.model.Regiao;
import br.com.gvdexport.model.TipoCalcado;
import br.com.gvdexport.model.Transportador;

@Named
@SessionScoped
public class FacadeLogs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;


	public List<LogAmostrasNovas> getBuscaLogsAmostraNova(Long amostraid){
		try {
			TypedQuery<LogAmostrasNovas> q = em.createQuery("SELECT lan " + 
					   "FROM  lan LogAmostrasNovas " +
					   "WHERE lan.amostra.amostraId=:Id ",LogAmostrasNovas.class);
						q.setParameter("Id",amostraid);
						return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}


}
