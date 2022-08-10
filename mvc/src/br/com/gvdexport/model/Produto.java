package br.com.gvdexport.model;

import java.io.Serializable;

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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Produto",indexes= {@Index(columnList="prod_mate_fk",name="prod_mate_ifk",unique=false)
							   ,@Index(columnList="prod_macl_fk",name="prod_macl_ifk",unique=false)
							   ,@Index(columnList="prod_lire_fk",name="prod_lire_ifk",unique=false)
							   ,@Index(columnList="prod_comp_fk",name="prod_comp_ifk",unique=false)
							   ,@Index(columnList="prod_clie_fk",name="prod_clie_ifk",unique=false)
							   ,@Index(columnList="prod_cor_fk",name="prod_cor_ifk",unique=false)
							   ,@Index(columnList="prod_mate_fk",name="prod_mate_ifk",unique=false)})
@Getter @Setter
@EqualsAndHashCode
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "produtoSeq")
	@SequenceGenerator(name = "produtoSeq", sequenceName = "s_produto", allocationSize = 1)
	@Column(name="produto_pk",updatable=false,nullable=false)
	private Long produtoid;
	
	@Column(length=30,nullable=false)
	private String nome;
	
	@Column(length=104,nullable=true)
	private String paresmusical;
	
	@Column(length=104,nullable=true)
	private String reservamusical;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	//Chaves Estrangeiras
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="prod_clie_fk"))
	private Cliente clientes;
	
	//Livros Referencias
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_lire_fk",referencedColumnName="lire_pk",nullable=false,foreignKey=@ForeignKey(name="prod_lire_fk"))
	private LivroReferencia livrosreferencias;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_cor_fk",referencedColumnName="cor_pk",nullable=false,foreignKey=@ForeignKey(name="prod_cor_fk"))
	private Cor cor;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_mate_fk",referencedColumnName="material_pk",nullable=false,foreignKey=@ForeignKey(name="prod_mate_fk"))
	private Material material;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_macl_fk",referencedColumnName="macl_pk",nullable=true,foreignKey=@ForeignKey(name="prod_macl_fk"))
	private MarcaCliente marcaCliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_comp_fk",referencedColumnName="comp_pk",nullable=false,foreignKey=@ForeignKey(name="prod_comp_fk"))
	private Componente componente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_mode_fk",referencedColumnName="modelo_pk",nullable=true,foreignKey=@ForeignKey(name="prod_mode_fk"))
	private Modelo modelo;
	
}
