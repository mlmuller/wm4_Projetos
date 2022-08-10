package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProgramacaoProducao.class)
public abstract class ProgramacaoProducao_ {

	public static volatile SingularAttribute<ProgramacaoProducao, Integer> projecao;
	public static volatile SingularAttribute<ProgramacaoProducao, String> usuariostamp;
	public static volatile SingularAttribute<ProgramacaoProducao, Cliente> cliente;
	public static volatile SingularAttribute<ProgramacaoProducao, Integer> ano;
	public static volatile SingularAttribute<ProgramacaoProducao, GrupoFabrica> grupofabrica;
	public static volatile SingularAttribute<ProgramacaoProducao, Long> programacaoproducaoid;
	public static volatile SingularAttribute<ProgramacaoProducao, Integer> meta;
	public static volatile SingularAttribute<ProgramacaoProducao, Date> datastamp;
	public static volatile SingularAttribute<ProgramacaoProducao, Integer> disponivel;
	public static volatile SingularAttribute<ProgramacaoProducao, String> mes;

	public static final String PROJECAO = "projecao";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String CLIENTE = "cliente";
	public static final String ANO = "ano";
	public static final String GRUPOFABRICA = "grupofabrica";
	public static final String PROGRAMACAOPRODUCAOID = "programacaoproducaoid";
	public static final String META = "meta";
	public static final String DATASTAMP = "datastamp";
	public static final String DISPONIVEL = "disponivel";
	public static final String MES = "mes";

}

