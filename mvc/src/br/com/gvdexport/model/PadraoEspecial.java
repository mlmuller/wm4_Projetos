package br.com.gvdexport.model;

public enum PadraoEspecial {
	P("Padr�o"),
	E("Especial");
    private String label;
	
    private PadraoEspecial(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
