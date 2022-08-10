package br.com.gvdexport.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CosturaAmostra",uniqueConstraints={@UniqueConstraint(columnNames={"amostra"},name="UK_Costura_Amostra")})
@Getter @Setter
public class CosturaAmostra implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "amoscosturaSeq")
	@SequenceGenerator(name = "amoscosturaSeq", sequenceName = "s_amoscostura", allocationSize = 1)
	@Column(name="idcosturaamostra",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long amostraid;
	
	@Column(length=38,nullable=true)
	private String borda;
	
	@Column(length=10,nullable=true)
	private String bordatipo;
	
	@Column(length=17,nullable=true)
	private String linha1;

	@Column(length=10,nullable=true)
	private String linhaespessura;

	@Column(length=10,nullable=true)
	private String linhafornecedor;
	
	@Column(length=10,nullable=true)
	private String linhapto;

	@Column(length=17,nullable=true)
	private String linha2;

	@Column(length=10,nullable=true)
	private String linha2espessura;

	@Column(length=10,nullable=true)
	private String linha2fornecedor;
	
	@Column(length=10,nullable=true)
	private String linha2pto;
	
	@Column(length=17,nullable=true)
	private String fioceleiro;

	@Column(length=10,nullable=true)
	private String fioceleiroespessura;

	@Column(length=10,nullable=true)
	private String fioceleiroreferencia;
	
	@Column(length=10,nullable=true)
	private String fioceleirofornecedor;
	
	@Column(length=10,nullable=true)
	private String fivelatipo;
	
	@Column(length=10,nullable=true)
	private String fivelareferencia;
	
	@Column(length=10,nullable=true)
	private String fivelafornecedor;
	
	@Column(length=10,nullable=true)
	private String rebitereferencia;
	
	@Column(length=10,nullable=true)
	private String rebitefornecedor;
	
	@Column(length=10,nullable=true)
	private String ilhosreferencia;
	
	@Column(length=10,nullable=true)
	private String ilhosfornecedor;
	
	@Column(length=18,nullable=true)
	private String ornamento;

	@Column(length=10,nullable=true)
	private String ornamentoreferencia;

	@Column(length=10,nullable=true)
	private String ornamentofornecedor;

	@Column(length=18,nullable=true)
	private String bielastico;
	
	@Column(length=10,nullable=true)
	private String bielasticotipo;
	
	@Column(length=10,nullable=true)
	private String bielasticolargura;
	
	@Column(length=10,nullable=true)
	private String bielasticofornecedor;
	
	@Column(length=18,nullable=true)
	private String elastico;
	
	@Column(length=10,nullable=true)
	private String elasticotipo;
	
	@Column(length=10,nullable=true)
	private String elasticolargura;

	@Column(length=10,nullable=true)
	private String elasticofornecedor;
	
	@Column(length=18,nullable=true)
	private String zipper;

	@Column(length=10,nullable=true)
	private String zippertipo;

	@Column(length=10,nullable=true)
	private String zippermaterial;
	
	@Column(length=10,nullable=true)
	private String zipperfornecedor;
	
	@Column(length=60,nullable=true)
	private String complemento;
	
	@Column(length=45,nullable=true)
	private String linha3;
	
	@Column(length=45,nullable=true)
	private String velcro;

	@Column(length=60,nullable=true)
	private String observacao;

	@Column(length=20,nullable=true)
	private String labeldescricao1;

	@Column(length=20,nullable=true)
	private String labeldescricao2;

	@Column(length=20,nullable=true)
	private String labeldescricao3;

	@Column(length=48,nullable=true)
	private String descricao1;

	@Column(length=48,nullable=true)
	private String descricao2;

	@Column(length=48,nullable=true)
	private String descricao3;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Column(nullable = false)
	private LocalDateTime dataStamp;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="amostra",referencedColumnName="amos_pk",nullable=false,foreignKey=@ForeignKey(name="FK_Costura_Amostra"))
	private Amostra amostra;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getAmostraid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amostraid == null) ? 0 : amostraid.hashCode());
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
		CosturaAmostra other = (CosturaAmostra) obj;
		if (amostraid == null) {
			if (other.amostraid != null)
				return false;
		} else if (!amostraid.equals(other.amostraid))
			return false;
		return true;
	}

}
