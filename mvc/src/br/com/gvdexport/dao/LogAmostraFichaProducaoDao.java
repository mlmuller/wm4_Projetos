package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.LogAmostrasNovas;

@RequestScoped
public class LogAmostraFichaProducaoDao extends CrudDao<LogAmostrasNovas, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
