package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ProblemaProducao",indexes= {@Index(columnList="probprd_setor_fk",name="probprd_setor_ifk")
							  			,@Index(columnList="probprd_motprod_fk",name="probprd_motivo_ifk")
										,@Index(columnList="probprd_fichprd_fk",name="probprd_fichprd_ifk")
							  			,@Index(columnList="probprd_fichdst_fk",name="probprd_fichdst_ifk")})
@IdClass(ProblemaProducaoId.class)
public class ProblemaProducao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long fichaproducaoid;
	
	@Id
	private Long sequenciaproblemaproducao;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date data;
	
	@Column(precision=6,scale=1,nullable=false)
	private BigDecimal pares;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private SimNao refazer;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length = 100, nullable = false)
	private String observacao;
	
	//Chave estrangeira fichaproducaoid-
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="probprd_fichprd_fk",referencedColumnName="fichaproducao_pk",nullable=true,foreignKey=@ForeignKey(name="probprd_fichprd_fk"))
	private FichaProducao fichaproducao;
	
	//Chave estrangeira fichaproducaoid
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="probprd_fichdst_fk",referencedColumnName="fichaproducao_pk",nullable=true,foreignKey=@ForeignKey(name="probprd_fichdst_fk"))
	private FichaProducao fichaproducaodestino;

	//Chave estrangeira Setor
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="probprd_setor_fk",referencedColumnName="setor_pk",nullable=true,foreignKey=@ForeignKey(name="probprd_setor_fk"))
	private Setor setor;
	
	//Chave estrangeira Setor
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="probprd_motprod_fk",referencedColumnName="motivoprod_pk",nullable=true,foreignKey=@ForeignKey(name="probprd_motprod_fk"))
	private MotivoProducao motivoproducao;

	public Long getFichaproducaoid() {
		return fichaproducaoid;
	}

	public void setFichaproducaoid(Long fichaproducaoid) {
		this.fichaproducaoid = fichaproducaoid;
	}

	public Long getSequenciaproblemaproducao() {
		return sequenciaproblemaproducao;
	}

	public void setSequenciaproblemaproducao(Long sequenciaproblemaproducao) {
		this.sequenciaproblemaproducao = sequenciaproblemaproducao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getPares() {
		return pares;
	}

	public void setPares(BigDecimal pares) {
		this.pares = pares;
	}

	public SimNao getRefazer() {
		return refazer;
	}

	public void setRefazer(SimNao refazer) {
		this.refazer = refazer;
	}

	public String getUsuariostamp() {
		return usuariostamp;
	}

	public void setUsuariostamp(String usuariostamp) {
		this.usuariostamp = usuariostamp;
	}

	public Date getDatastamp() {
		return datastamp;
	}

	public void setDatastamp(Date datastamp) {
		this.datastamp = datastamp;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public FichaProducao getFichaproducao() {
		return fichaproducao;
	}

	public void setFichaproducao(FichaProducao fichaproducao) {
		this.fichaproducao = fichaproducao;
	}

	public FichaProducao getFichaproducaodestino() {
		return fichaproducaodestino;
	}

	public void setFichaproducaodestino(FichaProducao fichaproducaodestino) {
		this.fichaproducaodestino = fichaproducaodestino;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public MotivoProducao getMotivoproducao() {
		return motivoproducao;
	}

	public void setMotivoproducao(MotivoProducao motivoproducao) {
		this.motivoproducao = motivoproducao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fichaproducaoid == null) ? 0 : fichaproducaoid.hashCode());
		result = prime * result + ((sequenciaproblemaproducao == null) ? 0 : sequenciaproblemaproducao.hashCode());
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
		ProblemaProducao other = (ProblemaProducao) obj;
		if (fichaproducaoid == null) {
			if (other.fichaproducaoid != null)
				return false;
		} else if (!fichaproducaoid.equals(other.fichaproducaoid))
			return false;
		if (sequenciaproblemaproducao == null) {
			if (other.sequenciaproblemaproducao != null)
				return false;
		} else if (!sequenciaproblemaproducao.equals(other.sequenciaproblemaproducao))
			return false;
		return true;
	}
	

}
