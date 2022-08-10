package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ParametroEmpresa.class)
public abstract class ParametroEmpresa_ {

	public static volatile SingularAttribute<ParametroEmpresa, BigDecimal> percdesagioslipfabrica;
	public static volatile SingularAttribute<ParametroEmpresa, Integer> anocorrente;
	public static volatile SingularAttribute<ParametroEmpresa, String> usuariostamp;
	public static volatile SingularAttribute<ParametroEmpresa, LivroReferencia> livrosreferencia;
	public static volatile SingularAttribute<ParametroEmpresa, Date> datastamp;
	public static volatile SingularAttribute<ParametroEmpresa, String> unidade;
	public static volatile SingularAttribute<ParametroEmpresa, BigDecimal> taxafrete;
	public static volatile SingularAttribute<ParametroEmpresa, Moeda> moedanacional;
	public static volatile SingularAttribute<ParametroEmpresa, Date> dtencerramentotrafego;
	public static volatile SingularAttribute<ParametroEmpresa, Moeda> moeda;
	public static volatile SingularAttribute<ParametroEmpresa, Estacao> estacao;
	public static volatile SingularAttribute<ParametroEmpresa, Long> parametroempresaid;
	public static volatile SingularAttribute<ParametroEmpresa, Fabrica> fabricaatelier;
	public static volatile SingularAttribute<ParametroEmpresa, Integer> codigovalidacao;
	public static volatile SingularAttribute<ParametroEmpresa, Integer> prazodocbanco;
	public static volatile SingularAttribute<ParametroEmpresa, Componente> componente;

	public static final String PERCDESAGIOSLIPFABRICA = "percdesagioslipfabrica";
	public static final String ANOCORRENTE = "anocorrente";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String LIVROSREFERENCIA = "livrosreferencia";
	public static final String DATASTAMP = "datastamp";
	public static final String UNIDADE = "unidade";
	public static final String TAXAFRETE = "taxafrete";
	public static final String MOEDANACIONAL = "moedanacional";
	public static final String DTENCERRAMENTOTRAFEGO = "dtencerramentotrafego";
	public static final String MOEDA = "moeda";
	public static final String ESTACAO = "estacao";
	public static final String PARAMETROEMPRESAID = "parametroempresaid";
	public static final String FABRICAATELIER = "fabricaatelier";
	public static final String CODIGOVALIDACAO = "codigovalidacao";
	public static final String PRAZODOCBANCO = "prazodocbanco";
	public static final String COMPONENTE = "componente";

}

