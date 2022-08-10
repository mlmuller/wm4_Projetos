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
import javax.validation.constraints.Email;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Empresa",indexes=@Index(columnList="empr_pais_fk",unique=false,name="empr_pais_ifk"))
@Getter @Setter
@EqualsAndHashCode

public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empresaSeq")
	@SequenceGenerator(name = "empresaSeq", sequenceName = "s_empresa", allocationSize = 1)
	@Column(name="empresa_pk",updatable=false,nullable=false)
	private Long empresaid;
	
	@Column(length=50,nullable=false)
	private String razaosocial;
	
	@Column(length=50,nullable=false)
	private String endereco;
	
	@Column(length=30,nullable=false)
	private String bairro;

	@Column(length=30,nullable=false)
	private String nomecidade;

	@Column(length=2,nullable=false)
	private String uf;
	
	@Column(length=12,nullable=false)
	private String cep;
	
	@Column(length=20,nullable=false)
	private String fone;

	@Column(length=18,nullable=false)
	private String cnpj;
	
	@Column(length=20,nullable=true)
	private String inscricaoestadual;

	@Column(length=20,nullable=true)
	private String faxtrading;
    
	@Email
	@Column(length=50,nullable=true)
	private String email;
	
	@Column(length=50,nullable=true)
	private String url;

	@Column(length=20,nullable=true)
	private String faxeuropa;
	
	@Column(length=20,nullable=true)
	private String faxeua;
	
	@Column(length=20,nullable=true)
	private String faxmi;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Chaves Estrangeiras
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empr_pais_fk", referencedColumnName = "pais_pk", nullable = false, foreignKey=@ForeignKey(name="empr_pais_fk"))
	private Pais pais;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empr_cida_fk", referencedColumnName = "cida_pk", nullable = false, foreignKey=@ForeignKey(name="empr_cida_fk"))
	private Cidade cidade;

}
