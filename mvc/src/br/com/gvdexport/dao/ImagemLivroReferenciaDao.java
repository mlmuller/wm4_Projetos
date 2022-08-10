package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.ImagemReferencia;

@RequestScoped
public class ImagemLivroReferenciaDao extends CrudDao<ImagemReferencia, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
