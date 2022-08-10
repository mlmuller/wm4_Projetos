package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RazaoAlteracao.class)
public abstract class RazaoAlteracao_ {

	public static volatile SingularAttribute<RazaoAlteracao, TipoRazao> tiporazao;
	public static volatile SingularAttribute<RazaoAlteracao, String> usuariostamp;
	public static volatile SingularAttribute<RazaoAlteracao, Situacao> situacao;
	public static volatile SingularAttribute<RazaoAlteracao, Long> razaoalteracaoid;
	public static volatile SingularAttribute<RazaoAlteracao, Date> datastamp;
	public static volatile SingularAttribute<RazaoAlteracao, String> descricao;

	public static final String TIPORAZAO = "tiporazao";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String RAZAOALTERACAOID = "razaoalteracaoid";
	public static final String DATASTAMP = "datastamp";
	public static final String DESCRICAO = "descricao";

}

