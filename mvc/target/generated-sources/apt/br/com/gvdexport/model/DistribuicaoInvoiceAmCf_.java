package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DistribuicaoInvoiceAmCf.class)
public abstract class DistribuicaoInvoiceAmCf_ {

	public static volatile SingularAttribute<DistribuicaoInvoiceAmCf, Long> destinoamcfid;
	public static volatile SingularAttribute<DistribuicaoInvoiceAmCf, String> usuariostamp;
	public static volatile SingularAttribute<DistribuicaoInvoiceAmCf, Long> invoiceamcfid;
	public static volatile SingularAttribute<DistribuicaoInvoiceAmCf, DestinoAmCf> destinoamcf;
	public static volatile SingularAttribute<DistribuicaoInvoiceAmCf, String> numeracaocaixas;
	public static volatile SingularAttribute<DistribuicaoInvoiceAmCf, Date> datastamp;
	public static volatile SingularAttribute<DistribuicaoInvoiceAmCf, InvoiceAmCf> invoiceamcf;

	public static final String DESTINOAMCFID = "destinoamcfid";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String INVOICEAMCFID = "invoiceamcfid";
	public static final String DESTINOAMCF = "destinoamcf";
	public static final String NUMERACAOCAIXAS = "numeracaocaixas";
	public static final String DATASTAMP = "datastamp";
	public static final String INVOICEAMCF = "invoiceamcf";

}

