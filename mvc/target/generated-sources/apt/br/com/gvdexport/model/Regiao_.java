package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Regiao.class)
public abstract class Regiao_ {

	public static volatile SingularAttribute<Regiao, String> usuariostamp;
	public static volatile SingularAttribute<Regiao, Date> datastamp;
	public static volatile SingularAttribute<Regiao, String> nome;
	public static volatile SingularAttribute<Regiao, Long> regiaoid;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String REGIAOID = "regiaoid";

}

