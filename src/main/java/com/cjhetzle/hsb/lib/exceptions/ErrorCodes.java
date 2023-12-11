package com.cjhetzle.hsb.lib.exceptions;

/**
 * summary.
 * 
 * @author Cameron Hetzler
 *
 */
public enum ErrorCodes {

    EXAMPLE("EXAMPLE", "0x0"), BASIC_ERROR("BASIC_ERROR", "0x1"),
    FILE_READ("FILE_READ", "0x2"), FILE_WRITE("FILE_WRITE", "0x3"),
    TO_JSON("TO_JSON", "0x4"), FROM_JSON("FROM_JSON", "0x5"),
    NULL_RETURN("NULL_RETURN", "0x6"), MISSING_PARAM("MISSING_PARAM", "0x7");

    private String value;
    private String code;

    private ErrorCodes(String value, String code) {
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
