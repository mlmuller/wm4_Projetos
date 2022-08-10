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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Transportador",uniqueConstraints= {@UniqueConstraint(columnNames="nome",name="tran_nome_uk")
                                                 ,@UniqueConstraint(columnNames="sucinto",name="tran_suci_uk")}
)
@Getter @Setter
@EqualsAndHashCode

public class Transportador implements Serializable,Cloneable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "transportadoraSeq")
	@SequenceGenerator(name = "transportadoraSeq", sequenceName = "s_transportadora", allocationSize = 1)
	@Column(name="trans_pk",updatable=false,nullable=false)
	private Long transportadoraid;

	@Column(length = 40, nullable = false)
	private String nome;
	
	@Column(length = 20, nullable = false)
	private String sucinto;
	
	@Column(length = 40, nullable = true)
	private String endereco;
	//anteriomente esta como variavel cidade para receber o nome..foi criado objeto cidade
	@Column(length = 20, nullable = true)
	private String nomecidade;
	
	@Column(length = 2, nullable = true)
	private String uf;
	
	@Column(length = 9, nullable = true)
	private String cep;
	
	@Column(length = 22, nullable = true)
	private String cgc;

	@Column(length = 20, nullable = true)
	private String inscrest;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trans_cida_fk", referencedColumnName = "cida_pk", nullable = true, foreignKey=@ForeignKey(name="trans_cida_fk"))
	private Cidade cidade;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getTransportadoraid());
	}
	@Override
	public Object clone() throws CloneNotSupportedException  {
		return super.clone();
	}
	
}
