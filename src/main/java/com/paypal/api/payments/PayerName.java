package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class PayerName extends PayPalModel {

	private String givenName;

	private String surname;

	/**
	 * @param givenName the givenName to set
	 */
	public PayerName setGivenName(String givenName) {
		this.givenName = givenName;
		return this;
	}

	/**
	 * @param surname the surname to set
	 */
	public PayerName setSurname(String surname) {
		this.surname = surname;
		return this;
	}
}
