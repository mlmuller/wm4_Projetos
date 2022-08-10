package br.com.gvdexport.model;

public enum Negociacao {
	  Direto("0"),
	  Trading("1");
	    private String label;
	    
	    private Negociacao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
