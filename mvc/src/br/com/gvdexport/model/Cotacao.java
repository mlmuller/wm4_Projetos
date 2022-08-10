package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Cotacoes",uniqueConstraints=@UniqueConstraint(columnNames= {"cota_moed_fk","datacotacao"},name="cota_moed_uk")
					  ,indexes= {@Index(columnList="cota_banc_fk",name="cota_bank_ifk",unique=false)
					  		    ,@Index(columnList="cota_moed_fk",name="cota_moed_ifk",unique=false)})
@Getter @Setter
@EqualsAndHashCode
public class Cotacao implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cotacoesSeq")
	@SequenceGenerator(name = "cotacoesSeq", sequenceName = "s_cotacoes", allocationSize = 1)
	@Column(name="cota_pk",updatable=false,nullable=false)
	private Long cotacaoid;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datacotacao;
	
	@Column(length=15,nullable=true)
	private String mes;
	
	@Column(length=4,nullable=false)
	private Integer ano;
	
	@Column(length=2,nullable=true)
	private Integer mesnumeral;
	
	@Column(length=7,nullable=true)
	private String nomedia;

	@Column(length=5,nullable=true)
	private String sigla;
	
	@Column(precision=10,scale=4, nullable = false)
	private BigDecimal valorcompra;
	
	@Column(precision=10,scale=4, nullable = true)
	private BigDecimal valorvenda;
	
	@Column(precision=10,scale=4, nullable = true)
	private BigDecimal vlrcomprareais;
	
	@Column(precision=10,scale=4, nullable = true)
	private BigDecimal vlrvendareais;
	
	@Column(precision=10,scale=4, nullable = true)
	private BigDecimal valorslipfabrica;
	
	@Transient
	@Column(length=1,nullable=true)
	private Boolean atualiza;
	
	@Transient
	private String caminho;
	
	@Enumerated(EnumType.STRING) //A=Atualiaado, P=Projetado
	@Column(length=1,nullable=true)
	private IdentificadorCotacao identificadorcotacao;
	
	//Moedas
//	@NotNull(message="Opte por uma Moeda,Obrigatório!")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cota_moed_fk",referencedColumnName="moed_pk",nullable=false,foreignKey=@ForeignKey(name="cota_moed_fk"))
	private Moeda moedas;

	//Bancos
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cota_banc_fk",referencedColumnName="banc_pk",nullable=true,foreignKey=@ForeignKey(name="cota_banc_fk"))
	private Banco bancos;
	

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getCotacaoid());
	}
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
}
