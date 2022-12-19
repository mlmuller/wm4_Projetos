package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="CosturaConfirmacao",uniqueConstraints={@UniqueConstraint(columnNames={"confirmacaoid"},name="conf_cost_uk")})
@Getter @Setter
public class CosturaConfirmacao implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confcosturaSeq")
	@SequenceGenerator(name = "confcosturaSeq", sequenceName = "s_confcostura", allocationSize = 1)
	@Column(name="confcostura_pk",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long confirmacaoid;
	
	@Column(length=38,nullable=true)
	private String borda;
	
	@Column(length=10,nullable=true)
	private String bordatipo;
	
	@Column(length=17,nullable=true)
	private String linha1;
	
	@Column(length=10,nullable=true)
	private String linha1espess;

	@Column(length=10,nullable=true)
	private String linha1forn;

	@Column(length=10,nullable=true)
	private String linha1pto;

	@Column(length=17,nullable=true)
	private String linha2;
	
	@Column(length=10,nullable=true)
	private String linha2espess;

	@Column(length=10,nullable=true)
	private String linha2forn;

	@Column(length=10,nullable=true)
	private String linha2pto;

	@Column(length=17,nullable=true)
	private String fioceleiro;
	
	@Column(length=10,nullable=true)
	private String fioceleiroespes;

	@Column(length=10,nullable=true)
	private String fioceleiroref;

	@Column(length=10,nullable=true)
	private String fioceleiroforn;

	@Column(length=10,nullable=true)
	private String fivelatipo;
	
	@Column(length=10,nullable=true)
	private String fivelaref;
	
	@Column(length=10,nullable=true)
	private String fivelaforn;
	
	@Column(length=10,nullable=true)
	private String rebiteref;
	
	@Column(length=10,nullable=true)
	private String rebiteforn;
	
	@Column(length=10,nullable=true)
	private String ilhosref;
	
	@Column(length=10,nullable=true)
	private String ilhosforn;
	
	@Column(length=18,nullable=true)
	private String ornamento;
	
	@Column(length=10,nullable=true)
	private String ornamentoref;
	
	@Column(length=18,nullable=true)
	private String ornamentoforn;
	
	@Column(length=18,nullable=true)
	private String bielastico;
	
	@Column(length=10,nullable=true)
	private String bielasticotipo;
	
	@Column(length=10,nullable=true)
	private String bielasticolargura;

	@Column(length=10,nullable=true)
	private String bielasticoforn;

	@Column(length=18,nullable=true)
	private String elastico;
	
	@Column(length=10,nullable=true)
	private String elasticotipo;
	
	@Column(length=10,nullable=true)
	private String elasticolargura;

	@Column(length=10,nullable=true)
	private String elasticoforn;
	
	@Column(length=18,nullable=true)
	private String zipper;
	
	@Column(length=10,nullable=true)
	private String zippertipo;
	
	@Column(length=10,nullable=true)
	private String zippermat;

	@Column(length=10,nullable=true)
	private String zipperforn;

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
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Confirmacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cost_conf_fk",referencedColumnName="confirmacao_pk",nullable=false,foreignKey=@ForeignKey(name="cost_conf_fk"))
	private Confirmacao confirmacao;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmacaoid == null) ? 0 : confirmacaoid.hashCode());
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
		CosturaConfirmacao other = (CosturaConfirmacao) obj;
		if (confirmacaoid == null) {
			if (other.confirmacaoid != null)
				return false;
		} else if (!confirmacaoid.equals(other.confirmacaoid))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getConfirmacaoid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}


}
