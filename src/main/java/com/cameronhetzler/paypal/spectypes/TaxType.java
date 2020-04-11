package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.Tax;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class TaxType extends BaseType<Tax> {
	
	public TaxType() {
		super(new Tax());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Tax>>(){}.getType();
	}

	public Class <Tax> getType() {
		// TODO Auto-generated method stub
		return Tax.class;
	}
}
