package br.com.gvdexport.model;

public enum ImprimiContratoFabrica {
	C("Nome Cliente"),
	G("nome Grupo");
		    
	    private String label;
	    
	    private ImprimiContratoFabrica(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
