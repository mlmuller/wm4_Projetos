package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.RazaoAlteracao;

@RequestScoped
public class RazaoAlteracaoDao extends CrudDao<RazaoAlteracao, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
