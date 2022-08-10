package br.com.gvdexport.model;

public enum TipoPrioridade {
	A("A"),
	B("B"),
	C("C"),
	D("D"),
	E("E"),
	F("F"),
	G("G"),
	H("H"),
	I("I"),
	J("J"),
	K("K"),
	L("L"),
	M("M"),
	N("N"),
	O("O"),
	P("P"),
	Q("Q"),
	R("R"),
	S("S"),
	T("T"),
	U("U"),
	V("V"),
	X("X"),
	Y("Y"),
	Z("Z");
    private String label;
	
    private TipoPrioridade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}
