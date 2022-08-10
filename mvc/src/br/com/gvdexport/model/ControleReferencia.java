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
import javax.persistence.Index;
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
@Table(name="ControleReferencia",uniqueConstraints= {@UniqueConstraint(columnNames= {"core_fabr_fk","core_lire_fk"},name="core_fabr_lire_uk")}
										  ,indexes= {@Index(columnList="core_lire_fk",name="core_lire_ifk",unique=false)
										            ,@Index(columnList="core_fabr_fk",name="core_fabr_ifk",unique=false)})
@Getter @Setter
@EqualsAndHashCode
public class ControleReferencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO ,generator = "controlereferenciaseq")
	@SequenceGenerator(name= "controlereferenciaseq",sequenceName = "s_controlereferencia", allocationSize = 1)
	@Column(name="ctrlref_pk",updatable=false,nullable=false)
	private Long controlereferenciaid;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date reuniaotecnica;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date prevpartecnico;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date previsaoconf;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date prevescala;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date prevtesteproducao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date previsaocorte;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date avalproducao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date testedecampo;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date toplinereceb;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date rasgreceb;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date campodevolucao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date partecnico;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date partecnico1;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date partecnico2;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date partecnico3;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date partecnico4;

	@Column(length=180,nullable=false)
	private String comentreuniao;
	
	@Column(length=1440,nullable=false)
	private String partecnamostras;
	
	@Column(length=540,nullable=false)
	private String obstecnicas;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataescala;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataproducao;
	
	@Column(length=3,nullable=true)
	private String trilho;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao toplinena;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao rasgamentona;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private Mercado mercado;
	
	//Livro Referencia
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="core_lire_fk",referencedColumnName="lire_pk",nullable=false,foreignKey=@ForeignKey(name="core_lire_fk"))
	private LivroReferencia livroreferencia;
	
	//Fabrica
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="core_fabr_fk",referencedColumnName="fabr_pk",nullable=false,foreignKey=@ForeignKey(name="core_fabr_fk"))
	private Fabrica fabrica;
	
	
	


	











	
	


}
