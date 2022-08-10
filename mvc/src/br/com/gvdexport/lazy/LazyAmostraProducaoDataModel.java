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

import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.util.ShowcaseUtil;

public class LazyAmostraProducaoDataModel extends LazyDataModel<FichaProducao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ShowcaseUtil showCaseUtil;
	
	private List<FichaProducao> datasource;

    public LazyAmostraProducaoDataModel(List<FichaProducao> datasource) {
    	this.datasource = datasource;
    }
 
    @Override
    public FichaProducao getRowData(String rowKey) {
        for (FichaProducao fichaProducao : datasource) {
            if (fichaProducao.getFichaproducaoid() == Integer.parseInt(rowKey)) {
                return fichaProducao;
            }
        }

        return null;
    }

    @Override
    public String getRowKey(FichaProducao fichaProducao) {
        return String.valueOf(fichaProducao.getFichaproducaoid());
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return (int) datasource.stream()
                .filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
                .count();
    }

    @Override
    public List<FichaProducao> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        // apply offset & filters
        List<FichaProducao> amostraProducao = datasource.stream()
                .skip(offset)
                .filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
                .limit(pageSize)
                .collect(Collectors.toList());
        
        // sort
        if (!sortBy.isEmpty()) {
            List<Comparator<FichaProducao>> comparators = sortBy.values().stream()
                    .map(o -> new LazyAmostraProducaoSorter(o.getField(), o.getOrder()))
                    .collect(Collectors.toList());
            Comparator<FichaProducao> cp = ComparatorUtils.chainedComparator(comparators); // from apache
            amostraProducao.sort(cp);
        }
        return amostraProducao;
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
