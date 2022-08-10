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
@Table(name="Hts",uniqueConstraints=@UniqueConstraint(columnNames="hts",name="hts_codigo_uk"))
@Getter @Setter
@EqualsAndHashCode
public class Hts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "htsSeq")
	@SequenceGenerator(name = "htsSeq", sequenceName = "s_hts", allocationSize = 1)
	@Column(name="hts_pk",updatable=false,nullable=false)
	private Long htsid;
	
	@Column(length=15,nullable=false)
	private String hts;
	
	@Column(length=40,nullable=false)
	private String descricao;
	
	@Column(length=5,precision=2,nullable=true)
	private BigDecimal duty;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getHtsid());
	}

}
