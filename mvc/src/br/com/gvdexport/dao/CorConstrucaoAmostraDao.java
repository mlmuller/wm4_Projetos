package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.CorConstrucaoAm;

@RequestScoped
public class CorConstrucaoAmostraDao extends CrudDao<CorConstrucaoAm, Long> implements Serializable {

	private static final long serialVersionUID = 1L;

}
