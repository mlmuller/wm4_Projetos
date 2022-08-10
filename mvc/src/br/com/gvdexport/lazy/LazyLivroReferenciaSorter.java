package br.com.gvdexport.lazy;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.util.ShowcaseUtil;

public class LazyLivroReferenciaSorter implements Comparator<LivroReferencia> {

	   private String sortField;
	   private SortOrder sortOrder;

	    public LazyLivroReferenciaSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	    @SuppressWarnings("unchecked")
		@Override
	    public int compare(LivroReferencia livroReferencia1, LivroReferencia livroReferencia2) {
	        try {
	        Object value1 = ShowcaseUtil.getPropertyValueViaReflection(livroReferencia1,sortField);
	        Object value2 = ShowcaseUtil.getPropertyValueViaReflection(livroReferencia2, sortField);
	        @SuppressWarnings("rawtypes")
			int value = ((Comparable) value1).compareTo(value2);	
	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
