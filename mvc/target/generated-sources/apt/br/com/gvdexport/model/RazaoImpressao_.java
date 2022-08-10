package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RazaoImpressao.class)
public abstract class RazaoImpressao_ {

	public static volatile SingularAttribute<RazaoImpressao, String> usuariostamp;
	public static volatile SingularAttribute<RazaoImpressao, Date> datastamp;
	public static volatile SingularAttribute<RazaoImpressao, Long> razaoimpressaoid;
	public static volatile SingularAttribute<RazaoImpressao, String> descricao;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String DATASTAMP = "datastamp";
	public static final String RAZAOIMPRESSAOID = "razaoimpressaoid";
	public static final String DESCRICAO = "descricao";

}

