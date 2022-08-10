package br.com.gvdexport.model;

public enum PagamentoDiferencaFrete {
	  A("Agente"),
	  C("Cliente"),
	  F("Fábrica"),
	  G("GVD");
	    private String label;
	    
	    private PagamentoDiferencaFrete(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

	    
}
