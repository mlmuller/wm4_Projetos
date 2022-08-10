package br.com.gvdexport.model;

public enum Tipo {
	  A("Amostra"),
	  C("Catalogo"),
	  M("Maquete");
	    private String label;
	    
	    private Tipo(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
