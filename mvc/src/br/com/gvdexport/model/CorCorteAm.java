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
@Table(name="CorCorteAm",uniqueConstraints={@UniqueConstraint(columnNames={"amostra","coramostra"},name="UK_CorCorte_CorAmostra")})
@Getter @Setter
public class CorCorteAm implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "amoscorcorteSeq")
	@SequenceGenerator(name = "amoscorcorteSeq", sequenceName = "s_amoscorcorte", allocationSize = 1)
	@Column(name="idcorcorteamostra",updatable=false,nullable=false)
	private Long id;

	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacoramostra;

	@Column(length=20,nullable=true)
	private String forrogaspea;

	@Column(length=20,nullable=true)
	private String forrogaspeacomplemento;
	
	@Column(length=20,nullable=true)
	private String forrotraseiro;
	
	@Column(length=20,nullable=true)
	private String forrotraseirocomplemento;

	@Column(length=20,nullable=true)
	private String dublagemforro;
	
	@Column(length=20,nullable=true)
	private String palmilhainterna;
	
	@Column(length=20,nullable=true)
	private String avesso;
	
	@Column(length=20,nullable=true)
	private String carimboetiqueta;
	
	@Column(length=20,nullable=true)
	private String reforcopalmilha;
	
	@Column(length=20,nullable=true)
	private String dublagema;

	@Column(length=20,nullable=true)
	private String dublagemb;
	
	@Column(length=20,nullable=true)
	private String descricao1;
	
	@Column(length=20,nullable=true)
	private String descricao2;
	
	@Column(length=20,nullable=true)
	private String descricao3;
	
	@Column(length=20,nullable=true)
	private String palmilhainternacomplemento;
	
	@Column(length=20,nullable=true)
	private String espuma;
	
	@Column(length=20,nullable=true)
	private String debrumpalmilha;
	
	@Column(length=20,nullable=true)
	private String contraforte;
	
	@Column(length=20,nullable=true)
	private String contraforte2;
	
	@Column(length=20,nullable=true)
	private String couraca;
	
	@Column(length=20,nullable=true)
	private String couraca2;
	
	@Column(length=20,nullable=true)
	private String cortecomplemento;

	@Column(length = 10, nullable = false)
	private String usuariostamp;

	@Column(nullable = false)
	private LocalDateTime datastamp;

	//Cor Amostra - chave composta
	@ManyToOne(optional = false)
	@JoinColumn(name="coramostra",referencedColumnName="amosCor_Pk",foreignKey=@ForeignKey(name="FK_CorCorte_CorAmostra"))
	private CorAmostra coramostra;

	@ManyToOne(optional = false)
	@JoinColumn(name="amostra",referencedColumnName="amos_pk",foreignKey=@ForeignKey(name="FK_Corte_Amostra"))
	private Amostra amostra;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getId());
	}
	
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
		CorCorteAm other = (CorCorteAm) obj;
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


}
