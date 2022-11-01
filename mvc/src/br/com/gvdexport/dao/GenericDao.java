package br.com.gvdexport.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.gvdexport.core.Transactional;
import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.CorAcabamentoAm;
import br.com.gvdexport.model.CorAmostra;
import br.com.gvdexport.model.CorAmostraMulti;
import br.com.gvdexport.model.CorCabedalAm;
import br.com.gvdexport.model.CorConstrucaoAm;
import br.com.gvdexport.model.CorCorteAm;
import br.com.gvdexport.model.CorCosturaAm;
import br.com.gvdexport.model.EnderecoCliente;
import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.model.LogAmostraFichaProducao;
import br.com.gvdexport.model.LogAmostrasNovas;

@Dependent
@Named("baseDao")
public class GenericDao<T,ID> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;

	@SuppressWarnings("rawtypes")
	private Class entityClass;
	
	@SuppressWarnings("rawtypes")
	public Class getEntityClass() {
		if(entityClass == null) {
			entityClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return entityClass;
	}

	@SuppressWarnings("rawtypes")
	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}
	
	   //utility database methods
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public T find(ID id, Class<T> type) {
        return (T) this.em.find(type, id);
    }
    @Transactional
    public void delete(ID id, Class<T> type) {
        Object ref = this.em.getReference(type, id);
        this.em.remove(ref);
    }
    @Transactional
    public void deleteEC(EnderecoCliente endcli) {
        this.em.remove(endcli);	
    }
    @Transactional
    public void deleteCorMulti(CorAmostraMulti MultiId) {
    	this.em.remove(MultiId);
    }
    @Transactional
    public void deleteCabedalMulti(CorCabedalAm cabMultiId) {
    	this.em.remove(cabMultiId);
    }

    @Transactional
    public T update(T t) {
        return (T) this.em.merge(t);
    }
    @Transactional
    public void insert(T t) {
        this.em.persist(t);
	
    }
    
    @Transactional
    public CorAmostra updateCorAmostra(CorAmostra corAmostra) {
 	   return (CorAmostra) this.em.merge(corAmostra);
    }
    
    @Transactional
    public CorCorteAm updateCorAmostraCorte(CorCorteAm corCorteAmostra) {
 	   return (CorCorteAm) this.em.merge(corCorteAmostra);
    }

    @Transactional
    public CorCosturaAm updateCorAmostraCostura(CorCosturaAm corCosturaAmostra) {
 	   return (CorCosturaAm) this.em.merge(corCosturaAmostra);
    }

    @Transactional
    public CorConstrucaoAm updateCorAmostraSolado(CorConstrucaoAm corConstrucaoAmostra) {
 	   return (CorConstrucaoAm) this.em.merge(corConstrucaoAmostra);
    }
 
    @Transactional
    public CorAcabamentoAm updateCorAmostraAcabamento(CorAcabamentoAm corAcabamentoAmostra) {
 	   return (CorAcabamentoAm) this.em.merge(corAcabamentoAmostra);
    }
    
    @Transactional
    public CorCabedalAm updateCorAmostraCabedal(CorCabedalAm corCabedalAmostra) {
 	   return (CorCabedalAm) this.em.merge(corCabedalAmostra);
    }
 
    
    @Transactional
    public CorAmostraMulti updateCorMulti(CorAmostraMulti corMulti) {
		return (CorAmostraMulti) this.em.merge(corMulti);
    }
    
    @Transactional
    public FichaProducao updateLiberaFichaProducao(FichaProducao fichaProducao) {
		return (FichaProducao) this.em.merge(fichaProducao);
    }

    @Transactional
    public Amostra updateLiberaAmostra(Amostra fichaAmostra) {
		return (Amostra) this.em.merge(fichaAmostra);
    }

    //Bloco gravacao Logs
    @Transactional
    public LogAmostrasNovas updateLogAmostraNova(LogAmostrasNovas logAmostraNova) {
		return (LogAmostrasNovas)  this.em.merge(logAmostraNova);
    }
    @Transactional
    public LogAmostraFichaProducao updateLogAmostraFichaProducao(LogAmostraFichaProducao logAmostraFichaProducao) {
		return (LogAmostraFichaProducao)  this.em.merge(logAmostraFichaProducao);
    }

    //
    
	// Etapas Producao Amostras Novas
	//Corte
	//Costura
	//Solado
	//Acabamento
    
    @Transactional
    public CorCorteAm saveCorCorteAmostra(CorCorteAm corCorteFinal) {
		return this.em.merge(corCorteFinal);
    }

	@Transactional
	public CorCosturaAm saveCorCosturaAmostra(CorCosturaAm corCosturaFinal) {
		return this.em.merge(corCosturaFinal);
	}

	@Transactional
	public CorConstrucaoAm saveCorSoladoAmostra(CorConstrucaoAm corSoladoFinal) {
		return this.em.merge(corSoladoFinal);
	}
	@Transactional
	public CorAcabamentoAm saveCorAcabamentoAmostra(CorAcabamentoAm corAcabamentoAmFinal) {
		return this.em.merge(corAcabamentoAmFinal);
	}
    
	
	public Timestamp gettimeStamp(){
		return new Timestamp(System.currentTimeMillis());
	}
	
	
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<T> findAll(Class<T> type) {
        return em.createQuery("Select entityClass FROM "+type.getSimpleName() +" entityClass").getResultList();
    } 

}
