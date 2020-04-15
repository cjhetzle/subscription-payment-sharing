/**
 * 
 */
package com.paypal.api.payments;

import java.util.List;
import java.util.Map;

import com.cameronhetzler.paypal.flows.SubscriptionPlans;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.HttpMethod;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.PayPalResource;
import com.paypal.base.rest.RESTUtil;

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
	private String id;
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
	 * 
	 * @param id
	 */
	public SubscriptionPlan setId(String id) {
		this.id = id;
		return this;
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
	 * Creates an SubscriptionPlan. Include SubscriptionPlan details including merchant information in the request.
	 * @deprecated Please use {@link #create(APIContext)} instead.
	 * @param accessToken
	 * Access Token used for the API call.
	 * @return SubscriptionPlan
	 * @throws PayPalRESTException
	 */
	public SubscriptionPlan create(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return create(apiContext);
	}

	/**
	 * Creates an SubscriptionPlan. Include SubscriptionPlan details including merchant information in the request.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @return SubscriptionPlan
	 * @throws PayPalRESTException
	 */
	public SubscriptionPlan create(APIContext apiContext) throws PayPalRESTException {
		String resourcePath = "v1/billing/plans";
		String payLoad = this.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, SubscriptionPlan.class);
	}

	/**
	 * Lists some or all merchant Products. Filters the response by any specified optional query string parameters.
	 * @deprecated Please use {@link #getAll(APIContext)} instead.
	 * @param accessToken
	 * Access Token used for the API call.
	 * @return Products
	 * @throws PayPalRESTException
	 */
	public static SubscriptionPlans getAll(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return getAll(apiContext, null);
	}

	/**
	 * Lists some or all merchant Products. Filters the response by any specified optional query string parameters.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @return Products
	 * @throws PayPalRESTException
	 */
	public static SubscriptionPlans getAll(APIContext apiContext) throws PayPalRESTException {
		return getAll(apiContext, null);
	}

	/**
	 * Lists some or all merchant Products. Filters the response by any specified optional query string parameters.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @param options
	 * {@link Map} of query parameters. Allowed options: page, page_size, total_count_required.
	 * @return Products
	 * @throws PayPalRESTException
	 */
	public static SubscriptionPlans getAll(APIContext apiContext, Map<String, String> options)
			throws PayPalRESTException {
		String pattern = "v1/billing/plans";
		String resourcePath = RESTUtil.formatURIPath(pattern, null, options);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, SubscriptionPlans.class);
	}

	/**
	 * Gets the details for a specified SubscriptionPlan, by ID.
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 * @param accessToken
	 * Access Token used for the API call.
	 * @param ProductId
	 * String
	 * @return SubscriptionPlan
	 * @throws PayPalRESTException
	 */
	public static SubscriptionPlan get(String accessToken, String ProductId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, ProductId);
	}

	/**
	 * Gets the details for a specified SubscriptionPlan, by ID.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @param ProductId
	 * String
	 * @return SubscriptionPlan
	 * @throws PayPalRESTException
	 */
	public static SubscriptionPlan get(APIContext apiContext, String ProductId) throws PayPalRESTException {
		if (ProductId == null) {
			throw new IllegalArgumentException("ProductId cannot be null");
		}
		Object[] parameters = new Object[] { ProductId };
		String pattern = "v1/invoicing/Products/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, SubscriptionPlan.class);
	}
}
