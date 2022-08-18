package br.com.gvdexport.model;

public enum PrioridadeProducao {
	  X("Não Liberado"),
	  N("Normal"),
	  U("Urgente"),
	  T("Transição");
	    private String label;
	    
	    private PrioridadeProducao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
