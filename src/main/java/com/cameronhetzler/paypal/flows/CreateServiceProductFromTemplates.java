package com.cameronhetzler.paypal.flows;

import com.cameronhetzler.paypal.exceptions.ServicesException;
import com.cameronhetzler.paypal.payload.Payload;
import com.cameronhetzler.paypal.result.Result;
import com.cameronhetzler.paypal.spectypes.ProductType;
import com.cameronhetzler.paypal.spectypes.ProductType.Type;
import com.paypal.base.rest.PayPalRESTException;

/**
 * 
 * @author Cameron Hetzler
 *
 */
public class CreateServiceProductFromTemplates extends ApplicationServiceFlow {

	@Override
	protected Result executeApplicationFlow(Payload request) throws ServicesException {
		final String methodName = "executeApplicationFlow";
		Long entryTime = entering(methodName);
		Result result = new Result();

		ProductType product = new ProductType();
		product.getInstance().setName("nameTest");
		product.getInstance().setType(Type.SERVICE.toString());

		try {
			product.setInstance(product.getInstance().create(getContext()));
			info("Created Product with ID: " + product.getInstance().getId(), result);
		} catch (PayPalRESTException e) {
			error("Failed to create Product.", result, e);
			return result;
		}

		result.success();
		exiting(methodName, entryTime, result);
		return result;
	}

}
