package com.muhammet.jpa.exception;

import lombok.Getter;

@Getter
public class JavaBoostHs2Exception extends RuntimeException{
    private ErrorType errorType;
    public JavaBoostHs2Exception(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

}
