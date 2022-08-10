package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name="Modelo",uniqueConstraints= {@UniqueConstraint(columnNames={"mode_lire_fk","mode_clie_fk","mode_esta_fk","nome"},name = "mode_lire_clie_esta_uk")},
indexes= {@Index(columnList="nome",name="mode_nome_i",unique = false)
		 ,@Index(columnList="mode_clie_fk",name="mode_clie_ifk",unique=false)
		 ,@Index(columnList="mode_esta_fk",name="mode_esta_ifk",unique=false)
		 ,@Index(columnList="mode_lire_fk",name="mode_lire_ifk",unique=false)})


@Getter @Setter
public class Modelo implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "modeloSeq")
	@SequenceGenerator(name = "modeloSeq", sequenceName = "s_modelo", allocationSize = 1)
	@Column(name="modelo_pk",nullable=false)
	private Long modeloid;
	
	@Column(length=20,nullable=false)
	private String nome;

	@Column(length = 16,nullable = true)
	private String construcaonome;
	
	@Column(length = 2,nullable = true , columnDefinition = "smallint")
	private Integer versao;
	
	@Column(length = 6 ,nullable = true)
	private Integer referencia;
	
	@Column(length = 2,nullable = true,columnDefinition = "smallint")
	private Integer versaorefer;

	@Column(length = 10, nullable = true)
	private  String referenciaforma;

	@Column(length=4,nullable=true)
	private String nomeestacao;
	
	@Column(length=15,nullable=true)
	private String sucinto;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	 
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//LivrosReferencias
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mode_lire_fk",referencedColumnName="lire_pk",nullable=false,foreignKey=@ForeignKey(name="mode_lire_fk"))
	private LivroReferencia livroreferencia;
	
	//Clientes
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mode_clie_fk",referencedColumnName="clie_pk",nullable=false,foreignKey=@ForeignKey(name="mode_clie_fk"))
	private Cliente cliente;
	
	//Estacoes
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mode_esta_fk",referencedColumnName="esta_pk",nullable=false,foreignKey=@ForeignKey(name="mode_esta_fk"))
	private Estacao estacao;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modeloid == null) ? 0 : modeloid.hashCode());
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
		Modelo other = (Modelo) obj;
		if (modeloid == null) {
			if (other.modeloid != null)
				return false;
		} else if (!modeloid.equals(other.modeloid))
			return false;
		return true;
	}


	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getModeloid());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}



}
