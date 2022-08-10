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
@Table(name="CorCosturaAmostra",uniqueConstraints={@UniqueConstraint(columnNames={"amostra","coramostra"},name="UK_CorCostura_CorAmostra")})
@Getter @Setter
public class CorCosturaAm implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "amoscorcostSeq")
	@SequenceGenerator(name = "amoscorcostSeq", sequenceName = "s_amoscorcost", allocationSize = 1)
	@Column(name="idcorcosturaamostra",updatable=false,nullable=false)
	private Long id;

	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacoramostra;
	
	@Column(length=20,nullable=true)
	private String linha1;

	@Column(length=20,nullable=true)
	private String linha2;
	
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
	private String bileastico;
	
	@Column(length=20,nullable=true)
	private String elastico;
	
	@Column(length=20,nullable=true)
	private String zipper;
	
	@Column(length=20,nullable=true)
	private String linha3;
	
	@Column(length=20,nullable=true)
	private String velcro;
	
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
	
	@Column(nullable = false)
	private LocalDateTime datastamp;


	@ManyToOne(optional = false)
	@JoinColumn(name="coramostra",referencedColumnName="amosCor_Pk",foreignKey=@ForeignKey(name="FK_CorCostura_CorAmostra"))
	private CorAmostra coramostra;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="amostra",referencedColumnName="amos_pk",foreignKey=@ForeignKey(name="FK_Costura_Amostra"))
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
		result = prime * result + ((coramostra == null) ? 0 : coramostra.hashCode());
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
		CorCosturaAm other = (CorCosturaAm) obj;
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
