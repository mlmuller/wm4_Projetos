package br.com.gvdexport.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmpresaLogo.class)
public abstract class EmpresaLogo_ {

	public static volatile SingularAttribute<EmpresaLogo, byte[]> foto;
	public static volatile SingularAttribute<EmpresaLogo, Long> empresalogoid;
	public static volatile SingularAttribute<EmpresaLogo, Empresa> empresa;

	public static final String FOTO = "foto";
	public static final String EMPRESALOGOID = "empresalogoid";
	public static final String EMPRESA = "empresa";

}

