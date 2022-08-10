package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DestinoAmCf.class)
public abstract class DestinoAmCf_ {

	public static volatile SingularAttribute<DestinoAmCf, Long> destinoamcfid;
	public static volatile SingularAttribute<DestinoAmCf, String> usuariostamp;
	public static volatile SingularAttribute<DestinoAmCf, Situacao> situacao;
	public static volatile SingularAttribute<DestinoAmCf, GrupoClienteInvoice> gruposclientesinvoices;
	public static volatile SingularAttribute<DestinoAmCf, Date> datastamp;
	public static volatile SingularAttribute<DestinoAmCf, String> destino;

	public static final String DESTINOAMCFID = "destinoamcfid";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String GRUPOSCLIENTESINVOICES = "gruposclientesinvoices";
	public static final String DATASTAMP = "datastamp";
	public static final String DESTINO = "destino";

}

