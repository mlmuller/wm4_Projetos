package br.com.gvdexport.model;

public enum SituacaoProducao {
	  I("Impressa"),
	  N("Não Liberada Cancelada"),
	  L("Não Impressa");

	private String label;
	    
	    private SituacaoProducao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }


}
