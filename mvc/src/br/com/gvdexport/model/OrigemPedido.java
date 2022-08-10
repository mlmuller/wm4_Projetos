package br.com.gvdexport.model;

public enum OrigemPedido {
	  D("Digita��o"),
	  W("Web");

	private String label;
  
  private OrigemPedido(String label) {
      this.label = label;
  }

  public String getLabel() {
      return label;
  }

}
