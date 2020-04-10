package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.Invoice;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class InvoiceType extends BaseType<Invoice> {
	
	public InvoiceType() {
		super(new Invoice());
	}

	public Type getType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Invoice>>(){}.getType();
	}

	public Class<Invoice> getSpecType() {
		// TODO Auto-generated method stub
		return Invoice.class;
	}

	public List<Invoice> create(String jsonFile) throws ServicesException {
		// TODO Auto-generated method stub
		try {
			return load(jsonFile, getType());
		} catch (Exception e) {
			return Arrays.asList( load(jsonFile, getSpecType()) );
		}
	}
}
