package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Importador.class)
public abstract class Importador_ {

	public static volatile SingularAttribute<Importador, String> usuariostamp;
	public static volatile SingularAttribute<Importador, Situacao> situacao;
	public static volatile SingularAttribute<Importador, String> telefone;
	public static volatile SingularAttribute<Importador, Cidade> cidade;
	public static volatile SingularAttribute<Importador, String> endereco;
	public static volatile SingularAttribute<Importador, String> bairro;
	public static volatile SingularAttribute<Importador, Date> datastamp;
	public static volatile SingularAttribute<Importador, String> nome;
	public static volatile SingularAttribute<Importador, String> cnpjcpf;
	public static volatile SingularAttribute<Importador, String> inscricaoestadual;
	public static volatile SingularAttribute<Importador, TipoImportador> tipoimportador;
	public static volatile SingularAttribute<Importador, String> cep;
	public static volatile SingularAttribute<Importador, TipoPessoa> tipopessoa;
	public static volatile SingularAttribute<Importador, Pais> pais;
	public static volatile SingularAttribute<Importador, String> uf;
	public static volatile SingularAttribute<Importador, String> descricaocidade;
	public static volatile SingularAttribute<Importador, SimNao> liberadoedi;
	public static volatile SingularAttribute<Importador, Long> importadorid;
	public static volatile SingularAttribute<Importador, String> sucinto;
	public static volatile SingularAttribute<Importador, TipoTelefone> tipotelefone;
	public static volatile SingularAttribute<Importador, String> percdesconto;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String SITUACAO = "situacao";
	public static final String TELEFONE = "telefone";
	public static final String CIDADE = "cidade";
	public static final String ENDERECO = "endereco";
	public static final String BAIRRO = "bairro";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String CNPJCPF = "cnpjcpf";
	public static final String INSCRICAOESTADUAL = "inscricaoestadual";
	public static final String TIPOIMPORTADOR = "tipoimportador";
	public static final String CEP = "cep";
	public static final String TIPOPESSOA = "tipopessoa";
	public static final String PAIS = "pais";
	public static final String UF = "uf";
	public static final String DESCRICAOCIDADE = "descricaocidade";
	public static final String LIBERADOEDI = "liberadoedi";
	public static final String IMPORTADORID = "importadorid";
	public static final String SUCINTO = "sucinto";
	public static final String TIPOTELEFONE = "tipotelefone";
	public static final String PERCDESCONTO = "percdesconto";

}

