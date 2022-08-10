package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FichaProducao.class)
public abstract class FichaProducao_ {

	public static volatile SingularAttribute<FichaProducao, LocalDate> datacorte;
	public static volatile SingularAttribute<FichaProducao, String> usuariostamp;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datafmontagem;
	public static volatile SingularAttribute<FichaProducao, SituacaoProducao> situacao;
	public static volatile SingularAttribute<FichaProducao, LocalDateTime> datacorrecao;
	public static volatile SingularAttribute<FichaProducao, LocalDate> dataalmoxarifadopre;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datafcostura;
	public static volatile SingularAttribute<FichaProducao, LocalDateTime> dataentrada;
	public static volatile SingularAttribute<FichaProducao, LocalDate> dataprefabricado;
	public static volatile SingularAttribute<FichaProducao, CorMaquete> cormaquete;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datafacabamento;
	public static volatile SingularAttribute<FichaProducao, LocalDate> dataimpressao;
	public static volatile SingularAttribute<FichaProducao, LocalDate> dataalmoxarifado;
	public static volatile SingularAttribute<FichaProducao, Boolean> aliberar;
	public static volatile SingularAttribute<FichaProducao, BigDecimal> pares;
	public static volatile SingularAttribute<FichaProducao, LocalDate> dataacabamento;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datamontagem;
	public static volatile SingularAttribute<FichaProducao, Amostra> amostra;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datafalmoxarifado;
	public static volatile SingularAttribute<FichaProducao, EmTransicao> liberadoalteraramostra;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datafalmoxarifadopre;
	public static volatile SingularAttribute<FichaProducao, Maquete> maquete;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datafcorte;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datadistribuicao;
	public static volatile SingularAttribute<FichaProducao, LocalDateTime> datastamp;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datafprefabricado;
	public static volatile SingularAttribute<FichaProducao, CorAmostra> coramostra;
	public static volatile SingularAttribute<FichaProducao, BigDecimal> paresatual;
	public static volatile SingularAttribute<FichaProducao, String> comentario;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datamodelagem;
	public static volatile SingularAttribute<FichaProducao, Long> fichaproducaoid;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datacostura;
	public static volatile SingularAttribute<FichaProducao, CorConfirmacao> corconfirmacao;
	public static volatile SingularAttribute<FichaProducao, LocalDate> datafdistribuicao;

	public static final String DATACORTE = "datacorte";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String DATAFMONTAGEM = "datafmontagem";
	public static final String SITUACAO = "situacao";
	public static final String DATACORRECAO = "datacorrecao";
	public static final String DATAALMOXARIFADOPRE = "dataalmoxarifadopre";
	public static final String DATAFCOSTURA = "datafcostura";
	public static final String DATAENTRADA = "dataentrada";
	public static final String DATAPREFABRICADO = "dataprefabricado";
	public static final String CORMAQUETE = "cormaquete";
	public static final String DATAFACABAMENTO = "datafacabamento";
	public static final String DATAIMPRESSAO = "dataimpressao";
	public static final String DATAALMOXARIFADO = "dataalmoxarifado";
	public static final String ALIBERAR = "aliberar";
	public static final String PARES = "pares";
	public static final String DATAACABAMENTO = "dataacabamento";
	public static final String DATAMONTAGEM = "datamontagem";
	public static final String AMOSTRA = "amostra";
	public static final String DATAFALMOXARIFADO = "datafalmoxarifado";
	public static final String LIBERADOALTERARAMOSTRA = "liberadoalteraramostra";
	public static final String DATAFALMOXARIFADOPRE = "datafalmoxarifadopre";
	public static final String MAQUETE = "maquete";
	public static final String DATAFCORTE = "datafcorte";
	public static final String DATADISTRIBUICAO = "datadistribuicao";
	public static final String DATASTAMP = "datastamp";
	public static final String DATAFPREFABRICADO = "datafprefabricado";
	public static final String CORAMOSTRA = "coramostra";
	public static final String PARESATUAL = "paresatual";
	public static final String COMENTARIO = "comentario";
	public static final String DATAMODELAGEM = "datamodelagem";
	public static final String FICHAPRODUCAOID = "fichaproducaoid";
	public static final String DATACOSTURA = "datacostura";
	public static final String CORCONFIRMACAO = "corconfirmacao";
	public static final String DATAFDISTRIBUICAO = "datafdistribuicao";

}

