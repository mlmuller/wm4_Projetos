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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ItemFaturaFabrica",indexes= {@Index(columnList="pedidoid,subgradepedidoid",name="itff_pedsugp_ifk",unique=false)
										 ,@Index(columnList="notafiscaltradingid,itemnotafiscaltrading",name="itff_inft_ifk",unique=false)
										 ,@Index(columnList="faturafabricaid",name="itff_fafa_ifk",unique=false)})
@IdClass(ItemFaturaFabricaId.class)
@Getter @Setter
@EqualsAndHashCode
public class ItemFaturaFabrica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long faturafabricaid;
	
	@Id
	private Long itemfaturafabricaid;
	
	@Column(precision=10,nullable=false)
	private Long pedidoid;
	
	@Column(precision=2,nullable=false)
	private Long subgradepedidoid;
	
	//Sera utilizado se for implementado modulo Trading
	@Column(precision=10,nullable=true)
	private Long notafiscaltradingid;
	
	@Column(precision=2,nullable=true)
	private Long itemnotafiscaltrading;
	
	@Column(length=6,nullable=false)
	private Integer pares;
	
	@Column(length=6,nullable=true)
	private Integer paresretornadosfabrica;
	
	@Column(length=6,nullable=false)
	private Integer saldoparesnotafabrica;
	
	@Column(precision=15,scale=2,nullable=false)
	private Integer precounitario;
	
	@Column(length=10,nullable=true)
	private String numerocaixas;
	
	//Trading
	@Column(length=4,nullable=true)
	private Integer sufixore;

	@Column(length=5,nullable=true)
	private Integer totalcaixas;
	
	@Column(precision=5,scale=2,nullable=true)
	private Long cubico;
	
	@Column(length=104,nullable=true)
	private String paresolido;
	
	@Column(length=104,nullable=true)
	private String paresmusical;
	
	//Trading (Atual nullable esta como false)
	@Column(length=6,nullable=true)
	private Integer saldoparesnftrading;
	//Trading
	@Column(precision=15,scale=2,nullable=true)
	private Long saldoaplicarcontrcambio;
	//Trading (Atual nullable esta como false)
	@Column(precision=15,scale=2,nullable=true)
	private Long saldoparesfaturatrading ;
	
	//Trading (Atual nullable esta como false)
	@Column(precision=15,scale=2,nullable=true)
	private Long valoritem;

	@Column(length = 10, nullable = false)
	private String usuariostamp;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataentrada;

	@Column(precision=15,scale=2,nullable=true)
	private Long valorfrete;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TotalParcial totalparcial=TotalParcial.valueOf(null);

	@Column(length=6,nullable=true)
	private Integer saldoaurizembarque;

	@Column(length = 4, nullable = false)
	private String dimensaocaixal;

	@Column(length = 4, nullable = false)
	private String dimensaocaixaw;
	
	@Column(length = 4, nullable = false)
	private String dimensaocaixah;

	//SubGradePedido
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="subgradepedidoid_fk",referencedColumnName="pedidoid",nullable=false),@JoinColumn(name="subgradepedido_fk",referencedColumnName="subgradepedidoid",nullable=false)},foreignKey=@ForeignKey(name="itff_subgrdped_fk"))
	private SubGradePedido subgradepedido;
	
	//Item Fatura Fabrica - Foreigh Key
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="itff_fafa_fk",referencedColumnName="faturafabrica_pk",nullable=false,foreignKey=@ForeignKey(name="itff_fafa_fk"))
	private FaturaFabrica faturafabrica;

	
}
