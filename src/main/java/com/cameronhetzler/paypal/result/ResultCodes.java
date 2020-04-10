package com.cameronhetzler.paypal.result;

import lombok.Getter;

@Getter
public enum ResultCodes {
	
	SUCCESS("SUCCESS"),
	FAILURE("FAILURE"),
	WARNING("WARNING");
	
	private String result;
	
	private ResultCodes(String result) {
		this.result = result;
	}
}
