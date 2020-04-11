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
	
	@Getter @ToString.Exclude
	private AbstractList<Result> result;
	
	@Getter
	private Throwable throwable;
	
	@Getter
	private ResultCodes resultCode;
	
	@Getter @Setter
	private ErrorCodes errorCode;
	
	private boolean inheritedCode = false;
	
	public void setThrowable(Throwable value) {
		if (value instanceof ServicesException) {
			errorCode = ((ServicesException) value).getErrorCode();
		}
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
		if (!inheritedCode)
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
		if (value.getResultCode() != null &&
				!ResultCodes.ignorableCodes.contains(
						value.getResultCode())) {
			resultCode = value.getResultCode();
			inheritedCode = true;
		}
		if (result == null) result = new LinkedList<Result>();
		result.add(value);
	}
	
//	/**
//	 * Append a list of Results to this result at once.
//	 * We need to check each result for a resultCode that is
//	 * non ignorable.
//	 * 
//	 * @param values
//	 */
//	public void append(Collection<Result> values) {
//		for (Result value : values) {
//			if (value.getResultCode() != null &&
//					!ResultCodes.ignorableCodes.contains(
//							value.getResultCode())) {
//				resultCode = value.getResultCode();
//				inheritedCode = true;
//				break;
//			}
//		}
//		result.addAll(values);
//	}
}
