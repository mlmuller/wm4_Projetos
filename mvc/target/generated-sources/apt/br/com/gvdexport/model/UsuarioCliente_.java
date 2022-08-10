package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsuarioCliente.class)
public abstract class UsuarioCliente_ {

	public static volatile SingularAttribute<UsuarioCliente, String> usuariostamp;
	public static volatile SingularAttribute<UsuarioCliente, Cliente> cliente;
	public static volatile SingularAttribute<UsuarioCliente, Situacao> situacao;
	public static volatile SingularAttribute<UsuarioCliente, Long> usuarioclienteid;
	public static volatile SingularAttribute<UsuarioCliente, Date> datastamp;
	public static volatile SingularAttribute<UsuarioCliente, Usuario> usuario;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String CLIENTE = "cliente";
	public static final String SITUACAO = "situacao";
	public static final String USUARIOCLIENTEID = "usuarioclienteid";
	public static final String DATASTAMP = "datastamp";
	public static final String USUARIO = "usuario";

}

