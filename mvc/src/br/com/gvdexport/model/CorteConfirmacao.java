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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CorteConfirmacao",uniqueConstraints={@UniqueConstraint(columnNames={"confirmacaoid"},name="conf_corte_uk")})
@Getter @Setter
public class CorteConfirmacao implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "confcorteSeq")
	@SequenceGenerator(name = "confcorteSeq", sequenceName = "s_confcorte", allocationSize = 1)
	@Column(name="confcorte_pk",updatable=false,nullable=false)
	private Long id;

	@Column(updatable=false,nullable=false)
	private Long confirmacaoid;
	
	@Column(length=28,nullable=true)
	private String forrogaspea;
	
	@Column(length=10,nullable=true)
	private String forrogaspeafornecedor;
	
	@Column(length=10,nullable=true)
	private String forrogaspeacompl;

	@Column(length=28,nullable=true)
	private String forrotraseiro;

	@Column(length=10,nullable=true)
	private String forrotraseiroref;
	
	@Column(length=10,nullable=true)
	private String forrotraseiroforn;

	@Column(length=45,nullable=true)
	private String forrotraseirocompl;

	@Column(length=28,nullable=true)
	private String dublagemforro;

	@Column(length=10,nullable=true)
	private String dublagemforroref;
	
	@Column(length=10,nullable=true)
	private String dublagemforroforn;

	@Column(length=45,nullable=true)
	private String carimboetiqueta;

	@Column(length=28,nullable=true)
	private String palmilhainterna;

	@Column(length=10,nullable=true)
	private String palmilhainternaref;

	@Column(length=10,nullable=true)
	private String palmilhainternaforn;

	@Column(length=45,nullable=true)
	private String palmilhacompl;

	@Column(length=17,nullable=true)
	private String espuma;

	@Column(length=10,nullable=true)
	private String espumatipo;


	@Column(length=10,nullable=true)
	private String espumaespes;
	
	@Column(length=10,nullable=true)
	private String espumaforn;
	
	@Column(length=5,nullable=true)
	private String espumadensidade;

	@Column(length=38,nullable=true)
	private String debrumplamilha;

	@Column(length=10,nullable=true)
	private String debrumpalmilhatipo;

	@Column(length=28,nullable=true)
	private String avesso;

	@Column(length=10,nullable=true)
	private String avessotipo;
	
	@Column(length=10,nullable=true)
	private String avessoref;
	
	@Column(length=10,nullable=true)
	private String avessoforn;
	
	@Column(length=28,nullable=true)
	private String contraforte;


	@Column(length=10,nullable=true)
	private String contraforteref;

	@Column(length=10,nullable=true)
	private String contraforteforn;

	@Column(length=28,nullable=true)
	private String contraforte2;


	@Column(length=10,nullable=true)
	private String contraforte2ref;

	@Column(length=10,nullable=true)
	private String contraforte2forn;

	
	@Column(length=18,nullable=true)
	private String couraca;

	@Column(length=10,nullable=true)
	private String couracatipo;

	@Column(length=10,nullable=true)
	private String couracaref;

	@Column(length=10,nullable=true)
	private String couracaoforn;

	@Column(length=18,nullable=true)
	private String couraca2;

	@Column(length=10,nullable=true)
	private String couraca2tipo;

	@Column(length=10,nullable=true)
	private String couraca2ref;

	@Column(length=10,nullable=true)
	private String couracao2forn;
		
	@Column(length=60,nullable=true)
	private String complcorte;

	@Column(length=60,nullable=true)
	private String observacao;

	@Column(length=45,nullable=true)
	private String dublagema;

	@Column(length=45,nullable=true)
	private String dublagemb;

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
	private String descricao3;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Confirmacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cort_conf_fk",referencedColumnName="confirmacao_pk",nullable=false,foreignKey=@ForeignKey(name="cort_conf_fk"))
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
		CorteConfirmacao other = (CorteConfirmacao) obj;
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
