package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GrupoClienteInvoice.class)
public abstract class GrupoClienteInvoice_ {

	public static volatile SingularAttribute<GrupoClienteInvoice, String> usuariostamp;
	public static volatile SingularAttribute<GrupoClienteInvoice, Situacao> situacao;
	public static volatile SingularAttribute<GrupoClienteInvoice, SimNao> precofabrica;
	public static volatile SingularAttribute<GrupoClienteInvoice, Integer> sequenciaid;
	public static volatile SingularAttribute<GrupoClienteInvoice, Date> datastamp;
	public static volatile SingularAttribute<GrupoClienteInvoice, String> sucinto;
	public static volatile SingularAttribute<GrupoClienteInvoice, String> nome;
	public static volatile SingularAttribute<GrupoClienteInvoice, Long> grupoclienteinvoiceid;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String PRECOFABRICA = "precofabrica";
	public static final String SEQUENCIAID = "sequenciaid";
	public static final String DATASTAMP = "datastamp";
	public static final String SUCINTO = "sucinto";
	public static final String NOME = "nome";
	public static final String GRUPOCLIENTEINVOICEID = "grupoclienteinvoiceid";

}

