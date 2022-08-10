package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class MaqueteId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false)
	private Long maqueteid;

	public Long getMaqueteid() {
		return maqueteid;
	}

	public void setMaqueteid(Long maqueteid) {
		this.maqueteid = maqueteid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maqueteid == null) ? 0 : maqueteid.hashCode());
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
		MaqueteId other = (MaqueteId) obj;
		if (maqueteid == null) {
			if (other.maqueteid != null)
				return false;
		} else if (!maqueteid.equals(other.maqueteid))
			return false;
		return true;
	}

	
}
