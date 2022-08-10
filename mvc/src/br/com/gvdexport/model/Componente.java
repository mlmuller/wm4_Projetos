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
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Componente",uniqueConstraints=@UniqueConstraint(columnNames= {"def1","grupocomponente"},name="comp_def_grupo_uk")
						 ,indexes= {@Index(columnList="comp_htss_fk",name="comp_htss_ifk",unique=false)
						 		   ,@Index(columnList="comp_nbms_fk",name="comp_nbms_ifk",unique=false)
						 		   ,@Index(columnList="comp_tica_fk",name="comp_tica_ifk",unique=false)})
@Getter @Setter
@EqualsAndHashCode

public class Componente implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "componenteSeq")
	@SequenceGenerator(name = "componenteSeq", sequenceName = "s_componente", allocationSize = 1)
	@Column(name="comp_pk",updatable=false,nullable=false)
	private Long componenteid;
	
	@Column(length=50,nullable=true)
	private String def1;
	
	@Column(length=90,nullable=true)
	private String def2;
	
	@Column(length = 35, nullable=true)
	private String nomeconversao;
	
	@Column(length = 25, nullable=true)
	private String nomesucinto;
	
	@Column(length = 5 , nullable=true)
	private String nomeabreviado;
	
	// Todososprodutos(D,B,H,I,L,Z--L=Numeracoes,cada menu produto tem uma letra
	@Column(length=1,nullable=true)
	private String grupocomponente;
	
	//(4,0,1,2,3) --NL
	@Column(length=1,nullable=true)
	private Character unidade;
	
	@Enumerated(EnumType.STRING) //Ativo,Inativo
	@Column(length=1,nullable=true)
	private Situacao situacao;
	
	@Column(length=12,precision=2,nullable=true)
	private BigDecimal fretecompl;
	
	@Column(length=60,nullable=true)
	private String obssolado;
	
	//Estrangeira,Nacional
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private OrigemProduto origemproduto ;
	
	//Fabric,Leather,Synthetic...
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoSolado tiposolado ;
	
	//Fabric,Leather,Synthetic...
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoMaterial tipocabedal ;
	
    @Column(length = 1,nullable=true)
    private String liberadoweb;
	
	@Column(length=3,nullable=true)
	private String destaquencm;
	
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

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Tipos Calcados
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="comp_tica_fk",referencedColumnName="tica_pk",nullable=true,foreignKey=@ForeignKey(name="comp_tica_fk"))
	private TipoCalcado tipocalcados;

	//Cadastros NBMS
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="comp_nbms_fk",referencedColumnName="nbm_pk",nullable=true,foreignKey=@ForeignKey(name="comp_nbms_fk"))
	private Nbm nbm;
	
	//Cadastros HTS
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="comp_htss_fk",referencedColumnName="hts_pk",nullable=true,foreignKey=@ForeignKey(name="comp_htss_fk"))
	private Hts hts;

	//Cadastros Numeracao Produzir
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="conv_nume_fk",referencedColumnName="conv_pk",nullable=true,foreignKey=@ForeignKey(name="conv_nume_fk"))
	private Conversao conversao;

	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getComponenteid());
	}
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

}
