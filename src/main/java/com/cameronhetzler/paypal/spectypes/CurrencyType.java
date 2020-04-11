package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.Currency;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class CurrencyType extends BaseType<Currency> {
	
	public CurrencyType() {
		super(new Currency());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Currency>>(){}.getType();
	}

	public Class<Currency> getType() {
		// TODO Auto-generated method stub
		return Currency.class;
	}
}
