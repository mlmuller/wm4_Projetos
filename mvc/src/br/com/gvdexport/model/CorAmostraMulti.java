package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "CorAmostraMulti",uniqueConstraints = {@UniqueConstraint(columnNames={"amostra","corAmostra","sequenciaPosicao"},name="cor_multi_uk")}
							   ,indexes= {@Index(unique=false,name="amos_cormulti_i",columnList="amostra,corAmostra,sequenciaPosicao")})

@Getter @Setter
public class CorAmostraMulti implements Serializable,Cloneable, Comparable<CorAmostraMulti>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "corMultiSeq")
	@SequenceGenerator(name = "corMultiSeq", sequenceName = "s_corMulti", allocationSize = 1)
	@Column(name="corMulti_pk",updatable=false,nullable=false)
	private Long cormultiid;

	@Column(length = 2, nullable = true, columnDefinition = "smallint")
	private Integer sequenciaPosicao;

	@Column(length = 7 , nullable = true)
	private String completaMaterial;
	
	@Column(length = 15, nullable = true)
	private String matNome;
	
	@Column(length = 15 , nullable = true)
	private String corNome;
	
	@Column(length = 10, nullable = true)
	private String completaCor;
	
	@Column(length = 1 , nullable = true)
	private Boolean corPrincipal;
	
	@Column(length = 1, columnDefinition = "smallint")
	private Integer seqMaterial;
	
	@Column(length = 1, columnDefinition = "smallint")
	private Integer seqCor;

	@Column(length = 1, columnDefinition = "smallint",nullable = false)
	private Integer seqCorAmostra;
	
	@Transient
	@Column(length = 1,nullable = true)
	private String status;
	
	// Tabela de Cores
	@ManyToOne(optional = true)
	@JoinColumn(name = "cor", foreignKey = @ForeignKey(name = "comu_cor_fk"))
	private Cor cor;
	
	// Tabela de Materiais
	@ManyToOne(optional = true)
	@JoinColumn(name = "material", foreignKey = @ForeignKey(name = "comu_mate_fk"))
	private Material material;

	
	// Amostras Novas
	@ManyToOne(optional = true)
	@JoinColumn(name = "amostra", foreignKey = @ForeignKey(name = "coam_amos_fk"))
	private Amostra amostra;


	// Cor Amostras Novas 
	@ManyToOne(optional = true)
	@JoinColumn(name = "corAmostra", foreignKey = @ForeignKey(name = "comu_coam_fk"))
	private CorAmostra corAmostra;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cormultiid == null) ? 0 : cormultiid.hashCode());
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
		CorAmostraMulti other = (CorAmostraMulti) obj;
		if (cormultiid == null) {
			if (other.cormultiid != null)
				return false;
		} else if (!cormultiid.equals(other.cormultiid))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CorAmostraMulti [cormultiid=" + cormultiid + "]";
	}

	@Override
	public int compareTo(CorAmostraMulti outra) {
		return Comparator.comparing(CorAmostraMulti::getSeqCor)
				.thenComparing(CorAmostraMulti::getCompletaCor)
				.compare(this,outra);
			
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public CorAmostraMulti(Integer seqCor,String completaMaterial) {
		this.seqCor = seqCor;
		this.completaMaterial = completaMaterial;
	}
	

	public CorAmostraMulti() {
		
	}

}
