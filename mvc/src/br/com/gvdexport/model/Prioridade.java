package br.com.gvdexport.model;

public enum Prioridade {
	  A("A"),
	  B("B"),
	  O("O"),
	  P("P"),
	  Q("Q"),
	  R("R"),
	  S("S"),
	  H("H"),
	  T("T"),
	  I("I"),
	  U("U"),
	  J("J"),
	  C("C"),
	  V("V"),
	  K("K"),
	  D("D"),
	  X("X"),
	  L("L"),
	  E("E"),
	  Z("Z"),
	  M("M"),
	  F("F"),
	  N("N"),
	  G("G");
      private String label;
    
      private Prioridade(String label) {
          this.label = label;
      }

      public String getLabel() {
         return label;
      }

}
