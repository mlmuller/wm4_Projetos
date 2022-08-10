package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.Etiquetas;

@RequestScoped
public class EtiquetasDao extends CrudDao<Etiquetas, Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
