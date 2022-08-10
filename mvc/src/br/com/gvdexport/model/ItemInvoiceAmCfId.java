package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class ItemInvoiceAmCfId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false)
	private Long invoiceamcfid;
	
	@Column(precision=10,nullable=false)
	private Long iteminvoiceamcfid;

	public Long getInvoiceamcfid() {
		return invoiceamcfid;
	}

	public void setInvoiceamcfid(Long invoiceamcfid) {
		this.invoiceamcfid = invoiceamcfid;
	}

	public Long getIteminvoiceamcfid() {
		return iteminvoiceamcfid;
	}

	public void setIteminvoiceamcfid(Long iteminvoiceamcfid) {
		this.iteminvoiceamcfid = iteminvoiceamcfid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoiceamcfid == null) ? 0 : invoiceamcfid.hashCode());
		result = prime * result + ((iteminvoiceamcfid == null) ? 0 : iteminvoiceamcfid.hashCode());
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
		ItemInvoiceAmCfId other = (ItemInvoiceAmCfId) obj;
		if (invoiceamcfid == null) {
			if (other.invoiceamcfid != null)
				return false;
		} else if (!invoiceamcfid.equals(other.invoiceamcfid))
			return false;
		if (iteminvoiceamcfid == null) {
			if (other.iteminvoiceamcfid != null)
				return false;
		} else if (!iteminvoiceamcfid.equals(other.iteminvoiceamcfid))
			return false;
		return true;
	}
	
	

}
