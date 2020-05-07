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
public class NetworkException extends Exception {

	@NonNull
	private String message;

	private NetworkCodes errorCode;

	private Throwable error;
	
	public NetworkException(String message, NetworkCodes errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}

}
