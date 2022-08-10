package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Hts.class)
public abstract class Hts_ {

	public static volatile SingularAttribute<Hts, String> usuariostamp;
	public static volatile SingularAttribute<Hts, Long> htsid;
	public static volatile SingularAttribute<Hts, String> hts;
	public static volatile SingularAttribute<Hts, Date> datastamp;
	public static volatile SingularAttribute<Hts, BigDecimal> duty;
	public static volatile SingularAttribute<Hts, String> descricao;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String HTSID = "htsid";
	public static final String HTS = "hts";
	public static final String DATASTAMP = "datastamp";
	public static final String DUTY = "duty";
	public static final String DESCRICAO = "descricao";

}

