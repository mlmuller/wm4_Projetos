package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Material.class)
public abstract class Material_ {

	public static volatile SingularAttribute<Material, String> resumido;
	public static volatile SingularAttribute<Material, String> usuariostamp;
	public static volatile SingularAttribute<Material, Situacao> situacao;
	public static volatile SingularAttribute<Material, Date> datastamp;
	public static volatile SingularAttribute<Material, String> nome;
	public static volatile SingularAttribute<Material, String> nomeingles;
	public static volatile SingularAttribute<Material, Long> materialid;
	public static volatile SingularAttribute<Material, String> nomeespanhol;

	public static final String RESUMIDO = "resumido";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String NOMEINGLES = "nomeingles";
	public static final String MATERIALID = "materialid";
	public static final String NOMEESPANHOL = "nomeespanhol";

}

