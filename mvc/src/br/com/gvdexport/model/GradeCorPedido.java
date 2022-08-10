package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="GradeCorPedido",uniqueConstraints= {@UniqueConstraint(columnNames= {"pedidoid","confirmacaoid","confirmacaocorid"},name="cogrp_pedi_conf_cor_uk")}
									  ,indexes= {@Index(columnList="grcp_tprz_fk",name="grcp_tprz_ifk",unique=false)
										        ,@Index(columnList="pedidoid",name="grcp_pedi_i",unique=false)
									  			,@Index(columnList="grcp_comp_fk",name="grcp_comp_ifk",unique=false)
									  			,@Index(columnList="confirmacaoid,confirmacaocorid",name="grcp_corcon_i",unique=false)})
@IdClass(GradeCorPedidoId.class)
@Getter @Setter
public class GradeCorPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long pedidoid;
	
	@Id 
	private Long pedidocorid;

	@Column(precision=10,nullable=false)
	private Long confirmacaoid;
	
	@Column(precision=2,nullable=false)
	private Long confirmacaocorid;
	
	//Existe na grade mas nao é usado
	//	@Column(precision=10,nullable=true)
	//	private Long componenteid;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private SimNao emitidocontrado;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=6,nullable=true)
	private Integer totalpares;
	
	@Column(length=6,nullable=true)
	private Integer parescancelados;
	
	@Column(length=6,nullable=true)
	private Integer paresembarcados;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dtcancelamento;
	
	@Column(length=15,nullable=true)
	private String stocknbr;
	
	@Column(length=15,nullable=true)
	private String stocknbr1;

	@Column(length=100,nullable=true)
	private String texto;

	@Column(length=12,nullable=true)
	private String codeidcliente;
	
	@Column(precision=10,nullable=true)
	private Long idrazaoalteracao;
	
	@Column(length=30,nullable=true)
	private String obscomercial;
	
	@Column(length=12,nullable=true)
	private String referenciacliente;
	
	@Column(length=20,nullable=true)
	private String codigocorcliente;
	
	@Column(length=6,nullable=true)
	private Integer paresxfct;

	@Column(length=15,nullable=true)
	private String nrocaixainicial;

	@Column(length=15,nullable=true)
	private String nrocaixafinal;

	@Column(length=3,nullable=true)
	private String trilho;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataentrada;

	@Column(length=20,nullable=true)
	private String terceiro;
	
	@Column(length=6,nullable=true)
	private Integer paresconfirmadoembarque;

	@Column(length=5,nullable=true)
	private String ordercustomer ;

	//Pedidos
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="grcp_pedi_fk",referencedColumnName="pedido_pk",nullable=true,foreignKey=@ForeignKey(name="grcp_pedi_fk"))
	private Pedido pedido;	

	//Cor Confirmacao
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="confirmacaoid_fk",referencedColumnName="confirmacaoid",nullable=false),@JoinColumn(name="seqcorconfirmacao_fk",referencedColumnName="sequenciacorconfirmacao",nullable=false)},foreignKey=@ForeignKey(name="grcp_corcon_fk"))
	private CorConfirmacao corconfirmacao;

	//Componente
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="grcp_comp_fk",referencedColumnName="comp_pk",nullable=true,foreignKey=@ForeignKey(name="grcp_comp_fk"))
	private Componente componente;

	//Tipos de alteracaos(Razoes)
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="grcp_tprz_fk",referencedColumnName="razaoalteracao_pk",nullable=true,foreignKey=@ForeignKey(name="grcp_tprz_fk"))
	private RazaoAlteracao razaoalteracao;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidocorid == null) ? 0 : pedidocorid.hashCode());
		result = prime * result + ((pedidoid == null) ? 0 : pedidoid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradeCorPedido other = (GradeCorPedido) obj;
		if (pedidocorid == null) {
			if (other.pedidocorid != null)
				return false;
		} else if (!pedidocorid.equals(other.pedidocorid))
			return false;
		if (pedidoid == null) {
			if (other.pedidoid != null)
				return false;
		} else if (!pedidoid.equals(other.pedidoid))
			return false;
		return true;
	}
	
	
	
	
	

}
