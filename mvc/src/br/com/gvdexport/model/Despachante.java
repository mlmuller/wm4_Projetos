package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Despachante",uniqueConstraints= {@UniqueConstraint(columnNames="nome",name="desp_nome_uk")
											  ,@UniqueConstraint(columnNames="sucinto",name="desp_suci_uk")})
@Getter @Setter
@EqualsAndHashCode(of="despachanteid")
public class Despachante implements Serializable,Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "despachanteSeq")
	@SequenceGenerator(name = "despachanteSeq", sequenceName = "s_despachante", allocationSize = 1)
	@Column(name="desp_pk",updatable=false,nullable=false)
	private Long despachanteid;

	@Column(length = 40 , nullable = false)
	private String nome;
	
	@Column(length = 20 , nullable = false)
	private String sucinto;
	
	@Column(length = 40 , nullable = true)
	private String endereco;

	@Column(length = 20 , nullable = true)
	private String cidade;
	
	@Column(length = 20 , nullable = true)
	private String uf;
	
	@Column(length = 9 , nullable = true)
	private String cep;
	
	@Column(length = 20 , nullable = true)
	private String cgc;
	
	@Column(length = 20 , nullable = true)
	private String inscricaoestadual;
	
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1 , nullable = false)
	private Situacao situacao;
	
	@Column(precision = 10,scale=4 , nullable = true)
	private BigDecimal valorporcaminhao;
	
	@Column(precision = 10,scale=4, nullable = true)
	private String valorpordde;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	//adicionado nao existe no Oracle
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "desp_cida_fk", referencedColumnName = "cida_pk", nullable = true, foreignKey=@ForeignKey(name="desp_cida_fk"))
	private Cidade cidades;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getDespachanteid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
	
}
