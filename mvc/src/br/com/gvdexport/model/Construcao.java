package br.com.gvdexport.model;

import java.io.Serializable;
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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter @Setter
@EqualsAndHashCode(of="construcaoid")
@Table(name="Construcao", uniqueConstraints= {@UniqueConstraint(columnNames={"construcao","versao"},name="cons_vers_uk")},indexes= {
		@Index(unique=false,name="cons_form_ifk",columnList="forma")}) 
public class Construcao implements Serializable,Cloneable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "construcaoSeq")
	@SequenceGenerator(name = "construcaoSeq", sequenceName = "s_construcao", allocationSize = 1)
	@Column(name="cons_pk",updatable=false,nullable=false)
	private Long construcaoid;
	
	@Column(length = 16 , nullable = false)
	private String construcao;
	
	@Column(length = 2,nullable = false , columnDefinition = "smallint")
	private Integer versao;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1 , nullable = false)
	private SimNao bloqueio;
	
	@Column(length = 1, nullable = false)
	private Boolean comercial;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = true)
	private  Situacao situacao=Situacao.A ;
	
	@Column(length = 10, nullable = false)
	private  String referenciaforma;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	//descricao da sola
	@Column(length = 23 , nullable = true)
	private String solalaminada;
	
	@Column(length = 10, nullable = true)
	private String solalaminadamaterial;
	
	@Column(length = 10, nullable = true)
	private String solalaminadaespessura;
	
	@Column(length = 10, nullable = true)
	private String solalaminadafornecedor;
	
	@Column(length = 18 , nullable = true)
	private String solainjetada;
	
	@Column(length = 10 , nullable = true)
	private String solainjetadamaterial;
	
	@Column(length = 10, nullable = true)
	private String solainjfornecedor;
	
	@Column(length = 10, nullable = true)
	private String solainjabrasao;
	
	@Column(length = 10, nullable = true)
	private String solainjdureza;
	
	@Column(length = 45, nullable = true)
	private String carimbosola;
	
	@Column(length = 23, nullable = true)
	private String entressola;
	
	@Column(length = 10 , nullable = true)
	private String entressolamaterial;
	
	@Column(length = 10, nullable = true)
	private String entressolafornecedor;
	
	@Column(length = 10, nullable = true)
	private String entressolaespessura;
	
	@Column(length = 18, nullable = true)
	private String vira1;
	
	@Column(length = 10, nullable = true)
	private String vira1material;
	
	@Column(length = 10, nullable = true)
	private String vira1referencia;
	
	@Column(length = 10, nullable = true)
	private String vira1fornecedor;

	@Column(length = 10, nullable =true)
	private String vira2;
	
	@Column(length = 10 , nullable = true)
	private String vira2material;
	
	@Column(length = 10 , nullable = true)
	private String vira2referencia;
	
	@Column(length = 10 , nullable = true)
	private String vira2fornecedor;

	@Column(length = 45 , nullable = true)
	private String tipobeira;
	
	@Column(length = 45, nullable = true)
	private String salto;
	
	@Column(length = 10 , nullable = true)
	private String saltomaterial;
	
	@Column(length = 10 , nullable = true)
	private String saltoreferencia;

	@Column(length = 10 , nullable = true)
	private String saltofornecedor;

	@Column(length = 45, nullable = true)
	private String fixasalto;
	
	@Column(length = 17,nullable =true )
	private String tacao;
	
	@Column(length = 10 , nullable = true)
	private String tacaomaterial;
	
	@Column(length = 10 , nullable = true)
	private String tacaofornecedor;
	
	@Column(length = 5 , nullable = true)
	private String tacaoespessura;
	
	@Column(length = 10 , nullable = true)
	private String tacaodurreza;

	@Column(length = 45 , nullable = true)
	private String fixatacao;

	@Column(length = 28 , nullable = true)
	private String plataforma;

	@Column(length = 10 , nullable = true)
	private String plataformamaterial;
	
	@Column(length = 10 , nullable = true)
	private String plataformafornecedor;
	
	@Column(length = 28 , nullable = true)
	private String palmilhamontagem;
	
	@Column(length = 5 , nullable = true)
	private String palmilhamonpadrao;

	@Column(length = 5 , nullable = true)
	private String palmilhamontagemcodigo;
	
	@Column(length = 120 , nullable = true)
	private String obsconstrucao;
	
	@Column(length = 10 , nullable = true)
	private String relevobico;
	
	@Column(length = 10 , nullable = true)
	private String palmilhamontagemfornecedor;
	
	@Column(length = 10 , nullable = true)
	private String fachetefornecedor;
	
	@Column(length = 10 , nullable = true)
	private String fachetematerial;
	
	@Column(length = 20 , nullable = true)
	private String labeldescricao1;

	@Column(length = 20 , nullable = true)
	private String labeldescricao2;

	@Column(length = 20 , nullable = true)
	private String labeldescricao3;
	
	@Column(length = 20 , nullable = true)
	private String labeldescricao4;

	@Column(length = 48 , nullable = true)
	private String descricao1;

	@Column(length = 48 , nullable = true)
	private String descricao2;
	
	@Column(length = 48 , nullable = true)
	private String descricao3;

	@Column(length = 48 , nullable = true)
	private String descricao4;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "forma",foreignKey=@ForeignKey(name="cons_form_fk"))
	private Forma forma;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getConstrucaoid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
}