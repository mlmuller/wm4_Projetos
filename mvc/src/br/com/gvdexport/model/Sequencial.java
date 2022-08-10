package br.com.gvdexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Sequencial")
@Getter @Setter
@EqualsAndHashCode
public class Sequencial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nextreferencia")
	@SequenceGenerator(name = "nextreferencia", sequenceName = "s_nextreferencia", allocationSize = 1)
	@Column(name="nextreferencia_pk",updatable=false,nullable=false)
	private Long nextreferenciaid;
	
	@Column(length = 10, nullable = false)
	private Integer referencia;

}