package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.DGAMenu;

@RequestScoped
public class DGAMenuDao extends CrudDao<DGAMenu, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


}