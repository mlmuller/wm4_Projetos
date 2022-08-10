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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;


//D-efinicao G-eral A-plicacoes
@Entity
@Table(name="DGAPrivilegio",indexes= {@Index(columnList="dgapri_dgamod_fk",name="dgapri_dgamod_ifk",unique=false)
									 ,@Index(columnList="dgapri_usu_fk",name="dgapri_usu_ifk",unique=false)})
@NamedQueries({@NamedQuery(name="buscaChaveComposta",query="SELECT p FROM DGAPrivilegio p WHERE "
														  +"p.dgausuarioid = :primeiroId AND "
														  +"p.dgamoduloid  = :segundoId")})


//@IdClass(DGAPrivilegioId.class)
@Getter @Setter
public class DGAPrivilegio implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "privilegioSeq")
	@SequenceGenerator(name = "privilegioSeq", sequenceName = "s_privilegio", allocationSize = 1)
	@Column(name="privilegio_pk",updatable=false,nullable=false)
	private Long privilegioid;

	@Column(precision=10,nullable=false)
	private Long dgausuarioid;
	@Column(precision=10,nullable=false)
	private Long dgamoduloid;

	@Column(columnDefinition="boolean default true",nullable=true)
	private Boolean privinsert;
	
	@Column(columnDefinition="boolean default true",nullable=true)
	private Boolean privupdate;
	
	@Column(columnDefinition="boolean default true",nullable=true)
	private Boolean privdelete;

	@Column(columnDefinition="boolean default true",nullable=true)
	private Boolean privselect;
	
	@Column(length=200,nullable=true)
	private String privwhere;
	
	@Column(length=3,nullable=true)
	private Integer ordem;
	
	@Column(length=25,nullable=true)
	private String nomesistema;

	@Column(length=25,nullable=true)
	private String nomemenu;

	@Column(length=25,nullable=true)
	private String nomeModulo;
	
	@Column(length=35,nullable=true)
	private String caminho;
	//Define = 1, como qualquer tipo de permissao
	@Column(length=1,nullable=true,columnDefinition="smallint")
	private Integer permissao;

	@Column(length = 10, nullable = false)
	private String usuariostamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date datastamp;

	@Column(length=1,nullable=true)
	private String grpcomponente;
	//Chaves Estrangeiras
	//Usuario
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dgapri_usu_fk",referencedColumnName="usuario_pk",nullable=true,foreignKey=@ForeignKey(name="dgapri_usu_fk"))
	private Usuario usuario;

	//Modulos
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dgapri_dgamod_fk",referencedColumnName="dgamodulo_pk",nullable=true,foreignKey=@ForeignKey(name="dgapri_dgamod_fk"))
	private DGAModulo dgamodulo;

	//Sistemas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dgapri_dgasis_fk",referencedColumnName="dgasistema_pk",nullable=true,foreignKey=@ForeignKey(name="dgapri_dgasis_fk"))
	private DGASistema dgasistema;

	//Menus
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dgapri_dgamen_fk",referencedColumnName="dgamenu_pk",nullable=true,foreignKey=@ForeignKey(name="dgapri_dgamen_fk"))
	private DGAMenu dgamenu;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dgamoduloid == null) ? 0 : dgamoduloid.hashCode());
		result = prime * result + ((dgausuarioid == null) ? 0 : dgausuarioid.hashCode());
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
		DGAPrivilegio other = (DGAPrivilegio) obj;
		if (dgamoduloid == null) {
			if (other.dgamoduloid != null)
				return false;
		} else if (!dgamoduloid.equals(other.dgamoduloid))
			return false;
		if (dgausuarioid == null) {
			if (other.dgausuarioid != null)
				return false;
		} else if (!dgausuarioid.equals(other.dgausuarioid))
			return false;
		return true;
	}


}
