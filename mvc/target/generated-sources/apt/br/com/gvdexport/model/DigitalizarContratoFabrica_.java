package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DigitalizarContratoFabrica.class)
public abstract class DigitalizarContratoFabrica_ {

	public static volatile SingularAttribute<DigitalizarContratoFabrica, Fabrica> fabrica;
	public static volatile SingularAttribute<DigitalizarContratoFabrica, String> usuariostamp;
	public static volatile SingularAttribute<DigitalizarContratoFabrica, Integer> sequencia;
	public static volatile SingularAttribute<DigitalizarContratoFabrica, byte[]> foto;
	public static volatile SingularAttribute<DigitalizarContratoFabrica, Long> digconfabid;
	public static volatile SingularAttribute<DigitalizarContratoFabrica, Date> datastamp;
	public static volatile SingularAttribute<DigitalizarContratoFabrica, String> tipoarquivo;

	public static final String FABRICA = "fabrica";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SEQUENCIA = "sequencia";
	public static final String FOTO = "foto";
	public static final String DIGCONFABID = "digconfabid";
	public static final String DATASTAMP = "datastamp";
	public static final String TIPOARQUIVO = "tipoarquivo";

}

