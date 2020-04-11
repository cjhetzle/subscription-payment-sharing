package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.MerchantPreferences;

public class MerchantPreferencesType extends BaseType<MerchantPreferences> {

	public MerchantPreferencesType() {
		super(new MerchantPreferences());
		// TODO Auto-generated constructor stub
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<MerchantPreferences>>() {}.getType();
	}

	public Class<MerchantPreferences> getType() {
		// TODO Auto-generated method stub
		return MerchantPreferences.class;
	}
}
