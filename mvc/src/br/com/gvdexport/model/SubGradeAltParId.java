package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class SubGradeAltParId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(precision=10,nullable=false)
	private Long pedidoid;
	
	@Column(precision=5,nullable=false)
	private Long sbgradepedidoid;
	
	@Column(precision=3,nullable=false)
	private Long sequenciaid;

	public Long getPedidoid() {
		return pedidoid;
	}

	public void setPedidoid(Long pedidoid) {
		this.pedidoid = pedidoid;
	}

	public Long getSubgradepedidoid() {
		return sbgradepedidoid;
	}

	public void setSubgradepedidoid(Long subgradepedidoid) {
		this.sbgradepedidoid = subgradepedidoid;
	}

	public Long getSequenciaid() {
		return sequenciaid;
	}

	public void setSequenciaid(Long sequenciaid) {
		this.sequenciaid = sequenciaid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidoid == null) ? 0 : pedidoid.hashCode());
		result = prime * result + ((sequenciaid == null) ? 0 : sequenciaid.hashCode());
		result = prime * result + ((sbgradepedidoid == null) ? 0 : sbgradepedidoid.hashCode());
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
		SubGradeAltParId other = (SubGradeAltParId) obj;
		if (pedidoid == null) {
			if (other.pedidoid != null)
				return false;
		} else if (!pedidoid.equals(other.pedidoid))
			return false;
		if (sequenciaid == null) {
			if (other.sequenciaid != null)
				return false;
		} else if (!sequenciaid.equals(other.sequenciaid))
			return false;
		if (sbgradepedidoid == null) {
			if (other.sbgradepedidoid != null)
				return false;
		} else if (!sbgradepedidoid.equals(other.sbgradepedidoid))
			return false;
		return true;
	}
	
	

}
