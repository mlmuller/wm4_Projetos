package br.com.gvdexport.model;

public enum TipoBico {
	F("Fino"),
	M("Médio"),
	O("Oval"),
	R("Redondo)"),
	Q("Quadrado");
	private String label;
	
	private TipoBico(String label) {
		this.label = label;
		
	}
	public String getLabel() {
		return label;
	}

}
