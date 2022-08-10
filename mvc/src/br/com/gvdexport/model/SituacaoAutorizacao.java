package br.com.gvdexport.model;

public enum SituacaoAutorizacao {
	  A("Ativa"),
	  T("Todas"),
	  N("N�o Impressas"),
	  I("Impressas"),
	  C("Canceladas");
	    private String label;
	    
	    private SituacaoAutorizacao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
