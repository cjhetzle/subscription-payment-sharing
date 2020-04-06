package com.cameronhetzler.paypal;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.jasypt.util.text.BasicTextEncryptor;

import com.cameronhetzler.paypal.flows.ApplicationFlow;
import com.cameronhetzler.paypal.flows.SendInvoicesFromTemplates;
import com.cameronhetzler.paypal.payload.Classifications;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.exceptions.ServicesException;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class Index {

	private static final String clientID_sandbox = "fuck-off";
	private static final String clientSecret_sandbox = "fuck-off";
	private static final String clientID = "fuck-off";
	private static final String clientSecret = "fuck-off";
	
	public static void main(String[] args) {
		
		if (args.length < 1) {
			System.out.println("Please make sure to supply args. Exiting...");
			System.exit(-1);
		}
		
		Classifications classification = null;
		
		try {
			classification = Classifications.valueOf(args[0]);
		} catch (Exception e) {
			System.out.println("Please make sure to supply valid args. Exiting...");
			System.exit(-1);
		}
		
		BasicConfigurator.configure();
		
		handleRequest(classification);
	}
	
	public static Result handleRequest(Classifications classification) {
		Result result = null;
		
		Payload request = new Payload();
		Map<String, Object> table = new HashMap<String, Object>();
		
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("this-is-not-your-normal-password");
		
		table.put(Constants.CLIENT_ID, textEncryptor.encrypt(clientID));
		table.put(Constants.CLIENT_SECRET, textEncryptor.encrypt(clientSecret));
		table.put(Constants.ENVIRONMENT, Constants.LIVE);
		
		request.setTable(table);
		
		ApplicationFlow flow = null;
		try {
			switch (classification) {
			case EXAMPLE:
				flow = new SendInvoicesFromTemplates();
				break;
			default:
				throw new ServicesException("No Application flow found for the given classification");
			}
			flow.configureAndBuildRequest(request);
		} catch (ServicesException e) {
			
		}
		
		return result;
	}

}
