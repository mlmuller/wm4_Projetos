package br.com.gvdexport.model;

public enum GrupoMercado {
	Europa_EUA("E"),
	GVD("I"),
	Mercosul("S"),
	Licenciados("L");
    private String label;
	
    private GrupoMercado(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
