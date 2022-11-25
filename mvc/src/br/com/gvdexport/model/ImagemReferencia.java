package br.com.gvdexport.model;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ImagemReferencia",uniqueConstraints = {@UniqueConstraint(columnNames={"abreviacao","imre_lire_fk","versaorefer","tipoimagem"},name="lrim_tipo_uk")},indexes=@Index(columnList="imre_lire_fk,tipoimagem",name="imre_lire_ifk"))
@Getter @Setter
public class ImagemReferencia implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO ,generator = "imreferenciaseq")
	@SequenceGenerator(name= "imreferenciaseq",sequenceName = "s_imreferencia", allocationSize = 1)
	@Column(name="imlire_pk",updatable=false,nullable=false)
	private Long imagemlivroreferenciaid;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private TipoImagem tipoimagem;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoGrupoProduto tipogrupoimagem;

	@Column(length = 6 ,nullable = false)
	private Integer referencia;
	
	@Column(length = 2,nullable = false , columnDefinition = "smallint")
	private Integer versaorefer;

	
	@Column(length = 3, nullable = true)
	private String abreviacao;

	@Column(length = 16 , nullable = true)
	private String construcaonome;
	
	@Column(length = 10, nullable = true)
	private  String referenciaforma;
	
	@Column(length = 2,nullable = true)
	private Integer versao;

	@Column(length = 5,nullable = false)
	private String extensao;
	
	@Column(length = 25 , nullable = false)
	private String nomearquivo;

	@Column(length = 25 , nullable = true)
	private String caminhoarquivo;
	
	@Lob
	@Column(name="imagem",nullable=true)
	private byte[] foto ;
	
	@Column(length = 5,nullable = true)
	private String imwidth;
	
	@Column(length = 5, nullable = true)
	private String imheight;

	@Lob
	@Column(name="imagemb",nullable=true)
	private byte[] fotob ;

	@Column(length = 5,nullable = true)
	private String imwidthb;
	
	@Column(length = 5, nullable = true)
	private String imheightb;

	@Transient
	public StreamedContent getImagem() {
		if (this.getFoto() != null) {
			String mime = this.getExtensao();
			String nome = this.getNomearquivo();
			byte[] foto = this.getFoto();
    		StreamedContent streamedcontent = DefaultStreamedContent.builder()
    				.name(nome)
    				.contentType(mime).stream(()->new ByteArrayInputStream(foto))
    				.build();

			return(streamedcontent);
		}
		return new DefaultStreamedContent();
	}
	
	@Transient
	public StreamedContent getImagemCar() {
		if (this.getFotob() != null) {
			String mimeb = this.getExtensao();
			String nomeb = this.getNomearquivo();
			byte[] fotob = this.getFotob();
    		StreamedContent streamedcontent = DefaultStreamedContent.builder()
    				.name(nomeb)
    				.contentType(mimeb).stream(()->new ByteArrayInputStream(fotob))
    				.build();

			return(streamedcontent);
		}
		return new DefaultStreamedContent();
	}
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="imre_lire_fk",referencedColumnName="lire_pk",nullable=false,foreignKey=@ForeignKey(name="imre_lire_fk"))
	private LivroReferencia livroreferencia;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imagemlivroreferenciaid == null) ? 0 : imagemlivroreferenciaid.hashCode());
		result = prime * result + ((tipoimagem == null) ? 0 : tipoimagem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImagemReferencia other = (ImagemReferencia) obj;
		if (imagemlivroreferenciaid == null) {
			if (other.imagemlivroreferenciaid != null)
				return false;
		} else if (!imagemlivroreferenciaid.equals(other.imagemlivroreferenciaid))
			return false;
		if (tipoimagem != other.tipoimagem)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImagemReferencia [imagemlivroreferenciaid=" + imagemlivroreferenciaid + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}


}
