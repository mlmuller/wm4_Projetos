package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClienteProjecao.class)
public abstract class ClienteProjecao_ {

	public static volatile SingularAttribute<ClienteProjecao, String> usuariostamp;
	public static volatile SingularAttribute<ClienteProjecao, Long> clienteprojecaoid;
	public static volatile SingularAttribute<ClienteProjecao, Integer> prioridade;
	public static volatile SingularAttribute<ClienteProjecao, Date> datastamp;
	public static volatile SingularAttribute<ClienteProjecao, String> nome;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String CLIENTEPROJECAOID = "clienteprojecaoid";
	public static final String PRIORIDADE = "prioridade";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";

}

