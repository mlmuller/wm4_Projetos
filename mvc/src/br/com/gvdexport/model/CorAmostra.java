package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name="CorAmostra", uniqueConstraints= {@UniqueConstraint(columnNames={"amostra","sequenciaCorAmostra"},name="amos_cor_uk")}
						,indexes= {@Index(unique=false,name="amo_cor_i",columnList="amostra,sequenciaCorAmostra")}) 
@Getter
@Setter
public class CorAmostra implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amosCorSeq")
	@SequenceGenerator(name = "amosCorSeq", sequenceName = "s_AmosCor", allocationSize = 1)
	@Column(name = "amosCor_Pk", updatable = false, nullable = false)
	private Long Id;

	@Column(nullable = false)
	private Long amostraId;

	@Column(length = 2, nullable = false, columnDefinition = "smallint")
	private Integer sequenciaCorAmostra;

	@Column(length = 70, nullable = false)
	private String cor;

	@Column(length = 15, nullable = false)
	private String corPrincipal;

	@Column(length = 60, nullable = false)
	private String material;

	@Column(length = 30 , nullable = true)
	private String obsMaterial;
	
	@Column(length = 5, nullable = true)
	private String linha;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private DireitoEsquerdo pe;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private TipoMaterial tipoMaterial;

	@Column(precision = 3, scale = 1, nullable = false)
	private BigDecimal totalPar;

	@Column(precision = 3, scale = 1, nullable = true)
	private BigDecimal parGvd;

	@Column(precision = 3, scale = 1, nullable = true)
	private BigDecimal parCancelado;

	@Column(length = 3, nullable = true)
	private String localizacao;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private SimNao desenvolveramostra = SimNao.S;

	@Column(length = 10, nullable = false)
	private String usuarioStamp;

	@Column(nullable = false)
	private LocalDateTime dataStamp;

	@Column(length = 6, nullable = true)
	private String sizeCor;

	@Column(length = 60, nullable = true)
	private String corEtiqueta;

	@Column(precision = 7, scale = 1, nullable = true)
	private String saldoParEtiqueta;

	@Column(precision = 7, scale = 1, nullable = true)
	private String saldoParInvoice;

	@Column(nullable = true)
	private Boolean producao;
	
	@Column(length = 7,nullable = true)
	private String marca;

	@Transient
	@Column(columnDefinition="boolean default true",nullable=true)
	private Boolean corselecao;

	
	// Cor Maquete
	@ManyToOne(optional = true)
	@JoinColumn(name = "corMaquete", foreignKey = @ForeignKey(name = "coma_amos_fk"))
	private CorMaquete corMaquete;

	// Amostras Novas
	@ManyToOne(optional = false)
	@JoinColumn(name = "amostra",foreignKey = @ForeignKey(name = "coam_amos_fk"))
	private Amostra amostra;
	
	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		CorAmostra other = (CorAmostra) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}


	
}
