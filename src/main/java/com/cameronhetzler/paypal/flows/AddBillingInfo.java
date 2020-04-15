package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;

public class AddBillingInfo extends ApplicationFlow {

	private static final String CLASSNAME = AddBillingInfo.class.getName();
	private static final String CLASSNAME_SIMPLE = AddBillingInfo.class.getSimpleName();
	private static final Logger LOGGER = Logger.getLogger(AddBillingInfo.class);

	public Result executeApplicationFlow(Payload request) {
		String methodName = "executeApplicationFlow";
		Long entryTime = entering(methodName, request);
		Result result = new Result(getSimpleClassName() + "." + methodName);

		exiting(methodName, entryTime, result);
		return result;
	}

	public Logger getLogger() {
		return LOGGER;
	}

	public String getClassName() {
		return CLASSNAME;
	}

	public String getSimpleClassName() {
		return CLASSNAME_SIMPLE;
	}

}
