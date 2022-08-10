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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Confirmacao",indexes= {@Index(columnList="liberado",name="conf_liberado_i",unique=false)
								   ,@Index(columnList="conf_clie_fk",name="conf_clie_ifk",unique=false)
								   ,@Index(columnList="conf_comp_nume_fk",name="conf_com_nume_ifk",unique=false)
								   ,@Index(columnList="conf_esta_fk",name="conf_esta_ifk",unique=false)
								   ,@Index(columnList="conf_fabr_fk",name="conf_fabr_ifk",unique=false)
								   ,@Index(columnList="conf_lire_fk",name="conf_lire_ifk",unique=false)
								   ,@Index(columnList="conf_macl_fk",name="conf_marcli_ifk",unique=false)
								   ,@Index(columnList="conf_raal_fk",name="conf_razcli_ifk",unique=false)
								   ,@Index(columnList="conf_comp_prod_fk",name="conf_com_prod_ifk",unique=false)
								   ,@Index(columnList="mercado,conf_fabr_fk,conf_lire_fk,reuniaotecnica,prevpartecnico,previsaoconf,prevescala,prevtesteproducao,previsaocorte",name="conf_datas_tecnicas_ifk",unique=false)
								   ,@Index(columnList="nroconfirmacaoold",name="conf_confold_iuk",unique=false)})
@Getter @Setter
public class Confirmacao implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "confirmacaoSeq")
	@SequenceGenerator(name = "confirmacaoSeq", sequenceName = "s_confirmacao", allocationSize = 1)
	@Column(name="confirmacao_pk",nullable=false)
	private Long confirmacaoid;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date dtentregaconfirmacao;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private TipoLiberacao liberado;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Mercado mercado;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=45,nullable=true)
	private String carimboproducao;
	
	@Column(length=45,nullable=true)
	private String carimboconstrucao;
	
	@Column(length=540,nullable=true)
	private String obstecnicas;
	
	@Column(length=540,nullable=true)
	private String obsconfirmacao;
	
	@Column(length=360,nullable=true)
	private String obsgeral;
	
	@Enumerated(EnumType.STRING)
	private SimNao simconfirmacao;
	
	@Enumerated(EnumType.STRING)
	private SimNao simpublicidade;
	
	@Enumerated(EnumType.STRING)
	private SimNao simtestecalce;
	
	@Enumerated(EnumType.STRING)
	private SimNao simlaboratorio;
	
	@Column(length=60,nullable=true)
	private String complsolado;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao simcartela;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao simpetecnico;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao simpebase;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao simcasquinha;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao simcartolina;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date colagem;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date acabto;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date elastico;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date chapaponto;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date mtztraseiro;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date ferrambico;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date cochoprensa;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date mtzcamasto;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date mtzpregosto;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date testemetais;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date testesolado;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date acabprevio;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date avalproducao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date prevtesteproducao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataproducao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date reuniaotecnica;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date prevescala;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataescala;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date prevpartecnico;
	
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
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date partecnico;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date prevfittest;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datafittest;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date paresfitteste;
	
	@Column(length=64,nullable=true)
	private String sizesnumfittest;
	
	@Column(length=64,nullable=true)
	private String sizesprsfittest;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date testedecampo;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date avaliacaodeproducao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date previsaoconf;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date previsaocorte;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date inicorte;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date inicostura;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date inisolado;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date iniacabamento;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date encaminhasola;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date apresentabronze;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date aprovacxindividual;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date ferramental;
	
	@Column(length=120,nullable=true)
	private String obscronograma;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date solmaqpiloto;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date solmatpiloto;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date solmatcolecao;
	
	@Column(length=180,nullable=true)
	private String comentreuniao;
	
	@Column(length=1440,nullable=true)
	private String partecnamostra;
	
	@Column(length=3,nullable=true)
	private Integer pecartaocx;
	
	@Column(length=20,nullable=true)
	private String pecartaopratel;
	
	@Column(length=20,nullable=true)
	private String gaveta;
	
	@Column(length=25,nullable=true)
	private String solicitante;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date devolvido;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datadestruir;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao destruirpecartao;
	
	@Column(length=6,nullable=true)
	private Integer nroconfirmacaoold;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private Situacao situacao;
	
	@Column(length=60,nullable=true)
	private String obssolado;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date rasgreceb;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date rasgdevol;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date campodevol;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date toplinereceb;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date toplinedevol;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao topline;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao rasgamento;
	
	@Column(length=3,nullable=true)
	private String trilho;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datalalteracaomaterial;
	
	@Column(length=60,nullable=true)
	private String codigomodelocliente;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtliberacaoproducao;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private PrioridadeProducao prioridadeproducao;

	//Clientes
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="conf_clie_fk"))
	private Cliente cliente;
	//Componente
	//Clientes-para Numeracoes
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_comp_nume_fk",referencedColumnName="comp_pk",nullable=false,foreignKey=@ForeignKey(name="conf_comp_nume_fk"))
	private Componente componentenum;
	//Componente Produto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_comp_prod_fk",referencedColumnName="comp_pk",nullable=false,foreignKey=@ForeignKey(name="conf_comp_prod_fk"))
	private Componente componenteprod;
//	//Destino Amostra Confirmacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_deac_fk",referencedColumnName="deac_pk",nullable=false,foreignKey=@ForeignKey(name="conf_deac_fk"))
	private DestinoAmCf destinoamcf;
	//Estacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_esta_fk",referencedColumnName="esta_pk",nullable=false,foreignKey=@ForeignKey(name="conf_esta_fk"))
	private Estacao estacao;
	//Fabrica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_fabr_fk",referencedColumnName="fabr_pk",nullable=false,foreignKey=@ForeignKey(name="conf_fabr_fk"))
	private Fabrica fabrica;
	//Livro Referencia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_lire_fk",referencedColumnName="lire_pk",nullable=false,foreignKey=@ForeignKey(name="conf_lire_fk"))
	private LivroReferencia livroreferencia;
	//Marca Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_macl_fk",referencedColumnName="macl_pk",nullable=false,foreignKey=@ForeignKey(name="conf_marcli_fk"))
	private MarcaCliente marcacliente;
	//Personagem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_pers_fk",referencedColumnName="pers_pk",nullable=false,foreignKey=@ForeignKey(name="conf_pers_fk"))
	private Personagem personagem;
	//Razao Alteracao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_raal_fk",referencedColumnName="razaoalteracao_pk",nullable=false,foreignKey=@ForeignKey(name="conf_razalt_fk"))
	private RazaoAlteracao razaoalteracao;
	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getConfirmacaoid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmacaoid == null) ? 0 : confirmacaoid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Confirmacao other = (Confirmacao) obj;
		if (confirmacaoid == null) {
			if (other.confirmacaoid != null)
				return false;
		} else if (!confirmacaoid.equals(other.confirmacaoid))
			return false;
		return true;
	}

	
}
