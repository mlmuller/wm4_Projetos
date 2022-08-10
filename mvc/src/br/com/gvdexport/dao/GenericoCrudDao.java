package br.com.gvdexport.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.gvdexport.core.Transactional;

@Named
@Dependent
public class GenericoCrudDao<PK,T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	//
	//
	@SuppressWarnings("unchecked")
	public T getById(PK pk) {
        return (T) em.find(getTypeClass(), pk);
    }
    @Transactional
    public void save(T entity) {
        em.merge(entity);
    }
    @Transactional
    public void insert(T entity) {
    	em.persist(entity);
    }
    @Transactional
    public void update(T entity) {
        em.merge(entity);
    }
    @Transactional
    public void delete(T entity) {
        em.remove(entity);
    }
 
//    @SuppressWarnings("unchecked")
//	public List<T> findAll() {
//    	return em.createQuery(("FROM " + getTypeClass().getSimpleName())).getResultList();
//    }
//    
   
	public Timestamp gettimeStamp(){
		return new Timestamp(System.currentTimeMillis());
	}
 	private Class<?> getTypeClass() {
 		try {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
        		.getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
 		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
    }
}
