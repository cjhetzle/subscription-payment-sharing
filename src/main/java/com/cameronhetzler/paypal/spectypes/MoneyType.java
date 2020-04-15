package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.Money;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class MoneyType extends BaseType<Money> {

	public MoneyType() {
		super(new Money());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Money>>() {
		}.getType();
	}

	public Class<Money> getType() {
		// TODO Auto-generated method stub
		return Money.class;
	}
}
