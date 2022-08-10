package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name="DigitalContratoFabrica",uniqueConstraints=@UniqueConstraint(columnNames= {"sequencia","digcont_fabr_fk"},name="digcont_fabr_uk"))
@Getter @Setter
@EqualsAndHashCode

public class DigitalizarContratoFabrica implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "digconfabSeq")
	@SequenceGenerator(name = "digconfabSeq", sequenceName = "s_digconfab", allocationSize = 1)
	@Column(name="digconfab_pk",updatable=false,nullable=false)
	private Long digconfabid;
	
	@Column(length=5,nullable=false)
	private Integer sequencia;
	
	@Column(length=128,nullable=true)
	private String tipoarquivo;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(name="digital",nullable=false)
	@Lob
	private byte[] foto ;
	
	//Chave Estrangeira
	//Fabricas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="digcont_fabr_fk",referencedColumnName="fabr_pk",nullable=false,foreignKey=@ForeignKey(name="digcont_fabr_fk"))
	private Fabrica fabrica;

	

	

}
