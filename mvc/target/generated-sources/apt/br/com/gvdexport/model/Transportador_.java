package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transportador.class)
public abstract class Transportador_ {

	public static volatile SingularAttribute<Transportador, String> usuariostamp;
	public static volatile SingularAttribute<Transportador, Situacao> situacao;
	public static volatile SingularAttribute<Transportador, Cidade> cidade;
	public static volatile SingularAttribute<Transportador, String> endereco;
	public static volatile SingularAttribute<Transportador, Long> transportadoraid;
	public static volatile SingularAttribute<Transportador, String> inscrest;
	public static volatile SingularAttribute<Transportador, Date> datastamp;
	public static volatile SingularAttribute<Transportador, String> nome;
	public static volatile SingularAttribute<Transportador, String> nomecidade;
	public static volatile SingularAttribute<Transportador, String> cep;
	public static volatile SingularAttribute<Transportador, String> uf;
	public static volatile SingularAttribute<Transportador, String> sucinto;
	public static volatile SingularAttribute<Transportador, String> cgc;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String CIDADE = "cidade";
	public static final String ENDERECO = "endereco";
	public static final String TRANSPORTADORAID = "transportadoraid";
	public static final String INSCREST = "inscrest";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String NOMECIDADE = "nomecidade";
	public static final String CEP = "cep";
	public static final String UF = "uf";
	public static final String SUCINTO = "sucinto";
	public static final String CGC = "cgc";

}

