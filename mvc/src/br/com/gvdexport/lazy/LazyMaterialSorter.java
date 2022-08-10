package br.com.gvdexport.lazy;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import br.com.gvdexport.model.Material;
import br.com.gvdexport.util.ShowcaseUtil;

public class LazyMaterialSorter implements Comparator<Material> {

	   private String sortField;
	   private SortOrder sortOrder;

	    public LazyMaterialSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	    @SuppressWarnings("unchecked")
		@Override
	    public int compare(Material material1, Material material2) {
	        try {
	        Object value1 = ShowcaseUtil.getPropertyValueViaReflection(material1,sortField);
	        Object value2 = ShowcaseUtil.getPropertyValueViaReflection(material2, sortField);
	        @SuppressWarnings("rawtypes")
			int value = ((Comparable) value1).compareTo(value2);	
	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
