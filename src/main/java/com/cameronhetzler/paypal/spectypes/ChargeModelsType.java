package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.ChargeModels;

public class ChargeModelsType extends BaseType<ChargeModels> {

	public ChargeModelsType() {
		super(new ChargeModels());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<ChargeModels>>(){}.getType();
	}

	public Class<ChargeModels> getType() {
		// TODO Auto-generated method stub
		return ChargeModels.class;
	}
}
