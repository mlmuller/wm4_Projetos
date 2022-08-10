package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ControleProducao.class)
public abstract class ControleProducao_ {

	public static volatile SingularAttribute<ControleProducao, GrupoMercado> grupomercado;
	public static volatile SingularAttribute<ControleProducao, String> trilho;
	public static volatile SingularAttribute<ControleProducao, String> usuariostamp;
	public static volatile SingularAttribute<ControleProducao, Fabrica> fabricas;
	public static volatile SingularAttribute<ControleProducao, TipoPrioridade> tipo;
	public static volatile SingularAttribute<ControleProducao, SimNao> efetivado;
	public static volatile SingularAttribute<ControleProducao, Date> data;
	public static volatile SingularAttribute<ControleProducao, Integer> pares;
	public static volatile SingularAttribute<ControleProducao, Date> datastamp;
	public static volatile SingularAttribute<ControleProducao, Long> controleproducaoid;
	public static volatile SingularAttribute<ControleProducao, LivroReferencia> livrosreferencias;

	public static final String GRUPOMERCADO = "grupomercado";
	public static final String TRILHO = "trilho";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String FABRICAS = "fabricas";
	public static final String TIPO = "tipo";
	public static final String EFETIVADO = "efetivado";
	public static final String DATA = "data";
	public static final String PARES = "pares";
	public static final String DATASTAMP = "datastamp";
	public static final String CONTROLEPRODUCAOID = "controleproducaoid";
	public static final String LIVROSREFERENCIAS = "livrosreferencias";

}

