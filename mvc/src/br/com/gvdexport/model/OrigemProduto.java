package br.com.gvdexport.model;

public enum OrigemProduto {
	  A("Nacional"), //No Oracle = 0
	  B("Estrangeiro Adq.Mercado Nacional"),
	  C("Estrangeira-Importa��o Direto");

	private String label;
  
  private OrigemProduto(String label) {
      this.label = label;
  }

  public String getLabel() {
      return label;
  }

}
