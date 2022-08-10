package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemClaim.class)
public abstract class ItemClaim_ {

	public static volatile SingularAttribute<ItemClaim, String> usuariostamp;
	public static volatile SingularAttribute<ItemClaim, Long> sequenciaitemclaim;
	public static volatile SingularAttribute<ItemClaim, Long> itemclaimid;
	public static volatile SingularAttribute<ItemClaim, BigDecimal> descontopar;
	public static volatile SingularAttribute<ItemClaim, Date> datastamp;
	public static volatile SingularAttribute<ItemClaim, Pedido> pedido;
	public static volatile SingularAttribute<ItemClaim, Claim> claim;
	public static volatile SingularAttribute<ItemClaim, String> descricao;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SEQUENCIAITEMCLAIM = "sequenciaitemclaim";
	public static final String ITEMCLAIMID = "itemclaimid";
	public static final String DESCONTOPAR = "descontopar";
	public static final String DATASTAMP = "datastamp";
	public static final String PEDIDO = "pedido";
	public static final String CLAIM = "claim";
	public static final String DESCRICAO = "descricao";

}

