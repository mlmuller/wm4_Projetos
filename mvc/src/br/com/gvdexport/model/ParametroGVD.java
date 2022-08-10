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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ParametroGVD")
@Getter @Setter
@EqualsAndHashCode
public class ParametroGVD implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "parametrogvdSeq")
	@SequenceGenerator(name = "parametrogvdSeq", sequenceName = "s_parametrogvd", allocationSize = 1)
	@Column(name="parametrogvd_pk",updatable=false,nullable=false)
	private Long parametrogvdid;

	@Column(length=50,nullable=false)
	private String parametro;
	
	@Column(length=200,nullable=false)
	private String valor;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;


}
