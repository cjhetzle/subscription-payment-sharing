package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.InvoiceItem;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class InvoiceItemType extends BaseType<InvoiceItem> {
	
	public InvoiceItemType() {
		super(new InvoiceItem());
	}

	public Type getType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<InvoiceItem>>(){}.getType();
	}

	public Class<InvoiceItem> getSpecType() {
		// TODO Auto-generated method stub
		return InvoiceItem.class;
	}

	public List<InvoiceItem> create(String jsonFile) throws ServicesException {
		// TODO Auto-generated method stub
		try {
			return load(jsonFile, getType());
		} catch (Exception e) {
			return Arrays.asList( load(jsonFile, getSpecType()) );
		}
	}
}
