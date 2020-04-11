package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class PaymentMethod extends PayPalModel {

	private String payerSelected;
	
	private String payeePreferred;
	
	private String category;

	/**
	 * @param payerSelected the payerSelected to set
	 */
	public PaymentMethod setPayerSelected(String payerSelected) {
		this.payerSelected = payerSelected;
		return this;
	}

	/**
	 * @param payeePreferred the payeePreferred to set
	 */
	public PaymentMethod setPayeePreferred(String payeePreferred) {
		this.payeePreferred = payeePreferred;
		return this;
	}

	/**
	 * @param category the category to set
	 */
	public PaymentMethod setCategory(String category) {
		this.category = category;
		return this;
	}
}
