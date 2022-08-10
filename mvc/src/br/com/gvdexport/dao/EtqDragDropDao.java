package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.EtqDragDrop;

@RequestScoped
public class EtqDragDropDao extends CrudDao<EtqDragDrop, Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
