package br.com.gvdexport.model;

public enum OrigemInsercao  {
	  T("Trafego"),
	  F("Fatura"),
	  R("Reserva");
	    private String label;
	    
	    private OrigemInsercao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }


}
