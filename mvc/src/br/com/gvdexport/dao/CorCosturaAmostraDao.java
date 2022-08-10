package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.CorCosturaAm;

@RequestScoped
public class CorCosturaAmostraDao extends CrudDao<CorCosturaAm, Long> implements Serializable {

	private static final long serialVersionUID = 1L;

}
