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
@Table(name="Revisor",uniqueConstraints=@UniqueConstraint(columnNames="nome",name="revi_nome_uk"))
@Getter @Setter
@EqualsAndHashCode
public class Revisor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "revisoresSeq")
	@SequenceGenerator(name = "revisoresSeq", sequenceName = "s_revisores", allocationSize = 1)
	@Column(name="revi_pk",updatable=false,nullable=false)
	private Long revisorid;

	@Column(length=20,nullable=false)
	private String nome;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Enumerated(EnumType.STRING) // Ativo/Inativo
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

}
