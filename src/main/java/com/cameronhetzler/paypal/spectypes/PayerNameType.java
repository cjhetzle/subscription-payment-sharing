package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.PayerName;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class PayerNameType extends BaseType<PayerName> {

	public PayerNameType() {
		super(new PayerName());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<PayerName>>() {
		}.getType();
	}

	public Class<PayerName> getType() {
		// TODO Auto-generated method stub
		return PayerName.class;
	}

}
