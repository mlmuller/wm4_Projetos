package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SubGradeAltPar.class)
public abstract class SubGradeAltPar_ {

	public static volatile SingularAttribute<SubGradeAltPar, String> usuariostamp;
	public static volatile SingularAttribute<SubGradeAltPar, String> paresmusicalnarrow;
	public static volatile SingularAttribute<SubGradeAltPar, Date> data;
	public static volatile SingularAttribute<SubGradeAltPar, Integer> caixas;
	public static volatile SingularAttribute<SubGradeAltPar, Date> datastamp;
	public static volatile SingularAttribute<SubGradeAltPar, String> paresmusical;
	public static volatile SingularAttribute<SubGradeAltPar, SubGradePedido> subgradepedido;
	public static volatile SingularAttribute<SubGradeAltPar, RazaoAlteracao> razaoalteracao;
	public static volatile SingularAttribute<SubGradeAltPar, Long> pedidoid;
	public static volatile SingularAttribute<SubGradeAltPar, Long> sequenciaid;
	public static volatile SingularAttribute<SubGradeAltPar, BigDecimal> pares;
	public static volatile SingularAttribute<SubGradeAltPar, String> paressolido;
	public static volatile SingularAttribute<SubGradeAltPar, String> paresmusicallwidth;
	public static volatile SingularAttribute<SubGradeAltPar, Long> sbgradepedidoid;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String PARESMUSICALNARROW = "paresmusicalnarrow";
	public static final String DATA = "data";
	public static final String CAIXAS = "caixas";
	public static final String DATASTAMP = "datastamp";
	public static final String PARESMUSICAL = "paresmusical";
	public static final String SUBGRADEPEDIDO = "subgradepedido";
	public static final String RAZAOALTERACAO = "razaoalteracao";
	public static final String PEDIDOID = "pedidoid";
	public static final String SEQUENCIAID = "sequenciaid";
	public static final String PARES = "pares";
	public static final String PARESSOLIDO = "paressolido";
	public static final String PARESMUSICALLWIDTH = "paresmusicallwidth";
	public static final String SBGRADEPEDIDOID = "sbgradepedidoid";

}

