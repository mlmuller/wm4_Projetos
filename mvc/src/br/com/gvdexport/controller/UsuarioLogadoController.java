package br.com.gvdexport.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.gvdexport.model.Usuario;

@Named
@SessionScoped
public class UsuarioLogadoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuariologado;

	public Usuario getUsuariologado() {
		return usuariologado;
	}

	public void setUsuariologado(Usuario usuariologado) {
		this.usuariologado = usuariologado;
	}



}
