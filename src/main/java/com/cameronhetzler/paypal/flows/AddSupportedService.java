package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.result.ResultCodes;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class AddSupportedService extends ApplicationServiceFlow {

	private static final String CLASSNAME = AddSupportedService.class.getName();
	private static final Logger LOGGER = Logger.getLogger(AddSupportedService.class);
	
	public Result executeApplicationFlow(Payload request) {
		String methodName = "executeApplicationFlow";
		Long entryTime = entering(methodName, request);
		Result result = new Result();
		result.setResultCode(ResultCodes.SUCCESS);
		
		exiting(methodName, entryTime, result);
		return result;
	}

	public Logger getLogger() {
		return LOGGER;
	}

	public String getClassName() {
		return CLASSNAME;
	}
}
