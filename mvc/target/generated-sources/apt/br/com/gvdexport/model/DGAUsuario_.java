package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DGAUsuario.class)
public abstract class DGAUsuario_ {

	public static volatile SingularAttribute<DGAUsuario, String> senha;
	public static volatile SingularAttribute<DGAUsuario, String> usuariostamp;
	public static volatile SingularAttribute<DGAUsuario, Date> datastamp;
	public static volatile SingularAttribute<DGAUsuario, Long> dgausuarioid;
	public static volatile SingularAttribute<DGAUsuario, String> nome;
	public static volatile SingularAttribute<DGAUsuario, Long> id;
	public static volatile SingularAttribute<DGAUsuario, DGASistema> dgasistema;
	public static volatile SingularAttribute<DGAUsuario, String> username;

	public static final String SENHA = "senha";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String DATASTAMP = "datastamp";
	public static final String DGAUSUARIOID = "dgausuarioid";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String DGASISTEMA = "dgasistema";
	public static final String USERNAME = "username";

}

