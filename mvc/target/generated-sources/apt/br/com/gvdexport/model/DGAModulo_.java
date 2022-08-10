package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DGAModulo.class)
public abstract class DGAModulo_ {

	public static volatile SingularAttribute<DGAModulo, String> usuariostamp;
	public static volatile SingularAttribute<DGAModulo, DGAMenu> dgamenu;
	public static volatile SingularAttribute<DGAModulo, String> classe;
	public static volatile SingularAttribute<DGAModulo, Situacao> situacao;
	public static volatile SingularAttribute<DGAModulo, Long> dgamoduloid;
	public static volatile SingularAttribute<DGAModulo, Date> datastamp;
	public static volatile SingularAttribute<DGAModulo, String> nome;
	public static volatile SingularAttribute<DGAModulo, String> url;
	public static volatile SingularAttribute<DGAModulo, String> hint;
	public static volatile SingularAttribute<DGAModulo, Integer> ordem;
	public static volatile SingularAttribute<DGAModulo, String> grpcomponente;
	public static volatile SingularAttribute<DGAModulo, SimNao> monousuario;
	public static volatile SingularAttribute<DGAModulo, DGAImpressora> dgaimpressora;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String DGAMENU = "dgamenu";
	public static final String CLASSE = "classe";
	public static final String SITUACAO = "situacao";
	public static final String DGAMODULOID = "dgamoduloid";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String URL = "url";
	public static final String HINT = "hint";
	public static final String ORDEM = "ordem";
	public static final String GRPCOMPONENTE = "grpcomponente";
	public static final String MONOUSUARIO = "monousuario";
	public static final String DGAIMPRESSORA = "dgaimpressora";

}

