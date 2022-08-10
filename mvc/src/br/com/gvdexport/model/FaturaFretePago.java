package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="FaturaFretePago",indexes= {@Index(columnList="numerofaturatradingid,anofaturatrading",name="ftpg_fattrd_ifk",unique=false)})
@IdClass(FaturaFretePagoId.class)
@Getter @Setter
@EqualsAndHashCode(of = {"numerofaturatradingid", "anofaturatrading"})
public class FaturaFretePago implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long numerofaturatradingid;
	
	@Id
	private String anofaturatrading;
	
	@Column(precision=12,scale=4,nullable=true)
	private BigDecimal pesobrutototalcontainer;
	
	@Column(precision=12,scale=2,nullable=true)
	private BigDecimal valortotalcontainer;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	@Column(precision=8,scale=2,nullable=true)
	private BigDecimal taxaemissaohawb;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private PagamentoDiferencaFrete pagamentodiferencafrete;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoContainer tipocontainer;
	
	//chave estrangeira Numero fatura trading+ano fatura trading
	
	
	
	
	

}
