package br.com.gvdexport.model;

public enum TipoGrupoProduto {
	  S("Sapato"),
	  C("Botinha"),
	  L("Bota");
	
	    private String label;
	    
	    private TipoGrupoProduto(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
