package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DGASistema.class)
public abstract class DGASistema_ {

	public static volatile SingularAttribute<DGASistema, String> usuariostamp;
	public static volatile SingularAttribute<DGASistema, Integer> ordem;
	public static volatile SingularAttribute<DGASistema, Date> datastamp;
	public static volatile SingularAttribute<DGASistema, Long> dgasistemaid;
	public static volatile SingularAttribute<DGASistema, String> nome;
	public static volatile SingularAttribute<DGASistema, String> iconesistema;
	public static volatile SingularAttribute<DGASistema, String> stylesistema;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String ORDEM = "ordem";
	public static final String DATASTAMP = "datastamp";
	public static final String DGASISTEMAID = "dgasistemaid";
	public static final String NOME = "nome";
	public static final String ICONESISTEMA = "iconesistema";
	public static final String STYLESISTEMA = "stylesistema";

}

