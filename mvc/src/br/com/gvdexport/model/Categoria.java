package br.com.gvdexport.model;

public enum Categoria {
	A("Homem(Man)"),
	B("Mulher(Lady"),
	C("Criança(Children)"),
	D("Bêbe(Baby)");
    private String label;
	
    private Categoria(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
