package br.com.gvdexport.model;

public enum IdentificadorCotacao {
	  A("Atualizado"),
	  P("Projetado");

	  private String label;
	
	  private IdentificadorCotacao(String label) {
	        this.label = label;
	  }

	  public String getLabel() {
	        return label;
	  }

}
