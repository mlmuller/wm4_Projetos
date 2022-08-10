package br.com.gvdexport.model;

import java.io.Serializable;

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

import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name="DGAUsuarioNivel", indexes = {@Index(columnList="dganivel_dgamod_fk",name="dganivel_dgamod_ifk",unique=false)
,@Index(columnList="dganivel_usu_fk",name="dganivel_usu_ifk",unique=false)})


@Getter @Setter
public class DGAUsuarioNivel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuarionivelSeq")
	@SequenceGenerator(name = "usuarionivelSeq", sequenceName = "s_usuarionivel", allocationSize = 1)
	@Column(name="usuarionivel_pk",updatable=false,nullable=false)
	private Long usuarionivelid;

	@Column(precision=10,nullable=false)
	private Long dgausuarioid;
	@Column(precision=10,nullable=false)
	private Long dgamoduloid;
	
	@Column(length=25,nullable=true)
	private String nivelbarra;

	@Column(length=3,nullable=true)
	private Integer ordembarra;

	@Column(length=3,nullable=true)
	private Integer ordemmenu;
	
	@Column(length=25,nullable=true)
	private String nivelsubmenu;
	
	@Column(length=25,nullable=true)
	private String nivelsubitem;
	
	@Column(length=3,nullable=true)
	private Integer ordemitem;

	//Se usuario for incluir/aterar = 1 , se usuario alterar/cancelar=2, se consultar=3 (ver pelas permissoes)
	@Column(length=2,nullable=true)
	private Integer nivelgrupo;
	
	@Column(length=30,nullable=true)
	private String iconesistema;

	@Column(length=75,nullable=true)
	private String url;
	
	@Column(length=15,nullable=true)
	private String stylemenu;
	
	@Column(columnDefinition="boolean default true",nullable=true)
	private Boolean privinsert;
	
	@Column(columnDefinition="boolean default true",nullable=true)
	private Boolean privupdate;
	
	@Column(columnDefinition="boolean default true",nullable=true)
	private Boolean privdelete;

	@Column(columnDefinition="boolean default true",nullable=true)
	private Boolean privselect;

	@Column(length=1,nullable=true)
	private String grpcomponente;
	
	//Chaves Estrangeiras
	//Usuario
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dganivel_usu_fk",referencedColumnName="usuario_pk",nullable=false,foreignKey=@ForeignKey(name="dganivel_usu_fk"))
	private Usuario usuario;

	//Sistemas
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dganivel_dgasis_fk",referencedColumnName="dgasistema_pk",nullable=true,foreignKey=@ForeignKey(name="dganivel_dgasis_fk"))
	private DGASistema dgasistema;

	//Menus
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dganivel_dgamen_fk",referencedColumnName="dgamenu_pk",nullable=true,foreignKey=@ForeignKey(name="dganivel_dgamen_fk"))
	private DGAMenu dgamenu;

	//Modulos
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dganivel_dgamod_fk",referencedColumnName="dgamodulo_pk",nullable=false,foreignKey=@ForeignKey(name="dganivel_dgamod_fk"))
	private DGAModulo dgamodulo;


	
}
