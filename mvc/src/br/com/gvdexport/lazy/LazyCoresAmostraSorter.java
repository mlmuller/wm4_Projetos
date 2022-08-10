package br.com.gvdexport.lazy;

import java.util.Comparator;

import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import br.com.gvdexport.model.Cor;

public class LazyCoresAmostraSorter implements Comparator<Cor> {

	@Inject
	private br.com.gvdexport.util.ShowcaseUtil showCaseUtil;

	   private String sortField;
	    private SortOrder sortOrder;

	    public LazyCoresAmostraSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	    @Override
	    public int compare(Cor amostraCor1, Cor amostraCor2) {
	        try {
	        	Object value1 = showCaseUtil.getPropertyValueViaReflection(amostraCor1, sortField);
	           	Object value2 = showCaseUtil.getPropertyValueViaReflection(amostraCor2, sortField);
	       	        	
	            int value = ((Comparable) value1).compareTo(value2);

	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
