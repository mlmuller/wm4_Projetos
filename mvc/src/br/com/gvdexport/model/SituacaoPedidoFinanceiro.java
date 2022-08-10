package br.com.gvdexport.model;

public enum SituacaoPedidoFinanceiro {
	  Aprovado_por_Financeiro("3"),
	  Aguardando_liberacao_Financeira("2"),
	  Liberacao_Automatica("5"),
	  Pedido_em_Digitacao("1"),
	  Financeiro_libera_Alteracao("4");
	
	    private String label;
	    
	    private SituacaoPedidoFinanceiro(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
