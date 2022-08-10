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
@Table(name="DGAUsuario",uniqueConstraints=@UniqueConstraint(columnNames="username",name="dgausu_usern_uk")
						,indexes=@Index(columnList="dgausu_dgasis_fk",name="dgausu_dgasis_ifk",unique=false))
@Getter @Setter
@EqualsAndHashCode

public class DGAUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "dgausuarioSeq")
	@SequenceGenerator(name = "dgausuarioSeq", sequenceName = "s_dgausuario", allocationSize = 1)
	@Column(name="dgausuario_pk",updatable=false,nullable=false)
	private Long dgausuarioid;
	
	@Column(length=50,nullable=false)
	private String nome;
	
	@Column(length=20,nullable=false)
	private String username;
	
	@Column(length=10,nullable=false)
	private String senha;

	@Column(precision=10,nullable=true)
	private Long id;
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Chaves Estrangeiras
	//Sistema
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dgausu_dgasis_fk",referencedColumnName="dgasistema_pk",nullable=false,foreignKey=@ForeignKey(name="dgausu_dgasis_fk"))
	private DGASistema dgasistema;


}
