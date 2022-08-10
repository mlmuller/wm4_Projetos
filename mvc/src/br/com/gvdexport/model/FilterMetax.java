package br.com.gvdexport.model;

import java.io.Serializable;
import java.util.Objects;

import javax.el.ELContext;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.DynamicColumn;
import org.primefaces.component.api.UIColumn;
import org.primefaces.component.column.ColumnBase;
import org.primefaces.component.datatable.feature.FilterFeature;
import org.primefaces.model.MatchMode;
import org.primefaces.model.filter.FilterConstraint;
import org.primefaces.model.filter.FunctionFilterConstraint;
import org.primefaces.model.filter.GlobalFilterConstraint;

public class FilterMetax implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String GLOBAL_FILTER_KEY = "globalFilter";

	    private String field;
	    private String columnKey;
	    private ValueExpression filterBy;
	    private Object filterValue;
	    private MatchMode matchMode = MatchMode.CONTAINS;
	    private FilterConstraint constraint;

	    public FilterMetax() {
	        // NOOP
	    }

	    FilterMetax(String columnKey, String field, FilterConstraint constraint,
	               ValueExpression filterBy, Object filterValue, MatchMode matchMode) {
	        this.field = field;
	        this.columnKey = columnKey;
	        this.filterBy = filterBy;
	        this.constraint = constraint;
	        this.filterValue = filterValue;
	        this.matchMode = matchMode;
	    }

	    /**
	     * @deprecated Use FilterMeta#builder() instead
	     */
	    @Deprecated
	    public FilterMetax(String field, String columnKey, ValueExpression filterByVE, MatchMode filterMatchMode, Object filterValue) {
	        this.field = field;
	        this.columnKey = columnKey;
	        this.filterBy = filterByVE;
	        this.constraint = FilterFeature.FILTER_CONSTRAINTS.get(filterMatchMode);
	        this.filterValue = filterValue;
	        this.matchMode = filterMatchMode;
	    }

	    public static FilterMetax of(FacesContext context, String var, UIColumn column) {
	        if (column instanceof DynamicColumn) {
	            ((DynamicColumn) column).applyStatelessModel();
	        }

	        if (!column.isFilterable()) {
	            return null;
	        }

	        String field = column.getField();
	        ValueExpression filterByVE = column.getValueExpression(ColumnBase.PropertyKeys.filterBy.name());
	        if (field == null && filterByVE == null) {
	            return null;
	        }

	        if (field == null) {
	            field = column.resolveField(context, filterByVE);
	        }
	        else if (filterByVE == null) {
	            filterByVE = UIColumn.createValueExpressionFromField(context, var, field);
	        }

	        MatchMode matchMode = MatchMode.of(column.getFilterMatchMode());
	        FilterConstraint constraint = FilterFeature.FILTER_CONSTRAINTS.get(matchMode);

	        if (column.getFilterFunction() != null) {
	            constraint = new FunctionFilterConstraint(column.getFilterFunction());
	        }

	        return new FilterMetax(column.getColumnKey(),
	                              field,
	                              constraint,
	                              filterByVE,
	                              column.getFilterValue(),
	                              matchMode);
	    }

	    public static FilterMetax of(Object globalFilterValue, MethodExpression globalFilterFunction) {
	        FilterConstraint constraint = globalFilterFunction == null
	                ? new GlobalFilterConstraint()
	                : new FunctionFilterConstraint(globalFilterFunction);

	        return new FilterMetax(GLOBAL_FILTER_KEY,
	                              GLOBAL_FILTER_KEY,
	                              constraint,
	                              null,
	                              globalFilterValue,
	                              MatchMode.GLOBAL);
	    }

	    public String getField() {
	        return field;
	    }

	    public String getColumnKey() {
	        return columnKey;
	    }

	    public ValueExpression getFilterBy() {
	        return filterBy;
	    }

	    public void setFilterBy(ValueExpression filterBy) {
	        this.filterBy = filterBy;
	    }

	    public Object getFilterValue() {
	        return filterValue;
	    }

	    public void setFilterValue(Object filterValue) {
	        this.filterValue = filterValue;
	    }

	    public FilterConstraint getConstraint() {
	        return constraint;
	    }

	    public void setConstraint(FilterConstraint constraint) {
	        this.constraint = constraint;
	    }

	    public boolean isActive() {
	        return filterValue != null;
	    }

	    public MatchMode getMatchMode() {
	        return matchMode;
	    }

	    public void setMatchMode(MatchMode matchMode) {
	        this.matchMode = matchMode;
	    }

	    public boolean isGlobalFilter() {
	        return GLOBAL_FILTER_KEY.equals(columnKey);
	    }

	    public Object getLocalValue(ELContext elContext, UIColumn column) {
	        if (column instanceof DynamicColumn) {
	            ((DynamicColumn) column).applyStatelessModel();
	        }
	        return filterBy.getValue(elContext);
	    }

	    public static Builder builder() {
	        return new Builder();
	    }

	    public static final class Builder {

	        private final FilterMetax filterBy;

	        private Builder() {
	            filterBy = new FilterMetax();
	        }

	        public Builder field(String field) {
	            filterBy.field = field;
	            return this;
	        }

	        public Builder filterBy(ValueExpression filterBy) {
	            this.filterBy.filterBy = filterBy;
	            return this;
	        }

	        public Builder filterValue(Object filterValue) {
	            filterBy.filterValue = filterValue;
	            return this;
	        }

	        public Builder constraint(FilterConstraint constraint) {
	            filterBy.constraint = constraint;
	            return this;
	        }

	        public Builder matchMode(MatchMode matchMode) {
	            filterBy.matchMode = matchMode;
	            return this;
	        }

	        public FilterMetax build() {
	            if (filterBy.matchMode != null) {
	                filterBy.constraint = FilterFeature.FILTER_CONSTRAINTS.get(filterBy.matchMode);
	            }
	            Objects.requireNonNull(filterBy.constraint, "Filter constraint is required");
	            Objects.requireNonNull(filterBy.field, "Field is required");
	            return filterBy;
	        }
	    }

	    @Override
	    public String toString() {
	        return "FilterMeta{" +
	                "field='" + field + '\'' +
	                ", columnKey='" + columnKey + '\'' +
	                ", filterBy=" + filterBy +
	                ", filterValue=" + filterValue +
	                ", matchMode=" + matchMode +
	                ", constraint=" + constraint +
	                '}';
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        FilterMetax that = (FilterMetax) o;
	        return Objects.equals(field, that.field) &&
	                Objects.equals(columnKey, that.columnKey);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(field, columnKey);
	    }
}
