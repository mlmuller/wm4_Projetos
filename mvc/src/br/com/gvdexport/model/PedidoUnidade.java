package br.com.gvdexport.model;

public enum PedidoUnidade {
	  MetroLinear("5"),
	  Placas("2"),
	  Pecas("1"),
	  Conjunto("7"),
	  PesQuadrado("4"),
	  Resmas("3"),
	  M2("6"),
	  Pares("0");
	    private String label;
	    
	    private PedidoUnidade(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
