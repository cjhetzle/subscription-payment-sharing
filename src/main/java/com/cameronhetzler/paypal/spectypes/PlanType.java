package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.Plan;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class PlanType extends BaseType<Plan> {

	public PlanType() {
		super(new Plan());
	}

	public Type getType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Plan>>(){}.getType();
	}
	
	public Class<Plan> getSpecType() {
		// TODO Auto-generated method stub
		return Plan.class;
	}

	public List<Plan> create(String jsonFile) throws ServicesException {
		// TODO Auto-generated method stub
		try {
			return load(jsonFile, getType());
		} catch (Exception e) {
			return Arrays.asList( load(jsonFile, getSpecType()) );
		}
	}
}
