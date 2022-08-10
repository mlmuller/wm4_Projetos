package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AutorizacaoReimpressao",indexes= {@Index(columnList="aure_razimp_fk",name="aure_razalt_ifk",unique=false)
											 , @Index(columnList="autorizacaoreimpressaoid,sequencia",name="aure_autemb_i",unique=false)})
@Getter @Setter
@EqualsAndHashCode(of = { "autorizacaoreimpressaoid", "sequencia" })
@IdClass(AutorizacaoReimpressaoId.class)
public class AutorizacaoReimpressao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long autorizacaoreimpressaoid;
	
	@Id
	private Long sequencia;

	
	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;
	
	//Razao Alteracao
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="aure_razimp_fk",referencedColumnName="razaoimpressao_pk",nullable=true,foreignKey=@ForeignKey(name="aure_razimp_fk"))
	private RazaoImpressao razaoimpressao;

}
