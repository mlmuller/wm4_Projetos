package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cotacao.class)
public abstract class Cotacao_ {

	public static volatile SingularAttribute<Cotacao, Long> cotacaoid;
	public static volatile SingularAttribute<Cotacao, String> usuariostamp;
	public static volatile SingularAttribute<Cotacao, Integer> ano;
	public static volatile SingularAttribute<Cotacao, String> sigla;
	public static volatile SingularAttribute<Cotacao, String> nomedia;
	public static volatile SingularAttribute<Cotacao, IdentificadorCotacao> identificadorcotacao;
	public static volatile SingularAttribute<Cotacao, BigDecimal> valorcompra;
	public static volatile SingularAttribute<Cotacao, Date> datastamp;
	public static volatile SingularAttribute<Cotacao, BigDecimal> valorvenda;
	public static volatile SingularAttribute<Cotacao, BigDecimal> vlrvendareais;
	public static volatile SingularAttribute<Cotacao, Date> datacotacao;
	public static volatile SingularAttribute<Cotacao, BigDecimal> vlrcomprareais;
	public static volatile SingularAttribute<Cotacao, Integer> mesnumeral;
	public static volatile SingularAttribute<Cotacao, Moeda> moedas;
	public static volatile SingularAttribute<Cotacao, String> mes;
	public static volatile SingularAttribute<Cotacao, BigDecimal> valorslipfabrica;
	public static volatile SingularAttribute<Cotacao, Banco> bancos;

	public static final String COTACAOID = "cotacaoid";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String ANO = "ano";
	public static final String SIGLA = "sigla";
	public static final String NOMEDIA = "nomedia";
	public static final String IDENTIFICADORCOTACAO = "identificadorcotacao";
	public static final String VALORCOMPRA = "valorcompra";
	public static final String DATASTAMP = "datastamp";
	public static final String VALORVENDA = "valorvenda";
	public static final String VLRVENDAREAIS = "vlrvendareais";
	public static final String DATACOTACAO = "datacotacao";
	public static final String VLRCOMPRAREAIS = "vlrcomprareais";
	public static final String MESNUMERAL = "mesnumeral";
	public static final String MOEDAS = "moedas";
	public static final String MES = "mes";
	public static final String VALORSLIPFABRICA = "valorslipfabrica";
	public static final String BANCOS = "bancos";

}

