package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.result.Result;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
class SendInvoicesFromTemplates extends ApplicationFlow {

	private static final String CLASSNAME = SendInvoicesFromTemplates.class.getName();
	private static final Logger LOGGER = Logger.getLogger(SendInvoicesFromTemplates.class);
	
	public Result configureAndBuildRequest() {
		String methodName = "configureAndBuildRequest";
		Long entryTime = entering(methodName);
		Result result = new Result();
		// TODO Auto-generated method stub
		
		exiting(methodName, entryTime);
		return result;
	}
	
	public Logger getLogger() {
		return LOGGER;
	}

	public String getClassName() {
		return CLASSNAME;
	}
	
}
