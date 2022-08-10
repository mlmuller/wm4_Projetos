package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="Regiao",uniqueConstraints=@UniqueConstraint(columnNames= {"nome"},name="regi_uk"))
@Getter @Setter
@EqualsAndHashCode
public class Regiao implements Serializable,Cloneable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "regiaoSeq")
	@SequenceGenerator(name = "regiaoSeq", sequenceName = "s_regiao", allocationSize = 1)
	@Column(name="regi_pk",updatable=false,nullable=false)
	private Long regiaoid;
	
	@Column(length = 50, nullable =false)
	private String nome;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
	
}
