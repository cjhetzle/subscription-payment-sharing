package com.cjhetzle.hsb.lib.exceptions;

public enum NetworkCodes {

    OPEN_CONNECTION("OPEN CONNECTION", "0x10"),
    CLOSED_CONNECTION("CLOSED CONNECTION", "0x11"),
    AUTO_COMMIT("AUTO COMMIT", "0x12");

    private String value;
    private String code;

    private NetworkCodes(String value, String code) {
        this.value = value;
        this.code = code;
    }

    public String toString() {
        return this.value + ": " + this.code;
    }

    public String getDescription() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }
}
