package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Amostra.class)
public abstract class Amostra_ {

	public static volatile SingularAttribute<Amostra, String> obsSolado;
	public static volatile ListAttribute<Amostra, CorAmostra> coresAmostra;
	public static volatile SingularAttribute<Amostra, Fabrica> fabrica;
	public static volatile SingularAttribute<Amostra, String> obs;
	public static volatile SingularAttribute<Amostra, Tipo> tipo;
	public static volatile SingularAttribute<Amostra, String> construcaoNome;
	public static volatile SingularAttribute<Amostra, LocalDateTime> dataLiberacaoProducao;
	public static volatile SingularAttribute<Amostra, String> complementoSolado;
	public static volatile SingularAttribute<Amostra, Boolean> gerada;
	public static volatile SingularAttribute<Amostra, Integer> linhaProducao;
	public static volatile SingularAttribute<Amostra, LocalDate> dtxfct;
	public static volatile SingularAttribute<Amostra, Integer> nroAmostraoId;
	public static volatile SingularAttribute<Amostra, MarcaCliente> marcaCliente;
	public static volatile SingularAttribute<Amostra, Mercado> mercado;
	public static volatile SingularAttribute<Amostra, BigDecimal> pares;
	public static volatile SingularAttribute<Amostra, LocalDateTime> dataStamp;
	public static volatile SingularAttribute<Amostra, LocalDate> datCadCam;
	public static volatile SingularAttribute<Amostra, Personagem> personagem;
	public static volatile SingularAttribute<Amostra, String> referenciaForma;
	public static volatile SingularAttribute<Amostra, Construcao> construcao;
	public static volatile SingularAttribute<Amostra, Componente> componente;
	public static volatile SingularAttribute<Amostra, Boolean> temcor;
	public static volatile SingularAttribute<Amostra, Integer> versaoRefer;
	public static volatile SingularAttribute<Amostra, DestinoAmCf> destinoAmCf;
	public static volatile SingularAttribute<Amostra, String> usuarioStamp;
	public static volatile SingularAttribute<Amostra, String> sucCliente;
	public static volatile SingularAttribute<Amostra, String> abreviacao;
	public static volatile SingularAttribute<Amostra, BigDecimal> valorNegocFabr;
	public static volatile SingularAttribute<Amostra, String> amostraSize;
	public static volatile SingularAttribute<Amostra, LocalDate> dataSolicitacao;
	public static volatile SingularAttribute<Amostra, Cliente> cliente;
	public static volatile SingularAttribute<Amostra, String> obsBase;
	public static volatile SingularAttribute<Amostra, PrioridadeProducao> prioridaDeProducao;
	public static volatile SingularAttribute<Amostra, Estacao> estacao;
	public static volatile SingularAttribute<Amostra, String> sucFabrica;
	public static volatile SingularAttribute<Amostra, LocalDate> dataEntrega;
	public static volatile SingularAttribute<Amostra, Long> amostraId;
	public static volatile SingularAttribute<Amostra, LivroReferencia> livroReferencia;
	public static volatile SingularAttribute<Amostra, Integer> referencia;
	public static volatile SingularAttribute<Amostra, Integer> versao;
	public static volatile SingularAttribute<Amostra, BigDecimal> pargvd;
	public static volatile SingularAttribute<Amostra, BigDecimal> parCancelado;

	public static final String OBS_SOLADO = "obsSolado";
	public static final String CORES_AMOSTRA = "coresAmostra";
	public static final String FABRICA = "fabrica";
	public static final String OBS = "obs";
	public static final String TIPO = "tipo";
	public static final String CONSTRUCAO_NOME = "construcaoNome";
	public static final String DATA_LIBERACAO_PRODUCAO = "dataLiberacaoProducao";
	public static final String COMPLEMENTO_SOLADO = "complementoSolado";
	public static final String GERADA = "gerada";
	public static final String LINHA_PRODUCAO = "linhaProducao";
	public static final String DTXFCT = "dtxfct";
	public static final String NRO_AMOSTRAO_ID = "nroAmostraoId";
	public static final String MARCA_CLIENTE = "marcaCliente";
	public static final String MERCADO = "mercado";
	public static final String PARES = "pares";
	public static final String DATA_STAMP = "dataStamp";
	public static final String DAT_CAD_CAM = "datCadCam";
	public static final String PERSONAGEM = "personagem";
	public static final String REFERENCIA_FORMA = "referenciaForma";
	public static final String CONSTRUCAO = "construcao";
	public static final String COMPONENTE = "componente";
	public static final String TEMCOR = "temcor";
	public static final String VERSAO_REFER = "versaoRefer";
	public static final String DESTINO_AM_CF = "destinoAmCf";
	public static final String USUARIO_STAMP = "usuarioStamp";
	public static final String SUC_CLIENTE = "sucCliente";
	public static final String ABREVIACAO = "abreviacao";
	public static final String VALOR_NEGOC_FABR = "valorNegocFabr";
	public static final String AMOSTRA_SIZE = "amostraSize";
	public static final String DATA_SOLICITACAO = "dataSolicitacao";
	public static final String CLIENTE = "cliente";
	public static final String OBS_BASE = "obsBase";
	public static final String PRIORIDA_DE_PRODUCAO = "prioridaDeProducao";
	public static final String ESTACAO = "estacao";
	public static final String SUC_FABRICA = "sucFabrica";
	public static final String DATA_ENTREGA = "dataEntrega";
	public static final String AMOSTRA_ID = "amostraId";
	public static final String LIVRO_REFERENCIA = "livroReferencia";
	public static final String REFERENCIA = "referencia";
	public static final String VERSAO = "versao";
	public static final String PARGVD = "pargvd";
	public static final String PAR_CANCELADO = "parCancelado";

}

