package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoCalcado.class)
public abstract class TipoCalcado_ {

	public static volatile SingularAttribute<TipoCalcado, String> usuariostamp;
	public static volatile SingularAttribute<TipoCalcado, Situacao> situacao;
	public static volatile SingularAttribute<TipoCalcado, String> nomeport;
	public static volatile SingularAttribute<TipoCalcado, BigDecimal> pramostracli;
	public static volatile SingularAttribute<TipoCalcado, Date> datastamp;
	public static volatile SingularAttribute<TipoCalcado, String> nomeingles;
	public static volatile SingularAttribute<TipoCalcado, IdentificaCalcado> identificacalcado;
	public static volatile SingularAttribute<TipoCalcado, BigDecimal> taxafrete;
	public static volatile SingularAttribute<TipoCalcado, Long> tipocalcadoid;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String NOMEPORT = "nomeport";
	public static final String PRAMOSTRACLI = "pramostracli";
	public static final String DATASTAMP = "datastamp";
	public static final String NOMEINGLES = "nomeingles";
	public static final String IDENTIFICACALCADO = "identificacalcado";
	public static final String TAXAFRETE = "taxafrete";
	public static final String TIPOCALCADOID = "tipocalcadoid";

}

