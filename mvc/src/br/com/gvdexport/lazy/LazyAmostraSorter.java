package br.com.gvdexport.lazy;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.util.ShowcaseUtil;

public class LazyAmostraSorter implements Comparator<Amostra> {

	   private String sortField;
	   private SortOrder sortOrder;

	    public LazyAmostraSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	    @SuppressWarnings("unchecked")
		@Override
	    public int compare(Amostra amostra1, Amostra amostra2) {
	        try {
	        Object value1 = ShowcaseUtil.getPropertyValueViaReflection(amostra1,sortField);
	        Object value2 = ShowcaseUtil.getPropertyValueViaReflection(amostra2,sortField);
	        @SuppressWarnings("rawtypes")
			int value = ((Comparable) value1).compareTo(value2);	
	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
