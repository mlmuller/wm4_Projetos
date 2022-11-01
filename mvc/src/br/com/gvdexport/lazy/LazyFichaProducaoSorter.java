package br.com.gvdexport.lazy;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.util.ShowcaseUtil;

public class LazyFichaProducaoSorter implements Comparator<FichaProducao> {

	   private String sortField;
	   private SortOrder sortOrder;

	    public LazyFichaProducaoSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	    @SuppressWarnings("unchecked")
		@Override
	    public int compare(FichaProducao producao1, FichaProducao producao2) {
	        try {
	        Object value1 = ShowcaseUtil.getPropertyValueViaReflection(producao1,sortField);
	        Object value2 = ShowcaseUtil.getPropertyValueViaReflection(producao2,sortField);
	        @SuppressWarnings("rawtypes")
			int value = ((Comparable) value1).compareTo(value2);	
	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
