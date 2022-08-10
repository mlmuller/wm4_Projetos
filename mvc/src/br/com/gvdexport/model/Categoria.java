package br.com.gvdexport.model;

public enum Categoria {
	A("Homem(Man)"),
	B("Mulher(Lady"),
	C("Crian�a(Children)"),
	D("B�be(Baby)");
    private String label;
	
    private Categoria(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
