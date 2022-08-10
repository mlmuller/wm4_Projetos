package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReprogramacaoOrder.class)
public abstract class ReprogramacaoOrder_ {

	public static volatile SingularAttribute<ReprogramacaoOrder, String> usuariostamp;
	public static volatile SingularAttribute<ReprogramacaoOrder, String> obs;
	public static volatile SingularAttribute<ReprogramacaoOrder, TipoFrete> tipofrete;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> stitchreal;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> dtestimatedxfct;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> lastingscheduled;
	public static volatile SingularAttribute<ReprogramacaoOrder, String> obscliente;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> datastamp;
	public static volatile SingularAttribute<ReprogramacaoOrder, Long> reprogramacaoorderid;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> materialscheduled;
	public static volatile SingularAttribute<ReprogramacaoOrder, Indicador> indicador;
	public static volatile SingularAttribute<ReprogramacaoOrder, Integer> totalpares;
	public static volatile SingularAttribute<ReprogramacaoOrder, BigDecimal> preco;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> stitchschedule;
	public static volatile SingularAttribute<ReprogramacaoOrder, Cliente> cliente;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> lastingreal;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> dtreprogramacao;
	public static volatile SingularAttribute<ReprogramacaoOrder, UrgenciaObs> urgenciaobs;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> cuttingscheduled;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> materialreal;
	public static volatile SingularAttribute<ReprogramacaoOrder, CorConfirmacao> corconfirmacao;
	public static volatile SingularAttribute<ReprogramacaoOrder, Pedido> pedido;
	public static volatile SingularAttribute<ReprogramacaoOrder, String> sugporder;
	public static volatile SingularAttribute<ReprogramacaoOrder, Date> cuttingreal;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String OBS = "obs";
	public static final String TIPOFRETE = "tipofrete";
	public static final String STITCHREAL = "stitchreal";
	public static final String DTESTIMATEDXFCT = "dtestimatedxfct";
	public static final String LASTINGSCHEDULED = "lastingscheduled";
	public static final String OBSCLIENTE = "obscliente";
	public static final String DATASTAMP = "datastamp";
	public static final String REPROGRAMACAOORDERID = "reprogramacaoorderid";
	public static final String MATERIALSCHEDULED = "materialscheduled";
	public static final String INDICADOR = "indicador";
	public static final String TOTALPARES = "totalpares";
	public static final String PRECO = "preco";
	public static final String STITCHSCHEDULE = "stitchschedule";
	public static final String CLIENTE = "cliente";
	public static final String LASTINGREAL = "lastingreal";
	public static final String DTREPROGRAMACAO = "dtreprogramacao";
	public static final String URGENCIAOBS = "urgenciaobs";
	public static final String CUTTINGSCHEDULED = "cuttingscheduled";
	public static final String MATERIALREAL = "materialreal";
	public static final String CORCONFIRMACAO = "corconfirmacao";
	public static final String PEDIDO = "pedido";
	public static final String SUGPORDER = "sugporder";
	public static final String CUTTINGREAL = "cuttingreal";

}

