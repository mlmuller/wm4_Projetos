package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.CorAmostraMulti;

@RequestScoped
public class CorAmostraMultiDao extends CrudDao<CorAmostraMulti, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
