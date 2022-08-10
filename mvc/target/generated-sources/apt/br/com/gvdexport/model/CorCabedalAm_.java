package br.com.gvdexport.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CorCabedalAm.class)
public abstract class CorCabedalAm_ {

	public static volatile SingularAttribute<CorCabedalAm, String> texto;
	public static volatile SingularAttribute<CorCabedalAm, String> usuariostamp;
	public static volatile SingularAttribute<CorCabedalAm, LocalDateTime> datastamp;
	public static volatile SingularAttribute<CorCabedalAm, CorAmostra> coramostra;
	public static volatile SingularAttribute<CorCabedalAm, Long> id;
	public static volatile SingularAttribute<CorCabedalAm, Integer> sequenciacoramostra;
	public static volatile SingularAttribute<CorCabedalAm, Amostra> amostra;

	public static final String TEXTO = "texto";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String DATASTAMP = "datastamp";
	public static final String CORAMOSTRA = "coramostra";
	public static final String ID = "id";
	public static final String SEQUENCIACORAMOSTRA = "sequenciacoramostra";
	public static final String AMOSTRA = "amostra";

}

