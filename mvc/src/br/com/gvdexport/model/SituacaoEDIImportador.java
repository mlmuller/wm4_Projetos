package br.com.gvdexport.model;

public enum SituacaoEDIImportador {
	  A("EDI Libera Altera��o"),
	  E("Enviado Importador"),
	  I("Inserida EDI"),
	  L("Liberada Gera��o EDI"),
	  N("N�o Liberada EDI");
	    private String label;
	    
	    private SituacaoEDIImportador(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }


}
