package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Banco",uniqueConstraints=@UniqueConstraint(columnNames= {"sucinto"},name="banc_sucinto_uk"))
@Getter @Setter
@EqualsAndHashCode

public class Banco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "bancoSeq")
	@SequenceGenerator(name = "bancoSeq", sequenceName = "s_banco", allocationSize = 1)
	@Column(name="banc_pk",updatable=false,nullable = false)
	private Long bancoid;

	@Column(length=40,nullable = false)
	private String nome;
	
	@Column(length=25, nullable=false)
	private String sucinto;
	
	@Enumerated(EnumType.STRING) //(N acional,I nteracional)
	@Column(length=1, nullable = false)
	private TipoBanco tipobanco;
	
	@Enumerated(EnumType.STRING) //(A tivo,I nativo)
	@Column(length=1, nullable = false)
	private Situacao situacao;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=30, nullable = true)
	private String agencia;
	
	@Column(length=40, nullable = true)
	private String endereco;
	
	@Column(length=20, nullable = true)
	private String telefone;
	
	@Column(length=40, nullable = true)
	private String email;
	
	@Column(length=20, nullable = true)
	private String fax;
	
	@Column(length=20, nullable = true)
	private String cgc;

	@Column(length=300, nullable = true)
	private String enderecocomplementar;
	
	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getBancoid());
	}

		
}
