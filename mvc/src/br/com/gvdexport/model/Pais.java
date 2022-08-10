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
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Pais",uniqueConstraints= {@UniqueConstraint(columnNames={"nome"},name="pais_nome_uk")
										,@UniqueConstraint(columnNames= {"sigla"},name="pais_sigl_uk")})
@Getter @Setter
@EqualsAndHashCode
public class Pais implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "paisSeq")
	@SequenceGenerator(name = "paisSeq", sequenceName = "s_pais", allocationSize = 1)
	@Column(name="pais_pk",updatable=false,nullable=false)
	private Long paisid;
	
	@Column(length = 20, nullable =false)
	private String nome;
	
	@Column(length = 3, nullable =false)
	private String sigla;
	
	@Column(length = 4, nullable =true)
	private Integer codigopais;
	
	@Column(length=1,nullable=false)
	private String grupopais;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Continentes continente;

	@Column(length=30,nullable=true)
	private String nomecontinente;
	
	@Column(length = 30, nullable =true)
	private String nomeingles;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getPaisid());
	}

}
