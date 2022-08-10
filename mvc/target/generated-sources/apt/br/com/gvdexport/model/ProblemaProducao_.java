package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProblemaProducao.class)
public abstract class ProblemaProducao_ {

	public static volatile SingularAttribute<ProblemaProducao, Long> sequenciaproblemaproducao;
	public static volatile SingularAttribute<ProblemaProducao, Long> fichaproducaoid;
	public static volatile SingularAttribute<ProblemaProducao, String> usuariostamp;
	public static volatile SingularAttribute<ProblemaProducao, Setor> setor;
	public static volatile SingularAttribute<ProblemaProducao, SimNao> refazer;
	public static volatile SingularAttribute<ProblemaProducao, String> observacao;
	public static volatile SingularAttribute<ProblemaProducao, Date> data;
	public static volatile SingularAttribute<ProblemaProducao, BigDecimal> pares;
	public static volatile SingularAttribute<ProblemaProducao, Date> datastamp;
	public static volatile SingularAttribute<ProblemaProducao, FichaProducao> fichaproducaodestino;
	public static volatile SingularAttribute<ProblemaProducao, FichaProducao> fichaproducao;
	public static volatile SingularAttribute<ProblemaProducao, MotivoProducao> motivoproducao;

	public static final String SEQUENCIAPROBLEMAPRODUCAO = "sequenciaproblemaproducao";
	public static final String FICHAPRODUCAOID = "fichaproducaoid";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SETOR = "setor";
	public static final String REFAZER = "refazer";
	public static final String OBSERVACAO = "observacao";
	public static final String DATA = "data";
	public static final String PARES = "pares";
	public static final String DATASTAMP = "datastamp";
	public static final String FICHAPRODUCAODESTINO = "fichaproducaodestino";
	public static final String FICHAPRODUCAO = "fichaproducao";
	public static final String MOTIVOPRODUCAO = "motivoproducao";

}

