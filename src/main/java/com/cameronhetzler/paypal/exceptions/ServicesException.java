package com.cameronhetzler.paypal.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ServicesException extends Throwable {

	@NonNull
	private String message;
	
	private ErrorCodes errorCode;
	
	private Throwable error;
		
}
