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
@Table(name="Vendedor",uniqueConstraints= {@UniqueConstraint(columnNames="nome",name="vend_nome_uk")
											,@UniqueConstraint(columnNames="sucinto",name="vend_sucinto_uk")})
@Getter @Setter
@EqualsAndHashCode
public class Vendedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "vendedoresSeq")
	@SequenceGenerator(name = "vendedoresSeq", sequenceName = "s_vendedores", allocationSize = 1)
	@Column(name="vend_pk",updatable=false,nullable=false)
	private Long vendedorid;
	
	@Column(length=60,nullable=false)
	private String nome;
	
	@Column(length=40,nullable=false)
	private String sucinto;
	
	@Column(length=500,nullable=true)
	private String endereco;
	
	@Column(length=30,nullable=true)
	private String telefone;

	@Column(length=30,nullable=true)
	private String email;
	
	@Column(precision=5,scale=2, nullable=true)
	private String percentualcomissao;

	@Column(length=10,nullable=true)
	private String valorcomissao;
	
	@Column(length=500,nullable=true)
	private String observacao;
	
	@Enumerated(EnumType.STRING) //(A tivo, I nativo)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Enumerated(EnumType.STRING) //(A , R)
	@Column(length=1,nullable=true)
	private TipoVendedor tipovendedor;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vend_cida_fk", referencedColumnName = "cida_pk", nullable = true, foreignKey=@ForeignKey(name="vend_cida_fk"))
	private Cidade cidade;
	
	
	

}
