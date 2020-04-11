package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;

public abstract class ApplicationServiceFlow extends ApplicationFlow {

	private static final String CLASSNAME = ApplicationServiceFlow.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

	protected String service;
	
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return LOGGER;
	}

	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASSNAME;
	}

}
