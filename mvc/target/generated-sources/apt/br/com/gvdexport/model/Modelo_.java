package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Modelo.class)
public abstract class Modelo_ {

	public static volatile SingularAttribute<Modelo, String> usuariostamp;
	public static volatile SingularAttribute<Modelo, Integer> versaorefer;
	public static volatile SingularAttribute<Modelo, Situacao> situacao;
	public static volatile SingularAttribute<Modelo, String> nomeestacao;
	public static volatile SingularAttribute<Modelo, Date> datastamp;
	public static volatile SingularAttribute<Modelo, String> nome;
	public static volatile SingularAttribute<Modelo, String> construcaonome;
	public static volatile SingularAttribute<Modelo, Cliente> cliente;
	public static volatile SingularAttribute<Modelo, Estacao> estacao;
	public static volatile SingularAttribute<Modelo, LivroReferencia> livroreferencia;
	public static volatile SingularAttribute<Modelo, String> referenciaforma;
	public static volatile SingularAttribute<Modelo, String> sucinto;
	public static volatile SingularAttribute<Modelo, Long> modeloid;
	public static volatile SingularAttribute<Modelo, Integer> versao;
	public static volatile SingularAttribute<Modelo, Integer> referencia;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String VERSAOREFER = "versaorefer";
	public static final String SITUACAO = "situacao";
	public static final String NOMEESTACAO = "nomeestacao";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String CONSTRUCAONOME = "construcaonome";
	public static final String CLIENTE = "cliente";
	public static final String ESTACAO = "estacao";
	public static final String LIVROREFERENCIA = "livroreferencia";
	public static final String REFERENCIAFORMA = "referenciaforma";
	public static final String SUCINTO = "sucinto";
	public static final String MODELOID = "modeloid";
	public static final String VERSAO = "versao";
	public static final String REFERENCIA = "referencia";

}

