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

@Entity
@Table(name="motivoProducao")

public class MotivoProducao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "motivoproducaoSeq")
	@SequenceGenerator(name = "motivoproducaoSeq", sequenceName = "s_motivoproducao", allocationSize = 1)
	@Column(name="motivoprod_pk",updatable=false,nullable=false)
	private Long motivoproducaoid;

	@Column(length=30,nullable=false)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private TipoMotivoProducao motivoproducao;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
}
