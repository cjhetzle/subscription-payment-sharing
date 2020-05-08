package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.database.DAO;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class CreateSupportedService extends ApplicationFlow {

	private final Logger LOGGER = Logger.getLogger(CreateSupportedService.class);
	
	public Result executeApplicationFlow(Payload request) {
		final String methodName = "executeApplicationFlow";
		final Long entryTime = entering(methodName);
		Result result = new Result(getSimpleClassName() + "." + methodName);
		// TODO Auto-generated method stub
		
		try {
			
			this.open();
			
			String query = "select * from servex.Plans;";
			
			DAO.executeSelectQuery(connection, query, null);
			
			this.commit();
			
		} catch (Exception e) {
			
		} finally {
			
		}
		
		exiting(methodName, entryTime);
		return null;
	}
}
