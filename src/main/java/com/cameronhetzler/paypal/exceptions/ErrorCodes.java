package com.cameronhetzler.paypal.exceptions;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public enum ErrorCodes {

	EXAMPLE("EXAMPLE", "0x0"),
	BASIC_ERROR("BASIC_ERROR", "0x1");
	
	
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
