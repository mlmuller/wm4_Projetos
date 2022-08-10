package br.com.gvdexport.model;

public enum DireitoEsquerdo {
	  D("Direito"),
	  E("Esquerdo");
	    private String label;
	    
	    private DireitoEsquerdo(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
