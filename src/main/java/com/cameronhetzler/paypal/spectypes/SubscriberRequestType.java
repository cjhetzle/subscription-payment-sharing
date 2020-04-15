package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.SubscriberRequest;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class SubscriberRequestType extends BaseType<SubscriberRequest> {

	public SubscriberRequestType() {
		super(new SubscriberRequest());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<SubscriberRequest>>() {
		}.getType();
	}

	public Class<SubscriberRequest> getType() {
		// TODO Auto-generated method stub
		return SubscriberRequest.class;
	}
}
