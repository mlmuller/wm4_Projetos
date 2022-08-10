package br.com.gvdexport.model;

public enum Situacao {
	  A("Ativo"), // Ativo
	  I("Inativo"); // Inativo
	    
	    private String label;
	    
	    private Situacao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
