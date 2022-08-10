package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estado.class)
public abstract class Estado_ {

	public static volatile SingularAttribute<Estado, String> usuariostamp;
	public static volatile SingularAttribute<Estado, String> sigla;
	public static volatile SingularAttribute<Estado, String> codigoibge;
	public static volatile SingularAttribute<Estado, Date> datastamp;
	public static volatile SingularAttribute<Estado, Long> estadoid;
	public static volatile SingularAttribute<Estado, String> nome;
	public static volatile SingularAttribute<Estado, Regiao> regiao;
	public static volatile SingularAttribute<Estado, Pais> pais;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SIGLA = "sigla";
	public static final String CODIGOIBGE = "codigoibge";
	public static final String DATASTAMP = "datastamp";
	public static final String ESTADOID = "estadoid";
	public static final String NOME = "nome";
	public static final String REGIAO = "regiao";
	public static final String PAIS = "pais";

}

