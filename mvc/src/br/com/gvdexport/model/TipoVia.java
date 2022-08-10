package br.com.gvdexport.model;

public enum TipoVia {
	  A("A�reo"),
	  M("Mar�timo"),
	  R("Rodovi�rio"),
	  F("Ferrovi�rio");
	  
	    private String label;
	    
	    private TipoVia(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
