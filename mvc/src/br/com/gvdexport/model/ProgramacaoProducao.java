package br.com.gvdexport.model;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ProgramacaoProducao",uniqueConstraints= {@UniqueConstraint(columnNames= {"prgprd_clie_fk","prgprd_grfab_fk","mes","ano"},name="prgprd_clie_fabr_mes_ano_ifk")}
								 ,indexes=@Index(columnList="prgprd_clie_fk",name="prgprd_clie_ifk",unique=false))
@Getter @Setter
@EqualsAndHashCode
public class ProgramacaoProducao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "programacaoproducaoSeq")
	@SequenceGenerator(name = "programacaoproducaoSeq", sequenceName = "s_programacaoproducao", allocationSize = 1)
	@Column(name="programacaoproducao_pk",updatable=false,nullable=false)
	private Long programacaoproducaoid;

	@Column(length=2,nullable=false)
	private String mes;
	
	@Column(length=5,nullable=false)
	private Integer ano;
	
	@Column(length=10,nullable=false)
	private Integer projecao;
	
	@Column(length=10,nullable=false)
	private Integer meta;

	@Column(length=10,nullable=true)
	private Integer disponivel;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//chaves Estrangeiras
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prgprd_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="prgprd_clie_fk"))
	private Cliente cliente;

	//grupos Fabricas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prgprd_grfab_fk",referencedColumnName="grfb_pk",nullable=false,foreignKey=@ForeignKey(name="prgprd_grfab_fk"))
	private GrupoFabrica grupofabrica;
	


	
}
