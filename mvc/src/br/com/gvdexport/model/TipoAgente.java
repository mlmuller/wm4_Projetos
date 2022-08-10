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
@Table(name="TipoAgente",uniqueConstraints={@UniqueConstraint(columnNames="nome",name="tiag_nome_uk")
										   ,@UniqueConstraint(columnNames="sucinto",name="tiag_sucinto_uk")})
@Getter @Setter
@EqualsAndHashCode

public class TipoAgente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tipoagenteSeq")
	@SequenceGenerator(name = "tipoagenteSeq", sequenceName = "s_tipoagente", allocationSize = 1)
	@Column(name="tipoagente_pk",updatable=false,nullable=false)
	private Long tipoagenteid;
	
	@Column(length=40,nullable=false)
	private String nome;
	
	@Column(length=15,nullable=false)
	private String sucinto;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

}
