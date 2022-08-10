package br.com.gvdexport.model;

public enum TipoImportador {
	  I("Interkommerz"),
	  O("Outros");
	    private String label;
	    
	    private TipoImportador(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
