package br.com.gvdexport.model;

import java.io.Serializable;
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
@Table(name="ItemAvisoRetorno",indexes= {@Index(columnList="itavre_fafaid_fk,itavre_itfafa_fk",name="itavre_itfafa_ifk",unique=false)
									    ,@Index(columnList="avisoretornoid",name="itavre_avre_i",unique=false)})
@IdClass(ItemAvisoRetornoId.class)

public class ItemAvisoRetorno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long avisoretornoid;
	
	@Id
	private Long itemavisoretornoid;
	
	@Column(length=6,nullable=false)
	private Integer pares;
	
	@Column(length=104,nullable=true)
	private String paressolido;
	
	@Column(length=104,nullable=true)
	private String paresmusical;

	@Column(length=4,nullable=false)
	private Integer caixas;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Chaves Estrangeiras
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={@JoinColumn(name="itavre_fafaid_fk",referencedColumnName="faturafabricaid",nullable=false),@JoinColumn(name="itavre_itfafa_fk",referencedColumnName="itemfaturafabricaid",nullable=false)},foreignKey=@ForeignKey(name="itavre_itfafa_fk"))
	private ItemFaturaFabrica itemfaturafabrica;

	public Long getAvisoretornoid() {
		return avisoretornoid;
	}

	public void setAvisoretornoid(Long avisoretornoid) {
		this.avisoretornoid = avisoretornoid;
	}

	public Long getItemavisoretornoid() {
		return itemavisoretornoid;
	}

	public void setItemavisoretornoid(Long itemavisoretornoid) {
		this.itemavisoretornoid = itemavisoretornoid;
	}

	public Integer getPares() {
		return pares;
	}

	public void setPares(Integer pares) {
		this.pares = pares;
	}

	public String getParessolido() {
		return paressolido;
	}

	public void setParessolido(String paressolido) {
		this.paressolido = paressolido;
	}

	public String getParesmusical() {
		return paresmusical;
	}

	public void setParesmusical(String paresmusical) {
		this.paresmusical = paresmusical;
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

	public ItemFaturaFabrica getItemfaturafabrica() {
		return itemfaturafabrica;
	}

	public void setItemfaturafabrica(ItemFaturaFabrica itemfaturafabrica) {
		this.itemfaturafabrica = itemfaturafabrica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avisoretornoid == null) ? 0 : avisoretornoid.hashCode());
		result = prime * result + ((itemavisoretornoid == null) ? 0 : itemavisoretornoid.hashCode());
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
		ItemAvisoRetorno other = (ItemAvisoRetorno) obj;
		if (avisoretornoid == null) {
			if (other.avisoretornoid != null)
				return false;
		} else if (!avisoretornoid.equals(other.avisoretornoid))
			return false;
		if (itemavisoretornoid == null) {
			if (other.itemavisoretornoid != null)
				return false;
		} else if (!itemavisoretornoid.equals(other.itemavisoretornoid))
			return false;
		return true;
	}


}
