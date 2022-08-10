package br.com.gvdexport.model;

public enum Idioma {
	  pt("Portugues"), // Ativo
	  en("Ingles"); // Inativo
	    
	    private String label;
	    
	    private Idioma(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
