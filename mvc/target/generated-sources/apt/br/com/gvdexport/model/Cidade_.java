package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cidade.class)
public abstract class Cidade_ {

	public static volatile SingularAttribute<Cidade, String> usuariostamp;
	public static volatile SingularAttribute<Cidade, Long> cidadeid;
	public static volatile SingularAttribute<Cidade, Estado> estado;
	public static volatile SingularAttribute<Cidade, String> codigoibge;
	public static volatile SingularAttribute<Cidade, Date> datastamp;
	public static volatile SingularAttribute<Cidade, String> nome;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String CIDADEID = "cidadeid";
	public static final String ESTADO = "estado";
	public static final String CODIGOIBGE = "codigoibge";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";

}

