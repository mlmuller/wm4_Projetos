package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class ItemClaimId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false)
	private Long itemclaimid;
	
	@Column(precision=6,nullable=false)
	private Long sequenciaitemclaim;

	public Long getItemclaimid() {
		return itemclaimid;
	}

	public void setItemclaimid(Long itemclaimid) {
		this.itemclaimid = itemclaimid;
	}

	public Long getSequenciaitemclaim() {
		return sequenciaitemclaim;
	}

	public void setSequenciaitemclaim(Long sequenciaitemclaim) {
		this.sequenciaitemclaim = sequenciaitemclaim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemclaimid == null) ? 0 : itemclaimid.hashCode());
		result = prime * result + ((sequenciaitemclaim == null) ? 0 : sequenciaitemclaim.hashCode());
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
		ItemClaimId other = (ItemClaimId) obj;
		if (itemclaimid == null) {
			if (other.itemclaimid != null)
				return false;
		} else if (!itemclaimid.equals(other.itemclaimid))
			return false;
		if (sequenciaitemclaim == null) {
			if (other.sequenciaitemclaim != null)
				return false;
		} else if (!sequenciaitemclaim.equals(other.sequenciaitemclaim))
			return false;
		return true;
	}
	
	

}
