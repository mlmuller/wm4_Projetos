package br.com.gvdexport.model;

public enum IdentificaCalcado {
	  D("Sand�lia"), 
	  F("Confec��o"),
	  b("Sand�lia Salto Alto"), //Oracle usado numero 2
	  a("Sand�lia Salto Baixo"), // ORacle usado = 1
	  B("Bota Cano Longo"),
	  S("Sapato"),
	  Z("Bota"),
	  L("Cartela"),
	  c("Bota Cano M�dio"), //Oracle = 0
	  H("Chinelo"),
	  E("Bota Cano Curto"),
	  N("Acess�rio"),
	  C("Tamanco"),
	  M("Mule"),
	  U("Sapato Masculino"),
	  O("Outros"),
	  T("T�nis"),
	  A("Bolsas");
	    private String label;
	    
	    private IdentificaCalcado(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
