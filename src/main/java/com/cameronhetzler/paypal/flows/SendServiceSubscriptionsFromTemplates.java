package com.cameronhetzler.paypal.flows;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.common.Constants;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.spectypes.BillingCycleType;
import com.cameronhetzler.paypal.spectypes.BillingCycleType.Tenure;
import com.cameronhetzler.paypal.spectypes.FrequencyType;
import com.cameronhetzler.paypal.spectypes.PaymentPreferencesType;
import com.cameronhetzler.paypal.spectypes.PricingSchemeType;
import com.cameronhetzler.paypal.spectypes.SubscriberRequestType;
import com.cameronhetzler.paypal.spectypes.SubscriptionPlanType;
import com.cameronhetzler.paypal.spectypes.SubscriptionType;
import com.paypal.api.payments.SubscriptionPlan;
import com.paypal.base.rest.PayPalRESTException;
import com.cameronhetzler.paypal.spectypes.FrequencyType.Intervals;
import com.cameronhetzler.paypal.spectypes.MoneyType;
import com.cameronhetzler.paypal.spectypes.PayerNameType;

/**
 * 
 * @author Cameron Hetzler
 *
 */
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

		SubscriptionPlanType plan = new SubscriptionPlanType();

		try {
			plan.setInstanceList((plan.getInstance().getAll(getContext())).getPlans());
			info("Retrieved list of Subscription Plans.", result);
		} catch (PayPalRESTException e) {
			error("Failed to getAll Plans.", result, e);
			return result;
		}

		for (SubscriptionPlan p : plan.getInstanceList()) {
			if (p.getName().equalsIgnoreCase("nameTest")) {
				plan.setInstance(p);
				break;
			}
		}

		SubscriptionType subscription = new SubscriptionType();
		subscription.getInstance().setPlanId(plan.getInstance().getId());

		SubscriberRequestType subscriber = new SubscriberRequestType();
		subscriber.getInstance().setEmailAddress("quebec4bear@gmail.com");
		PayerNameType payerName = new PayerNameType();
		payerName.getInstance().setGivenName("Cameron");
		payerName.getInstance().setSurname("Hetzler");
		subscriber.getInstance().setName(payerName.getInstance());

		subscription.getInstance().setSubscriber(subscriber.getInstance());

		try {
			subscription.setInstance(subscription.getInstance().create(getContext()));
			info("Created Subscription with ID: " + subscription.getInstance().getId(), result);
		} catch (PayPalRESTException e) {
			error("Failed to create Subscription.", result, e);
			return result;
		}

		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}
}
