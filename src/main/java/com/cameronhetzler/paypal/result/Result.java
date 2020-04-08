package com.cameronhetzler.paypal.result;

import com.cameronhetzler.paypal.exceptions.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {

	private String message;
	
	private String payload;
	
	private Throwable throwable;
	
	private ResultCodes resultCode;
	
	private ErrorCodes errorCode;

}
