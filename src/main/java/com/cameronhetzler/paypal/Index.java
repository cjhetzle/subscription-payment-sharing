package com.cameronhetzler.paypal;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.jasypt.util.text.BasicTextEncryptor;

import com.cameronhetzler.paypal.flows.ApplicationFlow;
import com.cameronhetzler.paypal.flows.SendServiceInvoicesFromTemplates;
import com.cameronhetzler.paypal.payload.Classifications;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.common.SupportedServices;
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
		table.put(Constants.SERVICE, SupportedServices.NETFLIX);
		
		request.setTable(table);
		
		handleRequest(request);
	}
	
	public static Result handleRequest(Payload request) {
		Result result = null;
		
		ApplicationFlow flow = null;
		Classifications classification = null;
		try {
			classification = (Classifications) request.getTable().get(Constants.CLASSIFICATION);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			switch (classification) {
			case EXAMPLE:
				flow = new SendServiceInvoicesFromTemplates();
				break;
			case ADD_BILLINGINFO:
				
				break;
			case ADD_SUPPORTED_SERVICE:
				
				break;
			case ADD_SERVICE_ITEM:
				
				break;
			case SEND_SERVICE_INVOICES:
				
				break;
			case SEND_SINGLE_SERVICE_INVOICE:
				
				break;
			case CANCEL_SERVICE_INVOICES:
				
				break;
			case CANCEL_SINGLE_SERVICE_INVOICE:
				
				break;
			case SEND_SERVICE_INVOICES_FROM_TEMPLATES:
				flow = new SendServiceInvoicesFromTemplates();
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
