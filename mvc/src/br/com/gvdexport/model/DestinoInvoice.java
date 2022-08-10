package br.com.gvdexport.model;

public enum DestinoInvoice {
	  P("Port"),
	  A("AirPort");
	    private String label;
	    
	    private DestinoInvoice(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
