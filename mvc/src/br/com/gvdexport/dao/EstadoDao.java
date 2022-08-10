package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.Estado;

@RequestScoped
public class EstadoDao extends CrudDao<Estado, Long>  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
