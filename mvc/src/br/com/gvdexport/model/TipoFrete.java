package br.com.gvdexport.model;
//Este Enum, devera ser feitouma tabela, para organizar melhor as informacoes, edar mais abertuda de opcoes
//compatibilizar para herdar novo codigo.
public enum TipoFrete {
	 GVD_Air("6"),
	  FCA("A"),
	  CIF_Sea("4"),
	  CIF_Air("5"),
	  FOB_Air("3"),
	  FOB_Sea("2"),
	  DDU("D"),
	  CeF_Air("1"),
	  CeF_Sea("0"),
	  DDP("E"),
	  Fact_Air("8"),
	  CPT("B"),
	  Truck("7"),
	  CIP("C");
	    private String label;
	    
	    private TipoFrete(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
