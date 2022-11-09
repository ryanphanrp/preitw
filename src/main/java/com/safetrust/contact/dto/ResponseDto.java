package com.safetrust.contact.dto;

import com.safetrust.contact.constant.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseDto<T> {

    private int code;
    private String message;
    private T body;

    public ResponseDto(ResponseCode resCode, T body) {
        this.body = body;
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public ResponseDto(ResponseCode resCode) {
        this.message = resCode.getMessage();
        this.code = resCode.getCode();
    }

    public static<T> ResponseDto<T> ok(T data) {
        return new ResponseDto<T>(ResponseCode.OK, data);
    }

    public static<T> ResponseDto<T> ok() {
        return new ResponseDto<T>(ResponseCode.OK);
    }
}

