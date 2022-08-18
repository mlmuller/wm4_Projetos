package br.com.gvdexport.model;

public enum PrioridadeProducao {
	  X("N�o Liberado"),
	  N("Normal"),
	  U("Urgente"),
	  T("Transi��o");
	    private String label;
	    
	    private PrioridadeProducao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
