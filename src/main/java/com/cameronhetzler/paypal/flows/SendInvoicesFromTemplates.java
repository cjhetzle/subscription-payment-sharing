package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.result.Result;

/**
 * 
 * @author Cameron Hetzler
 *
 */
class SendInvoicesFromTemplates extends ApplicationFlow {

	private static final String CLASSNAME = SendInvoicesFromTemplates.class.getName();
	private static final Logger LOGGER = Logger.getLogger(SendInvoicesFromTemplates.class);
	
	public Result configureAndBuildRequest() {
		String methodName = "configureAndBuildRequest";
		
		
		// TODO Auto-generated method stub
		return null;
	}
	
	public Logger getLogger() {
		return LOGGER;
	}
	
}
