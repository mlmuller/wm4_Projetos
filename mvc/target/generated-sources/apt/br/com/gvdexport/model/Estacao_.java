package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estacao.class)
public abstract class Estacao_ {

	public static volatile SingularAttribute<Estacao, Long> estacaoid;
	public static volatile SingularAttribute<Estacao, String> usuariostamp;
	public static volatile SingularAttribute<Estacao, Situacao> situacao;
	public static volatile SingularAttribute<Estacao, String> nomeport;
	public static volatile SingularAttribute<Estacao, Date> datastamp;
	public static volatile SingularAttribute<Estacao, String> nome;
	public static volatile SingularAttribute<Estacao, String> siglainglesa;
	public static volatile SingularAttribute<Estacao, Date> fimestacao;
	public static volatile SingularAttribute<Estacao, Date> inicioestacao;

	public static final String ESTACAOID = "estacaoid";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String NOMEPORT = "nomeport";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String SIGLAINGLESA = "siglainglesa";
	public static final String FIMESTACAO = "fimestacao";
	public static final String INICIOESTACAO = "inicioestacao";

}

