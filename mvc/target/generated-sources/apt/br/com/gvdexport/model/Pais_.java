package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pais.class)
public abstract class Pais_ {

	public static volatile SingularAttribute<Pais, Continentes> continente;
	public static volatile SingularAttribute<Pais, Long> paisid;
	public static volatile SingularAttribute<Pais, String> nomecontinente;
	public static volatile SingularAttribute<Pais, String> usuariostamp;
	public static volatile SingularAttribute<Pais, String> sigla;
	public static volatile SingularAttribute<Pais, String> grupopais;
	public static volatile SingularAttribute<Pais, Date> datastamp;
	public static volatile SingularAttribute<Pais, String> nome;
	public static volatile SingularAttribute<Pais, String> nomeingles;
	public static volatile SingularAttribute<Pais, Integer> codigopais;

	public static final String CONTINENTE = "continente";
	public static final String PAISID = "paisid";
	public static final String NOMECONTINENTE = "nomecontinente";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SIGLA = "sigla";
	public static final String GRUPOPAIS = "grupopais";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String NOMEINGLES = "nomeingles";
	public static final String CODIGOPAIS = "codigopais";

}

