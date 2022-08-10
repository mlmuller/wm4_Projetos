package br.com.gvdexport.model;

import java.io.Serializable;

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
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AcabamentoConfirmacao",uniqueConstraints= {@UniqueConstraint(columnNames={"confirmacaoid"},name="conf_acab_uk")})

@Getter @Setter
public class AcabamentoConfirmacao implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "confacabSeq")
	@SequenceGenerator(name = "confacabSeq", sequenceName = "s_confacab", allocationSize = 1)
	@Column(name="confacab_pk",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long confirmacaoid;
	
	@Column(length=17,nullable=true)
	private String atacador;
	
	@Column(length=10,nullable=true)
	private String atacadortipo;
	
	@Column(length=5,nullable=true)
	private String atacadorfornecedor;

	@Column(length=60,nullable=true)
	private String complemento;

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
	private String descrica31;

	@Column(length=60,nullable=true)
	private String corpo;

	@Column(length=60,nullable=true)
	private String gola;
	
	@Column(length=60,nullable=true)
	private String punho;

	@Column(length=60,nullable=true)
	private String perna;

	@Column(length=60,nullable=true)
	private String fechamento;

	@Column(length=60,nullable=true)
	private String cadarcoamarracao;

	@Column(length=60,nullable=true)
	private String cadarcoajuste;
	
	@Column(length=60,nullable=true)
	private String puxador1;

	@Column(length=60,nullable=true)
	private String puxador2;

	@Column(length=60,nullable=true)
	private String zippercursor1;
	
	@Column(length=60,nullable=true)
	private String zippercursor2;

	@Column(length=60,nullable=true)
	private String vivo1;

	@Column(length=60,nullable=true)
	private String vivo2;
	
	@Column(length=60,nullable=true)
	private String costura1;

	@Column(length=60,nullable=true)
	private String costura2;

	@Column(length=60,nullable=true)
	private String costura3;

	@Column(length=60,nullable=true)
	private String estampa1;

	@Column(length=60,nullable=true)
	private String estampa2;

	@Column(length=60,nullable=true)
	private String estampa3;
	
	@Column(length=60,nullable=true)
	private String etiquetacnpj;

	@Column(length=60,nullable=true)
	private String etiquetatamanho;
	
	@Column(length=60,nullable=true)
	private String etiquetalavagem;
	
	@Column(length=60,nullable=true)
	private String etiquetadecorativa;
	
	@Column(length=60,nullable=true)
	private String linhabranco1;

	@Column(length=60,nullable=true)
	private String linhabranco2;

	@Column(length=60,nullable=true)
	private String linhabranco3;

	//Confirmacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="coco_conf_fk",referencedColumnName="confirmacao_pk",nullable=false,foreignKey=@ForeignKey(name="acab_corcon_fk"))
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
		AcabamentoConfirmacao other = (AcabamentoConfirmacao) obj;
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
