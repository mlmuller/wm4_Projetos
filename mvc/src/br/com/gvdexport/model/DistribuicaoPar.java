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

@Entity
@Table(name="DistribuicaoPar",uniqueConstraints= {@UniqueConstraint(columnNames= {"situacao","dipa_comp_fk","codigo"},name="dipa_situ_comp_codi_uk")}
										 ,indexes=@Index(columnList="dipa_comp_fk",name="dipa_comp_ifk",unique=false))
public class DistribuicaoPar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "distribuicaoparSeq")
	@SequenceGenerator(name = "distribuicaoparSeq", sequenceName = "s_distribuicaopar", allocationSize = 1)
	@Column(name="distribuicaopar_pk",updatable=false,nullable=false)
	private Long distribuicaoparid;

	@Column(length=10,nullable=false)
	private String codigo;
	
	@Column(length=104,nullable=true)
	private String distribuicao;
	
	@Column(length=104,nullable=true)
	private String distribuicaonarrow;
	
	@Column(length=104,nullable=true)
	private String distribuicaowidth;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private TipoDistribuicao tipodistribuicao=TipoDistribuicao.M;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dipa_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="dipa_clie_fk"))
	private Cliente cliente;

	//Componente numeracao
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dipa_comp_fk",referencedColumnName="comp_pk",nullable=true,foreignKey=@ForeignKey(name="dipa_comp_nume_fk"))
	private Componente componente;


}
