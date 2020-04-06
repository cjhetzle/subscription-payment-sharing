package com.cameronhetzler.paypal.payload;

import lombok.Getter;
import lombok.ToString;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
@ToString
public enum Classifications {

	EXAMPLE("EXAMPLE");
	
	private String classification;
	
	private Classifications(String classification) {
		this.classification = classification;
	}
}
