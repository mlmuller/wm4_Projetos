package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ControleProducaoZ.class)
public abstract class ControleProducaoZ_ {

	public static volatile SingularAttribute<ControleProducaoZ, GrupoMercado> grupomercado;
	public static volatile SingularAttribute<ControleProducaoZ, String> trilho;
	public static volatile SingularAttribute<ControleProducaoZ, String> usuariostamp;
	public static volatile SingularAttribute<ControleProducaoZ, Fabrica> fabricas;
	public static volatile SingularAttribute<ControleProducaoZ, TipoPrioridade> tipo;
	public static volatile SingularAttribute<ControleProducaoZ, SimNao> efetivado;
	public static volatile SingularAttribute<ControleProducaoZ, Date> data;
	public static volatile SingularAttribute<ControleProducaoZ, Long> controleproducaozid;
	public static volatile SingularAttribute<ControleProducaoZ, Integer> pares;
	public static volatile SingularAttribute<ControleProducaoZ, Date> datastamp;
	public static volatile SingularAttribute<ControleProducaoZ, LivroReferencia> livrosreferencias;

	public static final String GRUPOMERCADO = "grupomercado";
	public static final String TRILHO = "trilho";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String FABRICAS = "fabricas";
	public static final String TIPO = "tipo";
	public static final String EFETIVADO = "efetivado";
	public static final String DATA = "data";
	public static final String CONTROLEPRODUCAOZID = "controleproducaozid";
	public static final String PARES = "pares";
	public static final String DATASTAMP = "datastamp";
	public static final String LIVROSREFERENCIAS = "livrosreferencias";

}

