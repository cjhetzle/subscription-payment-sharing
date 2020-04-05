package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.result.Result;

/**
 * 
 * @author Cameron Hetzler
 *
 */
interface ApplicationFlowInt {
	
	/**
	 * 
	 * @return
	 */
	public Result configureAndBuildRequest();
	
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
