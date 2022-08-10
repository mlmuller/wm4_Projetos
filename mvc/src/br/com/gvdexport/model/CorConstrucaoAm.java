package br.com.gvdexport.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CorSoladoAmostra",uniqueConstraints= {@UniqueConstraint(columnNames={"amostra","coramostra"},name="UK_CorSolado_CorAmostra")})
@Getter @Setter
public class CorConstrucaoAm implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "amoscorconsSeq")
	@SequenceGenerator(name = "amoscorconsSeq", sequenceName = "s_amocorcons", allocationSize = 1)
	@Column(name="idcorconstrucaoamostra",updatable=false,nullable=false)
	private Long id;

	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacoramostra;

	@Column(length=20,nullable=true)
	private String solalaminada;
	
	@Column(length=20,nullable=true)
	private String solainjetada;
	
	@Column(length=20,nullable=true)
	private String entressola;
	
	@Column(length=20,nullable=true)
	private String vira1;
	
	@Column(length=20,nullable=true)
	private String vira2;
	
	@Column(length=20,nullable=true)
	private String tipobeira;
	
	@Column(length=20,nullable=true)
	private String salto;
	
	@Column(length=20,nullable=true)
	private String tacao;
	
	@Column(length=20,nullable=true)
	private String plataforma;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;

	@Column(nullable = false)
	private LocalDateTime dataStamp;

	@Column(length=20,nullable=true)
	private String carimbosola;
	
	@Column(length=20,nullable=true)
	private String descricao1;
	
	@Column(length=20,nullable=true)
	private String descricao2;
	
	@Column(length=20,nullable=true)
	private String descricao3;
	
	@Column(length=20,nullable=true)
	private String descricao4;
	
	@Column(length=20,nullable=true)
	private String palmilhamontagem;

	//Cor Amostra - chave composta
	@ManyToOne(optional = false)
	@JoinColumn(name="coramostra",referencedColumnName="amosCor_Pk",foreignKey=@ForeignKey(name="FK_CorSolado_CorAmostra"))
	private CorAmostra coramostra;

	@ManyToOne(optional = false)
	@JoinColumn(name="amostra",referencedColumnName="amos_pk",foreignKey=@ForeignKey(name="FK_Solado_Amostra"))
	private Amostra amostra;

	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amostra == null) ? 0 : amostra.hashCode());
		result = prime * result + ((coramostra == null) ? 0 : coramostra.hashCode());
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
		CorConstrucaoAm other = (CorConstrucaoAm) obj;
		if (amostra == null) {
			if (other.amostra != null)
				return false;
		} else if (!amostra.equals(other.amostra))
			return false;
		if (coramostra == null) {
			if (other.coramostra != null)
				return false;
		} else if (!coramostra.equals(other.coramostra))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CorConstrucaoAm [id=" + id + "]";
	}

}
