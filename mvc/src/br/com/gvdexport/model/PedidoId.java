package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class PedidoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(precision=10,nullable=false)
	private Long pedidoid;

	public Long getPedidoid() {
		return pedidoid;
	}

	public void setPedidoid(Long pedidoid) {
		this.pedidoid = pedidoid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidoid == null) ? 0 : pedidoid.hashCode());
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
		PedidoId other = (PedidoId) obj;
		if (pedidoid == null) {
			if (other.pedidoid != null)
				return false;
		} else if (!pedidoid.equals(other.pedidoid))
			return false;
		return true;
	}
	
	
}
