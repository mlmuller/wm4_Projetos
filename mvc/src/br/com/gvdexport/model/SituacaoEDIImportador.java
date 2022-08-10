package br.com.gvdexport.model;

public enum SituacaoEDIImportador {
	  A("EDI Libera Alteração"),
	  E("Enviado Importador"),
	  I("Inserida EDI"),
	  L("Liberada Geração EDI"),
	  N("Não Liberada EDI");
	    private String label;
	    
	    private SituacaoEDIImportador(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }


}
