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
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PrecoAmostra",uniqueConstraints= {@UniqueConstraint(columnNames= {"pram_grpcliamo_fk","tipopreco","identificacalcado"},name="pram_grci_tipr_idca_uk")}
									, indexes=@Index(columnList="pram_grpcliamo_fk",name="pram_grpcliamo_ifk",unique=false))
@Getter @Setter
@EqualsAndHashCode
public class PrecoAmostra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "precoamostraSeq")
	@SequenceGenerator(name = "precoamostraSeq", sequenceName = "s_precoamostra", allocationSize = 1)
	@Column(name="precoamostra_pk",updatable=false,nullable=false)
	private Long precoamostraid;

	@Column(precision=6,scale=2,nullable=false)
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private IdentificaCalcado identificacalcado;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private TipoPreco tipopreco;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pram_grpcliamo_fk",referencedColumnName="grci_pk",nullable=true,foreignKey=@ForeignKey(name="pram_grpcliamo_fk"))
	private GrupoClienteInvoice grupoclienteinvoice;
	
		
}
