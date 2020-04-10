package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.cameronhetzler.paypal.exceptions.ServicesException;
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

	public Type getType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Tax>>(){}.getType();
	}

	public Class <Tax> getSpecType() {
		// TODO Auto-generated method stub
		return Tax.class;
	}

	public List<Tax> create(String jsonFile) throws ServicesException {
		// TODO Auto-generated method stub
		try {
			return load(jsonFile, getType());
		} catch (Exception e) {
			return Arrays.asList( load(jsonFile, getSpecType()) );
		}
	}
}
