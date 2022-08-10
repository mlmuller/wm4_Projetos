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
@Table(name="ClienteMercado",uniqueConstraints= {@UniqueConstraint(columnNames= {"clme_clie_fk","mercado"},name="clme_clie_merc_uk")}
										,indexes=@Index(columnList="clme_clie_fk",name="clme_clie_ifk",unique=false))
@Getter @Setter
@EqualsAndHashCode
public class ClienteMercado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO ,generator = "clientemercadoseq")
	@SequenceGenerator(name= "clientemercadoseq",sequenceName = "s_clientemercado", allocationSize = 1)
	@Column(name="cliemerc_pk",updatable=false,nullable=false)
	private Long clientemercadoid;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Enumerated(EnumType.STRING)
	@Column(length=1,nullable=false)
	private Mercado mercado;
	
	//Objeto Personagem
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clme_clie_fk", referencedColumnName="clie_pk", nullable=false,foreignKey=@ForeignKey(name="clme_clie_fk"))
	private Cliente cliente;

	@Override
	public String toString(){
		return String.format("%s[id=%d]",getClass().getSimpleName(),getClientemercadoid());
	}
}
