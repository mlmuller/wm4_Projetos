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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AvisoRetorno",indexes= {@Index(columnList="avre_fabr_fk",name="avre_fabr_ifk",unique=false)
									  ,@Index(columnList="avre_revi_fk",name="avre_revi_ifk",unique=false)})
@Getter @Setter
@EqualsAndHashCode

public class AvisoRetorno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "avisosretornosSeq")
	@SequenceGenerator(name = "avisosretornosSeq", sequenceName = "s_avisosretornos", allocationSize = 1)
	@Column(name="avre_pk",updatable=false,nullable=false)
	private Long avisoretornoid;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date dataretorno;
	
	@Column(length=10,nullable=false)
	private String nftransporte;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date datanftransporte;

	@Enumerated(EnumType.STRING) //E,ntrada/S,aida
	@Column(length=1,nullable=false)
	private TipoNota tiponota;

	@Enumerated(EnumType.STRING) //D,entro / F,ora
	@Column(length=1,nullable=false)
	private Local local;
	
	@Column(length=6,nullable=true)
	private Integer pares;
	
	@Column(length=200,nullable=true)
	private String observacao;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Fabricas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="avre_fabr_fk",referencedColumnName="fabr_pk",nullable=true,foreignKey=@ForeignKey(name="avre_fabr_fk"))
	private Fabrica fabricas;
	
	//Revisores
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="avre_revi_fk",referencedColumnName="revi_pk",nullable=false,foreignKey=@ForeignKey(name="avre_revi_fk"))
	private Revisor revisores;

}
