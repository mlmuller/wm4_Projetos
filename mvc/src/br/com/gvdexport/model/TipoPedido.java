package br.com.gvdexport.model;

public enum TipoPedido {
	  Novo("N"),
	  Reorder("R"),
	  Top_Store_Price("2"),
	  Bulk_Price("1"),
	  Trial_Price("0"),
	  Wear_Test("W"),
	  Test_Reaction("T"),
	  Estoque("E"),
	  Adotado("A");

	private String label;
	    
	    private TipoPedido(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
