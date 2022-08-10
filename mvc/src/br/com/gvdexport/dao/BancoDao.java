package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.Banco;

@RequestScoped
public class BancoDao extends CrudDao<Banco, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
