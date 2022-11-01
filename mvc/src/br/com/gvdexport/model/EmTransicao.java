package br.com.gvdexport.model;

public enum EmTransicao {
	/*
	 *Transicao, significa, que foi liberado para alteracao dpto Amostra
	 *A Liberar, significa, que foi solicitado liberacao para Almoxarifado
	 *Liberado, significa, que Almoxarifado liberou e alterou o Status p/Transição
	 *Nao - significao que o status na producao esta bloqueado para Dpto Amostras
	 */
	
	  S("Sim"),
	  N("Nao"),
	  T("Transição"),
	  W("A Liberar"),
	  L("Liberado");
	    private String label;
	    
	    private EmTransicao(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
