package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.PaymentDefinition;

public class PaymentDefinitionType extends BaseType<PaymentDefinition> {

	public PaymentDefinitionType() {
		super(new PaymentDefinition());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<PaymentDefinition>>() {
		}.getType();
	}

	public Class<PaymentDefinition> getType() {
		// TODO Auto-generated method stub
		return PaymentDefinition.class;
	}
}
