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
@Table(name="ContratoFabrica",uniqueConstraints=@UniqueConstraint(columnNames="abreviacao",name="confab_abrev_uk"))
@Getter @Setter
@EqualsAndHashCode
public class ContratoFabrica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "contratofabricaSeq")
	@SequenceGenerator(name = "contratofabricaSeq", sequenceName = "s_contratofabrica", allocationSize = 1)
	@Column(name="contratofabrica_pk",updatable=false,nullable=false)
	private Long contratofabricaid;

	@Column(length=5,nullable=false)
	private String abreviacao;
	
	@Column(length=40,nullable=false)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Column(length=4000,nullable=false)
	private String texto;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

}
