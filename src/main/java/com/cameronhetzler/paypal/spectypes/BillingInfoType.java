package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.BillingInfo;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class BillingInfoType extends BaseType<BillingInfo>{
	
	public BillingInfoType() {
		super(new BillingInfo());
	}

	public Type getType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<BillingInfo>>(){}.getType();
	}
	
	public Class<BillingInfo> getSpecType() {
		// TODO Auto-generated method stub
		return BillingInfo.class;
	}
	
	public List<BillingInfo> create(String jsonFile) throws ServicesException {
		// TODO Auto-generated method stub
		try {
			return load(jsonFile, getType());
		} catch (Exception e) {
			return Arrays.asList( load(jsonFile, getSpecType()) );
		}
	}
}
