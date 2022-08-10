package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MotivoProducao.class)
public abstract class MotivoProducao_ {

	public static volatile SingularAttribute<MotivoProducao, String> usuariostamp;
	public static volatile SingularAttribute<MotivoProducao, Situacao> situacao;
	public static volatile SingularAttribute<MotivoProducao, Long> motivoproducaoid;
	public static volatile SingularAttribute<MotivoProducao, Date> datastamp;
	public static volatile SingularAttribute<MotivoProducao, String> descricao;
	public static volatile SingularAttribute<MotivoProducao, TipoMotivoProducao> motivoproducao;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String MOTIVOPRODUCAOID = "motivoproducaoid";
	public static final String DATASTAMP = "datastamp";
	public static final String DESCRICAO = "descricao";
	public static final String MOTIVOPRODUCAO = "motivoproducao";

}

