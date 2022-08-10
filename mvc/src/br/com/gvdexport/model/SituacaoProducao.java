package br.com.gvdexport.model;

public enum SituacaoProducao {
	  I("Impressa"),
	  N("N�o Liberada Cancelada"),
	  L("N�o Impressa");

	private String label;
	    
	    private SituacaoProducao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }


}
