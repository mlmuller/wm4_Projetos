package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Cliente",uniqueConstraints= {@UniqueConstraint(columnNames="nome",name="clie_nome_uk")
										  ,@UniqueConstraint(columnNames="sucinto",name="clie_sucinto_uk")}
										  ,indexes={@Index(columnList="clie_grcl_fk",name="clie_grcl_ifk")
										  ,@Index(columnList="clie_impo_fk",name="clie_impo_ifk",unique=false)
										  ,@Index(columnList="clie_desp1_fk",name="clie_desp1_ifk",unique=false)
										  ,@Index(columnList="clie_desp2_fk",name="clie_desp2_ifk",unique=false)
										  ,@Index(columnList="clie_tran1_fk",name="clie_tran1_ifk",unique=false)
										  ,@Index(columnList="clie_tran2_fk",name="clie_tran2_ifk",unique=false)})
@Getter @Setter

public class Cliente implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "clienteSeq")
	@SequenceGenerator(name = "clienteSeq", sequenceName = "s_cliente", allocationSize = 1)
	@Column(name="clie_pk",updatable=false,nullable=false)
	private Long clienteid;

	@Column(length=30,nullable=false)
	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(length=1,nullable=false)
	private Mercado mercado;
	
	@Column(length=15,nullable=false)
	private String sucinto;
	
	@Enumerated(EnumType.STRING) //(A tivo, I nativo)
	@Column(length=1,nullable= false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=15, nullable=true)
	private String abrfin;
	
	@Column(length=3, nullable=true)
	private String sigla;
	
	@Column(length=3, nullable=true)
	private String prioridade;

	@Column(length=40, nullable=true)
	private String endereco;

	@Column(length=25, nullable=true)
	private String cidade;

	@Column(length=25, nullable=true)
	private String pais;

	@Column(length=15, nullable=true)
	private String lingua;

	@Column(length=5, nullable=true)
	private String codimp;
	
	@Enumerated(EnumType.STRING) // imprimi contrato fabrica nome cliente =C, ou nome Grupo cliente = G
	@Column(length=1, nullable=false)
	private ImprimiContratoFabrica imprimicontratofabrica;
	
	@Column(length=5, nullable=true)
	private String abramostra;
	
	@Enumerated(EnumType.STRING) //Sim,Nao
	@Column(length=1, nullable=true)
	private SimNao imprimepalmilhaEtiqueta;

	@Column(length=30, nullable=true)
	private String divisao;
	
	@Column(length=30, nullable=true)
	private String invoicecustomer;

	@Enumerated(EnumType.STRING) //Sim/Nao
	@Column(length=1, nullable=true)
	private SimNao liberadoreprogramacaoorder;

	@Column(length=10, nullable=true)
	private String codcliediintershoe;

//	@Enumerated(EnumType.STRING) //I,T,B,E //Nao tem implementacao Oracle,campo nulo
//	@Column(length=1, nullable=true)
//	private Character tipoprecoinvoiceam;

	@Column(length=14, nullable=true)
	private String cnpjcpf;

	@Column(length=16, nullable=true)
	private String inscricaoestadual;

	@Column(length=30, nullable=true)
	private String bairro;

	@Column(length=10, nullable=true)
	private String cep;

	@Column(length=4, nullable=true)
	private String uf;

	@Column(length=30, nullable=true)
	private String telefone;

	@Enumerated(EnumType.STRING) //F,J,N,E
	@Column(length=1, nullable=true)
	private TipoPessoa tipopessoa;

	@Enumerated(EnumType.STRING) //B,L,C,D,E,Z,F,H,G,I,M,A,K,J
	@Column(length=1,nullable=true)
	private LayoutInvoiceTrading layoutinvoicetrading;
	
	@Column(length=10, nullable=true)
	private String codcliediinterkommerz;

	@Enumerated(EnumType.STRING) //F=First Cost, verifacr cadastro tela.....
	@Column(length=1, nullable=true)
	private TipoNegociacao tiponegociacao;

	@Column(length=5,precision=4, nullable=true)
	private BigDecimal nilreturn;
	
	@Enumerated(EnumType.STRING) //S/N
	@Column(length=1, nullable=true)
	private SimNao imprimicodigofrete;

	@Enumerated(EnumType.STRING) //S/N
	@Column(length=1, nullable=true)
	private SimNao imprimicalculordd;

	@Column(length=50, nullable=true)
	private String contacorente;
	
	@Column(length=500, nullable=true)
	private String remessaaomostra;
	
	@Column(length=8,precision=4, nullable=true)
	private BigDecimal descdiversos;

	@Column(length=100, nullable=true)
	private String parametrocompradorestoque;
	//Primeiro despachante
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_desp1_fk",referencedColumnName="desp_pk",nullable=true,foreignKey=@ForeignKey(name="clie_desp1_fk"))
	private Despachante despachantes1;
	//Segundo despachante
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_desp2_fk",referencedColumnName="desp_pk",nullable=true,foreignKey=@ForeignKey(name="cle_desp2_fk"))
	private Despachante despachantes2;
	//Primeiro Transportadora
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_tran1_fk",referencedColumnName="trans_pk",nullable=true,foreignKey=@ForeignKey(name="clie_tran1_fk"))
	private Transportador transportadoras1;
	//segundo Transportadora
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_tran2_fk",referencedColumnName="trans_pk",nullable=true,foreignKey=@ForeignKey(name="clie_tran2_fk"))
	private Transportador transportadoras2;
	//Importador
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_impo_fk",referencedColumnName="impo_pk",nullable=true,foreignKey=@ForeignKey(name="clie_impo_fk"))
	private Importador importadores;
	//Paises
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_pais_fk",referencedColumnName="pais_pk",nullable=true,foreignKey=@ForeignKey(name="clie_pais_fk"))
	private Pais paises;
	//GrupoCliente
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_grcl_fk",referencedColumnName="grcl_pk",nullable=false,foreignKey=@ForeignKey(name="clie_grcl_fk"))
	private GrupoCliente grupoclientes;
	//Cidades
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_cida_fk",referencedColumnName="cida_pk",nullable=true,foreignKey=@ForeignKey(name="clie_cida_fk"))
	private Cidade cidades;
	//Bancos
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_banc_fk",referencedColumnName="banc_pk",nullable=true,foreignKey=@ForeignKey(name="clie_banc_fk"))
	private Banco bancos;
	//Prazo Paamentos
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_prpa_fk",referencedColumnName="prpa_pk",nullable=true,foreignKey=@ForeignKey(name="clie_prpa_fk"))
	private PrazoPagamento prazopagamentos;
	//Moedas
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_moed_fk",referencedColumnName="moed_pk",nullable=true,foreignKey=@ForeignKey(name="clie_moed_fk"))
	private Moeda moedas;
	//Comprador
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_cmpr_fk",referencedColumnName="cmpr_pk",nullable=true,foreignKey=@ForeignKey(name="clie_cmpr_fk"))
	private Comprador compradores;
	//Clientes Projecoes
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_clpr_fk",referencedColumnName="clpr_pk",nullable=true,foreignKey=@ForeignKey(name="clie_clpr_fk"))
	private ClienteProjecao clientesprojecoes;

	//Clientes Invoice
	@ManyToOne(optional = true)
	@JoinColumn(name="clie_grinv_fk",referencedColumnName="grci_pk",nullable=true,foreignKey=@ForeignKey(name="clie_grinv_fk"))
	private GrupoClienteInvoice grpclienteinvoice;
	
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clienteid == null) ? 0 : clienteid.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (clienteid == null) {
			if (other.clienteid != null)
				return false;
		} else if (!clienteid.equals(other.clienteid))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cliente [clienteid=" + clienteid + "]";
	}

}
