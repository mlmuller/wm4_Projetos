package br.com.gvdexport.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Long> produtoid;
	public static volatile SingularAttribute<Produto, Situacao> situacao;
	public static volatile SingularAttribute<Produto, MarcaCliente> marcaCliente;
	public static volatile SingularAttribute<Produto, Material> material;
	public static volatile SingularAttribute<Produto, Cor> cor;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, String> reservamusical;
	public static volatile SingularAttribute<Produto, Cliente> clientes;
	public static volatile SingularAttribute<Produto, Componente> componente;
	public static volatile SingularAttribute<Produto, Modelo> modelo;
	public static volatile SingularAttribute<Produto, String> paresmusical;
	public static volatile SingularAttribute<Produto, LivroReferencia> livrosreferencias;

	public static final String PRODUTOID = "produtoid";
	public static final String SITUACAO = "situacao";
	public static final String MARCA_CLIENTE = "marcaCliente";
	public static final String MATERIAL = "material";
	public static final String COR = "cor";
	public static final String NOME = "nome";
	public static final String RESERVAMUSICAL = "reservamusical";
	public static final String CLIENTES = "clientes";
	public static final String COMPONENTE = "componente";
	public static final String MODELO = "modelo";
	public static final String PARESMUSICAL = "paresmusical";
	public static final String LIVROSREFERENCIAS = "livrosreferencias";

}

