package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="TipoCalcado",uniqueConstraints=@UniqueConstraint(columnNames="nomeport",name="tica_nomeport_uk"))
@Getter @Setter
@EqualsAndHashCode

public class TipoCalcado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8996336937494818298L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tipocalcadoSeq")
	@SequenceGenerator(name = "tipocalcadoSeq", sequenceName = "s_tipocalcado", allocationSize = 1)
	@Column(name="tica_pk",updatable=false,nullable=false)
	private Long tipocalcadoid;
	
	@Column(length=45,nullable=false)
	private String nomeport;
	
	@Column(length=45,nullable=true)
	private String nomeingles;
	
	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal taxafrete;
	
	@Column(precision=10,scale=4, nullable=true)
	private BigDecimal pramostracli;
	
	@Enumerated(EnumType.STRING) //Ativo/Inativo
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Enumerated(EnumType.STRING) //Alfabeto para identificar ,Sandalia=D,Sapato Masculino=U....cg_ref_codes
	@Column(length=1,nullable=false)
	private IdentificaCalcado identificacalcado;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getTipocalcadoid());
	}

}
