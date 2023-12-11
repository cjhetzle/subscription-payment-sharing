package com.cjhetzle.hsb.lib.common;

/**
 * Programmed list of Named
 * services. This will be a
 * text file eventually.
 * 
 * @author Cameron Hetzler
 *
 */
public enum Services {

    NETFLIX("netflix"), SPOTIFY("spotify"), NINTENDO_ONLINE("nintendo_online"),
    CRUNCHYROLL("crunchyroll");

    private String value;

    private Services(String value) {
        this.value = value;
        Constants.SupportedServices.add(this);
    }

    public String toString() {
        return value.toLowerCase();
    }
}
