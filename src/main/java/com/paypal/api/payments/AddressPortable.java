package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class AddressPortable extends PayPalModel {

	private String addressLine1;

	private String addressLine2;

	private String addressLine3;

	private String adminArea4;

	private String adminArea3;

	private String adminArea2;

	private String adminArea1;

	private String postalCode;

	private String countryCode;

	private AddressDetails addressDetails;

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public AddressPortable setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public AddressPortable setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	/**
	 * @param addressLine3 the addressLine3 to set
	 */
	public AddressPortable setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
		return this;
	}

	/**
	 * @param adminArea4 the adminArea4 to set
	 */
	public AddressPortable setAdminArea4(String adminArea4) {
		this.adminArea4 = adminArea4;
		return this;
	}

	/**
	 * @param adminArea3 the adminArea3 to set
	 */
	public AddressPortable setAdminArea3(String adminArea3) {
		this.adminArea3 = adminArea3;
		return this;
	}

	/**
	 * @param adminArea2 the adminArea2 to set
	 */
	public AddressPortable setAdminArea2(String adminArea2) {
		this.adminArea2 = adminArea2;
		return this;
	}

	/**
	 * @param adminArea1 the adminArea1 to set
	 */
	public AddressPortable setAdminArea1(String adminArea1) {
		this.adminArea1 = adminArea1;
		return this;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public AddressPortable setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public AddressPortable setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	/**
	 * @param addressDetails the addressDetails to set
	 */
	public AddressPortable setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
		return this;
	}
}
