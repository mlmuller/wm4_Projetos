package br.com.gvdexport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SubGradeAltPar",indexes= {@Index(columnList="subgralt_razalt_fk",name="subgralt_razalt_ifk",unique=false)
									  ,@Index(columnList="pedidoid,sbgradepedidoid",name="subgralt_pedsub_ifk",unique=false)})
@IdClass(SubGradeAltParId.class)

public class SubGradeAltPar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long pedidoid;
	
	@Id
	private Long sbgradepedidoid;
	
	@Id
	private Long sequenciaid;
	
	@Column(length=104,nullable=true)
	private String paresmusical;
	
	@Column(length=104,nullable=true)
	private String paressolido;
	
	@Column(length=104,nullable=true)
	private String paresmusicalnarrow;
	
	@Column(length=104,nullable=true)
	private String paresmusicallwidth;

	@Column(precision=5,scale=1,nullable=false)
	private BigDecimal pares;
	
	@Column(length=5,nullable=true)
	private Integer caixas;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date data;
	
	//Chaves Estrangeiras
	//Razao Alteracao
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="subgralt_razalt_fk",referencedColumnName="razaoalteracao_pk",nullable=false,foreignKey=@ForeignKey(name="subgralt_razalt_fk"))
	private RazaoAlteracao razaoalteracao;
	
	//SubGradePedido
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="subgralt_pedi_fk",referencedColumnName="pedidoid",nullable=false),@JoinColumn(name="subgralt_subgrd_fk",referencedColumnName="subgradepedidoid",nullable=false)},foreignKey=@ForeignKey(name="subgralt_pedsub_fk"))
	private SubGradePedido subgradepedido;

	public Long getPedidoid() {
		return pedidoid;
	}

	public void setPedidoid(Long pedidoid) {
		this.pedidoid = pedidoid;
	}

	public Long getSbgradepedidoid() {
		return sbgradepedidoid;
	}

	public void setSbgradepedidoid(Long sbgradepedidoid) {
		this.sbgradepedidoid = sbgradepedidoid;
	}

	public Long getSequenciaid() {
		return sequenciaid;
	}

	public void setSequenciaid(Long sequenciaid) {
		this.sequenciaid = sequenciaid;
	}

	public String getParesmusical() {
		return paresmusical;
	}

	public void setParesmusical(String paresmusical) {
		this.paresmusical = paresmusical;
	}

	public String getParessolido() {
		return paressolido;
	}

	public void setParessolido(String paressolido) {
		this.paressolido = paressolido;
	}

	public String getParesmusicalnarrow() {
		return paresmusicalnarrow;
	}

	public void setParesmusicalnarrow(String paresmusicalnarrow) {
		this.paresmusicalnarrow = paresmusicalnarrow;
	}

	public String getParesmusicallwidth() {
		return paresmusicallwidth;
	}

	public void setParesmusicallwidth(String paresmusicallwidth) {
		this.paresmusicallwidth = paresmusicallwidth;
	}

	public BigDecimal getPares() {
		return pares;
	}

	public void setPares(BigDecimal pares) {
		this.pares = pares;
	}

	public Integer getCaixas() {
		return caixas;
	}

	public void setCaixas(Integer caixas) {
		this.caixas = caixas;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public RazaoAlteracao getRazaoalteracao() {
		return razaoalteracao;
	}

	public void setRazaoalteracao(RazaoAlteracao razaoalteracao) {
		this.razaoalteracao = razaoalteracao;
	}

	public SubGradePedido getSubgradepedido() {
		return subgradepedido;
	}

	public void setSubgradepedido(SubGradePedido subgradepedido) {
		this.subgradepedido = subgradepedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidoid == null) ? 0 : pedidoid.hashCode());
		result = prime * result + ((sbgradepedidoid == null) ? 0 : sbgradepedidoid.hashCode());
		result = prime * result + ((sequenciaid == null) ? 0 : sequenciaid.hashCode());
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
		SubGradeAltPar other = (SubGradeAltPar) obj;
		if (pedidoid == null) {
			if (other.pedidoid != null)
				return false;
		} else if (!pedidoid.equals(other.pedidoid))
			return false;
		if (sbgradepedidoid == null) {
			if (other.sbgradepedidoid != null)
				return false;
		} else if (!sbgradepedidoid.equals(other.sbgradepedidoid))
			return false;
		if (sequenciaid == null) {
			if (other.sequenciaid != null)
				return false;
		} else if (!sequenciaid.equals(other.sequenciaid))
			return false;
		return true;
	}

	
}
