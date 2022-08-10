package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Navio.class)
public abstract class Navio_ {

	public static volatile SingularAttribute<Navio, String> usuariostamp;
	public static volatile SingularAttribute<Navio, Situacao> situacao;
	public static volatile SingularAttribute<Navio, Long> navioid;
	public static volatile SingularAttribute<Navio, Date> datastamp;
	public static volatile SingularAttribute<Navio, String> nome;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String NAVIOID = "navioid";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";

}

