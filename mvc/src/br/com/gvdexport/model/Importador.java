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
@Table(name="Importador",uniqueConstraints= {@UniqueConstraint(columnNames= {"nome"},name="impo_nome_uk"),
											   @UniqueConstraint(columnNames= {"sucinto"},name="impo_sucinto_uk")},
						   indexes=@Index(columnList="impo_pais_fk",unique=false,name="impo_pais_ifk"))
@Getter @Setter
@EqualsAndHashCode

public class Importador implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "importadorSeq")
	@SequenceGenerator(name = "importadorSeq", sequenceName = "s_importador", allocationSize = 1)
	@Column(name="impo_pk",updatable=false,nullable=false)
	private Long importadorid;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoImportador tipoimportador;
	
	@Column(length = 40 , nullable = true)
	private String nome;
	
	@Column(length = 20 , nullable = true)
	private String sucinto;
	
	@Column(length = 40 , nullable = true)
	private String endereco;

	@Column(length = 200 , nullable = true)
	private String descricaocidade;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1 , nullable = true)
	private Situacao situacao;
	
	@Column(length = 22 , nullable = true)
	private String cnpjcpf;
	
	@Column(length = 16 , nullable = true)
	private String inscricaoestadual;

	@Column(length = 30 , nullable = true)
	private String bairro;
	
	@Column(length = 10 , nullable = true)
	private String cep;

	@Column(length = 2 , nullable = true)
	private String uf;
	
	@Column(length = 30 , nullable = true)
	private String telefone;
	
	@Enumerated(EnumType.STRING) //(F,J,N,E)
	@Column(length = 1 , nullable = true)
	private TipoPessoa tipopessoa;
	
	@Enumerated(EnumType.STRING) //(C,F)
	@Column(length = 1 , nullable = true)
	private TipoTelefone tipotelefone;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1 , nullable = false)
	private SimNao liberadoedi=SimNao.N;
	
	@Column(length = 6 , precision = 3 ,nullable = true)
	private String percdesconto;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "impo_cida_fk", referencedColumnName = "cida_pk", nullable = true, foreignKey=@ForeignKey(name="impo_cida_fk"))
	private Cidade cidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "impo_pais_fk", referencedColumnName = "pais_pk", nullable = true, foreignKey=@ForeignKey(name="impo_pais_fk"))
	private Pais pais;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getImportadorid());
	}
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
}
