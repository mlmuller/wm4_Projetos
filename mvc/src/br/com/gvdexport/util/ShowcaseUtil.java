package br.com.gvdexport.util;

import java.beans.PropertyDescriptor;

import javax.management.IntrospectionException;

public class ShowcaseUtil {
	  private ShowcaseUtil() {

	    }

	    public static final Object getPropertyValueViaReflection(Object o, String field)
	                throws ReflectiveOperationException, IllegalArgumentException, IntrospectionException, java.beans.IntrospectionException {
	        return new PropertyDescriptor(field, o.getClass()).getReadMethod().invoke(o);
	    }


}
