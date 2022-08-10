package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="DistribuicaoInvoiceAmCf",indexes= {@Index(columnList="disinv_invdes_fk",unique=false,name="disinv_desinv_ifk")
											   ,@Index(columnList="disinv_invamcf_fk",unique=false,name="disinv_invamcf_ifk")})
@IdClass(DistribuicaoInvoiceAmCfId.class)

public class DistribuicaoInvoiceAmCf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long invoiceamcfid;
	
	@Id
	private Long destinoamcfid;
	
	@Column(length=50,nullable=true)
	private String numeracaocaixas;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Invoices Amostras/Confirmacoes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="disinv_invamcf_fk",referencedColumnName="invoiceamcf_pk",nullable=false,foreignKey=@ForeignKey(name="disinv_invamcf_fk"))
	private InvoiceAmCf invoiceamcf;
	

	//Invoices Destino
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="disinv_invdes_fk",referencedColumnName="deac_pk",nullable=false,foreignKey=@ForeignKey(name="disinv_invdes_fk"))
	private DestinoAmCf destinoamcf;


	public Long getInvoiceamcfid() {
		return invoiceamcfid;
	}


	public void setInvoiceamcfid(Long invoiceamcfid) {
		this.invoiceamcfid = invoiceamcfid;
	}


	public Long getDestinoamcfid() {
		return destinoamcfid;
	}


	public void setDestinoamcfid(Long destinoamcfid) {
		this.destinoamcfid = destinoamcfid;
	}


	public String getNumeracaocaixas() {
		return numeracaocaixas;
	}


	public void setNumeracaocaixas(String numeracaocaixas) {
		this.numeracaocaixas = numeracaocaixas;
	}


	public String getUsuariostamp() {
		return usuariostamp;
	}


	public void setUsuariostamp(String usuariostamp) {
		this.usuariostamp = usuariostamp;
	}


	public Date getDatastamp() {
		return datastamp;
	}


	public void setDatastamp(Date datastamp) {
		this.datastamp = datastamp;
	}


	public InvoiceAmCf getInvoiceamcf() {
		return invoiceamcf;
	}


	public void setInvoiceamcf(InvoiceAmCf invoiceamcf) {
		this.invoiceamcf = invoiceamcf;
	}


	public DestinoAmCf getDestinoamcf() {
		return destinoamcf;
	}


	public void setDestinoamcf(DestinoAmCf destinoamcf) {
		this.destinoamcf = destinoamcf;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destinoamcfid == null) ? 0 : destinoamcfid.hashCode());
		result = prime * result + ((invoiceamcfid == null) ? 0 : invoiceamcfid.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistribuicaoInvoiceAmCf other = (DistribuicaoInvoiceAmCf) obj;
		if (destinoamcfid == null) {
			if (other.destinoamcfid != null)
				return false;
		} else if (!destinoamcfid.equals(other.destinoamcfid))
			return false;
		if (invoiceamcfid == null) {
			if (other.invoiceamcfid != null)
				return false;
		} else if (!invoiceamcfid.equals(other.invoiceamcfid))
			return false;
		return true;
	}


}
