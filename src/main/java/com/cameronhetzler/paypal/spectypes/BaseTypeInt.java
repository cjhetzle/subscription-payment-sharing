package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.cameronhetzler.paypal.exceptions.ServicesException;

/**
 * 
 * @author Cameron Hetzler
 *
 * @param <T>
 */
interface BaseTypeInt<T> {
	
	public Type getType();
	
	public Class<T> getSpecType();
	
	List<T> create(String jsonFile) throws ServicesException;
}