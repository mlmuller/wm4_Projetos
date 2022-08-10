package br.com.gvdexport.model;

public enum TipoDistribuicao {
	  M("Musical"), 
	  S("Solida"); 
	    
	    private String label;
	    
	    private TipoDistribuicao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
