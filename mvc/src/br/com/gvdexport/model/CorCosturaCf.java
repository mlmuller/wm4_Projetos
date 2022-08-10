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
@Table(name="CorCosturaCf",uniqueConstraints={@UniqueConstraint(columnNames={"confirmacaoid","sequenciacorconfirmacao"},name="conf_corcost_uk")})
@Getter @Setter
public class CorCosturaCf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "confcorcostSeq")
	@SequenceGenerator(name = "confcorcostSeq", sequenceName = "s_confcorcost", allocationSize = 1)
	@Column(name="confcorcost_pk",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long confirmacaoid;
	
	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacorconfirmacao;
	
	@Column(length=20,nullable=true)
	private String linha1;
	
	@Column(length=20,nullable=true)
	private String linha2;

	@Column(length=20,nullable=true)
	private String linha3;

	@Column(length=20,nullable=true)
	private String fioceleiro;
	
	@Column(length=20,nullable=true)
	private String fivela;
	
	@Column(length=20,nullable=true)
	private String rebite;
	
	@Column(length=20,nullable=true)
	private String ilhos;
	
	@Column(length=20,nullable=true)
	private String ornamento;
	
	@Column(length=20,nullable=true)
	private String bielastico;
	
	@Column(length=20,nullable=true)
	private String elastico;
	
	@Column(length=20,nullable=true)
	private String zipper;
	
	@Column(length=20,nullable=true)
	private String descricao1;

	@Column(length=20,nullable=true)
	private String descricao2;
	
	@Column(length=20,nullable=true)
	private String descricao3;
	
	@Column(length=20,nullable=true)
	private String borda;
	
	@Column(length=20,nullable=true)
	private String complemento;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Cor Confirmacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns(value={@JoinColumn(name="confirmacaoid_fk",referencedColumnName="confcor_pk",nullable=false)},foreignKey=@ForeignKey(name="corcos_conf_fk"))
	private CorConfirmacao corconfirmacao;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmacaoid == null) ? 0 : confirmacaoid.hashCode());
		result = prime * result + ((sequenciacorconfirmacao == null) ? 0 : sequenciacorconfirmacao.hashCode());
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
		CorCosturaCf other = (CorCosturaCf) obj;
		if (confirmacaoid == null) {
			if (other.confirmacaoid != null)
				return false;
		} else if (!confirmacaoid.equals(other.confirmacaoid))
			return false;
		if (sequenciacorconfirmacao == null) {
			if (other.sequenciacorconfirmacao != null)
				return false;
		} else if (!sequenciacorconfirmacao.equals(other.sequenciacorconfirmacao))
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
