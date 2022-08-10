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
@Table(name="UsuarioMercado",uniqueConstraints=@UniqueConstraint(columnNames= {"usumer_usua_fk","mercado"},name="usumer_usua_uk")
											  ,indexes=@Index(columnList="usumer_usua_fk",name="usumer_usua_ifk",unique=false))
@Getter @Setter
@EqualsAndHashCode

public class UsuarioMercado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuariomercadoSeq")
	@SequenceGenerator(name = "usuariomercadoSeq", sequenceName = "s_usuariomercado", allocationSize = 1)
	@Column(name="usuariomercado_pk",updatable=false,nullable=false)
	private Long usuariomercadoid;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Mercado mercado;
	
	//Chave Estrangeira
	//Usuario
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="usumer_usua_fk",referencedColumnName="usuario_pk",nullable=false,foreignKey=@ForeignKey(name="usumer_usua_fk"))
	private Usuario usuario;	


}
