package br.com.gvdexport.lazy;

import java.util.Comparator;

import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import br.com.gvdexport.model.Construcao;

public class LazyConstrucaoSorter implements Comparator<Construcao> {

	@Inject
	private br.com.gvdexport.util.ShowcaseUtil showCaseUtil;

	   private String sortField;
	    private SortOrder sortOrder;

	    public LazyConstrucaoSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	    @Override
	    public int compare(Construcao construcao1, Construcao construcao2) {
	        try {
	        	Object value1 = showCaseUtil.getPropertyValueViaReflection(construcao1, sortField);
	           	Object value2 = showCaseUtil.getPropertyValueViaReflection(construcao2, sortField);
	       	        	
	            int value = ((Comparable) value1).compareTo(value2);

	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
