package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class GradeCorPedidoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false)
	private Long pedidoid;
	
	@Column(precision=2,nullable=false)
	private Long pedidocorid;

	public Long getPedidoid() {
		return pedidoid;
	}

	public void setPedidoid(Long pedidoid) {
		this.pedidoid = pedidoid;
	}

	public Long getPedidocorid() {
		return pedidocorid;
	}

	public void setPedidocorid(Long pedidocorid) {
		this.pedidocorid = pedidocorid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidocorid == null) ? 0 : pedidocorid.hashCode());
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
		GradeCorPedidoId other = (GradeCorPedidoId) obj;
		if (pedidocorid == null) {
			if (other.pedidocorid != null)
				return false;
		} else if (!pedidocorid.equals(other.pedidocorid))
			return false;
		if (pedidoid == null) {
			if (other.pedidoid != null)
				return false;
		} else if (!pedidoid.equals(other.pedidoid))
			return false;
		return true;
	}

	
}
