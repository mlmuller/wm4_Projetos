package br.com.gvdexport.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemAvisoRetorno.class)
public abstract class ItemAvisoRetorno_ {

	public static volatile SingularAttribute<ItemAvisoRetorno, String> usuariostamp;
	public static volatile SingularAttribute<ItemAvisoRetorno, Long> avisoretornoid;
	public static volatile SingularAttribute<ItemAvisoRetorno, Integer> pares;
	public static volatile SingularAttribute<ItemAvisoRetorno, Integer> caixas;
	public static volatile SingularAttribute<ItemAvisoRetorno, String> paressolido;
	public static volatile SingularAttribute<ItemAvisoRetorno, Date> datastamp;
	public static volatile SingularAttribute<ItemAvisoRetorno, Long> itemavisoretornoid;
	public static volatile SingularAttribute<ItemAvisoRetorno, String> paresmusical;
	public static volatile SingularAttribute<ItemAvisoRetorno, ItemFaturaFabrica> itemfaturafabrica;

	public static final String USUARIOSTAMP = "usuariostamp";
	public static final String AVISORETORNOID = "avisoretornoid";
	public static final String PARES = "pares";
	public static final String CAIXAS = "caixas";
	public static final String PARESSOLIDO = "paressolido";
	public static final String DATASTAMP = "datastamp";
	public static final String ITEMAVISORETORNOID = "itemavisoretornoid";
	public static final String PARESMUSICAL = "paresmusical";
	public static final String ITEMFATURAFABRICA = "itemfaturafabrica";

}

