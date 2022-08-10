package br.com.gvdexport.model;

public enum TipoItemInvoice {
	  Personal_Sample("5"),
	  Press_Day("E"),
	  Lab_Tests("Z"),
	  fit_Test("F"),
	  Trim_Sheet("W"),
	  Sales_Man("4"),
	  For_Color_Approval_Only("C"),
	  Revised("R"),
	  Wear_Test("2"),
	  Mock_shop_Sample("M"),
	  Publicty_Sample("P"),
	  Fit_reference("8"),
	  Vamp_Only("V"),
	  Corrected_Sample("T"),
	  Mail_Order("9"),
	  Fit_sample("O"),
	  Marketing_Request("I"),
	  For_Fit_Color("1"),
	  Internet_Still_Samples("K"),
	  Approval_Pattern("Y"),
	  Prototype("7"),
	  PR_Samples("N"),
	  Advertising("H"),
	  Wear_Trial("S"),
	  WEB_Sample("B"),
	  Photo_Sample("A"),
	  For_Fit_Quality_Approval("Q"),
	  Sealing_sample("U"),
	  Style_Insider("G"),
	  For_reference("0"),
	  Press_Sample("6"),
	  Looks_Shoot("L"),
	  Production_Sample("J"),
	  Shipment_Sample("X"),
	  Look_book("D"),
	  Change_of_Material("3");
	
	    private String label;
	    
	    private TipoItemInvoice(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
