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
@Table(name="DGASistema",uniqueConstraints= {@UniqueConstraint(columnNames= {"dgasistema_pk","ordem"},name="sist_sist_uk")
											,@UniqueConstraint(columnNames="ordem",name="sist_ordem_uk")
											,@UniqueConstraint(columnNames="nome",name="sist_nome_uk")})
@Getter @Setter
@EqualsAndHashCode
public class DGASistema implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "dgasistemaSeq")
	@SequenceGenerator(name = "dgasistemaSeq", sequenceName = "s_dgasistema", allocationSize = 1)
	@Column(name="dgasistema_pk",updatable=false,nullable=false)
	private Long dgasistemaid;

	@Column(length=30,nullable=false)
	private String nome;
	
	@Column(length=5,nullable=false)
	private Integer ordem;
	
	@Column(length=15,nullable=true)
	private String stylesistema;
	
	@Column(length=30,nullable=true)
	private String iconesistema;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

}
