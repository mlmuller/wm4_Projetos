package br.com.gvdexport.model;

public enum TipoBanco {
	  N("Nacional"), // Dentro Brasil
	  E("Estrangeiro"); // Fora Brasil
	    
	    private String label;
	    
	    private TipoBanco(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
