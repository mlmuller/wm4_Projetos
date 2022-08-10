package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class SubGradePedidoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false)
	private Long pedidoid;
	
	@Column(precision=2,nullable=false)
	private Long subgradepedidoid;

	public Long getPedidoid() {
		return pedidoid;
	}

	public void setPedidoid(Long pedidoid) {
		this.pedidoid = pedidoid;
	}

	public Long getSubgradepedidoid() {
		return subgradepedidoid;
	}

	public void setSubgradepedidoid(Long subgradepedidoid) {
		this.subgradepedidoid = subgradepedidoid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidoid == null) ? 0 : pedidoid.hashCode());
		result = prime * result + ((subgradepedidoid == null) ? 0 : subgradepedidoid.hashCode());
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
		SubGradePedidoId other = (SubGradePedidoId) obj;
		if (pedidoid == null) {
			if (other.pedidoid != null)
				return false;
		} else if (!pedidoid.equals(other.pedidoid))
			return false;
		if (subgradepedidoid == null) {
			if (other.subgradepedidoid != null)
				return false;
		} else if (!subgradepedidoid.equals(other.subgradepedidoid))
			return false;
		return true;
	}
	
	

}
