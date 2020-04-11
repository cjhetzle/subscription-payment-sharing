package com.paypal.api.payments;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class ShippingDetailName {

	private String fullName;

	/**
	 * @param fullName the fullName to set
	 */
	public ShippingDetailName setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}
}
