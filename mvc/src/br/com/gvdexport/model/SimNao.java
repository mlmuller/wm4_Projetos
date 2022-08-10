package br.com.gvdexport.model;

public enum SimNao {
	  S("Sim"),
	  N("Nao");
	    private String label;
	    
	    private SimNao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
