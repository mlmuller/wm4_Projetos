package br.com.gvdexport.model;

public enum LayoutInvoiceTrading {
	  A("A"),
	  B("B"),
	  C("C"),
	  D("D"),
	  E("E"),
	  F("F"),
	  G("G"),
	  H("H"),
	  I("I"),
	  J("J"),
	  K("K"),
	  L("L"),
	  M("M"),
	  N("N"),
	  O("O");
	  private String label;
	    
	  private LayoutInvoiceTrading(String label) {
	        this.label = label;
	  }

	  public String getLabel() {
	        return label;
	  }

}
