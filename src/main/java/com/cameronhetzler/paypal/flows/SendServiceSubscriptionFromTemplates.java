package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.spectypes.ChargeModelsType;
import com.cameronhetzler.paypal.spectypes.CurrencyType;
import com.cameronhetzler.paypal.spectypes.PaymentDefinitionType;
import com.cameronhetzler.paypal.spectypes.PlanType;
import com.cameronhetzler.paypal.spectypes.PlanType.PayCycles;
import com.paypal.base.rest.PayPalRESTException;

public class SendServiceSubscriptionFromTemplates extends ApplicationServiceFlow {
	
	private static final String CLASSNAME = SendServiceSubscriptionFromTemplates.class.getName();
	private static final String CLASSNAME_SIMPLE = SendServiceSubscriptionFromTemplates.class.getSimpleName();
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
		
		try {
			plan.setInstance(plan.getInstance().create(getContext()));
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//payment_definitions
		PaymentDefinitionType paymentDefinition = new PaymentDefinitionType();
		//paymentDefinition.create(null);
//		paymentDefinition.setName("Regular Payments");
//		paymentDefinition.setType("REGULAR");
//		paymentDefinition.setFrequency("MONTH");
//		paymentDefinition.setFrequencyInterval("1");
//		paymentDefinition.setCycles("12");

		//currency
		CurrencyType currency = new CurrencyType();
//		currency.setCurrency("USD");
//		currency.setValue("20");
//		paymentDefinition.setAmount(currency);
		
		//charge_models
		ChargeModelsType chargeModels = new ChargeModelsType();
//		chargeModels.setType("SHIPPING");
//		chargeModels.setAmount(currency);
		
		paymentDefinition.setInstance(paymentDefinition.getInstance().setChargeModels(chargeModels.getInstanceList()));

		//payment_definition
//		List<PaymentDefinition> paymentDefinitionList = new ArrayList<PaymentDefinition>();
//		paymentDefinitionList.add(paymentDefinition);
		plan.getInstance().setPaymentDefinitions(paymentDefinition.getInstanceList());

		//merchant_preferences
//		MerchantPreferences merchantPreferences = new MerchantPreferences();
//		merchantPreferences.setSetupFee(currency);
//		merchantPreferences.setCancelUrl("http://www.cancel.com");
//		merchantPreferences.setReturnUrl("http://www.return.com");
//		merchantPreferences.setMaxFailAttempts("0");
//		merchantPreferences.setAutoBillAmount("YES");
//		merchantPreferences.setInitialFailAmountAction("CONTINUE");
//		plan.setMerchantPreferences(merchantPreferences);
//
//		this.instance = plan.create(context);
		
		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}
}
