package com.safetrust.contact.exception;

import com.safetrust.contact.constant.ResponseCode;
import com.safetrust.contact.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class GlobalAppExceptionHandler {

    @ExceptionHandler({GlobalAppException.class})
    @ResponseStatus(HttpStatus.GONE)
    public ResponseDto<?> globalAppHandler(HttpServletRequest req, GlobalAppException exp) {
        log.error(exp.getMessage());
        return new ResponseDto<>(exp.getCode());
    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> handleBindException(BindException ex) {
        final FieldError fieldError = ex.getFieldError();
        if (Objects.nonNull(fieldError)) {
            log.error(fieldError.getDefaultMessage());
            return new ResponseDto<>(ResponseCode.BAD_REQUEST, fieldError.getDefaultMessage());
        }
        return new ResponseDto<>(ResponseCode.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto<?> handleUncaughtException(Exception ex) {
        ex.printStackTrace();
        log.error(ex.getMessage());
        return new ResponseDto<>(ResponseCode.INTERNAL_ERROR, ex.getMessage());
    }

}

