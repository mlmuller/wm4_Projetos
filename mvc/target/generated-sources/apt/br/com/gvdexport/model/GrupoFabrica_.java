package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GrupoFabrica.class)
public abstract class GrupoFabrica_ {

	public static volatile SingularAttribute<GrupoFabrica, String> usuariostamp;
	public static volatile SingularAttribute<GrupoFabrica, Prioridade> prioridade;
	public static volatile SingularAttribute<GrupoFabrica, Long> fabricagrpid;
	public static volatile SingularAttribute<GrupoFabrica, Date> datastamp;
	public static volatile SingularAttribute<GrupoFabrica, String> sucinto;
	public static volatile SingularAttribute<GrupoFabrica, String> nome;
	public static volatile SingularAttribute<GrupoFabrica, QuadroFabrica> quadrofabrica;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String PRIORIDADE = "prioridade";
	public static final String FABRICAGRPID = "fabricagrpid";
	public static final String DATASTAMP = "datastamp";
	public static final String SUCINTO = "sucinto";
	public static final String NOME = "nome";
	public static final String QUADROFABRICA = "quadrofabrica";

}

