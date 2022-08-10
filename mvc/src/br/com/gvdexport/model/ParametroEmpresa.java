package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ParametroEmpresa",indexes= {@Index(columnList="empr_moenac_fk",unique=false,name="empr_moenac_ifk")
										,@Index(columnList="empr_moeda_fk",unique=false,name="empr_moeda_ifk")
										,@Index(columnList="empr_fabr_fk",unique=false,name="empr_fabr_ifk")})
@Getter @Setter
@EqualsAndHashCode
public class ParametroEmpresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "parametroempresaSeq")
	@SequenceGenerator(name = "parametroempresaSeq", sequenceName = "s_parametroempresa", allocationSize = 1)
	@Column(name="parametroempresa_pk",updatable=false,nullable=false)
	private Long parametroempresaid;
	
	@Column(length=4,nullable=true)
	private Integer anocorrente;
	
	@Column(length=4,nullable=true)
	private Integer prazodocbanco;
	
	@Column(precision=10,scale=6,nullable=true)
	private BigDecimal taxafrete;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtencerramentotrafego;

	@Column(precision=6,scale=3,nullable=true)
	private BigDecimal percdesagioslipfabrica;
	
	//Unidades,se necessario:4,0,1,2,3 - provavel unidades NL
	@Column(length=1,nullable=true)
	private String unidade;
	
	@Column(length=1,nullable=false)
	private Integer codigovalidacao;
	
	//chaves Estrangeiras
	
	//Livros Referencias
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="empr_lire_fk",referencedColumnName="lire_pk",nullable=true,foreignKey=@ForeignKey(name="empr_lire_fk"))
	private LivroReferencia livrosreferencia;
	
	//Estacao
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="empr_esta_fk",referencedColumnName="esta_pk",nullable=true,foreignKey=@ForeignKey(name="empr_esta_fk"))
	private Estacao estacao;
	
	//Componente
	//Clientes-para Numeracoes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="empr_comp_nume_fk",referencedColumnName="comp_pk",nullable=true,foreignKey=@ForeignKey(name="empr_comp_nume_fk"))
	private Componente componente;
	
	//Fabrica
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="empr_fabr_fk",referencedColumnName="fabr_pk",nullable=false,foreignKey=@ForeignKey(name="empr_fabr_fk"))
	private Fabrica fabricaatelier;

	//Moeda Nacional
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="empr_moenac_fk",referencedColumnName="moed_pk",nullable=true,foreignKey=@ForeignKey(name="empr_moenac_fk"))
	private Moeda moedanacional;
	
	//Moeda
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="empr_moeda_fk",referencedColumnName="moed_pk",nullable=true,foreignKey=@ForeignKey(name="empr_moeda_fk"))
	private Moeda moeda;

}
