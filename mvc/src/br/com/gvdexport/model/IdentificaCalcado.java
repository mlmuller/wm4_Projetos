package br.com.gvdexport.model;

public enum IdentificaCalcado {
	  D("Sandália"), 
	  F("Confecção"),
	  b("Sandália Salto Alto"), //Oracle usado numero 2
	  a("Sandália Salto Baixo"), // ORacle usado = 1
	  B("Bota Cano Longo"),
	  S("Sapato"),
	  Z("Bota"),
	  L("Cartela"),
	  c("Bota Cano Médio"), //Oracle = 0
	  H("Chinelo"),
	  E("Bota Cano Curto"),
	  N("Acessório"),
	  C("Tamanco"),
	  M("Mule"),
	  U("Sapato Masculino"),
	  O("Outros"),
	  T("Tênis"),
	  A("Bolsas");
	    private String label;
	    
	    private IdentificaCalcado(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
