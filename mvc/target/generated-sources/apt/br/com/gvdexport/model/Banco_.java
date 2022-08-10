package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Banco.class)
public abstract class Banco_ {

	public static volatile SingularAttribute<Banco, String> usuariostamp;
	public static volatile SingularAttribute<Banco, Situacao> situacao;
	public static volatile SingularAttribute<Banco, String> telefone;
	public static volatile SingularAttribute<Banco, String> endereco;
	public static volatile SingularAttribute<Banco, Date> datastamp;
	public static volatile SingularAttribute<Banco, String> nome;
	public static volatile SingularAttribute<Banco, String> agencia;
	public static volatile SingularAttribute<Banco, Long> bancoid;
	public static volatile SingularAttribute<Banco, TipoBanco> tipobanco;
	public static volatile SingularAttribute<Banco, String> enderecocomplementar;
	public static volatile SingularAttribute<Banco, String> sucinto;
	public static volatile SingularAttribute<Banco, String> fax;
	public static volatile SingularAttribute<Banco, String> email;
	public static volatile SingularAttribute<Banco, String> cgc;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String TELEFONE = "telefone";
	public static final String ENDERECO = "endereco";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String AGENCIA = "agencia";
	public static final String BANCOID = "bancoid";
	public static final String TIPOBANCO = "tipobanco";
	public static final String ENDERECOCOMPLEMENTAR = "enderecocomplementar";
	public static final String SUCINTO = "sucinto";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String CGC = "cgc";

}

