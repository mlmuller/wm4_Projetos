package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="FichaProducao",uniqueConstraints = {@UniqueConstraint(columnNames = {"corconfirmacao"},name = "fichaProducao_corconfirmacao_UK"),
		                                         @UniqueConstraint(columnNames = {"cormaquete"},name = "fichaproducao_cormaquete_UK"),
		                                         @UniqueConstraint(columnNames = {"coramostra"},name = "fichaproducao_coramostra_UK")},
							indexes= {@Index(columnList="amostra,coramostra",name="ficprod_coramos_ifk"),
									  @Index(columnList="maquete,cormaquete",name="ficprod_cormaqu_ifk")})
@Getter @Setter
public class FichaProducao implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "fichaproducaoSeq")
	@SequenceGenerator(name = "fichaproducaoSeq", sequenceName = "s_fichaproducao", allocationSize = 1)
	@Column(name="fichaproducao_pk",updatable=false,nullable=false)
	private Long fichaproducaoid;
	
	@Column(nullable = true)
	private LocalDateTime dataentrada;

	@Column(nullable=true)
	private Boolean aliberar;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Column(nullable = false)
	private LocalDateTime datastamp;

	@Column(precision=6,scale=1,nullable=false)
	private BigDecimal pares;
	
	@Column(precision=6,scale=1,nullable=false)
	private BigDecimal paresatual;
	
	@Column(nullable = true)
	private LocalDate datamodelagem;
	
	@Column(nullable = true)
	private LocalDate dataalmoxarifado;

	@Column(nullable = true)
	private LocalDate datafalmoxarifado;

	@Column(nullable = true)
	private LocalDate dataalmoxarifadopre;

	@Column(nullable = true)
	private LocalDate datafalmoxarifadopre;
	
	@Column(nullable = true)
	private LocalDate dataprefabricado;

	@Column(nullable = true)
	private LocalDate datafprefabricado;

	@Column(nullable = true)
	private LocalDate datacorte;

	@Column(nullable = true)
	private LocalDate datafcorte;

	@Column(nullable = true)
	private LocalDate datacostura;
	
	@Column(nullable = true)
	private LocalDate datafcostura;

	@Column(nullable = true)
	private LocalDate datadistribuicao;
	
	@Column(nullable = true)
	private LocalDate datafdistribuicao;

	@Column(nullable = true)
	private LocalDate datamontagem;
	
	@Column(nullable = true)
	private LocalDate datafmontagem;

	@Column(nullable = true)
	private LocalDate dataacabamento;

	@Column(nullable = true)
	private LocalDate datafacabamento;

	@Column(nullable = true)
	private LocalDateTime datacorrecao;
	
	@Column(length=600,nullable=true)
	private String comentario;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private SituacaoProducao situacao;

	@Column(nullable = true)
	private LocalDate dataimpressao;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private EmTransicao liberadoalteraramostra = EmTransicao.N;
	
	@Column(length = 7,nullable = true)
	private String semaforo;
	
	//Cor Confirmacao
	@ManyToOne(optional = true)
	@JoinColumn(name="corconfirmacao",referencedColumnName="confcor_pk",nullable = true,foreignKey=@ForeignKey(name="FK_fichaproducao_corconfirmacao"))
	private CorConfirmacao corconfirmacao;

	//Maquete
	@ManyToOne(optional = true)
	@JoinColumn(name="maquete",referencedColumnName="maqu_pk",nullable = true,foreignKey=@ForeignKey(name="FK_fichaproducao_maquete"))
	private Maquete maquete;

	
	//Cor Maquete
	@ManyToOne(optional = true)
	@JoinColumn(name="cormaquete",referencedColumnName="maqucor_pk",nullable = true,foreignKey=@ForeignKey(name="FK_fichaproducao_cormaquete"))
	private CorMaquete cormaquete;
	
	//Cor Amostra
	@ManyToOne(optional = true)
	@JoinColumn(name="coramostra",referencedColumnName="amosCor_Pk",nullable = true, foreignKey=@ForeignKey(name="FK_fichaproducao_coramostra"))
	private CorAmostra coramostra;

	//Amostra
	@ManyToOne(optional = true)
	@JoinColumn(name="amostra",referencedColumnName="amos_pk",nullable = true,foreignKey=@ForeignKey(name="FK_fichaproducao_amostra"))
	private Amostra amostra;
	
	@Override
	public int hashCode() {
		return Objects.hash(fichaproducaoid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FichaProducao other = (FichaProducao) obj;
		return Objects.equals(fichaproducaoid, other.fichaproducaoid);
	}

	@Override
	public String toString() {
		return "FichaProducao [fichaproducaoid=" + fichaproducaoid + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

}
