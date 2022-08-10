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
@Table(name="DestinoAmCf",uniqueConstraints=@UniqueConstraint(columnNames={"destino","deac_grci_fk"},name="deac_dest_clie_uk")
							,indexes=@Index(columnList="deac_grci_fk",name="deac_grci_ifk",unique=false))
@Getter @Setter
@EqualsAndHashCode

public class DestinoAmCf implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "destinoamcfSeq")
	@SequenceGenerator(name = "destinoamcfSeq", sequenceName = "s_destinoamcf", allocationSize = 1)
	@Column(name="deac_pk",updatable=false,nullable=false)
	private Long destinoamcfid;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Column(length=60, nullable=false)
	private String destino;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	//GruposClientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="deac_grci_fk",referencedColumnName="grci_pk",nullable=false,foreignKey=@ForeignKey(name="deac_grci_fk"))
	private GrupoClienteInvoice gruposclientesinvoices;

	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getDestinoamcfid());
	}

}
