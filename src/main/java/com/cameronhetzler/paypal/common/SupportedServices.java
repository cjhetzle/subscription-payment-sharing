package com.cameronhetzler.paypal.common;

import lombok.Getter;

public enum SupportedServices {

	NETFLIX("netflix"),
	SPOTIFY("spotify"),
	NINTENDO_ONLINE("nintendo_online"),
	CRUNCHYROLL("crunchyroll");
	
	@Getter
	private String value;
	
	private SupportedServices(String value) {
		this.value = value;
	}
}
