package br.com.gvdexport.model;

public enum TipoNegociacao {
	  B("Landed Branded"),
	  F("First Cost"),
	  I("International"),
	  L("Landed"),
	  R("Reaction"),
	  U("UnList"),
	  X("YourCouture"),
	  Y("NewYork");
	
	  private String label;
	    
	  private TipoNegociacao(String label) {
	        this.label = label;
	  }

	  public String getLabel() {
	        return label;
	  }

}
