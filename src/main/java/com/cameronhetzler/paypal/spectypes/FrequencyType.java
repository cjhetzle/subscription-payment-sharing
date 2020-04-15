package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.Frequency;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class FrequencyType extends BaseType<Frequency> {

	public static enum Intervals {

		DAY("DAY"), WEEK("WEEK"), MONTH("MONTH"), YEAR("YEAR");

		private String value;

		private Intervals(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	}

	public FrequencyType() {
		super(new Frequency());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Frequency>>() {
		}.getType();
	}

	public Class<Frequency> getType() {
		// TODO Auto-generated method stub
		return Frequency.class;
	}

}
