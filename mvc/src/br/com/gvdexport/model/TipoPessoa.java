package br.com.gvdexport.model;

public enum TipoPessoa {
	//(F,J,N,E)
	F("Fisica"),
	J("Juridica"),
	E("Estrangeiro"),
	N("Nenhum"),
	D("Desconecido");
	
	    private String label;
	    
	    private TipoPessoa(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
