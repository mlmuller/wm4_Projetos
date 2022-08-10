package br.com.gvdexport.model;

public enum Indicador {
	RP("Reatualizado pelo Pedido"),
	AP("Atualizado pelo Pedido"),
	AR("Atualizado na Reprogramacao"),
	GR("Inserido na Reprogramacao"),
	GP("Gerado pelo Pedido");
    private String label;
	
    private Indicador(String label) {
        this.label = label;
    }
    

    public String getLabel() {
        return label;
    }


}
