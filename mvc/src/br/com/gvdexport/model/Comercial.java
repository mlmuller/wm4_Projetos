package br.com.gvdexport.model;

public enum Comercial {
	  s("*"),
	  n("n");
	    private String label;
	    private Comercial(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }


}
