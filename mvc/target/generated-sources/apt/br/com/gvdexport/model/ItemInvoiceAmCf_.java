package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemInvoiceAmCf.class)
public abstract class ItemInvoiceAmCf_ {

	public static volatile SingularAttribute<ItemInvoiceAmCf, String> usuariostamp;
	public static volatile SingularAttribute<ItemInvoiceAmCf, TipoCalcado> tipocalcado;
	public static volatile SingularAttribute<ItemInvoiceAmCf, String> sizeiteminvoice;
	public static volatile SingularAttribute<ItemInvoiceAmCf, TipoSalto> tiposalto;
	public static volatile SingularAttribute<ItemInvoiceAmCf, Date> datastamp;
	public static volatile SingularAttribute<ItemInvoiceAmCf, CorAmostra> coramostra;
	public static volatile SingularAttribute<ItemInvoiceAmCf, String> comentario;
	public static volatile SingularAttribute<ItemInvoiceAmCf, TipoSolado> tiposolado;
	public static volatile SingularAttribute<ItemInvoiceAmCf, Long> iteminvoiceamcfid;
	public static volatile SingularAttribute<ItemInvoiceAmCf, CorMaquete> cormaquete;
	public static volatile SingularAttribute<ItemInvoiceAmCf, TipoItemInvoice> tipoiteminvoice;
	public static volatile SingularAttribute<ItemInvoiceAmCf, Cliente> cliente;
	public static volatile SingularAttribute<ItemInvoiceAmCf, Long> invoiceamcfid;
	public static volatile SingularAttribute<ItemInvoiceAmCf, DestinoAmCf> destinoamcf;
	public static volatile SingularAttribute<ItemInvoiceAmCf, TipoMaterial> tipomaterial;
	public static volatile SingularAttribute<ItemInvoiceAmCf, BigDecimal> pares;
	public static volatile SingularAttribute<ItemInvoiceAmCf, CorConfirmacao> corconfirmacao;
	public static volatile SingularAttribute<ItemInvoiceAmCf, BigDecimal> precounitario;
	public static volatile SingularAttribute<ItemInvoiceAmCf, String> outroscor;
	public static volatile SingularAttribute<ItemInvoiceAmCf, String> outrosstyles;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String TIPOCALCADO = "tipocalcado";
	public static final String SIZEITEMINVOICE = "sizeiteminvoice";
	public static final String TIPOSALTO = "tiposalto";
	public static final String DATASTAMP = "datastamp";
	public static final String CORAMOSTRA = "coramostra";
	public static final String COMENTARIO = "comentario";
	public static final String TIPOSOLADO = "tiposolado";
	public static final String ITEMINVOICEAMCFID = "iteminvoiceamcfid";
	public static final String CORMAQUETE = "cormaquete";
	public static final String TIPOITEMINVOICE = "tipoiteminvoice";
	public static final String CLIENTE = "cliente";
	public static final String INVOICEAMCFID = "invoiceamcfid";
	public static final String DESTINOAMCF = "destinoamcf";
	public static final String TIPOMATERIAL = "tipomaterial";
	public static final String PARES = "pares";
	public static final String CORCONFIRMACAO = "corconfirmacao";
	public static final String PRECOUNITARIO = "precounitario";
	public static final String OUTROSCOR = "outroscor";
	public static final String OUTROSSTYLES = "outrosstyles";

}

