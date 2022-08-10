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
@Table(name="CorConstrucaoCf",uniqueConstraints={@UniqueConstraint(columnNames={"confirmacaoid","sequenciacorconfirmacao"},name="conf_corcons_uk")})
@Getter @Setter
public class CorConstrucaoCf implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "confcorconsSeq")
	@SequenceGenerator(name = "confcorconsSeq", sequenceName = "s_confcorcons", allocationSize = 1)
	@Column(name="confcorcons_pk",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long confirmacaoid;

	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacorconfirmacao;
	
	@Column(length=20,nullable=true)
	private String solalaminada;
	
	@Column(length=20,nullable=true)
	private String solainjetada;
	
	@Column(length=20,nullable=true)
	private String entressola;
	
	@Column(length=20,nullable=true)
	private String vira1;

	@Column(length=20,nullable=true)
	private String vira2;

	@Column(length=20,nullable=true)
	private String tipobeira;
	
	@Column(length=20,nullable=true)
	private String salto;
	
	@Column(length=20,nullable=true)
	private String tacao;

	@Column(length=20,nullable=true)
	private String plataforma;
	
	@Column(length=20,nullable=true)
	private String carimbosola;
	
	@Column(length=20,nullable=true)
	private String descricao1;

	@Column(length=20,nullable=true)
	private String descricao2;

	@Column(length=20,nullable=true)
	private String descricao3;
	
	@Column(length=20,nullable=true)
	private String descricao4;
	
	@Column(length=20,nullable=true)
	private String palmilhamontagem;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Cor  Amostra
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns(value={@JoinColumn(name="confirmacaoid_fk",referencedColumnName="confcor_pk",nullable=false)},foreignKey=@ForeignKey(name="coco_conf_fk"))
	private CorConfirmacao corconfirmacao;


	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getConfirmacaoid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

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
		CorConstrucaoCf other = (CorConstrucaoCf) obj;
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

	
}
