package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemCatalogo.class)
public abstract class ItemCatalogo_ {

	public static volatile SingularAttribute<ItemCatalogo, Long> catalogoid;
	public static volatile SingularAttribute<ItemCatalogo, BigDecimal> precofob;
	public static volatile SingularAttribute<ItemCatalogo, String> usuariostamp;
	public static volatile SingularAttribute<ItemCatalogo, Date> delivery;
	public static volatile SingularAttribute<ItemCatalogo, String> observacao;
	public static volatile SingularAttribute<ItemCatalogo, Integer> ordemreferencia;
	public static volatile SingularAttribute<ItemCatalogo, Integer> ordemimpressao;
	public static volatile SingularAttribute<ItemCatalogo, String> outromaterial;
	public static volatile SingularAttribute<ItemCatalogo, Date> datastamp;
	public static volatile SingularAttribute<ItemCatalogo, CorAmostra> coramostra;
	public static volatile SingularAttribute<ItemCatalogo, String> outromodelo;
	public static volatile SingularAttribute<ItemCatalogo, BigDecimal> preco;
	public static volatile SingularAttribute<ItemCatalogo, LivroReferencia> livrosreferenciasoutros;
	public static volatile SingularAttribute<ItemCatalogo, BigDecimal> precodesconto;
	public static volatile SingularAttribute<ItemCatalogo, String> outrocor;
	public static volatile SingularAttribute<ItemCatalogo, String> outromarca;
	public static volatile SingularAttribute<ItemCatalogo, Integer> pares;
	public static volatile SingularAttribute<ItemCatalogo, Long> itemcatalogoid;
	public static volatile SingularAttribute<ItemCatalogo, String> observacao1;
	public static volatile SingularAttribute<ItemCatalogo, Catalogo> catalogo;
	public static volatile SingularAttribute<ItemCatalogo, String> observacao2;
	public static volatile SingularAttribute<ItemCatalogo, BigDecimal> precovendaproduto;

	public static final String CATALOGOID = "catalogoid";
	public static final String PRECOFOB = "precofob";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String DELIVERY = "delivery";
	public static final String OBSERVACAO = "observacao";
	public static final String ORDEMREFERENCIA = "ordemreferencia";
	public static final String ORDEMIMPRESSAO = "ordemimpressao";
	public static final String OUTROMATERIAL = "outromaterial";
	public static final String DATASTAMP = "datastamp";
	public static final String CORAMOSTRA = "coramostra";
	public static final String OUTROMODELO = "outromodelo";
	public static final String PRECO = "preco";
	public static final String LIVROSREFERENCIASOUTROS = "livrosreferenciasoutros";
	public static final String PRECODESCONTO = "precodesconto";
	public static final String OUTROCOR = "outrocor";
	public static final String OUTROMARCA = "outromarca";
	public static final String PARES = "pares";
	public static final String ITEMCATALOGOID = "itemcatalogoid";
	public static final String OBSERVACAO1 = "observacao1";
	public static final String CATALOGO = "catalogo";
	public static final String OBSERVACAO2 = "observacao2";
	public static final String PRECOVENDAPRODUTO = "precovendaproduto";

}

