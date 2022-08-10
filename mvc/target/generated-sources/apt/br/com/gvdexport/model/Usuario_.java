package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> usuariostamp;
	public static volatile SingularAttribute<Usuario, Situacao> situacao;
	public static volatile SingularAttribute<Usuario, String> senhaconversao;
	public static volatile SingularAttribute<Usuario, Grupo> grupo;
	public static volatile SingularAttribute<Usuario, Date> datastamp;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, Idioma> idioma;
	public static volatile SingularAttribute<Usuario, Long> usuarioid;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, Cliente> cliente;
	public static volatile SingularAttribute<Usuario, SimNao> liberafinanceiro;
	public static volatile SingularAttribute<Usuario, Mercado> mercado;
	public static volatile SingularAttribute<Usuario, String> usuario;
	public static volatile SingularAttribute<Usuario, String> email;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String SENHACONVERSAO = "senhaconversao";
	public static final String GRUPO = "grupo";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String IDIOMA = "idioma";
	public static final String USUARIOID = "usuarioid";
	public static final String SENHA = "senha";
	public static final String CLIENTE = "cliente";
	public static final String LIBERAFINANCEIRO = "liberafinanceiro";
	public static final String MERCADO = "mercado";
	public static final String USUARIO = "usuario";
	public static final String EMAIL = "email";

}

