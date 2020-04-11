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

	public static enum Status {
		
		CREATED("CREATED"),
		INACTIVE("INACTIVE"),
		ACTIVE("ACTIVE");
		
		private String value;
		
		private Status(String value) {
			this.value = value;
		}
		
		public String toString() {
			return value;
		}
	}
	
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
