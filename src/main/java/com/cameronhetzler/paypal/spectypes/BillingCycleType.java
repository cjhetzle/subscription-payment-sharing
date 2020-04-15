package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.BillingCycle;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class BillingCycleType extends BaseType<BillingCycle> {

	public static enum Tenure {

		TRIAL("TRIAL"), REGULAR("REGULAR");

		private String value;

		private Tenure(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	}

	public BillingCycleType() {
		super(new BillingCycle());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<BillingCycle>>() {
		}.getType();
	}

	public Class<BillingCycle> getType() {
		// TODO Auto-generated method stub
		return BillingCycle.class;
	}

}
