package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FaturaFretePago.class)
public abstract class FaturaFretePago_ {

	public static volatile SingularAttribute<FaturaFretePago, BigDecimal> valortotalcontainer;
	public static volatile SingularAttribute<FaturaFretePago, String> usuariostamp;
	public static volatile SingularAttribute<FaturaFretePago, PagamentoDiferencaFrete> pagamentodiferencafrete;
	public static volatile SingularAttribute<FaturaFretePago, BigDecimal> pesobrutototalcontainer;
	public static volatile SingularAttribute<FaturaFretePago, BigDecimal> taxaemissaohawb;
	public static volatile SingularAttribute<FaturaFretePago, Long> numerofaturatradingid;
	public static volatile SingularAttribute<FaturaFretePago, Date> datastamp;
	public static volatile SingularAttribute<FaturaFretePago, String> anofaturatrading;
	public static volatile SingularAttribute<FaturaFretePago, TipoContainer> tipocontainer;

	public static final String VALORTOTALCONTAINER = "valortotalcontainer";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String PAGAMENTODIFERENCAFRETE = "pagamentodiferencafrete";
	public static final String PESOBRUTOTOTALCONTAINER = "pesobrutototalcontainer";
	public static final String TAXAEMISSAOHAWB = "taxaemissaohawb";
	public static final String NUMEROFATURATRADINGID = "numerofaturatradingid";
	public static final String DATASTAMP = "datastamp";
	public static final String ANOFATURATRADING = "anofaturatrading";
	public static final String TIPOCONTAINER = "tipocontainer";

}

