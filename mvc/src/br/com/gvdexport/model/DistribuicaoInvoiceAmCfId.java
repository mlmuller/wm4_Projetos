package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class DistribuicaoInvoiceAmCfId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false)
	private Long invoiceamcfid;
	
	@Column(precision=10,nullable=false)
	private Long destinoamcfid;

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
		DistribuicaoInvoiceAmCfId other = (DistribuicaoInvoiceAmCfId) obj;
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
