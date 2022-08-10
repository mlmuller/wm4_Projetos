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
@Table(name="CorAcabamentoMq",uniqueConstraints={@UniqueConstraint(columnNames={"maqueteid","sequenciacormaquete"},name="maqu_coracab_uk")})
@Getter @Setter
public class CorAcabamentoMq implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "maqucoracabSeq")
	@SequenceGenerator(name = "maqucoracabSeq", sequenceName = "s_maqucoracab", allocationSize = 1)
	@Column(name="maqucoracab_pk",updatable=false,nullable=false)
	private Long id;

	
	
	@Column(updatable=false,nullable=false)
	private Long maqueteid;
	
	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacormaquete;
	
	@Column(length=10,nullable=true)
	private String palmilhainterna;
	
	@Column(length=10,nullable=true)
	private String carimboetiqueta;
	
	@Column(length=10,nullable=true)
	private String fioceleiro;

	@Column(length=10,nullable=true)
	private String fivela;
	
	@Column(length=10,nullable=true)
	private String rebite;
	
	@Column(length=10,nullable=true)
	private String ilhos;
	
	@Column(length=10,nullable=true)
	private String ornamento;
	
	@Column(length=10,nullable=true)
	private String elastico;
	
	@Column(length=10,nullable=true)
	private String zipper;
	
	@Column(length=10,nullable=true)
	private String atacador;
	
	@Column(length=10,nullable=true)
	private String forrogaspea;

	@Column(length=10,nullable=true)
	private String linha1;

	@Column(length=10,nullable=true)
	private String linha2;

	@Column(length=10,nullable=true)
	private String solalaminada;
	
	@Column(length=10,nullable=true)
	private String solainjetada;
	
	@Column(length=10,nullable=true)
	private String entressola;
	
	@Column(length=10,nullable=true)
	private String vira1;
	
	@Column(length=10,nullable=true)
	private String vira2;
	
	@Column(length=10,nullable=true)
	private String tipobeira;
	
	@Column(length=10,nullable=true)
	private String salto;
	
	@Column(length=10,nullable=true)
	private String plataforma;
	
	@Column(length=10,nullable=true)
	private String tacao;
	
	@Column(length=10,nullable=true)
	private String carimbosola;

	@Column(length=10,nullable=true)
	private String descricao1;

	@Column(length=10,nullable=true)
	private String descricao2;

	@Column(length=10,nullable=true)
	private String descricao3;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="camq_maqu_fk",referencedColumnName="maqu_pk",nullable=false,foreignKey=@ForeignKey(name="camq_maqu_fk"))
	private Maquete maquete;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maqueteid == null) ? 0 : maqueteid.hashCode());
		result = prime * result + ((sequenciacormaquete == null) ? 0 : sequenciacormaquete.hashCode());
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
		CorAcabamentoMq other = (CorAcabamentoMq) obj;
		if (maqueteid == null) {
			if (other.maqueteid != null)
				return false;
		} else if (!maqueteid.equals(other.maqueteid))
			return false;
		if (sequenciacormaquete == null) {
			if (other.sequenciacormaquete != null)
				return false;
		} else if (!sequenciacormaquete.equals(other.sequenciacormaquete))
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
