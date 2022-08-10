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

import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.Cor;
import br.com.gvdexport.util.ShowcaseUtil;

public class LazyCoresAmostraModel extends LazyDataModel<Cor> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ShowcaseUtil showCaseUtil;
	
	private List<Cor> datasource;

    public LazyCoresAmostraModel(List<Cor> datasource) {
    	this.datasource = datasource;
    }
 
    @Override
    public Cor getRowData(String rowKey) {
        for (Cor cor : datasource) {
            if (cor.getCorid() == Integer.parseInt(rowKey)) {
                return cor;
            }
        }

        return null;
    }

    @Override
    public String getRowKey(Cor cor) {
        return String.valueOf(cor.getCorid());
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return (int) datasource.stream()
                .filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
                .count();
    }

    @Override
    public List<Cor> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        // apply offset & filters
        List<Cor> cor = datasource.stream()
                .skip(offset)
                .filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
                .limit(pageSize)
                .collect(Collectors.toList());
        
        // sort
        if (!sortBy.isEmpty()) {
            List<Comparator<Cor>> comparators = sortBy.values().stream()
                    .map(o -> new LazyCoresAmostraSorter(o.getField(), o.getOrder()))
                    .collect(Collectors.toList());
            Comparator<Cor> cp = ComparatorUtils.chainedComparator(comparators); // from apache
            cor.sort(cp);
        }
        return cor;
    }

    private boolean filter(FacesContext context, Collection<FilterMeta> filterBy, Object o) {
        boolean matching = true;

        for (FilterMeta filter : filterBy) {
            FilterConstraint constraint = filter.getConstraint();
            Object filterValue = filter.getFilterValue();

            try {
            	Object columnValue = String.valueOf(showCaseUtil.getPropertyValueViaReflection(o, filter.getField()));
                matching = constraint.isMatching(context, columnValue, filterValue, LocaleUtils.getCurrentLocale());
            }
            catch (ReflectiveOperationException | IntrospectionException e) {
                matching = false;
            } catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (java.beans.IntrospectionException e) {
				e.printStackTrace();
			}

            if (!matching) {
                break;
            }
        }

        return matching;
    }

}
