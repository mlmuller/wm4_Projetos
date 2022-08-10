package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Notificar.class)
public abstract class Notificar_ {

	public static volatile SingularAttribute<Notificar, String> usuariostamp;
	public static volatile SingularAttribute<Notificar, Situacao> situacao;
	public static volatile SingularAttribute<Notificar, String> endereco;
	public static volatile SingularAttribute<Notificar, Long> notificarid;
	public static volatile SingularAttribute<Notificar, Date> datastamp;
	public static volatile SingularAttribute<Notificar, String> nome;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String ENDERECO = "endereco";
	public static final String NOTIFICARID = "notificarid";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";

}

