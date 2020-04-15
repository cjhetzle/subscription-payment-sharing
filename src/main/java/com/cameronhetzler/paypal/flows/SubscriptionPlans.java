package com.cameronhetzler.paypal.flows;

import java.util.List;

import com.paypal.api.payments.SubscriptionPlan;
import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class SubscriptionPlans extends PayPalModel {

	private Integer totalItems;

	private Integer totalPages;

	private List<SubscriptionPlan> plans;

	/**
	 * @param totalItems the totalItems to set
	 */
	public SubscriptionPlans setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
		return this;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public SubscriptionPlans setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
		return this;
	}

	/**
	 * @param plans the plans to set
	 */
	public SubscriptionPlans setPlans(List<SubscriptionPlan> plans) {
		this.plans = plans;
		return this;
	}
}
