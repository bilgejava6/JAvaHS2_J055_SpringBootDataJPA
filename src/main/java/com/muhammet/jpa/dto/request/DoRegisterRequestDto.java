package com.muhammet.jpa.dto.request;

public record DoRegisterRequestDto(
        String userName,
        String password,
        String rePassword) {

}
