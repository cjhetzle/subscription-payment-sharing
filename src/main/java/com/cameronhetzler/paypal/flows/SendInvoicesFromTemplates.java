package com.cameronhetzler.paypal.flows;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.exceptions.ErrorCodes;
import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.paypal.api.payments.BillingInfo;
import com.paypal.api.payments.Currency;
import com.paypal.api.payments.Invoice;
import com.paypal.api.payments.InvoiceItem;
import com.paypal.api.payments.MerchantInfo;
import com.paypal.base.rest.PayPalRESTException;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class SendInvoicesFromTemplates extends ApplicationFlow {

	private static final String CLASSNAME = SendInvoicesFromTemplates.class.getName();
	private static final Logger LOGGER = Logger.getLogger(SendInvoicesFromTemplates.class);
	
	public Result configureAndBuildRequest(Payload request) throws ServicesException {
		String methodName = "configureAndBuildRequest";
		Long entryTime = entering(methodName);
		Result result = new Result();
		// TODO Auto-generated method stub
		parseAndSetElements(request);
		
		Invoice invoice = new Invoice();
		
		MerchantInfo merchantInfo = new MerchantInfo();
		merchantInfo.setBusinessName("businessName-test");
		merchantInfo.setEmail("");
		
		Currency currency = new Currency();
		currency.setCurrency(Constants.USD);
		currency.setValue("1.23");
		
		InvoiceItem item = new InvoiceItem();
		item.setUnitPrice(currency);
		item.setName("name-test");
		item.setQuantity(1);
		
		BillingInfo billingInfo = new BillingInfo();
		billingInfo.setEmail("");
		
		invoice.setMerchantInfo(merchantInfo);
		invoice.setItems(Arrays.asList(item));
		invoice.setBillingInfo(Arrays.asList(billingInfo));
		
		// create the draft invoices
		try {
			invoice = invoice.create(getContext());
		} catch (PayPalRESTException e) {
			ServicesException _e = new ServicesException("Unable to create draft Invoice.", ErrorCodes.EXAMPLE, e);
			exiting(methodName, entryTime, _e);
			throw _e;
		}
		
		try {
			invoice.send(getContext());
		} catch (PayPalRESTException e) {
			ServicesException _e = new ServicesException("Unable to send Invoice.", ErrorCodes.EXAMPLE, e);
			exiting(methodName, entryTime, _e);
			throw _e;
		}
		
		exiting(methodName, entryTime);
		return result;
	}
	
	public Logger getLogger() {
		return LOGGER;
	}

	public String getClassName() {
		return CLASSNAME;
	}
	
}
