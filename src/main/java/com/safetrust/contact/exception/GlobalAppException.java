package com.safetrust.contact.exception;

import com.safetrust.contact.constant.ResponseCode;
import lombok.Getter;

@Getter
public class GlobalAppException extends RuntimeException {
    private final ResponseCode code;

    public GlobalAppException(ResponseCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public GlobalAppException(String message) {
        super(message);
        this.code = ResponseCode.INTERNAL_ERROR;
    }
}

