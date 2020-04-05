package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.result.Result;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public abstract class ApplicationFlow implements ApplicationFlowInt {

	public Long entering(String methodName, Object...objects) {
		
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append("Entering: ");
		strBldr.append(methodName);
		
		if (objects != null) {
			strBldr.append(". Params: { ");
			for (Object obj : objects) {
				strBldr.append(obj.getClass().getName());
				strBldr.append(": ");
				strBldr.append(obj.toString());
				strBldr.append(", ");
			}
			strBldr.append(" }");
		}
		
		Logger logger = getLogger();
		logger.debug(strBldr.toString());
		
		return System.currentTimeMillis();
	}
	
	public void exiting(String methodName, Long entryTime) {
		exiting(methodName, entryTime, null);
	}
	
	public void exiting(String methodName, Long entryTime, Result result) {
		
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append("Exiting: ");
		strBldr.append(methodName);
		strBldr.append(". Total Time: ");
		
		Long deltaTime = entryTime - System.currentTimeMillis();
		strBldr.append(deltaTime);
		
		if (result != null) {
			strBldr.append(". Result: ");
			strBldr.append(result.toString());
		}
		
		Logger logger = getLogger();
		logger.debug(strBldr.toString());
	}
	
}
