/**
 * 
 */
package com.paypal.api.payments;

import java.util.List;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.HttpMethod;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.PayPalResource;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class Subscription extends PayPalResource {
	/**
	 * 
	 */
	private String product_id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String status;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private List<BillingCycle> billing_cycles;
	/**
	 * 
	 */
	private PaymentPreferences payment_preferences;
	/**
	 * 
	 */
	private Tax taxes;
	/**
	 * 
	 */
	private Boolean quantity_supported;
	
	public Subscription() {
		
	}

	/**
	 * @param product_id the product_id to set
	 */
	public Subscription setProduct_id(String product_id) {
		this.product_id = product_id;
		return this;
	}

	/**
	 * @param name the name to set
	 */
	public Subscription setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @param status the status to set
	 */
	public Subscription setStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * @param description the description to set
	 */
	public Subscription setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * @param billing_cycles the billing_cycles to set
	 */
	public Subscription setBilling_cycles(List<BillingCycle> billing_cycles) {
		this.billing_cycles = billing_cycles;
		return this;
	}

	/**
	 * @param payment_preferences the payment_preferences to set
	 */
	public Subscription setPayment_preferences(PaymentPreferences payment_preferences) {
		this.payment_preferences = payment_preferences;
		return this;
	}

	/**
	 * @param taxes the taxes to set
	 */
	public Subscription setTaxes(Tax taxes) {
		this.taxes = taxes;
		return this;
	}

	/**
	 * @param quantity_supported the quantity_supported to set
	 */
	public Subscription setQuantity_supported(Boolean quantity_supported) {
		this.quantity_supported = quantity_supported;
		return this;
	}
	
	/**
	 * Creates an invoice. Include invoice details including merchant information in the request.
	 * @deprecated Please use {@link #create(APIContext)} instead.
	 * @param accessToken
	 * Access Token used for the API call.
	 * @return Invoice
	 * @throws PayPalRESTException
	 */
	public Invoice create(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return create(apiContext);
	}

	/**
	 * Creates an invoice. Include invoice details including merchant information in the request.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @return Invoice
	 * @throws PayPalRESTException
	 */
	public Invoice create(APIContext apiContext) throws PayPalRESTException {
		String resourcePath = "v1/billing/plans";
		String payLoad = this.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Invoice.class);
	}
}
