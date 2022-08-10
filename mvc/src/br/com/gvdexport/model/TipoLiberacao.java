package br.com.gvdexport.model;

public enum TipoLiberacao {
	  N("Normal"),
	  T("T�cnico"),
	  C("Confirma��o");
	    private String label;
	    
	    private TipoLiberacao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
