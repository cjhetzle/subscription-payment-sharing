package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.spectypes.ChargeModelsType;
import com.cameronhetzler.paypal.spectypes.CurrencyType;
import com.cameronhetzler.paypal.spectypes.MerchantPreferencesType;
import com.cameronhetzler.paypal.spectypes.PaymentDefinitionType;
import com.cameronhetzler.paypal.spectypes.PlanType;
import com.cameronhetzler.paypal.spectypes.PlanType.PayCycles;
import com.paypal.base.rest.PayPalRESTException;

public class SendServiceSubscriptionsFromTemplates extends ApplicationServiceFlow {
	
	private static final String CLASSNAME = SendServiceSubscriptionsFromTemplates.class.getName();
	private static final String CLASSNAME_SIMPLE = SendServiceSubscriptionsFromTemplates.class.getSimpleName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

	public Logger getLogger() {
		// TODO Auto-generated method stub
		return LOGGER;
	}

	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASSNAME;
	}
	
	public String getSimpleClassName() {
		return CLASSNAME_SIMPLE;
	}

	public Result executeApplicationFlow(Payload request) {
		final String methodName = "executeApplicationFlow";
		Long entryTime = entering(methodName, request);
		Result result = new Result(getSimpleClassName() + "." + methodName);
		
		PlanType plan = new PlanType();
//		plan.setName("T-Shirt of the Month Club Plan");
//		plan.setDescription("Template creation.");
//		plan.setType("fixed");
		plan.getInstance().setType(PayCycles.INFINITE.toString());
		plan.getInstance().setName("Test Plan");
		plan.getInstance().setDescription("Test Description");
		

		//payment_definitions
		PaymentDefinitionType paymentDefinition = new PaymentDefinitionType();
		//paymentDefinition.create(null);
		paymentDefinition.getInstance().setName("Regular Payments");
		paymentDefinition.getInstance().setType("REGULAR");
		paymentDefinition.getInstance().setFrequency("MONTH");
		paymentDefinition.getInstance().setFrequencyInterval("1");
		paymentDefinition.getInstance().setCycles("0");

		//currency
		CurrencyType currency = new CurrencyType();
		currency.getInstance().setCurrency("USD");
		currency.getInstance().setValue("20");
		paymentDefinition.getInstance().setAmount(currency.getInstance());
		
		//charge_models
		ChargeModelsType chargeModels = new ChargeModelsType();
//		chargeModels.setType("SHIPPING");
//		chargeModels.setAmount(currency);
		
//		paymentDefinition.setInstance(paymentDefinition.getInstance().setChargeModels(chargeModels.getInstanceList()));

		//payment_definition
//		List<PaymentDefinition> paymentDefinitionList = new ArrayList<PaymentDefinition>();
//		paymentDefinitionList.add(paymentDefinition);
		plan.getInstance().setPaymentDefinitions(paymentDefinition.getInstanceList());

		//merchant_preferences
		MerchantPreferencesType merchantPreferences = new MerchantPreferencesType();
//		merchantPreferences.setSetupFee(currency);
		merchantPreferences.getInstance().setCancelUrl("http://www.cancel.com");
		merchantPreferences.getInstance().setReturnUrl("http://www.return.com");
//		merchantPreferences.setMaxFailAttempts("0");
//		merchantPreferences.setAutoBillAmount("YES");
//		merchantPreferences.setInitialFailAmountAction("CONTINUE");
		plan.getInstance().setMerchantPreferences(merchantPreferences.getInstance());
//
//		this.instance = plan.create(context);
		try {
			plan.setInstance(plan.getInstance().create(getContext()));
		} catch (PayPalRESTException e) {
			error("Failed to create Plan.", result, e);
			return result;
		}
		
		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}
}
