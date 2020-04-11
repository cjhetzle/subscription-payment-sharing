package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
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
	
	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<MerchantInfo>>(){}.getType();
	}

	public Class<MerchantInfo> getType() {
		// TODO Auto-generated method stub
		return MerchantInfo.class;
	}

	public MerchantInfoType create(String jsonFile) throws ServicesException {
		// TODO Auto-generated method stub
		return create(jsonFile);
	}
}
