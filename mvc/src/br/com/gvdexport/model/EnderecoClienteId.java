package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;

public class EnderecoClienteId implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(precision=10,nullable=false,updatable = true)
	private Long grpcliinvid;
	
	@Column(nullable=false,updatable = true)
	private Integer sequenciaendereco;

	public Long getGrpcliinvid() {
		return grpcliinvid;
	}

	public void setGrpcliinvid(Long grpcliinvid) {
		this.grpcliinvid = grpcliinvid;
	}

	public Integer getSequenciaendereco() {
		return sequenciaendereco;
	}

	public void setSequenciaendereco(Integer sequenciaendereco) {
		this.sequenciaendereco = sequenciaendereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grpcliinvid == null) ? 0 : grpcliinvid.hashCode());
		result = prime * result + ((sequenciaendereco == null) ? 0 : sequenciaendereco.hashCode());
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
		EnderecoClienteId other = (EnderecoClienteId) obj;
		if (grpcliinvid == null) {
			if (other.grpcliinvid != null)
				return false;
		} else if (!grpcliinvid.equals(other.grpcliinvid))
			return false;
		if (sequenciaendereco == null) {
			if (other.sequenciaendereco != null)
				return false;
		} else if (!sequenciaendereco.equals(other.sequenciaendereco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnderecoClienteId [grpcliinvid=" + grpcliinvid + ", sequenciaendereco=" + sequenciaendereco + "]";
	}

	public EnderecoClienteId(Long grpcliinvid, Integer sequenciaendereco) {
		super();
		this.grpcliinvid = grpcliinvid;
		this.sequenciaendereco = sequenciaendereco;
	}

	public EnderecoClienteId() {
		super();
	}


}
