package com.paypal.api.payments;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class PaymentSource {
	
	private Card card;

	/**
	 * @param card the card to set
	 */
	public PaymentSource setCard(Card card) {
		this.card = card;
		return this;
	}
}
