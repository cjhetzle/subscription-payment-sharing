package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

@Getter
public class BillingCycle extends PayPalModel {

	private PricingScheme pricingScheme;

	private Frequency frequency;

	private String tenureType;

	private Integer sequence;

	private Integer totalCycles;

	/**
	 * @param pricingScheme the pricingScheme to set
	 */
	public BillingCycle setPricingScheme(PricingScheme pricingScheme) {
		this.pricingScheme = pricingScheme;
		return this;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public BillingCycle setFrequency(Frequency frequency) {
		this.frequency = frequency;
		return this;
	}

	/**
	 * @param tenureType the tenureType to set
	 */
	public BillingCycle setTenureType(String tenureType) {
		this.tenureType = tenureType;
		return this;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public BillingCycle setSequence(Integer sequence) {
		this.sequence = sequence;
		return this;
	}

	/**
	 * @param totalCycles the totalCycles to set
	 */
	public BillingCycle setTotalCycles(Integer totalCycles) {
		this.totalCycles = totalCycles;
		return this;
	}

}
