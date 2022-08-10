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
@Table(name="AcabamentoMaquete",uniqueConstraints= {@UniqueConstraint(columnNames={"maqueteid"},name="maqu_acab_uk")})

@Getter @Setter
public class AcabamentoMaquete implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "maqacabSeq")
	@SequenceGenerator(name = "maqucabSeq", sequenceName = "s_bmaquacab", allocationSize = 1)
	@Column(name="maquacab_pk",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long maqueteid;
	
	@Column(length=10, nullable=true)
	private String palmilhainterna;

	@Column(length=10, nullable=true)
	private String palmilhainternareferencia;
	
	@Column(length=10, nullable=true)
	private String palmilhainternafornecedor;
	
	@Column(length=17, nullable=true)
	private String espuma;

	@Column(length=10, nullable=true)
	private String espumatipo;
	
	@Column(length=10, nullable=true)
	private String espumaespessura;
	
	@Column(length=10, nullable=true)
	private String espumafornecedor;
	
	@Column(length=5, nullable=true)
	private String espumadensidade;

	@Column(length=38, nullable=true)
	private String debrumpalmilha;

	@Column(length=10, nullable=true)
	private String debrumtipo;

	@Column(length=45, nullable=true)
	private String carimboetiqueta;

	@Column(length=17, nullable=true)
	private String fioceleiro;


	@Column(length=10, nullable=true)
	private String fioceleiroespessura;
	

	@Column(length=10, nullable=true)
	private String fioceleiroreferencia;
	

	@Column(length=10, nullable=true)
	private String fioceleirofornecedor;
	

	@Column(length=10, nullable=true)
	private String fivelatipo;

	@Column(length=10, nullable=true)
	private String fivelareferencia;
	
	@Column(length=10, nullable=true)
	private String fivelafornecedor;
	
	@Column(length=10, nullable=true)
	private String rebitereferencia;
	
	@Column(length=10, nullable=true)
	private String rebitefornecedor;
	
	@Column(length=10, nullable=true)
	private String ilhosreferencia;
	
	@Column(length=10, nullable=true)
	private String ilhosfornecedor;
	
	@Column(length=18, nullable=true)
	private String ornamento;
	
	@Column(length=10, nullable=true)
	private String ornamentoreferencia;
	
	@Column(length=10, nullable=true)
	private String ornamentofornecedor;
	
	@Column(length=18, nullable=true)
	private String elastico;

	@Column(length=10, nullable=true)
	private String elasticotipo ;

	@Column(length=10, nullable=true)
	private String elasticolargura;
	
	@Column(length=10, nullable=true)
	private String elasticofornecedor;
	
	@Column(length=18, nullable=true)
	private String zipper ;

	@Column(length=10, nullable=true)
	private String zippertipo;
	
	@Column(length=10, nullable=true)
	private String zippermataterial;
	
	@Column(length=10, nullable=true)
	private String zipperfornecedor;
	
	@Column(length=17, nullable=true)
	private String atacador;
	
	@Column(length=10, nullable=true)
	private String atacadortipo;

	@Column(length=5, nullable=true)
	private String atacadorcomprimento;
	
	@Column(length=10, nullable=true)
	private String atacadorfornecedor;

	@Column(length=28, nullable=true)
	private String forrogaspea;
	
	@Column(length=10, nullable=true)
	private String forrogaspeareferencia ;

	@Column(length=10, nullable=true)
	private String forrogaspeafornecedor;
	
	@Column(length=17, nullable=true)
	private String linha1;
	
	@Column(length=10, nullable=true)
	private String linhaespessura;
	
	@Column(length=10, nullable=true)
	private String linhafornecedor;
	
	@Column(length=10, nullable=true)
	private String linhapto;
	
	@Column(length=17, nullable=true)
	private String linha2;
	
	@Column(length=10, nullable=true)
	private String linha2espessura;
	
	@Column(length=10, nullable=true)
	private String linha2fornecedor;
	
	@Column(length=10, nullable=true)
	private String linha2pto;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=20, nullable=true)
	private String labeldescricao1;

	@Column(length=20, nullable=true)
	private String labeldescricao2;

	@Column(length=20, nullable=true)
	private String labeldescricao3;
	
	@Column(length=48, nullable=true)
	private String descricao1;

	@Column(length=48, nullable=true)
	private String descricao2;

	@Column(length=48, nullable=true)
	private String descricao3;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="acma_maqu_fk",referencedColumnName="maqu_pk",nullable=false,foreignKey=@ForeignKey(name="acma_maqu_fk"))
	private Maquete maquete;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maqueteid == null) ? 0 : maqueteid.hashCode());
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
		AcabamentoMaquete other = (AcabamentoMaquete) obj;
		if (maqueteid == null) {
			if (other.maqueteid != null)
				return false;
		} else if (!maqueteid.equals(other.maqueteid))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getMaqueteid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}


}
