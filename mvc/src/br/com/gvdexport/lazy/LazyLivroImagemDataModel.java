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
import br.com.gvdexport.model.ImagemReferencia;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.util.ShowcaseUtil;

public class LazyLivroImagemDataModel extends LazyDataModel<ImagemReferencia> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ShowcaseUtil showCaseUtil;
	
	private List<ImagemReferencia> datasource;

    public LazyLivroImagemDataModel(List<ImagemReferencia> datasource) {
    	this.datasource = datasource;
    }
 
    @Override
    public ImagemReferencia getRowData(String rowKey) {
        for (ImagemReferencia livroImagem : datasource) {
            if (livroImagem.getImagemlivroreferenciaid() == Integer.parseInt(rowKey)) {
                return livroImagem;
            }
        }

        return null;
    }

    @Override
    public String getRowKey(ImagemReferencia livroImagem) {
        return String.valueOf(livroImagem.getImagemlivroreferenciaid());
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return (int) datasource.stream()
                .filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
                .count();
    }

    @Override
    public List<ImagemReferencia> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        // apply offset & filters
        List<ImagemReferencia> livroReferencia = datasource.stream()
                .skip(offset)
                .filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
                .limit(pageSize)
                .collect(Collectors.toList());
        
        // sort
        if (!sortBy.isEmpty()) {
            List<Comparator<ImagemReferencia>> comparators = sortBy.values().stream()
                    .map(o -> new LazyLivroImagemSorter(o.getField(), o.getOrder()))
                    .collect(Collectors.toList());
            Comparator<ImagemReferencia> cp = ComparatorUtils.chainedComparator(comparators); // from apache
            livroReferencia.sort(cp);
        }
        return livroReferencia;
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
