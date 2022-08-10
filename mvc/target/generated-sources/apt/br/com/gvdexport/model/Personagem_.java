package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Personagem.class)
public abstract class Personagem_ {

	public static volatile SingularAttribute<Personagem, String> usuariostamp;
	public static volatile SingularAttribute<Personagem, Long> personagemid;
	public static volatile SingularAttribute<Personagem, Date> datastamp;
	public static volatile SingularAttribute<Personagem, String> nome;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String PERSONAGEMID = "personagemid";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";

}

