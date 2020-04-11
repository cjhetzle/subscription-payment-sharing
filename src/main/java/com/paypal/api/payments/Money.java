package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class Money extends PayPalModel {

	private String currencyCode;
	
	private String value;

	/**
	 * @param currencyCode the currencyCode to set
	 */
	public Money setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	/**
	 * @param value the value to set
	 */
	public Money setValue(String value) {
		this.value = value;
		return this;
	}
	
}
