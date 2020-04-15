package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.PaymentPreferences;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class PaymentPreferencesType extends BaseType<PaymentPreferences> {

	public PaymentPreferencesType() {
		super(new PaymentPreferences());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<PaymentPreferences>>() {
		}.getType();
	}

	public Class<PaymentPreferences> getType() {
		// TODO Auto-generated method stub
		return PaymentPreferences.class;
	}

}
