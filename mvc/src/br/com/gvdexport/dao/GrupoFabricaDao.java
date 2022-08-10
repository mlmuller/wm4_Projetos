package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.GrupoFabrica;

@RequestScoped
public class GrupoFabricaDao extends CrudDao<GrupoFabrica, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
