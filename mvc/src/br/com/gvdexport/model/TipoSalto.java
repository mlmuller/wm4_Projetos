package br.com.gvdexport.model;

public enum TipoSalto {
	  G("Wodden Heel"),
	  W("Wodden Wedge");
	
	    private String label;
	    
	    private TipoSalto(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
