package com.paypal.api.payments;

import com.paypal.base.rest.PayPalResource;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class Subscription extends PayPalResource {

	private String planId;
	
	private String startTime;
	
	private String quantity;
	
	private Money shippingAmount;
	
	private SubscriberRequest subscriber;
	
	private Boolean autoRenewal;
	
	private ApplicationContext applicationContext;

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
}
