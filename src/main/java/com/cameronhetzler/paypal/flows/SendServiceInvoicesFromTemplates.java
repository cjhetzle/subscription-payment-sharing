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
public class SendServiceInvoicesFromTemplates extends ApplicationFlow {

	private static final String CLASSNAME = SendServiceInvoicesFromTemplates.class.getName();
	private static final Logger LOGGER = Logger.getLogger(SendServiceInvoicesFromTemplates.class);
	
	private String service;
	private Invoice invoice;
	
	public Result configureAndBuildRequest(Payload request) {
		String methodName = "configureAndBuildRequest";
		Long entryTime = entering(methodName);
		Result result = new Result();
		result.setResultCode(ResultCodes.SUCCESS);
		
		try {
			
			parseAndSetElements(request);
			
			buildBaseInvoiceRequest(request);
			
			getBillingInfoAndSend(request);
			
		} catch(ServicesException se) {
			error("Exception caught in: " + methodName, se);
			result.setResultCode(ResultCodes.FAILURE);
			result.setThrowable(se);
		}
		
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
	private void buildBaseInvoiceRequest(Payload request) throws ServicesException {
		String methodName = "buildBaseInvoiceRequest";
		Long entryTime = entering(methodName, request);
		
		Object object = request.getTable().get(Constants.SERVICE);
		
		String service = null;
		try {
			service = (String) object;
			this.service = service;
			info("Service was parsed and set to: " + this.service);
		} catch (Exception e) {
			error("Exception caught.", e);
			ServicesException se = new ServicesException("Unable to cast service <Object> to <String>.", ErrorCodes.BASIC_ERROR, e);
			exiting(methodName, entryTime, se);
			throw se;
		} finally {
			if (service == null) {
				error("Service is null. Throwing error.");
				ServicesException se = new ServicesException("Parsed [Service] was null.");
				exiting(methodName, entryTime, se);
				throw se;
			}
		}
		
		MerchantInfoType merchantInfo = new MerchantInfoType();
		try {
			merchantInfo.setInstance(merchantInfo.load(Constants.MERCHANTINFO_FILE + this.service + Constants.JSON));
		} catch (Exception e) {
			error("Exception caught.", e);
			ServicesException se = new ServicesException("Unable to load MerchantInfo file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e);
			exiting(methodName, entryTime, se);
			throw se;
		}
		
		CurrencyType currency = new CurrencyType();
		try {
			currency.setInstance(currency.load(Constants.CURRENCY_FILE + this.service + Constants.JSON));
		} catch (Exception e) {
			error("Exception caught.", e);
			ServicesException se = new ServicesException("Unable to load Currency file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e);
			exiting(methodName, entryTime, se);
			throw se;
		}
		
		TaxType tax = new TaxType();
		try {
			tax.setInstance(tax.load(Constants.TAX_FILE + this.service + Constants.JSON));
		} catch (Exception e) {
			error("Exception caught.", e);
			ServicesException se = new ServicesException("Unable to load Tax file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e);
			exiting(methodName, entryTime, se);
			throw se;
		}
		
		InvoiceItemType item = new InvoiceItemType();
		try {
			item.setInstance(item.load(Constants.ITEM_FILE + this.service + Constants.JSON));
		} catch (Exception e) {
			error("Exception caught.", e);
			ServicesException se = new ServicesException("Unable to load Item file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e);
			exiting(methodName, entryTime, se);
			throw se;
		}
		
		item.setInstance(item.getInstance().setUnitPrice(currency.getInstance()));
		
		item.setInstance(item.getInstance().setTax(tax.getInstance()));
		
		InvoiceType invoice = new InvoiceType();
		try {
			invoice.setInstance(invoice.load(Constants.INVOICE_FILE + this.service + Constants.JSON));
		} catch (Exception e) {
			error("Exception caught.", e);
			ServicesException se = new ServicesException("Unable to load Invoice file for service: " + this.service + ". Make sure file exists.", ErrorCodes.FILE_READ, e);
			exiting(methodName, entryTime, se);
			throw se;
		}
		
		invoice.setInstance(invoice.getInstance().setMerchantInfo(merchantInfo.getInstance()));
		
		invoice.setInstance(invoice.getInstance().setItems(Arrays.asList(item.getInstance())));
		
		this.invoice = invoice.getInstance();
		exiting(methodName, entryTime);
	}
	
	private void getBillingInfoAndSend(Payload request) throws ServicesException {
		String methodName = "getBillingInfoAndSend";
		Long entryTime = entering(methodName, request);
		
		BillingInfoType billingInfo = new BillingInfoType();
		try {
			billingInfo.setInstanceList(billingInfo.load(Constants.BILLINGINFO_FILE + this.service + Constants.JSON));
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
		
		exiting(methodName, entryTime);
	}
	
	public Logger getLogger() {
		return LOGGER;
	}

	public String getClassName() {
		return CLASSNAME;
	}
	
}
