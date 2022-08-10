package br.com.gvdexport.model;

public enum TipoSize {
	A("Continental(Continental)"),
	B("Americana(American)"),
	C("Inglesa(English)"),
	D("Hemisf�rio Sul(South Hemisphere)"),
	E("Dom�stica(Domestic)");
	private String label;
	
	private TipoSize(String label) {
		this.label = label;
		
	}
	public String getLabel() {
		return label;
	}

}
