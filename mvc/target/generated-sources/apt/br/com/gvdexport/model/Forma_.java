package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Forma.class)
public abstract class Forma_ {

	public static volatile SingularAttribute<Forma, Fabrica> fabrica;
	public static volatile SingularAttribute<Forma, TipoCalcadoResumido> tipocalcado;
	public static volatile SingularAttribute<Forma, String> usuariostamp;
	public static volatile SingularAttribute<Forma, String> observacao;
	public static volatile SingularAttribute<Forma, Situacao> situacao;
	public static volatile SingularAttribute<Forma, LarguraForma> largura;
	public static volatile SingularAttribute<Forma, String> formasize;
	public static volatile SingularAttribute<Forma, String> nrogvd;
	public static volatile SingularAttribute<Forma, Long> formaid;
	public static volatile SingularAttribute<Forma, Date> datastamp;
	public static volatile SingularAttribute<Forma, Integer> circunferencia;
	public static volatile SingularAttribute<Forma, String> referenciafabrica;
	public static volatile SingularAttribute<Forma, String> altura;
	public static volatile SingularAttribute<Forma, String> referenciaforma;
	public static volatile SingularAttribute<Forma, Integer> comprimento;
	public static volatile SingularAttribute<Forma, Integer> totalformasestoque;
	public static volatile SingularAttribute<Forma, TipoBico> bico;
	public static volatile SingularAttribute<Forma, Integer> base;

	public static final String FABRICA = "fabrica";
	public static final String TIPOCALCADO = "tipocalcado";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String OBSERVACAO = "observacao";
	public static final String SITUACAO = "situacao";
	public static final String LARGURA = "largura";
	public static final String FORMASIZE = "formasize";
	public static final String NROGVD = "nrogvd";
	public static final String FORMAID = "formaid";
	public static final String DATASTAMP = "datastamp";
	public static final String CIRCUNFERENCIA = "circunferencia";
	public static final String REFERENCIAFABRICA = "referenciafabrica";
	public static final String ALTURA = "altura";
	public static final String REFERENCIAFORMA = "referenciaforma";
	public static final String COMPRIMENTO = "comprimento";
	public static final String TOTALFORMASESTOQUE = "totalformasestoque";
	public static final String BICO = "bico";
	public static final String BASE = "base";

}

