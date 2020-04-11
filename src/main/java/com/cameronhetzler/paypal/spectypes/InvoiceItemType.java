package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

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

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<InvoiceItem>>(){}.getType();
	}

	public Class<InvoiceItem> getType() {
		// TODO Auto-generated method stub
		return InvoiceItem.class;
	}
}
