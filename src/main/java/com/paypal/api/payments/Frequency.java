package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class Frequency extends PayPalModel {

	private String intervalUnit;
	
	private String intervalCount;

	/**
	 * @param intervalUnit the intervalUnit to set
	 */
	public Frequency setIntervalUnit(String intervalUnit) {
		this.intervalUnit = intervalUnit;
		return this;
	}

	/**
	 * @param intervalCount the intervalCount to set
	 */
	public Frequency setIntervalCount(String intervalCount) {
		this.intervalCount = intervalCount;
		return this;
	}
}
