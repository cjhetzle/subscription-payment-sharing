package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;

import com.cameronhetzler.paypal.exceptions.ServicesException;

/**
 * 
 * @author Cameron Hetzler
 *
 * @param <T>
 */
interface BaseTypeInt<T> {
	
	/**
	 * Get the SDK type in Token List form.
	 * This is meant for serializing Json Files.
	 * 
	 * @return Type
	 */
	public Type getListType();
	
	/**
	 * Get the SDK type class.
	 * This is meant for serializing Json Files.
	 * 
	 * @return Class<T>
	 */
	public Class<T> getType();
	
	/**
	 * Abstracted create method will create object from template file
	 * with provided jsonFile String.
	 * 
	 * @param jsonFile The file name and relative path from Resources.
	 * @return 
	 * @throws ServicesException
	 */
	BaseTypeInt<T> create(String jsonFile) throws ServicesException;
}