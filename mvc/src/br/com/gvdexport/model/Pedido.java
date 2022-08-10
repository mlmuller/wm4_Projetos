package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Pedido",indexes= {@Index(columnList="pedi_fabr_fk",name="pedi_fabr_iuk",unique=false)
							  ,@Index(columnList="pedi_clie_fk",name="pedi_clie_ifk",unique=false)
							  ,@Index(columnList="pedi_comp_cari_fk",name="pedi_comp_cari_ifk",unique=false)
							  ,@Index(columnList="pedi_conf_fk",name="pedi_conf_ifk",unique=false)
							  ,@Index(columnList="pedi_impo_fk",name="pedi_impo_ifk",unique=false)
							  ,@Index(columnList="pedi_tprz_fk",name="pedi_tprz_ifk",unique=false)
							  ,@Index(columnList="pedi_tpag_fk",name="pedi_tpag_ifk",unique=false)
							  ,@Index(columnList="nropedidoold",name="pedi_nroold_i",unique=false)
							  ,@Index(columnList="idpedidoorigem",name="pedi_orig_i",unique=false)
							  ,@Index(columnList="pedi_comp_caix_fk",name="pedi_comp_caix_ifk",unique=false)
							  ,@Index(columnList="pedi_comp_prod_fk",name="pedi_comp_prod_ifk",unique=false)})
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pedidoSeq")
	@SequenceGenerator(name = "pedidoSeq", sequenceName = "s_pedido", allocationSize = 1)
	@Column(name="pedido_pk",updatable=false,nullable=false)
	private Long pedidoid;

	@Column(length=5,nullable=true)
	private Integer pedidocabedal;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date datapedido;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private PedidoUnidade unidade;
	
	@Column(length=12,nullable=true)
	private String referenciacliente;
	
	@Column(length=1000,nullable=true)
	private String obs;
	
	@Column(length=6,nullable=true)
	private Integer totalpares;
	
	@Column(length=6,nullable=true)
	private Integer paresxfct;
	
	@Column(length=6,nullable=true)
	private Integer parescancelados;
	
	@Column(length=6,nullable=true)
	private Integer paresembarcados;

	@Column(length=100,nullable=true)
	private String texto;
	
	@Column(length=12,nullable=true)
	private String hpstyle;
	
	@Column(length=30,nullable=true)
	private String obstransportadora;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date ultdtchegadacli;

	@Column(length=2,nullable=true)
	private String refcdigoimportador;

	@Column(length=6,nullable=true)
	private Integer soladoenviadofabr;
	
	@Column(length=6,nullable=true)
	private Integer nropedidoold;

	@Column(length=6,nullable=true)
	private Integer idpedidoorigem;

	@Column(length=14,nullable=true)
	private String commoditycode;

	@Column(length=30,nullable=true)
	private String obscomercial;
	
	@Column(length=3,nullable=true)
	private String trilho;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao liberadoconfirmacao;

	@Column(length=20,nullable=true)
	private String terceiro;
	
	@Column(length=6,nullable=true)
	private Integer paresconfembarcado;

	@Column(length=5,nullable=true)
	private String ordercustomer;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private IdentificaGlobalCalcado identificaglobalcalcado;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private OrigemPedido origempedido;
	
	@Column(length=6,nullable=true)
	private String paresvendidosestoque;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	//Chaves Estrangeiras
	//Pedido Origem,provavel pedidos Web
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_pedori_fk",referencedColumnName="pedido_pk",nullable=true,foreignKey=@ForeignKey(name="pedi_pedori_fk"))
	private Pedido pedido;
	
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="pedi_clie_fk"))
	private Cliente cliente;
	
	//Fabricas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_fabr_fk",referencedColumnName="fabr_pk",nullable=false,foreignKey=@ForeignKey(name="pedi_fabr_fk"))
	private Fabrica fabrica;
	
	//Confirmacao
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_conf_fk",referencedColumnName="confirmacao_pk",nullable=false,foreignKey=@ForeignKey(name="pedi_conf_fk"))
	private Confirmacao confirmacao;
	
	//Tipo de Agente
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_tpag_fk",referencedColumnName="tipoagente_pk",nullable=true,foreignKey=@ForeignKey(name="pedi_tpag_fk"))
	private TipoAgente tipoagente;
	
	//Importador
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_impo_fk",referencedColumnName="impo_pk",nullable=true,foreignKey=@ForeignKey(name="pedi_impo_fk"))
	private Importador importador;
	
	//Tipos de alteracaos(Razoes)
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_tprz_fk",referencedColumnName="razaoalteracao_pk",nullable=true,foreignKey=@ForeignKey(name="pedi_tprz_fk"))
	//Modelos
	private RazaoAlteracao razaoalteracao;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_mode_fk",referencedColumnName="modelo_pk",nullable=true,foreignKey=@ForeignKey(name="pedi_mode_fk"))
	private Modelo modelo;

	//Componente
	//componente Carimbo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_comp_cari_fk",referencedColumnName="comp_pk",nullable=true,foreignKey=@ForeignKey(name="pedi_comp_cari_fk"))
	private Componente componentecarimbo;
	
	//Componente Caixa
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_comp_caix_fk",referencedColumnName="comp_pk",nullable=true,foreignKey=@ForeignKey(name="pedi_comp_caix_fk"))
	private Componente componentecaixa;

	//Componente Produto
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedi_comp_prod_fk",referencedColumnName="comp_pk",nullable=false,foreignKey=@ForeignKey(name="pedi_comp_prod_fk"))
	private Componente componenteproduto;
	

}
