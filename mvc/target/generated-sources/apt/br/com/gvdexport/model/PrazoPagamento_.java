package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PrazoPagamento.class)
public abstract class PrazoPagamento_ {

	public static volatile SingularAttribute<PrazoPagamento, String> usuariostamp;
	public static volatile SingularAttribute<PrazoPagamento, Situacao> situacao;
	public static volatile SingularAttribute<PrazoPagamento, Long> prazopagamentoid;
	public static volatile SingularAttribute<PrazoPagamento, Date> datastamp;
	public static volatile SingularAttribute<PrazoPagamento, Integer> prazo;
	public static volatile SingularAttribute<PrazoPagamento, String> descricao;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String PRAZOPAGAMENTOID = "prazopagamentoid";
	public static final String DATASTAMP = "datastamp";
	public static final String PRAZO = "prazo";
	public static final String DESCRICAO = "descricao";

}

