package com.safetrust.contact.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    OK(200, "Ok"),
    CREATED(201, "Created"),
    BAD_REQUEST(-400, "Bad request"),
    UNAUTHORIZED(-401, "Unauthorized"),
    NOT_FOUND(-404, "Not found"),
    INTERNAL_ERROR(-500, "Internal error"),
    ACCESS_DENIED(-503, "Access denied"),
    UNSUPPORTED_OP(-600, "Unsupported operation"),
    INVALID_OP(-601, "Invalid operation"),

    EXISTED_CONTACT(-409, "Contact has been existed"),
    NOT_FOUND_CONTACT(-404, "Contact not found");

    private final int code;
    private final String message;
}


