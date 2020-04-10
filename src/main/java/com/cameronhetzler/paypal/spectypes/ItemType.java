package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.Item;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class ItemType extends BaseType<Item> {

	public ItemType() {
		super(new Item());
	}

	public Type getType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Item>>(){}.getType();
	}

	public Class<Item> getSpecType() {
		// TODO Auto-generated method stub
		return Item.class;
	}

	public List<Item> create(String jsonFile) throws ServicesException {
		// TODO Auto-generated method stub
		try {
			return load(jsonFile, getType());
		} catch (Exception e) {
			return Arrays.asList( load(jsonFile, getSpecType()) );
		}
	}
}
