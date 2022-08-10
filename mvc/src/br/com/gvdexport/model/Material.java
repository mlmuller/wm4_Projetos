package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Material",uniqueConstraints=@UniqueConstraint(columnNames="nome",name="mate_nome_uk"))
@Getter @Setter
public class Material implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "materialSeq")
	@SequenceGenerator(name = "materialSeq", sequenceName = "s_material", allocationSize = 1)
	@Column(name="material_pk",updatable=false,nullable=false)
	private Long materialid;

	@Column(length=15,nullable=false)
	private String nome;
	
	@Column(length=7,nullable=false)
	private String resumido;

	@Enumerated(EnumType.STRING)
	@Column(length =1 , nullable=true)
	private Situacao situacao;

	@Column(length=15,nullable=true)
	private String nomeingles;

	@Column(length=15,nullable=true)
	private String nomeespanhol;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Transient
	@Column(length = 7 , nullable = true)
	private String completaMaterial;
	
	@Transient
	@Column(nullable = true)
	private Boolean verificado;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materialid == null) ? 0 : materialid.hashCode());
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
		Material other = (Material) obj;
		if (materialid == null) {
			if (other.materialid != null)
				return false;
		} else if (!materialid.equals(other.materialid))
			return false;
		return true;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Material [materialid=" + materialid + "]";
	}

	
	
}
