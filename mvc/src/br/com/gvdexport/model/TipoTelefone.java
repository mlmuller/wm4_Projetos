package br.com.gvdexport.model;

public enum TipoTelefone {
	  F("Fixo"),
	  C("Celular");
	    private String label;
	    
	    private TipoTelefone(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
