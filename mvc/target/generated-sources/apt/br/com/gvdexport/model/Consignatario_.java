package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Consignatario.class)
public abstract class Consignatario_ {

	public static volatile SingularAttribute<Consignatario, String> usuariostamp;
	public static volatile SingularAttribute<Consignatario, Situacao> situacao;
	public static volatile SingularAttribute<Consignatario, String> endereco;
	public static volatile SingularAttribute<Consignatario, Long> consignatarioid;
	public static volatile SingularAttribute<Consignatario, Date> datastamp;
	public static volatile SingularAttribute<Consignatario, String> nome;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String ENDERECO = "endereco";
	public static final String CONSIGNATARIOID = "consignatarioid";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";

}

