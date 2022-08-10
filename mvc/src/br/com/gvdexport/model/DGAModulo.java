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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="DGAModulo",uniqueConstraints= {@UniqueConstraint(columnNames= {"dgamod_dgamen_fk","nome"},name="dgamod_dgamen_uk"),
											@UniqueConstraint(columnNames= {"dgamodulo_pk","ordem"},name="dgamod_ordem_uk")}
								   ,indexes=@Index(columnList="dgamod_dgamen_fk",name="dgamod_dgamen_ifk",unique=false))
@Getter @Setter
@EqualsAndHashCode

public class DGAModulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "dgamoduloSeq")
	@SequenceGenerator(name = "dgamoduloSeq", sequenceName = "s_dgamodulo", allocationSize = 1)
	@Column(name="dgamodulo_pk",updatable=false,nullable=false)
	private Long dgamoduloid;
	
	@Column(length=40,nullable=false)
	private String nome;
	
	@Column(length=40,nullable=false)
	private String classe;

	@Column(length=75,nullable=false)
	private String url;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private SimNao monousuario;
	
	@Column(length=3,nullable=false)
	private Integer ordem;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Situacao situacao;
	
	@Column(length=40,nullable=true)
	private String hint;
	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=1,nullable=true)
	private String grpcomponente;
	//Chave Estrangeira
	//Menus
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dgamod_dgamen_fk",referencedColumnName="dgamenu_pk",nullable=false,foreignKey=@ForeignKey(name="dgamod_dgamen_fk"))
	private DGAMenu dgamenu;
	
	//
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dgamod_dgaimp_fk",referencedColumnName="dgaimpressora_pk",nullable=true,foreignKey=@ForeignKey(name="dgamod_dgaimp_fk"))
	private DGAImpressora dgaimpressora;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getDgamoduloid());
	}
}
