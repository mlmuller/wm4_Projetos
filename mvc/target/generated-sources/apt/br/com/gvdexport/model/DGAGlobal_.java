package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DGAGlobal.class)
public abstract class DGAGlobal_ {

	public static volatile SingularAttribute<DGAGlobal, String> usuariostamp;
	public static volatile SingularAttribute<DGAGlobal, String> grupocomponente;
	public static volatile SingularAttribute<DGAGlobal, Situacao> situacao;
	public static volatile SingularAttribute<DGAGlobal, String> parametro;
	public static volatile SingularAttribute<DGAGlobal, String> valor;
	public static volatile SingularAttribute<DGAGlobal, Date> datastamp;
	public static volatile SingularAttribute<DGAGlobal, Long> dgaglobalid;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String GRUPOCOMPONENTE = "grupocomponente";
	public static final String SITUACAO = "situacao";
	public static final String PARAMETRO = "parametro";
	public static final String VALOR = "valor";
	public static final String DATASTAMP = "datastamp";
	public static final String DGAGLOBALID = "dgaglobalid";

}

