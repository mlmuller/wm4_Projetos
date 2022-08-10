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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ControleProducao",indexes= {@Index(columnList="grupomercado,ctrprd_fabr_fk,trilho,data,tipo,ctrprd_lire_fk",unique=false,name="ctrprd_fabr_data_ifk")
										,@Index(columnList="ctrprd_lire_fk",unique=false,name="ctrprd_lire_ifk")})
@Getter @Setter
@EqualsAndHashCode
public class ControleProducao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "controleproducaoSeq")
	@SequenceGenerator(name = "controleproducaoSeq", sequenceName = "s_controleproducao", allocationSize = 1)
	@Column(name="controleproducao_pk",updatable=false,nullable=false)
	private Long controleproducaoid;

	@Column(length=3,nullable=true)
	private String trilho;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date data;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=10,nullable=true)
	private Integer pares;
	
	//Tipo, esta definido grupo de fabricas, caso nao esteja assume codificacao tipo="Z"
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private TipoPrioridade tipo;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private GrupoMercado grupomercado;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao efetivado;
	
	//Chaves Estrangeiras
	//Livros Referencias
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ctrprd_lire_fk",referencedColumnName="lire_pk",nullable=true,foreignKey=@ForeignKey(name="ctrprd_lire_fk"))
	private LivroReferencia livrosreferencias;
	
	//Fabricas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ctrprd_fabr_fk",referencedColumnName="fabr_pk",nullable=false,foreignKey=@ForeignKey(name="ctrprd_fabr_fk"))
	private Fabrica fabricas;
	

}
