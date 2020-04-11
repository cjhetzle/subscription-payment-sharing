package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class ShippingDetail extends PayPalModel {

	private ShippingDetailName name;
	
	private AddressPortable address;

	/**
	 * @param name the name to set
	 */
	public ShippingDetail setName(ShippingDetailName name) {
		this.name = name;
		return this;
	}

	/**
	 * @param address the address to set
	 */
	public ShippingDetail setAddress(AddressPortable address) {
		this.address = address;
		return this;
	}
}
