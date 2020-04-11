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
public class SubscriptionPlan extends PayPalResource {
	/**
	 * 
	 */
	private String productId;
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
	private List<BillingCycle> billingCycles;
	/**
	 * 
	 */
	private PaymentPreferences paymentPreferences;
	/**
	 * 
	 */
	private Tax taxes;
	/**
	 * 
	 */
	private Boolean quantitySupported;
	
	public SubscriptionPlan() {
		
	}

	/**
	 * @param product_id the product_id to set
	 */
	public SubscriptionPlan setProductId(String productId) {
		this.productId = productId;
		return this;
	}

	/**
	 * @param name the name to set
	 */
	public SubscriptionPlan setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @param status the status to set
	 */
	public SubscriptionPlan setStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * @param description the description to set
	 */
	public SubscriptionPlan setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * @param billing_cycles the billing_cycles to set
	 */
	public SubscriptionPlan setBillingCycles(List<BillingCycle> billingCycles) {
		this.billingCycles = billingCycles;
		return this;
	}

	/**
	 * @param payment_preferences the payment_preferences to set
	 */
	public SubscriptionPlan setPaymentPreferences(PaymentPreferences paymentPreferences) {
		this.paymentPreferences = paymentPreferences;
		return this;
	}

	/**
	 * @param taxes the taxes to set
	 */
	public SubscriptionPlan setTaxes(Tax taxes) {
		this.taxes = taxes;
		return this;
	}

	/**
	 * @param quantity_supported the quantity_supported to set
	 */
	public SubscriptionPlan setQuantitySupported(Boolean quantitySupported) {
		this.quantitySupported = quantitySupported;
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
