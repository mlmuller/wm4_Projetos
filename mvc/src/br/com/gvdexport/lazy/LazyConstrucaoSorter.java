package br.com.gvdexport.lazy;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import br.com.gvdexport.model.Construcao;
import br.com.gvdexport.util.ShowcaseUtil;

public class LazyConstrucaoSorter implements Comparator<Construcao> {

	   private String sortField;
	   private SortOrder sortOrder;

	    public LazyConstrucaoSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	    @SuppressWarnings("unchecked")
		@Override
	    public int compare(Construcao construcao1, Construcao construcao2) {
	        try {
	        Object value1 = ShowcaseUtil.getPropertyValueViaReflection(construcao1,sortField);
	        Object value2 = ShowcaseUtil.getPropertyValueViaReflection(construcao2,sortField);
	        @SuppressWarnings("rawtypes")
			int value = ((Comparable) value1).compareTo(value2);	
	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
