package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AutorizacaoReimpressao.class)
public abstract class AutorizacaoReimpressao_ {

	public static volatile SingularAttribute<AutorizacaoReimpressao, String> usuariostamp;
	public static volatile SingularAttribute<AutorizacaoReimpressao, Long> sequencia;
	public static volatile SingularAttribute<AutorizacaoReimpressao, Long> autorizacaoreimpressaoid;
	public static volatile SingularAttribute<AutorizacaoReimpressao, Date> datastamp;
	public static volatile SingularAttribute<AutorizacaoReimpressao, RazaoImpressao> razaoimpressao;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SEQUENCIA = "sequencia";
	public static final String AUTORIZACAOREIMPRESSAOID = "autorizacaoreimpressaoid";
	public static final String DATASTAMP = "datastamp";
	public static final String RAZAOIMPRESSAO = "razaoimpressao";

}

