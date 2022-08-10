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
import javax.persistence.JoinColumn;
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
@Table(name="EnderecoCliente",uniqueConstraints=@UniqueConstraint(columnNames= {"endcli_grpinvcli_fk","sequenciaendereco"},name = "endcli_uk"))
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class EnderecoCliente implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "endcliSeq")
	@SequenceGenerator(name = "endcliSeq", sequenceName = "s_endcli", allocationSize = 1)
	@Column(name="endcli_pk",updatable=false,nullable=false)
	private Long enderecoclienteid;
	
	@Column(length = 3, nullable = false)
	private Integer sequenciaendereco;
	
	@Column(length=300,nullable=true)
	private String address;
	
	@Column(length=300,nullable=true)
	private String notify1;

	@Column(length=300,nullable=true)
	private String notify2;

	@Column(length=300,nullable=true)
	private String consignee1;

	@Column(length=300,nullable=true)
	private String consignee2;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private DestinoInvoice destinoinvoice;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=5,nullable=true)
	private String ediinterkommerznotify;
	
	@Column(length=5,nullable=true)
	private String ediinterkommerznotify2;

	@Column(length=150,nullable=true)
	private String complementoaddress;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="endcli_grpinvcli_fk",referencedColumnName="grci_pk",nullable=false,
	foreignKey=@ForeignKey(name="endcli_grpinvcli_fk"))
	private GrupoClienteInvoice grupoclienteinvoice;

	@Override
	public String toString() {
		return "EnderecoCliente [sequenciaendereco=" + sequenciaendereco + ", grupoclienteinvoice="
				+ grupoclienteinvoice + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

	
}
