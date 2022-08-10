package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Moeda.class)
public abstract class Moeda_ {

	public static volatile SingularAttribute<Moeda, String> usuariostamp;
	public static volatile SingularAttribute<Moeda, String> sigla;
	public static volatile SingularAttribute<Moeda, Long> moedaid;
	public static volatile SingularAttribute<Moeda, Date> datastamp;
	public static volatile SingularAttribute<Moeda, Integer> codigomoeda;
	public static volatile SingularAttribute<Moeda, SimNao> moedamovimento;
	public static volatile SingularAttribute<Moeda, String> descricao;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SIGLA = "sigla";
	public static final String MOEDAID = "moedaid";
	public static final String DATASTAMP = "datastamp";
	public static final String CODIGOMOEDA = "codigomoeda";
	public static final String MOEDAMOVIMENTO = "moedamovimento";
	public static final String DESCRICAO = "descricao";

}

