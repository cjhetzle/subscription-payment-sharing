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

	public static void main(String[] args) {
		
		if (args.length < 4) {
			System.out.println("Please make sure to supply args. Exiting...");
			System.exit(-1);
		}
		
		Classifications classification = null;
		String clientID = null;
		String clientSecret = null;
		String environment = null;
		
		try {
			classification = Classifications.valueOf(args[0]);
			clientID = args[1].strip();
			clientSecret = args[2].strip();
			environment = args[3].strip();
		} catch (Exception e) {
			System.out.println("Please make sure to supply valid args. Exiting...");
			System.exit(-1);
		}
		
		BasicConfigurator.configure();
		
		// Build a payload
		Payload request = new Payload(classification);
		Map<String, Object> table = new HashMap<String, Object>();
		
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("this-is-not-your-normal-password");
		
		table.put(Constants.CLASSIFICATION, classification);
		table.put(Constants.CLIENT_ID, textEncryptor.encrypt(clientID));
		table.put(Constants.CLIENT_SECRET, textEncryptor.encrypt(clientSecret));
		table.put(Constants.ENVIRONMENT, environment);
		
		handleRequest(request);
	}
	
	public static Result handleRequest(Payload request) {
		Result result = null;
		
		ApplicationFlow flow = null;
		try {
			switch ((Classifications)request.getTable().get(Constants.CLASSIFICATION)) {
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
