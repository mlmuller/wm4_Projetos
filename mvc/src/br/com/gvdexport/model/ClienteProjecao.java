package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="ClienteProjecao",uniqueConstraints=@UniqueConstraint(columnNames="nome",name="clpr_nome_uk"))
@Getter  @Setter
@EqualsAndHashCode
public class ClienteProjecao implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "clienteprojecaoSeq")
	@SequenceGenerator(name = "clienteprojecaoSeq", sequenceName = "s_clienteprojecao", allocationSize = 1)
	@Column(name="clpr_pk",updatable=false,nullable=false)
	private Long clienteprojecaoid;

	@Column(length=30,nullable=false)
	private String nome;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=5,nullable=true)
	private Integer prioridade; 
	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getClienteprojecaoid());
	}
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

}
