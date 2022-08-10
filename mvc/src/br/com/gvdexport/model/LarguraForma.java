package br.com.gvdexport.model;

public enum LarguraForma {
	  W("Width"),
	  M("Medium("),
	  N("Narrow");
	    private String label;
	    
	    private LarguraForma(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
