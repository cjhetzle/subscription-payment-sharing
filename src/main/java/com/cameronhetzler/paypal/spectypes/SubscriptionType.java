/**
 * 
 */
package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;

import com.paypal.api.payments.Subscription;

/**
 * @author Cameron Hetzler
 *
 */
public class SubscriptionType extends BaseType<Subscription> {

	public SubscriptionType() {
		super(new Subscription());
		// TODO Auto-generated constructor stub
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return null;
	}

	public Class<Subscription> getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
