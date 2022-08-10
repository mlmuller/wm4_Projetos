package br.com.gvdexport.model;

public enum TipoImagem {
	  P("Preto_Branco"),
	  C("Colorida"),
	  M("Multi Cor");
	
	    private String label;
	    
	    private TipoImagem(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
