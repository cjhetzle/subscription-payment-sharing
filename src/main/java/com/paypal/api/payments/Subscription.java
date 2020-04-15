package com.paypal.api.payments;

import java.util.Map;

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
public class Subscription extends PayPalResource {

	private String id;

	private String planId;

	private String startTime;

	private String status;

	private String statusUpdateTime;

	private String createTime;

	private String quantity;

	private Money shippingAmount;

	private SubscriberRequest subscriber;

	private Boolean autoRenewal;

	private ApplicationContext applicationContext;

	public Subscription setId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * @param planId the planId to set
	 */
	public Subscription setPlanId(String planId) {
		this.planId = planId;
		return this;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public Subscription setStartTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public Subscription setQuantity(String quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * @param shippingAmount the shippingAmount to set
	 */
	public Subscription setShippingAmount(Money shippingAmount) {
		this.shippingAmount = shippingAmount;
		return this;
	}

	/**
	 * @param subscriber the subscriber to set
	 */
	public Subscription setSubscriber(SubscriberRequest subscriber) {
		this.subscriber = subscriber;
		return this;
	}

	/**
	 * @param autoRenewal the autoRenewal to set
	 */
	public Subscription setAutoRenewal(Boolean autoRenewal) {
		this.autoRenewal = autoRenewal;
		return this;
	}

	/**
	 * @param applicationContext the applicationContext to set
	 */
	public Subscription setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		return this;
	}

	/**
	 * Creates an Subscription. Include Subscription details including merchant information in the request.
	 * @deprecated Please use {@link #create(APIContext)} instead.
	 * @param accessToken
	 * Access Token used for the API call.
	 * @return Subscription
	 * @throws PayPalRESTException
	 */
	public Subscription create(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return create(apiContext);
	}

	/**
	 * Creates an Subscription. Include Subscription details including merchant information in the request.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @return Subscription
	 * @throws PayPalRESTException
	 */
	public Subscription create(APIContext apiContext) throws PayPalRESTException {
		String resourcePath = "v1/billing/subscriptions";
		String payLoad = this.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Subscription.class);
	}

	/**
	 * Gets the details for a specified Subscription, by ID.
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 * @param accessToken
	 * Access Token used for the API call.
	 * @param ProductId
	 * String
	 * @return Subscription
	 * @throws PayPalRESTException
	 */
	public static Subscription get(String accessToken, String ProductId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, ProductId);
	}

	/**
	 * Gets the details for a specified Subscription, by ID.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @param ProductId
	 * String
	 * @return Subscription
	 * @throws PayPalRESTException
	 */
	public static Subscription get(APIContext apiContext, String ProductId) throws PayPalRESTException {
		if (ProductId == null) {
			throw new IllegalArgumentException("ProductId cannot be null");
		}
		Object[] parameters = new Object[] { ProductId };
		String pattern = "v1/billing/subscriptions/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Subscription.class);
	}

	/**
	 * @param status the status to set
	 */
	public Subscription setStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * @param statusUpdateTime the statusUpdateTime to set
	 */
	public Subscription setStatusUpdateTime(String statusUpdateTime) {
		this.statusUpdateTime = statusUpdateTime;
		return this;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public Subscription setCreateTime(String createTime) {
		this.createTime = createTime;
		return this;
	}
}
