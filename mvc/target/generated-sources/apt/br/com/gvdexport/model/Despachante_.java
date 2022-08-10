package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Despachante.class)
public abstract class Despachante_ {

	public static volatile SingularAttribute<Despachante, String> valorpordde;
	public static volatile SingularAttribute<Despachante, String> usuariostamp;
	public static volatile SingularAttribute<Despachante, String> cidade;
	public static volatile SingularAttribute<Despachante, Situacao> situacao;
	public static volatile SingularAttribute<Despachante, String> endereco;
	public static volatile SingularAttribute<Despachante, Date> datastamp;
	public static volatile SingularAttribute<Despachante, String> nome;
	public static volatile SingularAttribute<Despachante, Cidade> cidades;
	public static volatile SingularAttribute<Despachante, String> inscricaoestadual;
	public static volatile SingularAttribute<Despachante, String> cep;
	public static volatile SingularAttribute<Despachante, String> uf;
	public static volatile SingularAttribute<Despachante, Long> despachanteid;
	public static volatile SingularAttribute<Despachante, BigDecimal> valorporcaminhao;
	public static volatile SingularAttribute<Despachante, String> sucinto;
	public static volatile SingularAttribute<Despachante, String> cgc;

	public static final String VALORPORDDE = "valorpordde";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String CIDADE = "cidade";
	public static final String SITUACAO = "situacao";
	public static final String ENDERECO = "endereco";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String CIDADES = "cidades";
	public static final String INSCRICAOESTADUAL = "inscricaoestadual";
	public static final String CEP = "cep";
	public static final String UF = "uf";
	public static final String DESPACHANTEID = "despachanteid";
	public static final String VALORPORCAMINHAO = "valorporcaminhao";
	public static final String SUCINTO = "sucinto";
	public static final String CGC = "cgc";

}

