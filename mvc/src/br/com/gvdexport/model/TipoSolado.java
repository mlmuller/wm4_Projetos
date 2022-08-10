package br.com.gvdexport.model;

public enum TipoSolado {
	  L("Leather"),
	  S("Synthetic");
	
	    private String label;
	    
	    private TipoSolado(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
