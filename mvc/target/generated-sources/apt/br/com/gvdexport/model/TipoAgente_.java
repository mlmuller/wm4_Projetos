package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoAgente.class)
public abstract class TipoAgente_ {

	public static volatile SingularAttribute<TipoAgente, String> usuariostamp;
	public static volatile SingularAttribute<TipoAgente, Situacao> situacao;
	public static volatile SingularAttribute<TipoAgente, Long> tipoagenteid;
	public static volatile SingularAttribute<TipoAgente, Date> datastamp;
	public static volatile SingularAttribute<TipoAgente, String> sucinto;
	public static volatile SingularAttribute<TipoAgente, String> nome;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String TIPOAGENTEID = "tipoagenteid";
	public static final String DATASTAMP = "datastamp";
	public static final String SUCINTO = "sucinto";
	public static final String NOME = "nome";

}

