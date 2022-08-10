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
@Table(name="RazaoImpressao",uniqueConstraints=@UniqueConstraint(columnNames="descricao",name="razimp_desc_uk"))
@Getter @Setter
@EqualsAndHashCode
public class RazaoImpressao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "razaoimpressaoSeq")
	@SequenceGenerator(name = "razaoimpressaoSeq", sequenceName = "s_razaoimpressao", allocationSize = 1)
	@Column(name="razaoimpressao_pk",updatable=false,nullable=false)
	private Long razaoimpressaoid;

	@Column(length=20,nullable=false)
	private String descricao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

}
