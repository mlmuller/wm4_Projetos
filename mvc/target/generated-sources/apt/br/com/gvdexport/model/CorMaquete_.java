package br.com.gvdexport.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CorMaquete.class)
public abstract class CorMaquete_ {

	public static volatile SingularAttribute<CorMaquete, String> usuariostamp;
	public static volatile SingularAttribute<CorMaquete, String> espessura;
	public static volatile SingularAttribute<CorMaquete, String> sizecor;
	public static volatile SingularAttribute<CorMaquete, TipoMaterial> tipmaterial;
	public static volatile SingularAttribute<CorMaquete, String> cor;
	public static volatile SingularAttribute<CorMaquete, String> corprincipal;
	public static volatile SingularAttribute<CorMaquete, Date> datastamp;
	public static volatile SingularAttribute<CorMaquete, BigDecimal> totalpar;
	public static volatile SingularAttribute<CorMaquete, BigDecimal> parcancelado;
	public static volatile SingularAttribute<CorMaquete, CorMaquete> cormaquete;
	public static volatile SingularAttribute<CorMaquete, BigDecimal> saldoparinvoice;
	public static volatile SingularAttribute<CorMaquete, String> coretiqueta;
	public static volatile SingularAttribute<CorMaquete, Integer> sequenciacormaquete;
	public static volatile SingularAttribute<CorMaquete, String> material;
	public static volatile SingularAttribute<CorMaquete, DireitoEsquerdo> pe;
	public static volatile SingularAttribute<CorMaquete, Long> maqueteid;
	public static volatile SingularAttribute<CorMaquete, Long> id;
	public static volatile SingularAttribute<CorMaquete, BigDecimal> saldoparetiqueta;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String ESPESSURA = "espessura";
	public static final String SIZECOR = "sizecor";
	public static final String TIPMATERIAL = "tipmaterial";
	public static final String COR = "cor";
	public static final String CORPRINCIPAL = "corprincipal";
	public static final String DATASTAMP = "datastamp";
	public static final String TOTALPAR = "totalpar";
	public static final String PARCANCELADO = "parcancelado";
	public static final String CORMAQUETE = "cormaquete";
	public static final String SALDOPARINVOICE = "saldoparinvoice";
	public static final String CORETIQUETA = "coretiqueta";
	public static final String SEQUENCIACORMAQUETE = "sequenciacormaquete";
	public static final String MATERIAL = "material";
	public static final String PE = "pe";
	public static final String MAQUETEID = "maqueteid";
	public static final String ID = "id";
	public static final String SALDOPARETIQUETA = "saldoparetiqueta";

}

