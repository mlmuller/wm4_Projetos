package br.com.gvdexport.model;

public enum TipoVia {
	  A("Aéreo"),
	  M("Marítimo"),
	  R("Rodoviário"),
	  F("Ferroviário");
	  
	    private String label;
	    
	    private TipoVia(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
