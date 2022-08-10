package br.com.gvdexport.model;

public enum QuadroFabrica {
	A("Factory A"),
	B("Factory B"),
	C("Satellite");
	
	private String label;
 
	private QuadroFabrica(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
