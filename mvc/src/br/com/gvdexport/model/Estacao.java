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
@Table(name="Estacao",uniqueConstraints=@UniqueConstraint(columnNames="nome",name="esta_nome_uk"))
@Getter @Setter
@EqualsAndHashCode
public class Estacao implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "estacaoSeq")
	@SequenceGenerator(name = "estacaoSeq", sequenceName = "s_estacao", allocationSize = 1)
	@Column(name="esta_pk",updatable=false,nullable=false)
	private Long estacaoid;
	
	@Column(length=4,nullable=false)
	private String nome;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date inicioestacao;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date fimestacao;

	@Enumerated(EnumType.STRING) //A,tivo, I,nativo
	@Column(nullable = false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//A/W-08
	@Column(length=6,nullable=true)
	private String siglainglesa;
	// Inverno/2008
	@Column(length=15,nullable=true)
	private String nomeport;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getEstacaoid());
	}
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
	
}
