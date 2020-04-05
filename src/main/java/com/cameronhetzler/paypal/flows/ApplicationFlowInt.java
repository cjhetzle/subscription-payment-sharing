package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.result.Result;

/**
 * 
 * @author Cameron Hetzler
 *
 */
interface ApplicationFlowInt {
	
	public Result configureAndBuildRequest();
	
	public Long entering(String methodName, Object...object);

	public void exiting(String methodName, Long entryTime);
	
	public void exiting(String methodName, Long entryTime, Result result);
	
	Logger getLogger();
	
}
