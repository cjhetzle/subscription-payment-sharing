package com.cameronhetzler.paypal.payload;

import lombok.Getter;
import lombok.ToString;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
@ToString
public enum Classifications {

	EXAMPLE("EXAMPLE"),
	ADD_BILLINGINFO("ADD_BILLINGINFO"),
	ADD_SUPPORTED_SERVICE("ADD_SUPPORTED_SERVICE"),
	ADD_SERVICE_ITEM("ADD_SERVICE_ITEM"),
	SEND_SERVICE_INVOICES("SEND_SERVICE_INVOICES"),
	CANCEL_SERVICE_INVOICES("CANCEL_SERVICE_INVOICES");
	
	private String classification;
	
	private Classifications(String classification) {
		this.classification = classification;
	}
}
