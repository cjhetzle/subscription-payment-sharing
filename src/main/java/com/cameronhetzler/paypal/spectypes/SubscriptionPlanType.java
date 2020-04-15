package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.SubscriptionPlan;

public class SubscriptionPlanType extends BaseType<SubscriptionPlan> {

	public SubscriptionPlanType() {
		super(new SubscriptionPlan());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<SubscriptionPlan>>() {
		}.getType();
	}

	public Class<SubscriptionPlan> getType() {
		// TODO Auto-generated method stub
		return SubscriptionPlan.class;
	}
}
