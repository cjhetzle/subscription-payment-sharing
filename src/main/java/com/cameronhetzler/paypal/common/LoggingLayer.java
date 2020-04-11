package com.cameronhetzler.paypal.common;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.result.Result;

public abstract class LoggingLayer {
	
	protected abstract String getClassName();
	
	protected abstract Logger getLogger();
	
	public Long entering(String methodName, Object...objects) {
		
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append("Entering: ");
		strBldr.append(getClassName());
		strBldr.append('.');
		strBldr.append(methodName);
		
		if (objects != null && objects.length > 0) {
			strBldr.append(". Params: { ");
			for (Object obj : objects) {
				strBldr.append(obj.getClass().getName());
				strBldr.append(": ");
				strBldr.append(obj.toString());
				strBldr.append(", ");
			}
			strBldr.append(" }");
		}
		
		getLogger().debug(strBldr.toString());
		
		return System.currentTimeMillis();
	}
	
	public void exiting(String methodName, Long entryTime, Object...objects) {
		exiting(methodName, entryTime, null, objects);
	}
	
	public void exiting(String methodName, Long entryTime, Result result, Object...objects) {
		
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append("Exiting: ");
		strBldr.append(getClassName());
		strBldr.append('.');
		strBldr.append(methodName);
		strBldr.append(". Total Time: ");
		
		Long deltaTime = System.currentTimeMillis() - entryTime;
		strBldr.append(deltaTime);
		
		if (result != null) {
			strBldr.append(". Result { ");
//			strBldr.append("message: \"");
//			strBldr.append(result.getMessage());
//			strBldr.append("\", ");
//			strBldr.append("details: ");
//			for (String detail : result.getPayload()) {
//				strBldr.append("\"");
//				strBldr.append(detail);
//				strBldr.append("\", ");
//			}
			strBldr.append(result.toString());
			strBldr.append(" } ");

		}
		
		if (objects != null && objects.length > 0) {
			strBldr.append(". Objects: { ");
			for (Object obj : objects) {
				strBldr.append(obj.getClass().getName());
				strBldr.append(": ");
				strBldr.append(obj.toString());
				strBldr.append(", ");
			}
			strBldr.append(" } ");
		}
		
		getLogger().debug(strBldr.toString());
	}
	
	public void info(String message, Object...objects) {
		info(message, null, objects);
	}
	
	public void info(String message, Result result, Object...objects) {
		
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append(message);
		
		if (objects != null && objects.length > 0) {
			strBldr.append(". Objects: { ");
			for (Object obj : objects) {
				strBldr.append(obj.getClass().getName());
				strBldr.append(": ");
				strBldr.append(obj.toString());
				strBldr.append(", ");
			}
			strBldr.append(" }");
		}
		
		if (result != null)
			result.append(strBldr.toString());
		
		getLogger().info(strBldr.toString());
	}
	
	public void debug(String message, Object...objects) {
		debug(message, null, objects);
	}
	
	public void debug(String message, Result result, Object...objects) {
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append(message);
		
		if (objects != null && objects.length > 0) {
			strBldr.append(". Objects: { ");
			for (Object obj : objects) {
				strBldr.append(obj.getClass().getName());
				strBldr.append(": ");
				strBldr.append(obj.toString());
				strBldr.append(", ");
			}
			strBldr.append(" }");
		}
		
		if (result != null)
			result.append(strBldr.toString());
		
		getLogger().debug(strBldr.toString());
	}
	
	public void warning(String message, Object...objects) {
		warning(message, null, objects);
	}
	
	public void warning(String message, Result result, Object...objects) {
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append(message);
		
		if (objects != null && objects.length > 0) {
			strBldr.append(". Objects: { ");
			for (Object obj : objects) {
				strBldr.append(obj.getClass().getName());
				strBldr.append(": ");
				strBldr.append(obj.toString());
				strBldr.append(", ");
			}
			strBldr.append(" }");
		}
		
		if (result != null)
			result.append(strBldr.toString());
		
		Logger logger = getLogger();
		logger.warn(strBldr.toString());
	}
	
	public void error(String message, Object...objects) {
		error(message, null, objects);
	}
	
	public void error(String message, Result result, Object...objects) {
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append(message);
		
		if (objects != null && objects.length > 0) {
			strBldr.append(". Objects: { ");
			for (Object obj : objects) {
				strBldr.append(obj.getClass().getName());
				strBldr.append(": ");
				strBldr.append(obj.toString());
				strBldr.append(", ");
			}
			strBldr.append(" }");
		}
		
		if (result != null)
			result.append(strBldr.toString());
		
		getLogger().error(strBldr.toString());
	}
}
