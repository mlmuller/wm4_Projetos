package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.EnderecoCliente;

@RequestScoped
public class EnderecoClienteDao extends CrudDao<EnderecoCliente, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
