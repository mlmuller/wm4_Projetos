package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.Cor;

@RequestScoped
public class CorDao extends CrudDao<Cor, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -146258698445889943L;

}
