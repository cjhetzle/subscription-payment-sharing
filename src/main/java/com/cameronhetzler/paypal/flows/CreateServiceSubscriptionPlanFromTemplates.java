package com.cameronhetzler.paypal.flows;

import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.spectypes.BillingCycleType;
import com.cameronhetzler.paypal.spectypes.FrequencyType;
import com.cameronhetzler.paypal.spectypes.MoneyType;
import com.cameronhetzler.paypal.spectypes.PaymentPreferencesType;
import com.cameronhetzler.paypal.spectypes.PricingSchemeType;
import com.cameronhetzler.paypal.spectypes.SubscriptionPlanType;
import com.cameronhetzler.paypal.spectypes.BillingCycleType.Tenure;
import com.cameronhetzler.paypal.spectypes.FrequencyType.Intervals;
import com.paypal.base.rest.PayPalRESTException;

public class CreateServiceSubscriptionPlanFromTemplates extends ApplicationServiceFlow {

	@Override
	protected Result executeApplicationFlow(Payload request) throws ServicesException {
		final String methodName = "executeApplicationFlow";
		Long entryTime = entering(methodName, request);
		Result result = new Result(getSimpleClassName() + "." + methodName);

		SubscriptionPlanType plan = new SubscriptionPlanType();

		plan.getInstance().setProductId("PROD-9HP23572NB642980D");
		plan.getInstance().setName("nameTest");

		BillingCycleType billingCycle = new BillingCycleType();

		FrequencyType frequency = new FrequencyType();
		frequency.getInstance().setIntervalUnit(Intervals.DAY.toString());
		frequency.getInstance().setIntervalCount(5);
		billingCycle.getInstance().setFrequency(frequency.getInstance());

		billingCycle.getInstance().setTenureType(Tenure.REGULAR.toString());
		billingCycle.getInstance().setSequence(1);

		PricingSchemeType pricingScheme = new PricingSchemeType();
		MoneyType fixedPrice = new MoneyType();
		fixedPrice.getInstance().setCurrencyCode(Constants.USD);
		fixedPrice.getInstance().setValue("0.69");

		pricingScheme.getInstance().setFixedPrice(fixedPrice.getInstance());

		billingCycle.getInstance().setPricingScheme(pricingScheme.getInstance());

		plan.getInstance().setBillingCycles(billingCycle.getInstanceList());

		PaymentPreferencesType paymentPreferences = new PaymentPreferencesType();

		paymentPreferences.getInstance().setAutoBillOutstanding(true);

		plan.getInstance().setPaymentPreferences(paymentPreferences.getInstance());

		try {
			plan.setInstance(plan.getInstance().create(getContext()));
			info("Created Plan with ID: " + plan.getInstance().getId(), result);
		} catch (PayPalRESTException e) {
			error("Failed to create SubscriptionPlan.", result, e);
			return result;
		}

		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}

}
