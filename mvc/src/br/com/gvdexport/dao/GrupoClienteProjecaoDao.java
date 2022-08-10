package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.ClienteProjecao;


@RequestScoped
public class GrupoClienteProjecaoDao extends CrudDao<ClienteProjecao, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
