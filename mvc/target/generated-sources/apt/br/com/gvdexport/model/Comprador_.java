package br.com.gvdexport.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comprador.class)
public abstract class Comprador_ {

	public static volatile SingularAttribute<Comprador, Consignatario> consignatarios;
	public static volatile SingularAttribute<Comprador, Situacao> situacao;
	public static volatile SingularAttribute<Comprador, Comprador> compradores;
	public static volatile SingularAttribute<Comprador, String> vat;
	public static volatile SingularAttribute<Comprador, String> nome;
	public static volatile SingularAttribute<Comprador, Vendedor> vendedores;
	public static volatile SingularAttribute<Comprador, BigDecimal> re;
	public static volatile SingularAttribute<Comprador, Long> compradorid;
	public static volatile SingularAttribute<Comprador, BigDecimal> iva;
	public static volatile SingularAttribute<Comprador, String> sucinto;
	public static volatile SingularAttribute<Comprador, SimNao> possuire;
	public static volatile SingularAttribute<Comprador, Notificar> notifcar;
	public static volatile SingularAttribute<Comprador, Long> compradormatrizid;
	public static volatile SingularAttribute<Comprador, Cliente> clientes;
	public static volatile SingularAttribute<Comprador, SimNao> possuiiva;

	public static final String CONSIGNATARIOS = "consignatarios";
	public static final String SITUACAO = "situacao";
	public static final String COMPRADORES = "compradores";
	public static final String VAT = "vat";
	public static final String NOME = "nome";
	public static final String VENDEDORES = "vendedores";
	public static final String RE = "re";
	public static final String COMPRADORID = "compradorid";
	public static final String IVA = "iva";
	public static final String SUCINTO = "sucinto";
	public static final String POSSUIRE = "possuire";
	public static final String NOTIFCAR = "notifcar";
	public static final String COMPRADORMATRIZID = "compradormatrizid";
	public static final String CLIENTES = "clientes";
	public static final String POSSUIIVA = "possuiiva";

}

