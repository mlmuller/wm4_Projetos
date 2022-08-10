package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PedidoFinanceiro",indexes= {@Index(columnList="situacaopedidofinanceiro",name="pefi_situacao_i",unique=false)
										,@Index(columnList="pefi_confab_fk",name="pefi_confab_iuk",unique=false)
										,@Index(columnList="pefi_esta_fk",name="pefi_esta_ifk",unique=false)
										,@Index(columnList="pefi_przcli_fk",name="pefi_przcli_ifk",unique=false)})
@IdClass(PedidoId.class)

public class PedidoFinanceiro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long pedidoid;
	
	@Column(length=10,nullable=true)
	private String lcrequest;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Negociacao negociacao;
	
	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal retailprice;
	
	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal retailprc;
	
	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal precototal;
	
	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal precofabrica;
	
	@Column(precision=7,scale=4,nullable=true)
	private BigDecimal receitagvd;

	@Column(precision=7,scale=4,nullable=true)
	private BigDecimal comissaogvd;
	
	@Column(precision=7,scale=4,nullable=true)
	private BigDecimal valorfrete;
	
	@Column(precision=4,scale=2,nullable=true)
	private BigDecimal desconto;
	
	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal descdiverso;

	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal descnov;
	
	@Column(length=500,nullable=true)
	private String obsfinanceiro;
	
	//sera substituido por tabela ,apos importacao da base de dados
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoFrete tipofrete;
	
	@Column(precision=5,scale=2,nullable=true)
	private BigDecimal vlrdiverso;
	
	@Column(precision=7,scale=4,nullable=true)
	private BigDecimal vornov;
	
	@Column(precision=5,scale=2,nullable=true)
	private BigDecimal percdesc;

	@Column(precision=5,scale=2,nullable=true)
	private BigDecimal percgvd;
	
	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal acertocliente;


	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal comissaoagente;
	
	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal customer;
	
	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal precotabelacli;
	
	@Column(precision=7,scale=4,nullable=true)
	private BigDecimal nilreturn;

	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal prefabrcabedal;
	
	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal pretotalcabedal;
	
	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal receitacabedal;
	
	//Campo sem uso, totalmente null
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoNegociacao tiponegociacao;

	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal vlrcouro;
	
	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal vlrcouro1;
	
	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal vlrsola;
	
	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal vlrsola1;

	//*,L,N,para conpatiblizar,informacao nao mais usada
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private Licenca licenca;
	
	//First cost,UnList....
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoNegociacao landedfirst;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private BaseContrato basecontrato;
	
	//Nao mais usado-compatibilizar
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoVia via;

	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal royalty;
	
	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal unitariomaterialimportado;
	
	@Column(length=14,nullable=true)
	private String commoditycode;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private TipoPedido tipopedido;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(precision=12,scale=4,nullable=true)
	private BigDecimal peso;

	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal discrepar;
	
	@Column(length=3,nullable=true)
	private String ws;
	
	@Column(precision=12,scale=4,nullable=true)
	private BigDecimal vlrsintetico;

	@Column(precision=12,scale=4,nullable=true)
	private BigDecimal vlrclaim;
	
	@Column(precision=12,scale=4,nullable=true)
	private BigDecimal vlrclaimfabrica;
	
	@Column(precision=12,scale=4,nullable=true)
	private BigDecimal materiaprima;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao pedidoassinado;
	
	@Column(length=2,nullable=true)
	private String codigoestacao;
	
	@Column(length=60,nullable=true)
	private String codigomodelo;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SituacaoPedidoFinanceiro situacaopedidofinanceiro;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataimpressaopedido;
	
	@Column(precision=6,scale=3,nullable=true)
	private BigDecimal percentualagente;

	@Column(precision=8,scale=4,nullable=true)
	private BigDecimal perccomisagenteinv;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoComissaoAgente tipocomisagenteinv;

	@Column(precision=7,scale=4,nullable=true)
	private BigDecimal taxafabrica;

	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal specialdiscount;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataultimaliberacao;

	@Column(precision=16,scale=6,nullable=true)
	private BigDecimal receita;
	
	@Column(precision=16,scale=6,nullable=true)
	private BigDecimal percreceita;

	//Chaves Estrangeiras
	//Pedidos
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_pedi_pk",referencedColumnName="pedido_pk",nullable=true,foreignKey=@ForeignKey(name="pefi_pedi_fk"))
	private Pedido pedido;	
	
	//Prazo Pagamentos
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_przpag_fk",referencedColumnName="prpa_pk",nullable=true,foreignKey=@ForeignKey(name="pefi_przpag_fk"))
	private PrazoPagamento prazopagamento;
	
	//Estacoes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_esta_fk",referencedColumnName="esta_pk",nullable=true,foreignKey=@ForeignKey(name="pefi_esta_fk"))
	private Estacao estacao;

	//Contrato Fabrica
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_confab_fk",referencedColumnName="contratofabrica_pk",nullable=true,foreignKey=@ForeignKey(name="pefi_confab_fk"))
	private ContratoFabrica contratofabrica;
	
	//Moeda Cliente
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_moecli_fk",referencedColumnName="moed_pk",nullable=false,foreignKey=@ForeignKey(name="pefi_moecli_fk"))
	private Moeda moedacliente;
	
	//Moeda Fabrica
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_moefab_fk",referencedColumnName="moed_pk",nullable=false,foreignKey=@ForeignKey(name="pefi_moefab_fk"))
	private Moeda moedafabrica;
	
	//Vendedor
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_vend_fk",referencedColumnName="vend_pk",nullable=true,foreignKey=@ForeignKey(name="pefi_vend_fk"))
	private Vendedor vendedor;

	//Vendedor Invoice
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_veninv_fk",referencedColumnName="vend_pk",nullable=true,foreignKey=@ForeignKey(name="pefi_veninv_fk"))
	private Vendedor vendedorinvoice;

	//Moeda Frete
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_moefre_fk",referencedColumnName="moed_pk",nullable=true,foreignKey=@ForeignKey(name="pefi_moefre_fk"))
	private Moeda moedafrete;

	//Prazo Pagamentos Cliente
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_przcli_fk",referencedColumnName="prpa_pk",nullable=true,foreignKey=@ForeignKey(name="pefi_przcli_fk"))
	private PrazoPagamento prazopagamentocliente;

	//Moeda Retail
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pefi_moeret_fk",referencedColumnName="moed_pk",nullable=true,foreignKey=@ForeignKey(name="pefi_moeret_fk"))
	private Moeda moedaretail;
	
}
