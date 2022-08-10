package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AvisoRetorno.class)
public abstract class AvisoRetorno_ {

	public static volatile SingularAttribute<AvisoRetorno, String> usuariostamp;
	public static volatile SingularAttribute<AvisoRetorno, Fabrica> fabricas;
	public static volatile SingularAttribute<AvisoRetorno, String> observacao;
	public static volatile SingularAttribute<AvisoRetorno, String> nftransporte;
	public static volatile SingularAttribute<AvisoRetorno, Long> avisoretornoid;
	public static volatile SingularAttribute<AvisoRetorno, TipoNota> tiponota;
	public static volatile SingularAttribute<AvisoRetorno, Integer> pares;
	public static volatile SingularAttribute<AvisoRetorno, Date> datastamp;
	public static volatile SingularAttribute<AvisoRetorno, Revisor> revisores;
	public static volatile SingularAttribute<AvisoRetorno, Date> datanftransporte;
	public static volatile SingularAttribute<AvisoRetorno, Local> local;
	public static volatile SingularAttribute<AvisoRetorno, Date> dataretorno;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String FABRICAS = "fabricas";
	public static final String OBSERVACAO = "observacao";
	public static final String NFTRANSPORTE = "nftransporte";
	public static final String AVISORETORNOID = "avisoretornoid";
	public static final String TIPONOTA = "tiponota";
	public static final String PARES = "pares";
	public static final String DATASTAMP = "datastamp";
	public static final String REVISORES = "revisores";
	public static final String DATANFTRANSPORTE = "datanftransporte";
	public static final String LOCAL = "local";
	public static final String DATARETORNO = "dataretorno";

}

