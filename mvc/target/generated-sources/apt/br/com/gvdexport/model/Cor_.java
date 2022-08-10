package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cor.class)
public abstract class Cor_ {

	public static volatile SingularAttribute<Cor, String> resumido;
	public static volatile SingularAttribute<Cor, String> usuariostamp;
	public static volatile SingularAttribute<Cor, Situacao> situacao;
	public static volatile SingularAttribute<Cor, Long> corid;
	public static volatile SingularAttribute<Cor, Date> datastamp;
	public static volatile SingularAttribute<Cor, String> nome;
	public static volatile SingularAttribute<Cor, String> nomeingles;
	public static volatile SingularAttribute<Cor, String> nomeespanhol;

	public static final String RESUMIDO = "resumido";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String CORID = "corid";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String NOMEINGLES = "nomeingles";
	public static final String NOMEESPANHOL = "nomeespanhol";

}

