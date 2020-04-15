package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.PricingScheme;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class PricingSchemeType extends BaseType<PricingScheme> {

	public PricingSchemeType() {
		super(new PricingScheme());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<PricingScheme>>() {
		}.getType();
	}

	public Class<PricingScheme> getType() {
		// TODO Auto-generated method stub
		return PricingScheme.class;
	}
}
