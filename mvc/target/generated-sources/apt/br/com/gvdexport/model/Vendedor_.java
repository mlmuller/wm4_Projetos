package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vendedor.class)
public abstract class Vendedor_ {

	public static volatile SingularAttribute<Vendedor, String> percentualcomissao;
	public static volatile SingularAttribute<Vendedor, String> usuariostamp;
	public static volatile SingularAttribute<Vendedor, String> telefone;
	public static volatile SingularAttribute<Vendedor, String> observacao;
	public static volatile SingularAttribute<Vendedor, Situacao> situacao;
	public static volatile SingularAttribute<Vendedor, Cidade> cidade;
	public static volatile SingularAttribute<Vendedor, String> endereco;
	public static volatile SingularAttribute<Vendedor, TipoVendedor> tipovendedor;
	public static volatile SingularAttribute<Vendedor, Date> datastamp;
	public static volatile SingularAttribute<Vendedor, String> nome;
	public static volatile SingularAttribute<Vendedor, String> sucinto;
	public static volatile SingularAttribute<Vendedor, Long> vendedorid;
	public static volatile SingularAttribute<Vendedor, String> valorcomissao;
	public static volatile SingularAttribute<Vendedor, String> email;

	public static final String PERCENTUALCOMISSAO = "percentualcomissao";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String TELEFONE = "telefone";
	public static final String OBSERVACAO = "observacao";
	public static final String SITUACAO = "situacao";
	public static final String CIDADE = "cidade";
	public static final String ENDERECO = "endereco";
	public static final String TIPOVENDEDOR = "tipovendedor";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String SUCINTO = "sucinto";
	public static final String VENDEDORID = "vendedorid";
	public static final String VALORCOMISSAO = "valorcomissao";
	public static final String EMAIL = "email";

}

