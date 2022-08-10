package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CorAmostra.class)
public abstract class CorAmostra_ {

	public static volatile SingularAttribute<CorAmostra, String> cor;
	public static volatile SingularAttribute<CorAmostra, String> corPrincipal;
	public static volatile SingularAttribute<CorAmostra, String> marca;
	public static volatile SingularAttribute<CorAmostra, LocalDateTime> dataStamp;
	public static volatile SingularAttribute<CorAmostra, String> corEtiqueta;
	public static volatile SingularAttribute<CorAmostra, Amostra> amostra;
	public static volatile SingularAttribute<CorAmostra, BigDecimal> parGvd;
	public static volatile SingularAttribute<CorAmostra, String> localizacao;
	public static volatile SingularAttribute<CorAmostra, String> usuarioStamp;
	public static volatile SingularAttribute<CorAmostra, String> linha;
	public static volatile SingularAttribute<CorAmostra, BigDecimal> totalPar;
	public static volatile SingularAttribute<CorAmostra, String> saldoParInvoice;
	public static volatile SingularAttribute<CorAmostra, SimNao> desenvolveramostra;
	public static volatile SingularAttribute<CorAmostra, Integer> sequenciaCorAmostra;
	public static volatile SingularAttribute<CorAmostra, String> material;
	public static volatile SingularAttribute<CorAmostra, String> obsMaterial;
	public static volatile SingularAttribute<CorAmostra, DireitoEsquerdo> pe;
	public static volatile SingularAttribute<CorAmostra, CorMaquete> corMaquete;
	public static volatile SingularAttribute<CorAmostra, Boolean> producao;
	public static volatile SingularAttribute<CorAmostra, Long> amostraId;
	public static volatile SingularAttribute<CorAmostra, String> saldoParEtiqueta;
	public static volatile SingularAttribute<CorAmostra, String> sizeCor;
	public static volatile SingularAttribute<CorAmostra, Long> Id;
	public static volatile SingularAttribute<CorAmostra, TipoMaterial> tipoMaterial;
	public static volatile SingularAttribute<CorAmostra, BigDecimal> parCancelado;

	public static final String COR = "cor";
	public static final String COR_PRINCIPAL = "corPrincipal";
	public static final String MARCA = "marca";
	public static final String DATA_STAMP = "dataStamp";
	public static final String COR_ETIQUETA = "corEtiqueta";
	public static final String AMOSTRA = "amostra";
	public static final String PAR_GVD = "parGvd";
	public static final String LOCALIZACAO = "localizacao";
	public static final String USUARIO_STAMP = "usuarioStamp";
	public static final String LINHA = "linha";
	public static final String TOTAL_PAR = "totalPar";
	public static final String SALDO_PAR_INVOICE = "saldoParInvoice";
	public static final String DESENVOLVERAMOSTRA = "desenvolveramostra";
	public static final String SEQUENCIA_COR_AMOSTRA = "sequenciaCorAmostra";
	public static final String MATERIAL = "material";
	public static final String OBS_MATERIAL = "obsMaterial";
	public static final String PE = "pe";
	public static final String COR_MAQUETE = "corMaquete";
	public static final String PRODUCAO = "producao";
	public static final String AMOSTRA_ID = "amostraId";
	public static final String SALDO_PAR_ETIQUETA = "saldoParEtiqueta";
	public static final String SIZE_COR = "sizeCor";
	public static final String ID = "Id";
	public static final String TIPO_MATERIAL = "tipoMaterial";
	public static final String PAR_CANCELADO = "parCancelado";

}

