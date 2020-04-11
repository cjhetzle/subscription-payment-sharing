package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.spectypes.SubscriptionPlanType;
import com.cameronhetzler.paypal.spectypes.SubscriptionType;

public class SendServiceSubscriptionsFromTemplates extends ApplicationServiceFlow {
	
	private static final String CLASSNAME = SendServiceSubscriptionsFromTemplates.class.getName();
	private static final String CLASSNAME_SIMPLE = SendServiceSubscriptionsFromTemplates.class.getSimpleName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

	public Logger getLogger() {
		// TODO Auto-generated method stub
		return LOGGER;
	}

	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASSNAME;
	}
	
	public String getSimpleClassName() {
		return CLASSNAME_SIMPLE;
	}

	public Result executeApplicationFlow(Payload request) {
		final String methodName = "executeApplicationFlow";
		Long entryTime = entering(methodName, request);
		Result result = new Result(getSimpleClassName() + "." + methodName);
		
		SubscriptionPlanType plan = new SubscriptionPlanType();
		
	
		
		SubscriptionType subscription = new SubscriptionType();
				
		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}
}
