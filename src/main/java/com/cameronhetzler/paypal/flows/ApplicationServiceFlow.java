package com.cameronhetzler.paypal.flows;

import java.util.Map;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.exceptions.ErrorCodes;
import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;

public abstract class ApplicationServiceFlow extends ApplicationFlow {

	private static final String CLASSNAME = ApplicationServiceFlow.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

	protected String service;
	
	@Override
	protected Result parseAndSetElements(Payload request) {
		String methodName = "parseAndSetElements";
		Long entryTime = entering(methodName);
		Result result = new Result(methodName);
		
		result.append(super.parseAndSetElements(request));
		
		Map<String, Object> table = request.getTable();
		
		if (!table.containsKey(Constants.SERVICE)) {
			error("Missing Service in payload.");
			result.setThrowable(new ServicesException("Missing Service in payload.", ErrorCodes.MISSING_PARAM, null));
			exiting(methodName, entryTime, result);
			return result;
		}
		
		this.service = (String) table.get(Constants.SERVICE);
		
		result.success();
		exiting(methodName, entryTime, result);
		return result;
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
