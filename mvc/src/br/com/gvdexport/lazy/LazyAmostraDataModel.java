package br.com.gvdexport.lazy;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.faces.context.FacesContext;

import org.apache.commons.collections4.ComparatorUtils;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.filter.FilterConstraint;
import org.primefaces.util.LocaleUtils;

import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.util.ShowcaseUtil;

public class LazyAmostraDataModel extends LazyDataModel<Amostra> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Amostra> datasource;

    public LazyAmostraDataModel(List<Amostra> datasource) {
    	this.datasource = datasource;
    }
 
    @Override
    public Amostra getRowData(String rowKey) {
        for (Amostra amostra : datasource) {
            if (amostra.getAmostraId() == Integer.parseInt(rowKey)) {
                return amostra;
            }
        }

        return null;
    }

    @Override
    public String getRowKey(Amostra amostra) {
        return String.valueOf(amostra.getAmostraId());
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return (int) datasource.stream()
                .filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
                .count();
    }

    @Override
    public List<Amostra> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        // apply offset & filters
        List<Amostra> amostra = datasource.stream()
                .skip(offset)
                .filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
                .limit(pageSize)
                .collect(Collectors.toList());
        
        // sort
        if (!sortBy.isEmpty()) {
            List<Comparator<Amostra>> comparators = sortBy.values().stream()
                    .map(o -> new LazyAmostraSorter(o.getField(), o.getOrder()))
                    .collect(Collectors.toList());
            Comparator<Amostra> cp = ComparatorUtils.chainedComparator(comparators); // from apache
            amostra.sort(cp);
        }
        return amostra;
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
