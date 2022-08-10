package br.com.gvdexport.lazy;

import java.util.Comparator;

import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import br.com.gvdexport.model.ImagemReferencia;

public class LazyLivroImagemSorter implements Comparator<ImagemReferencia> {

	@Inject
	private br.com.gvdexport.util.ShowcaseUtil showCaseUtil;

	   private String sortField;
	    private SortOrder sortOrder;

	    public LazyLivroImagemSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	    @Override
	    public int compare(ImagemReferencia imagemReferencia1, ImagemReferencia imagemReferencia2) {
	        try {
	        	Object value1 = showCaseUtil.getPropertyValueViaReflection(imagemReferencia1, sortField);
	           	Object value2 = showCaseUtil.getPropertyValueViaReflection(imagemReferencia2, sortField);
	       	        	
	            int value = ((Comparable) value1).compareTo(value2);

	            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
	        }
	        catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
