package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fabrica.class)
public abstract class Fabrica_ {

	public static volatile SingularAttribute<Fabrica, Long> fabricaid;
	public static volatile SingularAttribute<Fabrica, String> usuariostamp;
	public static volatile SingularAttribute<Fabrica, String> telefone;
	public static volatile SingularAttribute<Fabrica, Situacao> situacao;
	public static volatile SingularAttribute<Fabrica, String> observacao;
	public static volatile SingularAttribute<Fabrica, Cidade> cidade;
	public static volatile SingularAttribute<Fabrica, GrupoFabrica> grupofabrica;
	public static volatile SingularAttribute<Fabrica, Integer> codigoimp;
	public static volatile SingularAttribute<Fabrica, String> diretor;
	public static volatile SingularAttribute<Fabrica, String> cep;
	public static volatile SingularAttribute<Fabrica, String> uf;
	public static volatile SingularAttribute<Fabrica, Integer> capacidadetrilho;
	public static volatile SingularAttribute<Fabrica, SimNao> integrantesimplesnacional;
	public static volatile SingularAttribute<Fabrica, String> cacex;
	public static volatile SingularAttribute<Fabrica, String> sucinto;
	public static volatile SingularAttribute<Fabrica, String> contato;
	public static volatile SingularAttribute<Fabrica, String> nrocontrato;
	public static volatile SingularAttribute<Fabrica, String> endereco;
	public static volatile SingularAttribute<Fabrica, String> abreviacao;
	public static volatile SingularAttribute<Fabrica, Integer> producaofabrica;
	public static volatile SingularAttribute<Fabrica, Date> datastamp;
	public static volatile SingularAttribute<Fabrica, String> nome;
	public static volatile SingularAttribute<Fabrica, String> nomecidade;
	public static volatile SingularAttribute<Fabrica, String> inscricaoestadual;
	public static volatile SingularAttribute<Fabrica, Pais> pais;
	public static volatile SingularAttribute<Fabrica, Integer> prazopagamento;
	public static volatile SingularAttribute<Fabrica, Integer> nrotrilho;
	public static volatile SingularAttribute<Fabrica, String> cgc;

	public static final String FABRICAID = "fabricaid";
	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String TELEFONE = "telefone";
	public static final String SITUACAO = "situacao";
	public static final String OBSERVACAO = "observacao";
	public static final String CIDADE = "cidade";
	public static final String GRUPOFABRICA = "grupofabrica";
	public static final String CODIGOIMP = "codigoimp";
	public static final String DIRETOR = "diretor";
	public static final String CEP = "cep";
	public static final String UF = "uf";
	public static final String CAPACIDADETRILHO = "capacidadetrilho";
	public static final String INTEGRANTESIMPLESNACIONAL = "integrantesimplesnacional";
	public static final String CACEX = "cacex";
	public static final String SUCINTO = "sucinto";
	public static final String CONTATO = "contato";
	public static final String NROCONTRATO = "nrocontrato";
	public static final String ENDERECO = "endereco";
	public static final String ABREVIACAO = "abreviacao";
	public static final String PRODUCAOFABRICA = "producaofabrica";
	public static final String DATASTAMP = "datastamp";
	public static final String NOME = "nome";
	public static final String NOMECIDADE = "nomecidade";
	public static final String INSCRICAOESTADUAL = "inscricaoestadual";
	public static final String PAIS = "pais";
	public static final String PRAZOPAGAMENTO = "prazopagamento";
	public static final String NROTRILHO = "nrotrilho";
	public static final String CGC = "cgc";

}

