package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class ItemCatalogoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false)
	private Long catalogoid;
	
	@Column(precision=2,nullable=false)
	private Long itemcatalogoid;

	public Long getCatalogoid() {
		return catalogoid;
	}

	public void setCatalogoid(Long catalogoid) {
		this.catalogoid = catalogoid;
	}

	public Long getCatalogoitemid() {
		return itemcatalogoid;
	}

	public void setCatalogoitemid(Long catalogoitemid) {
		this.itemcatalogoid = catalogoitemid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalogoid == null) ? 0 : catalogoid.hashCode());
		result = prime * result + ((itemcatalogoid == null) ? 0 : itemcatalogoid.hashCode());
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
		ItemCatalogoId other = (ItemCatalogoId) obj;
		if (catalogoid == null) {
			if (other.catalogoid != null)
				return false;
		} else if (!catalogoid.equals(other.catalogoid))
			return false;
		if (itemcatalogoid == null) {
			if (other.itemcatalogoid != null)
				return false;
		} else if (!itemcatalogoid.equals(other.itemcatalogoid))
			return false;
		return true;
	}


}
