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
@Table(name="Consignatario",uniqueConstraints=@UniqueConstraint(columnNames="nome",name="cong_nome_uk"))
@Getter @Setter
@EqualsAndHashCode
public class Consignatario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "consignatarioSeq")
	@SequenceGenerator(name = "consignatarioSeq", sequenceName = "s_consignatario", allocationSize = 1)
	@Column(name="cong_pk",updatable=false,nullable=false)
	private Long consignatarioid;

	@Column(length=50,nullable = false)
	private String nome;
	
	@Column(length=500, nullable = true)
	private String endereco;
	
	@Enumerated(EnumType.STRING) //(A tivo, I nativo)
	@Column(length=1,nullable = true)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

}
