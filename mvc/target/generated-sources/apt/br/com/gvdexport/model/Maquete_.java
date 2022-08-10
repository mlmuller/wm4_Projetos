package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Maquete.class)
public abstract class Maquete_ {

	public static volatile SingularAttribute<Maquete, BigDecimal> par;
	public static volatile SingularAttribute<Maquete, Fabrica> fabrica;
	public static volatile SingularAttribute<Maquete, String> obs;
	public static volatile SingularAttribute<Maquete, String> usuariostamp;
	public static volatile SingularAttribute<Maquete, LivroReferencia> livrosreferencia;
	public static volatile SingularAttribute<Maquete, Date> datastamp;
	public static volatile SingularAttribute<Maquete, PrioridadeProducao> prioridadeproducao;
	public static volatile SingularAttribute<Maquete, String> obssolado;
	public static volatile SingularAttribute<Maquete, BigDecimal> parcancelado;
	public static volatile SingularAttribute<Maquete, Date> dtentrega;
	public static volatile SingularAttribute<Maquete, String> complementosolado;
	public static volatile SingularAttribute<Maquete, Date> dtliberacaoproducao;
	public static volatile SingularAttribute<Maquete, Date> dtxfct;
	public static volatile SingularAttribute<Maquete, Cliente> cliente;
	public static volatile SingularAttribute<Maquete, String> referenciamaquete;
	public static volatile SingularAttribute<Maquete, DestinoAmCf> destinoamcf;
	public static volatile SingularAttribute<Maquete, Mercado> mercado;
	public static volatile SingularAttribute<Maquete, Date> dtsolicitacao;
	public static volatile SingularAttribute<Maquete, Long> maqueteid;
	public static volatile SingularAttribute<Maquete, Componente> componente;

	public static final String PAR = "par";
	public static final String FABRICA = "fabrica";
	public static final String OBS = "obs";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String LIVROSREFERENCIA = "livrosreferencia";
	public static final String DATASTAMP = "datastamp";
	public static final String PRIORIDADEPRODUCAO = "prioridadeproducao";
	public static final String OBSSOLADO = "obssolado";
	public static final String PARCANCELADO = "parcancelado";
	public static final String DTENTREGA = "dtentrega";
	public static final String COMPLEMENTOSOLADO = "complementosolado";
	public static final String DTLIBERACAOPRODUCAO = "dtliberacaoproducao";
	public static final String DTXFCT = "dtxfct";
	public static final String CLIENTE = "cliente";
	public static final String REFERENCIAMAQUETE = "referenciamaquete";
	public static final String DESTINOAMCF = "destinoamcf";
	public static final String MERCADO = "mercado";
	public static final String DTSOLICITACAO = "dtsolicitacao";
	public static final String MAQUETEID = "maqueteid";
	public static final String COMPONENTE = "componente";

}

