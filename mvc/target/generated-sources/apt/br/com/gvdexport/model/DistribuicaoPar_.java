package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DistribuicaoPar.class)
public abstract class DistribuicaoPar_ {

	public static volatile SingularAttribute<DistribuicaoPar, String> usuariostamp;
	public static volatile SingularAttribute<DistribuicaoPar, Cliente> cliente;
	public static volatile SingularAttribute<DistribuicaoPar, Long> distribuicaoparid;
	public static volatile SingularAttribute<DistribuicaoPar, String> codigo;
	public static volatile SingularAttribute<DistribuicaoPar, String> distribuicaonarrow;
	public static volatile SingularAttribute<DistribuicaoPar, String> distribuicaowidth;
	public static volatile SingularAttribute<DistribuicaoPar, Situacao> situacao;
	public static volatile SingularAttribute<DistribuicaoPar, Date> datastamp;
	public static volatile SingularAttribute<DistribuicaoPar, String> distribuicao;
	public static volatile SingularAttribute<DistribuicaoPar, Componente> componente;
	public static volatile SingularAttribute<DistribuicaoPar, TipoDistribuicao> tipodistribuicao;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String CLIENTE = "cliente";
	public static final String DISTRIBUICAOPARID = "distribuicaoparid";
	public static final String CODIGO = "codigo";
	public static final String DISTRIBUICAONARROW = "distribuicaonarrow";
	public static final String DISTRIBUICAOWIDTH = "distribuicaowidth";
	public static final String SITUACAO = "situacao";
	public static final String DATASTAMP = "datastamp";
	public static final String DISTRIBUICAO = "distribuicao";
	public static final String COMPONENTE = "componente";
	public static final String TIPODISTRIBUICAO = "tipodistribuicao";

}

