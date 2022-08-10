package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Nbm.class)
public abstract class Nbm_ {

	public static volatile SingularAttribute<Nbm, String> usuariostamp;
	public static volatile SingularAttribute<Nbm, Long> nbmid;
	public static volatile SingularAttribute<Nbm, String> nbm;
	public static volatile SingularAttribute<Nbm, Date> datastamp;
	public static volatile SingularAttribute<Nbm, String> nala;
	public static volatile SingularAttribute<Nbm, BigDecimal> percentualipi;
	public static volatile SingularAttribute<Nbm, String> descricao;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String NBMID = "nbmid";
	public static final String NBM = "nbm";
	public static final String DATASTAMP = "datastamp";
	public static final String NALA = "nala";
	public static final String PERCENTUALIPI = "percentualipi";
	public static final String DESCRICAO = "descricao";

}

