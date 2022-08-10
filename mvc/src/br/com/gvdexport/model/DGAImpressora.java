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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="DGAImpressora")
@Getter @Setter
@EqualsAndHashCode
public class DGAImpressora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "dgaimpressoraSeq")
	@SequenceGenerator(name = "dgaimpressoraSeq", sequenceName = "s_dgaimpressora", allocationSize = 1)
	@Column(name="dgaimpressora_pk",updatable=false,nullable=false)
	private Long dgaimpressoraid;
	
	@Column(length=30,nullable=false)
	private String nome;
	
	@Column(length=40,nullable=false)
	private String caminho;
	
	@Column(length=1,nullable=false)
	private String tipo;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(precision=10,nullable=false)
	private Long id;
	

}
