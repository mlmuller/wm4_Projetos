package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.Usuario;

@RequestScoped
public class UsuarioDao extends CrudDao<Usuario, Long> implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
}
