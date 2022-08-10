package br.com.gvdexport.model;

public enum TipoMaterial {
	C("Leather"),
	T("Fabric"),
	S("Synthetic");

    private String label;
    
    private TipoMaterial(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
