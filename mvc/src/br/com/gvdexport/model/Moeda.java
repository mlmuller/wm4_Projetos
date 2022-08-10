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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Moeda",uniqueConstraints= {@UniqueConstraint(columnNames="sigla",name="moed_sigla_uk")
										,@UniqueConstraint(columnNames="descricao",name="moed_descricao_uk")})
@Getter @Setter
@EqualsAndHashCode
public class Moeda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "moedaSeq")
	@SequenceGenerator(name = "moedaSeq", sequenceName = "s_moeda", allocationSize = 1)
	@Column(name="moed_pk",updatable=false,nullable=false)
	private Long moedaid;

	@Column(length=10,nullable=false)
	private String sigla;
	
	@Column(length=20, nullable=false)
	private String descricao;
	
	@Enumerated(EnumType.STRING) //(S , N)
	@Column(length=1,nullable=true)
	private SimNao moedamovimento;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=3,nullable=true)
	private Integer codigomoeda;
	
	@Transient
	@Column(length=1,nullable=true)
	private Boolean janeiro;

	@Transient
	@Column(length=1,nullable=true)
	private Boolean fevereiro;
	
	@Transient
	@Column(length=1,nullable=true)
	private Boolean marco;
	
	@Transient
	@Column(length=1,nullable=true)
	private Boolean abril;
	
	@Transient
	@Column(length=1,nullable=true)
	private Boolean maio;

	@Transient
	@Column(length=1,nullable=true)
	private Boolean junho;
	
	@Transient
	@Column(length=1,nullable=true)
	private Boolean julho;
	

	@Transient
	@Column(length=1,nullable=true)
	private Boolean agosto;
	
	@Transient
	@Column(length=1,nullable=true)
	private Boolean setembro;
	
	@Transient
	@Column(length=1,nullable=true)
	private Boolean outubro;
	
	@Transient
	@Column(length=1,nullable=true)
	private Boolean novembro;
	
	@Transient
	@Column(length=1,nullable=true)
	private Boolean dezembro;
	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getMoedaid());
	}
}
