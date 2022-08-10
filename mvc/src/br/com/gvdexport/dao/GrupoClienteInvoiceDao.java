package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.GrupoClienteInvoice;

@RequestScoped
public class GrupoClienteInvoiceDao extends CrudDao<GrupoClienteInvoice, Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
