package br.com.gvdexport.model;

public enum TipoNota {
	  E("Entrada"),
	  S("Saida");
	    private String label;
	    
	    private TipoNota(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
