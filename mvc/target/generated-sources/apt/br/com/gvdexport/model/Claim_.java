package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Claim.class)
public abstract class Claim_ {

	public static volatile SingularAttribute<Claim, Fabrica> fabrica;
	public static volatile SingularAttribute<Claim, String> usuariostamp;
	public static volatile SingularAttribute<Claim, Cliente> cliente;
	public static volatile SingularAttribute<Claim, Integer> pares;
	public static volatile SingularAttribute<Claim, BigDecimal> valor;
	public static volatile SingularAttribute<Claim, Date> datastamp;
	public static volatile SingularAttribute<Claim, Pedido> pedido;
	public static volatile SingularAttribute<Claim, Long> claimid;
	public static volatile SingularAttribute<Claim, String> descricao;

	public static final String FABRICA = "fabrica";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String CLIENTE = "cliente";
	public static final String PARES = "pares";
	public static final String VALOR = "valor";
	public static final String DATASTAMP = "datastamp";
	public static final String PEDIDO = "pedido";
	public static final String CLAIMID = "claimid";
	public static final String DESCRICAO = "descricao";

}

