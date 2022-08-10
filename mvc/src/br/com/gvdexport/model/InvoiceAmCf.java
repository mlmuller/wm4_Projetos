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
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="InvoiceAmCf",uniqueConstraints= @UniqueConstraint(columnNames= {"grpcliinv_fk","numeroinvoice","mercado"},name="invamcf_grpcliinv_uk"),
indexes={@Index(columnList="grpcliinv_invamcf_fk",name="invamcf_grpinv_ifk",unique=false)})
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor


public class InvoiceAmCf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "invoiceamcfSeq")
	@SequenceGenerator(name = "invoiceamcfSeq", sequenceName = "s_invoiceamcf", allocationSize = 1)
	@Column(name="invoiceamcf_pk",updatable=false,nullable=false)
	private Long invoiceamcfid;

	@Column(length=10,nullable=false)
	private Integer numeroinvoice;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datainvoice;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Mercado mercado;
	
	@Column(length=2000,nullable=true)
	private String descricaopares;
	
	@Column(length=500,nullable=true)
	private String descricaocaixas;
	
	@Column(precision=10,scale=2,nullable=true)
	private BigDecimal precototal;
	
	@Column(length=50,nullable=true)
	private String complementonotify;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private Situacao situacao;
	
	@Column(precision=10,scale=2,nullable=true)
	private BigDecimal preco;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Grupo Cliente
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="grpcliinv_fk",referencedColumnName="grci_pk")
	private GrupoClienteInvoice grupoclienteinvoice;
	//endereco e Sequencia
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="grpcliinv_invamcf_fk",referencedColumnName="endcli_pk",nullable=false,foreignKey=@ForeignKey(name="amo_encli_fk"))})
	private EnderecoCliente sequenciaendereco;

	
}
