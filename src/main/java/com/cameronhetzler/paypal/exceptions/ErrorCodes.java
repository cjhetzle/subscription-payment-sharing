package com.cameronhetzler.paypal.exceptions;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public enum ErrorCodes {

	EXAMPLE("EXAMPLE", "0x0");
	
	private String value;
	private String code;
	
	private ErrorCodes(String value, String code) {
		this.value = value;
		this.code = code;
	}
	
	public String toString() {
		return this.value + ": " + this.code;
	}
	
	public String getDescription() {
		return this.value;
	}
	
	public String getCode() {
		return this.code;
	}
}
