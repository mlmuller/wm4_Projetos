package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.CosturaAmostra;

@RequestScoped
public class CosturaAmostraDao extends CrudDao<CosturaAmostra, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;   

}
