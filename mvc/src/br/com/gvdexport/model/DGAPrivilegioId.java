package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class DGAPrivilegioId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(precision=10,nullable=false)
	private Long dgausuarioid;
	
	@Column(precision=10,nullable=false)
	private Long dgamoduloid;
	
	public Long getDgausuarioid() {
		return dgausuarioid;
	}

	public Long getDgamoduloid() {
		return dgamoduloid;
	}

	public void setDgausuarioid(Long dgausuarioid) {
		this.dgausuarioid = dgausuarioid;
	}

	public void setDgamoduloid(Long dgamoduloid) {
		this.dgamoduloid = dgamoduloid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dgamoduloid == null) ? 0 : dgamoduloid.hashCode());
		result = prime * result + ((dgausuarioid == null) ? 0 : dgausuarioid.hashCode());
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
		DGAPrivilegioId other = (DGAPrivilegioId) obj;
		if (dgamoduloid == null) {
			if (other.dgamoduloid != null)
				return false;
		} else if (!dgamoduloid.equals(other.dgamoduloid))
			return false;
		if (dgausuarioid == null) {
			if (other.dgausuarioid != null)
				return false;
		} else if (!dgausuarioid.equals(other.dgausuarioid))
			return false;
		return true;
	}


}
