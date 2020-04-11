package com.cameronhetzler.paypal.flows;

import java.util.Map;

import org.apache.log4j.Logger;
import org.jasypt.util.text.BasicTextEncryptor;

import com.cameronhetzler.paypal.exceptions.ErrorCodes;
import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.result.ResultCodes;
import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.common.LoggingLayer;
import com.paypal.base.rest.APIContext;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public abstract class ApplicationFlow
extends LoggingLayer
implements ApplicationFlowInt {
	
	private static final String CLASSNAME = ApplicationFlow.class.getName();
	private static final String CLASSNAME_SIMPLE = ApplicationFlow.class.getSimpleName();

	protected String getClassName() {
		return CLASSNAME;
	}
	
	protected String getSimpleClassName() {
		return CLASSNAME_SIMPLE;
	}
	
	private String clientID;
	private String clientSecret;
	@Getter
	private APIContext context;
	private String environment;
	
	public Result configureAndBuildRequest(Payload request) {
		String methodName = "configureAndBuildRequest";
		Long entryTime = entering(methodName);
		Result result = new Result(this.getSimpleClassName() + "." + methodName);
		
		try {
			
			result.append(parseAndSetElements(request));
			
			result.append(executeApplicationFlow(request));
			
		} catch(ServicesException se) {
			error("Exception caught in: " + methodName, se);
			result.setResultCode(ResultCodes.ERROR);
			result.setThrowable(se);
			return result;
		}
		
		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}
	
	protected abstract Result executeApplicationFlow(Payload request) throws ServicesException;
	
	/**
	 * 
	 * @param request
	 */
	protected Result parseAndSetElements(Payload request) {
		final String methodName = "parseAndSetElements";
		Long entryTime = entering(methodName, request);
		Result result = new Result(getSimpleClassName() + "." + methodName);
		
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("this-is-not-your-normal-password");
		
		Map<String, Object> table = request.getTable();
		
		if (!table.containsKey(Constants.CLIENT_ID)) {
			error("Missing Client-ID in payload.", result);
			result.setThrowable(new ServicesException("Missing Client-ID in payload.", ErrorCodes.MISSING_PARAM, null));
			exiting(methodName, entryTime, result);
			return result;
		} else if (!table.containsKey(Constants.CLIENT_SECRET)) {
			error("Missing Client-Secret in payload.", result);
			result.setThrowable(new ServicesException("Missing Client-Secret in payload.", ErrorCodes.MISSING_PARAM, null));
			exiting(methodName, entryTime, result);
			return result;
		} else if (!table.containsKey(Constants.ENVIRONMENT)) {
			error("Missing Environment Type in payload.", result);
			result.setThrowable(new ServicesException("Missing Environment Type in payload.", ErrorCodes.MISSING_PARAM, null));
			exiting(methodName, entryTime, result);
			return result;
		}
		
		try {
			this.clientID = textEncryptor.decrypt((String)table.get(Constants.CLIENT_ID));
			this.clientSecret = textEncryptor.decrypt((String)table.get(Constants.CLIENT_SECRET));
		} catch (Exception e) {
			error("Error caught in: " + methodName, result, e);
			result.setThrowable(new ServicesException("Unable to decrypt clientID and clientSecret. Make sure there is not a casting error to <String>", ErrorCodes.BASIC_ERROR, e));
			exiting(methodName, entryTime, result);
			return result;
		}
		
		this.environment = (String)table.get(Constants.ENVIRONMENT);
		info("Environment set to: " + environment, result);
		
		this.context = new APIContext(clientID, clientSecret, environment);
		info("Created API context.", result);
		
		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}
	
}
