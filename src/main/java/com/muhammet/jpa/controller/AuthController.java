package com.muhammet.jpa.controller;

import com.muhammet.jpa.dto.request.DoRegisterRequestDto;
import com.muhammet.jpa.dto.response.BaseResponse;
import com.muhammet.jpa.entity.Auth;
import com.muhammet.jpa.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.muhammet.jpa.config.RestApis.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService authService;

    @PostMapping(DO_REGISTER)
    public ResponseEntity<BaseResponse<Auth>> doRegister(@RequestBody DoRegisterRequestDto dto){
        Auth auth = authService.doRegister(dto);
        return ResponseEntity.ok(BaseResponse.<Auth>builder()
                        .code(1101)
                        .isSuccess(true)
                        .message("Kullanıcı başarı ile kayıt edildi.")
                        .data(auth)
                .build());
    }


}
