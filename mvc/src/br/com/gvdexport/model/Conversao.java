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
@Table(name="Conversao",uniqueConstraints= {@UniqueConstraint(columnNames="nome",name="conv_nome_uk")
})
@Getter @Setter
@EqualsAndHashCode
public class Conversao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "conversaoSeq")
	@SequenceGenerator(name = "conversaoSeq", sequenceName = "s_conversao", allocationSize = 1)
	@Column(name="conv_pk",updatable=false,nullable=false)
	private Long conversaoid;
	
	@Column(length = 35, nullable=false)
	private String nome;
	
	@Column(length = 15, nullable=true)
	private String nomeespecial;
	
	@Column(length = 15, nullable=true)
	private String nomesucinto;
	
	@Column(length = 5, nullable=true)
	private String nomeabreviado;
	
	@Enumerated(EnumType.STRING) //Ativo,Inativo
	@Column(length=1,nullable=false)
	private Genero genero;
	

	@Enumerated(EnumType.STRING) //Ativo,Inativo
	@Column(length=1,nullable=true)
	private PadraoEspecial padraoespecial;
	
	@Enumerated(EnumType.STRING) //Ativo,Inativo
	@Column(length=1,nullable=false)
	private TipoSize tiposize;

	@Column(length=5, nullable=true)
	private String t1;
	
	@Column(length=5, nullable=true)
	private String t2;

	@Column(length=5, nullable=true)
	private String t3;
	
	@Column(length=5, nullable=true)
	private String t4;

	@Column(length=5, nullable=true)
	private String t5;

	@Column(length=5, nullable=true)
	private String t6;

	@Column(length=5, nullable=true)
	private String t7;

	@Column(length=5, nullable=true)
	private String t8;

	@Column(length=5, nullable=true)
	private String t9;

	@Column(length=5, nullable=true)
	private String t10;

	@Column(length=5, nullable=true)
	private String t11;

	@Column(length=5, nullable=true)
	private String t12;

	@Column(length=5, nullable=true)
	private String t13;

	@Column(length=5, nullable=true)
	private String t14;

	@Column(length=5, nullable=true)
	private String t15;

	@Column(length=5, nullable=true)
	private String t16;

	@Column(length=5, nullable=true)
	private String t17;

	@Column(length=5, nullable=true)
	private String t18;

	@Column(length=5, nullable=true)
	private String t19;

	@Column(length=5, nullable=true)
	private String t20;

	@Column(length = 10, nullable = true)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date datastamp;

	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getConversaoid());
	}

}
