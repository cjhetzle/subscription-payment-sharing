package com.cameronhetzler.paypal.result;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public enum ResultCodes {
	
	SUCCESS("SUCCESS"),
	ERROR("ERROR"),
	WARNING("WARNING");
	
	static List<ResultCodes> ignorableCodes = Arrays.asList(
			ResultCodes.SUCCESS, ResultCodes.WARNING);
	
	private String result;
	
	private ResultCodes(String result) {
		this.result = result;
	}
}
