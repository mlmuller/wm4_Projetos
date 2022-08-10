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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Fabrica",uniqueConstraints = {@UniqueConstraint(columnNames={"sucinto"},name="fabr_sucinto_uk"),
											@UniqueConstraint(columnNames= {"abreviacao"},name="fabr_abrev_uk"),
											@UniqueConstraint(columnNames= {"nome"},name="fabr_nome_uk")})
@Getter @Setter
@EqualsAndHashCode(of="fabricaid")
public class Fabrica implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "fabricaSeq")
	@SequenceGenerator(name = "fabricaSeq", sequenceName = "s_fabrica", allocationSize = 1)
	@Column(name="fabr_pk",updatable=false,nullable=false)
	private Long fabricaid;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 25, nullable = false)
	private String sucinto;
	
	@Column(length = 40, nullable = true)
	private String endereco;
	
	@Column(length = 30, nullable = true)
	private String nomecidade;

	@Column(length = 2, nullable = true)
	private String uf;

	@Column(length = 10, nullable = true)
	private String cep;

	@Column(length = 14, nullable = true)
	private String telefone;
	
	@Column(length = 150, nullable = true)
	private String contato;
	
	@Column(length = 150, nullable = true)
	private String diretor;
	
	@Column(length = 18, nullable = true)
	private String cgc;
	
	@Column(length = 15, nullable = true)
	private String inscricaoestadual;

	@Column(length = 2, nullable = true)
	private Integer nrotrilho;
	
	@Column(length = 5, nullable = true)
	private Integer producaofabrica;
	
	@Column(length = 5, nullable = true)
	private Integer capacidadetrilho;

	@Column(length = 3, nullable = true)
	private String abreviacao;
	
	@Column(length = 5, nullable = true)
	private Integer codigoimp;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1, nullable=true)
	private Situacao situacao;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private SimNao integrantesimplesnacional;
	
	@Column(length = 30, nullable = true)
	private String cacex;
	
	@Column(length = 2, nullable = true)
	private Integer prazopagamento;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length = 12, nullable = true)
	private String nrocontrato;

	@Column(length = 200, nullable = true)
	private String observacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fabr_pais_fk", referencedColumnName = "pais_pk", nullable = true, foreignKey=@ForeignKey(name="fabr_pais_fk"))
	private Pais pais;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fabr_grfa_fk", referencedColumnName = "grfb_pk", nullable = true, foreignKey=@ForeignKey(name="fabr_fagr_fk"))
	private GrupoFabrica grupofabrica;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fabr_cida_fk", referencedColumnName = "cida_pk", nullable = true, foreignKey=@ForeignKey(name="fabr_cida_fk"))
	private Cidade cidade;

	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getFabricaid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

}
