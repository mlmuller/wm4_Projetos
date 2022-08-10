package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.Sequencial;

@RequestScoped
public class SequencialDao extends CrudDao<Sequencial, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
