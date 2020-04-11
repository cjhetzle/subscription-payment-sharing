package com.cameronhetzler.paypal.result;

import java.util.Collection;
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
	private Queue<String> payload;
	
	@Getter
	private Stack<Result> result;
	
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
	
	public void setResultCode(ResultCodes value) {
		if (!inheritedCode)
			resultCode = value;
	}
	
	public Result(String value) {
		this.message = value;
	}

	public void appendPayload(String value) {
		payload.add(value);
	}
	
	public void appendPayload(Collection<String> values) {
		payload.addAll(values);
	}
	
	/**
	 * Append a result to the result. We need to check
	 * the child result for a non ignorable code first.
	 * 
	 * @param value
	 */
	public void appendResult(Result value) {
		if (value.getResultCode() != null &&
				!ResultCodes.ignorableCodes.contains(
						value.getResultCode())) {
			resultCode = value.getResultCode();
			inheritedCode = true;
		}
		result.add(value);
	}
	
	/**
	 * Append a list of Results to this result at once.
	 * We need to check each result for a resultCode that is
	 * non ignorable.
	 * 
	 * @param values
	 */
	public void appendResult(Collection<Result> values) {
		for (Result value : values) {
			if (value.getResultCode() != null &&
					!ResultCodes.ignorableCodes.contains(
							value.getResultCode())) {
				resultCode = value.getResultCode();
				inheritedCode = true;
				break;
			}
		}
		result.addAll(values);
	}
}
