package com.wuke.exception;

/**
 * 自定义异常
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;

    private final String message;

    public CustomException(String message) {
        this.message = message;
    }

    public CustomException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
