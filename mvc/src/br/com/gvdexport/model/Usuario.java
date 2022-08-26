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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Usuario",uniqueConstraints=@UniqueConstraint(columnNames="nome",name="usua_nome_uk"))
@NamedQueries({@NamedQuery(name="findAll",query="SELECT u FROM Usuario u")
						  ,@NamedQuery(name="findOne",query="SELECT u FROM Usuario u WHERE u.usuario = :usuario")})
@Getter @Setter
@EqualsAndHashCode

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuarioSeq")
	@SequenceGenerator(name = "usuarioSeq", sequenceName = "s_usuario", allocationSize = 1)
	@Column(name="usuario_pk",updatable=false,nullable=false)
	private Long usuarioid;

	@Column(length=20,nullable=false)
	private String usuario;

	@Column(length=30,nullable=false)
	private String nome;

	@Column(length=30,nullable=true)
	private String mailgvd;
	
	@Column(length=8,nullable=true)
	private String mailpassword;

	@Column(length=32,nullable=false)
	private String senha;
	
	@Column(length=32,nullable=false)
	private String senhaconversao;
	
	@Enumerated(EnumType.STRING)
	@Column(length=30,nullable=false)
	private Mercado mercado;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private Grupo grupo;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=40,nullable=true)
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(length=2,nullable=false)
	private Idioma idioma;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private SimNao liberafinanceiro;
	
	//Chave Estrangeira
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="usua_clie_fk",referencedColumnName="clie_pk",nullable=true,foreignKey=@ForeignKey(name="usua_clie_fk"))
	private Cliente cliente;

}
