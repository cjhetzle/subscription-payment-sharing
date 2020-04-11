package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.spectypes.ChargeModelsType;
import com.cameronhetzler.paypal.spectypes.CurrencyType;
import com.cameronhetzler.paypal.spectypes.PaymentDefinitionType;
import com.cameronhetzler.paypal.spectypes.PlanType;

public class SendServiceSubscriptionFromTemplates extends ApplicationFlow {

	public Result configureAndBuildRequest(Payload request) {
		
		PlanType plan = new PlanType();
//		plan.setName("T-Shirt of the Month Club Plan");
//		plan.setDescription("Template creation.");
//		plan.setType("fixed");

		//payment_definitions
		PaymentDefinitionType paymentDefinition = new PaymentDefinitionType();
		paymentDefinition.create(Constants.PAYMENTDEFINITION_FILE + Constants.NETFLIX + Constants.JSON;)
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
		MerchantPreferences merchantPreferences = new MerchantPreferences();
		merchantPreferences.setSetupFee(currency);
		merchantPreferences.setCancelUrl("http://www.cancel.com");
		merchantPreferences.setReturnUrl("http://www.return.com");
		merchantPreferences.setMaxFailAttempts("0");
		merchantPreferences.setAutoBillAmount("YES");
		merchantPreferences.setInitialFailAmountAction("CONTINUE");
		plan.setMerchantPreferences(merchantPreferences);

		this.instance = plan.create(context);
		
		return null;
	}

	public Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

}
