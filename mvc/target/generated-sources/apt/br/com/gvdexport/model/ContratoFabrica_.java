package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContratoFabrica.class)
public abstract class ContratoFabrica_ {

	public static volatile SingularAttribute<ContratoFabrica, String> texto;
	public static volatile SingularAttribute<ContratoFabrica, String> usuariostamp;
	public static volatile SingularAttribute<ContratoFabrica, Situacao> situacao;
	public static volatile SingularAttribute<ContratoFabrica, String> abreviacao;
	public static volatile SingularAttribute<ContratoFabrica, Date> datastamp;
	public static volatile SingularAttribute<ContratoFabrica, Long> contratofabricaid;
	public static volatile SingularAttribute<ContratoFabrica, String> descricao;

	public static final String TEXTO = "texto";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String ABREVIACAO = "abreviacao";
	public static final String DATASTAMP = "datastamp";
	public static final String CONTRATOFABRICAID = "contratofabricaid";
	public static final String DESCRICAO = "descricao";

}

