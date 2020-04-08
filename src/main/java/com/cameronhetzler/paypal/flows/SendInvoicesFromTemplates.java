package com.cameronhetzler.paypal.flows;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.exceptions.ErrorCodes;
import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.spectypes.BillingInfoType;
import com.cameronhetzler.paypal.spectypes.CurrencyType;
import com.cameronhetzler.paypal.spectypes.InvoiceItemType;
import com.cameronhetzler.paypal.spectypes.MerchantInfoType;
import com.cameronhetzler.paypal.spectypes.TaxType;
import com.paypal.api.payments.BillingInfo;
import com.paypal.api.payments.Invoice;
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
	
	private static final String json = ".json";
	private static final String currencyJson = "currency_";
	private static final String billinginfoJson = "billinginfo_";
	private static final String merchantinfoJson = "merchantinfo_";
	private static final String taxJson = "tax_";
	private static final String itemJson = "item_";
	private static final String netflix = "netflix";
	
	public Result configureAndBuildRequest(Payload request) throws ServicesException {
		String methodName = "configureAndBuildRequest";
		Long entryTime = entering(methodName);
		Result result = new Result();
		// TODO Auto-generated method stub
		parseAndSetElements(request);
		
		Invoice invoice = new Invoice();
		
		MerchantInfoType merchantInfo = new MerchantInfoType();
		merchantInfo.setInstance(merchantInfo.load(merchantinfoJson + netflix + json));
		
		CurrencyType currency = new CurrencyType();
		currency.setInstance(currency.load(currencyJson + netflix + json));
		
		TaxType tax = new TaxType();
		tax.setInstance(tax.load(taxJson + netflix + json));
		
		InvoiceItemType item = new InvoiceItemType();
		item.setInstance(item.load(itemJson + netflix + json));
		item.setInstance(
				item.getInstance().setTax(
						tax.getInstance()));
		item.setInstance(
				item.getInstance().setUnitPrice(
						currency.getInstance()));
		
		BillingInfoType billingInfo = new BillingInfoType();
		billingInfo.setInstanceList(billingInfo.load(billinginfoJson + netflix + json));
		
		invoice.setMerchantInfo(merchantInfo.getInstance());
		invoice.setItems(Arrays.asList(item.getInstance()));
		invoice.setBillingInfo(billingInfo.getInstanceList());
		
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
