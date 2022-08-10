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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="grupoFabrica")
@Getter @Setter
@EqualsAndHashCode
public class GrupoFabrica implements Serializable,Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "fabricagrpSeq")
	@SequenceGenerator(name = "fabricagrpSeq", sequenceName = "s_fabricagrp", allocationSize = 1)
	@Column(name="grfb_pk",updatable=false,nullable=false)
	private Long fabricagrpid;

	@Column(length = 20, nullable = false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private QuadroFabrica quadrofabrica;
	
	@Column(length = 10, nullable = false)
	private String sucinto;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private Prioridade prioridade;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getFabricagrpid());
	}
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}


	
}
