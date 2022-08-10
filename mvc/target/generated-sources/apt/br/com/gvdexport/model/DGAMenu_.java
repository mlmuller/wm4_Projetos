package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DGAMenu.class)
public abstract class DGAMenu_ {

	public static volatile SingularAttribute<DGAMenu, String> usuariostamp;
	public static volatile SingularAttribute<DGAMenu, String> stylemenu;
	public static volatile SingularAttribute<DGAMenu, String> hint;
	public static volatile SingularAttribute<DGAMenu, Integer> ordem;
	public static volatile SingularAttribute<DGAMenu, Date> datastamp;
	public static volatile SingularAttribute<DGAMenu, String> nome;
	public static volatile SingularAttribute<DGAMenu, DGASistema> dgasistema;
	public static volatile SingularAttribute<DGAMenu, Long> dgamenuid;
	public static volatile SingularAttribute<DGAMenu, String> barramenu;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String STYLEMENU = "stylemenu";
	public static final String HINT = "hint";
	public static final String ORDEM = "ordem";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String DGASISTEMA = "dgasistema";
	public static final String DGAMENUID = "dgamenuid";
	public static final String BARRAMENU = "barramenu";

}

