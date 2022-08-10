package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class FaturaFretePagoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(length=10,nullable=false)
	private Long numerofaturatradingid;
	
	@Column(length=4,nullable=false)
	private String anofaturatrading;

	public Long getNumerofaturatradingid() {
		return numerofaturatradingid;
	}

	public void setNumerofaturatradingid(Long numerofaturatradingid) {
		this.numerofaturatradingid = numerofaturatradingid;
	}

	public String getAnofaturatrading() {
		return anofaturatrading;
	}

	public void setAnofaturatrading(String anofaturatrading) {
		this.anofaturatrading = anofaturatrading;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anofaturatrading == null) ? 0 : anofaturatrading.hashCode());
		result = prime * result + ((numerofaturatradingid == null) ? 0 : numerofaturatradingid.hashCode());
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
		FaturaFretePagoId other = (FaturaFretePagoId) obj;
		if (anofaturatrading == null) {
			if (other.anofaturatrading != null)
				return false;
		} else if (!anofaturatrading.equals(other.anofaturatrading))
			return false;
		if (numerofaturatradingid == null) {
			if (other.numerofaturatradingid != null)
				return false;
		} else if (!numerofaturatradingid.equals(other.numerofaturatradingid))
			return false;
		return true;
	}
	
	
}
