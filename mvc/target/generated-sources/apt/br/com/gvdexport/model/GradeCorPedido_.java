package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GradeCorPedido.class)
public abstract class GradeCorPedido_ {

	public static volatile SingularAttribute<GradeCorPedido, String> usuariostamp;
	public static volatile SingularAttribute<GradeCorPedido, Integer> paresxfct;
	public static volatile SingularAttribute<GradeCorPedido, String> trilho;
	public static volatile SingularAttribute<GradeCorPedido, Long> confirmacaocorid;
	public static volatile SingularAttribute<GradeCorPedido, Integer> paresembarcados;
	public static volatile SingularAttribute<GradeCorPedido, String> terceiro;
	public static volatile SingularAttribute<GradeCorPedido, Date> dataentrada;
	public static volatile SingularAttribute<GradeCorPedido, Integer> totalpares;
	public static volatile SingularAttribute<GradeCorPedido, Long> pedidoid;
	public static volatile SingularAttribute<GradeCorPedido, Long> confirmacaoid;
	public static volatile SingularAttribute<GradeCorPedido, Date> dtcancelamento;
	public static volatile SingularAttribute<GradeCorPedido, Pedido> pedido;
	public static volatile SingularAttribute<GradeCorPedido, Integer> paresconfirmadoembarque;
	public static volatile SingularAttribute<GradeCorPedido, Integer> parescancelados;
	public static volatile SingularAttribute<GradeCorPedido, Componente> componente;
	public static volatile SingularAttribute<GradeCorPedido, Long> idrazaoalteracao;
	public static volatile SingularAttribute<GradeCorPedido, String> referenciacliente;
	public static volatile SingularAttribute<GradeCorPedido, String> stocknbr;
	public static volatile SingularAttribute<GradeCorPedido, Long> pedidocorid;
	public static volatile SingularAttribute<GradeCorPedido, String> codeidcliente;
	public static volatile SingularAttribute<GradeCorPedido, Date> datastamp;
	public static volatile SingularAttribute<GradeCorPedido, String> stocknbr1;
	public static volatile SingularAttribute<GradeCorPedido, String> nrocaixafinal;
	public static volatile SingularAttribute<GradeCorPedido, String> texto;
	public static volatile SingularAttribute<GradeCorPedido, RazaoAlteracao> razaoalteracao;
	public static volatile SingularAttribute<GradeCorPedido, SimNao> emitidocontrado;
	public static volatile SingularAttribute<GradeCorPedido, CorConfirmacao> corconfirmacao;
	public static volatile SingularAttribute<GradeCorPedido, String> nrocaixainicial;
	public static volatile SingularAttribute<GradeCorPedido, String> ordercustomer;
	public static volatile SingularAttribute<GradeCorPedido, String> codigocorcliente;
	public static volatile SingularAttribute<GradeCorPedido, String> obscomercial;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String PARESXFCT = "paresxfct";
	public static final String TRILHO = "trilho";
	public static final String CONFIRMACAOCORID = "confirmacaocorid";
	public static final String PARESEMBARCADOS = "paresembarcados";
	public static final String TERCEIRO = "terceiro";
	public static final String DATAENTRADA = "dataentrada";
	public static final String TOTALPARES = "totalpares";
	public static final String PEDIDOID = "pedidoid";
	public static final String CONFIRMACAOID = "confirmacaoid";
	public static final String DTCANCELAMENTO = "dtcancelamento";
	public static final String PEDIDO = "pedido";
	public static final String PARESCONFIRMADOEMBARQUE = "paresconfirmadoembarque";
	public static final String PARESCANCELADOS = "parescancelados";
	public static final String COMPONENTE = "componente";
	public static final String IDRAZAOALTERACAO = "idrazaoalteracao";
	public static final String REFERENCIACLIENTE = "referenciacliente";
	public static final String STOCKNBR = "stocknbr";
	public static final String PEDIDOCORID = "pedidocorid";
	public static final String CODEIDCLIENTE = "codeidcliente";
	public static final String DATASTAMP = "datastamp";
	public static final String STOCKNBR1 = "stocknbr1";
	public static final String NROCAIXAFINAL = "nrocaixafinal";
	public static final String TEXTO = "texto";
	public static final String RAZAOALTERACAO = "razaoalteracao";
	public static final String EMITIDOCONTRADO = "emitidocontrado";
	public static final String CORCONFIRMACAO = "corconfirmacao";
	public static final String NROCAIXAINICIAL = "nrocaixainicial";
	public static final String ORDERCUSTOMER = "ordercustomer";
	public static final String CODIGOCORCLIENTE = "codigocorcliente";
	public static final String OBSCOMERCIAL = "obscomercial";

}

