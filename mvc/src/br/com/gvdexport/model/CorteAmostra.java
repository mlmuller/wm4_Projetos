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
@Table(name="CorteAmostra",uniqueConstraints={@UniqueConstraint(columnNames={"amostra"},name="UK_Corte_Amostra")})
public class CorteAmostra implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "amoscorteSeq")
	@SequenceGenerator(name = "amoscorteSeq", sequenceName = "s_amoscorte", allocationSize = 1)
	@Column(name="idcorteamostra",updatable=false,nullable=false)
	private Long id;

	@Getter @Setter
	@Column(updatable=false,nullable=false)
	private Long amostraid;
	@Getter @Setter		
	@Column(length=28, nullable=true)
	private String forrogaspea;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String forrogaspeareferencia;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String forrogaspeafornecedor;
	@Getter @Setter
	@Column(length=45, nullable=true)
	private String forrogaspeacomplemento;
	@Getter @Setter
	@Column(length=28, nullable=true)
	private String forrotraseiro;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String forrotraseiroreferencia;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String forrotraseirofornecedor;
	@Getter @Setter
	@Column(length=45, nullable=true)
	private String forrotraseirocomplemento;
	@Getter @Setter
	@Column(length=28, nullable=true)
	private String dublagemforro;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String dublagemforroreferencia;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String dublagemforrofornecedor;
	@Getter @Setter
	@Column(length=45, nullable=true)
	private String carimboetiqueta;
	@Getter @Setter
	@Column(length=28, nullable=true)
	private String palmilhainterna;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String palmilhainternareferencia;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String palmilhainternafornecedor;
	@Getter @Setter
	@Column(length=45, nullable=true)
	private String palmilhainternacomplemento;
	@Getter @Setter
	@Column(length=17, nullable=true)
	private String espuma;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String espumatipo;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String espumaespessura;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String espumafornecedor;
	@Getter @Setter
	@Column(length=5, nullable=true)
	private String espumadensidade;
	@Getter @Setter
	@Column(length=38, nullable=true)
	private String debrumpalmilha;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String debrumpalmilhatipo;
	@Getter @Setter
	@Column(length=28, nullable=true)
	private String avesso;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String avessotipo;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String avessoreferencia;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String avessofornecedor;
	@Getter @Setter
	@Column(length=28, nullable=true)
	private String contraforte;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String contrafortereferencia;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String contrafortefornecedor;
	@Getter @Setter
	@Column(length=18, nullable=true)
	private String couraca;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String couracatipo;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String couracareferencia;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String couracafornecedor ;
	@Getter @Setter
	@Column(length=60, nullable=true)
	private String complementocorte;
	@Getter @Setter
	@Column(length=45, nullable=true)
	private String dublagema;
	@Getter @Setter
	@Column(length=45, nullable=true)
	private String dublagemb;
	@Getter @Setter
	@Column(length=60, nullable=true)
	private String observacao;
	@Getter @Setter
	@Column(length=48, nullable=true)
	private String descricao1;
	@Getter @Setter
	@Column(length=48, nullable=true)
	private String descricao2;
	@Getter @Setter
	@Column(length=48, nullable=true)
	private String descricao3;
	@Getter @Setter
	@Column(length=20, nullable=true)
	private String labeldescricao1;
	@Getter @Setter
	@Column(length=20, nullable=true)
	private String labeldescricao2;
	@Getter @Setter
	@Column(length=20, nullable=true)
	private String labeldescricao3;
	@Getter @Setter
	@Column(length=28, nullable=true)
	private String contraforte2;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String contraforte2referencia;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String contraforte2fornecedor;
	@Getter @Setter
	@Column(length=18, nullable=true)
	private String couraca2;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String couraca2tipo;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String couraca2referencia;
	@Getter @Setter
	@Column(length=10, nullable=true)
	private String couraca2fornecedor;
	@Getter @Setter
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	@Getter @Setter
	@Column(nullable = false)
	private LocalDateTime dataStamp;
	@Getter @Setter
	@ManyToOne(optional = false)
	@JoinColumn(name="amostra",referencedColumnName="amos_pk",nullable=false,foreignKey=@ForeignKey(name="FK_Corte_Amostra"))
	private Amostra amostra;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getAmostraid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amostraid == null) ? 0 : amostraid.hashCode());
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
		CorteAmostra other = (CorteAmostra) obj;
		if (amostraid == null) {
			if (other.amostraid != null)
				return false;
		} else if (!amostraid.equals(other.amostraid))
			return false;
		return true;
	}


}
