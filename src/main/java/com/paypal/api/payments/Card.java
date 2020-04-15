package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class Card extends PayPalModel {

	private String name;

	private String number;

	private String expiry;

	private String securityCode;

	private AddressPortable billingAddress;

	/**
	 * @param name the name to set
	 */
	public Card setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @param number the number to set
	 */
	public Card setNumber(String number) {
		this.number = number;
		return this;
	}

	/**
	 * @param expiry the expiry to set
	 */
	public Card setExpiry(String expiry) {
		this.expiry = expiry;
		return this;
	}

	/**
	 * @param securityCode the securityCode to set
	 */
	public Card setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
		return this;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public Card setBillingAddress(AddressPortable billingAddress) {
		this.billingAddress = billingAddress;
		return this;
	}
}
