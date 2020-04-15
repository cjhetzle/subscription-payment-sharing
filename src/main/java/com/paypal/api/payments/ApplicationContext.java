package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class ApplicationContext extends PayPalModel {

	private String brandName;

	private String locale;

	private String shippingPreference;

	private String userAction;

	private PaymentMethod paymentMethod;

	private String returnUrl;

	private String cancelUrl;

	/**
	 * @param brandName the brandName to set
	 */
	public ApplicationContext setBrandName(String brandName) {
		this.brandName = brandName;
		return this;
	}

	/**
	 * @param locale the locale to set
	 */
	public ApplicationContext setLocale(String locale) {
		this.locale = locale;
		return this;
	}

	/**
	 * @param shippingPreference the shippingPreference to set
	 */
	public ApplicationContext setShippingPreference(String shippingPreference) {
		this.shippingPreference = shippingPreference;
		return this;
	}

	/**
	 * @param userAction the userAction to set
	 */
	public ApplicationContext setUserAction(String userAction) {
		this.userAction = userAction;
		return this;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public ApplicationContext setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}

	/**
	 * @param returnUrl the returnUrl to set
	 */
	public ApplicationContext setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}

	/**
	 * @param cancelUrl the cancelUrl to set
	 */
	public ApplicationContext setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
		return this;
	}
}
