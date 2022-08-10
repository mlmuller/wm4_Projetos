package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsuarioMercado.class)
public abstract class UsuarioMercado_ {

	public static volatile SingularAttribute<UsuarioMercado, String> usuariostamp;
	public static volatile SingularAttribute<UsuarioMercado, Long> usuariomercadoid;
	public static volatile SingularAttribute<UsuarioMercado, Mercado> mercado;
	public static volatile SingularAttribute<UsuarioMercado, Date> datastamp;
	public static volatile SingularAttribute<UsuarioMercado, Usuario> usuario;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String USUARIOMERCADOID = "usuariomercadoid";
	public static final String MERCADO = "mercado";
	public static final String DATASTAMP = "datastamp";
	public static final String USUARIO = "usuario";

}

