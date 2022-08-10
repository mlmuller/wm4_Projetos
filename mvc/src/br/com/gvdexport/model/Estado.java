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
@Table(name="Estado",uniqueConstraints=@UniqueConstraint(columnNames= {"nome"},name="esta_pais_ufk"),
indexes= {@Index(unique=false,name="esta_regi_ifk", columnList="esta_regi_fk"),
		  @Index(unique=false,name="esta_pais_ifk",columnList="esta_pais_fk")})
@Getter @Setter
@EqualsAndHashCode(of="estadoid")
public class Estado implements Serializable,Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "estadoSeq")
	@SequenceGenerator(name = "estadoSeq", sequenceName = "s_estado", allocationSize = 1)
	@Column(name="esta_pk",updatable=false,nullable=false)

	private Long estadoid;
	
	@Column(length = 50, nullable =false)
	private String nome;
	
	@Column(length = 2, nullable = true)
	private String codigoibge;
	
	@Column(length = 3, nullable = false)
	private String sigla;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "esta_regi_fk", referencedColumnName = "regi_pk", nullable = true, foreignKey=@ForeignKey(name="esta_regi_fk"))
	private Regiao regiao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "esta_pais_fk", referencedColumnName = "pais_pk", nullable = false, foreignKey=@ForeignKey(name="esta_pais_fk"))
	private Pais pais;
	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getEstadoid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

}
