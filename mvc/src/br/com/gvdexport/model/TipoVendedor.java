package br.com.gvdexport.model;

public enum TipoVendedor {
	  A("A"),
	  R("R");
	    private String label;
	    
	    private TipoVendedor(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
