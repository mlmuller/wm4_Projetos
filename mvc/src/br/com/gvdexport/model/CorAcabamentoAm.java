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
@Table(name="CorAcabamentoAm",uniqueConstraints= {@UniqueConstraint(columnNames={"amostra","coramostra"},name="UK_CorAcabamento_CorAmostra")})
@Getter @Setter
public class CorAcabamentoAm implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "amoscoracabSeq")
	@SequenceGenerator(name = "amoscoracabSeq", sequenceName = "s_amoscoracab", allocationSize = 1)
	@Column(name="amoscoracab_pk",updatable=false,nullable=false)
	private Long id;

	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacoramostra;
	
	@Column(length=20,nullable=true)
	private String atacador;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Column(nullable = false)
	private LocalDateTime dataStamp;

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
	private String perna;

	@Column(length=20,nullable=true)
	private String barra;
	
	@Column(length=20,nullable=true)
	private String fechamento;

	@Column(length=20,nullable=true)
	private String cadarcoamarracao;

	@Column(length=20,nullable=true)
	private String  cadarcoajuste;
	
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
	private String etiquetacnpj;

	@Column(length=20,nullable=true)
	private String etiquetatamanho;

	@Column(length=20,nullable=true)
	private String etiquetalavagem;

	@Column(length=20,nullable=true)
	private String etiquetadecorativa;

	@Column(length=20,nullable=true)
	private String linhabranco1;

	@Column(length=20,nullable=true)
	private String linhabranco2;

	@Column(length=20,nullable=true)
	private String linhabranco3;

	//Cor Amostra - chave composta
	@Getter @Setter
	@ManyToOne(optional = false)
	@JoinColumn(name="coramostra",referencedColumnName="amosCor_Pk",foreignKey=@ForeignKey(name="FK_CorAcabamento_CorAmostra"))
	private CorAmostra coramostra;

	@Getter @Setter
	@ManyToOne(optional = false)
	@JoinColumn(name="amostra",referencedColumnName="amos_pk",foreignKey=@ForeignKey(name="FK_CorAcabamento_Amostra"))
	private Amostra amostra;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amostra == null) ? 0 : amostra.hashCode());
		result = prime * result + ((coramostra == null) ? 0 : coramostra.hashCode());
		return result;
	}

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getId());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CorAcabamentoAm other = (CorAcabamentoAm) obj;
		if (amostra == null) {
			if (other.amostra != null)
				return false;
		} else if (!amostra.equals(other.amostra))
			return false;
		if (coramostra == null) {
			if (other.coramostra != null)
				return false;
		} else if (!coramostra.equals(other.coramostra))
			return false;
		return true;
	}

}
