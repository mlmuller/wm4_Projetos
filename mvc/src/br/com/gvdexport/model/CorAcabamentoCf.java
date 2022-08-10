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
@Table(name="CorAcabamentoCf",uniqueConstraints= {@UniqueConstraint(columnNames={"confirmacaoid","sequenciacorconfirmacao"},name="conf_coracab_uk")})
@Getter @Setter
public class CorAcabamentoCf implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "vonfcoracabSeq")
	@SequenceGenerator(name = "confcoracabSeq", sequenceName = "s_confcoracab", allocationSize = 1)
	@Column(name="confcoracab_pk",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long confirmacaoid;
	
	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacorconfirmacao;
	
	
	@Column(length=20,nullable=true)
	private String atacador;

	@Column(length=20,nullable=true)
	private String descricao1;

	@Column(length=20,nullable=true)
	private String descricao2;

	@Column(length=20,nullable=true)
	private String descricao3;
	
	@Column(length=20,nullable=true)
	private String complemento;
	
	@Column(length=20,nullable=true)
	private String corpo;
	
	@Column(length=20,nullable=true)
	private String gola;
	
	@Column(length=20,nullable=true)
	private String punho;
	
	@Column(length=20,nullable=true)
	private String barra;
	
	@Column(length=20,nullable=true)
	private String fechamento;
	
	@Column(length=20,nullable=true)
	private String cadarcoamarracao;
	
	@Column(length=20,nullable=true)
	private String cadarcoajuste;
	
	@Column(length=20,nullable=true)
	private String puxador1;
	
	@Column(length=20,nullable=true)
	private String puxador2;
	
	@Column(length=20,nullable=true)
	private String zippercursor1;
	
	@Column(length=20,nullable=true)
	private String zippercursor2;
	
	@Column(length=20,nullable=true)
	private String vivo1;
	
	@Column(length=20,nullable=true)
	private String vivo2;
	
	@Column(length=20,nullable=true)
	private String costura1;
	
	@Column(length=20,nullable=true)
	private String costura2;
	
	@Column(length=20,nullable=true)
	private String costura3;
	
	@Column(length=20,nullable=true)
	private String estampa1;
	
	@Column(length=20,nullable=true)
	private String estampa2;
	
	@Column(length=20,nullable=true)
	private String estampa3;
	
	@Column(length=20,nullable=true)
	private String etiquetancpj;
	
	@Column(length=20,nullable=true)
	private String etiquetatamanho;
	
	@Column(length=20,nullable=true)
	private String lavagem;
	
	@Column(length=20,nullable=true)
	private String etiquetadecorativa;
	
	@Column(length=20,nullable=true)
	private String linhabranco1;
	
	@Column(length=20,nullable=true)
	private String linhabranco2;
	
	@Column(length=20,nullable=true)
	private String linhabranco3;
	
	@Column(length=20,nullable=true)
	private String perna;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Cor Confirmacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns(value={@JoinColumn(name="confirmacaoid_fk",referencedColumnName="confcor_pk",nullable=false)},foreignKey=@ForeignKey(name="coac_conf_fk"))
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
		CorAcabamentoCf other = (CorAcabamentoCf) obj;
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
