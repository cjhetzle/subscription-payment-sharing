package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class PricingScheme extends PayPalModel {

	private Integer version;
	
	private Money fixedPrice;
	
	private String createTime;
	
	private String updateTime;

	/**
	 * @param version the version to set
	 */
	public PricingScheme setVersion(Integer version) {
		this.version = version;
		return this;
	}

	/**
	 * @param fixedPrice the fixedPrice to set
	 */
	public PricingScheme setFixedPrice(Money fixedPrice) {
		this.fixedPrice = fixedPrice;
		return this;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public PricingScheme setCreateTime(String createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public PricingScheme setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
		return this;
	}
	
}
