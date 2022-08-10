package br.com.gvdexport.model;

public enum TipoCalcadoResumido {
	  F("Fechado"),
	  S("Sandália"),
	  B("Bota");
	    private String label;
	    
	    private TipoCalcadoResumido(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
