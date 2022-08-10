package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DGAPrivilegio.class)
public abstract class DGAPrivilegio_ {

	public static volatile SingularAttribute<DGAPrivilegio, String> usuariostamp;
	public static volatile SingularAttribute<DGAPrivilegio, DGAMenu> dgamenu;
	public static volatile SingularAttribute<DGAPrivilegio, Long> dgamoduloid;
	public static volatile SingularAttribute<DGAPrivilegio, Boolean> privdelete;
	public static volatile SingularAttribute<DGAPrivilegio, String> privwhere;
	public static volatile SingularAttribute<DGAPrivilegio, Date> datastamp;
	public static volatile SingularAttribute<DGAPrivilegio, DGAModulo> dgamodulo;
	public static volatile SingularAttribute<DGAPrivilegio, Long> dgausuarioid;
	public static volatile SingularAttribute<DGAPrivilegio, DGASistema> dgasistema;
	public static volatile SingularAttribute<DGAPrivilegio, Integer> permissao;
	public static volatile SingularAttribute<DGAPrivilegio, Boolean> privupdate;
	public static volatile SingularAttribute<DGAPrivilegio, Boolean> privinsert;
	public static volatile SingularAttribute<DGAPrivilegio, String> nomemenu;
	public static volatile SingularAttribute<DGAPrivilegio, String> nomeModulo;
	public static volatile SingularAttribute<DGAPrivilegio, String> nomesistema;
	public static volatile SingularAttribute<DGAPrivilegio, Long> privilegioid;
	public static volatile SingularAttribute<DGAPrivilegio, Integer> ordem;
	public static volatile SingularAttribute<DGAPrivilegio, String> grpcomponente;
	public static volatile SingularAttribute<DGAPrivilegio, Usuario> usuario;
	public static volatile SingularAttribute<DGAPrivilegio, String> caminho;
	public static volatile SingularAttribute<DGAPrivilegio, Boolean> privselect;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String DGAMENU = "dgamenu";
	public static final String DGAMODULOID = "dgamoduloid";
	public static final String PRIVDELETE = "privdelete";
	public static final String PRIVWHERE = "privwhere";
	public static final String DATASTAMP = "datastamp";
	public static final String DGAMODULO = "dgamodulo";
	public static final String DGAUSUARIOID = "dgausuarioid";
	public static final String DGASISTEMA = "dgasistema";
	public static final String PERMISSAO = "permissao";
	public static final String PRIVUPDATE = "privupdate";
	public static final String PRIVINSERT = "privinsert";
	public static final String NOMEMENU = "nomemenu";
	public static final String NOME_MODULO = "nomeModulo";
	public static final String NOMESISTEMA = "nomesistema";
	public static final String PRIVILEGIOID = "privilegioid";
	public static final String ORDEM = "ordem";
	public static final String GRPCOMPONENTE = "grpcomponente";
	public static final String USUARIO = "usuario";
	public static final String CAMINHO = "caminho";
	public static final String PRIVSELECT = "privselect";

}

