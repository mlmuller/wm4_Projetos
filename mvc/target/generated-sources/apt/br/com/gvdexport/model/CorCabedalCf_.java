package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CorCabedalCf.class)
public abstract class CorCabedalCf_ {

	public static volatile SingularAttribute<CorCabedalCf, String> texto;
	public static volatile SingularAttribute<CorCabedalCf, String> usuariostamp;
	public static volatile SingularAttribute<CorCabedalCf, Long> confirmacaoid;
	public static volatile SingularAttribute<CorCabedalCf, Integer> sequenciacorconfirmacao;
	public static volatile SingularAttribute<CorCabedalCf, CorConfirmacao> corconfirmacao;
	public static volatile SingularAttribute<CorCabedalCf, Date> datastamp;
	public static volatile SingularAttribute<CorCabedalCf, Long> id;

	public static final String TEXTO = "texto";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String CONFIRMACAOID = "confirmacaoid";
	public static final String SEQUENCIACORCONFIRMACAO = "sequenciacorconfirmacao";
	public static final String CORCONFIRMACAO = "corconfirmacao";
	public static final String DATASTAMP = "datastamp";
	public static final String ID = "id";

}

