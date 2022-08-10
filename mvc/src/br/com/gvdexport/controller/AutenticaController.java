package br.com.gvdexport.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class AutenticaController implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private String Nome;
	@Getter @Setter
	private String Senha;

	
	

}
