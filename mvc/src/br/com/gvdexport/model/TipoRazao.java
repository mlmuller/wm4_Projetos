package br.com.gvdexport.model;

public enum TipoRazao {
	C("Acrescimo"),
	R("Redução");
		    
	    private String label;
	    
	    private TipoRazao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }


}
