package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.MerchantInfo;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class MerchantInfoType extends BaseType<MerchantInfo> {
	
	public MerchantInfoType() {
		super(new MerchantInfo());
	}
	
	public Type getType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<MerchantInfo>>(){}.getType();
	}

	public Class<MerchantInfo> getSpecType() {
		// TODO Auto-generated method stub
		return MerchantInfo.class;
	}

	public List<MerchantInfo> create(String jsonFile) throws ServicesException {
		// TODO Auto-generated method stub
		try {
			return load(jsonFile, getType());
		} catch (Exception e) {
			return Arrays.asList( load(jsonFile, getSpecType()) );
		}
	}
}
