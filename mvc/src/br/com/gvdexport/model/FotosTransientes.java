package br.com.gvdexport.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity(name="photo")
@Getter @Setter
public class FotosTransientes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idphoto;
	
	@Transient
	@Lob
	@Column(name="imagem",nullable=true)
	private byte[] fotoMenor ;

	@Transient
	@Lob
	@Column(name="imagem",nullable=true)
	private byte[] fotoMaior ;

	@Transient
	@Column(length = 12, nullable = true)
	private String Referencia;
	
	@Transient
	@Column(length = 2, nullable = true)
	private String versaoref;
	
	@Transient
	@Column(length = 20, nullable = true)
	private String construcao;
	
	@Transient
	@Column(length = 2, nullable = true)
	private String versaocons;

}
