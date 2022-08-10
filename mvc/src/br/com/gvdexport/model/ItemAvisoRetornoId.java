package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class ItemAvisoRetornoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false)
	private Long avisoretornoid;
	
	@Column(precision=2,nullable=false)
	private Long itemavisoretornoid;

	public Long getAvisoretornoid() {
		return avisoretornoid;
	}

	public void setAvisoretornoid(Long avisoretornoid) {
		this.avisoretornoid = avisoretornoid;
	}

	public Long getItemavisoretornoid() {
		return itemavisoretornoid;
	}

	public void setItemavisoretornoid(Long itemavisoretornoid) {
		this.itemavisoretornoid = itemavisoretornoid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avisoretornoid == null) ? 0 : avisoretornoid.hashCode());
		result = prime * result + ((itemavisoretornoid == null) ? 0 : itemavisoretornoid.hashCode());
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
		ItemAvisoRetornoId other = (ItemAvisoRetornoId) obj;
		if (avisoretornoid == null) {
			if (other.avisoretornoid != null)
				return false;
		} else if (!avisoretornoid.equals(other.avisoretornoid))
			return false;
		if (itemavisoretornoid == null) {
			if (other.itemavisoretornoid != null)
				return false;
		} else if (!itemavisoretornoid.equals(other.itemavisoretornoid))
			return false;
		return true;
	}
	
	

}
