package br.com.gvdexport.model;

public enum Grupo {
	M("Master"),
	A("Administrador"),
	U("Usuario"),
	C("Externo");
	
	private String label;

	private Grupo(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
