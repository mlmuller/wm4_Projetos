package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Revisor.class)
public abstract class Revisor_ {

	public static volatile SingularAttribute<Revisor, String> usuariostamp;
	public static volatile SingularAttribute<Revisor, Situacao> situacao;
	public static volatile SingularAttribute<Revisor, Date> datastamp;
	public static volatile SingularAttribute<Revisor, String> nome;
	public static volatile SingularAttribute<Revisor, Long> revisorid;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String REVISORID = "revisorid";

}

