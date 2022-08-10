package br.com.gvdexport.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.gvdexport.model.TipoCalcado;

@RequestScoped
public class TipoCalcadoDao extends CrudDao<TipoCalcado, Long>  implements Serializable{


	private static final long serialVersionUID = -1687883092879874999L;



}
