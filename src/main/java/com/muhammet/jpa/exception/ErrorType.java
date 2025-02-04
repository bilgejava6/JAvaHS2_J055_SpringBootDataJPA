package com.muhammet.jpa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;
@Getter
@AllArgsConstructor
public enum ErrorType {

    ZERO_NUMBER_ERROR(4001, "Girilen sayısal değerlerin ikiside sıfır olamaz",BAD_REQUEST),
    BADREQUEST(4002, "Girilen parametereler hatalıdır.",BAD_REQUEST),
    INTERNAL_SERVER(5000, "Sunucuda beklenmeyen bir hata",INTERNAL_SERVER_ERROR);

    int code;
    String message;
    HttpStatus httpStatus;

}
