package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class ProblemaProducaoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	//Id Ficha Producao
	@Column(precision=10,nullable=false)
	private Long fichaproducaoid;
	//Sequencial
	@Column(precision=2, nullable = false)
	private Long sequenciaproblemaproducao;


	public Long getFichaproducaoid() {
		return fichaproducaoid;
	}

	public void setFichaproducaoid(Long fichaproducaoid) {
		this.fichaproducaoid = fichaproducaoid;
	}

	public Long getSequenciaproblemaproducao() {
		return sequenciaproblemaproducao;
	}

	public void setSequenciaproblemaproducao(Long sequenciaproblemaproducao) {
		this.sequenciaproblemaproducao = sequenciaproblemaproducao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fichaproducaoid == null) ? 0 : fichaproducaoid.hashCode());
		result = prime * result + ((sequenciaproblemaproducao == null) ? 0 : sequenciaproblemaproducao.hashCode());
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
		ProblemaProducaoId other = (ProblemaProducaoId) obj;
		if (fichaproducaoid == null) {
			if (other.fichaproducaoid != null)
				return false;
		} else if (!fichaproducaoid.equals(other.fichaproducaoid))
			return false;
		if (sequenciaproblemaproducao == null) {
			if (other.sequenciaproblemaproducao != null)
				return false;
		} else if (!sequenciaproblemaproducao.equals(other.sequenciaproblemaproducao))
			return false;
		return true;
	}



}
