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
@Table(name="AutorizacaoEmbarque",indexes= {@Index(columnList="auem_clie_fk",name="auem_clie_ifk",unique=false)
										   ,@Index(columnList="auem_fabr_fk",name="auem_fabr_ifk",unique=false)
										   ,@Index(columnList="faturafabricaid,itemfaturafabricaid",name="auem_itff_ifk")
										   ,@Index(columnList="pedidoid,subgradepedidoid",name="auem_sugp_ifk",unique=false)
										   ,@Index(columnList="faturafabricafatrid,itemfaturafabricafatrid",name="auem_itff_tr_ifk",unique=false)})
@Getter @Setter
@EqualsAndHashCode
public class AutorizacaoEmbarque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "autorizacaoembarqueSeq")
	@SequenceGenerator(name = "autorizacaoembarqueSeq", sequenceName = "s_autorizacaoembarque", allocationSize = 1)
	@Column(name="autorizacaoembarque_pk",updatable=false,nullable=false)
	private Long autorizacaoembarqueid;

	@Column(precision=10,nullable=false)
	private Long pedidoid;
	
	@Column(precision=2,nullable=false)
	private Long subgradepedidoid;

	@Column(precision=10,nullable=true)
	private Long faturafabricaid;

	@Column(precision=2,nullable=true)
	private Long itemfaturafabricaid;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date dtcadastro;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtemissao;
	
	@Column(length=2,nullable=false)
	private Integer nrovias;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtprevxfactory;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtrealxfactory;

	@Column(length=6,nullable=false)
	private Integer pares;

	@Column(length=104,nullable=true)
	private String paressolido;
	
	@Column(length=104,nullable=true)
	private String paresmusical;

	@Column(length=5,nullable=true)
	private Integer caixas;

	@Column(length=10,nullable=true)
	private String notafiscaltransporte;
	
	@Column(length=10,nullable=true)
	private String dtnotafiscaltransporte;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataultimaimpressao;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private SituacaoAutorizacao situacao=SituacaoAutorizacao.A;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datacancelamento;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	@Column(length=104,nullable=true)
	private String paresmusicalnarrow;
	
	@Column(length=104,nullable=true)
	private String paresmusicalwidth;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoFrete tipofrete;
	
	@Column(precision=6,nullable=true)
	private Long faturafabricafatrid;

	@Column(precision=3,nullable=true)
	private Long itemfaturafabricafatrid;
	
	@Column(length=6,nullable=true)
	private Integer saldoparesemso;
	
	@Column(length=5,nullable=true)
	private Integer saldocaixasemso;

	@Column(length=104,nullable=true)
	private String saldoparesmusicalemso;
	
	//Chaves Estrangeiras

	//SubGradePedido
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="subgradepedidoid_fk",referencedColumnName="pedidoid",nullable=false),@JoinColumn(name="subgradepedido_fk",referencedColumnName="subgradepedidoid",nullable=false)},foreignKey=@ForeignKey(name="auem_subgrdped_fk"))
	private SubGradePedido subgradepedido;

	//Itens Faturas Fabricas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="fatfabid_fk",referencedColumnName="faturafabricaid",nullable=true),@JoinColumn(name="itfatfabid_fk",referencedColumnName="itemfaturafabricaid",nullable=true)},foreignKey=@ForeignKey(name="auem_itfatfab_fk"))
	private ItemFaturaFabrica itemfaturafabrica;
	
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="auem_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="auem_clie_fk"))
	private Cliente cliente;
	
	//Fabricas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="auem_fabr_fk",referencedColumnName="fabr_pk",nullable=false,foreignKey=@ForeignKey(name="auem_fabr_fk"))
	private Fabrica fabrica;

}
