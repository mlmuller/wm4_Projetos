package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ItemClaim",indexes= {@Index(columnList="itcl_pedi_pk",unique=false,name="itcl_pedi_ifk")
								 ,@Index(columnList="itcl_claim_pk",unique=false,name="itcl_claim_ifk")})
@Getter @Setter
@EqualsAndHashCode
@IdClass(ItemClaimId.class)
public class ItemClaim implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long itemclaimid;
	
	@Id
	private Long sequenciaitemclaim;
	
	@Column(length=100,nullable=false)
	private String descricao;
	
	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal descontopar;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="itcl_pedi_pk",referencedColumnName="pedido_pk",nullable=false,foreignKey=@ForeignKey(name="itcl_pedi_fk"))
	private Pedido pedido;	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="itcl_claim_pk",referencedColumnName="claim_pk",nullable=false,foreignKey=@ForeignKey(name="itcl_claim_fk"))
	private Claim claim;	

}
