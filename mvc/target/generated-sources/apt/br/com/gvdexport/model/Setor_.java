package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Setor.class)
public abstract class Setor_ {

	public static volatile SingularAttribute<Setor, String> usuariostamp;
	public static volatile SingularAttribute<Setor, Situacao> situacao;
	public static volatile SingularAttribute<Setor, Date> datastamp;
	public static volatile SingularAttribute<Setor, String> nome;
	public static volatile SingularAttribute<Setor, Long> setorid;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String SETORID = "setorid";

}

