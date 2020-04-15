package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.Plan;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class PlanType extends BaseType<Plan> {

	public static enum PayCycles {
		FIXED("FIXED"), INFINITE("INFINITE");

		private String value;

		private PayCycles(String value) {
			this.value = value;
		}

		public String toString() {
			return value.toLowerCase();
		}
	}

	public PlanType() {
		super(new Plan());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Plan>>() {
		}.getType();
	}

	public Class<Plan> getType() {
		// TODO Auto-generated method stub
		return Plan.class;
	}
}
