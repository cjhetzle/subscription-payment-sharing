package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class SubscriberRequest extends PayPalModel {

	private PayerName name;
	
	private String emailAddress;
	
	private String payerId;
	
	private ShippingDetail shippingAddress;
	
	private PaymentSource paymentSource;

	/**
	 * @param name the name to set
	 */
	public SubscriberRequest setName(PayerName name) {
		this.name = name;
		return this;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public SubscriberRequest setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

	/**
	 * @param payerId the payerId to set
	 */
	public SubscriberRequest setPayerId(String payerId) {
		this.payerId = payerId;
		return this;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public SubscriberRequest setShippingAddress(ShippingDetail shippingAddress) {
		this.shippingAddress = shippingAddress;
		return this;
	}

	/**
	 * @param paymentSource the paymentSource to set
	 */
	public SubscriberRequest setPaymentSource(PaymentSource paymentSource) {
		this.paymentSource = paymentSource;
		return this;
	}
}
