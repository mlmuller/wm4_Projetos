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
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="FaturasFabricas",uniqueConstraints= {@UniqueConstraint(columnNames= {"numerofaturafabrica","anofaturafabrica","fafa_fabr_fk"},name="fafa_nume_ano_ifk")}
						               ,indexes= {@Index(columnList="dataconfirmembarque",name="fafa_dtemb_i",unique=false)
						                         ,@Index(columnList="nrofattrad",name="fafa_nrotrad_i",unique=false)
						               			 ,@Index(columnList= "numerofaturatrading,anofaturatrading",name="fafa_fatr_i")
						               			 ,@Index(columnList="fafa_fabr_fk",name="fafa_fabr_ifk",unique=false)
						               			 ,@Index(columnList="fafa_clie_fk",name="fafa_clie_ifk",unique=false)})
@Getter @Setter
@EqualsAndHashCode

public class FaturaFabrica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "faturafabricaSeq")
	@SequenceGenerator(name = "faturafabricaSeq", sequenceName = "s_faturafabrica", allocationSize = 1)
	@Column(name="faturafabrica_pk",updatable=false,nullable=false)
	private Long faturafabricaid;

	@Column(length=6,nullable=true)
	private Integer numerofaturatrading;
	
	@Column(length=4,nullable=true)
	private Integer anofaturatrading;
	
	@Column(length=8,nullable=true)
	private Integer caminhao;

	@Column(length=6,nullable=false)
	private String numerofaturafabrica;

	@Column(length=4,nullable=false)
	private Integer anofaturafabrica;
	
	@Column(length=8,nullable=true)
	private Integer totalpares;
	
	@Column(length=8,nullable=true)
	private Integer parespagofabrica;
	
	@Column(precision=9,scale=2,nullable=true)
	private BigDecimal specialdiscount;
	
	@Column(precision=12,scale=4,nullable=true)
	private BigDecimal custofrete;
	
	@Column(precision=9,scale=2,nullable=true)
	private BigDecimal freterefund;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoFrete tipofrete;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoVia viaembarque;

	@Column(precision=12,scale=4,nullable=true)
	private BigDecimal pesobruto;
	
	@Column(precision=12,scale=4,nullable=true)
	private BigDecimal pesoliquido;
	
	@Column(length=4,nullable=true)
	private String numerocaixas;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datapagamento;

	@Column(precision=15,scale=2,nullable=true)
	private BigDecimal valorfatura;
	
	@Column(precision=15,scale=2,nullable=true)
	private BigDecimal valorfaturafabrica;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataprogramada;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datasaida;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datachegada;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datadocumento;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataprogramadasaida;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataconfirmembarque;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datapartidareal;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datachegadacliente;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datafcr;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataxfactory;
	
	@Column(precision=8,scale=2,nullable=true)
	private BigDecimal metrocubico;
	
	@Column(length=100,nullable=true)
	private String observacao;
	
	@Column(length=25,nullable=true)
	private String airboat;

	@Column(length=5,nullable=true)
	private Integer numeromapashipping;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datamapashipping;

	@Column(length=12,nullable=true)
	private String numeradorshipping;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataretorno;

	@Column(length=4,nullable=true)
	private Integer numerojucari;
	
	@Column(length=5,nullable=true)
	private Integer numerogeralmapa;
	
	@Column(precision=15,scale=4,nullable=true)
	private BigDecimal frete;
	
	@Column(precision=5,scale=2,nullable=true)
	private BigDecimal desconto;
	
	@Column(length=15,nullable=true)
	private String nrofattrad;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datapgtofabricagvd;

	@Column(length=10,nullable=true)
	private String notagvdcomissao;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date emissaonotagvdcomissao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datapgtogvdfabrica;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataliquidacaocliente;
	
	@Column(precision=13,scale=4,nullable=true)
	private BigDecimal valorpagocliente;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataduplicidade;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataliquidacaofatura;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date dataentrada;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private OrigemInsercao origeminsercao=OrigemInsercao.F;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private SituacaoEDIImportador situacaoediimportador=SituacaoEDIImportador.N;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataexpediimportador;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataimpediimportador;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datavctofabrica;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao liberacomissao;

	@Column(length=8,nullable=true)
	private Integer parescaixas;
	
	@Column(length=4,nullable=true)
	private Integer numerocaixas2;
	
	@Column(length=5,nullable=true)
	private Integer parescaixas2;

	@Column(length=10,nullable=true)
	private String numeracaocaixas;

	@Column(length=4,nullable=true)
	private String dimensaocaixal;
	
	@Column(length=4,nullable=true)
	private String dimensaocaixaw;
	
	@Column(length=4,nullable=true)
	private String dimensaocaixah;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataprevisaoembarqueslip;
	
	@Column(length=1000,nullable=true)
	private String observacaocliente;
		
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fafa_clie_fk",referencedColumnName="clie_pk",nullable=true,foreignKey=@ForeignKey(name="fafa_clie_fk"))
	private Cliente cliente;
	
	//Fabricas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fafa_fabr_fk",referencedColumnName="fabr_pk",nullable=true,foreignKey=@ForeignKey(name="fafa_fabr_fk"))
	private Fabrica fabrica;
	
	//Navio
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fafa_navio_fk",referencedColumnName="navio_pk",nullable=true,foreignKey=@ForeignKey(name="fafa_navio_fk"))
	private Navio navio;



}
