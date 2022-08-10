package br.com.gvdexport.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionPoint;

import br.com.gvdexport.core.Dao;

public class DaoProducer<T>  {

	@SuppressWarnings("hiding")
	@Produces
	@Dependent
	@Dao
    public <T,ID> CrudDao<T, ID> produce(InjectionPoint ip, BeanManager bm) {
        if (ip.getAnnotated().isAnnotationPresent(Dao.class)) {
            @SuppressWarnings("unchecked")
			CrudDao<T, ID> crudDao = (CrudDao<T, ID>)  this.getBeanByName("crudDao", bm);
            ParameterizedType type = (ParameterizedType) ip.getType();
            Type[] typeArgs = type.getActualTypeArguments();
            @SuppressWarnings("unchecked")
			Class<T> entityClass = (Class<T>) typeArgs[0];
            crudDao.setEntityClass(entityClass);
            return crudDao;
        }
        throw new IllegalArgumentException("Annotation @Dao is required when injecting BaseDao");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Object getBeanByName(String name, BeanManager bm) { // eg. name=availableCountryDao{
        Bean bean = bm.getBeans(name).iterator().next();
		CreationalContext ctx = bm.createCreationalContext(bean); // could be inlined below
        Object o = bm.getReference(bean, bean.getBeanClass(), ctx); // could be inlined with return
        return o;
    }
    
      @SuppressWarnings("rawtypes")
	public static Object getBeanByType(Type t, BeanManager bm){ // eg. name=availableCountryDao
        Bean bean = bm.getBeans(t).iterator().next();
        @SuppressWarnings("unchecked")
		CreationalContext ctx = bm.createCreationalContext(bean); // could be inlined below
        Object o = bm.getReference(bean, bean.getBeanClass(), ctx); // could be inlined with return
        return o;
    }
}
