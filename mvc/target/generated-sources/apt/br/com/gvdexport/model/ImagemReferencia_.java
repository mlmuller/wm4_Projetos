package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ImagemReferencia.class)
public abstract class ImagemReferencia_ {

	public static volatile SingularAttribute<ImagemReferencia, String> extensao;
	public static volatile SingularAttribute<ImagemReferencia, String> usuariostamp;
	public static volatile SingularAttribute<ImagemReferencia, Integer> versaorefer;
	public static volatile SingularAttribute<ImagemReferencia, Long> imagemlivroreferenciaid;
	public static volatile SingularAttribute<ImagemReferencia, String> abreviacao;
	public static volatile SingularAttribute<ImagemReferencia, Date> datastamp;
	public static volatile SingularAttribute<ImagemReferencia, TipoGrupoProduto> tipogrupoimagem;
	public static volatile SingularAttribute<ImagemReferencia, String> construcaonome;
	public static volatile SingularAttribute<ImagemReferencia, TipoImagem> tipoimagem;
	public static volatile SingularAttribute<ImagemReferencia, String> imwidth;
	public static volatile SingularAttribute<ImagemReferencia, String> imheight;
	public static volatile SingularAttribute<ImagemReferencia, byte[]> foto;
	public static volatile SingularAttribute<ImagemReferencia, LivroReferencia> livroreferencia;
	public static volatile SingularAttribute<ImagemReferencia, String> referenciaforma;
	public static volatile SingularAttribute<ImagemReferencia, Integer> referencia;
	public static volatile SingularAttribute<ImagemReferencia, Integer> versao;
	public static volatile SingularAttribute<ImagemReferencia, String> nomearquivo;

	public static final String EXTENSAO = "extensao";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String VERSAOREFER = "versaorefer";
	public static final String IMAGEMLIVROREFERENCIAID = "imagemlivroreferenciaid";
	public static final String ABREVIACAO = "abreviacao";
	public static final String DATASTAMP = "datastamp";
	public static final String TIPOGRUPOIMAGEM = "tipogrupoimagem";
	public static final String CONSTRUCAONOME = "construcaonome";
	public static final String TIPOIMAGEM = "tipoimagem";
	public static final String IMWIDTH = "imwidth";
	public static final String IMHEIGHT = "imheight";
	public static final String FOTO = "foto";
	public static final String LIVROREFERENCIA = "livroreferencia";
	public static final String REFERENCIAFORMA = "referenciaforma";
	public static final String REFERENCIA = "referencia";
	public static final String VERSAO = "versao";
	public static final String NOMEARQUIVO = "nomearquivo";

}

