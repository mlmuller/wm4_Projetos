package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LivroReferencia.class)
public abstract class LivroReferencia_ {

	public static volatile SingularAttribute<LivroReferencia, String> referenciacliente;
	public static volatile SingularAttribute<LivroReferencia, Long> livroreferenciaid;
	public static volatile SingularAttribute<LivroReferencia, String> usuariostamp;
	public static volatile SingularAttribute<LivroReferencia, Integer> versaorefer;
	public static volatile SingularAttribute<LivroReferencia, String> abreviacao;
	public static volatile SingularAttribute<LivroReferencia, Date> dataokmodelo;
	public static volatile SingularAttribute<LivroReferencia, Date> datastamp;
	public static volatile SingularAttribute<LivroReferencia, String> construcaonome;
	public static volatile SingularAttribute<LivroReferencia, String> referenciaforma;
	public static volatile SingularAttribute<LivroReferencia, Personagem> personagem;
	public static volatile SingularAttribute<LivroReferencia, Construcao> construcao;
	public static volatile SingularAttribute<LivroReferencia, Integer> referencia;
	public static volatile SingularAttribute<LivroReferencia, Integer> versao;

	public static final String REFERENCIACLIENTE = "referenciacliente";
	public static final String LIVROREFERENCIAID = "livroreferenciaid";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String VERSAOREFER = "versaorefer";
	public static final String ABREVIACAO = "abreviacao";
	public static final String DATAOKMODELO = "dataokmodelo";
	public static final String DATASTAMP = "datastamp";
	public static final String CONSTRUCAONOME = "construcaonome";
	public static final String REFERENCIAFORMA = "referenciaforma";
	public static final String PERSONAGEM = "personagem";
	public static final String CONSTRUCAO = "construcao";
	public static final String REFERENCIA = "referencia";
	public static final String VERSAO = "versao";

}

