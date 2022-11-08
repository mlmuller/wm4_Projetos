package br.com.gvdexport.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class LogAmostraFichaProducao implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logAmostraSeq")
	@SequenceGenerator(name = "logAmostraSeq", sequenceName = "s_logAmostra", allocationSize = 1)
	@Column(name="logamos_pk",updatable=false,nullable=false)
	private Long logamostraFichaProducaoId;

	@Column(length=60)
	private String descricaocampo;
	
	@Column(length=200)
	private String valoranterior;
	
	@Column(nullable = false)
	private byte[] ip;
	
	@Column(length = 25, nullable = false)
	private String ipmask;
	
	@Column(length = 15,nullable =  true)
	private String horario;
	
	@Column(length = 25,nullable = false)
	private String nomedesktop;
	
	@Column(length = 10, nullable = false)
	private String usuarioStamp;
	
	@Column(nullable = false)
	private LocalDateTime dataStamp;
	
	// Amostras Novas
	@ManyToOne(optional = false)
	@JoinColumn(name = "amostra",foreignKey = @ForeignKey(name = "lgam_amos_fk"))
	private Amostra amostra;

	@Override
	public String toString() {
		return "LogAmostrasNovas [logamostraId=" + logamostraFichaProducaoId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(logamostraFichaProducaoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogAmostraFichaProducao other = (LogAmostraFichaProducao) obj;
		return Objects.equals(logamostraFichaProducaoId, other.logamostraFichaProducaoId);
	}

	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

}
