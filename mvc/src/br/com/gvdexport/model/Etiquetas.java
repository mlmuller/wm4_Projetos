package br.com.gvdexport.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Etiquetas")

@Getter @Setter
@EqualsAndHashCode
public class Etiquetas implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etiquetaSeq")
	@SequenceGenerator(name = "etiquetaSeq", sequenceName = "s_etiqueta", allocationSize = 1)
	@Column(name="etiqueta_pk",updatable=false,nullable=false)
	private Long idetiqueta;
	
	@Column(nullable=true)
	private Boolean escolha;
	
	@Column(name = "aprovacao", nullable = true)
	private LocalDate aprovacao;
	
	@Column(name = "inclusao", nullable = true)
	private LocalDate inclusao;

	@Column(length=32, nullable = true)
	private String material;

	@Column(length=32, nullable = true)
	private String materialb;


	@Column(name = "espessura",length = 15, nullable = true)
	private String espessura;
	
	@Column(length = 35, nullable = true)
	private String cor;
	
	@Column(length = 28, nullable = true)
	private String cora;

	@Column(name = "referencia", length = 45 , nullable = true)
	private String referencia;
	
	@Column(length = 28 , nullable = true)
	private String fase;
	
	@Column(length = 32, nullable = true)
	private String stylename1;

	@Column(length = 32 , nullable = true)
	private String stylename2;
	
	@Column(name = "construcao", length = 15 , nullable = true)
	private String construcao;

	@Column(name = "forma", length = 12 , nullable = true)
	private String forma;
	
	@Column(name = "toque", length = 5 , nullable = true)
	private String toque;
	
	@Column(name = "obs_1",length = 45 , nullable = true )
	private String obs1;
	
	@Column(name = "obs_2",length = 45, nullable = true)
	private String obs2;

	@Column(name = "code_customer",length = 25, nullable = true)
	private String codecustomer;
	
	@Column(name = "copias", length = 5, nullable = false)
	private Integer copias;
	
	@Column(name = "fabricanome", length = 50, nullable = true)
	private String fabricanome;
	
	@Column(name = "fabricasucinto",length = 25, nullable = true)
	private String fabricasucinto;
	
	@Column(name = "fabricaendereco",length = 50 , nullable = true)
	private String fabricaendereco;
	
	@Column(length = 30, nullable = true)
	private String clientenome;
	
	@Column(name = "clientesucinto",length = 25, nullable = true)
	private String clientesucinto;
	
	@Column(name = "fabricacidade",length = 30 , nullable = true)
	private String fabricacidade;
	
	@Transient
	@Column(name ="vazio1",length = 1, nullable = true)
	private Character vazio1;

	@Transient
	@Column(name ="vazio2",length = 1, nullable = true)
	private Character vazio2;
	@Transient
	@Column(name ="vazio3",length = 1, nullable = true)
	private Character vazio3;
	@Transient
	@Column(name ="vazio4",length = 1, nullable = true)
	private Character vazio4;
	@Transient
	@Column(name ="vazio5",length = 1, nullable = true)
	private Character vazio5;
	@Transient
	@Column(name ="vazio6",length = 1, nullable = true)
	private Character vazio6;
	@Transient
	@Column(name ="vazio7",length = 1, nullable = true)
	private Character vazio7;
	@Transient
	@Column(name ="vazio8",length = 1, nullable = true)
	private Character vazio8;

	//Clientes
	@ManyToOne(optional = false)
	@JoinColumn(name="cliente",foreignKey=@ForeignKey(name="etq_clie_fk"))
	private Cliente cliente;

	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getIdetiqueta());
	}


}
