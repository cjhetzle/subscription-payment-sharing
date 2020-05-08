package com.cameronhetzler.paypal.flows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.SQL.SQLType;
import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.database.DAO;
import com.cameronhetzler.paypal.exceptions.ErrorCodes;
import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class CreateSupportedService extends ApplicationFlow {

	private final Logger LOGGER = Logger.getLogger(CreateSupportedService.class);
	
	private String service;
	
	public Result executeApplicationFlow(Payload request) {
		final String methodName = "executeApplicationFlow";
		final Long entryTime = entering(methodName);
		Result result = new Result(getSimpleClassName() + "." + methodName);

		result.append(parseAndSetElements(request));
		
		if (result.isError())
			return result;
		
		try {
			
			this.open();
			
			Result res;
			
			ArrayList<Object> params = new ArrayList<Object>();
			params.add(this.service);
			


			res = DAO.executeUpdate(connection, SQLType.INSERT_INTO_SERVICES, params, null);
			
			result.append(res);
			
			this.commit();
			
		} catch (Exception e) {
			error("Encourntered exception while accessing DB.", result, e);
		} finally {
			
		}
		
		exiting(methodName, entryTime);
		return result;
	}
	
	@Override
	public Result parseAndSetElements(Payload request) {
		final String methodName = "parseAndSetElements";
		final Long entryTime = entering(methodName, request);
		Result result = new Result(this.getSimpleClassName() + "." + methodName);
		
		info("Checking payload for reqired elements.", result);

		if (!request.getTable().containsKey(Constants.SERVICE)) {
			error("Missing " + Constants.SERVICE + " Type in payload.", result);
			result.setThrowable(
					new ServicesException("Missing " + Constants.SERVICE + " Type in payload.", ErrorCodes.MISSING_PARAM, null));
			exiting(methodName, entryTime, result);
			return result;
		}
		
		info("Setting required elements from payload.", result);
		
		Object obj = request.getTable().get(Constants.SERVICE);
		
		try {
			this.service = (String) obj;
		} catch (Exception e) {
			error("Connot convert service object: " + obj.toString() + " to type String", result, e);
			return result;
		}
		
		info("Successfully parsed and set elements.", result);
		
		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}
}
