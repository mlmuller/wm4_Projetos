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
@Table(name="Cidade",uniqueConstraints= @UniqueConstraint(columnNames= {"cida_esta_fk","nome"},name="cida_esta_ufk"),
indexes=@Index(columnList="cida_esta_fk",unique=false,name="cida_esta_ifk"))
@Getter @Setter
@EqualsAndHashCode
public class Cidade implements Serializable,Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cidadeSeq")
	@SequenceGenerator(name = "cidadeSeq", sequenceName = "s_cidade", allocationSize = 1)
	@Column(name="cida_pk",updatable=false,nullable=false)
	private Long cidadeid;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 7, nullable = true)
	private String codigoibge;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cida_esta_fk", referencedColumnName = "esta_pk", nullable = false, foreignKey=@ForeignKey(name="cida_esta_fk"))
	private Estado estado;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getCidadeid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
}
