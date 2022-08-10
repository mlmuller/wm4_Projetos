package br.com.gvdexport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EmpresaLogo")
@Getter @Setter
@EqualsAndHashCode

public class EmpresaLogo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empresalogoSeq")
	@SequenceGenerator(name = "empresalogoSeq", sequenceName = "s_empresalogo", allocationSize = 1)
	@Column(name="empresalogo_pk",updatable=false,nullable=false)
	private Long empresalogoid;
	
	@Column(name="logotipo",nullable=true)
	@Lob
	private byte[] foto ;
	
	//Chave Estrangeira
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emplog_empr_fk", referencedColumnName = "empresa_pk", nullable = false, foreignKey=@ForeignKey(name="emplog_empr_fk"))
	private Empresa empresa;

}
