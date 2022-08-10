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
@Table(name="MarcaCliente",uniqueConstraints=@UniqueConstraint(columnNames="nome",name="macl_nome_uk")
							 ,indexes=@Index(columnList="macl_clie_fk",name="macl_clie_ifk",unique=false))
@Getter @Setter
@EqualsAndHashCode

public class MarcaCliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "marcaclienteSeq")
	@SequenceGenerator(name = "marcaclienteSeq", sequenceName = "s_marcacliente", allocationSize = 1)
	@Column(name="macl_pk",updatable=false,nullable=false)
	private Long marcaclienteid;

	@Column(length=30,nullable=false)
	private String nome;
	
	@Column(length=15,nullable=true)
	private String sucinto;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="macl_clie_fk",referencedColumnName="clie_pk",nullable=true,foreignKey=@ForeignKey(name="macl_clie_fk"))
	private Cliente cliente;

}
