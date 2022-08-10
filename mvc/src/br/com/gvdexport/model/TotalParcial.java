package br.com.gvdexport.model;

public enum TotalParcial {
	 T("Total"),
	  P("Parcial");
	
	    private String label;
	    
	    private TotalParcial(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
