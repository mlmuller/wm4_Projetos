package br.com.gvdexport.lazy;

import java.util.Comparator;

import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import br.com.gvdexport.model.FichaProducao;

public class LazyAmostraProducaoSorter implements Comparator<FichaProducao> {

	@Inject
	private br.com.gvdexport.util.ShowcaseUtil showCaseUtil;

	   private String sortField;
	    private SortOrder sortOrder;

	    public LazyAmostraProducaoSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	    @Override
	    public int compare(FichaProducao amostraProducao1, FichaProducao amostraProducao2) {
	        try {
	        	Object value1 = showCaseUtil.getPropertyValueViaReflection(amostraProducao1, sortField);
	           	Object value2 = showCaseUtil.getPropertyValueViaReflection(amostraProducao2, sortField);
	       	        	
	            int value = ((Comparable) value1).compareTo(value2);

	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
