package br.com.gvdexport.lazy;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.management.IntrospectionException;

import org.apache.commons.collections4.ComparatorUtils;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.filter.FilterConstraint;
import org.primefaces.util.LocaleUtils;

import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.util.ShowcaseUtil;

public class LazyLivroReferenciaDataModel extends LazyDataModel<LivroReferencia> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<LivroReferencia> datasource;

    public LazyLivroReferenciaDataModel(List<LivroReferencia> datasource) {
    	this.datasource = datasource;
    }
 
    @Override
    public LivroReferencia getRowData(String rowKey) {
        for (LivroReferencia livroReferencia : datasource) {
            if (livroReferencia.getLivroreferenciaid() == Integer.parseInt(rowKey)) {
                return livroReferencia;
            }
        }

        return null;
    }

    @Override
    public String getRowKey(LivroReferencia livroReferencia) {
        return String.valueOf(livroReferencia.getLivroreferenciaid());
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return (int) datasource.stream()
                .filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
                .count();
    }

    @Override
    public List<LivroReferencia> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        // apply offset & filters
        List<LivroReferencia> livroReferencia = datasource.stream()
                .skip(offset)
                .filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
                .limit(pageSize)
                .collect(Collectors.toList());
        
        // sort
        if (!sortBy.isEmpty()) {
            List<Comparator<LivroReferencia>> comparators = sortBy.values().stream()
                    .map(o -> new LazyLivroReferenciaSorter(o.getField(), o.getOrder()))
                    .collect(Collectors.toList());
            Comparator<LivroReferencia> cp = ComparatorUtils.chainedComparator(comparators); // from apache
            livroReferencia.sort(cp);
        }
        return livroReferencia;
    }

    private boolean filter(FacesContext context, Collection<FilterMeta> filterBy, Object o) {
        boolean matching = true;

        for (FilterMeta filter : filterBy) {
            FilterConstraint constraint = filter.getConstraint();
            	Object filterValue = filter.getFilterValue();
            	Object columnValue;
            	try {
                	columnValue = String.valueOf(ShowcaseUtil.getPropertyValueViaReflection(o, filter.getField()));
                	matching = constraint.isMatching(context, columnValue, filterValue, LocaleUtils.getCurrentLocale());
				} catch (Exception e) {
					matching = false;
				}

            if (!matching) {
                break;
            }
        }

        return matching;
    }

}
