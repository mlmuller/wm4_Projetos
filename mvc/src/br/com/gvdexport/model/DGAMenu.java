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
@Table(name="DGAMenu",uniqueConstraints= {@UniqueConstraint(columnNames= {"dgamenu_pk","ordem"},name="dgamen_ordem_uk")
										 ,@UniqueConstraint(columnNames= {"dgamen_dgasis_fk","nome"},name="dgamen_dgasis_ordem_iuk")}
										 ,indexes=@Index(columnList="dgamen_dgasis_fk",name="dgamen_dgasis_ifk",unique=false))
@Getter @Setter
@EqualsAndHashCode
public class DGAMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "dgamenuSeq")
	@SequenceGenerator(name = "dgamenuSeq", sequenceName = "s_dgamenu", allocationSize = 1)
	@Column(name="dgamenu_pk",updatable=false,nullable=false)
	private Long dgamenuid;
	
	@Column(length=30,nullable=false)
	private String nome;
	
	@Column(length=30,nullable=true)
	private String barramenu;
	
	@Column(length=3,nullable=false)
	private Integer ordem;

	@Column(length=60,nullable=true)
	private String hint;
	
	@Column(length=15,nullable=true)
	private String stylemenu;

	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	//Chave Estrangeira
	//Sistema
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dgamen_dgasis_fk",referencedColumnName="dgasistema_pk",nullable=false,foreignKey=@ForeignKey(name="dgamen_dgasis_fk"))
	private DGASistema dgasistema;


	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getDgamenuid());
	}
}
