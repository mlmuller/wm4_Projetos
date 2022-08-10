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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode(of="personagemid")
@Table(name="Personagem")
public class Personagem implements  Serializable,Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "personagemSeq")
	@SequenceGenerator(name = "personagemSeq", sequenceName = "s_personagem", allocationSize = 1)
	@Column(name="pers_pk",updatable=false,nullable=false)
	private Long personagemid;
	
	@Column(length = 30 , nullable = false)
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

	@Override
	public String toString() {
		return "Personagem [personagemid=" + personagemid + "]";
	}

}
