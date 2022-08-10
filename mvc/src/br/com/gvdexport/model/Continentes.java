package br.com.gvdexport.model;

public enum Continentes {
	A("America do Norte","1"),
	B("America do Sul","2"),
	C("America Central","3"),
	D("Europa","4"),
	E("Asia","5"),
	F("Africa","6"),
	G("Oceania","7");
	
	private String label1,label2;

	private Continentes(String label1, String label2) {
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
