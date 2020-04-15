package com.paypal.api.payments;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class PaymentPreferences {

	private Boolean autoBillOutstanding;

	private Money setupFee;

	private String setupFeeFailureAction;

	private Integer paymentFailureThreshold;

	/**
	 * @param autoBillOutstanding the autoBillOutstanding to set
	 */
	public PaymentPreferences setAutoBillOutstanding(Boolean autoBillOutstanding) {
		this.autoBillOutstanding = autoBillOutstanding;
		return this;
	}

	/**
	 * @param setupFee the setupFee to set
	 */
	public PaymentPreferences setSetupFee(Money setupFee) {
		this.setupFee = setupFee;
		return this;
	}

	/**
	 * @param setupFeeFailureAction the setupFeeFailureAction to set
	 */
	public PaymentPreferences setSetupFeeFailureAction(String setupFeeFailureAction) {
		this.setupFeeFailureAction = setupFeeFailureAction;
		return this;
	}

	/**
	 * @param paymentFailureThreshold the paymentFailureThreshold to set
	 */
	public PaymentPreferences setPaymentFailureThreshold(Integer paymentFailureThreshold) {
		this.paymentFailureThreshold = paymentFailureThreshold;
		return this;
	}
}
