package com.cameronhetzler.paypal.result;

import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.cameronhetzler.paypal.exceptions.ErrorCodes;
import com.cameronhetzler.paypal.exceptions.ServicesException;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {

	@Getter @Setter
	private String message;
	
	@Getter
	private AbstractList<String> details;
	
	@Getter
	private AbstractList<Result> results;
	
	@Getter
	private Throwable throwable;
	
	@Getter
	private ResultCodes resultCode;
	
	@Getter @Setter
	private ErrorCodes errorCode;
	
	public void setThrowable(Throwable value) {
		if (value != null && value instanceof ServicesException) {
			errorCode = ((ServicesException) value).getErrorCode();
		}
		if (resultCode == null || ResultCodes.ERROR.getLevel() < resultCode.getLevel())
			resultCode = ResultCodes.ERROR;
		throwable = value;
	}
	
	public void success() {
		this.setResultCode(ResultCodes.SUCCESS);
	}
	
	public void error() {
		this.setResultCode(ResultCodes.ERROR);
	}
	
	public void warning() {
		this.setResultCode(ResultCodes.WARNING);
	}
	
	public void setResultCode(ResultCodes value) {
		if (resultCode == null || value != null && 
				value.getLevel() < resultCode.getLevel())
			resultCode = value;
	}
	
	public Result(String value) {
		this.message = value;
	}

	public void append(String value) {
		if (details == null) details = new LinkedList<String>();
		details.add(value);
	}
	
	public void append(Collection<String> values) {
	if (details == null) details = new LinkedList<String>();
		details.addAll(values);
	}
	
	/**
	 * Append a result to the result. We need to check
	 * the child result for a non ignorable code first.
	 * 
	 * @param value
	 */
	public void append(Result value) {
		if (resultCode == null || value.getResultCode() != null &&
				value.getResultCode().getLevel() < resultCode.getLevel()) {
			resultCode = value.getResultCode();
		}
		if (results == null) results = new LinkedList<Result>();
		results.add(value);
	}
	
	public String toStringSimpler() {
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append("Result(");
		
		strBldr.append("message=" + String.valueOf(message));
		
		strBldr.append("details=" + String.valueOf(details));
		
		strBldr.append("resultCode=" + String.valueOf(resultCode));
		
		strBldr.append("errorCode=" + String.valueOf(errorCode));
		
		strBldr.append("throwable=" + String.valueOf(throwable));
		
		strBldr.append(")");
		
		return strBldr.toString();
	}
}
