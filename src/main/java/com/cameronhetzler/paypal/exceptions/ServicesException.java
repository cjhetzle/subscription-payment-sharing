package com.cameronhetzler.paypal.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ServicesException extends Throwable {

	private ErrorCodes errorCode;
	
	private Throwable error;
	
	private String message;
	
}
