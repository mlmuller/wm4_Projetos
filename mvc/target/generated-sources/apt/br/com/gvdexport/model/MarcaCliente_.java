package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MarcaCliente.class)
public abstract class MarcaCliente_ {

	public static volatile SingularAttribute<MarcaCliente, String> usuariostamp;
	public static volatile SingularAttribute<MarcaCliente, Cliente> cliente;
	public static volatile SingularAttribute<MarcaCliente, Date> datastamp;
	public static volatile SingularAttribute<MarcaCliente, String> sucinto;
	public static volatile SingularAttribute<MarcaCliente, String> nome;
	public static volatile SingularAttribute<MarcaCliente, Long> marcaclienteid;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String CLIENTE = "cliente";
	public static final String DATASTAMP = "datastamp";
	public static final String SUCINTO = "sucinto";
	public static final String NOME = "nome";
	public static final String MARCACLIENTEID = "marcaclienteid";

}

