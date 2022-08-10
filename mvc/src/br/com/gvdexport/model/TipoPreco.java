package br.com.gvdexport.model;

public enum TipoPreco {
	  I("Invoice"),
	  T("Tabela"),
	  B("Invoice_Pe"),
	  E("Tabela_Pe");
	
	    private String label;
	    
	    private TipoPreco(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
