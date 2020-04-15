package com.paypal.api.payments;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class AddressDetails {

	private String streetNumber;

	private String streetName;

	private String streetType;

	private String deliveryService;

	private String buildingName;

	private String subBuilding;

	/**
	 * @param streetNumber the streetNumber to set
	 */
	public AddressDetails setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
		return this;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public AddressDetails setStreetName(String streetName) {
		this.streetName = streetName;
		return this;
	}

	/**
	 * @param streetType the streetType to set
	 */
	public AddressDetails setStreetType(String streetType) {
		this.streetType = streetType;
		return this;
	}

	/**
	 * @param deliveryService the deliveryService to set
	 */
	public AddressDetails setDeliveryService(String deliveryService) {
		this.deliveryService = deliveryService;
		return this;
	}

	/**
	 * @param buildingName the buildingName to set
	 */
	public AddressDetails setBuildingName(String buildingName) {
		this.buildingName = buildingName;
		return this;
	}

	/**
	 * @param subBuilding the subBuilding to set
	 */
	public AddressDetails setSubBuilding(String subBuilding) {
		this.subBuilding = subBuilding;
		return this;
	}
}
