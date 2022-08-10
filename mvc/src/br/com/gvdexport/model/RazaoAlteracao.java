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
@Table(name="RazaoAlteracao",uniqueConstraints=@UniqueConstraint(columnNames="descricao",name="raztip_descricao_uk"))
@Getter @Setter
@EqualsAndHashCode
public class RazaoAlteracao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "razaoalteracaoSeq")
	@SequenceGenerator(name = "razaoalteracaoSeq", sequenceName = "s_razaoalteracao", allocationSize = 1)
	@Column(name="razaoalteracao_pk",updatable=false,nullable=false)
	private Long razaoalteracaoid;

	@Column(length=20,nullable=false)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private TipoRazao tiporazao;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getRazaoalteracaoid());
	}
}
