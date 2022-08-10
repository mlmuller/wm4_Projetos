package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class AutorizacaoReimpressaoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false)
	private Long autorizacaoreimpressaoid;
	
	@Column(precision=6,nullable=false)
	private Long sequencia;

	public Long getAutorizacaoreimpressaoid() {
		return autorizacaoreimpressaoid;
	}

	public void setAutorizacaoreimpressaoid(Long autorizacaoreimpressaoid) {
		this.autorizacaoreimpressaoid = autorizacaoreimpressaoid;
	}

	public Long getSequencia() {
		return sequencia;
	}

	public void setSequencia(Long sequencia) {
		this.sequencia = sequencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autorizacaoreimpressaoid == null) ? 0 : autorizacaoreimpressaoid.hashCode());
		result = prime * result + ((sequencia == null) ? 0 : sequencia.hashCode());
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
		AutorizacaoReimpressaoId other = (AutorizacaoReimpressaoId) obj;
		if (autorizacaoreimpressaoid == null) {
			if (other.autorizacaoreimpressaoid != null)
				return false;
		} else if (!autorizacaoreimpressaoid.equals(other.autorizacaoreimpressaoid))
			return false;
		if (sequencia == null) {
			if (other.sequencia != null)
				return false;
		} else if (!sequencia.equals(other.sequencia))
			return false;
		return true;
	}

	
}
