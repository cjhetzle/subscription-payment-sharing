package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;

/**
 * 
 * @author Cameron Hetzler
 *
 */
interface ApplicationFlowInt {
	
	/**
	 * Configure a possible payload that is sent in.
	 * Build a request, given the source class that was called,
	 * and send out that work to the Paypal-Rest-Sdk
	 * @return Result object with information on what happened
	 */
	public Result configureAndBuildRequest(Payload request);
	
	/**
	 * 
	 * @param methodName
	 * @param object
	 * @return
	 */
	public Long entering(String methodName, Object...object);

	/**
	 * 
	 * @param methodName
	 * @param entryTime
	 * @param objects
	 */
	public void exiting(String methodName, Long entryTime, Object...objects);
	
	/**
	 * 
	 * @return
	 */
	Logger getLogger();
	
	/**
	 * 
	 * @return
	 */
	String getClassName();
}
