package com.retail.product.exception;

public class ErrorDetails {
    private String message;
    private String details;

    public ErrorDetails(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
