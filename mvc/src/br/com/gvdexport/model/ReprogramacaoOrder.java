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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ReprogramacaoOrder",indexes=@Index(columnList="reprgord_clie_fk,sugporder,confirmacaoid_fk,seqcorconfirmacao_fk",name="reprgord_clie_ord_ifk",unique=false))
@Getter @Setter
@EqualsAndHashCode
public class ReprogramacaoOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reprogramacaoorderSeq")
	@SequenceGenerator(name = "reprogramacaoorderSeq", sequenceName = "s_reprogramacaoorder", allocationSize = 1)
	@Column(name="reprogramacaoorder_pk",updatable=false,nullable=false)
	private Long reprogramacaoorderid;
	
	@Column(length=25,nullable=true)
	private String sugporder;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtreprogramacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Enumerated(EnumType.STRING)
	@Column(length=2,nullable=true)
	private Indicador indicador;
	
	@Column(length=6,nullable=true)
	private Integer totalpares;
	
	@Column(length=1000,nullable=true)
	private String obs;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private UrgenciaObs urgenciaobs;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtestimatedxfct;
	
	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoFrete tipofrete;
	
	@Column(length=1000,nullable=true)
	private String obscliente;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date cuttingscheduled;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date cuttingreal;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date lastingscheduled;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date lastingreal;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date materialscheduled;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date materialreal;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date stitchschedule;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date stitchreal;
	
	//Chaves Estrangeiras
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="reprgord_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="reprgord_clie_fk"))
	private Cliente cliente;
	
	//Cor Confirmacao
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="confirmacaoid_fk",referencedColumnName="confirmacaoid",nullable=true),@JoinColumn(name="seqcorconfirmacao_fk",referencedColumnName="sequenciacorconfirmacao",nullable=true)},foreignKey=@ForeignKey(name="reprgord_conf_fk"))
	private CorConfirmacao corconfirmacao;

	//Pedidos
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="reprgord_pedi_fk",referencedColumnName="pedido_pk",nullable=true,foreignKey=@ForeignKey(name="reprgord_pedi_fk"))
	private Pedido pedido;	


}
