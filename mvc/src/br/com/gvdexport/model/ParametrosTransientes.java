package br.com.gvdexport.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity(name="Parametros")
@Getter @Setter
public class ParametrosTransientes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idparametro;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean btnsalva;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean inpdataliberacao;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean btnsalvamais;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean btnedita;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean btndeleta;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean btnrefaz;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean btnvisao;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean btncheck;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean btnlimpa1;

	@Transient
	@Column(length = 1, nullable = false)
	private Boolean btnlimpa2 = true;
	
	@Transient
	@Column(length = 1, nullable = false)
	private Boolean btnlimpa3 = true;
	
	@Transient
	@Column(length = 1, nullable = false)
	private Boolean btnlimpa4 = true;

	@Transient
	@Column(length = 1, nullable = false)
	private Boolean btnlimpa5 = true;

	@Transient
	@Column(length = 1, nullable = false)
	private Boolean btnlimpa6 = true;
	
	@Transient
	@Column(length = 1, nullable = false)
	private Boolean btnnovo;

	@Transient
	@Column(length = 1, nullable = false)
	private Boolean btnfecha;

	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean abacor = false;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean abacorte;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean abacostura;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean abasolado;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean abaacabamento;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean fechaTransicao;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean allTransicao;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean saveTransicao;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean temLog;

	@Transient
	@Column(length = 20 , nullable = true)
	private String logModulo;
	/*
	 * Estas variavies serao usadas em todos os modulos, para ser ou nao reenderizado nas telas
	 * de inclusao, estas estao relacionadas as cores de acabamento (Corte,Costura,Solado,Acabamento)
	 * de todos os modulos(Amostras,Atelier,tecnico,comercial
	 */
	//Primeira Cor
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean pricor;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean segcor;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean tercor;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean quacor;

	//Segunda cor
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean pricorb;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean segcorb;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean tercorb;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean quacorb;

	//Terceira Cor
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean pricorc;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean segcorc;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean tercorc;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean quacorc;

	//Quarta Cor
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean pricord;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean segcord;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean tercord;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean quacord;
	
	/*
	 * ----------------------------------------------------------------------------------------------
	 */
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean construcao;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean referencia;
	
	@Transient
	@Column(length = 1 , nullable = true)
	private Boolean prioridade;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean botao1 = true;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean botao2 = false;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean botao3 = false;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean botao4 = false;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean botao5 = false;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean botao6 = false;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean habilita1 = false;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean habilita2 = false;
	
	@Transient
	@Column(length = 1, nullable = true)
	private Boolean habilita3 = false;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean habilita4 = false;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean habilita5 = false;

	@Transient
	@Column(length = 1, nullable = true)
	private Boolean habilita6 = false;

}
