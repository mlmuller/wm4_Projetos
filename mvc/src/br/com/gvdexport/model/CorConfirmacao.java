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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CorConfirmacao",indexes= {@Index(columnList="amostraid,sequenciacoramostra",name="cocn_conf_ifk",unique=false)
									  ,@Index(columnList="confirmacaoid",name="cocn_conf_ifk",unique=false)
									  ,@Index(columnList="conf_raal_fk",name="cocn_raal_fk",unique=false)
									  ,@Index(columnList="material",name="cocn_material_ifk",unique=false)}
									  ,uniqueConstraints= {@UniqueConstraint(columnNames={"confirmacaoid","sequenciacorconfirmacao"},name="conf_cor_uk")})
@Getter @Setter
public class CorConfirmacao implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "confcorSeq")
	@SequenceGenerator(name = "confcorSeq", sequenceName = "s_confcor", allocationSize = 1)
	@Column(name="confcor_pk",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long confirmacaoid;
	
	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacorconfirmacao;

	@Column(length=10,nullable=true)
	private Integer amostraid;
	
	@Column(length=2,nullable=true)
	private Integer sequenciacoramostra;
	
	@Column(length=60,nullable=false)
	private String cor;
	
	@Column(length=15,nullable=false)
	private String corprincipal;
	
	@Column(length=60,nullable=false)
	private String material;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=5,nullable=true)
	private String linha;
	
	@Column(length=3,nullable=true)
	private String localizacao;
	
	@Column(length=6,nullable=true)
	private Integer parescor;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataprevisaocliente;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date datasaidafabrica;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao produzconfirmacao;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal paresconfirmacao;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal refazparesconfirmacao;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal parespublicidade;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal refazparespublicidade;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal parescalce;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal refazparescalce;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal pareslaboratorio;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal refazpareslaboratorio;
	
	@Column(length=6,nullable=true)
	private String sizeconfirmacao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date embarque1;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date embarque2;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date embarque3;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date embarquedef;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao parcialconf;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal paresparcial;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataparcial;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date aprovacaoconf;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date okcliente;
	
	@Column(length=3,nullable=true)
	private Integer pebasecx;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao pebasegaveta;
	
	@Column(length=20,nullable=true)
	private String pebaseprateleira;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date pebasesaida;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date pebaseretorno;

	@Column(length=25,nullable=true)
	private String pebasesolicit;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao pebasedstruir;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date pebaseencaix;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao peconfgaveta;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date peconfprateleira;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date peconfcaixa;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date peconfencaix;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao peconfperman;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date peconfdestruir;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date peconfsaida;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date peconfretorno;

	@Column(length=25,nullable=true)
	private String peconfsolicit;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private LarguraForma larguraforma;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private Situacao situacao;
	
	@Column(length=6,nullable=true)
	private Integer saldoparesinvoice;
	
	@Column(length=6,nullable=true)
	private String codigocor;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private LarguraForma cocnlarguraforma;
	
	@Column(length=3,nullable=true)
	private Integer pecartcaixa;
	
	@Column(length=20,nullable=true)
	private String pecartpratel;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao pecartgaveta;

	@Column(length=25,nullable=true)
	private String pecartsolicit;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date pecartdevolv;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date pecartdestru;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao pecartdestruir;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date pecartencaix;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date pebasedt;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date peconfdt;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date pecartdt;
	
	@Column(length=6,nullable=true)
	private String codigomaterial;
	
	@Column(length=30,nullable=true)
	private String obsmaterial;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoMaterial tipomaterial;

	@Column(length=60,nullable=true)
	private String coretiqueta;
	
	@Column(length=6,nullable=true)
	private Integer saldoparesetiquetas;
	
	@Column(length=6,nullable=true)
	private Integer saldoparesrotulos;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date aprovadocomercial;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date presssamplecomercial;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date cataloguecomercial;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataetiqueta;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataprogramacao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date cuttingscheduled;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date cuttingreal;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date lastingscheduled;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date lastingreal;
	//Confirmacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="coco_conf_fk",referencedColumnName="confirmacao_pk",nullable=false,foreignKey=@ForeignKey(name="coco_conf_fk"))
	private Confirmacao confirmacao;
	
	//Cor  Amostra
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns(value={@JoinColumn(name="coco_coramo_fk",referencedColumnName="amoscor_pk",nullable=false)},foreignKey=@ForeignKey(name="cor_conf_fk"))
	private CorAmostra coramostra;
	
	//Razao alteracao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="conf_raal_fk",referencedColumnName="razaoalteracao_pk",nullable=false,foreignKey=@ForeignKey(name="conf_razalt_fk"))
	private RazaoAlteracao razaoalteracao;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amostraid == null) ? 0 : amostraid.hashCode());
		result = prime * result + ((sequenciacorconfirmacao == null) ? 0 : sequenciacorconfirmacao.hashCode());
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
		CorConfirmacao other = (CorConfirmacao) obj;
		if (amostraid == null) {
			if (other.amostraid != null)
				return false;
		} else if (!amostraid.equals(other.amostraid))
			return false;
		if (sequenciacorconfirmacao == null) {
			if (other.sequenciacorconfirmacao != null)
				return false;
		} else if (!sequenciacorconfirmacao.equals(other.sequenciacorconfirmacao))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getConfirmacaoid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}


}
