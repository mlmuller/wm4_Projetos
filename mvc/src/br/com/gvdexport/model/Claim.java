package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Claim",indexes= {@Index(columnList="clai_pedi_fk",name="clai_pedi_ifk")
							 ,@Index(columnList="clai_fabr_fk",name="clai_fabr_ifk")
							 ,@Index(columnList="clai_clie_fk",name="clai_fabr_ifk")})
@Getter @Setter
@EqualsAndHashCode
public class Claim implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "claimSeq")
	@SequenceGenerator(name = "claimSeq", sequenceName = "s_claim", allocationSize = 1)
	@Column(name="claim_pk",updatable=false,nullable = false)
	private Long claimid;
	
	@Column(precision=15,scale=4,nullable=false)
	private BigDecimal valor;
	
	@Column(length=6,nullable=true)
	private Integer pares;
	
	@Column(length=300,nullable=false)
	private String descricao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="clai_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="clai_clie_fk"))
	private Cliente cliente;
	
	//Fabricas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="clai_fabr_fk",referencedColumnName="fabr_pk",nullable=false,foreignKey=@ForeignKey(name="clai_fabr_fk"))
	private Fabrica fabrica;
	
	//Pedidos
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="clai_pedi_fk",referencedColumnName="pedido_pk",nullable=false,foreignKey=@ForeignKey(name="clai_pedi_fk"))
	private Pedido pedido;

}
