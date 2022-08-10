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
@Table(name="UsuarioCliente",indexes= {@Index(columnList="usucli_clie_fk",name="usucli_clie_ifk",unique=false)
								      ,@Index(columnList="usucli_usua_fk",name="usucli_usua_ifk",unique=false)})
@Getter @Setter
@EqualsAndHashCode
public class UsuarioCliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuarioclienteSeq")
	@SequenceGenerator(name = "usuarioclienteSeq", sequenceName = "s_usuariocliente", allocationSize = 1)
	@Column(name="usuariocliente_pk",updatable=false,nullable=false)
	private Long usuarioclienteid;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Chaves Estrangeiras
	
	//Clientes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="usucli_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="usucli_clie_fk"))
	private Cliente cliente;
	
	//Usuario
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="usucli_usua_fk",referencedColumnName="usuario_pk",nullable=false,foreignKey=@ForeignKey(name="usucli_usua_fk"))
	private Usuario usuario;	



}
