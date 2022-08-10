package br.com.gvdexport.model;

public enum BaseContrato {
	  E("Embarque"),
	  X("Xfactory");
	    private String label;
	    
	    private BaseContrato(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
