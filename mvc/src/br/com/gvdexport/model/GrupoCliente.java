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
@Table(name="GrupoCliente",uniqueConstraints={@UniqueConstraint(columnNames="nome",name="grcl_nome_uk")})
@Getter @Setter
@EqualsAndHashCode
public class GrupoCliente implements Serializable,Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "clientegrpSeq")
	@SequenceGenerator(name = "clientegrpSeq", sequenceName = "s_clientegrp", allocationSize = 1)
	@Column(name="grcl_pk",updatable=false,nullable=false)
	private Long clientegrpid;

	@Column(length = 30, nullable = false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private Situacao situacao;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private SimNao mostraprecofabrica;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private SimNao imprformaetiquetaeuropa;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private SimNao imprversaozero=SimNao.N;
	
	@Column(length = 10, nullable = true)
	private Integer codigo;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getClientegrpid());
	}
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
}
