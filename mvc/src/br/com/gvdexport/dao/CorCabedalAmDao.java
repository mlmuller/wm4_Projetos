package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.CorCabedalAm;

@RequestScoped
public class CorCabedalAmDao extends CrudDao<CorCabedalAm, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
