package br.com.gvdexport.model;

public enum EmTransicao {
	  S("Sim"),
	  N("Nao"),
	  T("Transi��o");
	    private String label;
	    
	    private EmTransicao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
