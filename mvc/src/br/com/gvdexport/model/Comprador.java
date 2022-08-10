package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Comprador",uniqueConstraints=@UniqueConstraint(columnNames="sucinto",name="cmpr_sucinto_uk")
						 ,indexes=@Index(unique=false,columnList="compradormatrizid",name="cmpr_cmpr_ifk"))
@Getter @Setter
@EqualsAndHashCode

public class Comprador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "compradorSeq")
	@SequenceGenerator(name = "compradorSeq", sequenceName = "s_comprador", allocationSize = 1)
	@Column(name="cmpr_pk",updatable=false,nullable=false)
	private Long compradorid;
	
	@Column(length = 20,nullable = true)
	private Long compradormatrizid;
	
	@Column(length=50,nullable=false)
	private String nome;
	
	@Column(length=30,nullable=false)
	private String sucinto;
	
	@Enumerated(EnumType.STRING) //A,I
	@Column(length=1,nullable=false)
	private Situacao situacao;

	@Column(length=6,precision=3,nullable=true)
	private BigDecimal iva;

	@Column(length=6,precision=3,nullable=true)
	private BigDecimal re;
	
	@Enumerated(EnumType.STRING) //S,N
	@Column(length=1,nullable=true)
	private SimNao possuiiva;

	@Enumerated(EnumType.STRING) //S,N
	@Column(length=1,nullable=true)
	private SimNao possuire;
	
	@Column(length=20,nullable=true)
	private String vat;

	//
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cmpr_clie_fk",referencedColumnName="clie_pk",nullable=true,foreignKey=@ForeignKey(name="cmpr_clie_fk"))
	private Cliente clientes;
	
	//
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cmpr_cmpr_fk",referencedColumnName="cmpr_pk",nullable=true,foreignKey=@ForeignKey(name="cmpr_cmpr_fk"))
	private Comprador compradores;

	//
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cmpr_cong_fk",referencedColumnName="cong_pk",nullable=true,foreignKey=@ForeignKey(name="cmpr_cong_fk"))
	private Consignatario consignatarios;
	
	//
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cmpr_noti_fk",referencedColumnName="noti_pk",nullable=true,foreignKey=@ForeignKey(name="cmpr_noti_fk"))
	private Notificar notifcar;
	
	//
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cmpr_vend_fk",referencedColumnName="vend_pk",nullable=true,foreignKey=@ForeignKey(name="cmpr_vend_fk"))
	private Vendedor vendedores;

	
	
	

	
}
