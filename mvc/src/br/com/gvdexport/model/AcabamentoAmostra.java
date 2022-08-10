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
@Table(name="AcabamentoAmostra",uniqueConstraints= {@UniqueConstraint(columnNames={"amostra"},name="UK_Acabamento_Amostra")})

@Getter @Setter
public class AcabamentoAmostra implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "amostraacabSeq")
	@SequenceGenerator(name = "amostraacabSeq", sequenceName = "s_amostraacab", allocationSize = 1)
	@Column(name="idacabamentoamostra",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long amostraid;

	@Column(length=17,nullable=true)
	private String atacador;

	@Column(length=10,nullable=true)
	private String atacadortipo;
	
	@Column(length=10,nullable=true)
	private String atacadorforn;
	
	@Column(length=5,nullable=true)
	private String atacadorcompr;

	@Column(length=60,nullable=true)
	private String complemento;
	
	@Column(length=60,nullable=true)
	private String observacao;
	
	@Column(length=48,nullable=true)
	private String descricao1;
	
	@Column(length=48,nullable=true)
	private String descricao2;

	@Column(length=48,nullable=true)
	private String descricao3;

	@Column(length=20,nullable=true)
	private String labeldescricao1;

	@Column(length=20,nullable=true)
	private String labeldescricao2;

	@Column(length=20,nullable=true)
	private String labeldescricao3;

	@Column(length=20,nullable=true)
	private String acablabeldescricao3;
	
	@Column(length=60,nullable=true)
	private String corpo;

	@Column(length=60,nullable=true)
	private String gola;
	
	@Column(length=60,nullable=true)
	private String punho;

	@Column(length=60,nullable=true)
	private String perna;

	@Column(length=60,nullable=true)
	private String barra;

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
	private String vivo1;

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
	
	@Column(length=180,nullable=true)
	private String linha_branco1;

	@Column(length=180,nullable=true)
	private String linha_branco2;
	
	@Column(length=180,nullable=true)
	private String linha_branco3;

	@Column(length=60,nullable=true)
	private String vivo_2;

	@Column(length=60,nullable=true)
	private String zippercursor2;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Column(nullable = false)
	private LocalDateTime dataStamp;

	@ManyToOne(optional = false)
	@JoinColumn(name="amostra",referencedColumnName="amos_pk",nullable=false,foreignKey=@ForeignKey(name="FK_acabamento_Amostra"))
	private Amostra amostra;


	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getId());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amostra == null) ? 0 : amostra.hashCode());
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
		AcabamentoAmostra other = (AcabamentoAmostra) obj;
		if (amostra == null) {
			if (other.amostra != null)
				return false;
		} else if (!amostra.equals(other.amostra))
			return false;
		return true;
	}

	
}
