package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.DGAModulo;

@RequestScoped
public class DGAModuloDao extends CrudDao<DGAModulo, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
