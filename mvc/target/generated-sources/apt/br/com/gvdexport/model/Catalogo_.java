package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Catalogo.class)
public abstract class Catalogo_ {

	public static volatile SingularAttribute<Catalogo, Long> catalogoid;
	public static volatile SingularAttribute<Catalogo, String> usuariostamp;
	public static volatile SingularAttribute<Catalogo, TipoFrete> tipofrete;
	public static volatile SingularAttribute<Catalogo, Moeda> moedafob;
	public static volatile SingularAttribute<Catalogo, Date> datastamp;
	public static volatile SingularAttribute<Catalogo, TipoFrete> tipofrete2;
	public static volatile SingularAttribute<Catalogo, SituacaoCatalogo> situacaocatalogo;
	public static volatile SingularAttribute<Catalogo, String> nome;
	public static volatile SingularAttribute<Catalogo, Integer> numerocatalogo;
	public static volatile SingularAttribute<Catalogo, Date> datacatalogo;
	public static volatile SingularAttribute<Catalogo, String> texto;
	public static volatile SingularAttribute<Catalogo, Cliente> cliente;
	public static volatile SingularAttribute<Catalogo, Moeda> moeda;
	public static volatile SingularAttribute<Catalogo, Estacao> estacao;
	public static volatile SingularAttribute<Catalogo, Mercado> mercado;
	public static volatile SingularAttribute<Catalogo, Moeda> moedapvp;
	public static volatile SingularAttribute<Catalogo, String> formularecosto;

	public static final String CATALOGOID = "catalogoid";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String TIPOFRETE = "tipofrete";
	public static final String MOEDAFOB = "moedafob";
	public static final String DATASTAMP = "datastamp";
	public static final String TIPOFRETE2 = "tipofrete2";
	public static final String SITUACAOCATALOGO = "situacaocatalogo";
	public static final String NOME = "nome";
	public static final String NUMEROCATALOGO = "numerocatalogo";
	public static final String DATACATALOGO = "datacatalogo";
	public static final String TEXTO = "texto";
	public static final String CLIENTE = "cliente";
	public static final String MOEDA = "moeda";
	public static final String ESTACAO = "estacao";
	public static final String MERCADO = "mercado";
	public static final String MOEDAPVP = "moedapvp";
	public static final String FORMULARECOSTO = "formularecosto";

}

