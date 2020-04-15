package com.cameronhetzler.paypal.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class ServicesException extends Exception {

	@NonNull
	private String message;

	private ErrorCodes errorCode;

	private Throwable error;

}
