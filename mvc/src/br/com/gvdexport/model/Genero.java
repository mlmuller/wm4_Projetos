package br.com.gvdexport.model;

public enum Genero {
	M("Masculino"),
	F("Feminino"),
	C("Criança"),
	B("Bebe");
	
	private String label;
 
	private Genero(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
