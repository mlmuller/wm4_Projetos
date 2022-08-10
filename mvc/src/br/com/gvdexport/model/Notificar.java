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

@Entity
@Table(name="Notificar",uniqueConstraints=@UniqueConstraint(columnNames="nome",name="noti_nome_uk"))
public class Notificar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "notificarSeq")
	@SequenceGenerator(name = "notificarSeq", sequenceName = "s_notificar", allocationSize = 1)
	@Column(name="noti_pk",updatable=false,nullable=false)
	private Long notificarid;

	@Column(length=50, nullable=false)
	private String nome;
	
	@Column(length=500, nullable=true)
	private String endereco;
	
	@Enumerated(EnumType.STRING) //(A tivo, I nativo)
	@Column(length=1, nullable = false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

}
