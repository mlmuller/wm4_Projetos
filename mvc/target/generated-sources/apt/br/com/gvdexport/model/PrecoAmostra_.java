package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PrecoAmostra.class)
public abstract class PrecoAmostra_ {

	public static volatile SingularAttribute<PrecoAmostra, BigDecimal> preco;
	public static volatile SingularAttribute<PrecoAmostra, String> usuariostamp;
	public static volatile SingularAttribute<PrecoAmostra, GrupoClienteInvoice> grupoclienteinvoice;
	public static volatile SingularAttribute<PrecoAmostra, Long> precoamostraid;
	public static volatile SingularAttribute<PrecoAmostra, Date> datastamp;
	public static volatile SingularAttribute<PrecoAmostra, TipoPreco> tipopreco;
	public static volatile SingularAttribute<PrecoAmostra, IdentificaCalcado> identificacalcado;

	public static final String PRECO = "preco";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String GRUPOCLIENTEINVOICE = "grupoclienteinvoice";
	public static final String PRECOAMOSTRAID = "precoamostraid";
	public static final String DATASTAMP = "datastamp";
	public static final String TIPOPRECO = "tipopreco";
	public static final String IDENTIFICACALCADO = "identificacalcado";

}

