package br.com.gvdexport.model;

import java.io.Serializable;
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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SubGradePedido",indexes= {@Index(columnList="sugp_comp_nume3_fk",name="sugp_comp_num3_ifk")
									  ,@Index(columnList="sugp_comp_nume3_fk",name="sugp_comp_num2_ifk")
									  ,@Index(columnList="sugp_comp_nume3_fk",name="sugp_comp_num1_ifk")
									  ,@Index(columnList="inseridocontroleproducao,dtprorrxfct,pedidoid,trilho",name="sugp_pror_xfct_i")
									  ,@Index(columnList="pedidoid",name="sugp_pedi_i")
									  ,@Index(columnList="pedidoid,itemgradecor",name="sugp_grcp_i")
									  ,@Index(columnList="sugp_dipa_fk",name="sugp_dipa_ifk")
									  ,@Index(columnList="sugporder",name="sugp_order_i")})
@IdClass(SubGradePedidoId.class)
public class SubGradePedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long pedidoid;
	
	@Id
	private Long subgradepedidoid;

	@Column(precision=2,nullable=false)
	private Long itemgradecor;

	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataenvioinf;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtcartacredito;
	
	@Column(length=15,nullable=true)
	private String nrocartacredito;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoFrete tipofrete;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoVia via;
	
	@Column(length=5,nullable=true)
	private Integer caixas;
	
	@Column(length=5,nullable=true)
	private Integer caixascanceladas;
	
	@Column(length=6,nullable=false)
	private Integer totalpares;

	@Column(length=6,nullable=true)
	private Integer paresxfct;
	
	@Column(length=6,nullable=true)
	private Integer paresembarcados;
	
	@Column(length=6,nullable=false)
	private Integer saldoautorizacaoembarque;

	@Column(length=6,nullable=false)
	private Integer saldofaturaembarque;
	
	@Column(length=104,nullable=true)
	private String paresmusical;
	
	@Column(length=104,nullable=true)
	private String saldoparesmusical;

	@Column(length=104,nullable=true)
	private String saldoprmusicalfatfab;
	
	@Column(length=104,nullable=true)
	private String paressolido;
	
	@Column(length=104,nullable=true)
	private String saldoparessolido;
	
	@Column(length=104,nullable=true)
	private String saldoprsolidofatfab;
	
	@Column(length=104,nullable=true)
	private String parescanceladosmusical;
	
	@Column(length=104,nullable=true)
	private String parescanceladossolido;
	
	@Column(length=6,nullable=true)
	private Integer parescancelados;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtprevxfct;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtprorrxfct;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date rdd;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtprevembarque;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtembarque;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtprevchegadacli;
	
	@Column(length=100,nullable=true)
	private String texto;
	
	@Column(length=100,nullable=true)
	private String obs;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtproducao;
	
	@Column(length=10,nullable=true)
	private String codnumcli;
	
	@Column(length=20,nullable=true)
	private String sku;
	
	@Column(length=25,nullable=true)
	private String sugporder;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtorder;

	@Column(length=15,nullable=true)
	private String ponumber;

	@Column(length=10,nullable=true)
	private String codediv;

	@Column(length=10,nullable=true)
	private String area;

	@Column(length=15,nullable=true)
	private String stocknbr;

	@Column(length=15,nullable=true)
	private String stocknbr1;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtprevisaocorte;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtcorte;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtprevisaocostura;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtcostura;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtprevisaoacabam;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtacabamento;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtupdate;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date okcliente;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date ukdolcis;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date ukgvd;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date estimatedate;
	
	@Column(length=3,nullable=true)
	private String trilho;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao autorizadoembarque=SimNao.N;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private LarguraForma larguraforma;
	
	@Column(length=2,nullable=true)
	private Integer semana;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=5,nullable=true)
	private Integer saldocaixas;

	@Column(length=5,nullable=true)
	private Integer saldocaixasfatfab;
	
	@Column(length=50,nullable=true)
	private String obscomercial;
	
	@Column(length=4,nullable=true)
	private Integer iddistribuicaopar;

	@Column(length=20,nullable=true)
	private String terceiros;

	@Column(length=104,nullable=true)
	private String paresmusicalnarrow;
	
	@Column(length=104,nullable=true)
	private String saldoparesmusicalnarrow;
	
	@Column(length=104,nullable=true)
	private String saldomusicalnarrowfatfab;
	
	@Column(length=104,nullable=true)
	private String paresmusicalwidth;
	
	@Column(length=104,nullable=true)
	private String saldoparesmusicalwidth;
	
	@Column(length=104,nullable=true)
	private String saldomusicalwidthfatfab;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao etiquetaimpressa;
	
	@Column(length=6,nullable=true)
	private Integer paresconfirmembarcados;

	@Column(length=5,nullable=true)
	private String ordercustomer;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataetiqueta;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private SimNao inseridocontroleproducao=SimNao.valueOf(null);
	
	//id_item_solicitacao, nao sera implementado...
	//Componente Numeracao2
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sugp_pedi_fk",referencedColumnName="pedido_pk",nullable=true,foreignKey=@ForeignKey(name="sugp_pedi_fk"))
	private Pedido pedido;
	
	//Cor Grade Pedido
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="pedidoid_fk",referencedColumnName="pedidoid",nullable=false),@JoinColumn(name="gradecorpedido_fk",referencedColumnName="pedidocorid",nullable=false)},foreignKey=@ForeignKey(name="sugp_grdcor_fk"))
	private GradeCorPedido gradecorpedido;
	
	//Distribuicao de Pares Auxiliar
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sugp_dipa_fk",referencedColumnName="distribuicaopar_pk",nullable=true,foreignKey=@ForeignKey(name="sugp_dipa_fk"))
	private DistribuicaoPar distribuicaopar;
	
	//Componente
	//componente Numeracao1
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sugp_comp_nume1_fk",referencedColumnName="comp_pk",nullable=true,foreignKey=@ForeignKey(name="sugp_comp_nume1_fk"))
	private Componente numeracao1;
	
	//Componente Numeracao2
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sugp_comp_nume2_fk",referencedColumnName="comp_pk",nullable=true,foreignKey=@ForeignKey(name="sugp_comp_nume2_fk"))
	private Componente numeracao2;

	//Componente Numeracao3
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sugp_comp_nume3_fk",referencedColumnName="comp_pk",nullable=true,foreignKey=@ForeignKey(name="sugp_comp_nume3_fk"))
	private Componente numeracao3;
	
	
}
