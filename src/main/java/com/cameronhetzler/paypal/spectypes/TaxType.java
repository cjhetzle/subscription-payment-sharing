package com.cameronhetzler.paypal.spectypes;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.paypal.api.payments.Tax;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class TaxType extends TypeBase<Tax> {

	public static final String CLASSNAME = TypeBase.class.getName();
	public static final Logger LOGGER = Logger.getLogger(TypeBase.class);
	
	public TaxType() {
		super(new Tax());
	}
	
	public Tax load(String jsonFile) throws ServicesException {
		String methodName = "load";
		if (jsonFile == null) {
			ServicesException se = new ServicesException("Param passed in was [null].");
			LOGGER.debug(se);
			throw se;
		}
		
		try {
			return super.load(jsonFile, Tax.class);
		} catch (IOException e) {
			ServicesException se = new ServicesException("Error thrown while loading Invoice from jsonFile: " + jsonFile, null, e);
			LOGGER.debug("Throwing Error in " + CLASSNAME + "." + methodName, se);
			throw se;
		}
	}
}
