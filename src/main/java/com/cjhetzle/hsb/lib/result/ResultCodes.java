package com.cjhetzle.hsb.lib.result;

import lombok.Getter;

@Getter
public enum ResultCodes {

    SUCCESS("SUCCESS", 3), ERROR("ERROR", 0), WARNING("WARNING", 1);

    private String result;

    private int level;

    private ResultCodes(String result, int level) {
        this.result = result;
        this.level = level;
    }
}
