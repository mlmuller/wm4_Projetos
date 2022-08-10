package br.com.gvdexport.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "etqdragdrop")
public class EtqDragDrop implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable=false,nullable=false)
	private Long idetqdragdrop; 
    //1
	@Column(nullable = true)
	private LocalDate etqdata;

	@Column(name ="etq",length = 2, nullable=true)
	private Integer etiq;
	@Column(name = "vazia1",length = 1 , nullable = true)
	private Character vazio1;
	@Column(name = "vazia2",length = 1 , nullable = true)
	private Character vazio2;
	@Column(name = "vazia3",length = 1 , nullable = true)
	private Character vazio3;
	@Column(name = "vazia4",length = 1 , nullable = true)
	private Character vazio4;
	@Column(name = "vazia5",length = 1 , nullable = true)
	private Character vazio5;
	@Column(name = "vazia6",length = 1 , nullable = true)
	private Character vazio6;
	@Column(name = "vazia7",length = 1 , nullable = true)
	private Character vazio7;
	@Column(name = "vazia8",length = 1 , nullable = true)
	private Character vazio8;
	
	@Column(name = "aprovacao", nullable = true)
	private LocalDate aprovacao;
	
	@Column(nullable=true)
	private Date inclusao;
	
	@Column(name="material",length=45, nullable = true)
	private String material;

	@Column(name="materiala",length=32, nullable = true)
	private String materiala;

	@Column(name="materialb",length=32, nullable = true)
	private String materialb;

	@Column(name = "espessura",length = 15, nullable = true)
	private String espessura;
	
	@Column(name = "cor", length = 35, nullable = true)
	private String cor;

	@Column(length = 28, nullable = true)
	private String cora;
	
	@Column(length = 25, nullable = true)
	private String codecustomer;
	@Column(length = 32 , nullable = true)
	private String stylename1;

	@Column(length = 32 , nullable = true)
	private String stylename2;
	
	@Column(name = "construcao", length = 15 , nullable = true)
	private String construcao;

	@Column(name = "forma", length = 12 , nullable = true)
	private String forma;

	@Column(name = "fase", length = 28 , nullable = true)
	private String fase;

	
	@Column(name = "referencia", length = 45 , nullable = true)
	private String referencia;
	
	@Column(name = "toque", length = 5 , nullable = true)
	private String toque;
	
	@Column(name = "obs_1",length = 45 , nullable = true )
	private String obs1;
	
	@Column(name = "fabricanome", length = 50, nullable = true)
	private String fabricanome;
	
	@Column(name = "clientenome",length = 30, nullable = true)
	private String clientenome;
	//2
	@Column(name = "etq_date1", nullable = true)
	private LocalDate etqdata1;

	@Column(name = "aprovacao1", nullable = true)
	private LocalDate aprovacao1;
	
	@Column(name="material1",length=45, nullable = true)
	private String material1;
	
	@Column(name = "espessura1",length = 15, nullable = true)
	private String espessura1;
	
	@Column(name = "cor1", length = 45, nullable = true)
	private String cor1;
	
	@Column(name = "referencia1", length = 45 , nullable = true)
	private String referencia1;
	
	@Column(name = "toque1", length = 5 , nullable = true)
	private String toque1;
	
	@Column(name = "obs_11",length = 45 , nullable = true )
	private String obs11;
	
	@Column(name = "fabricanome1", length = 50, nullable = true)
	private String fabricanome1;
	
	@Column(name = "clientenome1",length = 30, nullable = true)
	private String clientenome1;
    //3
	@Column(name = "etq_date2", nullable = true)
	private LocalDate etqdata2;

	@Column(name = "aprovacao2", nullable = true)
	private LocalDate aprovacao2;
	
	@Column(name="material2",length=45, nullable = true)
	private String material2;
	
	@Column(name = "espessura2",length = 15, nullable = true)
	private String espessura2;
	
	@Column(name = "cor2", length = 45, nullable = true)
	private String cor2;
	
	@Column(name = "referencia2", length = 45 , nullable = true)
	private String referencia2;
	
	@Column(name = "toque2", length = 5 , nullable = true)
	private String toque2;
	
	@Column(name = "obs_12",length = 45 , nullable = true )
	private String obs12;
	
	@Column(name = "fabricanome2", length = 50, nullable = true)
	private String fabricanome2;
	
	@Column(name = "clientenome2",length = 30, nullable = true)
	private String clientenome2;
    //4
	@Column(name = "etq_date3", nullable = true)
	private LocalDate etqdata3;

	@Column(name = "aprovacao3", nullable = true)
	private LocalDate aprovacao3;
	
	@Column(name="material3",length=45, nullable = true)
	private String material3;
	
	@Column(name = "espessura3",length = 15, nullable = true)
	private String espessura3;
	
	@Column(name = "cor3", length = 45, nullable = true)
	private String cor3;
	
	@Column(name = "referencia3", length = 45 , nullable = true)
	private String referencia3;
	
	@Column(name = "toque3", length = 5 , nullable = true)
	private String toque3;
	
	@Column(name = "obs_13",length = 45 , nullable = true )
	private String obs13;
	
	@Column(name = "fabricanome3", length = 50, nullable = true)
	private String fabricanome3;
	
	@Column(name = "clientenome3",length = 30, nullable = true)
	private String clientenome3;
	//5
	@Column(name = "etq_date4", nullable = true)
	private LocalDate etqdata4;

	@Column(name = "aprovacao4", nullable = true)
	private LocalDate aprovacao4;
	
	@Column(name="material4",length=45, nullable = true)
	private String material4;
	
	@Column(name = "espessura4",length = 15, nullable = true)
	private String espessura4;
	
	@Column(name = "cor4", length = 45, nullable = true)
	private String cor4;
	
	@Column(name = "referencia4", length = 45 , nullable = true)
	private String referencia4;
	
	@Column(name = "toque4", length = 5 , nullable = true)
	private String toque4;
	
	@Column(name = "obs_14",length = 45 , nullable = true )
	private String obs14;
	
	@Column(name = "fabricanome4", length = 50, nullable = true)
	private String fabricanome4;
	
	@Column(name = "clientenome4",length = 30, nullable = true)
	private String clientenome4;
    //6
	@Column(name = "etq_date5", nullable = true)
	private LocalDate etqdata5;

	@Column(name = "aprovacao5", nullable = true)
	private LocalDate aprovacao5;
	
	@Column(name="material5",length=45, nullable = true)
	private String material5;
	
	@Column(name = "espessura5",length = 15, nullable = true)
	private String espessura5;
	
	@Column(name = "cor5", length = 45, nullable = true)
	private String cor5;
	
	@Column(name = "referencia5", length = 45 , nullable = true)
	private String referencia5;
	
	@Column(name = "toque5", length = 5 , nullable = true)
	private String toque5;
	
	@Column(name = "obs_15",length = 45 , nullable = true )
	private String obs15;
	
	@Column(name = "fabricanome5", length = 50, nullable = true)
	private String fabricanome5;
	
	@Column(name = "clientenome5",length = 30, nullable = true)
	private String clientenome5;
    //7
	@Column(name = "etq_date6", nullable = true)
	private LocalDate etqdata6;

	@Column(name = "aprovacao6", nullable = true)
	private LocalDate aprovacao6;
	
	@Column(name="material6",length=45, nullable = true)
	private String material6;
	
	@Column(name = "espessura6",length = 15, nullable = true)
	private String espessura6;
	
	@Column(name = "cor6", length = 45, nullable = true)
	private String cor6;
	
	@Column(name = "referencia6", length = 45 , nullable = true)
	private String referencia6;
	
	@Column(name = "toque6", length = 5 , nullable = true)
	private String toque6;
	
	@Column(name = "obs_16",length = 45 , nullable = true )
	private String obs16;
	
	@Column(name = "fabricanome6", length = 50, nullable = true)
	private String fabricanome6;
	
	@Column(name = "clientenome6",length = 30, nullable = true)
	private String clientenome6;
    //8
	@Column(name = "etq_date7", nullable = true)
	private LocalDate etqdata7;

	@Column(name = "aprovacao7", nullable = true)
	private LocalDate aprovacao7;
	
	@Column(name="material7",length=45, nullable = true)
	private String material7;
	
	@Column(name = "espessura7",length = 15, nullable = true)
	private String espessura7;
	
	@Column(name = "cor7", length = 45, nullable = true)
	private String cor7;
	
	@Column(name = "referencia7", length = 45 , nullable = true)
	private String referencia7;
	
	@Column(name = "toque7", length = 5 , nullable = true)
	private String toque7;
	
	@Column(name = "obs_17",length = 45 , nullable = true )
	private String obs17;
	
	@Column(name = "fabricanome7", length = 50, nullable = true)
	private String fabricanome7;
	
	@Column(name = "clientenome7",length = 30, nullable = true)
	private String clientenome7;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "etiqueta",foreignKey=@ForeignKey(name="etiq_etiq_fk"))
	private Etiquetas etiqueta;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getIdetqdragdrop());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idetqdragdrop == null) ? 0 : idetqdragdrop.hashCode());
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
		EtqDragDrop other = (EtqDragDrop) obj;
		if (idetqdragdrop == null) {
			if (other.idetqdragdrop != null)
				return false;
		} else if (!idetqdragdrop.equals(other.idetqdragdrop))
			return false;
		return true;
	}

	


}
