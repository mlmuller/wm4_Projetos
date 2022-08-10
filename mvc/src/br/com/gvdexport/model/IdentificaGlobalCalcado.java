package br.com.gvdexport.model;

public enum IdentificaGlobalCalcado {
	  C("Cal�ados"),
	  D("Diversos"),
	  E("Esportivos");

	private String label;
    
    private IdentificaGlobalCalcado(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
