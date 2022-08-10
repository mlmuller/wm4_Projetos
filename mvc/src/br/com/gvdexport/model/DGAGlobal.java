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
@Table(name="DGAGlobal",uniqueConstraints=@UniqueConstraint(columnNames="parametro",name="dgaglo_param_uk"))

@Getter @Setter
@EqualsAndHashCode
public class DGAGlobal implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "dgaglobalSeq")
	@SequenceGenerator(name = "dgaglobalSeq", sequenceName = "s_dgaglobal", allocationSize = 1)
	@Column(name="dgaglobal_pk",updatable=false,nullable=false)
	private Long dgaglobalid;
	
	@Column(length=15,nullable=false)
	private String parametro;
	
	@Column(length=100,nullable=false)
	private String valor;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Column(length = 26 , nullable = true)
	private String grupocomponente;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getDgaglobalid());
	}

}
