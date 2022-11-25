package br.com.gvdexport.model;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Lob;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import lombok.Getter;
import lombok.Setter;

@ApplicationScoped
@Getter @Setter
public class ResizerBlop implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	
	@Lob
	@Column(name="imagem",nullable=true)
	private byte[] foto_maior ;

	@Lob
	@Column(name="imagem",nullable=true)
	private byte[] foto_menor ;

	@Column(length = 5,nullable = false)
	private String extensao;

	@Column(length = 25 , nullable = false)
	private String nomearquivo;

	@Column(length = 25 , nullable = false)
	private String caminhoarquivo;

	@Column(length = 15 , nullable = false)
	private String referencia;

	@Column(length = 20 , nullable = false)
	private String construcao;

	@Column(length = 3 , nullable = false)
	private String versao_r;

	@Column(length = 3 , nullable = false)
	private String versao_c;
	
	@Column(length = 4 , nullable = false)
	private String width;

	@Column(length = 4 , nullable = false)
	private String height;

	public StreamedContent getImagemgr() {
		if (this.getFoto_maior() != null) {
			String mime = this.getExtensao();
			String nome = this.getNomearquivo();
			byte[] foto = this.getFoto_maior();
    		StreamedContent streamedcontent = DefaultStreamedContent.builder()
    				.name(nome)
    				.contentType(mime).stream(()->new ByteArrayInputStream(foto))
    				.build();

			return(streamedcontent);
		}
		return new DefaultStreamedContent();
	}
	public StreamedContent getImagempq() {
		if (this.getFoto_menor() != null) {
			String mime = this.getExtensao();
			String nome = this.getNomearquivo();
			byte[] foto = this.getFoto_menor();
    		StreamedContent streamedcontent = DefaultStreamedContent.builder()
    				.name(nome)
    				.contentType(mime).stream(()->new ByteArrayInputStream(foto))
    				.build();

			return(streamedcontent);
		}
		return new DefaultStreamedContent();
	}
	
}
