package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="LivroReferencia",uniqueConstraints = {@UniqueConstraint(columnNames= {"construcao","referencia","versaorefer","abreviacao"},name="lire_ref_ver_abr_uk")},
indexes= {@Index(unique=false,name="lire_usuario_i",columnList="usuariostamp")
		 ,@Index(unique=false,name="lire_cons_ifk",columnList="construcao")})
public class LivroReferencia implements Serializable,Cloneable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO ,generator = "referenciaseq")
	@SequenceGenerator(name= "referenciaseq",sequenceName = "s_referencia", allocationSize = 1)
	@Column(name="lire_pk",updatable=false,nullable=false)
	private Long livroreferenciaid;

	@Column(length = 6 ,nullable = false)
	private Integer referencia;
	
	@Column(length = 2,nullable = false , columnDefinition = "smallint")
	private Integer versaorefer;

	
	@Column(length = 3, nullable = true)
	private String abreviacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	@Temporal(value = TemporalType.DATE)
	@Column(nullable = true)
	private Date dataokmodelo;
	
	@Column(length = 20 , nullable = true)
	private String referenciacliente;
	//provisorio para compor chave unica

	@Column(length = 16 , nullable = true)
	private String construcaonome;
	
	@Column(length = 10, nullable = true)
	private  String referenciaforma;
	
	@Column(length = 2,nullable = true,columnDefinition = "smallint")
	private Integer versao;

	//Objeto construcao
	@ManyToOne(optional = true)
	@JoinColumn(name = "construcao",foreignKey=@ForeignKey(name="lire_cons_fk"))
	private Construcao construcao;
	//Objeto Personagem
	@ManyToOne(optional = true)
	@JoinColumn(name = "lire_pers_fk", referencedColumnName = "pers_pk", nullable = true,foreignKey=@ForeignKey(name="lire_pers_fk"))
	private Personagem personagem;
	

	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livroreferenciaid == null) ? 0 : livroreferenciaid.hashCode());
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
		LivroReferencia other = (LivroReferencia) obj;
		if (livroreferenciaid == null) {
			if (other.livroreferenciaid != null)
				return false;
		} else if (!livroreferenciaid.equals(other.livroreferenciaid))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "LivroReferencia [livroreferenciaid=" + livroreferenciaid + "]";
	}

}
