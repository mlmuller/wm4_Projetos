package br.com.gvdexport.model;

public enum Licenca {
	  X("Checar"),
	  L("Licenca"),
	  N("Sem Licen�a");
	    private String label;
	    
	    private Licenca(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
