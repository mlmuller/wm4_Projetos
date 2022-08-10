package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ {

	public static volatile SingularAttribute<Pedido, Fabrica> fabrica;
	public static volatile SingularAttribute<Pedido, String> obs;
	public static volatile SingularAttribute<Pedido, Integer> paresxfct;
	public static volatile SingularAttribute<Pedido, String> trilho;
	public static volatile SingularAttribute<Pedido, String> usuariostamp;
	public static volatile SingularAttribute<Pedido, Integer> soladoenviadofabr;
	public static volatile SingularAttribute<Pedido, Integer> paresembarcados;
	public static volatile SingularAttribute<Pedido, Date> ultdtchegadacli;
	public static volatile SingularAttribute<Pedido, String> paresvendidosestoque;
	public static volatile SingularAttribute<Pedido, Componente> componenteproduto;
	public static volatile SingularAttribute<Pedido, PedidoUnidade> unidade;
	public static volatile SingularAttribute<Pedido, String> terceiro;
	public static volatile SingularAttribute<Pedido, Integer> idpedidoorigem;
	public static volatile SingularAttribute<Pedido, Integer> paresconfembarcado;
	public static volatile SingularAttribute<Pedido, Componente> componentecarimbo;
	public static volatile SingularAttribute<Pedido, Integer> totalpares;
	public static volatile SingularAttribute<Pedido, Long> pedidoid;
	public static volatile SingularAttribute<Pedido, String> hpstyle;
	public static volatile SingularAttribute<Pedido, Pedido> pedido;
	public static volatile SingularAttribute<Pedido, String> obstransportadora;
	public static volatile SingularAttribute<Pedido, Importador> importador;
	public static volatile SingularAttribute<Pedido, Integer> parescancelados;
	public static volatile SingularAttribute<Pedido, SimNao> liberadoconfirmacao;
	public static volatile SingularAttribute<Pedido, Confirmacao> confirmacao;
	public static volatile SingularAttribute<Pedido, String> referenciacliente;
	public static volatile SingularAttribute<Pedido, Componente> componentecaixa;
	public static volatile SingularAttribute<Pedido, String> refcdigoimportador;
	public static volatile SingularAttribute<Pedido, TipoAgente> tipoagente;
	public static volatile SingularAttribute<Pedido, Date> datastamp;
	public static volatile SingularAttribute<Pedido, Integer> nropedidoold;
	public static volatile SingularAttribute<Pedido, String> commoditycode;
	public static volatile SingularAttribute<Pedido, Modelo> modelo;
	public static volatile SingularAttribute<Pedido, IdentificaGlobalCalcado> identificaglobalcalcado;
	public static volatile SingularAttribute<Pedido, Date> datapedido;
	public static volatile SingularAttribute<Pedido, OrigemPedido> origempedido;
	public static volatile SingularAttribute<Pedido, String> texto;
	public static volatile SingularAttribute<Pedido, Cliente> cliente;
	public static volatile SingularAttribute<Pedido, RazaoAlteracao> razaoalteracao;
	public static volatile SingularAttribute<Pedido, Integer> pedidocabedal;
	public static volatile SingularAttribute<Pedido, String> ordercustomer;
	public static volatile SingularAttribute<Pedido, String> obscomercial;

	public static final String FABRICA = "fabrica";
	public static final String OBS = "obs";
	public static final String PARESXFCT = "paresxfct";
	public static final String TRILHO = "trilho";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SOLADOENVIADOFABR = "soladoenviadofabr";
	public static final String PARESEMBARCADOS = "paresembarcados";
	public static final String ULTDTCHEGADACLI = "ultdtchegadacli";
	public static final String PARESVENDIDOSESTOQUE = "paresvendidosestoque";
	public static final String COMPONENTEPRODUTO = "componenteproduto";
	public static final String UNIDADE = "unidade";
	public static final String TERCEIRO = "terceiro";
	public static final String IDPEDIDOORIGEM = "idpedidoorigem";
	public static final String PARESCONFEMBARCADO = "paresconfembarcado";
	public static final String COMPONENTECARIMBO = "componentecarimbo";
	public static final String TOTALPARES = "totalpares";
	public static final String PEDIDOID = "pedidoid";
	public static final String HPSTYLE = "hpstyle";
	public static final String PEDIDO = "pedido";
	public static final String OBSTRANSPORTADORA = "obstransportadora";
	public static final String IMPORTADOR = "importador";
	public static final String PARESCANCELADOS = "parescancelados";
	public static final String LIBERADOCONFIRMACAO = "liberadoconfirmacao";
	public static final String CONFIRMACAO = "confirmacao";
	public static final String REFERENCIACLIENTE = "referenciacliente";
	public static final String COMPONENTECAIXA = "componentecaixa";
	public static final String REFCDIGOIMPORTADOR = "refcdigoimportador";
	public static final String TIPOAGENTE = "tipoagente";
	public static final String DATASTAMP = "datastamp";
	public static final String NROPEDIDOOLD = "nropedidoold";
	public static final String COMMODITYCODE = "commoditycode";
	public static final String MODELO = "modelo";
	public static final String IDENTIFICAGLOBALCALCADO = "identificaglobalcalcado";
	public static final String DATAPEDIDO = "datapedido";
	public static final String ORIGEMPEDIDO = "origempedido";
	public static final String TEXTO = "texto";
	public static final String CLIENTE = "cliente";
	public static final String RAZAOALTERACAO = "razaoalteracao";
	public static final String PEDIDOCABEDAL = "pedidocabedal";
	public static final String ORDERCUSTOMER = "ordercustomer";
	public static final String OBSCOMERCIAL = "obscomercial";

}

