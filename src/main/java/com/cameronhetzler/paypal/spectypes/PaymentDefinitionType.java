package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.PaymentDefinition;

public class PaymentDefinitionType extends BaseType<PaymentDefinition> {
	
	public PaymentDefinitionType() {
		super(new PaymentDefinition());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<PaymentDefinition>>(){}.getType();
	}

	public Class<PaymentDefinition> getType() {
		// TODO Auto-generated method stub
		return PaymentDefinition.class;
	}

	public PaymentDefinitionType create(String jsonFile) throws ServicesException {
		// TODO Auto-generated method stub
		try {
			setInstanceList(load(jsonFile, getListType()));
		} catch (Exception e) {
			setInstance(load(jsonFile, getType()));
		}
		return this;
	}

}
