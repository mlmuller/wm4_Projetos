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
@Table(name="PrazoPagamento",uniqueConstraints={@UniqueConstraint(columnNames="descricao",name="prpa_descricao_uk")
												  ,@UniqueConstraint(columnNames="prazo",name="prpa_prazo_uk")})
@Getter @Setter
@EqualsAndHashCode

public class PrazoPagamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pzpgtoSeq")
	@SequenceGenerator(name = "pzpgtoSeq", sequenceName = "s_pzpgto", allocationSize = 1)
	@Column(name="prpa_pk",updatable=false,nullable = false)
	private Long prazopagamentoid;

	@Column(length=20,nullable=true)
	private String descricao;
	
	@Column(length=3,nullable=true)
	private Integer prazo;
	
	@Enumerated(EnumType.STRING) //(A tivo, I nativo)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

}
