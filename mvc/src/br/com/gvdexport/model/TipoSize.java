package br.com.gvdexport.model;

public enum TipoSize {
	A("Continental(Continental)"),
	B("Americana(American)"),
	C("Inglesa(English)"),
	D("Hemisfério Sul(South Hemisphere)"),
	E("Doméstica(Domestic)");
	private String label;
	
	private TipoSize(String label) {
		this.label = label;
		
	}
	public String getLabel() {
		return label;
	}

}
