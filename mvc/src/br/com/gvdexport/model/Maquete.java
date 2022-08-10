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
@Table(name="Maquete",indexes= {@Index(columnList="maqu_clie_fk",name="maqu_clie_ifk",unique=false)
								,@Index(columnList="maqu_comp_fk",name="maqu_comp_ifk",unique=false)
								,@Index(columnList="maqu_deac_fk",name="maqu_deac_ifk",unique=false)
								,@Index(columnList="maqu_fabr_fk",name="maqu_fabr_ifk",unique=false)
								,@Index(columnList="maqu_lire_fk",name="maqu_lire_ifk",unique=false)})
@Getter @Setter
@EqualsAndHashCode

public class Maquete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "maqueteSeq")
	@SequenceGenerator(name = "maqueteSeq", sequenceName = "s_maquete", allocationSize = 1)
	@Column(name="maqu_pk",updatable=false,nullable=false)
	private Long maqueteid;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Mercado mercado;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date dtentrega;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date dtsolicitacao;

	@Column(precision=5,scale=1,nullable=false)
	private BigDecimal par;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtxfct;

	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal parcancelado;
	
	@Column(length=400,nullable=true)
	private String obs;

	@Column(length=60,nullable=true)
	private String complementosolado;

	@Column(length=60,nullable=true)
	private String obssolado;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date dtliberacaoproducao;

	@Column(length=14,nullable=true)
	private String referenciamaquete;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private PrioridadeProducao prioridadeproducao;
	
	//Fabricas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="maqu_fabr_fk",referencedColumnName="fabr_pk",nullable=false,foreignKey=@ForeignKey(name="maqu_fabr_fk"))
	private Fabrica fabrica;
	
	//Componentes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="maqu_comp_fk",referencedColumnName="comp_pk",nullable=false,foreignKey=@ForeignKey(name="maqu_comp_fk"))
	private Componente componente;

	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="maqu_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="maqu_clie_fk"))
	private Cliente cliente;

	//Livros Referencias
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="maqu_lire_fk",referencedColumnName="lire_pk",nullable=false,foreignKey=@ForeignKey(name="maqu_lire_fk"))
	private LivroReferencia livrosreferencia;

	//Destinos Am Cf
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="maqu_deac_fk",referencedColumnName="deac_pk",nullable=true,foreignKey=@ForeignKey(name="maqu_deac_fk"))
	private DestinoAmCf destinoamcf;

}
