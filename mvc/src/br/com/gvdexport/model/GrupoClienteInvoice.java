package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="GrupoClienteInvoice",uniqueConstraints=@UniqueConstraint(columnNames="nome",name="grci_nome_uk"))
@Getter @Setter
@EqualsAndHashCode
public class GrupoClienteInvoice implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "grupoclienteinvoiceSeq")
	@SequenceGenerator(name = "grupoclienteinvoiceSeq", sequenceName = "s_grupoclienteinvoice", allocationSize = 1)
	@Column(name="grci_pk",updatable=false,nullable=false)
	private Long grupoclienteinvoiceid;

	@Column(length = 2,nullable = true)
	private Integer sequenciaid;

	@Column(length=30, nullable=false)
	private String nome;
	
	@Column(length=30, nullable=false)
	private String sucinto;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private SimNao precofabrica;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getGrupoclienteinvoiceid());
	}
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}


}
