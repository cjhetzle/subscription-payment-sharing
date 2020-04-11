package com.cameronhetzler.paypal.flows;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.exceptions.ErrorCodes;
import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.result.ResultCodes;
import com.cameronhetzler.paypal.spectypes.BillingInfoType;
import com.cameronhetzler.paypal.spectypes.CurrencyType;
import com.cameronhetzler.paypal.spectypes.InvoiceItemType;
import com.cameronhetzler.paypal.spectypes.InvoiceType;
import com.cameronhetzler.paypal.spectypes.MerchantInfoType;
import com.cameronhetzler.paypal.spectypes.TaxType;
import com.paypal.api.payments.BillingInfo;
import com.paypal.api.payments.Invoice;
import com.paypal.base.rest.PayPalRESTException;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class SendServiceInvoicesFromTemplates extends ApplicationServiceFlow {

	private static final String CLASSNAME = SendServiceInvoicesFromTemplates.class.getName();
	private static final Logger LOGGER = Logger.getLogger(SendServiceInvoicesFromTemplates.class);
	
	private Invoice invoice;
	
	public Result executeApplicationFlow(Payload request) throws ServicesException {
		String methodName = "executeApplicationFlow";
		Long entryTime = entering(methodName);
		Result result = new Result();
		
		result.appendResult(buildBaseInvoiceRequest(request));
			
		result.appendResult(getBillingInfoAndSend(request));
		
		result.setResultCode(ResultCodes.SUCCESS);
		exiting(methodName, entryTime, result);
		return result;
	}
	
	/**
	 * Build an instance of an Invoice using TypeBase classes
	 * to load templates from the resources and then override
	 * class wide Invoice at the end.
	 * 
	 * @param request
	 * @throws ServicesException
	 */
	private Result buildBaseInvoiceRequest(Payload request) {
		String methodName = "buildBaseInvoiceRequest";
		Long entryTime = entering(methodName, request);
		Result result = new Result(methodName);		
		
		Object object = request.getTable().get(Constants.SERVICE);
		
		String service = null;
		try {
			service = (String) object;
			this.service = service;
			info("Service was parsed and set to: " + this.service);
		} catch (Exception e) {
			error("Exception caught.", e);
			result.setThrowable(new ServicesException("Unable to cast service <Object> to <String>.", ErrorCodes.BASIC_ERROR, e));
			exiting(methodName, entryTime, result);
			return result;
		} finally {
			if (service == null) {
				error("Service is null. Throwing error.");
				result.setThrowable(new ServicesException("Parsed [Service] was null.", ErrorCodes.NULL_RETURN, null));
				exiting(methodName, entryTime, result);
				return result;
			}
		}
		
		MerchantInfoType merchantInfo = new MerchantInfoType();
		try {
			merchantInfo.create(Constants.MERCHANTINFO_FILE + this.service + Constants.JSON);
		} catch (Exception e) {
			error("Exception caught.", e);
			result.setThrowable(new ServicesException("Unable to load MerchantInfo file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e));
			exiting(methodName, entryTime, result);
			return result;
		}
		
		CurrencyType currency = new CurrencyType();
		try {
			currency.create(Constants.CURRENCY_FILE + this.service + Constants.JSON);
		} catch (Exception e) {
			error("Exception caught.", e);
			result.setThrowable(new ServicesException("Unable to load MerchantInfo file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e));
			exiting(methodName, entryTime, result);
			return result;
		}
		
		TaxType tax = new TaxType();
		try {
			tax.create(Constants.TAX_FILE + this.service + Constants.JSON);
		} catch (Exception e) {
			error("Exception caught.", e);
			result.setThrowable(new ServicesException("Unable to load Tax file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e));
			exiting(methodName, entryTime, result);
			return result;
		}
		
		InvoiceItemType item = new InvoiceItemType();
		try {
			item.create(Constants.ITEM_FILE + this.service + Constants.JSON);
		} catch (Exception e) {
			error("Exception caught.", e);
			result.setThrowable(new ServicesException("Unable to load Item file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e));
			exiting(methodName, entryTime, result);
			return result;
		}
		
		item.getInstance().setUnitPrice(currency.getInstance());
		
		item.getInstance().setTax(tax.getInstance());
		
		InvoiceType invoice = new InvoiceType();
		try {
			invoice.create(Constants.INVOICE_FILE + this.service + Constants.JSON);
		} catch (Exception e) {
			error("Exception caught.", e);
			result.setThrowable(new ServicesException("Unable to load Invoice file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e));
			exiting(methodName, entryTime, result);
			return result;
		}
		
		invoice.getInstance().setMerchantInfo(merchantInfo.getInstance());
		
		invoice.getInstance().setItems(Arrays.asList(item.getInstance()));
		
		this.invoice = invoice.getInstance();
		
		result.setResultCode(ResultCodes.SUCCESS);
		exiting(methodName, entryTime, result);
		return result;
	}
	
	private Result getBillingInfoAndSend(Payload request) throws ServicesException {
		String methodName = "getBillingInfoAndSend";
		Long entryTime = entering(methodName, request);
		Result result = new Result(methodName);
		
		BillingInfoType billingInfo = new BillingInfoType();
		try {
			billingInfo.create(Constants.BILLINGINFO_FILE + this.service + Constants.JSON);
		} catch (Exception e) {
			ServicesException se = new ServicesException("Unable to load BillingInfo file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e);
			exiting(methodName, entryTime, se);
			throw se;
		}
		
		// this could use some fall back
		List<BillingInfo> billingList = billingInfo.getInstanceList();
		Invoice invoice = this.invoice;
		try {
			for (BillingInfo bi : billingList) {
				invoice.setBillingInfo(Arrays.asList(bi));
				
				// create the template on PayPal account
				invoice = invoice.create(getContext());
				
				// with invoice id, send out invoice
				invoice.send(getContext());
				
				info("Successfully send out invoice: " + invoice.getId());
				
				invoice = this.invoice;
			}
		} catch (PayPalRESTException pre) {
			ServicesException se = new ServicesException("Error while creating Invoices. Make sure template data is correct.", ErrorCodes.BASIC_ERROR, pre);
			exiting(methodName, entryTime, se);
			throw se;
		}
		
		result.setResultCode(ResultCodes.SUCCESS);
		exiting(methodName, entryTime, result);
		return result;
	}
	
	public Logger getLogger() {
		return LOGGER;
	}

	public String getClassName() {
		return CLASSNAME;
	}
	
}
