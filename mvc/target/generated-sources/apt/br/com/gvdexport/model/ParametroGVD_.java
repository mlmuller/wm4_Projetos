package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ParametroGVD.class)
public abstract class ParametroGVD_ {

	public static volatile SingularAttribute<ParametroGVD, String> usuariostamp;
	public static volatile SingularAttribute<ParametroGVD, Long> parametrogvdid;
	public static volatile SingularAttribute<ParametroGVD, String> parametro;
	public static volatile SingularAttribute<ParametroGVD, String> valor;
	public static volatile SingularAttribute<ParametroGVD, Date> datastamp;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String PARAMETROGVDID = "parametrogvdid";
	public static final String PARAMETRO = "parametro";
	public static final String VALOR = "valor";
	public static final String DATASTAMP = "datastamp";

}

