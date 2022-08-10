package br.com.gvdexport.model;

public enum UrgenciaObs {
	Urgente("1"),
	Normal("2"),
	Imprimi_Sempre("3");
	
	private String label;

	private UrgenciaObs(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
