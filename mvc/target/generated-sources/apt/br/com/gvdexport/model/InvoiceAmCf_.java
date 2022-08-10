package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InvoiceAmCf.class)
public abstract class InvoiceAmCf_ {

	public static volatile SingularAttribute<InvoiceAmCf, String> usuariostamp;
	public static volatile SingularAttribute<InvoiceAmCf, EnderecoCliente> sequenciaendereco;
	public static volatile SingularAttribute<InvoiceAmCf, Situacao> situacao;
	public static volatile SingularAttribute<InvoiceAmCf, GrupoClienteInvoice> grupoclienteinvoice;
	public static volatile SingularAttribute<InvoiceAmCf, Date> datastamp;
	public static volatile SingularAttribute<InvoiceAmCf, String> descricaopares;
	public static volatile SingularAttribute<InvoiceAmCf, BigDecimal> precototal;
	public static volatile SingularAttribute<InvoiceAmCf, BigDecimal> preco;
	public static volatile SingularAttribute<InvoiceAmCf, Long> invoiceamcfid;
	public static volatile SingularAttribute<InvoiceAmCf, String> complementonotify;
	public static volatile SingularAttribute<InvoiceAmCf, Mercado> mercado;
	public static volatile SingularAttribute<InvoiceAmCf, Date> datainvoice;
	public static volatile SingularAttribute<InvoiceAmCf, Integer> numeroinvoice;
	public static volatile SingularAttribute<InvoiceAmCf, String> descricaocaixas;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SEQUENCIAENDERECO = "sequenciaendereco";
	public static final String SITUACAO = "situacao";
	public static final String GRUPOCLIENTEINVOICE = "grupoclienteinvoice";
	public static final String DATASTAMP = "datastamp";
	public static final String DESCRICAOPARES = "descricaopares";
	public static final String PRECOTOTAL = "precototal";
	public static final String PRECO = "preco";
	public static final String INVOICEAMCFID = "invoiceamcfid";
	public static final String COMPLEMENTONOTIFY = "complementonotify";
	public static final String MERCADO = "mercado";
	public static final String DATAINVOICE = "datainvoice";
	public static final String NUMEROINVOICE = "numeroinvoice";
	public static final String DESCRICAOCAIXAS = "descricaocaixas";

}

