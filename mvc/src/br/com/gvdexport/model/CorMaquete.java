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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CorMaquete",indexes=@Index(columnList="maqueteid",name="coma_maqu_i",unique=false)
						,uniqueConstraints={@UniqueConstraint(columnNames={"maqueteid","sequenciacormaquete"},name="maqu_cor_uk")})

@Getter @Setter
public class CorMaquete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "maqucorSeq")
	@SequenceGenerator(name = "maqucorSeq", sequenceName = "s_maqucor", allocationSize = 1)
	@Column(name="maqucor_pk",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long maqueteid;
	
	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacormaquete;
	
	
	@Column(length=60,nullable=false)
	private String cor;
	
	@Column(length=60,nullable=false)
	private String corprincipal;
	
	@Column(length=30,nullable=true)
	private String coretiqueta;
	
	@Column(length=60,nullable=false)
	private String material;
	
	@Column(length=10,nullable=true)
	private String espessura;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private DireitoEsquerdo pe;
	
	@Column(precision=5,scale=1,nullable=false)
	private BigDecimal totalpar;
	
	@Column(length=6,nullable=false)
	private String sizecor;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal parcancelado;

	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal saldoparetiqueta;
	
	@Column(precision=5,scale=1,nullable=true)
	private BigDecimal saldoparinvoice;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=true)
	private TipoMaterial tipmaterial;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns(value= {@JoinColumn(name="coma_maquid_fk",referencedColumnName="maqucor_pk",nullable=false)}
						,foreignKey=@ForeignKey(name="coma_maqcor_fk"))
	private CorMaquete cormaquete;

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
		CorMaquete other = (CorMaquete) obj;
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
