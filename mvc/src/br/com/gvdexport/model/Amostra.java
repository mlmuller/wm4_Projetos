package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Amostra",indexes= {@Index(columnList="cliente",name="amos_clie_ifk",unique=false)
								,@Index(columnList="componente",name="amos_comp_ifk",unique=false)
								,@Index(columnList="estacao",name="amos_esta_ifk",unique=false)
								,@Index(columnList="fabrica",name="amos_fabr_ifk",unique=false)
								,@Index(columnList="livroreferencia",name="amos_lire_ifk",unique=false)
								,@Index(columnList="construcao",name="amos_cons_ifk",unique = false)
								,@Index(columnList = "gerada",name = "amos_prdu_i",unique = false)
								,@Index(columnList="amos_pk,mercado",name="amos_id_merc_i",unique=false)})
//amos_prdu_i, indicativo se foi gerado amostra para producao, boolean ,ordem,primeiro nao geradas,se houver
@Getter @Setter

public class Amostra implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amostraSeq")
	@SequenceGenerator(name = "amostraSeq", sequenceName = "s_amostra", allocationSize = 1)
	@Column(name="amos_pk",updatable=false,nullable=false)
	private Long amostraId;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private Mercado mercado;

	@Column(nullable = true)
	private LocalDate dataEntrega;
	
	@Transient
	@Column(nullable = true)
	private LocalDate dataEntFinal;

	@Transient
	@Column(columnDefinition="boolean default true",nullable=true)
	private Boolean amostraselecao;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Tipo tipo;

	@Column(length = 1,nullable=true)
	private Boolean log;
	
	@Column(nullable = false)
	private LocalDate dataSolicitacao;
	
	@Transient
	@Column(nullable = true)
	private LocalDate dataSolFinal;

	
	@Column(precision=5,scale=1,nullable=false)
	private BigDecimal pares;
	
	@Column(length=6,nullable=true)
	private String amostraSize;

	@Column(nullable = false)
	private LocalDate dtxfct;

	@Transient
	private LocalDate dataXfcFinal;

	
	@Column(precision=5,scale=1)
	private BigDecimal pargvd;
	
	@Column(precision=5,scale=1)
	private BigDecimal parCancelado;
	
	@Column(length=1000)
	private String obs;
	
	@Column(length=3)
	private Integer linhaProducao;
	
	@Column(length=100)
	private String obsBase;
	
	@Column(precision=10,scale=4)
	private BigDecimal valorNegocFabr;
	
	@Column(length=60)
	private String complementoSolado;

	@Column(length=6)
	private Integer nroAmostraoId;
	
	@Column(length=60)
	private String obsSolado;
	
	@Column(nullable = true)
	private LocalDateTime dataLiberacaoProducao;

	@Column(nullable = true)
	private LocalDateTime dataLiberadaAltProducao;

	@Transient
	private LocalDateTime dataLibPrdFinal;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1)
	private PrioridadeProducao prioridadeProducao;
	
	private LocalDate datCadCam;
		
	@Column(length = 10, nullable = false)
	private String usuarioStamp;
	
	@Column(nullable = false)
	private LocalDateTime dataStamp;

	@Column(length = 25)
	private String sucFabrica;
	
	@Column(length = 15)
	private String sucCliente;
	
	@Column(length = 6 ,nullable = false)
	private Integer referencia;
	
	@Column(length = 1, nullable = true)
	private Boolean gerada;
	
	@Column(length = 1,nullable = true)
	private Boolean temcor;
	
	@Column(length = 2,nullable = false , columnDefinition = "smallint")
	private Integer versaoRefer;
	
	@Column(length = 3)
	private String abreviacao;

	@Column(length = 16)
	private String construcaoNome;
	
	@Column(length = 10)
	private  String referenciaForma;
	
	@Column(length = 2,columnDefinition = "smallint")
	private Integer versao;

	@OneToMany(mappedBy = "amostra",fetch = FetchType.EAGER)
	private List<CorAmostra> coresAmostra;

	public Amostra(){
		coresAmostra = new ArrayList<>();
	}
	
	//Estacoes
	@ManyToOne(optional = false)
	@JoinColumn(name="estacao",foreignKey=@ForeignKey(name="amos_esta_fk"))
	private Estacao estacao;
	
	//Fabricas
	@ManyToOne(optional = false)
	@JoinColumn(name="fabrica",foreignKey=@ForeignKey(name="amos_fabr_fk"))
	private Fabrica fabrica;
	
	//Componentes
	@ManyToOne(optional = false)
	@JoinColumn(name="componente",foreignKey=@ForeignKey(name="amos_comp_fk"))
	private Componente componente;

	//Clientes
	@ManyToOne(optional = false)
	@JoinColumn(name="cliente",foreignKey=@ForeignKey(name="amos_clie_fk"))
	private Cliente cliente;

	//Livros Referencias
	@ManyToOne(optional = false)
	@JoinColumn(name="livroReferencia",foreignKey=@ForeignKey(name="amos_lire_fk"))
	private LivroReferencia livroReferencia;

	//Construcoes
	@ManyToOne(optional = false)
	@JoinColumn(name="construcao",foreignKey=@ForeignKey(name="amos_cons_fk"))
	private Construcao construcao;
	
//	//Destinos Am Cf
	@ManyToOne(optional = true)
	@JoinColumn(name="destinoAmCf",foreignKey=@ForeignKey(name="amos_deac_fk"))
	private DestinoAmCf destinoAmCf;

	//Marcas Clientes
	@ManyToOne(optional = true)
	@JoinColumn(name="marcaCliente",foreignKey=@ForeignKey(name="amos_macl_fk"))
	private MarcaCliente marcaCliente;

	//Personagens
	@ManyToOne(optional = true)
	@JoinColumn(name="personagem",foreignKey=@ForeignKey(name="amos_pers_fk"))
	private Personagem personagem;

	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amostraId == null) ? 0 : amostraId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Amostra other = (Amostra) o;
		if (amostraId == null) {
			if (other.amostraId != null)
				return false;
		} else if (!amostraId.equals(other.amostraId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Amostra [amostraId=" + amostraId + "]";
	}
	
	

}
