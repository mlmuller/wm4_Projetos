package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class ItemFaturaFabricaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false)
	private Long faturafabricaid;
	
	@Column(precision=2,nullable=false)
	private Long itemfaturafabricaid;

	public Long getFaturafabricaid() {
		return faturafabricaid;
	}

	public void setFaturafabricaid(Long faturafabricaid) {
		this.faturafabricaid = faturafabricaid;
	}

	public Long getItemfaturafabricaid() {
		return itemfaturafabricaid;
	}

	public void setItemfaturafabricaid(Long itemfaturafabricaid) {
		this.itemfaturafabricaid = itemfaturafabricaid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faturafabricaid == null) ? 0 : faturafabricaid.hashCode());
		result = prime * result + ((itemfaturafabricaid == null) ? 0 : itemfaturafabricaid.hashCode());
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
		ItemFaturaFabricaId other = (ItemFaturaFabricaId) obj;
		if (faturafabricaid == null) {
			if (other.faturafabricaid != null)
				return false;
		} else if (!faturafabricaid.equals(other.faturafabricaid))
			return false;
		if (itemfaturafabricaid == null) {
			if (other.itemfaturafabricaid != null)
				return false;
		} else if (!itemfaturafabricaid.equals(other.itemfaturafabricaid))
			return false;
		return true;
	}

	
}
