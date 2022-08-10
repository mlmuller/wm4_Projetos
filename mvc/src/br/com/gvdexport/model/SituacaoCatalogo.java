package br.com.gvdexport.model;

public enum SituacaoCatalogo {
	  C("Cancelado"), // Ativo
	  F("Finalizado Compra Via WEB"),
	  L("Liberado Compra Via WEB"),
	  N("Nao_Finalizado Compra Via WEB");
	    
	    private String label;
	    
	    private SituacaoCatalogo(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
