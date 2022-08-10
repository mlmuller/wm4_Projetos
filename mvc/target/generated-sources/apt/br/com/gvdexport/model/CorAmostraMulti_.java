package br.com.gvdexport.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CorAmostraMulti.class)
public abstract class CorAmostraMulti_ {

	public static volatile SingularAttribute<CorAmostraMulti, String> completaMaterial;
	public static volatile SingularAttribute<CorAmostraMulti, Long> cormultiid;
	public static volatile SingularAttribute<CorAmostraMulti, String> corNome;
	public static volatile SingularAttribute<CorAmostraMulti, Integer> sequenciaPosicao;
	public static volatile SingularAttribute<CorAmostraMulti, Integer> seqCor;
	public static volatile SingularAttribute<CorAmostraMulti, Cor> cor;
	public static volatile SingularAttribute<CorAmostraMulti, Boolean> corPrincipal;
	public static volatile SingularAttribute<CorAmostraMulti, String> completaCor;
	public static volatile SingularAttribute<CorAmostraMulti, String> matNome;
	public static volatile SingularAttribute<CorAmostraMulti, CorAmostra> corAmostra;
	public static volatile SingularAttribute<CorAmostraMulti, Material> material;
	public static volatile SingularAttribute<CorAmostraMulti, Integer> seqCorAmostra;
	public static volatile SingularAttribute<CorAmostraMulti, Amostra> amostra;
	public static volatile SingularAttribute<CorAmostraMulti, Integer> seqMaterial;

	public static final String COMPLETA_MATERIAL = "completaMaterial";
	public static final String CORMULTIID = "cormultiid";
	public static final String COR_NOME = "corNome";
	public static final String SEQUENCIA_POSICAO = "sequenciaPosicao";
	public static final String SEQ_COR = "seqCor";
	public static final String COR = "cor";
	public static final String COR_PRINCIPAL = "corPrincipal";
	public static final String COMPLETA_COR = "completaCor";
	public static final String MAT_NOME = "matNome";
	public static final String COR_AMOSTRA = "corAmostra";
	public static final String MATERIAL = "material";
	public static final String SEQ_COR_AMOSTRA = "seqCorAmostra";
	public static final String AMOSTRA = "amostra";
	public static final String SEQ_MATERIAL = "seqMaterial";

}

