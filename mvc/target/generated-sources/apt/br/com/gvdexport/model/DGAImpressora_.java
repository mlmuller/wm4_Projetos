package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DGAImpressora.class)
public abstract class DGAImpressora_ {

	public static volatile SingularAttribute<DGAImpressora, String> usuariostamp;
	public static volatile SingularAttribute<DGAImpressora, String> tipo;
	public static volatile SingularAttribute<DGAImpressora, Situacao> situacao;
	public static volatile SingularAttribute<DGAImpressora, Date> datastamp;
	public static volatile SingularAttribute<DGAImpressora, Long> dgaimpressoraid;
	public static volatile SingularAttribute<DGAImpressora, String> nome;
	public static volatile SingularAttribute<DGAImpressora, String> caminho;
	public static volatile SingularAttribute<DGAImpressora, Long> id;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String TIPO = "tipo";
	public static final String SITUACAO = "situacao";
	public static final String DATASTAMP = "datastamp";
	public static final String DGAIMPRESSORAID = "dgaimpressoraid";
	public static final String NOME = "nome";
	public static final String CAMINHO = "caminho";
	public static final String ID = "id";

}

