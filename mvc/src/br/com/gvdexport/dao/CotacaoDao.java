package br.com.gvdexport.dao;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.gvdexport.core.Transactional;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.Cotacao;

@RequestScoped
public class CotacaoDao extends CrudDao<Cotacao, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	@Inject
	private FacadeAcesso facadeAcesso;
	
	@Transactional
	public void saveVetorCotacao(List<Cotacao> listaCotacao) {
		Cotacao cotacao =new Cotacao();
		for (int i = 0; i < listaCotacao.size(); i++) {
			cotacao = listaCotacao.get(i);
			cotacao = em.merge(cotacao);
			listaCotacao.get(i).setCotacaoid(cotacao.getCotacaoid());
			cotacao = new Cotacao();
		} 
	}
	
	@Transactional
	public void saveCompletaMes(List<Cotacao> listaImportada) throws ParseException {
		Cotacao cotacaoAux = new Cotacao();
		Cotacao cotacao = new Cotacao();
		for (int i = 0; i < listaImportada.size(); i++) {
			cotacaoAux = listaImportada.get(i);
			java.sql.Date data = new java.sql.Date(cotacaoAux.getDatacotacao().getTime());
			cotacao = facadeAcesso.existeUnicoDiaCotacao(data, listaImportada.get(i).getMoedas().getSigla());
			if (cotacao == null) {
				cotacao = listaImportada.get(i);
			}else {
				cotacao.setIdentificadorcotacao(cotacaoAux.getIdentificadorcotacao());
				cotacao.setValorcompra(cotacaoAux.getValorcompra());
				cotacao.setValorvenda(cotacaoAux.getValorvenda());
				cotacao.setVlrcomprareais(cotacaoAux.getVlrcomprareais());
				cotacao.setVlrvendareais(cotacaoAux.getVlrvendareais());
			}
			em.merge(cotacao);
			cotacao = new Cotacao();
		}
	}

}
