package br.com.gvdexport.model;

public enum Local {
	  Dentro("D"),
	  Fora("F");
	    private String label;
	    
	    private Local(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
