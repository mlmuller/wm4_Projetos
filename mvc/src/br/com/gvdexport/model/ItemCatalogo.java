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
@Table(name="ItemCatalogo",indexes= {@Index(columnList="itecat_cata_fk",unique=false,name="itemcat_cata_ifk")
									,@Index(columnList="amostraid_fk,sequenciacoramostra_fk",unique=false,name="itemcat_amocor_ifk")})
@IdClass(ItemCatalogoId.class)

public class ItemCatalogo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long catalogoid;
	
	@Id
	private Long itemcatalogoid;
	
	@Column(length=5,nullable=true)
	private Integer ordemimpressao;
	
	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal precofob;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date delivery;
	
	@Column(length=300,nullable=true)
	private String observacao;

	@Column(length=5,nullable=true)
	private Integer ordemreferencia;

	@Column(length=60,nullable=true)
	private String outrocor;

	@Column(length=60,nullable=true)
	private String outromaterial;
	
	@Column(length=20,nullable=true)
	private String outromodelo;

	@Column(length=30,nullable=true)
	private String outromarca;

	@Column(length=6,nullable=true)
	private Integer pares;

	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal preco;
	
	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal precovendaproduto;
	
	@Column(precision=10,scale=4,nullable=true)
	private BigDecimal precodesconto;

	@Column(length=300,nullable=true)
	private String observacao1;

	@Column(length=300,nullable=true)
	private String observacao2;
	
	//Chaves Estrangeiras
	//Cor Amostra - chave composta
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="amostraid_fk",referencedColumnName="amostraid",nullable=true),@JoinColumn(name="sequenciacoramostra_fk",referencedColumnName="sequenciacoramostra",nullable=true)},foreignKey=@ForeignKey(name="itecat_coramo_fk"))
	private CorAmostra coramostra;

	//Livros Referencias
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="itecat_lire_fk",referencedColumnName="lire_pk",nullable=false,foreignKey=@ForeignKey(name="itecat_lire_fk"))
	private LivroReferencia livrosreferenciasoutros;

	//Livros Referencias
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="itecat_cata_fk",referencedColumnName="catalogo_pk",nullable=false,foreignKey=@ForeignKey(name="itecat_cata_fk"))
	private Catalogo catalogo;

	public Long getCatalogoid() {
		return catalogoid;
	}

	public void setCatalogoid(Long catalogoid) {
		this.catalogoid = catalogoid;
	}

	public Long getItemcatalogoid() {
		return itemcatalogoid;
	}

	public void setItemcatalogoid(Long itemcatalogoid) {
		this.itemcatalogoid = itemcatalogoid;
	}

	public Integer getOrdemimpressao() {
		return ordemimpressao;
	}

	public void setOrdemimpressao(Integer ordemimpressao) {
		this.ordemimpressao = ordemimpressao;
	}

	public BigDecimal getPrecofob() {
		return precofob;
	}

	public void setPrecofob(BigDecimal precofob) {
		this.precofob = precofob;
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

	public Date getDelivery() {
		return delivery;
	}

	public void setDelivery(Date delivery) {
		this.delivery = delivery;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getOrdemreferencia() {
		return ordemreferencia;
	}

	public void setOrdemreferencia(Integer ordemreferencia) {
		this.ordemreferencia = ordemreferencia;
	}

	public String getOutrocor() {
		return outrocor;
	}

	public void setOutrocor(String outrocor) {
		this.outrocor = outrocor;
	}

	public String getOutromaterial() {
		return outromaterial;
	}

	public void setOutromaterial(String outromaterial) {
		this.outromaterial = outromaterial;
	}

	public String getOutromodelo() {
		return outromodelo;
	}

	public void setOutromodelo(String outromodelo) {
		this.outromodelo = outromodelo;
	}

	public String getOutromarca() {
		return outromarca;
	}

	public void setOutromarca(String outromarca) {
		this.outromarca = outromarca;
	}

	public Integer getPares() {
		return pares;
	}

	public void setPares(Integer pares) {
		this.pares = pares;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getPrecovendaproduto() {
		return precovendaproduto;
	}

	public void setPrecovendaproduto(BigDecimal precovendaproduto) {
		this.precovendaproduto = precovendaproduto;
	}

	public BigDecimal getPrecodesconto() {
		return precodesconto;
	}

	public void setPrecodesconto(BigDecimal precodesconto) {
		this.precodesconto = precodesconto;
	}

	public String getObservacao1() {
		return observacao1;
	}

	public void setObservacao1(String observacao1) {
		this.observacao1 = observacao1;
	}

	public String getObservacao2() {
		return observacao2;
	}

	public void setObservacao2(String observacao2) {
		this.observacao2 = observacao2;
	}

	public CorAmostra getCoramostra() {
		return coramostra;
	}

	public void setCoramostra(CorAmostra coramostra) {
		this.coramostra = coramostra;
	}

	public LivroReferencia getLivrosreferenciasoutros() {
		return livrosreferenciasoutros;
	}

	public void setLivrosreferenciasoutros(LivroReferencia livrosreferenciasoutros) {
		this.livrosreferenciasoutros = livrosreferenciasoutros;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalogoid == null) ? 0 : catalogoid.hashCode());
		result = prime * result + ((itemcatalogoid == null) ? 0 : itemcatalogoid.hashCode());
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
		ItemCatalogo other = (ItemCatalogo) obj;
		if (catalogoid == null) {
			if (other.catalogoid != null)
				return false;
		} else if (!catalogoid.equals(other.catalogoid))
			return false;
		if (itemcatalogoid == null) {
			if (other.itemcatalogoid != null)
				return false;
		} else if (!itemcatalogoid.equals(other.itemcatalogoid))
			return false;
		return true;
	}

	
}
