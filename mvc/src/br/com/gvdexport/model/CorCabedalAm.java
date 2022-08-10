package br.com.gvdexport.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CorCabedalAm",uniqueConstraints = {@UniqueConstraint(columnNames={"amostra","corAmostra","sequenciacoramostra"},name="amos_corcab_uk")}
,indexes= {@Index(unique=false,name="amos_corcab_i",columnList="amostra,coramostra,sequenciacoramostra")})



@Getter @Setter
public class CorCabedalAm implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amoscorcabSeq")
	@SequenceGenerator(name = "amoscorcabSeq", sequenceName = "s_amoscorcab", allocationSize = 1)
	@Column(name="amoscorcab_pk",updatable=false,nullable=false)
	private Long id;

	@Column(length = 2,nullable = false,columnDefinition = "smallint")
	private Integer sequenciacoramostra;

	
	@Column(length=270,nullable=true)
	private String texto;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Column(nullable = false)
	private LocalDateTime datastamp;

	// Amostras Novas
	@ManyToOne(optional = false)
	@JoinColumn(name = "amostra", foreignKey = @ForeignKey(name = "cabe_amos_fk"))
	private Amostra amostra;


	// Cor Amostras Novas 
	@ManyToOne(optional = false)
	@JoinColumn(name = "coramostra", foreignKey = @ForeignKey(name = "cabe_coam_fk"))
	private CorAmostra coramostra;
	
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
		result = prime * result + ((datastamp == null) ? 0 : datastamp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CorCabedalAm other = (CorCabedalAm) obj;
		if (datastamp == null) {
			if (other.datastamp != null)
				return false;
		} else if (!datastamp.equals(other.datastamp))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
