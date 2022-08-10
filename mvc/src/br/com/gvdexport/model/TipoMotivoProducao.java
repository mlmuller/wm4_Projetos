package br.com.gvdexport.model;

public enum TipoMotivoProducao {
	  P("Problema"), // Ativo
	  C("Cancelamento"); // Inativo
	    
	    private String label;
	    
	    private TipoMotivoProducao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
