package com.cameronhetzler.paypal.flows;

import java.util.Map;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;

public abstract class ApplicationServiceFlow extends ApplicationFlow {

	private static final String CLASSNAME = ApplicationServiceFlow.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

	protected String service;
	
	protected void parseAndSetElements(Payload request) throws ServicesException {
		super.parseAndSetElements(request);
		String methodName = "parseAndSetElements";
		Long entryTime = entering(methodName);
		
		Map<String, Object> table = request.getTable();
		
		if (!table.containsKey(Constants.SERVICE)) {
			ServicesException e = new ServicesException("Missing Client-ID in payload.");
			exiting(methodName, entryTime, e);
			throw e;
		}
		
		this.service = (String) table.get(Constants.SERVICE);
		
		exiting(methodName, entryTime);
	}
	
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return LOGGER;
	}

	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASSNAME;
	}

}
