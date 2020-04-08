package com.cameronhetzler.paypal.flows;

import java.util.Map;

import org.apache.log4j.Logger;
import org.jasypt.util.text.BasicTextEncryptor;

import com.cameronhetzler.paypal.exceptions.ErrorCodes;
import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.common.Constants;
import com.paypal.base.rest.APIContext;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public abstract class ApplicationFlow implements ApplicationFlowInt {

	private String clientID;
	private String clientSecret;
	@Getter
	private APIContext context;
	private String environment;
	
	/**
	 * 
	 * @param request
	 */
	protected void parseAndSetElements(Payload request) throws ServicesException {
		String methodName = "parseAndSetElements";
		Long entryTime = entering(methodName, request);
		
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("this-is-not-your-normal-password");
		
		Map<String, Object> table = request.getTable();
		
		if (!table.containsKey(Constants.CLIENT_ID)) {
			ServicesException e = new ServicesException("Missing Client-ID in payload.");
			exiting(methodName, entryTime, e);
			throw e;
		} else if (!table.containsKey(Constants.CLIENT_SECRET)) {
			ServicesException e = new ServicesException("Missing Client-Secret in payload.");
			exiting(methodName, entryTime, e);
			throw e;
		} else if (!table.containsKey(Constants.ENVIRONMENT)) {
			ServicesException e = new ServicesException("Missing Environment Type in payload.");
			exiting(methodName, entryTime, e);
			throw e;
		}
		
		try {
			clientID = textEncryptor.decrypt((String)table.get(Constants.CLIENT_ID));
			clientSecret = textEncryptor.decrypt((String)table.get(Constants.CLIENT_SECRET));
		} catch (Exception e) {
			ServicesException _e = new ServicesException("Unable to decrypt clientID and clientSecret. Make sure there is not a casting error to <String>", ErrorCodes.BASIC_ERROR, e);
			exiting(methodName, entryTime, _e);
			throw _e;
		}
		
		environment = (String)table.get(Constants.ENVIRONMENT);
		
		context = new APIContext(clientID, clientSecret, environment);
		
		exiting(methodName, entryTime);
	}
	
	public Long entering(String methodName, Object...objects) {
		
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append("Entering: ");
		strBldr.append(getClassName());
		strBldr.append('.');
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
	
	public void exiting(String methodName, Long entryTime, Object...objects) {
		
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append("Exiting: ");
		strBldr.append(getClassName());
		strBldr.append('.');
		strBldr.append(methodName);
		strBldr.append(". Total Time: ");
		
		Long deltaTime = System.currentTimeMillis() - entryTime;
		strBldr.append(deltaTime);
		
		if (objects != null) {
			strBldr.append(". Result: { ");
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
	}
	
	public void info(String message, Object...objects) {
		
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append(message);
		
		if (objects != null) {
			strBldr.append(". Objects: { ");
			for (Object obj : objects) {
				strBldr.append(obj.getClass().getName());
				strBldr.append(": ");
				strBldr.append(obj.toString());
				strBldr.append(", ");
			}
			strBldr.append(" }");
		}
		
		Logger logger = getLogger();
		logger.info(strBldr.toString());
	}
	
	public void debug(String message, Object...objects) {
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append(message);
		
		if (objects != null) {
			strBldr.append(". Objects: { ");
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
	}
	
	public void warning(String message, Object...objects) {
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append(message);
		
		if (objects != null) {
			strBldr.append(". Objects: { ");
			for (Object obj : objects) {
				strBldr.append(obj.getClass().getName());
				strBldr.append(": ");
				strBldr.append(obj.toString());
				strBldr.append(", ");
			}
			strBldr.append(" }");
		}
		
		Logger logger = getLogger();
		logger.warn(strBldr.toString());
	}
	
	public void error(String message, Object...objects) {
		StringBuilder strBldr = new StringBuilder();
		
		strBldr.append(message);
		
		if (objects != null) {
			strBldr.append(". Objects: { ");
			for (Object obj : objects) {
				strBldr.append(obj.getClass().getName());
				strBldr.append(": ");
				strBldr.append(obj.toString());
				strBldr.append(", ");
			}
			strBldr.append(" }");
		}
		
		Logger logger = getLogger();
		logger.error(strBldr.toString());
	}
}
