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
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ItemInvoiceAmCf",indexes= {@Index(columnList="invoiceamcfid",unique=false,name="itamcf_itamcf_i")
									   ,@Index(columnList="itamcf_maquid_fk,itamcf_maqcor_fk",unique=false,name="itamcf_maqcor_ifk")
									   ,@Index(columnList="confirmacaoid_fk,seqcorconfirmacao_fk",unique=false,name="itamcf_corcnf_ifk")
									   ,@Index(columnList="amostraid_fk,sequenciacoramostra_fk",unique=false,name="itamcf_coramo_ifk")})
@IdClass(ItemInvoiceAmCfId.class)
public class ItemInvoiceAmCf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long invoiceamcfid;

	@Id
	private Long iteminvoiceamcfid;

	@Column(precision=5,scale=1,nullable=false)
	private BigDecimal pares;
	
	@Column(precision=10,scale=2,nullable=false)
	private BigDecimal precounitario;
	
	@Column(length=60,nullable=true)
	private String outrosstyles;
	
	@Column(length=60,nullable=true)
	private String outroscor;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoItemInvoice tipoiteminvoice;

	@Column(length = 6, nullable = true)
	private String sizeiteminvoice;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoMaterial tipomaterial;

	@Column(length = 30, nullable = true)
	private String comentario;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoSolado tiposolado;
	

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoSalto tiposalto;
		
	//Chaves estrangeiras
	//Cor Amostra - Chave composta
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="amostraid_fk",referencedColumnName="amostraid",nullable=true),@JoinColumn(name="sequenciacoramostra_fk",referencedColumnName="sequenciacoramostra",nullable=true)},foreignKey=@ForeignKey(name="itamcf_coramo_fk"))
	private CorAmostra coramostra;
	
	//Cor Confirmacao - Chave composta
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="confirmacaoid_fk",referencedColumnName="confirmacaoid",nullable=true),@JoinColumn(name="seqcorconfirmacao_fk",referencedColumnName="sequenciacorconfirmacao",nullable=true)},foreignKey=@ForeignKey(name="itamcf_corcnf_fk"))
	private CorConfirmacao corconfirmacao;

	//Cor Maquete - Chave composta
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value= {@JoinColumn(name="itamcf_maquid_fk",referencedColumnName="maqueteid",nullable=true),@JoinColumn(name="itamcf_maqcor_fk",referencedColumnName="sequenciacormaquete",nullable=true)}
						,foreignKey=@ForeignKey(name="itamcf_maqcor_fk"))
	private CorMaquete cormaquete;
	
	//Destino Amostra/Confirmacao
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="itamcf_deamcf_fk",referencedColumnName="deac_pk",nullable=true,foreignKey=@ForeignKey(name="itamcf_deamcf_fk"))
	private DestinoAmCf destinoamcf;
	
	//Destino Amostra/Confirmacao
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="itamcf_comp_fk",referencedColumnName="tica_pk",nullable=true,foreignKey=@ForeignKey(name="itamcf_tica_fk"))
	private TipoCalcado tipocalcado;
	
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="itamcf_clie_fk",referencedColumnName="clie_pk",nullable=true,foreignKey=@ForeignKey(name="itamcf_clie_fk"))
	private Cliente cliente;
	
	


	
	
}
