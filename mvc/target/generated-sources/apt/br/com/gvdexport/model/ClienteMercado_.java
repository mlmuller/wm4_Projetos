package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClienteMercado.class)
public abstract class ClienteMercado_ {

	public static volatile SingularAttribute<ClienteMercado, String> usuariostamp;
	public static volatile SingularAttribute<ClienteMercado, Cliente> cliente;
	public static volatile SingularAttribute<ClienteMercado, Mercado> mercado;
	public static volatile SingularAttribute<ClienteMercado, Date> datastamp;
	public static volatile SingularAttribute<ClienteMercado, Long> clientemercadoid;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String CLIENTE = "cliente";
	public static final String MERCADO = "mercado";
	public static final String DATASTAMP = "datastamp";
	public static final String CLIENTEMERCADOID = "clientemercadoid";

}

