package com.cjhetzle.hsb.lib.result;

import com.cjhetzle.hsb.lib.exceptions.ErrorCodes;
import com.cjhetzle.hsb.lib.exceptions.ServicesException;
import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * this is a summary.
 * 
 * @author Cameron Hetzler
 */
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @Getter
    @Setter
    private String message;

    @Getter
    private ResultCodes resultCode;

    @Getter
    @Setter
    private ErrorCodes errorCode;

    @Getter
    private Throwable throwable;

    @Getter
    private AbstractList<String> details;

    @Getter
    private AbstractList<Result> results;

    @Getter
    @Setter
    private Object payload;

    public boolean isError() {
        return this.getResultCode() == ResultCodes.ERROR ? true : false;
    }

    public void setThrowable(Throwable value) {
        if (throwable != null || value == null) {
            return;
        }
        if (value instanceof ServicesException) {
            errorCode = ((ServicesException) value).getErrorCode();
        }
        if (resultCode == null
                || ResultCodes.ERROR.getLevel() < resultCode.getLevel()) {
            resultCode = ResultCodes.ERROR;
        }
        throwable = value;
    }

    public void success() {
        this.setResultCode(ResultCodes.SUCCESS);
    }

    public void error() {
        this.setResultCode(ResultCodes.ERROR);
    }

    public void warning() {
        this.setResultCode(ResultCodes.WARNING);
    }

    public void setResultCode(ResultCodes value) {
        if (resultCode == null
                || value != null && value.getLevel() < resultCode.getLevel()) {
            resultCode = value;
        }
    }

    public Result(String value) {
        this.message = value;
    }

    public void append(String value) {
        if (details == null) {
            details = new LinkedList<String>();
        }
        details.add(value);
    }

    public void append(Collection<String> values) {
        if (details == null) {
            details = new LinkedList<String>();
        }
        details.addAll(values);
    }

    /**
     * Append a result to the result. We need to check
     * the child result for a non ignorable code first.
     * 
     * @param value Result to append
     */
    public void append(Result value) {
        if (resultCode == null || value.getResultCode() != null
                && value.getResultCode().getLevel() < resultCode.getLevel()) {
            resultCode = value.getResultCode();
        }
        if (results == null) {
            results = new LinkedList<Result>();
        }
        results.add(value);
    }

    public String toStringSimpler() {
        StringBuilder strBldr = new StringBuilder();

        strBldr.append("Result(");

        strBldr.append("message=" + String.valueOf(message));

        strBldr.append("details=" + String.valueOf(details));

        strBldr.append("resultCode=" + String.valueOf(resultCode));

        strBldr.append("errorCode=" + String.valueOf(errorCode));

        strBldr.append("throwable=" + String.valueOf(throwable));

        strBldr.append(")");

        return strBldr.toString();
    }

    public String toString() {
        return this.toString("");
    }

    private String toString(String appendFormat) {
        StringBuilder strBldr = new StringBuilder();

        strBldr.append("Result(\n");

        strBldr.append(
                appendFormat + "\tmessage=" + String.valueOf(message) + "\n");

        strBldr.append(
                appendFormat + "\tdetails=" + String.valueOf(details) + "\n");

        strBldr.append(appendFormat + "\tresultCode="
                + String.valueOf(resultCode) + "\n");

        strBldr.append(appendFormat + "\terrorCode=" + String.valueOf(errorCode)
                + "\n");

        strBldr.append(appendFormat + "\tthrowable=" + String.valueOf(throwable)
                + "\n");

        if (results != null) {
            strBldr.append(appendFormat + "\t{ ");
            for (Result result : results) {
                strBldr.append(result.toString(appendFormat + "\t"));
                strBldr.append(appendFormat + "\t,");
            }
            strBldr.append(" }");
        }

        strBldr.append(appendFormat + ")\n");

        return strBldr.toString();
    }
}
