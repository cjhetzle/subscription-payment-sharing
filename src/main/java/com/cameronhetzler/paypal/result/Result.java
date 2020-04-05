package com.cameronhetzler.paypal.result;

import com.cameronhetzler.paypal.exceptions.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Result {

	private String message;
	
	private String payload;
	
	private Throwable throwable;
	
	private ErrorCodes errorCode;

}
