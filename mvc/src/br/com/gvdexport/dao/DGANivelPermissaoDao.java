package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.DGAUsuarioNivel;
@RequestScoped
public class DGANivelPermissaoDao extends CrudDao<DGAUsuarioNivel, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
