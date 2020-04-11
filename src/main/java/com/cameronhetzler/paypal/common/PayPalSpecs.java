package com.cameronhetzler.paypal.common;

public enum PayPalSpecs {

	BILLINGINFO("BILLINGINFO"),
	CURRENCY("CURRENCY"),
	INVOICE("INVOICE"),
	ITEM("ITEM"),
	INVOICEITEM("INVOICEITEM"),
	MERCHANTINFO("MERCHANTINFO"),
	TAX("TAX"),
	PAYMENTDEFINITION("PAYMENTDEFINITION");
	
	private String value;
	
	private PayPalSpecs(String value) {
		this.value = value;
		Constants.PayPalSpecs.add(this);
	}
	
	public String toString() {
		return value.toLowerCase();
	}
}
