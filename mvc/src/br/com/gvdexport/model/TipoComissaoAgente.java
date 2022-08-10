package br.com.gvdexport.model;

public enum TipoComissaoAgente {
	  F("Fatura"),
	  G("Gráfica"),
	  R("Remeter");
	
	    private String label;
	    
	    private TipoComissaoAgente(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
