package com.cameronhetzler.paypal.common;

public enum SupportedServices {

	NETFLIX("netflix"),
	SPOTIFY("spotify"),
	NINTENDO_ONLINE("nintendo_online"),
	CRUNCHYROLL("crunchyroll");
	
	private String value;
	
	private SupportedServices(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value.toLowerCase();
	}
}
