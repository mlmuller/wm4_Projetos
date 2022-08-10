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
@Table(name="Cor",uniqueConstraints=@UniqueConstraint(columnNames="nome",name="cor_nome_uk"))
@Getter @Setter

public class Cor implements Serializable,Cloneable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "corCadSeq")
	@SequenceGenerator(name = "corCadSeq", sequenceName = "s_corCad", allocationSize = 1)
	@Column(name="cor_pk",updatable=false,nullable=false)
	private Long corid;
	
	@Column(length=15,nullable=false)
	private String nome;

	@Column(length=7,nullable=true)
	private String resumido;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1 , nullable=true)
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
	@Column(length = 5, nullable = true)
	private String completaCor;
	
	@Transient
	@Column(length = 1 , nullable = true)
	private Boolean corPrincipal;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getCorid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corid == null) ? 0 : corid.hashCode());
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
		Cor other = (Cor) obj;
		if (corid == null) {
			if (other.corid != null)
				return false;
		} else if (!corid.equals(other.corid))
			return false;
		return true;
	}

}
