package br.com.gvdexport.model;

import java.io.Serializable;
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

import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Table(name="Catalogo",uniqueConstraints= {@UniqueConstraint(columnNames= {"mercado","numerocatalogo"},name="cata_mernrc_uk")})
@Getter @Setter
@EqualsAndHashCode
public class Catalogo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "catalogoSeq")
	@SequenceGenerator(name = "catalogoSeq", sequenceName = "s_catalogo", allocationSize = 1)
	@Column(name="catalogo_pk",updatable=false,nullable = false)
	private Long catalogoid;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Mercado mercado;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datacatalogo;
	
	@Column(length = 100, nullable = true)
	private String nome;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=500,nullable=true)
	private String texto;
	
	@Column(length=10,nullable=false)
	private Integer numerocatalogo;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private SituacaoCatalogo situacaocatalogo=SituacaoCatalogo.N;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoFrete tipofrete;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoFrete tipofrete2;


	@Column(length=240,nullable=true)
	private String formularecosto;
	
	//Chaves Estrangeiras
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cata_clie_fk",referencedColumnName="clie_pk",nullable=true,foreignKey=@ForeignKey(name="cata_clie_fk"))
	private Cliente cliente;
	
	//Estacao
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cata_esta_fk",referencedColumnName="esta_pk",nullable=true,foreignKey=@ForeignKey(name="cata_esta_fk"))
	private Estacao estacao;
	
	//Moeda
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cata_moed_fk",referencedColumnName="moed_pk",nullable=true,foreignKey=@ForeignKey(name="cata_moed_fk"))
	private Moeda moeda;

	//moeda - Fob
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cata_moefob_fk",referencedColumnName="moed_pk",nullable=true,foreignKey=@ForeignKey(name="cata_moefob_fk"))
	private Moeda moedafob;

	//moeda - PVP
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cata_moepvp_fk",referencedColumnName="moed_pk",nullable=true,foreignKey=@ForeignKey(name="cata_moepvp_fk"))
	private Moeda moedapvp;

}
