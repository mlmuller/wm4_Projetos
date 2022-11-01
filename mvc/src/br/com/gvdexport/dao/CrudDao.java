package br.com.gvdexport.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.gvdexport.facade.DGAFacadeCompKey;
import br.com.gvdexport.model.CorAcabamentoAm;
import br.com.gvdexport.model.CorAmostra;
import br.com.gvdexport.model.CorAmostraMulti;
import br.com.gvdexport.model.CorCabedalAm;
import br.com.gvdexport.model.CorConstrucaoAm;
import br.com.gvdexport.model.CorCorteAm;
import br.com.gvdexport.model.CorCosturaAm;
import br.com.gvdexport.model.EmTransicao;
import br.com.gvdexport.model.EnderecoCliente;
import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.model.LogAmostraFichaProducao;
import br.com.gvdexport.model.LogAmostraFichaProducao_;
import br.com.gvdexport.model.LogAmostrasNovas;

@Named("crudDao")
public class CrudDao<T,ID> implements Serializable{
	    

	private static final long serialVersionUID = 1L;

	   @Inject
	   protected GenericDao<T, ID> dao;
	   @Inject
	   private DGAFacadeCompKey acessoFacade;
	    
	   protected Class<T> entityClass;
	    
	   @SuppressWarnings("unchecked")
	   public Class<T> getEntityClass() {
	        if (entityClass == null) {
	            //only works if one extends BaseDao, we will take care of it with CDI
	            entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	        }
	        return entityClass;
	    }

	    public void setEntityClass(Class<T> entityClass) {
	        this.entityClass = entityClass;
	    }
	    public T find(ID id){
	        return dao.find(id, getEntityClass());
	    }
	    public void delete(ID id){
	         dao.delete(id, getEntityClass());
	    }

	    public void DeleteEC(Long idP, Integer idS) {
	    	EnderecoCliente aux = acessoFacade.buscarChaveCompEndCliUni(idP,idS);
	    	dao.deleteEC(aux);
	    }
	    
	    public T update(T t){
	        return dao.update(t);
	    }
	    public void insert(T t){
	        dao.insert(t);
	    }
	    
	    public CorAmostra updateCorAmostra(CorAmostra corAmostra) {
	    	return dao.updateCorAmostra(corAmostra);
	    }
	    
	    public void updateCorMulti(List<CorAmostraMulti> finalMulti) {
//	        for (CorAmostraMulti corMulti : finalMulti) {
	    	CorAmostraMulti corMulti = new CorAmostraMulti();
	    	for (int i = 0; i < finalMulti.size(); i++) {
	    		corMulti = finalMulti.get(i);
	    		if (corMulti.getCormultiid() != null && corMulti.getMaterial() == null) {
	    			dao.deleteCorMulti(corMulti);
	    		}else {
		        	dao.updateCorMulti(corMulti);
	    			
	    		}
	        	corMulti = new CorAmostraMulti();
	        }
	    }
	    //Deletar Lista Tabela Multi
	    public void deleteCorMulti(List<CorAmostraMulti> listaMultiDelete) {
	    	for (CorAmostraMulti listaMultiDel : listaMultiDelete) {
	    		dao.deleteCorMulti(listaMultiDel);
	    	}
	    }
	    //Deletar Lista Tabela Cabedais
	    public void deleteCabedalMulti(List<CorCabedalAm> listaCabMultiDelete) {
	    	for (CorCabedalAm listaCabMultiDel : listaCabMultiDelete) {
	    		dao.deleteCabedalMulti(listaCabMultiDel);
	    	}
	    }
	    
	    
	    //Amostras Novas - cores
	    //Gravacao Acabamentos Corte - Amostras
	    public void saveAmostraCorCorte(List<CorCorteAm> corCorteAmostra) {
	    	for (CorCorteAm finalCorCorte : corCorteAmostra) {
	    		dao.saveCorCorteAmostra(finalCorCorte);
	    	}
	    }
	    //Gravacao Acabamentos Costura - Amostras
	    public void updateAmostraCorCostura(List<CorCosturaAm> corCosturaAmostra) {
	    	for (CorCosturaAm finalCorCostura : corCosturaAmostra) {
	    		dao.saveCorCosturaAmostra(finalCorCostura);
	    	}
	    }

	    
	    //Gravacao Acabamentos Costura - Amostras
	    public void saveAmostraCorCostura(List<CorCosturaAm> corCosturaAmostra) {
	    	for (CorCosturaAm finalCorCostura : corCosturaAmostra) {
	    		dao.saveCorCosturaAmostra(finalCorCostura);
	    	}
	    }
	    
	    //Gravacao Acabamentos Solado Amostras
	    public void saveAmostraCorSolado(List<CorConstrucaoAm> corConstrucaoAmostra) {

	    	for (CorConstrucaoAm finalCorSolado : corConstrucaoAmostra) {
	    		dao.saveCorSoladoAmostra(finalCorSolado);
	    	}
	    	
	    }
	    
	    //Gravacao Acabamentos Acabamento Amostras
	    public void saveAmostraCorAcabamento(List<CorAcabamentoAm> corAcabamentoAmostra) {

	    	for (CorAcabamentoAm finalCorAcabamento : corAcabamentoAmostra) {
	    		dao.saveCorAcabamentoAmostra(finalCorAcabamento);
	    	}
	    	
	    }
	    //Salvar cor(es) duplicadas Amostra
	    public void saveCorAmostraDup(List<CorAmostra> listaCorAmostraDup) {
	    	
	    	for (CorAmostra corAmostra : listaCorAmostraDup) {
	    		dao.updateCorAmostra(corAmostra);
	    	}
	    }
	    //Salvar cor(res) duplicadas Corte Amostra
	    public void updateCorCorteAmostra(List<CorCorteAm> listaCorAmostraCorte) {
	    	
	    	for (CorCorteAm corCorteAmostra : listaCorAmostraCorte) {
	    		dao.updateCorAmostraCorte(corCorteAmostra);
	    	}
	    	
	    }
	    
	    //Salvar cor(res) duplicadas Corte Amostra
	    public void updateCorCosturaAmostra(List<CorCosturaAm> listaCorAmostraCostura) {
	    	
	    	for (CorCosturaAm corCosturaAmostra : listaCorAmostraCostura) {
	    		dao.updateCorAmostraCostura(corCosturaAmostra);
	    	}
	    	
	    }

	    //Salvar cor(res) duplicadas Solado Amostra
	    public void updateCorSoladoAmostra(List<CorConstrucaoAm> listaCorAmostraSolado) {
	    	
	    	for (CorConstrucaoAm corSoladoAmostra : listaCorAmostraSolado) {
	    		dao.updateCorAmostraSolado(corSoladoAmostra);
	    	}
	    	
	    }

	    //Salvar cor(res) duplicadas Acabamento Amostra
	    public void updateCorAcabamentoAmostra(List<CorAcabamentoAm> listaCorAmostraAcabamento) {
	    	
	    	for (CorAcabamentoAm corAcabamentoAmostra : listaCorAmostraAcabamento) {
	    		dao.updateCorAmostraAcabamento(corAcabamentoAmostra);
	    	}
	    	
	    }

	    //Salvar cor(res) duplicadas Cabedal(is) Amostra
	    public void updateCorCabedalAmostra(List<CorCabedalAm> listaCorAmostraCabedal) {
	    	
	    	for (CorCabedalAm corCabedalAmostra : listaCorAmostraCabedal) {
	    		dao.updateCorAmostraCabedal(corCabedalAmostra);
	    	}
	    	
	    }

	    //Salvar Parametro para desbloquear e permitir alteracao da amostra Producao
	    public void updateAlteraLiberacao(List<FichaProducao> listaFichaProducao) {
	    	
	    	for (FichaProducao fichaProducao : listaFichaProducao) {
	    		fichaProducao.setLiberadoalteraramostra(EmTransicao.T);
	    		dao.updateLiberaFichaProducao(fichaProducao);
	    	}
	    	
	    }
	    
	    
	    public List<T> findAll(){
	        return dao.findAll(getEntityClass());
	    }
	    
		public Timestamp gettimeStamp(){
			return new Timestamp(System.currentTimeMillis());
		}

		public LocalDateTime getDateLocalTime(){
			LocalDateTime localDateTime = LocalDateTime.now();
			return localDateTime;
		}

		public LocalDate getDateLocal(){
			LocalDate localDate = LocalDate.now();
			return localDate;
		}
		
		public LocalDate getLocalDate() {
			LocalDate localDate = LocalDate.now();
			return localDate;
		}
		//Logs - salvar multiplos itens
	    public void updateLogAmostraNova(List<LogAmostrasNovas> listaLogAmostraNova) {
	    	
	    	for (LogAmostrasNovas logAmostraNova : listaLogAmostraNova) {
	    		dao.updateLogAmostraNova(logAmostraNova);
	    	}
	    	
	    }
	    //Logs - Salvar multiplis itens pós alteração, durante producao
	    public void updateLogAmostraFichaProducao(List<LogAmostraFichaProducao> listaLogAmostraFichaProducao) {
	    	
	    	for (LogAmostraFichaProducao logAmostraFichaProducao : listaLogAmostraFichaProducao) {
	    		dao.updateLogAmostraFichaProducao(logAmostraFichaProducao);
	    	}
	    	
	    }

}		
