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
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="Forma",uniqueConstraints=@UniqueConstraint(columnNames= {"referenciaforma"},name="form_refer_uk")
					,indexes=@Index(unique=false,columnList="form_fabr_fk",name="form_fabr_ifk"))
@Getter @Setter
@EqualsAndHashCode(of="formaid")
public class Forma implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "formaSeq")
	@SequenceGenerator(name = "formaSeq", sequenceName = "s_forma", allocationSize = 1)
	@Column(name="form_pk",updatable=false,nullable=false)
	private Long formaid;

	@Column(length = 10, nullable = true)
	private  String nrogvd;
	
	@Column(length = 10, nullable = false)
	private  String referenciaforma;
	
	@Column(length = 10, nullable = true)
	private  String referenciafabrica;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private  TipoCalcadoResumido tipocalcado;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private  TipoBico bico;
	
	@Column(length = 6, nullable = true)
	private  String altura;
	
	@Column(length = 6, nullable = true)
	private  Integer comprimento;
	
	@Column(length = 6, nullable = true)
	private  Integer circunferencia;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private  LarguraForma largura;
	
	
	@Column(length = 6, nullable = true)
	private  String formasize;

	@Column(length = 6, nullable = true)
	private  Integer base;
	
	@Column(length = 1000, nullable = true)
	private  String observacao;
	
	@Column(length = 4, nullable = true)
	private  Integer totalformasestoque;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private  Situacao situacao=Situacao.A ;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "form_fabr_fk", referencedColumnName = "fabr_pk", nullable = true, foreignKey=@ForeignKey(name="form_fabr_fk"))
	private Fabrica fabrica;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getFormaid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
}
