package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DragDropDao extends CrudDao<EtqDragDropDao, Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
