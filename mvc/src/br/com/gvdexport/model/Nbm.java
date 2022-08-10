package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="NBM",uniqueConstraints= {@UniqueConstraint(columnNames="nbm",name="nbm_codigo_uk")
									 ,@UniqueConstraint(columnNames="descricao",name="nbm_desc_uk")})
@Getter @Setter
@EqualsAndHashCode
public class Nbm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nbmSeq")
	@SequenceGenerator(name = "nbmSeq", sequenceName = "s_nbm", allocationSize = 1)
	@Column(name="nbm_pk",updatable=false,nullable=false)
	private Long nbmid;

	@Column(length=12,nullable=false)
	private String nbm;
	
	@Column(length=40,nullable=false)
	private String descricao;
	
	@Column(length=12,nullable=true)
	private String nala;
	
	@Column(precision=5,scale=2,nullable=true)
	private BigDecimal percentualipi;
	
	@Column(length = 10, nullable = true)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date datastamp;
	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getNbmid());
	}


}
