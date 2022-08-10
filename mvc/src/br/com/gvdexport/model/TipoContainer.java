package br.com.gvdexport.model;

public enum TipoContainer {
	  Vinte("1"),
	  Quarenta("2");
	    private String label;
	    
	    private TipoContainer(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
