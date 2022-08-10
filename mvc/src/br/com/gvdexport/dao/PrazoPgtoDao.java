package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.PrazoPagamento;

@RequestScoped
public class PrazoPgtoDao extends CrudDao<PrazoPagamento, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
