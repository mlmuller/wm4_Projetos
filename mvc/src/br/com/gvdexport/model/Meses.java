package br.com.gvdexport.model;

public enum Meses {
	
	 A("Janeiro","1"),
	 B("Fevereiro","2"),
	 C("Março","3"),
	 D("Abril","4"),
	 E("Maio","5"),
	 F("Junho","6"),
	 G("Julho","7"),
	 H("Agosto","8"),
	 I("Setembro","9"),
	 J("Outubro","10"),
	 K("Novembro","11"),
     L("Dezembro","12");
	
	private String label1,label2;

	private Meses(String label1, String label2) {
		this.label1 = label1;
		this.label2 = label2;
	}
	
	public String getLabel1() {
		return label1;
	}
	public String getLabel2() {
		return label2;
	}
	
}
