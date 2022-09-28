package com.example.felix_backend.common;

public class FelixException extends RuntimeException {

    private static final long serialVersionUID = 3638887403429291292L;

    public static final String WARNING_CODE = "1000";

    private final String code;

    public FelixException(String msg) {
        super(msg);
        this.code = FelixException.WARNING_CODE;
    }

    public FelixException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
