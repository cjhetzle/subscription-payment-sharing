package com.paypal.api.products;

import java.util.List;

import com.paypal.base.rest.PayPalModel;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class Products extends PayPalModel {

	private Integer totalItems;

	private Integer totalPages;

	private List<Product> items;

	/**
	 * @param totalItems the totalItems to set
	 */
	public Products setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
		return this;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public Products setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
		return this;
	}

	/**
	 * @param items the items to set
	 */
	public Products setItems(List<Product> items) {
		this.items = items;
		return this;
	}
}
